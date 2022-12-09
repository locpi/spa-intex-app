git config pull.rebase true
git pull
cd jaccuzi-spa-back
mvn clean package
mvn jib:dockerBuild
