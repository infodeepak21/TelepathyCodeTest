Steps how to run the program:

2 ways to run the program:

Option-1

open the eclipse or any development tool.
right click on project explore then click on import
search Maven and select as Existing Maven projects
after importing right on project select Maven and select update projects

ex- Maven>>update project

After builds successful right click on project select Run as and select  Run configurations


select java application go to (x)=Arguments sections under program arguments give the path of txt file (ex- D:\telepathy\planfinder\plans.txt

 ex-Run as >> Run configurations>> java application >> x)=Arguments >> program arguments >> location of the meetings.txt file with plans.
 
 (ex-D:\telepathy\planfinder\plans.txt email,voice,admin) 
 
 click on apply  
 
 click on run button.
 output would be display in console
 
 if wanted to test other parameter then update in plans.txt save the file then open the PlanFinderTest.java  and right click Run as >> java application
 output would be display in console
  
 
 example-1
 
PLAN1,100,voice,email
PLAN2,150,email,database,admin
PLAN3,125,voice,admin
PLAN4,135,database,admin


Option-2

Unzip the given file.
go to unzip folder 
open the command prompt from here and type the below command to build and package application.
mvn clean install
once above command run successfully and it generates jar file.
to start the applications run the below command
java -cp target\planfinder-0.0.1-SNAPSHOT.jar planfinder.PlanFinderTest "Fully Qualified path for example-D:\telepathy\planfinder\plans.txt" email, voice, admin
