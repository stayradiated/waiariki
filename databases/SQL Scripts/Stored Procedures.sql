use George;

/**
 * Create a Stored Procedure
 * -- Only needs to be run once --
 */

create procedure get_supplier_name( @sid varchar(2) ) as
begin
  select s.sname
  from s
  where s.s# = @sid
end

/**
 * Use the Stored Procedure
 */

exec get_supplier_name 'S1'
exec get_supplier_name 'S2'


/**
 * Create a Stored Function
 */

create function get_total_qty( @sid varchar(2) ) returns int
begin
  declare @total_qty int
  select @total_qty = sum( qty )
    from spj
    where s# = @sid
  return @total_qty
end

/**
 * Use the Stored Function
 */

select distinct s#, dbo.get_total_qty( s# )
  from spj;

select distinct sname, dbo.get_total_qty( spj.s# )
  from spj, s
  where spj.s# = s.s#;


/**
 * Deleting Stored Functions and Procedures
 */

drop function get_total_qty;
drop procedure get_supplier_name;
drop procedure get_supplier_qty;


/**
 * Custom Procedures and Functions
 */

create procedure get_supplier_qty( @sid varchar(2) ) as
begin
  select sname, sum(qty) as Total
  from spj, s
  where spj.s# = @sid and
  s.s# = @sid
  group by sname
end

exec get_supplier_qty 'S2'

create function get_supplier_qty( @sid varchar(2) ) returns int
begin
  declare @qty int
  select @qty = sum(qty)
    from spj
    where spj.s# = @sid
  return @qty
end

select distinct dbo.get_supplier_qty('S1') as Total
from spj;


/**
 * Describe the functionality of a stored procedure
 */

create procedure get_supplier_supplied_morethan( @qtysupp int) as
begin
  select sname, sum(qty) as Total
    from s, spj
    where s.s# = spj.s#
    group by sname
    having sum(qty) > @qtysupp;
end

exec get_supplier_supplied_morethan '2000'

-- sname | Total
-- ----- | -----
-- Adams | 3100
-- Jones | 3200

-- This procedure filters suppliers by those who supply a total quantity greather than @qtysupp, and then returns those suppliers names and total quantities.