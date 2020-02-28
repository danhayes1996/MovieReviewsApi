pipeline {
    agent any
    tools {
        maven 'maven 3.3.9'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install -DskipITs -DskipUTs'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
