/**
 * Create a new view
 */

create view employee as
  select *
    from spj
    where s# = 'S1';


/**
 * Run the view
 */

select * from employee;


/**
 * Custom view
 */

create view supply_qty as
  select s#, qty
    from spj


select * from supply_qty

drop view supply_t_qty

create view supply_t_qty as
  select s.s#, sum(qty) as Total
  from s, spj
  where s.s# = spj.s#
  group by s.s#
  having sum(qty) > 2000

select * from supply_t_qty
