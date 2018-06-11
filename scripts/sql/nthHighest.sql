Create table Employees
(
     ID int primary key identity,
     FirstName nvarchar(50),
     LastName nvarchar(50),
     Gender nvarchar(50),
     Salary int,
     Department int
)
GO

Insert into Employees values ('Ben', 'Hoskins', 'Male', 70000, 1)
Insert into Employees values ('Mark', 'Hastings', 'Male', 60000,1)
Insert into Employees values ('Steve', 'Pound', 'Male', 45000,1)
Insert into Employees values ('Ben', 'Hoskins', 'Male', 70000,2)
Insert into Employees values ('Philip', 'Hastings', 'Male', 45000,2)
Insert into Employees values ('Mary', 'Lambeth', 'Female', 30000,2)
Insert into Employees values ('Valarie', 'Vikings', 'Female', 35000,1)
Insert into Employees values ('John', 'Stanmore', 'Male', 80000,1)
Insert into Employees values ('Gorg', 'Pore', 'Male', 2000,2)
GO

-- print all
select * from Employees order by salary
go

-- get nth max salary across all depts
with sals as (
select e.*, dense_rank() over (order by Salary asc) as 'rnk' from Employees e)
select sals.* from sals where sals.rnk =3
go



-- get nth max/min salary per dept
with byDept as (
select e.*, dense_rank() over (partition by department order by Salary desc) as 'rank' from Employees e)
select byDept.* from byDept where byDept.rank=1
go

-- get nth max/min salary per gender
with byGender as (

   select e.*, dense_rank() over(partition by Gender order by Salary desc) as 'rank' from Employees e)
   select byGender.* from byGender where byGender.gender='Female' and  byGender.rank = 1
go

-- get nth max/min salary per gender and dept
with byGenderAndDept as (
select e.*, dense_rank() over(partition by Gender,department order by Salary desc) as 'rank' from Employees e)
select byGenderAndDept.* from byGenderAndDept where byGenderAndDept.gender = 'Male' and byGenderAndDept.department =2
and rank =3
go