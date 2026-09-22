pipeline {

    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test package'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t student-management:latest .'
            }
        }

        stage('Deploy') {
            steps {
                bat 'docker stop student-app || exit 0'
                bat 'docker rm student-app || exit 0'
                bat 'docker run -d --name student-app -p 8081:8080 student-management:latest'
            }
        }

    }

    post {

        success {
            echo 'CI/CD Pipeline completed successfully!'
        }

        failure {
            echo 'CI/CD Pipeline failed.'
        }
    }
}