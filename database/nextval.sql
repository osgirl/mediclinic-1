-- --------------------------------------------------------------------------------
-- Routine DDL
-- --------------------------------------------------------------------------------
DELIMITER //

CREATE DEFINER=`root`@`localhost` FUNCTION `mediapp3`.`nextval`(`seq_name` varchar(100)) RETURNS bigint(20)
BEGIN    
 DECLARE cur_val bigint(20);
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp3.sequence_data     
 WHERE        
 sequence_name = seq_name;    
 IF cur_val IS NOT NULL THEN        
 UPDATE            
 mediapp3.sequence_data         
 SET            
 sequence_cur_value = IF (                 
 (sequence_cur_value + sequence_increment) > sequence_max_value,                 
 IF (                     
 sequence_cycle = TRUE,                     
 sequence_min_value,                     
 NULL                
 ),                 
 sequence_cur_value + sequence_increment             
 )         
 WHERE            
 sequence_name = seq_name         
 ;     
 END IF; 
  SELECT
 sequence_cur_value INTO cur_val     
 FROM        
 mediapp3.sequence_data     
 WHERE        
 sequence_name = seq_name;  
 RETURN cur_val; 
 END//
