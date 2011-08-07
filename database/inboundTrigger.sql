-- Trigger DDL Statements
USE `mediapp`;
DELIMITER //

CREATE DEFINER=`root`@`localhost` TRIGGER trig_inbound_messages_insert BEFORE INSERT ON `inbound_messages` 
    FOR EACH ROW SET NEW.sent_date = NOW()//