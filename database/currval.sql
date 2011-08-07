-- --------------------------------------------------------------------------------
-- Routine DDL
-- --------------------------------------------------------------------------------
DELIMITER //

CREATE DEFINER=`root`@`localhost` FUNCTION `mediapp`.`currval`(`seq_name` varchar(100)) RETURNS bigint(20)
BEGIN    
 DECLARE cur_val bigint(20); 
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp3.sequence_data     
 WHERE        
 sequence_name = seq_name;    
 RETURN cur_val; 
 END//
