ExcelEngin
==========
My aim is to create a jar application using Apache POI and Oracle Java Driver,
which will read Databse config (e.g IP, port, username and password, DB name)
and another config file (which will contain the SQL select query).
Runniing the jar will create an Excel file data filed with result returned from SQL query.

List of configurable parameters
--------------------------------

config.properties
------------------
Database IP Address,
Database Port,
Database Username,
Database Password,
Database Name,

application.properties
-----------------------
Report file name prefix (Timestamp will be added as specified like DD_MM_YYYY),
TimeStamp format,
SQL Query,
Path to save the Excel Report

Note :- Trying to make it compatable from Java version 1.5
