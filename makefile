#
# This is a make file for compiling the java files
#

JCC = javac
JAR = junit-4.11.jar
JAR1 = hamcrest-core-1.3.jar
RUNNER = org.junit.runner.JUnitCore
CP = -cp

#
# This is the script for base program that executes 
# the main class Main.java
#

main: Bed.class Hostel.class Customer.class Booking.class Result.class CmdParser.class Search.class Sort.class TXTHandler.class ProcessBooking.class XMLParser.class Main.class
	java Main

Bed.class: Bed.java
	$(JCC) Bed.java

Booking.class: Booking.java
	$(JCC) Booking.java

CmdParser.class: CmdParser.java
	$(JCC) CmdParser.java

Customer.class: Customer.java
	$(JCC) Customer.java

Hostel.class: Hostel.java
	$(JCC) Hostel.java

ProcessBooking.class: ProcessBooking.java
	$(JCC) ProcessBooking.java

Result.class: Result.java
	$(JCC) Result.java

Search.class: Search.java
	$(JCC) Search.java

Sort.class: Sort.java
	$(JCC) Sort.java

TXTHandler.class: TXTHandler.java
	$(JCC) TXTHandler.java

XMLParser.class: XMLParser.java
	$(JCC) XMLParser.java

Main.class: Main.java
	$(JCC) Main.java

#
# This script will run the test for Bed class
#

test_bed: TestBed
	java $(CP) .:$(JAR):$(JAR1) $(RUNNER) TestBed

TestBed: Bed.java TestBed.java
	$(JCC) $(CP) .:$(JAR) Bed.java TestBed.java

#
# This script will run the test for the Hostel class
#

test_hostel: TestHostel
	java $(CP) .:$(JAR):$(JAR1) $(RUNNER) TestHostel

TestHostel: Hostel.java TestHostel.java
	$(JCC) $(CP) .:$(JAR) Hostel.java TestHostel.java



#
# This script will run the test for the Booking class
#

test_booking: TestBooking
	java $(CP) .:$(JAR):$(JAR1) $(RUNNER) TestBooking

TestBooking: Booking.java TestBooking.java
	$(JCC) $(CP) .:$(JAR) Booking.java TestBooking.java


#
# This script will run the test for the Customer class
#

test_customer: TestCustomer
	java $(CP) .:$(JAR):$(JAR1) $(RUNNER) TestCustomer

TestCustomer: Customer.java TestCustomer.java
	$(JCC) $(CP) .:$(JAR) Customer.java TestCustomer.java


#
# This script will run the test for the Result class
#

test_result: TestResult
	java $(CP) .:$(JAR):$(JAR1) $(RUNNER) TestResult

TestResult: Result.java TestResult.java
	$(JCC) $(CP) .:$(JAR) Result.java TestResult.java

#
# This script will run the test for the Search class
#

test_search: TestSearch
	java $(CP) .:$(JAR):$(JAR1) $(RUNNER) TestSearch

TestSearch: Search.java TestSearch.java
	$(JCC) $(CP) .:$(JAR) Search.java TestSearch.java


#
# This script will run the test for the Sort class
#

test_sort: TestSort
	java $(CP) .:$(JAR):$(JAR1) $(RUNNER) TestSort

TestSort: Sort.java TestSort.java
	$(JCC) $(CP) .:$(JAR) Sort.java TestSort.java

#
# This script will run the test for the CmdParser class
#

test_cmd: TestCMD
	java $(CP) .:$(JAR):$(JAR1) $(RUNNER) TestCmdParser

TestCMD: CmdParser.java TestCmdParser.java
	$(JCC) $(CP) .:$(JAR) CmdParser.java TestCmdParser.java


#
# Script for cleaning compiled .class files
#
clean:
	$(RM) *.class