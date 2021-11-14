FROM openjdk:11
COPY ./build/libs/zuul-edge-service.jar.jar
EXPOSE 8075
CMD ["java","-jar","zuul-edge-service.jar"]