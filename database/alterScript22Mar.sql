SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE  TABLE IF NOT EXISTS `mediapp`.`holiday_calendar` (
  `idholiday_calendar` INT(11) NOT NULL ,
  `idPerson` INT(11) NULL DEFAULT NULL ,
  `date_of_holiday` DATE NULL DEFAULT NULL ,
  `start_time` TIME NULL DEFAULT NULL ,
  `end_time` TIME NULL DEFAULT NULL ,
  PRIMARY KEY (`idholiday_calendar`) ,
  INDEX `personID` (`idPerson` ASC) ,
  CONSTRAINT `personID`
    FOREIGN KEY (`idPerson` )
    REFERENCES `mediapp`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

ALTER TABLE `mediapp`.`Diagnosis` DROP COLUMN `follow_up_date` , DROP COLUMN `follow_up_id` , DROP COLUMN `follow_up_status` , DROP COLUMN `reference_doctor_id` , DROP COLUMN `share_status` ;

ALTER TABLE `mediapp`.`Patient_details` COMMENT = 'patient details' ;

ALTER TABLE `mediapp`.`doctor_details` DROP COLUMN `idSpecialization` , ADD COLUMN `friday_working` VARCHAR(1) NULL DEFAULT NULL  AFTER `idPerson` , ADD COLUMN `monday_working` VARCHAR(1) NULL DEFAULT NULL  AFTER `idPerson` , ADD COLUMN `saturday_working` VARCHAR(1) NULL DEFAULT NULL  AFTER `friday_working` , ADD COLUMN `specialization` VARCHAR(200) NULL DEFAULT NULL  AFTER `idPerson` , ADD COLUMN `sunday_working` VARCHAR(1) NULL DEFAULT NULL  AFTER `saturday_working` , ADD COLUMN `thursday_working` VARCHAR(1) NULL DEFAULT NULL  AFTER `monday_working` , ADD COLUMN `tuesday_working` VARCHAR(1) NULL DEFAULT NULL  AFTER `monday_working` , ADD COLUMN `wednesday_working` VARCHAR(1) NULL DEFAULT NULL  AFTER `tuesday_working` , ADD COLUMN `work_end_time` TIME NULL DEFAULT NULL  AFTER `specialization` , ADD COLUMN `work_start_time` TIME NULL DEFAULT NULL  AFTER `specialization` , COMMENT = 'doctor details' ;

ALTER TABLE `mediapp`.`Appointment_History` ADD COLUMN `follow_up_date` DATETIME NULL DEFAULT NULL  AFTER `proposed_reschedule_date` , ADD COLUMN `reference_doctor_id` INT(11) NULL DEFAULT NULL  AFTER `follow_up_date` , ADD COLUMN `time_of_appointment` TIME NULL DEFAULT NULL  AFTER `reference_doctor_id` , CHANGE COLUMN `date_of_appointment` `date_of_appointment` DATE NULL DEFAULT NULL  , 
  ADD CONSTRAINT `idReferenceDoctor`
  FOREIGN KEY (`reference_doctor_id` )
  REFERENCES `mediapp`.`Person` (`idPerson` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `idReferenceDoctor` (`reference_doctor_id` ASC) ;

ALTER TABLE `mediapp`.`Code_Decode` CHANGE COLUMN `code_val` `code_val` VARCHAR(200) NULL DEFAULT NULL  , CHANGE COLUMN `code_desc` `code_desc` VARCHAR(4000) NULL DEFAULT NULL  ; 
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

