SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

ALTER TABLE `mediapp`.`Diagnosis` DROP COLUMN `follow_up_date` , DROP COLUMN `follow_up_id` , DROP COLUMN `follow_up_status` , DROP COLUMN `reference_doctor_id` , DROP COLUMN `share_status` ;

ALTER TABLE `mediapp`.`Patient_details` COMMENT = 'patient details' ;

ALTER TABLE `mediapp`.`doctor_details` COMMENT = 'doctor details' ;

ALTER TABLE `mediapp`.`Appointment_History` ADD COLUMN `follow_up_date` DATETIME NULL DEFAULT NULL  AFTER `proposed_reschedule_date` , ADD COLUMN `reference_doctor_id` INT(11) NULL DEFAULT NULL  AFTER `follow_up_date` , 
  ADD CONSTRAINT `idReferenceDoctor`
  FOREIGN KEY (`reference_doctor_id` )
  REFERENCES `mediapp`.`Person` (`idPerson` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `idReferenceDoctor` (`reference_doctor_id` ASC) ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
