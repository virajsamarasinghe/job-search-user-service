pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'job-search-user-service-user-service'
        DOCKER_REGISTRY = 'docker.io'  // Adjust if you're using a private registry
        DOCKER_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git branch: 'main', url: 'https://github.com/yourusername/job-search-user-service.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image for the user-service
                    docker.build(DOCKER_IMAGE_NAME, '-f Dockerfile .')
                }
            }
        }

        stage('Run Docker Compose') {
            steps {
                script {
                    // Run docker-compose to start the containers
                    sh 'docker-compose -f docker-compose.yml up -d --build'
                }
            }
        }

        stage('Push Docker Image to Registry') {
            steps {
                script {
                    // Push the image to Docker Hub or another Docker registry
                    docker.withRegistry("https://${DOCKER_REGISTRY}", 'dockerhub-credentials') {
                        docker.image(DOCKER_IMAGE_NAME).push(DOCKER_TAG)
                    }
                }
            }
        }

        stage('Deploy Application') {
            steps {
                script {
                    // Optional: Deploy your application to a remote server
                    // Example: SSH into your server and restart Docker containers
                    sh 'ssh user@yourserver "docker-compose -f /path/to/docker-compose.yml down && docker-compose -f /path/to/docker-compose.yml up -d"'
                }
            }
        }
    }

    post {
        always {
            // Clean up Docker containers after the build
            sh 'docker-compose down'
        }

        success {
            // Notify on success
            echo 'Pipeline executed successfully.'
        }

        failure {
            // Notify on failure
            echo 'Pipeline failed.'
        }
    }
}
