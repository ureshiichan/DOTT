pipeline {
    agent  {docker { image: 'maven.3.3.3' } }

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
