Docker commands
----------------------------
1. docker pull <image>:<tag>

2. docker run <image>:<tag>

3. docker run -d <image>:<tag> --> Runs in detach mode, and it produces the container id

4. docker run -p <host port>:<container port> --> To bind the container port to host port

5. docker run --name <container name>  <image name> --> To run the container with different name other than image name.

6. docker ps --> show the running containers

7. docker ps -a --> To see the all the past containers

8. docker start <container ID>

9. docker stop <container ID>

10. docker images -> To list down all the available images

11. docker logs <container id>
docker logs <container id> | tail
docker logs <container id> -f --> String the logs


12. docker exec -it <container id> /bin/bash --> To get the interactive terminal of container or to access the file system of container.

13. exit -> exit out from interactive terminal

14. env -> To get the environment variables in linux

15. docker network ls --> To list down the networks: containers in the same network can just communicate using the container name.

16. docker network create <network name>

17. docker run --net <network name> <Image>  --> docker



Docker Compose
-----------------------
1. Docker Compose is a tool that was developed to help define and share multi-container applications. With Compose, we can create a YAML file to define the services and with a single command, can spin everything up or tear it all down.

2. Write the docker compose yaml file and then execute the following command

3. docker-compose -f mongo.yaml up/down  --> Up is to run all container and Down is to stop all the containers insider the yaml


Dockerfile
------------------------
1. A Dockerfile is a text document that contains all the commands a user could call on the command line to assemble an image. Using docker build users can create an automated build that executes several command-line instructions in succession. This page describes the commands you can use in a Dockerfile

2. Dockerfile name must be starting with 'D' "Dockerfile"

3. Then execute the command "docker build -t <imagename>:<verionnumber>" .<Path of the dockerfile>

Kubernetes
----------------------
1. Open source and container orchestration tool
2. High availability: no downtime, Scalability: high performance, Disaster: recovery-backup and recovery