pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean'
            }
        }
    }
    post {
            always {
                echo 'This will always run'
            }
        }
}