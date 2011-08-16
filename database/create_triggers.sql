DELIMITER //

CREATE TRIGGER createrow AFTER INSERT ON person_package
  FOR EACH ROW BEGIN
  
    IF (NEW.package = 'Patient') THEN        
    	INSERT INTO patient_details SET idPerson = NEW.person_id
        on DUPLICATE KEY UPDATE idPerson = NEW.person_id;
    END IF;
    
    IF (NEW.package = 'Doctor') THEN
        
    	INSERT INTO doctor_details SET idPerson = NEW.person_id
        on DUPLICATE KEY UPDATE idPerson = NEW.person_id;
    END IF;
 
 END//
