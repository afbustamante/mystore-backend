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
                        configFileProvider([configFile(fileId: '8d47e8c5-f619-4f36-a1dc-590dca78adb1', variable: 'SONAR_CONFIG')]) {
                            // some block
                            def props = readProperties file: "${SONAR_CONFIG}"
                            sh "sh mvnw sonar:sonar -Dsonar.host.url=${props['sonar.host.url']} -Dsonar.token=${props['sonar.login']} -Dsonar.organization=${props['sonar.organization']}"
                        }
                    } else {
                        echo 'Skipped Sonar analysis'
                    }
                }
            }
        }
    }
}
