# MetroRide CI/CD, Docker, and Automation Setup

## Jenkins Pipeline Stages
1. **Checkout** - Retrieves source code from Git.
2. **Maven Build** - Compiles & packages the Java project.
3. **Archive Artifact** - Stores the generated JAR.
4. **Docker Build** - Builds container image for the API.
5. **Docker Push** - Pushes the image to a remote registry.

## Docker Commands
```
docker build -t metroride-api .
docker run -p 8080:8080 metroride-api
docker images
docker ps
```

## Running Docker Compose
```
docker-compose up --build
```

## Shell Automation Script
The script `health_check.sh` performs:
- Disk usage check  
- Memory usage check  
- Listing running Java processes  

Make executable:
```
chmod +x health_check.sh
./health_check.sh
```
