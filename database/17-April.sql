ALTER TABLE `mediapp`.`appointment_history` ADD COLUMN `appointment_headline` VARCHAR(500) NULL  AFTER `time_of_appointment` , ADD COLUMN `appointment_comment` VARCHAR(4500) NULL  AFTER `appointment_headline` ;
ALTER TABLE `mediapp`.`appointment_history` ADD COLUMN `appointment_duration` TIME NULL  AFTER `appointment_comment` ;



