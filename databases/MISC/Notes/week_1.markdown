
# Business Rules

## Excercise 1

- There are many departments in our organisation.
- A department may employ many employees.
- A department must employ at least one employee.
- Each employee must be employed by only one department.

Include the cardinality rule that one of the employees is the manager of a
department and there could be a department without a manager.

- Each department may or may not have one manger.
- A manager must only manage a single department.
- Each manager is an employee.
- Each employee may or may not be a manager.

            +------------+                       +----------+
    -----O|-| Department |-||---< employs >---|<-| Employee |-|O-----
    |       +------------+                       +----------+       |
    |                                                               |
    ----------------------------< manages >--------------------------

    
### Department Table
    
    +---------+------+----------+--------------+
    | ID (PK) | Name | Location | Manager (FK) |
    +---------+------+----------+--------------+

### Employee Table 

    +---------+------+---------+-----------------+
    | ID (PK) | Name | Address | Department (FK) |
    +---------+------+---------+-----------------+

### Composite Table

    +-------------------+-----------------+
    | DepartmentID (PK) | EmployeeID (PK) |
    +-------------------+-----------------+

### Joining Tables
    
    SELECT department.Name, employee.Name
    FROM department, employee, dep_emp
    WHERE
        department.ID = dep_emp.DepartmentID AND
        employee.ID = dep_emp.EmployeeID 

### Without Using Composite Table

    SELECT department.Name, employee.Name
    FROM department, employee
    WHERE department.Manager = employee.ID




