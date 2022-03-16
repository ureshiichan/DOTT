pipeline {
   agent any
   
    environment {
       SCANNER_HOME = tool 'sqs'
       dockerImage=""
       registry="samcelis/doot"
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
                sh '''
                 echo "【B】【u】【i】【l】【d】"
               '''
               sh ''' chmod +x cidr_convert_api/java/build.sh '''

               withMaven(maven:'maven-latest') {
                sh '''cidr_convert_api/java/build.sh '''
                }
            }
        }

         
       
       
        stage("SonarQube analysis") {
            steps {
               echo "✩░▒▓▆▅▃▂▁𝐒𝐜𝐚𝐧𝐧𝐞𝐫▁▂▃▅▆▓▒░✩"
               withSonarQubeEnv('sq1'){
               withMaven(maven:'maven-latest') {
                   sh '''
                   cd cidr_convert_api 
                   cd java
                   cd cidr-api 
                   mvn  org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=ureshiichan_DOTT
                   '''
                }
               }
             }
          }
 
        
        stage('Build docker image') {
             steps {
                    script{}
                           echo docker.build("${registry}","./cidr_convert_api/java/ ")
                           dockerImage = docker.build("${registry}","./cidr_convert_api/java/ ")
                        }
                    }
                }

        
        stage('Deploy') {
            steps {
                echo "deploy"
            }
        }
    }
}
