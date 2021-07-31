-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: pinkbird
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `job_batch`
--

DROP TABLE IF EXISTS `job_batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_batch` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `job_id` varchar(100) DEFAULT NULL COMMENT '作业ID',
  `job_name` varchar(100) DEFAULT NULL COMMENT '作业名称',
  `job_status` int DEFAULT NULL COMMENT '作业状态',
  `path_jar` varchar(100) DEFAULT NULL COMMENT 'Jar包路径',
  `path_savepoint` varchar(100) DEFAULT NULL COMMENT 'save point路径',
  `enable_savepoint` int DEFAULT NULL COMMENT '是否启用save point',
  `jm_mem` int DEFAULT NULL COMMENT 'Job manager内存大小',
  `tm_mem` int DEFAULT NULL COMMENT 'Task manager内存大小',
  `yarnslots` int DEFAULT NULL COMMENT '槽数',
  `parallelism` int DEFAULT NULL COMMENT '并行度',
  `class_name` varchar(100) DEFAULT NULL COMMENT '主类名',
  `class_args` varchar(100) DEFAULT NULL COMMENT '运行参数',
  `start_time` datetime DEFAULT NULL,
  `create_userid` int DEFAULT NULL COMMENT '创建用户ID',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_userid` int DEFAULT NULL COMMENT '修改用户ID',
  `update_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_batch`
--

LOCK TABLES `job_batch` WRITE;
/*!40000 ALTER TABLE `job_batch` DISABLE KEYS */;
INSERT INTO `job_batch` VALUES (1,'application_1611304010879_0001','OrderDoneLog',1,'/var/flink/job/etl/sht-realtime-etl.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(2,'application_1611304010879_0002','AccessLogKafkaTransLoader',1,'/var/flink/job/etl/sht-realtime-etl.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(3,'application_1611304010879_0003','OrderOriginLogExtractor',1,'/var/flink/job/etl/sht-realtime-etl.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(4,'application_1611304010879_0004','OrderDoneLogKafkaTransLoader',1,'/var/flink/job/etl/sht-realtime-etl.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(5,'application_1611304010879_0005','ReverseWholeLogExtractor',1,'/var/flink/job/etl/sht-realtime-etl.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(6,'application_1611304010879_0006','OrderDoneLogClickHouseLoader',1,'/var/flink/job/etl/sht-realtime-etl.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(7,'application_1611304010879_0007','InternalCockpitDashboard',1,'/var/flink/job/etl/sht-realtime-dws.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(8,'application_1611304010879_0008','InternalPartnerMultipleDashboard',1,'/var/flink/job/etl/sht-realtime-dws.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(9,'application_1611304010879_0009','RealtimeWarReportDashboard',1,'/var/flink/job/etl/sht-realtime-dws.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(10,'application_1611304010879_00010','RealtimeWarReportOrderDashboard',1,'/var/flink/job/etl/sht-realtime-dws.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(11,'application_1611304010879_00011','RealtimeWarRepUVDashboard',1,'/var/flink/job/etl/sht-realtime-dws.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL),(12,'application_1611304010879_00012','HomePageClickStat',1,'/var/flink/job/etl/sht-realtime-dws.jar',NULL,0,1536,6144,2,20,NULL,'production','2021-07-30 00:00:00',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `job_batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_config`
--

DROP TABLE IF EXISTS `system_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_config` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `key` varchar(128) NOT NULL COMMENT 'key值',
  `val` varchar(512) NOT NULL COMMENT 'value',
  `type` varchar(12) NOT NULL COMMENT '类型 如:sys  alarm',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `creator` varchar(32) NOT NULL DEFAULT 'sys',
  `editor` varchar(32) NOT NULL DEFAULT 'sys',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_config`
--

LOCK TABLES `system_config` WRITE;
/*!40000 ALTER TABLE `system_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `stauts` tinyint(1) NOT NULL COMMENT '1:启用 0: 停用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1:删除 0: 未删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'sys',
  `editor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT 'sys',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_uk` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_user`
--

LOCK TABLES `system_user` WRITE;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-31 18:41:18
