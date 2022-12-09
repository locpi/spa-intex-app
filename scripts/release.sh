git config pull.rebase true
git pull
mvn build-helper:parse-version versions:set -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.incrementalVersion}
mvn clean package
MVN_VERSION=$(mvn -q \
    -Dexec.executable=echo \
    -Dexec.args='${project.version}' \
    --non-recursive \
    exec:exec)
echo "$MVN_VERSION"
sed -i "/APP_VERSION/d" deploy/prod/.env
#docker build -t evollis-notifications:latest -t evollis-notifications:"$MVN_VERSION" .
mvn jib:dockerBuild
echo "APP_VERSION=$MVN_VERSION" >> deploy/prod/.env
mvn build-helper:parse-version versions:set -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion}-SNAPSHOT
git add pom.xml
git add deploy/prod/.env
git commit -m "[RELEASE] nouvelle version release $MVN_VERSION"
git push origin master