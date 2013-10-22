
# Information Engineering Planning

## Strategic Planning Factors

- Organisational goals
- Critical success factors
- Problem areas

## Corporate Planning Objects

- Organisational units
- Locations
- Business functions
- Entity types

## Develop EER Model

- Functional decomposition
- Planning Matrices (Function-to-data entity, Location-to-function,
  Unit-to-function)
- Entity Relationship Diagram (ERD)

# Big Nowhere Real Estate

## List Strategic Planning Factors

## A functional decomposition diagram outlining the core processes for the application

## An initial list of entity types with brief definitions

## Draw one planning matrix


    Teachers ||--|< S_T >|--|| Students ||--|< S_C >|--|| Course

    +------------------+----------------+-----+--------+---------+
    |                  |  S_T | Student | S_C | Course | Teacher |
    +------------------+----------------+-----+--------+---------+
    | Prepare a        |      |         |     |        |         |
    | list of students |      |    X    |  X  |   X    |         |
    | in courses       |      |         |     |        |         | 
    +------------------+----------------+-----+--------+---------+


# Past Paper

## Figure 1

In the scenario, a client cannot rent more then one car. But the diagram limits
the number of cars a client can limit to one.

The diagram states that a car can have one or many clients, but in the scenario
a car can only have zero or one clients.

The limit of a required license is correct.

The cardinality of the client and license is correct.

---

## Figure 2

A client may rent zero or many cars, which is correct.

In the diagram the ownership of a license is limited to the clients renting a
car, but in the scenario it is the other way around.

Not all cars may have a client, but the diagram states every car will have a
client.

Client may not have a license, but the diagram states they will always have
one.

A license will always be owned by a client, but the diagram states that a
license may or may not belong to a client.




