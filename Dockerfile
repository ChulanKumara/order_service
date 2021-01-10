
#FROM java:8 as builder
#RUN mkdir -p app/source
#COPY . /app/source
#WORKDIR /app/source
#RUN ./mvnw clean package -Dmaven.test.skip=true
FROM maven AS builder
RUN mkdir -p app/order/source
COPY . /app/order/source
WORKDIR /app/order/source
RUN mvn clean package -Dmaven.test.skip=true

FROM  java:8 as vm
COPY --from=builder /app/order/source/target/*.jar /app/order/order_service.jar
WORKDIR /app/product
EXPOSE 8083
ENTRYPOINT ["java","-jar","product_service.jar","--spring.profiles.active=${ENV}"]
