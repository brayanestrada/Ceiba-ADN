pipeline {
  agent {
    label 'Slave_Induccion'
  }

  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  tools {
    jdk 'JDK8_Centos'
    gradle 'Gradle5.6_Centos'
  }

  stages{
    stage('Checkout') {
      steps{
          echo "------------>Checkout<------------"
              checkout([
                  $class: 'GitSCM',
                  branches: [[name: '*/develop']],
                  doGenerateSubmoduleConfigurations: false,
                  extensions: [],
                  gitTool: 'Git_Centos',
                  submoduleCfg: [],
                  userRemoteConfigs: [[
                  credentialsId: 'GitHub_brayanestrada',
                  url:'https://github.com/brayanestrada/Ceiba-ADN'
              ]]
          ])
      }

    }

    stage('Compile & Unit Tests') {
       steps{
         echo "------------>Cleaning previous compilations<------------"
           sh 'gradle --b ./build.gradle clean'

           echo "------------>Unit Tests<------------"
           sh 'gradle --b ./build.gradle test jacocoTestReport'
       }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
            sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
       steps {
         echo "------------>Build<------------"
         sh 'gradle --b ./build.gradle build -x test'
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
      echo 'This will run only if failed'
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
