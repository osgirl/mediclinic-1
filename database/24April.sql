ALTER TABLE `mediapp`.`tests` ADD COLUMN `idAppointment` INT(11) NULL  AFTER `test_Result_Unit` ,   ADD CONSTRAINT `fAppointment`  FOREIGN KEY (`idAppointment` )  REFERENCES `mediapp`.`appointment_history` (`idAppointment_History` )  ON DELETE NO ACTION  ON UPDATE NO ACTION, ADD INDEX `fAppointment` (`idAppointment` ASC) ;
ALTER TABLE `mediapp`.`diagnosis` DROP COLUMN `idTests` ;
ALTER TABLE `mediapp`.`tests` DROP COLUMN `idAppointment` , DROP FOREIGN KEY `fAppointment` , DROP INDEX `fAppointment` ;
ALTER TABLE `mediapp`.`tests` ADD COLUMN `fDiagnosis` INT(11) NULL  AFTER `test_Result_Unit` , 
  ADD CONSTRAINT `fDiagnosis`
  FOREIGN KEY (`fDiagnosis` )
  REFERENCES `mediapp`.`diagnosis` (`idDiagnosis` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fDiagnosis` (`fDiagnosis` ASC) ;




