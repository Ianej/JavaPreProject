#Создание таблицы users
#CREATE TABLE `testdb`.`users` (
#  `id` INT NOT NULL AUTO_INCREMENT,
#  `name` VARCHAR(45) NOT NULL,
#  `lastName` VARCHAR(45) NOT NULL,
#  `age` INT(3) NOT NULL,
#  PRIMARY KEY (`id`))
#ENGINE = InnoDB
#DEFAULT CHARACTER SET = utf8;

#Добавление записи в таблицу users
insert into users (name, lastname, age) values ('n1','l1',99);
#Получить все записи из таблицы users, где id = 3
select * from users;
#Получить все записи из таблицы users, где id = 3
select * from users where id = 3;
#Получить записи name, age из таблицы users, где id = 3
select name, age from users where id = 3;
#Обновить все записи name и age в таблице users
update users set name='UPn1', age=33;
#Обновить записи name и age в таблице users, где id = 3
update users set name='UPn2', age=33 where id = 3;
#Получить записи name, age из таблицы users, где name = 'UPn1'
select name, age from users where name = 'UPn1';
#Удалить все записи из таблицы users
delete from users;
#Удалить все записи name, age из таблицы users, где id = 3
delete from users where id = 3;
