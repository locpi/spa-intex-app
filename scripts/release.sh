git config pull.rebase true
git pull
mvn -f jaccuzi-spa-back/pom.xml clean package
mvn -f jaccuzi-spa-back/pom.xml jib:dockerBuild

# shellcheck disable=SC2164
cd jaccuzi-control

npm install
ng build -c production

