#docker-compose -f deploy/prod/docker-compose.yml rm -s -f -v app-bitbucket
#docker-compose -f deploy/prod/docker-compose.yml up app-bitbucket -d

docker-compose -f deploy/prod/docker-compose.yml rm -s -f -v app-gitlab
docker-compose -f deploy/prod/docker-compose.yml up app-gitlab -d
