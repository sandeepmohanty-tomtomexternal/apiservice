mvn install -DskipTests=true
cp target/OnlineVotingSystem-0.0.1-SNAPSHOT.jar deploy/OnlineVotingSystem-0.0.1-SNAPSHOT.jar
cd deploy
docker build -t jaibw/api .
docker push jaibw/api