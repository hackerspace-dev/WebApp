CREATE TABLE `users` (
   `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(40) NOT NULL,
   `date` DATETIME DEFAULT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `name` (`name`)
 ) ENGINE=MYISAM DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
 
 