-- --------------------------------------------------------------------------------
-- Routine DDL
-- --------------------------------------------------------------------------------
DELIMITER //

CREATE DEFINER=`root`@`localhost` FUNCTION `mediapp`.`bulknextval`(`seq_name` varchar(100), `incrementamt` bigint(20)) RETURNS bigint(20)
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
 (sequence_cur_value + sequence_increment*incrementamt) > sequence_max_value,                 
 IF (                     
 sequence_cycle = TRUE,                     
 sequence_min_value,                     
 NULL                
 ),                 
 sequence_cur_value + sequence_increment*incrementamt             
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
END//
