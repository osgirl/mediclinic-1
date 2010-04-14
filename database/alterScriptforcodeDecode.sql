ALTER TABLE `mediapp`.`code_decode` ADD COLUMN `description` VARCHAR(4000) NULL  AFTER `code_desc` ;
ALTER TABLE `mediapp`.`code_decode` CHANGE COLUMN `code_desc` `comment` VARCHAR(4000) NULL DEFAULT NULL  , CHANGE COLUMN `description` `code_desc` VARCHAR(4000) NULL DEFAULT NULL  ;
update code_decode set code_desc = code_val;