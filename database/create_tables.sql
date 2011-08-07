-- MySQL dump 10.13  Distrib 5.1.43, for Win32 (ia32)
--
-- Host: localhost    Database: mediapp3
-- ------------------------------------------------------
-- Server version	5.1.43-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE SCHEMA IF NOT EXISTS `mediapp3` DEFAULT CHARACTER SET latin1 ;

--
-- Table structure for table `mediapp3`.`address`
--

DROP TABLE IF EXISTS `mediapp3`.`address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`address` (
  `idAddress` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `Locality` varchar(100) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` varchar(45) DEFAULT NULL,
  `Country` varchar(45) DEFAULT NULL,
  `personID` int(11) DEFAULT NULL,
  `updated` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAddress`),
  KEY `personID` (`personID`),
  CONSTRAINT `personID` FOREIGN KEY (`personID`) REFERENCES `person` (`idPerson`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `appointment_history`
--

DROP TABLE IF EXISTS `mediapp3`.`appointment_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`appointment_history` (
  `idAppointment_History` int(11) NOT NULL AUTO_INCREMENT,
  `idPatient_details` int(11) DEFAULT NULL,
  `idDoctor_details` int(11) DEFAULT NULL,
  `date_of_appointment` date DEFAULT NULL,
  `idDiagnosis` int(11) DEFAULT NULL,
  `appointment_type` varchar(100) DEFAULT NULL,
  `appointment_confirmation` char(1) DEFAULT NULL,
  `proposed_reschedule_date` datetime DEFAULT NULL,
  `follow_up_date` datetime DEFAULT NULL,
  `reference_doctor_id` int(11) DEFAULT NULL,
  `time_of_appointment` time DEFAULT NULL,
  `appointment_headline` varchar(500) DEFAULT NULL,
  `appointment_comment` varchar(4500) DEFAULT NULL,
  `appointment_duration` time DEFAULT NULL,
  `appointment_end_time` time DEFAULT NULL,
  PRIMARY KEY (`idAppointment_History`),
  KEY `idPatient` (`idPatient_details`),
  KEY `idDoctor` (`idDoctor_details`),
  KEY `idDiagnosis` (`idDiagnosis`),
  KEY `idReferenceDoctor` (`reference_doctor_id`),
  KEY `ahDoctor` (`idDoctor_details`),
  CONSTRAINT `idDiagnosis` FOREIGN KEY (`idDiagnosis`) REFERENCES `diagnosis` (`idDiagnosis`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `code_category`
--

DROP TABLE IF EXISTS `mediapp3`.`code_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`code_category` (
  `idcode_category` int(11) NOT NULL AUTO_INCREMENT,
  `code_category` varchar(45) DEFAULT NULL,
  `caching` char(1) DEFAULT 'N',
  PRIMARY KEY (`idcode_category`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `code_decode`
--

DROP TABLE IF EXISTS `mediapp3`.`code_decode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`code_decode` (
  `idCode_Decode` int(11) NOT NULL,
  `code_ctg` varchar(45) DEFAULT NULL,
  `code_val` varchar(200) DEFAULT NULL,
  `comment` varchar(4000) DEFAULT NULL,
  `code_desc` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`idCode_Decode`),
  UNIQUE KEY `idCode_Decode_UNIQUE` (`idCode_Decode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diagnosis`
--

DROP TABLE IF EXISTS `mediapp3`.`diagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`diagnosis` (
  `idDiagnosis` int(11) NOT NULL,
  `idAppointment` int(11) DEFAULT NULL,
  `ICD_code` varchar(1000) DEFAULT NULL,
  `Prescription` varchar(45) DEFAULT NULL,
  `Lnotes` varchar(4500) DEFAULT NULL,
  `diagnosis` varchar(4500) DEFAULT NULL,
  `allergy` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idDiagnosis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `doctor_details`
--

DROP TABLE IF EXISTS `mediapp3`.`doctor_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`doctor_details` (
  `idDoctor_details` int(11) NOT NULL AUTO_INCREMENT,
  `idPerson` int(11) DEFAULT NULL,
  `specialization` varchar(200) DEFAULT NULL,
  `work_start_time` time DEFAULT NULL,
  `work_end_time` time DEFAULT NULL,
  `monday_working` varchar(1) DEFAULT NULL,
  `tuesday_working` varchar(1) DEFAULT NULL,
  `wednesday_working` varchar(1) DEFAULT NULL,
  `thursday_working` varchar(1) DEFAULT NULL,
  `friday_working` varchar(1) DEFAULT NULL,
  `saturday_working` varchar(1) DEFAULT NULL,
  `sunday_working` varchar(1) DEFAULT NULL,
  `registration_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDoctor_details`),
  KEY `idPerson1` (`idPerson`),
  CONSTRAINT `idPerson1` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1 COMMENT='doctor details';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `doctor_work_timings`
--

DROP TABLE IF EXISTS `mediapp3`.`doctor_work_timings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`doctor_work_timings` (
  `iddoctor_work_timings` int(11) NOT NULL AUTO_INCREMENT,
  `work_day` varchar(45) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddoctor_work_timings`),
  KEY `fk_doctor_id` (`doctor_id`),
  CONSTRAINT `fk_doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctor_details` (`idDoctor_details`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=521 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `holiday_calendar`
--

DROP TABLE IF EXISTS `mediapp3`.`holiday_calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`holiday_calendar` (
  `idholiday_calendar` int(11) NOT NULL,
  `idDoctor` int(11) NOT NULL,
  `date_of_holiday` date NOT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idDoctor`,`date_of_holiday`),
  KEY `hcpersonID` (`idDoctor`),
  KEY `hcDoctor` (`idDoctor`),
  CONSTRAINT `hcDoctor` FOREIGN KEY (`idDoctor`) REFERENCES `doctor_details` (`idDoctor_details`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `icd_code_10`
--

DROP TABLE IF EXISTS `mediapp3`.`icd_code_10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`icd_code_10` (
  `idicd_code_10` int(11) NOT NULL AUTO_INCREMENT,
  `icd_10_code` varchar(45) DEFAULT NULL,
  `ccs_category` varchar(10) DEFAULT NULL,
  `ccs_label` varchar(200) DEFAULT NULL,
  `icd_10_label` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idicd_code_10`),
  UNIQUE KEY `idicd_code_10_UNIQUE` (`idicd_code_10`)
) ENGINE=InnoDB AUTO_INCREMENT=32597 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inbound_messages`
--

DROP TABLE IF EXISTS `mediapp3`.`inbound_messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`inbound_messages` (
  `idinbound_messages` int(11) NOT NULL AUTO_INCREMENT,
  `sender_number` varchar(45) DEFAULT NULL,
  `inbound_message` varchar(200) DEFAULT NULL,
  `sent_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `processing_status` varchar(10) NOT NULL DEFAULT 'SCDL',
  `processed_on_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idprocessing` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idinbound_messages`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `job_inputs`
--

DROP TABLE IF EXISTS `mediapp3`.`job_inputs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`job_inputs` (
  `idjob_inputs` int(11) NOT NULL AUTO_INCREMENT,
  `idschedule_job` int(11) DEFAULT NULL,
  `input_parameter_name` varchar(100) DEFAULT NULL,
  `input_parameter_value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idjob_inputs`),
  KEY `idScheduleJob` (`idschedule_job`),
  CONSTRAINT `idScheduleJob` FOREIGN KEY (`idschedule_job`) REFERENCES `schedule_job` (`idschedule_job`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1060 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `mediapp3`.`log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`log` (
  `idlog` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(1000) DEFAULT NULL,
  `ptime` datetime DEFAULT NULL,
  `log_text` varchar(4500) DEFAULT NULL,
  PRIMARY KEY (`idlog`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `menu_to_role_mapping`
--

DROP TABLE IF EXISTS `mediapp3`.`menu_to_role_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`menu_to_role_mapping` (
  `idmenu_to_role_mapping` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `position` int(3) DEFAULT NULL,
  PRIMARY KEY (`idmenu_to_role_mapping`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient_allergies`
--

DROP TABLE IF EXISTS `mediapp3`.`patient_allergies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`patient_allergies` (
  `idpatient_allergies` int(11) NOT NULL AUTO_INCREMENT,
  `allergy` varchar(4500) DEFAULT NULL,
  `comments` varchar(4500) DEFAULT NULL,
  `idPatient_details` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpatient_allergies`),
  KEY `allergies_to_patient` (`idPatient_details`),
  CONSTRAINT `allergies_to_patient` FOREIGN KEY (`idPatient_details`) REFERENCES `patient_details` (`idPatient_details`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient_details`
--

DROP TABLE IF EXISTS `mediapp3`.`patient_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`patient_details` (
  `idPatient_details` int(11) NOT NULL AUTO_INCREMENT,
  `idPerson` int(11) DEFAULT NULL,
  `idPastHistory` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `height` decimal(10,0) DEFAULT NULL,
  `blood_group` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`idPatient_details`),
  KEY `idPerson` (`idPerson`),
  CONSTRAINT `idPerson` FOREIGN KEY (`idPerson`) REFERENCES `person` (`idPerson`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1 COMMENT='patient details';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient_document_details`
--

DROP TABLE IF EXISTS `mediapp3`.`patient_document_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`patient_document_details` (
  `idpatient_document_details` int(11) NOT NULL AUTO_INCREMENT,
  `document_name` varchar(1000) DEFAULT NULL,
  `document_path` varchar(2000) DEFAULT NULL,
  `comments` varchar(4500) DEFAULT NULL,
  `idPatient_details` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpatient_document_details`),
  KEY `document_to_patient` (`idPatient_details`),
  CONSTRAINT `document_to_patient` FOREIGN KEY (`idPatient_details`) REFERENCES `patient_details` (`idPatient_details`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `patient_prescription`
--

DROP TABLE IF EXISTS `mediapp3`.`patient_prescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`patient_prescription` (
  `idpatient_prescription` int(11) NOT NULL AUTO_INCREMENT,
  `prescription_name` varchar(1000) DEFAULT NULL,
  `dosage` varchar(45) DEFAULT NULL,
  `idDiagnosis` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpatient_prescription`),
  KEY `prescription_to_diagnosis` (`idDiagnosis`),
  CONSTRAINT `prescription_to_diagnosis` FOREIGN KEY (`idDiagnosis`) REFERENCES `diagnosis` (`idDiagnosis`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `mediapp3`.`person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`person` (
  `idPerson` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `landline_phone_number` varchar(20) DEFAULT NULL,
  `mobile_phone_number` varchar(20) DEFAULT NULL,
  `email_Address` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `status_of_account` varchar(1) DEFAULT NULL,
  `hint_question` varchar(100) DEFAULT NULL,
  `hint_answer` varchar(100) DEFAULT NULL,
  `person_type` varchar(45) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPerson`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person_package`
--

DROP TABLE IF EXISTS `mediapp3`.`person_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`person_package` (
  `idperson_package` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) DEFAULT NULL,
  `package` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idperson_package`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`idPerson`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `postal_codes`
--

DROP TABLE IF EXISTS `mediapp3`.`postal_codes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`postal_codes` (
  `idpostal_codes` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(1000) DEFAULT NULL,
  `state_name` varchar(1000) DEFAULT NULL,
  `area_name` varchar(1000) DEFAULT NULL,
  `pin_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idpostal_codes`)
) ENGINE=InnoDB AUTO_INCREMENT=43666 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `prescription_meta_data`
--

DROP TABLE IF EXISTS `mediapp3`.`prescription_meta_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`prescription_meta_data` (
  `idprescription_meta_data` int(11) NOT NULL AUTO_INCREMENT,
  `prescription` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idprescription_meta_data`)
) ENGINE=InnoDB AUTO_INCREMENT=142051 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `schedule_job`
--

DROP TABLE IF EXISTS `mediapp3`.`schedule_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`schedule_job` (
  `idschedule_job` int(11) NOT NULL AUTO_INCREMENT,
  `action` varchar(100) DEFAULT NULL,
  `comments` varchar(4500) DEFAULT NULL,
  `effectiveDate` datetime DEFAULT NULL,
  `job_status` varchar(10) DEFAULT 'SCDL',
  `processingDateTIme` datetime DEFAULT NULL,
  PRIMARY KEY (`idschedule_job`),
  KEY `job_status` (`job_status`),
  KEY `effectiveDate` (`effectiveDate`)
) ENGINE=InnoDB AUTO_INCREMENT=499 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sequence_data`
--

DROP TABLE IF EXISTS `mediapp3`.`sequence_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`sequence_data` (
  `sequence_name` varchar(100) NOT NULL,
  `sequence_increment` int(11) NOT NULL DEFAULT '1',
  `sequence_min_value` int(11) NOT NULL DEFAULT '1',
  `sequence_max_value` bigint(20) NOT NULL DEFAULT '100000000',
  `sequence_cur_value` bigint(20) NOT NULL DEFAULT '1',
  `sequence_cycle` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `smsserver_calls`
--

DROP TABLE IF EXISTS `mediapp3`.`smsserver_calls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`smsserver_calls` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `call_date` datetime NOT NULL,
  `gateway_id` varchar(64) NOT NULL,
  `caller_id` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `smsserver_in`
--

DROP TABLE IF EXISTS `mediapp3`.`smsserver_in`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`smsserver_in` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `process` int(11) NOT NULL,
  `originator` varchar(16) NOT NULL,
  `type` varchar(1) NOT NULL,
  `encoding` char(1) NOT NULL,
  `message_date` datetime NOT NULL,
  `receive_date` datetime NOT NULL,
  `text` varchar(1000) NOT NULL,
  `original_ref_no` varchar(64) DEFAULT NULL,
  `original_receive_date` datetime DEFAULT NULL,
  `gateway_id` varchar(64) DEFAULT NULL,
  `processing_status` varchar(1) DEFAULT 'S',
  `processing_id` varchar(45) DEFAULT NULL,
  `processed_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `smsserver_out`
--

DROP TABLE IF EXISTS `mediapp3`.`smsserver_out`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`smsserver_out` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(1) NOT NULL DEFAULT 'O',
  `recipient` varchar(16) NOT NULL,
  `text` varchar(1000) NOT NULL,
  `wap_url` varchar(100) DEFAULT NULL,
  `wap_expiry_date` datetime DEFAULT NULL,
  `wap_signal` varchar(1) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `originator` varchar(16) NOT NULL DEFAULT ' ',
  `encoding` varchar(1) NOT NULL DEFAULT '7',
  `status_report` int(1) NOT NULL DEFAULT '0',
  `flash_sms` int(1) NOT NULL DEFAULT '0',
  `src_port` int(6) NOT NULL DEFAULT '-1',
  `dst_port` int(6) NOT NULL DEFAULT '-1',
  `sent_date` datetime DEFAULT NULL,
  `ref_no` varchar(64) DEFAULT NULL,
  `priority` int(5) NOT NULL DEFAULT '0',
  `status` varchar(1) NOT NULL DEFAULT 'U',
  `errors` int(2) NOT NULL DEFAULT '0',
  `gateway_id` varchar(64) NOT NULL DEFAULT '*',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `test_meta_data`
--

DROP TABLE IF EXISTS `mediapp3`.`test_meta_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`test_meta_data` (
  `idtest_meta_data` int(11) NOT NULL AUTO_INCREMENT,
  `test_description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idtest_meta_data`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `mediapp3`.`tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediapp3`.`tests` (
  `idTests` int(11) NOT NULL AUTO_INCREMENT,
  `suggested_Test` varchar(1000) DEFAULT NULL,
  `test_Result_Value` varchar(45) DEFAULT NULL,
  `test_Result_Unit` varchar(45) DEFAULT NULL,
  `fDiagnosis` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTests`),
  KEY `fDiagnosis` (`fDiagnosis`),
  KEY `tests_diagnosis` (`fDiagnosis`),
  CONSTRAINT `tests_diagnosis` FOREIGN KEY (`fDiagnosis`) REFERENCES `diagnosis` (`idDiagnosis`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


-- Dump completed on 2011-08-07 20:30:21
