pipeline {
   agent any
    stages {
        stage('Build') {
            withMaven(maven: 'mvn') {
            sh "mvn clean package"
        }
            steps {
                sh '''
                pwd
                echo 'Building..'
                ls
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
