git config pull.rebase true
git pull
mvn -f jaccuzi-spa-back/pom.xml clean package
mvn -f jaccuzi-spa-back/pom.xml jib:dockerBuild

