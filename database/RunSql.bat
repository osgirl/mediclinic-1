set INPUT=
set /P INPUT=Type input: %=%
echo Running sql file : %INPUT%
mysql -u root -p --password=123456 mediapp < %INPUT% 
pause