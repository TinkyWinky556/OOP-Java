# Employee Database Manager Application
<hr>

### Dependencies For This Project :
- MySQL Connector/Java Ver. 8.0.25                              --> (Available In Repository)
- MySQL Shell Ver. 8.0 And Its Workbench                        --> (Download Them [Here](https://dev.mysql.com/downloads/installer/))
- External Swing Toolkit Ver. 1.2.0 For JFrame Design(Optional) --> (Available In Repository)
<hr>

The purpose of creation of this project is to provide a media for all its users to interact with / manipulate a pre-defined SQL Table which functions by listing all details of each virtual employee which has been recorded in the database server(MySQL RDBMS) through a graphical user interface application developed purely in Java using its own built-in gui design toolkit framework, most commonly referred to as "Swing" and an external API known as "MySQL Connector/Java" to establish a form of connection to the SQL table(JDBC).
<br>
The application itself currently supports three main features where they allow insertions, updates and deletion of a specific employee record found in the table, all to be done from within the displayed GUI, with the condition that each user has already defined their own tables with fixed names of its schema(SQL Package) and the table itself, which have been described in the database file in the contents of this repository.
<hr>

### How To Run This Project :
1. Clone This Repository 
```
git clone https://github.com/edward556/Employee-Database-Manager-Application.git
```
2. From The Local Environment Where The Repository Was Cloned, Navigate Into The Project's Java Package
```
cd .../Employee-Database-Manager-Application/JDBC_GUI_Project/src/jdbc_gui_project
```
3. Make Sure That MySQL Server Is Running In Localhost(127.0.0.1) And Is Equipped With Schema And Table Names, Along With The Number Of Available Columns And Each Column's Name That Follows The Syntax In This Repository's SQL Database File !
4. Compile And Run The Driver Class Which Opens The Application 
```
javac Main.java
java Main
```
<hr>

### Extras :
> During The Set Up Of MySQL Server, If The Specified ***Username***, ***Password*** And The Server's ***Port Number*** Is Different Compared To The Ones Used In This Repository's `Main_App.java` Then Each User May Have To Manually Replace Them With Each Of Their Own MySQL Server's Details In Three Of The Class's String Attributes In `Main_App.java` Which Have Been Marked With Comments So That They Can Be Easily Found.

> A Guide On Installing, Setting Up, Running, Creating Schema And Table Within The MySQL Prompt Interface :
> 1. Click On The Provided Link To MySQL Installer In This Repository.
> 2. Download The Folder "mysql-installer-community-8.0.25.0.msi".
> 3. Open It And Wait Until A Prompt Is Given.
> 4. Select "Developer Default" Type Of Server.
> 5. Skip All Supporting Files.
> 6. Select "Standalone MySQL Server" To Ease Server Configuration Within Operating System(Windows Only).
> 7. A Default Port Number Is Given, With The Value "3306". DO NOT MODIFY / CHANGE THIS.
> 8. Select "Legacy Authentication".
> 9. Set Both Username And Password Values For The Server As "root" and "12345". If These Values Are Modified, Make Sure To Apply The Same Changes In `Main_App.java`.
> 10. Create A New User Using The Details Which Have Been Specified Previously.
> 11. Click On "Execute".
> 12. Test The Server's Response By Clicking On "Check Connection".
> 13. If Everything Works Fine, Click On "Finish".
> 14. Both MySQL Shell(Ver. 8.0) And Its Workbench Will Be Opened. Select The Workbench For Convenience.
> 15. Select The Active Instance "Local Instance MySQL80".
> 16. Enter The Password From Which Has Been Set Previously.
> 17. Create A Schema And A Table By Following The DB Syntax In This Repository.

> If The Server Does Not Give A Response When Workbench Is Activated :
> 1. Go To Start --> Services.
> 2. Search The Thread "MySQL80".
> 3. Right Click On It, And Perform A Restart.
