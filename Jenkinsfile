pipeline {
    agent none

    options {
        timeout(time: 30, unit: 'MINUTES')
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Prepare') {
            agent {
                docker {
                    image 'maven:3.9-ibm-semeru-17-noble'
                    args '-v $HOME/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                // Get code from GitHub repository
                echo 'Pulling branch ' + env.GIT_BRANCH
                sh 'mvn clean'
            }
        }
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9-ibm-semeru-17-noble'
                    args '-v $HOME/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                // Run the maven build
                sh 'mvn compile'
            }
        }
        stage('Test (UT)') {
            agent {
                docker {
                    image 'maven:3.9-ibm-semeru-17-noble'
                    args '-v $HOME/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                // Run the maven build with tests
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Test (IT)') {
            agent {
                docker {
                    image 'maven:3.9-ibm-semeru-17-noble'
                    args '-v $HOME/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                // Run the maven build with integration tests
                sh 'mvn verify'
            }
            post {
                always {
                    junit '**/target/failsafe-reports/TEST-*.xml'
                }
            }
        }
        stage('Report') {
            agent {
                docker {
                    image 'maven:3.9-ibm-semeru-17-noble'
                    args '-v $HOME/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                script {
                    sh 'mvn site'
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: '**/target/site/', fingerprint: true
                }
            }
        }
        stage('Analyze') {
            agent {
                docker {
                    image 'maven:3.9-ibm-semeru-17-noble'
                    args '-v $HOME/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                script {
                    if (env.BRANCH_NAME == 'develop') {
                        // Run the Sonar analysis
                        configFileProvider([configFile(fileId: '956e942f-6748-449d-9596-478833bd8202', variable: 'SONAR_CONFIG')]) {
                            def props = readProperties file: "${SONAR_CONFIG}"
                            sh "mvn sonar:sonar -P sonarcloud -Dsonar.token=${props['sonar.token']} -Dsonar.projectKey=${props['sonar.projectKey']}"
                        }
                    } else {
                        echo 'Skipped Sonar analysis'
                    }
                }
            }
        }
    }
}
