cd  jaccuzi-spa-back
mvn clean package
docker buildx build --platform linux/amd64 -t loicpincon/spa-intex-back:1.1 --push .

cd ../jaccuzi-control
docker buildx build --platform linux/amd64 -t loicpincon/spa-intex-front:1.1 --push .
