mysql -u root -p --password=123456 mediapp < create_tables.sql >t1.log
mysql -u root -p --password=123456 mediapp < Create_codeDecode.sql >>t1.log 
mysql -u root -p --password=123456 mediapp < log.sql >>t1.log
mysql -u root -p --password=123456 mediapp < currval.sql >>t1.log
mysql -u root -p --password=123456 mediapp < nextval.sql >>t1.log
mysql -u root -p --password=123456 mediapp < bulknextval.sql >>t1.log
mysql -u root -p --password=123456 mediapp< inboundTrigger.sql >>t1.log
pause