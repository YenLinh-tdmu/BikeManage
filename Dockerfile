# Bước 1: Chọn image chính thức của Java
FROM openjdk:17-jdk-slim AS build

# Bước 2: Thiết lập thư mục làm việc
WORKDIR /app

# Bước 3: Copy pom.xml và tải dependencies
COPY pom.xml .
RUN apt-get update && apt-get install -y maven && mvn dependency:go-offline

# Bước 4: Copy mã nguồn và build ứng dụng
COPY src ./src
RUN mvn clean package -DskipTests

# Bước 5: Tạo image runtime
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/BikeManage-0.0.1-SNAPSHOT.jar app.jar

# Bước 6: Mở cổng ứng dụng (port 8080 hoặc PORT từ môi trường)
EXPOSE 8080

# Bước 7: Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
