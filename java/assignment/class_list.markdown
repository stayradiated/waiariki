
# Class list

## Employee

__attributes__

- \- id (int)
- \- age (int)
- \- duties (int)
- \- gender (char)
- \- name (String)

__methods__

- \+ serialize
- \+ getId
- \+ setId
- \+ getAge
- \+ setAge
- \+ getDuties
- \+ setDuties
- \+ getGender
- \+ setGender
- \+ getName
- \+ setName

## Employees

__attributes__

- \- employee (ArrayList)
- \- nextId (int)
- \- max (int)
- \+ length (int)

__methods__

- \+ add
- \+ has
- \+ get
- \+ at
- \+ remove
- \+ inAgeGroup
- \+ withMostDuties
- \+ withNoDuties
- \+ write
- \+ read
- \+ fileExists
- \+ isFull
- \+ serialize
- \- error
- \- stringify
- \- parse

## Question

__attributes__

- \- text (String)
- \- type (String)
- \- length (int)

__methods__

- \+ ask
- \+ getText
- \+ setText
- \+ getType
- \+ setType

## Questions

__attributes__

- \- scanner (Scanner)
- \- questions (Question[])
- \- maxLength (int)

__methods__

- \+ ask
- \- calculateMaxLength

## Table

__attributes__

- \- columns (TableColumn[])
- \- rows (String[][])
- \- width (int)

__methods__

- \+ print
- \+ addRows

## TableColumn

__attributes__

- \- width (int)
- \- name (string)

__methods__

- \+ getWidth
- \+ setWidth
- \+ getName
- \+ setName

## Title

__attributes__

- \- title (String)
- \- table (Table)

__methods__

- \+ print
- \+ setTitle
- \- createTable

## TUI

__attributes__

- \- scanner (Scanner)
- \- employees (Employees)

__methods__

- \+ menu
- \+ add
- \+ delete
- \+ modify
- \+ listAll
- \+ listSingle
- \+ listAgeGroup
- \+ showMostDuties
- \+ showNoDuties
- \+ exit
- \- setEmployee
- \- write
- \- numberOfEmployees
- \- printEmployeeDetails
- \- readInt
- \- waitForUser
- \- print