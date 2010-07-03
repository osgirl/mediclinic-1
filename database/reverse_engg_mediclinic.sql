SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
CREATE SCHEMA IF NOT EXISTS `mediapp` DEFAULT CHARACTER SET latin1 ;

-- -----------------------------------------------------
-- Table `mediapp`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`person` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`person` (
  `idPerson` INT(11) NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(45) NULL DEFAULT NULL ,
  `last_name` VARCHAR(45) NULL DEFAULT NULL ,
  `middle_name` VARCHAR(45) NULL DEFAULT NULL ,
  `date_of_birth` DATE NULL DEFAULT NULL ,
  `Gender` VARCHAR(1) NULL DEFAULT NULL ,
  `landline_phone_number` VARCHAR(20) NULL DEFAULT NULL ,
  `mobile_phone_number` VARCHAR(20) NULL DEFAULT NULL ,
  `email_Address` VARCHAR(45) NULL DEFAULT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  `status_of_account` VARCHAR(1) NULL DEFAULT NULL ,
  `hint_question` VARCHAR(100) NULL DEFAULT NULL ,
  `hint_answer` VARCHAR(100) NULL DEFAULT NULL ,
  `person_type` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPerson`) ,
  UNIQUE INDEX `email_Address_UNIQUE` (`email_Address` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`address` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`address` (
  `idAddress` INT(11) NOT NULL AUTO_INCREMENT ,
  `address1` VARCHAR(100) NULL DEFAULT NULL ,
  `address2` VARCHAR(100) NULL DEFAULT NULL ,
  `Locality` VARCHAR(100) NULL DEFAULT NULL ,
  `City` VARCHAR(45) NULL DEFAULT NULL ,
  `State` VARCHAR(45) NULL DEFAULT NULL ,
  `Country` VARCHAR(45) NULL DEFAULT NULL ,
  `personID` INT(11) NULL DEFAULT NULL ,
  `updated` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idAddress`) ,
  INDEX `personID` (`personID` ASC) ,
  CONSTRAINT `personID`
    FOREIGN KEY (`personID` )
    REFERENCES `mediapp`.`person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`diagnosis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`diagnosis` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`diagnosis` (
  `idDiagnosis` INT(11) NOT NULL ,
  `idAppointment` INT(11) NULL DEFAULT NULL ,
  `ICD_code` VARCHAR(45) NULL DEFAULT NULL ,
  `Prescription` VARCHAR(45) NULL DEFAULT NULL ,
  `Lnotes` VARCHAR(4500) NULL DEFAULT NULL ,
  `diagnosis` VARCHAR(4500) NULL DEFAULT NULL ,
  `allergy` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`idDiagnosis`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`appointment_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`appointment_history` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`appointment_history` (
  `idAppointment_History` INT(11) NOT NULL AUTO_INCREMENT ,
  `idPatient_details` INT(11) NULL DEFAULT NULL ,
  `idDoctor_details` INT(11) NULL DEFAULT NULL ,
  `date_of_appointment` DATE NULL DEFAULT NULL ,
  `idDiagnosis` INT(11) NULL DEFAULT NULL ,
  `appointment_type` VARCHAR(100) NULL DEFAULT NULL ,
  `appointment_confirmation` CHAR(1) NULL DEFAULT NULL ,
  `proposed_reschedule_date` DATETIME NULL DEFAULT NULL ,
  `follow_up_date` DATETIME NULL DEFAULT NULL ,
  `reference_doctor_id` INT(11) NULL DEFAULT NULL ,
  `time_of_appointment` TIME NULL DEFAULT NULL ,
  `appointment_headline` VARCHAR(500) NULL DEFAULT NULL ,
  `appointment_comment` VARCHAR(4500) NULL DEFAULT NULL ,
  `appointment_duration` TIME NULL DEFAULT NULL ,
  PRIMARY KEY (`idAppointment_History`) ,
  INDEX `idPatient` (`idPatient_details` ASC) ,
  INDEX `idDoctor` (`idDoctor_details` ASC) ,
  INDEX `idDiagnosis` (`idDiagnosis` ASC) ,
  INDEX `idReferenceDoctor` (`reference_doctor_id` ASC) ,
  CONSTRAINT `idDiagnosis`
    FOREIGN KEY (`idDiagnosis` )
    REFERENCES `mediapp`.`diagnosis` (`idDiagnosis` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDoctor`
    FOREIGN KEY (`idDoctor_details` )
    REFERENCES `mediapp`.`person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idPatient`
    FOREIGN KEY (`idPatient_details` )
    REFERENCES `mediapp`.`person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idReferenceDoctor`
    FOREIGN KEY (`reference_doctor_id` )
    REFERENCES `mediapp`.`person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 36
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`code_decode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`code_decode` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`code_decode` (
  `idCode_Decode` INT(11) NOT NULL ,
  `code_ctg` VARCHAR(45) NULL DEFAULT NULL ,
  `code_val` VARCHAR(200) NULL DEFAULT NULL ,
  `comment` VARCHAR(4000) NULL DEFAULT NULL ,
  `code_desc` VARCHAR(4000) NULL DEFAULT NULL ,
  PRIMARY KEY (`idCode_Decode`) ,
  UNIQUE INDEX `idCode_Decode_UNIQUE` (`idCode_Decode` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`doctor_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`doctor_details` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`doctor_details` (
  `idDoctor_details` INT(11) NOT NULL AUTO_INCREMENT ,
  `idPerson` INT(11) NULL DEFAULT NULL ,
  `specialization` VARCHAR(200) NULL DEFAULT NULL ,
  `work_start_time` TIME NULL DEFAULT NULL ,
  `work_end_time` TIME NULL DEFAULT NULL ,
  `monday_working` VARCHAR(1) NULL DEFAULT NULL ,
  `tuesday_working` VARCHAR(1) NULL DEFAULT NULL ,
  `wednesday_working` VARCHAR(1) NULL DEFAULT NULL ,
  `thursday_working` VARCHAR(1) NULL DEFAULT NULL ,
  `friday_working` VARCHAR(1) NULL DEFAULT NULL ,
  `saturday_working` VARCHAR(1) NULL DEFAULT NULL ,
  `sunday_working` VARCHAR(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`idDoctor_details`) ,
  INDEX `idPerson1` (`idPerson` ASC) ,
  CONSTRAINT `idPerson1`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediapp`.`person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1
COMMENT = '\'doctor detail';


-- -----------------------------------------------------
-- Table `mediapp`.`doctor_work_timings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`doctor_work_timings` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`doctor_work_timings` (
  `iddoctor_work_timings` INT(11) NOT NULL ,
  `work_day` VARCHAR(45) NULL DEFAULT NULL ,
  `start_time` TIME NULL DEFAULT NULL ,
  `end_time` TIME NULL DEFAULT NULL ,
  `doctor_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`iddoctor_work_timings`) ,
  INDEX `fk_doctor_id` (`doctor_id` ASC) ,
  CONSTRAINT `fk_doctor_id`
    FOREIGN KEY (`doctor_id` )
    REFERENCES `mediapp`.`doctor_details` (`idDoctor_details` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`holiday_calendar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`holiday_calendar` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`holiday_calendar` (
  `idholiday_calendar` INT(11) NOT NULL ,
  `idPerson` INT(11) NULL DEFAULT NULL ,
  `date_of_holiday` DATE NULL DEFAULT NULL ,
  `start_time` TIME NULL DEFAULT NULL ,
  `end_time` TIME NULL DEFAULT NULL ,
  PRIMARY KEY (`idholiday_calendar`) ,
  INDEX `hcpersonID` (`idPerson` ASC) ,
  CONSTRAINT `hcpersonID`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediapp`.`person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`icd_code_10`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`icd_code_10` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`icd_code_10` (
  `idicd_code_10` INT(11) NOT NULL AUTO_INCREMENT ,
  `icd_10_code` VARCHAR(45) NULL DEFAULT NULL ,
  `ccs_category` VARCHAR(10) NULL DEFAULT NULL ,
  `ccs_label` VARCHAR(200) NULL DEFAULT NULL ,
  `icd_10_label` VARCHAR(1000) NULL DEFAULT NULL ,
  PRIMARY KEY (`idicd_code_10`) ,
  UNIQUE INDEX `idicd_code_10_UNIQUE` (`idicd_code_10` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 32597
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`schedule_job`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`schedule_job` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`schedule_job` (
  `idschedule_job` INT(11) NOT NULL AUTO_INCREMENT ,
  `action` VARCHAR(100) NULL DEFAULT NULL ,
  `comments` VARCHAR(4500) NULL DEFAULT NULL ,
  PRIMARY KEY (`idschedule_job`) )
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`job_inputs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`job_inputs` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`job_inputs` (
  `idjob_inputs` INT(11) NOT NULL AUTO_INCREMENT ,
  `idschedule_job` INT(11) NULL DEFAULT NULL ,
  `input_parmeter_name` VARCHAR(100) NULL DEFAULT NULL ,
  `input_paramenter_id` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`idjob_inputs`) ,
  INDEX `idScheduleJob` (`idschedule_job` ASC) ,
  CONSTRAINT `idScheduleJob`
    FOREIGN KEY (`idschedule_job` )
    REFERENCES `mediapp`.`schedule_job` (`idschedule_job` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`log` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`log` (
  `idlog` INT(11) NOT NULL AUTO_INCREMENT ,
  `pname` VARCHAR(1000) NULL DEFAULT NULL ,
  `ptime` DATETIME NULL DEFAULT NULL ,
  `log_text` VARCHAR(4500) NULL DEFAULT NULL ,
  PRIMARY KEY (`idlog`) )
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`menu_to_role_mapping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`menu_to_role_mapping` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`menu_to_role_mapping` (
  `idmenu_to_role_mapping` INT(11) NOT NULL AUTO_INCREMENT ,
  `menu_name` VARCHAR(50) NULL DEFAULT NULL ,
  `menu_url` VARCHAR(100) NULL DEFAULT NULL ,
  `role` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`idmenu_to_role_mapping`) )
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`patient_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`patient_details` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`patient_details` (
  `idPatient_details` INT(11) NOT NULL AUTO_INCREMENT ,
  `idPerson` INT(11) NULL DEFAULT NULL ,
  `idPastHistory` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPatient_details`) ,
  INDEX `idPerson` (`idPerson` ASC) ,
  CONSTRAINT `idPerson`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediapp`.`person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1
COMMENT = '\'patient detail';


-- -----------------------------------------------------
-- Table `mediapp`.`postal_codes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`postal_codes` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`postal_codes` (
  `idpostal_codes` INT(11) NOT NULL AUTO_INCREMENT ,
  `country_name` VARCHAR(1000) NULL DEFAULT NULL ,
  `state_name` VARCHAR(1000) NULL DEFAULT NULL ,
  `area_name` VARCHAR(1000) NULL DEFAULT NULL ,
  `pin_code` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`idpostal_codes`) )
ENGINE = InnoDB
AUTO_INCREMENT = 43666
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`prescription_meta_data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`prescription_meta_data` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`prescription_meta_data` (
  `idprescription_meta_data` INT(11) NOT NULL AUTO_INCREMENT ,
  `prescription` VARCHAR(1000) NULL DEFAULT NULL ,
  PRIMARY KEY (`idprescription_meta_data`) )
ENGINE = InnoDB
AUTO_INCREMENT = 142051
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`sequence_data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`sequence_data` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`sequence_data` (
  `sequence_name` VARCHAR(100) NOT NULL ,
  `sequence_increment` INT(11) NOT NULL DEFAULT '1' ,
  `sequence_min_value` INT(11) NOT NULL DEFAULT '1' ,
  `sequence_max_value` BIGINT(20) NOT NULL DEFAULT '100000000' ,
  `sequence_cur_value` BIGINT(20) NOT NULL DEFAULT '1' ,
  `sequence_cycle` TINYINT(1) NOT NULL DEFAULT '0' ,
  PRIMARY KEY (`sequence_name`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`test_meta_data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`test_meta_data` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`test_meta_data` (
  `idtest_meta_data` INT(11) NOT NULL AUTO_INCREMENT ,
  `test_description` VARCHAR(1000) NULL DEFAULT NULL ,
  PRIMARY KEY (`idtest_meta_data`) )
ENGINE = InnoDB
AUTO_INCREMENT = 87
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mediapp`.`tests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`tests` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`tests` (
  `idTests` INT(11) NOT NULL AUTO_INCREMENT ,
  `suggested_Test` VARCHAR(1000) NULL DEFAULT NULL ,
  `test_Result_Value` VARCHAR(45) NULL DEFAULT NULL ,
  `test_Result_Unit` VARCHAR(45) NULL DEFAULT NULL ,
  `fDiagnosis` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`idTests`) ,
  INDEX `fDiagnosis` (`fDiagnosis` ASC) ,
  INDEX `fk_diagnosis` () ,
  CONSTRAINT `fk_diagnosis`
    FOREIGN KEY ()
    REFERENCES `mediapp`.`diagnosis` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- function bulknextval
-- -----------------------------------------------------

DELIMITER $$
DROP function IF EXISTS `mediapp`.`bulknextval` $$
CREATE DEFINER=`root`@`localhost` FUNCTION `bulknextval`(`seq_name` varchar(100), `incrementamt` bigint(20)) RETURNS bigint(20)
BEGIN    
 DECLARE cur_val bigint(20);
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp.sequence_data     
 WHERE        
 sequence_name = seq_name;    
 IF cur_val IS NOT NULL THEN        
 UPDATE            
 mediapp.sequence_data         
 SET            
 sequence_cur_value = IF (                 
 (sequence_cur_value + sequence_increment*incrementamt) > sequence_max_value,                 
 IF (                     
 sequence_cycle = TRUE,                     
 sequence_min_value,                     
 NULL                
 ),                 
 sequence_cur_value + sequence_increment*incrementamt             
 )         
 WHERE            
 sequence_name = seq_name         
 ;     
 END IF; 
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp.sequence_data     
 WHERE        
 sequence_name = seq_name;  
 RETURN cur_val; 
END$$

-- -----------------------------------------------------
-- function currval
-- -----------------------------------------------------
DROP function IF EXISTS `mediapp`.`currval` $$
CREATE DEFINER=`root`@`localhost` FUNCTION `currval`(`seq_name` varchar(100)) RETURNS bigint(20)
BEGIN    
 DECLARE cur_val bigint(20); 
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp.sequence_data     
 WHERE        
 sequence_name = seq_name;    
 RETURN cur_val; 
 END$$

-- -----------------------------------------------------
-- procedure log_insert
-- -----------------------------------------------------
DROP procedure IF EXISTS `mediapp`.`log_insert` $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `log_insert`(in p_proc_id varchar(100),in p_debug_info text)
BEGIN
insert into log (pname,log_text,ptime)  values (p_proc_id,p_debug_info,now());
END$$

-- -----------------------------------------------------
-- function nextval
-- -----------------------------------------------------
DROP function IF EXISTS `mediapp`.`nextval` $$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextval`(`seq_name` varchar(100)) RETURNS bigint(20)
BEGIN    
 DECLARE cur_val bigint(20);
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp.sequence_data     
 WHERE        
 sequence_name = seq_name;    
 IF cur_val IS NOT NULL THEN        
 UPDATE            
 mediapp.sequence_data         
 SET            
 sequence_cur_value = IF (                 
 (sequence_cur_value + sequence_increment) > sequence_max_value,                 
 IF (                     
 sequence_cycle = TRUE,                     
 sequence_min_value,                     
 NULL                
 ),                 
 sequence_cur_value + sequence_increment             
 )         
 WHERE            
 sequence_name = seq_name         
 ;     
 END IF; 
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp.sequence_data     
 WHERE        
 sequence_name = seq_name;  
 RETURN cur_val; 
 END$$

DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
