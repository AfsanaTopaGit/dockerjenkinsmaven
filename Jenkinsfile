node{
def GIT_URL= "git@github.com:AfsanaTopaGit/dockerjenkinsmaven.git"
def SERVICE_NAME= "docker-jenkins-maven-image-test"
env.appUrl= "${params.appUrl}"

env.isStaus=""
def String branchName="${params.branchName}"

def pathToTestResult= "${env.WORKSPACE}/build/test-=results/test/"
def text="

//Email definitions

def smtp="smtp://mailout.topa.fed.gov"
def from="foo@gmail.com"
def to="bar@gmail.com"


if(env.appUrl=="null" || env.appUrl==""){
env.appUrl=="https://fed-topa-dev.gov"
}


stage("clean workspace and checkout Git code"){
echo "checking out from ${GIT_URL}"
echo "Backstage URL is {appUrl}"
git branch: 'main', credentialsId: 'github-ssh-key', url: 'git@github.com:AfsanaTopaGit/dockerjenkinsmaven.git'

}


stage('Images'){
dir(SERVICE_NAME){
sh """
cd "${env.WORKSPACE}"
ls -al
pwd
docker build -t docker-jenkins-maven-image-test .
docker ps --all
docker plugin ls
docker images
"""
}
}



stage('Run Selenium Tests using Maven'){
script{
docker.image("docker-jenkins-maven-image-test:lates").inside(){
sh """
ls -R /opt/google/chrome/
ls -R /usr/bin/chrome/
./gradlew test -DappUrl=${appUrl}
"""
}
}

//Steps to send email to do

stage(Publish report){
publishHTML(target:[
allowMissing: false,
alwaysLinkToLastBuild: true,
keepAll: true,
reportDir: './build/test-=results/test/'
reportFiles: 'index.html'
reportName: 'HTML_Report'
reportTitles: ''
}
