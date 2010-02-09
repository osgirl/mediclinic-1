SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mediclinic` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

-- -----------------------------------------------------
-- Table `mediclinic`.`Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediclinic`.`Person` ;

CREATE  TABLE IF NOT EXISTS `mediclinic`.`Person` (
  `idPerson` INT NOT NULL ,
  `first_name` VARCHAR(45) NULL ,
  `last_name` VARCHAR(45) NULL ,
  `middle_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`idPerson`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediclinic`.`Patient_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediclinic`.`Patient_details` ;

CREATE  TABLE IF NOT EXISTS `mediclinic`.`Patient_details` (
  `idPatient_details` INT NOT NULL ,
  `idPerson` INT NULL ,
  `idPastHistory` INT NULL ,
  PRIMARY KEY (`idPatient_details`) ,
  INDEX `idPerson` (`idPerson` ASC) ,
  CONSTRAINT `idPerson`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediclinic`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'patient details';


-- -----------------------------------------------------
-- Table `mediclinic`.`doctor_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediclinic`.`doctor_details` ;

CREATE  TABLE IF NOT EXISTS `mediclinic`.`doctor_details` (
  `idDoctor_details` INT NOT NULL ,
  `idPerson` INT NULL ,
  `idSpecialization` INT NULL ,
  PRIMARY KEY (`idDoctor_details`) ,
  INDEX `idPerson` (`idPerson` ASC) ,
  CONSTRAINT `idPerson1`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediclinic`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'doctor details';


-- -----------------------------------------------------
-- Table `mediclinic`.`Diagnosis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediclinic`.`Diagnosis` ;

CREATE  TABLE IF NOT EXISTS `mediclinic`.`Diagnosis` (
  `idDiagnosis` INT NOT NULL ,
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
  PRIMARY KEY (`idDiagnosis`) ,
  INDEX `idAppointment` (`idAppointment` ASC) ,
  CONSTRAINT `idAppointment`
    FOREIGN KEY (`idAppointment` )
    REFERENCES `mediclinic`.`Appointment_History` (`idAppointment_History` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediclinic`.`Appointment_History`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mediclinic`.`Appointment_History` ;

CREATE  TABLE IF NOT EXISTS `mediclinic`.`Appointment_History` (
  `idAppointment_History` INT NOT NULL ,
  `idPatient_details` INT NULL ,
  `idDoctor_details` INT NULL ,
  `date_of_appointment` DATE NULL ,
  `idDiagnosis` INT NULL ,
  PRIMARY KEY (`idAppointment_History`) ,
  INDEX `idPatient` (`idPatient_details` ASC) ,
  INDEX `idDoctor` (`idDoctor_details` ASC) ,
  INDEX `idDiagnosis` (`idDiagnosis` ASC) ,
  CONSTRAINT `idPatient`
    FOREIGN KEY (`idPatient_details` )
    REFERENCES `mediclinic`.`Patient_details` (`idPatient_details` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDoctor`
    FOREIGN KEY (`idDoctor_details` )
    REFERENCES `mediclinic`.`doctor_details` (`idDoctor_details` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDiagnosis`
    FOREIGN KEY (`idDiagnosis` )
    REFERENCES `mediclinic`.`Diagnosis` (`idDiagnosis` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
