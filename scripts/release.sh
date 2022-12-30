source .env

cd  back &&
mvn clean package &&
docker buildx build --platform linux/amd64 -t loicpincon/spa-intex-back:$VERSION_BACK --push .

cd ../front &&
ng build -c production &&
docker buildx build --platform linux/amd64 -t loicpincon/spa-intex-front:$VERSION_FRONT --push .
