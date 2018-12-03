pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'echo "Hello World"'
            }
        }
    }
    post {
            always {
                echo 'This will always run'
            }
        }
}