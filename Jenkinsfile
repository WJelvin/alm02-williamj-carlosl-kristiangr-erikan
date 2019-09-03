pipeline {
    agent any
    parameters {
        choice(name: 'DEPLOY_ENV', choices: ['int', 'stage', 'prod'],  description: 'The target environment to deploy artifacts')
    }
    stages {       
        stage('Building project, running tests and publishing test results') {
            agent { 
                docker{ image 'rasilva1986/java-maven.:alm'}
            }   
            steps {
                sh 'mvn clean install test'
            }
            post {
                always {            
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([
                    allowMissing          : false,
                    alwaysLinkToLastBuild : false,
                    keepAll               : true,
                    reportDir             : 'target/site/jacoco/',
                    reportFiles           : 'index.html',
                    reportTitles          : "Tests coverage",
                    reportName            : "Tests coverage"
                    ])
                }
                success {
                    archive "target/ALM02-1.0-SNAPSHOT.war"
                }
            } 
        }         
       
        stage('Deploying artifacts to selected target'){
            agent any
            steps{
                sh 'export PATH=/opt/glassfish-4.1.1/bin/asadmin:$PATH'
                sh 'asadmin --port 4848 deploy --force --name ALM02-1.0-SNAPSHOT-${DEPLOY_ENV} --contextroot ALM02-1.0-SNAPSHOT-${DEPLOY_ENV} target/ALM02-1.0-SNAPSHOT.war'
            }
        } 
    }
}
