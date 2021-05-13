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

#  PreparedStatment 

* Prepared statement is an interface available in java.sql.package
* Prepared statement is extending Statement Interface
	class PreparedStatement extends Statement{
	.......
	}
* Subclass of PreparedStatement interface is provided by Driver vendor 
* you can create a prepared statment object using the following method of Connection Interface
	public PreparedStatement prepareStatement(sql);
* you can call one of the following methods on prepared statement object to submit sql statments 
			public int executeUpdate()
			public ResultSet executeQuery()
			public boolean execute()
* using Single preparedstatement object you can submit only one sql statement


![alt text](https://github.com/RakeshGanapathy/rad/blob/master/Images/preparedstatments.PNG)

* when we submit the sql statement using prepared statement object then sql statement will be __compiled__ only once i.e first time and 
precompiled SQL statement will be executed every time.

TotalTime = request time +compile time +execution time +response 

	  = 5 + 5 + 5 + 5= 20 ms 
	 
First Time 		= 20ms

2nd onwards		= 5ms +0ms+5ms +5ms

			=15ms
			
100 sql statements 	= 20ms +99*15ms
			= 1505ms

* Prepared Statment gives you the place holder mechanism for providing the data dynamically to the sql statments. you need to use __?__ symbol for place holder 

* To provide the value for placeholder, you need to invoke the setter method depending on the placeholder data type.

				* public void setInt(int paramIndex, int val);
				* public void setString(int paramIndex, String val);
				* public void setLong(int paramIndex,long val);
				* public void setDouble(int paramIndex, double val);
				etc...

#  Callable Statement 

* CallableStatement is an interface available in java.sql.package.
* CallableStatement is extending PreparedStatement interface
* subclass of CallableStatement interface is provided by Driver vendor.
* you can create the Callable Statement object using the following methods of Connection interface 
		
		public CallableStatement prepareCall(sql)
		public CallableStatement prepareCall(sql,int,int)
		public CallableStatement prepareCall(sql,int,int,int)

* you can call the following method on CallableStatement object to submit the SQL Statement to Database
		
		public boolean execute()
		
* using the single CallableStatement Object,you can submit call to only one procedure 
	
	eg: 
	String sql = "callProc1(?,?)";
	CallableStatement cal = con.prepareCall(sql);
	cal.setInt(1,10);
	cal.setInt(2,20);
	cal.execute();
	
![alt text](https://github.com/RakeshGanapathy/rad/blob/master/Images/preparedstatments.PNG)
	
* when you submit the call to stored procedures using CallableStatement object thne pre compiled stored procedures will be executed directly 

	4 sqlStatements = 5 + 0 + 4*5  + 5 m = 30 ms

	4 SqlStatement *25 = 30*25 = 750ms 
	
* Callable statement gives you the place holder mechanism for providing the data dynamically to the procedure parameters , you need to invoke
the setter meethods depending on the placeholder data type.

				 public void setInt(int paramIndex, int val);
				 public void setString(int paramIndex, String val);
				 public void setLong(int paramIndex,long val);
				 public void setDouble(int paramIndex, double val);
				etc...

you need to use the following method to specify the OUT parameter 
	public void registerOutParameter(int parameterIndex,int sqlType)
		* sql type is a constant from java.sql.Types class

you can use getters
				 public void getInt(int paramIndex, int val);
				 public void getString(int paramIndex, String val);
				 public void getLong(int paramIndex,long val);
				 public void getDouble(int paramIndex, double val);
				
__Queries__

create table students(
studid int primary key,
studname varchar(10),
studemail varchar(10),
phone long);


delimiter $
create procedure insertStudentInfo(id int , name varchar(20),
mail varchar(20),phone long)
begin
insert into students values(id,name,mail,phone);
end;
$


create table studentsfee(
studid int primary key,
studname varchar(10),
fee float);


insert into studentsfee values(7,'farooq',256.45);


DROP PROCEDURE IF EXISTS updateInfo; 

delimiter $
create procedure updateInfo(id int , OUT name varchar(20),INOUT inc float)
begin
update studentsfee set fee=fee+inc where studid =id;
select studname,fee into name,inc from studentsfee where studid=id;
end;
$




