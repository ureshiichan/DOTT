pipeline {
   agent any
    stages {
        stage('Build') {
           
            steps {
                sh '''
                pwd
                echo 'Building..'
                ls
                '''
                withMaven(maven:'maven-latest') {
                sh "mvn --version"
                }
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
