pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-token',
                    url: 'https://github.com/github.com/parker0509/reservationPoc'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew clean build -x test'
            }
        }
    }
}