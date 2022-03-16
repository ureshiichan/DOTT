pipeline {
   agent any
   
    environment {
       SCANNER_HOME = tool 'sqs'
    }
    stages {
       
     stage('Test') {
            steps {
               withMaven(maven:'maven-latest') {
                   script{
                       try{
                           sh '''
                            cd cidr_convert_api 
                            cd java
                            cd cidr-api 
                            echo "【Ｔｅｓｔ】"
                            mvn test
                            pwd
                            '''
                       }catch (Exception e) {
                    echo 'Error happened in testing. ERROR: ' + e.toString()
                    }
                   }
                   
               }
            }
        }
       
       
        stage('Build') {
           
            steps {
               sh "【B】【u】【i】【l】【d】"
               sh ''' chmod +x cidr_convert_api/java/build.sh '''
                withMaven(maven:'maven-latest') {
                sh '''cidr_convert_api/java/build.sh '''
                }
            }
        }

         
       
       
        stage("SonarQube analysis") {
            steps {
                echo '✩░▒▓▆▅▃▂▁𝐒𝐂𝐀𝐍𝐍𝐄𝐑▁▂▃▅▆▓▒░✩'
               withSonarQubeEnv('sq1'){
               withMaven(maven:'maven-latest') {
                   sh '''
                   cd cidr_convert_api 
                   cd java
                   cd cidr-api 
                   mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=ureshiichan_DOTT
                   '''
                }
               }
             }
          }
 

        
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
