SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `mediapp` ;
CREATE SCHEMA IF NOT EXISTS `mediapp` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

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
  PRIMARY KEY (`idAddress`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Person` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Person` (
  `idPerson` INT NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(45) NULL ,
  `last_name` VARCHAR(45) NULL ,
  `middle_name` VARCHAR(45) NULL ,
  `idAddress` INT NULL ,
  `date_of_birth` DATE NULL ,
  `Gender` VARCHAR(1) NULL ,
  `landline_phone_number` INT NULL ,
  `mobile_phone_number` INT NULL ,
  `email_Address` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `status_of_account` VARCHAR(1) NULL ,
  `hint_question` VARCHAR(100) NULL ,
  `hint_answer` VARCHAR(100) NULL ,
  `person_type` VARCHAR(45) NULL ,
  PRIMARY KEY (`idPerson`) ,
  INDEX `idAddress` (`idAddress` ASC) ,
  UNIQUE INDEX `email_Address_UNIQUE` (`email_Address` ASC) ,
  CONSTRAINT `idAddress`
    FOREIGN KEY (`idAddress` )
    REFERENCES `mediapp`.`Address` (`idAddress` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `idSpecialization` INT NULL ,
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
  `follow_up_date` DATE NULL ,
  `follow_up_status` CHAR NULL ,
  `follow_up_id` INT NULL ,
  `reference_doctor_id` INT NULL ,
  `share_status` CHAR NULL ,
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
  `date_of_appointment` DATETIME NULL ,
  `idDiagnosis` INT NULL ,
  `appointment_set_by` VARCHAR(100) NULL ,
  `appointment_confirmation` CHAR NULL ,
  `proposed_reschedule_date` DATETIME NULL ,
  PRIMARY KEY (`idAppointment_History`) ,
  INDEX `idPatient` (`idPatient_details` ASC) ,
  INDEX `idDoctor` (`idDoctor_details` ASC) ,
  INDEX `idDiagnosis` (`idDiagnosis` ASC) ,
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
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediapp`.`Code_Decode`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Code_Decode` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Code_Decode` (
  `idCode_Decode` INT NOT NULL ,
  `code_ctg` VARCHAR(45) NULL ,
  `code_val` VARCHAR(10) NULL ,
  `code_desc` VARCHAR(100) NULL ,
  PRIMARY KEY (`idCode_Decode`) ,
  UNIQUE INDEX `idCode_Decode_UNIQUE` (`idCode_Decode` ASC) )
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
-- Table `mediapp`.`Calendar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediapp`.`Calendar` ;

CREATE  TABLE IF NOT EXISTS `mediapp`.`Calendar` (
  `idcalendar` INT NOT NULL AUTO_INCREMENT ,
  `cal_date` DATE NULL
  PRIMARY KEY (`idcalendar`) )
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mediapp`.`Code_Decode`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
insert into `mediapp`.`Code_Decode` (`idCode_Decode`, `code_ctg`, `code_val`, `code_desc`) values (1, 'PERSON_TY', 'Doctor', 'doctor');
insert into `mediapp`.`Code_Decode` (`idCode_Decode`, `code_ctg`, `code_val`, `code_desc`) values (2, 'PERSON_TY', 'Patient', 'patient');

COMMIT;
