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
               sh ''' sudo chmod +x cidr_convert_api/java/build.sh '''

               
                withMaven(maven:'maven-latest') {
                sh "mvn --version"
                sh ''' sudo cidr_convert_api/java/build.sh '''
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
