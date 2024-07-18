
FROM maven:3.6.3-jdk-8
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn clean install
ENTRYPOINT ["mvn", "test"]
