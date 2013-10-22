
# Normalisation

There are six normal forms.

- First normal form
- Second normal form
- Third normal form
- Fourth normal form
- BCNF normal form
- Fith normal form

## First normal form

Every attribute value must be a atomic.

    +-------+---------+------------+-------+
    | ST_NO | ST_NAME | YEAR&GROUP | MARKS |
    +-------+---------+------------+-------+
    | 12345 | Jack    | 2,NDBC     | 78    |
    | 12346 | Jill    | 3,CBC      | 45    |
    | 12347 | Bill    | 4,CBC      | 89    |
    +-------+---------+------------+-------+

    +-------+---------+------+-------+-------+
    | ST_NO | ST_NAME | YEAR | GROUP | MARKS |
    +-------+---------+------+-------+-------+
    | 12345 | Jack    | 2    | NDBC  | 78    |
    | 12346 | Jill    | 3    | CBC   | 45    |
    | 12347 | Bill    | 4    | CBC   | 89    |
    +-------+---------+------+-------+-------+

## Second normal form

__Functional dependence__

The value of one attribute (the determinant) determines the value of
another attribute.

__Second normal form requirements__

- Must be in first normal form
- Every non-key attribute must be fully functionally dependent on the
  ENTIRE primary key.
    - Every non-key attribute must be defined by the entire key, not by a
      part of the key
    - No partial functional dependencies

_Example of partial dependency_

If you have a primary key that is not required to get the record.
    
    WRONG:
    +-----+-------+---------+-----------+
    | ID* | NAME* | ADDRESS | TELEPHONE |
    +-----+-------+---------+-----------+

    RIGHT:
    +-----+------+---------+-----------+
    | ID* | NAME | ADDRESS | TELEPHONE |
    +-----+------+---------+-----------+

    * = primary key

## Third normal form

A relation is in the third normal form if:

- it is in the second normal form
- there are no transitive dependencies

__Transitive dependency__

Sometimes a non-key attribute of a relation may determine the value of
another non key attribute.

    CITY_CODE is related to CITY
    
    **Suppier**
    +----+------+---------+-----------+
    | ID | NAME | CITY    | CITY_CODE |
    +----+------+---------+-----------+
    | S1 | John | Rotorua | 02        |
    | S2 | Bill | London  | 06        |
    | S3 | Mark | Rotorua | 02        |
    | S4 | Sam  | Rotorua | 02        |
    | S5 | Jill | London  | 06        |
    +----+------+---------+-----------+

_The solution is to split the table into two parts._

    **Supplier**                 **City Code**
    +----+------+-----------+    +-----------+---------+
    | ID | NAME | CITY_CODE |    | CITY_CODE | CITY    |
    +----+------+-----------+    +-----------+---------+
    | S1 | John | 02        |    | 02        | Rotorua |
    | S2 | Bill | 06        |    | 06        | London  |
    | S3 | Mark | 02        |    +-----------+---------+
    | S4 | Sam  | 02        |    
    | S5 | Jill | 06        |    
    +----+------+-----------+    

_Problems caused_

- __Insertion Anomaly__ Inserting the city code relies on the city

- Hard to lookup city code for a city, have to go through all the
  suppliers, possibly might not find a supplier in the city you are looking
  for 

- __Deletion Anomaly__ If the last supplier form a city is removed, then you lose information
  about a city

- __Updating Anomaly__ Have to update every supplier with the new city name,
  instead of just changing it once in the city table


## Boyce/Codd normal form

A relation is in Boyce/Codd normal form if and only if every determinant is a
canditate key.

## Fourth normal form

__Multivalued Dependency__
    
    +---------+-------------+----------------------+
    | Course* | Teacher*    | Text*                |
    +---------+-------------+----------------------+
    | Physics | Prof. Green | Basic Mechanics      |
    | Physics | Prof. Green | Principles of optics |
    | Physics | Prof. Brown | Basic Mechanics      |
    | Physics | Prof. Brown | Principles of optics |
    | Maths   | Prof. Green | Basic Mechanics      |
    | Maths   | Prof. Green | Vector Analysis      |
    | Maths   | Prof. Green | Trigonometry         |
    +---------+-------------+----------------------+

    +---------+-------------+    +---------+----------------------+
    | Course* | Teacher*    |    | Course* | Text*                |
    +---------+-------------+    +---------+----------------------+
    | Physics | Prof. Green |    | Physics | Basic Mechanics      |
    | Physics | Prof. Green |    | Physics | Principles of optics |
    | Physics | Prof. Brown |    | Physics | Basic Mechanics      |
    | Physics | Prof. Brown |    | Physics | Principles of optics |
    | Maths   | Prof. Green |    | Maths   | Basic Mechanics      |
    | Maths   | Prof. Green |    | Maths   | Vector Analysis      |
    | Maths   | Prof. Green |    | Maths   | Trigonometry         |
    +---------+-------------+    +---------+----------------------+


