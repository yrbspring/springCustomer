pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }
    agent any
    stages {
        stage('Build') {
            steps {
               echo 'This is a minimal pipeline.'
               sh 'mvn clean install'
            }
        }
    }
}