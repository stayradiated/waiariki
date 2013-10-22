# Database Indexing

_Searching for data_

To get some benefit from indexing, you should have at least 20,000 records.

Index files are used to improve performance of SQL queries. The search arguments allow the optimiser to decide whether one or more existing indices to be used in searching.

## How does indexing work?

    SELECT * FROM SPJ WHERE J#='J2';

_Search for J2 records in SPJ table_

Slow mode: read one by one until the end of the record.

Indexes: sort the data and then use a binary search.

## Creating an index

    CREATE INDEX INDEX_SPJ_J# ON SPJ (J#);

