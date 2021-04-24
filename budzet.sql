create database home_budget character set utf8mb4 collate utf8mb4_polish_ci; 
USE home_budget;
INSERT INTO
	transaction(type,description,amount,date)
VALUES
	('przychód', 'wypłata', 3024, '2021-03-29'
	),('przychód', 'kasa od Malwy', 100, '2021-04-02'
	),('wydatek', 'osteopata', 100, '2021-04-14'
	),('wydatek', 'zakupy w Rewe', 46, '2021-04-15'
	),('wydatek', 'zmiana opon', 42, '2021-04-15'
	);