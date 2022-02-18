DB
1) Open MySql CLC
create database db_example;
create user 'springuser'@'%' identified by 'ThePassword';
grant all on db_example.* to 'springuser'@'%';



netstat -ano | findstr :8080
taskkill /PID {your process id} /F