# Bookteria

Bookteria là hệ thống mạng xã hội dành cho người yêu sách. Người dùng có
thể đăng ký và đăng nhập, quản lý hồ sơ, chia sẻ bài viết, trò chuyện, tìm
kiếm nội dung và lưu trữ tệp thông qua các dịch vụ độc lập.

## Kiến trúc hệ thống

Bookteria được xây dựng theo kiến trúc microservices:

- **Web App**: giao diện ReactJS cho người dùng.
- **Mobile App**: ứng dụng Flutter.
- **API Gateway**: cổng vào tập trung, định tuyến request và xác thực.
- **Identity Service**: đăng ký, đăng nhập và quản lý danh tính người dùng
  với MySQL.
- **Profile Service**: quản lý thông tin hồ sơ và quan hệ người dùng với
  Neo4j.
- **Post Service**: quản lý bài viết với MongoDB.
- **Book Service**: quản lý dữ liệu sách và chức năng liên quan.
- **Chat Service**: quản lý cuộc trò chuyện và tin nhắn.
- **Notification Service**: xử lý thông báo và email.
- **File Service**: quản lý tệp và hình ảnh.
- **Search Service**: tìm kiếm nội dung với Elasticsearch.
- **Kafka**: truyền sự kiện bất đồng bộ giữa các service.

## Công nghệ sử dụng

- Java, Spring Boot, Spring Cloud Gateway, Spring Security và OpenFeign
- ReactJS và Material UI
- Flutter
- MySQL, MongoDB, Neo4j và Elasticsearch
- Apache Kafka
- Docker Compose

## Yêu cầu

- JDK 17 trở lên
- Maven
- Node.js và npm
- Docker Desktop
- Flutter SDK nếu cần chạy mobile app

## Khởi chạy hạ tầng

Từ thư mục gốc của project, chạy:

```bash
docker compose up -d
```

Lệnh trên khởi chạy Kafka, MongoDB, MySQL và Neo4j theo cấu hình trong
[`docker-compose.yml`](./docker-compose.yml).

## Chạy các service

Mỗi backend service là một Maven project độc lập. Ví dụ:

```bash
cd identity-service
./mvnw spring-boot:run
```

Trên Windows có thể dùng:

```powershell
.\mvnw.cmd spring-boot:run
```

Thực hiện tương tự cho `api-gateway`, `profile-service`, `post-service`,
`book-service`, `chat-service`, `notification-service`, `file-service` và
`search-service`.

## Chạy Web App

```bash
cd web-app
npm install
npm start
```

## Tài liệu service

README hướng dẫn riêng của từng thành phần nằm trong các thư mục:

- [`api-gateway`](./api-gateway/README.md)
- [`identity-service`](./identity-service/README.md)
- [`profile-service`](./profile-service/README.md)
- [`post-service`](./post-service/README.md)
- [`book-service`](./book-service/README.md)
- [`chat-service`](./chat-service/README.md)
- [`notification-service`](./notification-service/README.md)
- [`file-service`](./file-service/README.md)
- [`search-service`](./search-service/README.md)
- [`web-app`](./web-app/README.md)
- [`mobile-app`](./mobile-app/README.md)

## Sơ đồ hệ thống

Sơ đồ kiến trúc được lưu tại
[`image/bookteria-architecture.png`](./image/bookteria-architecture.png).

