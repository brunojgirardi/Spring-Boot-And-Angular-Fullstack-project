## database
Crie os usuário e banco necessários ao aplicativo

create user 'todoapp'@'localhost' identified by 'todoapp'
grant all on todo.* to 'todoapp'@'localhost'; 