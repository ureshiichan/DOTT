pipeline {
   agent any
   
    environment {
       SCANNER_HOME = tool 'sqs'
       dockerImage=""
       repository="samcelis/doot"
       dhCredential="dockerhub"
    }
    stages {
       
     stage('Test') {
            steps {
             echo "▛▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝ ▜"
             echo "                    ∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼ 𝗧𝗲𝘀𝘁 ᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
             echo "▙ ▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▟"
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
                echo "▛▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝ ▜"
                echo "                    ∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼ 𝒃𝒖𝒊𝒍𝒅 ᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
                echo "▙ ▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▟"
                sh ''' chmod +x cidr_convert_api/java/build.sh '''

               withMaven(maven:'maven-latest') {
                sh '''cidr_convert_api/java/build.sh '''
                }
            }
        }

         
       
       
        stage("SonarQube analysis") {
            steps {
               echo "▛▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝ ▜"
                echo "                    ∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼ 𝑺𝒄𝒂𝒏𝒏𝒆𝒓 ᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
                echo "▙ ▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▟"
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
                 echo "▛▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝ ▜"
                echo "              ∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼ 𝔹𝕦𝕝𝕕𝕚𝕟𝕘 𝕕𝕠𝕔𝕜𝕖𝕣 𝕚𝕞𝕒𝕘𝕖 ᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
                echo "▙ ▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▟"
                    script{
                           dockerImage = docker.build("${repository}","./cidr_convert_api/java/ ")
                        }
                    }
                }

              

        stage('Upload image') {
            steps {
                echo "▛▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝ ▜"
                echo "       ∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼ 𝑼𝒑𝒍𝒐𝒂𝒅𝒊𝒏𝒈 𝒊𝒎𝒂𝒈𝒆 𝒕𝒐 𝒅𝒐𝒄𝒌𝒆𝒓𝒉𝒖𝒃 ᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
                echo "▙ ▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▟"
                script{
                    docker.withRegistry('',dhCredential){
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Remove old container') {
        steps{
                echo "▛▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝ ▜"
                echo "     ∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼ 𝔹𝐑𝐞𝐦𝐨𝐯𝐞 𝐨𝐥𝐝 𝐜𝐨𝐧𝐭𝐚𝐢𝐧𝐞𝐫 ᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
                echo "▙ ▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▟"
            script {
                try{
                    sh 'docker rm -f api'
                }catch(Exception e){
                    echo e.toString()
                }
            }
        }
    }

        stage('Run Docker container') {
        steps{
                echo "▛▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝ ▜"
                echo "              ∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼ 𝐑𝐮𝐧 𝐃𝐨𝐜𝐤𝐞𝐫 𝐜𝐨𝐧𝐭𝐚𝐢𝐧𝐞𝐫 ᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
                echo "▙ ▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▟"
            script {
                sh 'docker images'
                dockerImage.run("-ti -p 8000:8000  --name api")
            }
        }
    }

       stage('Remove dangling image') {
        steps{
                echo "▛▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝▝ ▜"
                echo "          ∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼ 𝐑𝐞𝐦𝐨𝐯𝐞 𝐝𝐚𝐧𝐠𝐥𝐢𝐧𝐠 𝐢𝐦𝐚𝐠𝐞 ᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙"
                echo "▙ ▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▖▟"
            script {
                sh 'docker image prune -f'
                
            }
        }
    }


    }
}
