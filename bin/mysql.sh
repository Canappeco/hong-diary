CREATE TABLE t_diary
(
   id int auto_increment PRIMARY KEY,
   user_id varchar(50),
   content varchar(5000),
   image varchar(1000),
   video varchar(100),
   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   finish_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   is_deleted int default 0
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;