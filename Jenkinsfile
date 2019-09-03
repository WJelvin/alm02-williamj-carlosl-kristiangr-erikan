pipeline{
    agent any
    parameters{
            choice(name: 'DEPLOY_ENV',choices:['INT','STAGE','PROD','TEST'], description: 'The enviroment that the artefact will be deployed to')
            }
            stages{
                stage('Building project, running tests and and publishing results'){
                agent { docker { image 'maven:3.3.3' }}
            }

}

pipeline {
    agent any
    parameters {
        choice(name: 'DEPLOY_ENV', choices: ['INT', 'STAGE', 'PROD'],  description: 'The target environment to deploy artifacts')
    }
    stages {
        stage('Building project, running tests and publishing test results') {
            agent {
                docker{ { image 'maven:3.3.3' }}
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
                sh 'asadmin --port 4848 deploy --force --name fortuneTeller-${DEPLOY_ENV} --contextroot calculator-${DEPLOY_ENV} target/calc-jsf-1.0.war'
            }
        }
    }
}
