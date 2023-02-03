pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    stages {
        stage('mvn Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/Jaibw/apiservice.git'

                // Run Maven on a Unix agent.
                sh "mvn install -DskipTests=true"
            }

           
        }
        
        stage('docker Build') {
            steps {
                sh 'cp target/OnlineVotingSystem-0.0.1-SNAPSHOT.jar deploy/OnlineVotingSystem-0.0.1-SNAPSHOT.jar'
                sh "cd deploy && docker build -t jaibw/apidemo:${env.BUILD_NUMBER} ."
            }
        }
        
         stage('docker Verify') {
            steps {
                sh 'docker images'
            }
        }
        
         stage('docker Upload') {
            steps {
                sh "docker push jaibw/apidemo:${env.BUILD_NUMBER}"
            }
        }
         
         stage('k8s ns') {
            steps {
                sh "kubectl apply -f deploy/k8s/namespace.yaml"
            }
        }
        
        stage('k8s config') {
            steps {
                sh "kubectl apply -f deploy/k8s/app-config.yaml"
                sh "kubectl apply -f deploy/k8s/app-secret.yaml"
                sh "kubectl apply -f deploy/k8s/pv-postgres.yaml"
                sh "kubectl apply -f deploy/k8s/pvc-postgres.yaml"
            }
        }
        
        stage('k8s postgres') {
            steps {
                sh "kubectl apply -f deploy/k8s/db-deploy.yaml"
                sh "kubectl apply -f deploy/k8s/db-svc.yaml"
            }
        }
        
         stage('k8s app') {
            steps {
                sh "kubectl apply -f deploy/k8s/app-deploy.yaml"
                sh "kubectl apply -f deploy/k8s/db-svc.yaml"
            }
        }
        
        
    }
}
