Hướng dẫn tìm template: https://www.youtube.com/watch?v=KcQuJ-c_5wA
Hướng dẫn cơ bản custom template, đổ dữ liệu vào template: https://www.youtube.com/watch?v=kXrq6IiXdzo
Demo Template : https://themewagon.com/themes/eshopper-free-responsive-bootstrap-4-e-commerce-website-template/
Login Template :https://colorlib.com/wp/template/login-form-18/
Hướng dẫn setup kết nối MySQL jdbc :https://freetuts.net/ket-noi-mysql-bang-java-jdbc-driver-2790.html
Hướng dẫn config properties: https://mkyong.com/java/java-properties-file-examples/
Hướng dẫn config jstl :https://openplanning.net/10429/java-jsp-standard-tag-library#a1264562

CREATE TABLE `product` (
  `id` bigint NOT NULL,
  `title` varchar(100) NOT NULL,
  `price` bigint DEFAULT NULL,
  `size` varchar(50) DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `description` text,
  `image` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;