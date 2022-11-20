# JDBC
1. Склонировать заготовку с репозитория
2. Настроить соединение с БД в Util
3. Реализовать методы DAO слоя в UserDaoJDBCImpl
4. Реализовать методы Service слоя в UserServiceImpl
5. Реализовать алгоритм работы программы в Main
6. Залить программу на свой собственный репозиторий

Алгоритм работы программы:
- создать таблицу пользователей
- сохранить несколько пользователей в таблицу
- удалить 1 пользователя по id
- получить всех пользователей
- очистить таблицу пользователей

В качестве БД использовать Postgres
Драйвер работы с БД Postgres добавить в POM в виде зависимости

Проверить работоспособность методов можно с помощью запусков автотестов.