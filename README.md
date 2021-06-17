# Employee Database Management Application
<hr>

### Dependencies For This Project :
- MySQL Connector/Java Ver. 8.0.25                              --> (Available In Repository)
- MySQL Shell Ver. 8.0 And Its Workbench                        --> (Download Them [Here](https://dev.mysql.com/downloads/installer/))
- External Swing Toolkit Ver. 1.2.0 For JFrame Design(Optional) --> (Available In Repository)
<hr>

The purpose of creation of this project is to provide a media for all its users to interact with / manipulate a pre-defined SQL Table which functions by listing all details of each virtual employee which has been recorded in the database server(MySQL) through a graphical user interface application developed purely in Java using its own built-in gui design tool, most commonly referred to as "Swing" and an external API known as MySQL Connector/Java to establish a form of connection to the SQL table(JDBC).
<br>
The application itself currently supports three main features where they allow insertions, updates and deletion of a specific employee record found in the table, all to be done from within the displayed GUI, with the condition that each user has already defined their own tables with fixed names of its schema(SQL Package) and the table itself, which have been described in the database file in the contents of this repository.
<hr>

### How To Run This Project :
1. Clone This Repository
```
git clone https://github.com/edward556/OOP_Project.git
```
2. Navigate Into The Project's Java Package
```
cd .../OOP_Project/JDBC_GUI_Project/src/jdbc_gui_project
```
3. Make Sure That MySQL Server Is Running In Localhost(127.0.0.1) And Is Equipped With Schema And Table Names, Along With The Number Of Available Columns And Each Column's Name That Follows The Syntax In This Repository's SQL Database File !
4. Build And Run The Driver Class Which Opens The Application 
```
javac Main.java
java Main
```
<hr>

### Extras :
> During The Set Up Of MySQL Server, If The Specified ***Username***, ***Password*** And The Server's ***Port Number*** Is Different     Compared To The Ones Used In This Repository's `Main_App.java` Then Each User May Have To Manually Replace Them With Each Of Their Own MySQL Server's Details In Three Of The Class's String Attributes In `Main_App.java` Which Have Been Marked With Comments So That They Can Be Easily Found.
