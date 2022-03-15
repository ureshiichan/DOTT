pipeline {
   agent any
   
    environment {
       SCANNER_HOME = tool 'sqs'
    }
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
               withSonarQuebeEnv('sq1'){
               withMaven(maven:'maven-latest') {
                   sh '''
                   pwd
                   cd cidr_convert_api 
                   cd java
                   cd cidr-api 
                   pwd
                   ls
                   mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=ureshiichan_DOTT
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
