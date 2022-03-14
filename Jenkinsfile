pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                 withMaven {
                    sh "mvn clean verify"
                    }
                sh '''
                mvn --version
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
