FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/cause_agent.jar /cause_agent/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/cause_agent/app.jar"]
