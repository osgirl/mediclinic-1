SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `mediapp` ;
CREATE SCHEMA IF NOT EXISTS `mediapp` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
DROP SCHEMA IF EXISTS `new_schema1` ;
CREATE SCHEMA IF NOT EXISTS `new_schema1` ;

-- -----------------------------------------------------
-- Table `mediapp`.`Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Person` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Person` (
  `idPerson` INT NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(45) NULL ,
  `last_name` VARCHAR(45) NULL ,
  `middle_name` VARCHAR(45) NULL ,
  `date_of_birth` DATE NULL ,
  `Gender` VARCHAR(1) NULL ,
  `landline_phone_number` VARCHAR(100) NULL ,
  `mobile_phone_number` VARCHAR(100) NULL ,
  `email_Address` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `status_of_account` VARCHAR(1) NULL ,
  `hint_question` VARCHAR(100) NULL ,
  `hint_answer` VARCHAR(100) NULL ,
  `person_type` VARCHAR(45) NULL ,
  PRIMARY KEY (`idPerson`) ,
  UNIQUE INDEX `email_Address_UNIQUE` (`email_Address` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`Patient_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Patient_details` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Patient_details` (
  `idPatient_details` INT NOT NULL AUTO_INCREMENT ,
  `idPerson` INT NULL ,
  `idPastHistory` INT NULL ,
  PRIMARY KEY (`idPatient_details`) ,
  INDEX `idPerson` (`idPerson` ASC) ,
  CONSTRAINT `idPerson`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediapp`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'patient details';


-- -----------------------------------------------------
-- Table `mediapp`.`doctor_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`doctor_details` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`doctor_details` (
  `idDoctor_details` INT NOT NULL AUTO_INCREMENT ,
  `idPerson` INT NULL ,
  `specialization` VARCHAR(200) NULL ,
  `work_start_time` TIME NULL ,
  `work_end_time` TIME NULL ,
  `monday_working` VARCHAR(1) NULL ,
  `tuesday_working` VARCHAR(1) NULL ,
  `wednesday_working` VARCHAR(1) NULL ,
  `thursday_working` VARCHAR(1) NULL ,
  `friday_working` VARCHAR(1) NULL ,
  `saturday_working` VARCHAR(1) NULL ,
  `sunday_working` VARCHAR(1) NULL ,
  PRIMARY KEY (`idDoctor_details`) ,
  INDEX `idPerson1` (`idPerson` ASC) ,
  CONSTRAINT `idPerson1`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediapp`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'doctor details';


-- -----------------------------------------------------
-- Table `mediapp`.`Diagnosis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Diagnosis` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Diagnosis` (
  `idDiagnosis` INT NOT NULL AUTO_INCREMENT ,
  `idAppointment` INT NULL ,
  `ICD_code` VARCHAR(45) NULL ,
  `Prescription` VARCHAR(45) NULL ,
  `Lnotes` VARCHAR(4500) NULL ,
  `diagnosis` VARCHAR(4500) NULL ,
  `allergy` VARCHAR(100) NULL ,
  `idTests` INT NULL ,
  PRIMARY KEY (`idDiagnosis`) ,
  INDEX `idAppointment` (`idAppointment` ASC) ,
  CONSTRAINT `idAppointment`
    FOREIGN KEY (`idAppointment` )
    REFERENCES `mediapp`.`Appointment_History` (`idAppointment_History` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`Appointment_History`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Appointment_History` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Appointment_History` (
  `idAppointment_History` INT NOT NULL AUTO_INCREMENT ,
  `idPatient_details` INT NULL ,
  `idDoctor_details` INT NULL ,
  `date_of_appointment` DATE NULL ,
  `idDiagnosis` INT NULL ,
  `appointment_type` VARCHAR(100) NULL ,
  `appointment_confirmation` CHAR NULL ,
  `proposed_reschedule_date` DATETIME NULL ,
  `follow_up_date` DATETIME NULL ,
  `reference_doctor_id` INT NULL ,
  `time_of_appointment` TIME NULL ,
  `appointment_headline` VARCHAR(500) NULL ,
  `appointment_comment` VARCHAR(4500) NULL ,
  `appointment_duration` TIME NULL ,
  PRIMARY KEY (`idAppointment_History`) ,
  INDEX `idPatient` (`idPatient_details` ASC) ,
  INDEX `idDoctor` (`idDoctor_details` ASC) ,
  INDEX `idDiagnosis` (`idDiagnosis` ASC) ,
  INDEX `idReferenceDoctor` (`reference_doctor_id` ASC) ,
  CONSTRAINT `idPatient`
    FOREIGN KEY (`idPatient_details` )
    REFERENCES `mediapp`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDoctor`
    FOREIGN KEY (`idDoctor_details` )
    REFERENCES `mediapp`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDiagnosis`
    FOREIGN KEY (`idDiagnosis` )
    REFERENCES `mediapp`.`Diagnosis` (`idDiagnosis` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idReferenceDoctor`
    FOREIGN KEY (`reference_doctor_id` )
    REFERENCES `mediapp`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`Code_Decode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Code_Decode` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Code_Decode` (
  `idCode_Decode` INT NOT NULL ,
  `code_ctg` VARCHAR(45) NULL ,
  `code_val` VARCHAR(200) NULL ,
  `code_desc` VARCHAR(4000) NULL ,
  `comment` VARCHAR(4000) NULL ,
  PRIMARY KEY (`idCode_Decode`) ,
  UNIQUE INDEX `idCode_Decode_UNIQUE` (`idCode_Decode` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Address` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Address` (
  `idAddress` INT NOT NULL AUTO_INCREMENT ,
  `address1` VARCHAR(100) NULL ,
  `address2` VARCHAR(100) NULL ,
  `Locality` VARCHAR(100) NULL ,
  `City` VARCHAR(45) NULL ,
  `State` VARCHAR(45) NULL ,
  `Country` VARCHAR(45) NULL ,
  `personID` INT NULL ,
  `updated` INT NULL DEFAULT 1 ,
  PRIMARY KEY (`idAddress`) ,
  INDEX `personID` (`personID` ASC) ,
  UNIQUE INDEX `personID_UNIQUE` (`personID` ASC) ,
  CONSTRAINT `personID`
    FOREIGN KEY (`personID` )
    REFERENCES `mediapp`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`Tests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Tests` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Tests` (
  `idTests` INT NOT NULL AUTO_INCREMENT ,
  `suggested_Test` INT NULL ,
  `test_Result_Value` VARCHAR(45) NULL ,
  `test_Result_Unit` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTests`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`holiday_calendar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`holiday_calendar` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`holiday_calendar` (
  `idholiday_calendar` INT NOT NULL ,
  `idPerson` INT NULL ,
  `date_of_holiday` DATE NULL ,
  `start_time` TIME NULL ,
  `end_time` TIME NULL ,
  PRIMARY KEY (`idholiday_calendar`) ,
  INDEX `hcpersonID` (`idPerson` ASC) ,
  CONSTRAINT `hcpersonID`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediapp`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`icd_code_10`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`icd_code_10` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`icd_code_10` (
  `idicd_code_10` INT NOT NULL AUTO_INCREMENT ,
  `icd_10_code` VARCHAR(45) NULL ,
  `ccs_category` VARCHAR(10) NULL ,
  `ccs_label` VARCHAR(200) NULL ,
  `icd_10_label` VARCHAR(1000) NULL ,
  PRIMARY KEY (`idicd_code_10`) ,
  UNIQUE INDEX `idicd_code_10_UNIQUE` (`idicd_code_10` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`schedule_job`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`schedule_job` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`schedule_job` (
  `idschedule_job` INT NOT NULL AUTO_INCREMENT ,
  `action` VARCHAR(100) NULL ,
  `comments` VARCHAR(4500) NULL ,
  PRIMARY KEY (`idschedule_job`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`job_inputs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`job_inputs` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`job_inputs` (
  `idjob_inputs` INT NOT NULL ,
  `idschedule_job` INT NULL ,
  `input_parmeter_name` VARCHAR(100) NULL ,
  `input_paramenter_id` VARCHAR(100) NULL ,
  `process_indicator` VARCHAR(45) NULL DEFAULT 'N' ,
  PRIMARY KEY (`idjob_inputs`) ,
  INDEX `idScheduleJob` (`idschedule_job` ASC) ,
  CONSTRAINT `idScheduleJob`
    FOREIGN KEY (`idschedule_job` )
    REFERENCES `mediapp`.`schedule_job` (`idschedule_job` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`sequence_data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`sequence_data` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`sequence_data` (
  `sequence_name` VARCHAR(100) NOT NULL ,
  `sequence_increment` INT(11) NOT NULL DEFAULT 1 ,
  `sequence_min_value` INT(11) NOT NULL DEFAULT 1 ,
  `sequence_max_value` BIGINT(20) NOT NULL DEFAULT 100000000 ,
  `sequence_cur_value` BIGINT(20) NOT NULL DEFAULT 1 ,
  `sequence_cycle` TINYINT(1) NOT NULL DEFAULT FALSE ,
  PRIMARY KEY (`sequence_name`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- function nextval
-- -----------------------------------------------------

DELIMITER $$
DROP function IF EXISTS `mediapp`.`nextval` $$
 CREATE FUNCTION `mediapp`.`nextval` (`seq_name` varchar(100)) 
 RETURNS bigint(20) NOT DETERMINISTIC 
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
 END;
 $$

-- -----------------------------------------------------
-- function currval
-- -----------------------------------------------------
DROP function IF EXISTS `mediapp`.`currval` $$
 CREATE FUNCTION `mediapp`.`currval` (`seq_name` varchar(100)) 
 RETURNS bigint(20) NOT DETERMINISTIC 
 BEGIN    
 DECLARE cur_val bigint(20);
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp.sequence_data     
 WHERE        
 sequence_name = seq_name;    
 RETURN cur_val; 
 END;
$$

-- -----------------------------------------------------
-- function bulknextval
-- -----------------------------------------------------
DROP function IF EXISTS `mediapp`.`bulknextval` $$
CREATE FUNCTION `mediapp`.`bulknextval` (`seq_name` varchar(100), `incrementamt` bigint(20)) 
RETURNS bigint(20) NOT DETERMINISTIC 
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
 (sequence_cur_value + (sequence_increment*incrementamt)) > sequence_max_value,                 
 IF (                     
 sequence_cycle = TRUE,                     
 sequence_min_value,                     
 NULL                
 ),                 
 sequence_cur_value + (sequence_increment*incrementamt)            
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
