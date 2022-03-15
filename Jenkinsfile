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
                sdh ''' sudo chmod +x cidr_convert_api/java/build.sh '''   
                sh ''' sudo cidr_convert_api/java/build.sh '''
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
