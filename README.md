Place your Readme.txt file here and explain how to run your java program and how to execute SQL scripts.

How to run the Java program:
1) Make sure Maven and Javac are setup as home variables. (https://youtu.be/6AVC3X88z6E) This is not necessary for certain IDEs such as IntelliJ.
1.5) Some team memebers require to turn on the UH VPN to full in order to run the application
2) Open the Project as [File >  New  > Project from Existing Sources...] with [Maven] as the external model.
2.1) When the project is opened, make sure the pom.xml is opened and contains the correct dependencies.
2.2) If the project is not reading Maven dependencies correctly, unlink Maven using the appropriate IDE build and rebuild the project. Follow 2.1) again.
2.3) Allow the application through your firewall. You may have to manually disable your firewall.
3) Set the project JDK. Any Java language 8+ should work but 11 is the most consistent.
4) Run the project. If the project can't be run through default settings, go to [SwiftDB Application>src>main>java>SwiftDatabaseApplication] and manually run the SwiftDatabaseApplication class or main method.
5) Open a browser of your choosing and to go localhost:8080.
5.1) If the program is throwing a localhost error, you may need to go to application.properties and add [server.port=8081] to a new line. Then, go to localhost:8081 in your URL.
6) Login using [ssu] as the username and [Houston28] as the password.
7) You can now use the application.


How to rebuild the database:
1) Connect to the appropriate server in SSMS. [COT-CIS3365-17]
2) Delete the [3365DB5] database by right clicking it and selecting OK after selecting [Close existing connections].
3) Recreate the database by right clicking the [Databases] directory, selecting [New Database...] and naming it 3365DB5.
4) Make sure the CSV files are located on your computer's C drive in a folder named [Data].
5) Run the query. The following lines are necessary at the beginning of every query.
USE [3365DB5];
GO
6) The output will say there is a duplicate error in Discussion Medium, but this has no effect on the data or application.
7) The code has now been loaded.

How to run queries:
1) Ensure that the database has been built.
2) Run the query.