# Database Design

- Primary and Foreign keys
- Many records in tables _requires indexing_
- Too many tables
- Frequency of usage data
- Anomaly problems
- Long access time
- Too many joins
- Few records in tables _Tables might not be needed_

## Joining tables
    
    **DEPT**          **EMP**
    +----+-------+    +----+-------+----+
    | D# | Dname |    | E# | Ename | D# |
    +----+-------+    +----+-------+----+

    SELECT DEPT.Dname, EMP.Ename
    FROM DEPT, EMP
    WHERE DEPT.D#=EPM.D#

## Binary search

    1 2 3 4 5 6 7 8 9 10
    a b c d e f g h i j

    LOOK FOR f

    5 = e = TOO LOW
    8 = h = TOO HIGH
    7 = g = TOO HIGH
    6 = f = FOUND

## Anomalies

An error or inconsistency that could arise when a record is updated, deleted or
added.

There are three types of anomalies:

1. Insertion anomaly
2. Deletion anomaly
3. Updating anomaly

# Assignment

- Available on eCampus
- Will be given at next week
- Four weeks to complete...

__Send in questions before 4th September.__
__First part due on 18th september.__

_An initial list of entity types with definitions_

    +-------------+-----------------------------------+
    | Entity Type | Definition                        |
    +-------------+-----------------------------------+
    | Student     | A student is a person who has     |
    |             | enrolled in  a course at Waiariki |
    +-------------+-----------------------------------+

_Three ER diagrams_

Just have the tables that are needed for each process.

_An integrated ER diagram_

I think that this is just an ER diagram of all the tables...

_A list of operational business rules and referential integrity_

Link between private key and foreign key.
If a record is deleted in one table, what will happen to the other one?

    **DEPT**            **EMP**
    +----+----------+   +----+-------+----+
    | D# | Name     |   | E# | Name  | D# |
    +----+----------+   +----+-------+----+
    | 1  | Accounts |   | 1  | Don   | 1  |
    | 2  | Admin    |   | 2  | Peter | 2  |
    | 3  | Comp     |   | 3  | Jane  | 2  |
    | 4  | Services |   | 4  | Pat   | 4  |
    +----+----------+   | 5  | Kate  | 5  | <- DEPT 5 doesn't exist!
                        +----+-------+----+
    
_Constraints_

Delete the child records

    ON DELETE CASCADE

Set the child records value to null

    ON DELETE SET NULL

Prevent deletion if their are child records

    ON DELETE RESTRICT

_Appendix_

Put the reponse from the client (Don) in here.
Easy way to get some marks...

# ERD Exercise

Tables

- Person
- Excavation
- Artefact
- Type

An excavation can have zero or many people working on it
A person can be working at zero or more excavations

An excavation can have zero or many artefacts
An artefact can have only one excavation

A type can have many artefacts
An artefact can have only one type
 
# Database Design

Adding value. The goal is money.
Increase productivity, satify customers > more money.

__Planning__

- Type of database
- Cost
- Required skills
- Users _who they are, what they can do, access levels_

__Identify Requirements__

- Strategic planning goals
- Risks
- Identify basic forms and reports

- Identify users
- Identify data items to be stored
- Desing the classes/tables and relationships
- Identify business constraints
- Verify the design matches the business rules
- Study transactions and information flow

- Ask questions, and more questions

Talk about the business, daily activities, etc ...

- How does it fit in?
- Number of users _Many users, have to balance the load_
- Goals
- Expected life, upgrades?

_End users_

- Primary job function, etc...

_Requirements_

- Data structures
    - Planning matrixes
    - Data flow diagrams

    Conceptual Design -> Logical Design -> Physical Design
