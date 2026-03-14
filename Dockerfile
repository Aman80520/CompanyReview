FROM openjdk:17-jdk-slim

WORKDIR /app

COPY ./target/CompanyReview.jar /app

EXPOSE 8080

ENTRYPOINT [ "Java","-jar","CompanyReview.jar" ]
