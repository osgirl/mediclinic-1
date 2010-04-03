--------------Insert for sequence_data table--------------------

insert into sequence_data values ('seq_person_id',1,0,10000,0,0);


--------------Alter Scripts for the Phone Numbers----------------

alter table person modify mobile_phone_number VARCHAR(100);
alter table person modify landline_phone_number VARCHAR(100);