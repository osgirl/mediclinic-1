mysqldump -u root -p --password=123456 mediapp > backup.sql
mysqldump -u root -p --password=123456 mediapp --no-data --routines --triggers> backup_schema.sql
pause