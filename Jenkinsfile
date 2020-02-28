pipeline {
    agent any
    tools {
        maven 'maven 3.3.9'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
    }
}
