# JDBC STATEMENTS

there are 3 types of statements 
1. Statement
2. Prepared Statement
3. Callable Statement

# Query Execution 

we can use one of the following methods on Statment object to submit 
the SQL statement to Database:

* public int executeUpdate(String sql)
* public ResultSet executeQuery(String sql)
* public boolean execute(String sql)

__1.public int executeUpdate(String sql)__
	when you want to submit __INSERT__ or __UPDATE__ or __DELETE__ 	sql statements then use *executeUpdate()* which returns the 	*number of records* inserted or updated or deleted.

__2.public ResultSet executeQuery (Sting Sql)__
	when you want to submit __SELECT__ SQl statement then use 	*executeQuery* which return ResultSet object contains the records
	returned by the select statement

__3.public boolean execute(String sql)__
	when you want to submit __INSERT,UPDATE,DELETE or SELECT__ SQL 	statements then use *execute()* method which returns the boolean
	value.
	
    if execute() returns true - select SQL statement is submitted and ResultSet got created
    		call the getResultSet() which returns the ResultSet
    		public ResutlSet getResultSet()
    		
    if execute () returns false - INSERT,UPDATE,DELETE SQL statements are submitted and 
    		integer number is available (no of records inserted , updated or deleted)
		call getUpdateCount() which return the count
		public int getUpdateCount()

#	Statement 

Using the single statement object , you can submit any type of SQL 
statements and any number of SQL statements 

example:

	Statement statement= con.createStatement()
	String sql1="insert.."; String sql2="update...";
	String sql3="delete..";String sql4="select..";
	
	boolean status = statement.execute(sql1);
	int x= statement.executeUpdate(sql2);
	int y= statement.executeUpdate(Sql3);
	ResultSet rs= statement.executeQuery(sql4);
	
			

![alt text](https://github.com/RakeshGanapathy/rad/blob/master/Images/Statements.PNG)


When you submit the SQL statement using Statement Object then SQL
statement will be compiled and executed every time.

	
	

Total time 	= request time + compile time+execute time +response time 	= 5+5+5+5	= 20 ms

100 SQL query 		= 100*20  
Total time 		= 2000 ms


# MySQL queries

create table students(
studid int primary key,
studname varchar(10),
studemail varchar(10),
phone long);
