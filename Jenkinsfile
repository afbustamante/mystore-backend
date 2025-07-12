pipeline {
    agent {
        label 'jenkins-agent-1'
    }

    options {
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Prepare') {
            steps {
                // Get code from GitHub repository
                echo 'Pulling branch ' + env.GIT_BRANCH
                sh 'sh mvnw clean'
            }
        }
        stage('Build') {
            steps {
                // Run the maven build
                sh 'sh mvnw compile'
            }
        }
        stage('Test (UT)') {
            steps {
                // Run the maven build with tests
                sh 'sh mvnw test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Test (IT)') {
            steps {
                // Run the maven build with integration tests
                sh 'sh mvnw verify'
            }
            post {
                always {
                    junit '**/target/failsafe-reports/TEST-*.xml'
                }
            }
        }
        stage('Report') {
            steps {
                script {
                    sh 'sh mvnw site'
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: '**/target/site/', fingerprint: true
                }
            }
        }
        stage('Analyze') {
            steps {
                script {
                    if (env.BRANCH_NAME == 'develop') {
                        // Run the Sonar analysis
                        configFileProvider([configFile(fileId: '956e942f-6748-449d-9596-478833bd8202', variable: 'SONAR_CONFIG')]) {
                            def props = readProperties file: "${SONAR_CONFIG}"
                            sh "sh mvnw sonar:sonar -P sonarcloud -Dsonar.login=${props['sonar.token']} -Dsonar.projectKey=${props['sonar.projectKey']}"
                        }
                    } else {
                        echo 'Skipped Sonar analysis'
                    }
                }
            }
        }
    }
}
