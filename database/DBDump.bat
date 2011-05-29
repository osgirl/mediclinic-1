mysqldump -u root -p --password=123456 mediapp > backup.sql
mysqldump -u root -p --password=123456 mediapp --no-create-info  --no-create-db code_decode code_category> backup_codeDecode.sql
mysqldump -u root -p --password=123456 mediapp --no-data --routines --triggers> backup_schema.sql
pause