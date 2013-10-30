# Data Warehousing

## Definition

**Data Warehouse**

A subject-oriented, integrated, time-variant, non-updatable collection of data used in support of management decision-making processes

- _Subject-oriented:_ e.g. customers, patients, students, products
- _Integrated:_ Consistent naming conventions, formats, encoding structures; from multiple data sources
- _Time-variant:_ Can study trends and changes
- _Nonupdatable:_ Read-only, periodically refreshed

**Data Mart**

A data warehouse that is limited in scope

## Need for Data Warehousing

- Integrated, company-wide view of high-quality information (from disparate databases).
- Separation of operational and informational systems and data (for improved performance).

- Operational System: e.g. table
- Informational System: e.g. graph

## Two Level Architecture

Periodic extraction -> data is not completely current in warehouse.

## Independent Data Mart

Seperate ETL for each independent data mart.

Data accesss complexity due to multiple data marts.

## Dependent data mart with operational data store

ODS provides option for obtaining current data.

## Data Characteristics

### Status vs Event Data

### Transient vs Periodic Data

**Transient Data**

Changes to existing records are written over previous records, thus destroying the previous data content.

**Periodic Data**

Data is never physically altered or deleted once they have been added to the store.

**Main Difference**

- Transient data is altered - Periodic data is never altered.
- Periodic data is used in data warehouses - Transient data is used in databases.

## Data Reconciliation

Typical operational data is:

- Transient – not historical
- Not normalized (perhaps due to denormalization for performance)
- Restricted in scope – not comprehensive
- Sometimes poor quality – inconsistencies and errors

After ETL, data should be:

- Detailed – not summarized yet
- Historical – periodic
- Normalized – 3rd normal form or higher
- Comprehensive – enterprise-wide perspective
- Quality controlled – accurate with full integrity


    +-----+------------+-------+
    | ID* | Date*      | Price |
    +-----+------------+-------+
    | 01  | 01/01/2012 | 4.83  |
    | 02  | 01/01/2012 | 3.47  |
    | 01  | 02/01/2012 | 4.85  |
    | 02  | 02/01/2012 | 3.50  |
    +-----+------------+-------+

## The ETL Process

The whole process is known as data reconciliation.

- Capture
- Scrub or data cleansing
- Transform
- Load and Index

**ETL = Extract, transform, and load**

**Capture**

extract...obtainign a snapshot of a chosen subset of the soure data for loading into the data warehouse.

_Static extract:_ capturing a snapshot of the source data at a point in time.

_Incremental extract:_ capturing changes that have occured since the last static extract.

**Scrub**

cleanse ... uses pattern recognition and AI techniques to upgrade data quality.

_Fixing errors:_ mispellings, erroneous dates, incorrect field usage, mismatched addresses, missing data, duplicate data, inconsistencies.

_Also:_ decoding reformatting, time stamping, conversion, key generation, merging, error detection/logging, locating missing data.

**Transform**

convert data from format of operational system to format of data warehouse.

_Record level:_

- _selection:_ data partitioning
- _joining:_ data combining
- _aggregation:_ data summarization

_Field level:_

- _single field:_ from one field to one field
- _multi field:_ from many fields to one, or one field to many.

**Load Index**

Place transformed data into the warehouse and create indexes.

_Refresh mode:_ bulk rewriting of target data at periodic intervals.

_Update mode:_ only changes in source data are written to data warehouse.

### Single Field Transformation

- In general – some transformation function translates data from old form to new form
- Algorithmic transformation uses a formula or logical expression
- Table lookup – another approach

### Multi Field Transformation

From many source fields to one target field

    Employee Name + Telephone No => Employee ID

From one source field to many target fields

    Product Code => Brand Name + Product Name

## Derived Data

**Objectives**

- Ease of use for decision support applications
- Fast response to predefined user queries
- Customized data for particular target audiences
- Ad-hoc query support
- Data mining capabilities

**Characteristics**

- Detailed (mostly periodic) data
- Aggregate (for summary)
- Distributed (to departmental servers)

**Star Schema**

Most common data model (also called “dimensional model”)

## Components of a Star Schema

1:N relationship between dimension tables and fact tables.

Fact tables contain factual or quantitative data.

Dimension tables contain descriptions about the subjects of the business.

Dimension tables are denormalized to maximize performance.

This is excellent for ad-hoc queries, but bad for online transaction processing.

## Issues Regarding Star Schema

_Dimension table keys must be surrogate (non-intelligent and non-business related), because:_

- Keys may change over time
- Length/format consistency

_Granularity of Fact Table – what level of detail do you want?_

- Transactional grain – finest level
- Aggregated grain – more summarized
- Finer grains => better market basket analysis capability
- Finer grain => more dimension tables, more rows in fact table

## The User Interface Metadata (data catalogue)

- Identify subjects of the data mart
- Identify dimensions and facts
- Indicate how data is derived from enterprise data warehouses, including derivation rules
- Indicate how data is derived from operational data store, including derivation rules
- Identify available reports and predefined queries
- Identify data analysis techniques (e.g. drill-down)
- Identify responsible people

## On-Line Analytical Processing (OLAP)

The use of a set of graphical tools that provides users with multidimensional views of their data and allows them to analyze the data using simple windowing techniques.

- Relational OLAP (ROLAP)
    - Traditional relational representation
- Multidimensional OLAP (MOLAP)
    - Cube structure
- OLAP Operations
    - Cube slicing – come up with 2-D view of data
    - Drill-down – going from summary to more detailed views

## Data Mining and Visualization

Knowledge discovery using a blend of statistical, AI, and computer graphics techniques

**Goals**

- Explain observed events or conditions
- Confirm hypotheses
- Explore data for new or unexpected relationships

**Techniques**

- Case-based reasoning
- Rule discovery
- Signal processing
- Neural nets
- Fractals

Data visualization – representing data in graphical/multimedia formats for analysis

