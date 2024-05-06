/* INIT bank */

Drop table bankdata; drop table accounts;

Create table bankdata (totalassets int, deposits int, cash int);
Create table accounts (name char(60), id int, balance int)

Insert into accounts values ('turing', 1, 300);
Insert into accounts values ('neumann', 2, 200);

Insert into bankdata (deposits, cash)
values ((select sum(balance) from accounts), 250);

select * from accounts;
select * from bankdata;