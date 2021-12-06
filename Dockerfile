FROM openjdk:11

COPY ./build/libs/zuul-edge-service.jar zuul-edge-service.jar
#COPY entrypoint.sh /usr/local/bin/entrypoint.sh

EXPOSE 8075
CMD ["java","-jar","zuul-edge-service.jar"]

#RUN chmod +x /usr/local/bin/entrypoint.sh
#CMD bash -c 'source /usr/local/bin/entrypoint.sh && java -Djava.security.egd=file:/dev/./urandom -jar /zuul-edge-service.jar'