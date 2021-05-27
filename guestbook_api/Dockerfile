FROM openjdk:8-alpine

COPY target/uberjar/guestbook_api.jar /guestbook_api/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/guestbook_api/app.jar"]
