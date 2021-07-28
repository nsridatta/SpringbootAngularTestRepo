DROP TABLE IF EXISTS `employees`;
CREATE TABLE employees
(
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(128) NOT NULL,
`last_name` VARCHAR(255) NOT NULL,
`date_of_joining` VARCHAR(255) NOT NULL,
`email_id` VARCHAR(255) NOT NULL,
`country` VARCHAR(255) NOT NULL,
`state` VARCHAR(255) NOT NULL,
`city` VARCHAR(255) NOT NULL,
PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` smallint NOT NULL AUTO_INCREMENT,
  `country_code` VARCHAR(2),
  `country_name` varchar(255),
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `state_name` varchar(255) DEFAULT NULL,
  `country_id` smallint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`country_id`) REFERENCES `country`(`id`)
);

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) DEFAULT NULL,
  `state_id` smallint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`state_id`) REFERENCES `state`(`id`)
);
