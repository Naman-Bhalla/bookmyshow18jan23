```

namanbhalla@Namans-Scaler-MacbookM1Pro-16 ~ % psql
psql (14.1)
Type "help" for help.

namanbhalla=# create database bookmyshow18jan23
namanbhalla-# ;
CREATE DATABASE
namanbhalla=# create user bookmyshow18jan23;
CREATE ROLE
namanbhalla=# grant all privileges on database bookmyshow18jan23 to user bookmyshow18jan23;
ERROR:  syntax error at or near "user"
LINE 1: ...t all privileges on database bookmyshow18jan23 to user bookm...
                                                             ^
namanbhalla=# grant all privileges on database bookmyshow18jan23 to bookmyshow18jan23;
GRANT
namanbhalla=#


```