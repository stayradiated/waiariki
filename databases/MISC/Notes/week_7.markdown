# Business Rules

## Cardinality Rules

This specifies the number of one entity that can be associated with each instance of another entity.

## Structural Assertion

Structural assertion is a statement that expresses some aspect of the static structure of the organisation.

_Examples:_

- Definition of an entity (include scope?)
- Define attribute of an entity
- Definition of a fact (something to do with the structure)
- A fact designates subtype/supertype relationship

## Action Assertion

Actions deals with dynamic aspects of an organisation.

_Examples:_

- A course must have a course name (Something to do with actions).
- Students can not register for a course, if there is no teacher to teach the course.


## Actions

    ON DELETE CASCADE

Will delete the dependent rows


    ON DELETE SET NULL

Will set foreign keys to null


    ON UPDATE CASCADE

Will update foreign keys with new value


## Integrity Constraints

The purpose of _integrity constraints_ in a relational DB is to maintain the accuracy of data.

Types of integrity constraints:

1. __Domain constraints:__ All the values under an attribute must be from the same domain.
2. __Entity Integrity:__ All primary key values are unique and not null
3. __Referential integrity:__ Each foreign key value in one relation (Table) must match a primary key value in another relation (table).
4. __Action assertions:__ A statement of a constraint or control on the actions of the organisation.

