pipeline {
     agent none

    stages {
        stage('Build') {
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
