DB
1) Open MySql CLC
2) mysql> create database db_example; -- Creates the new database
3) mysql> create user 'springuser'@'%' identified by 'ThePassword';-- Creates the user 
4) mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database



netstat -ano | findstr :8080
taskkill /PID {your process id} /F