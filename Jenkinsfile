pipeline {
   agent any
    stages {
        stage('Build') {
            steps {
                sh '''
                pwd
                echo 'Building..'
                ls
                docker run --rm -v "$(pwd)":/opt/maven -w /opt/maven maven:3.3.9-jdk-8 mvn clean install
                '''
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
