DROP TABLE IF EXISTS tb_user;

CREATE TABLE tb_user (
id INT PRIMARY KEY auto_increment, 
username VARCHAR ( 20 ), 
PASSWORD VARCHAR ( 20 ), 
gender CHAR ( 1 ), 
addr VARCHAR ( 30 ) );

INSERT INTO tb_user VALUES ( 1, 'zhangsan', '123', '男', '北京' );
INSERT INTO tb_user VALUES ( 2, '李四', '234', '女', '天津' );
INSERT INTO tb_user VALUES ( 3, '王五', '11', '男', '西安' );