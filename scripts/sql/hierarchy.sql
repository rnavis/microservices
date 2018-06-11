Create table Employees
(
     empid int primary key identity,
     name nvarchar(50),
     mgrid int foreign key references Employees(empid)
)
GO

Insert into Employees values ('John', NULL)
Insert into Employees values ('Mark', NULL)
Insert into Employees values ('Steve', NULL)
Insert into Employees values ('Tom', NULL)
Insert into Employees values ('Lara', NULL)
Insert into Employees values ('Simon', NULL)
Insert into Employees values ('David', NULL)
Insert into Employees values ('Ben', NULL)
Insert into Employees values ('Stacy', NULL)
Insert into Employees values ('Sam', NULL)
GO

Update Employees Set mgrid = 8 Where name IN ('Mark', 'Steve', 'Lara')
Update Employees Set mgrid = 2 Where name IN ('Stacy', 'Simon')
Update Employees Set mgrid = 3 Where name IN ('Tom')
Update Employees Set mgrid = 5 Where name IN ('John', 'Sam')
Update Employees Set mgrid = 4 Where name IN ('David')
GO

-- list all employees who are managers
select distinct e.empid, e.name
from employees e join employees m
on e.empid= m.mgrid
go

-- list all managers with atleast 2 employees
with mgrs as (
select m.mgrid from employees e join
employees m
on e.empid= m.mgrid
group by m.mgrid having count(m.empid)>=2)
select mg.empid, mg.name from employees mg join mgrs on mg.empid= mgrs.mgrid

-- print hierarchy of employee id

select m.empid,m.mgrid
from employees e join employees m on e.empid= m.mgrid
where e.empid=1


-- get all the empids, their name and their mgr ids
with alls as (
    select empid,name,mgrid
    from employees where empid=4
union all
   select e.empid,e.name, e.mgrid
    from employees e join alls m
    on e.empid = m.mgrid
)
select * from alls

-- get all the empids, their name and their mgr names. if no manager say, ceo!
with alls as (
    select empid,name,mgrid
    from employees where empid=4
union all
   select e.empid,e.name, e.mgrid
    from employees e join alls m
    on e.empid = m.mgrid
)
select a.name, isnull(b.name, 'CEO') from alls a
left join alls b
on a.mgrid = b.empid
go