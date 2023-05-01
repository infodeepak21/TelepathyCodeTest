# TelepathyCodeTest

Steps how to run the program:

2 ways to run the program:

Option-1

open the eclipse or any development tool.
right click on project explore then click on import
search Maven and select as Existing Maven projects
after importing right on project select Maven and select update projects

ex- Maven>>update project

After builds successful right click on project select Run as and select  Run configurations


select java application go to (x)=Arguments sections under program arguments give the path of txt file (ex- D:\telepathy\meetingproblem\meetings.txt

 ex-Run as >> Run configurations>> java application >> x)=Arguments >> program arguments >> location of the meetings.txt file
 
 click on apply  
 
 click on run button.
 output would be display in console
 
 if wanted to test other parameter then update in meetings.txt save the file then open the RoomTest.java  and right click Run as >> java application
 output would be display in console
  
 
 example-1
in meetings.txt

09:00-10:00
10:00-11:00
 
 
Example2
09:00-10:00
09:30-11:00


Option-2

Unzip the given file.
go to unzip folder 
open the command prompt from here and type the below command to build and package application.
mvn clean install
once above command run successfully and it generates jar file.
to start the applications run the below command
java -cp target\planfinder-0.0.1-SNAPSHOT.jar planfinder.PlanFinderTest "Fully Qualified path for example-D:\telepathy\planfinder\plans.txt" email, voice, admin

 
