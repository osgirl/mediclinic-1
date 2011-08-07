-- --------------------------------------------------------------------------------
-- Routine DDL
-- --------------------------------------------------------------------------------
DELIMITER //

CREATE DEFINER=`root`@`localhost` PROCEDURE `mediapp`.`log_insert`(in p_proc_id varchar(100),in p_debug_info text)
BEGIN
insert into log (pname,log_text,ptime)  values (p_proc_id,p_debug_info,now());
END//
