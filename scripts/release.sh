VERSION=2.0

cd  back &&
mvn clean package &&
docker buildx build --platform linux/amd64 -t loicpincon/spa-intex-back:$VERSION --push .

cd ../front &&
ng build -c production &&
docker buildx build --platform linux/amd64 -t loicpincon/spa-intex-front:$VERSION --push .
