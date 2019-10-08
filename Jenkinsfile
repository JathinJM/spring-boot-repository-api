node {
stage('SCM Checkout'){
get https://github.com/JathinJM/spring-boot-repository-api
}
stage('Compile-Package') {
sh 'mvn package'
}
}
