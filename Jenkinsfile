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
               sh ''' chmod +x cidr_convert_api/java/build.sh '''

               
                withMaven(maven:'maven-latest') {
                sh "mvn --version"
                sh '''cidr_convert_api/java/build.sh '''
                }
            }
        }

        stage("build & SonarQube analysis") {
            steps {
               withMaven(maven:'maven-latest') {
                withSonarQubeEnv(credentialsId: 'jenkins-sonar', installationName: 'sq1') {
                   sh '''
                   pwd
                   cd cidr_convert_api 
                   cd java
                   cd cidr-api 
                   pwd
                   ls
                   mvn clean package sonar:sonar
                   pwd
                   '''
                  }
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
