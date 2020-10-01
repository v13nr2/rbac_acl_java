-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table spring_acl.aauth_groups
DROP TABLE IF EXISTS `aauth_groups`;
CREATE TABLE IF NOT EXISTS `aauth_groups` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `definition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table spring_acl.aauth_groups: ~3 rows (approximately)
/*!40000 ALTER TABLE `aauth_groups` DISABLE KEYS */;
INSERT INTO `aauth_groups` (`id`, `name`, `definition`) VALUES
	('ADMIN', 'ROLE_ADMIN', 'ini admin'),
	('SUPER_ADMIN', 'ROLE_SUPER_ADMIN', 'ini super admin'),
	('USER', 'ROLE_USER', 'ini user');
/*!40000 ALTER TABLE `aauth_groups` ENABLE KEYS */;

-- Dumping structure for table spring_acl.aauth_perms
DROP TABLE IF EXISTS `aauth_perms`;
CREATE TABLE IF NOT EXISTS `aauth_perms` (
  `id` varchar(50) NOT NULL,
  `aauth_perms` varchar(50) DEFAULT NULL,
  `definition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table spring_acl.aauth_perms: ~0 rows (approximately)
/*!40000 ALTER TABLE `aauth_perms` DISABLE KEYS */;
/*!40000 ALTER TABLE `aauth_perms` ENABLE KEYS */;

-- Dumping structure for table spring_acl.aauth_perm_to_group
DROP TABLE IF EXISTS `aauth_perm_to_group`;
CREATE TABLE IF NOT EXISTS `aauth_perm_to_group` (
  `perm_id` varchar(50) NOT NULL,
  `group_id` varchar(50) NOT NULL,
  PRIMARY KEY (`perm_id`,`group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table spring_acl.aauth_perm_to_group: ~0 rows (approximately)
/*!40000 ALTER TABLE `aauth_perm_to_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `aauth_perm_to_group` ENABLE KEYS */;

-- Dumping structure for table spring_acl.aauth_users
DROP TABLE IF EXISTS `aauth_users`;
CREATE TABLE IF NOT EXISTS `aauth_users` (
  `id` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `banned` int(11) DEFAULT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `date_created` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table spring_acl.aauth_users: ~2 rows (approximately)
/*!40000 ALTER TABLE `aauth_users` DISABLE KEYS */;
INSERT INTO `aauth_users` (`id`, `email`, `password`, `username`, `full_name`, `phone_number`, `avatar`, `banned`, `last_login`, `date_created`) VALUES
	('test1', NULL, '123', '001', 'Ferdinand', NULL, NULL, NULL, NULL, NULL),
	('test2', NULL, '456', '002', 'user', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `aauth_users` ENABLE KEYS */;

-- Dumping structure for table spring_acl.aauth_user_to_groups
DROP TABLE IF EXISTS `aauth_user_to_groups`;
CREATE TABLE IF NOT EXISTS `aauth_user_to_groups` (
  `user_id` varchar(50) NOT NULL,
  `group_id` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`group_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table spring_acl.aauth_user_to_groups: ~4 rows (approximately)
/*!40000 ALTER TABLE `aauth_user_to_groups` DISABLE KEYS */;
INSERT INTO `aauth_user_to_groups` (`user_id`, `group_id`) VALUES
	('test1', 'ADMIN'),
	('test1', 'SUPER_ADMIN'),
	('test1', 'USER'),
	('test2', 'USER');
/*!40000 ALTER TABLE `aauth_user_to_groups` ENABLE KEYS */;

-- Dumping structure for table spring_acl.siswa
DROP TABLE IF EXISTS `siswa`;
CREATE TABLE IF NOT EXISTS `siswa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `alamat` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jk` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '0 = tidak aktif, 1 = aktif',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table spring_acl.siswa: ~0 rows (approximately)
/*!40000 ALTER TABLE `siswa` DISABLE KEYS */;
/*!40000 ALTER TABLE `siswa` ENABLE KEYS */;

-- Dumping structure for table spring_acl.table_image
DROP TABLE IF EXISTS `table_image`;
CREATE TABLE IF NOT EXISTS `table_image` (
  `id` int(11) NOT NULL,
  `name_image` varchar(255) DEFAULT NULL,
  `image` blob DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table spring_acl.table_image: ~0 rows (approximately)
/*!40000 ALTER TABLE `table_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `table_image` ENABLE KEYS */;

-- Dumping structure for table spring_acl.table_product
DROP TABLE IF EXISTS `table_product`;
CREATE TABLE IF NOT EXISTS `table_product` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- Dumping data for table spring_acl.table_product: ~6 rows (approximately)
/*!40000 ALTER TABLE `table_product` DISABLE KEYS */;
INSERT INTO `table_product` (`id`, `name`, `created_date`, `created_by`, `updated_date`, `updated_by`) VALUES
	('1fb2d039-b522-4738-b928-db0a876a0787', 'product 3', '2019-10-08 17:23:39.571000', 'admin', NULL, NULL),
	('530d6411-96c0-49cc-a18a-baf9e34e60e9', 'product 5', '2019-10-08 17:23:47.537000', 'admin', NULL, NULL),
	('63b1335e-12c8-49a5-88d1-82cfc5ccf11d', 'product 2', '2019-10-08 17:23:33.472000', 'admin', NULL, NULL),
	('7b789fe5-e574-4dd5-b9b7-2c0e6c4611c6', 'product 1', '2019-10-08 17:23:27.139000', 'admin', NULL, NULL),
	('c595aa72-236d-4403-a435-42ff88c03bfb', 'product 4', '2019-10-08 17:23:43.521000', 'admin', NULL, NULL),
	('c62ab5cc-4254-4b4d-a17d-657ced035bc5', 'product 6 di update', '2019-10-08 17:23:51.110000', 'admin', '2019-10-08 17:27:50', 'pengupdate');
/*!40000 ALTER TABLE `table_product` ENABLE KEYS */;

-- Dumping structure for table spring_acl.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_password` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'md5',
  `user_full_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_request` datetime DEFAULT NULL,
  `user_session` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table spring_acl.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `user_name`, `user_password`, `user_full_name`, `last_request`, `user_session`) VALUES
	(3, 'admin', '202cb962ac59075b964b07152d234b70', 'Si Admin', NULL, '');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
