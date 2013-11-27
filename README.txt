##########################
##########################
\\ SAEED PATEL		//
// NOVEMBER 25, 2013	\\
\\ CS445: PROJECT	//
// HOSTEL 21 		\\
##########################
##########################





//NOTE// 
> The customer/user and booking data is saved into txt files namely 'customer.txt'
  and 'booking.txt' respectively. The filenames is hardcoded in main.
=============================
=============================
**//JUnit Tests commands\\**
====================================================
  //commmand//      ||     //Class to be tested//
====================================================		   

> make test_bed  		=> Bed.java, TestBed.java 
> make test_customer	=> Customer.java, TestCustomer.java
> make test_hostel		=> Hostel.java,	TestHostel.java
> make test_booking		=> Booking.java, TestBooking.java
> make test_result		=> Result.java, TestResult.java
> make test_search		=> Search.java, TestSearch.java
> make test_sort		=> Sort.java, TestSort.java
> make test_cmd			=> CmdParser.java, TestCmdParser.java

----------------------------------------------------------------------------------
=============================
**//TO RUN/EXIT MAIN PROGRAM\\**
=============================
> make main

=> To exit program, type "exit" or "quit"


===//**command line argument format/commands**\\====
##########################################################################################
IMPORTANT: Strictly follow the below format for the commands or the result will not to be 
	       as expected! I have tried to include a fair amount of exception handling, so
	       the program will rarely completely crash...but the behavior might be unexpected
	       All xml files must be present in the source/root folder of this program before 
	       loading it/inventory 
##########################################################################################

***User commands***
All data is saved in "customer.txt" file
When a user is added the program will check if a customer.txt file exists. If no, it will
just create a new file and add the user. If exists, it will look through the data and check
if a customer with the same email already exists. If not, it will add the new user. Else, it
will ask the admin to use the "user change" command instead

-> Use Case: Add User
   $ user add --first_name --last_name --email [ --cc_number --expiration_date --security_code --phone ]

--------------------------------------------------------------------------------------------
-> Use Case: Change User
   $ h21 user change --user_id [ --first_name --last_name --email [ --cc_number --expiration_date --security_code --phone ]]

---------------------------------------------------------------------------------------------
-> Use Case: View User
   $ h21 user view --email

============================================================================================
============================================================================================
***Admin commands***
All data is saved in txt files that are named after the city of a hostel
All inventory is sorted by date before writing to text file
In case of multiple locations, which the admin is given the cnoice if the city already
exists, to overwrite or create new location, each additional location for the same city
will have a digit at the end of its name. For example: chicago.txt, chicago1.txt

-> Use Case: Load hostel inventor(If data for the location already exists, program will
								 give an option to create new file, or use one of the 
								 existing files. Once the correponding 'int' is received
								 from user/admin input, the program will go through the 
								 existing inventory and find any repetitions. If repeated
								 inventory is found, the program will check if the existing
								 inventory is booked. If so, it will not overwrite. Otherwise
								 it will overwrite. At the end of the process, you will 
								 receive a status message stating how many overwrites were
								 performed and how many failed due to being booked)

   $ admin load 'myfilename.xml'      //Notice the single quotes, you NEED TO USE THEM!

--------------------------------------------------------------------------------------------
-> Use Case: Calculate occupancy for a location in a date range
	
	$ h21 admin occupancy --city "cityname" --start_date --end_date
--------------------------------------------------------------------------------------------
-> Use Case: Calculate revenue for a location a date range
	(The program will cound the number of bookings and cancellations for the given
	range. Additionally, for the bookings, it will display the total revenue collected
	from all of those bookings)
	
	$ h21 admin revenue --city "cityname" --start_date --end_date
	
============================================================================================
============================================================================================
***Search commands***

-> Use Case: Search in a date range without any argument given for number of beds
	(All the beds in the range will be displayed, sorted by price in ascending order)
	
   $ h21 search --city "cityname" --start_date --end_date  //Use the double quotes for city!
-------------------------------------------------------------------------------------------
-> Use Case: Search in a date range with an argument given for number of beds
	(When this commnand is used, the program will find all the possible beds in the
	range given with the condition that atleast/minimum the give --beds argument amount
	should be found. It then saves all the data in a Result object. The program then
	sorts the beds by price and pairs in groups of --beds. Any excess that do not form 
	a complete group will be discarded from the search result. Now, I know this is not the
	most practical solution, but it was the best I could in the time I had since the 
	professor said that we were only supposed to display the combination with the lowest
	total price)
	
   $ h21 search --city "cityname" --start_date --end_date --beds //Use the double quotes for city!

=============================================================================================
=============================================================================================
***Booking commands***
-> Use Case: Add/Create a new booking
	(All data will be saved in 'booking.txt'. The program verifies if the user exists and 
	if so processes the booking. If not, it will not process and display an error stating
	no user exists with the specified id. I forgot to add code to display the details of 
	the booking: id, customer name, total, etc, and I apologize for that! I hope its not 
	too big of a problem. Honestly it can be easily done, but since I am short on time
	I have to move on. For now, just refer to the 'booking.txt' file for details. Using the
	'book view' command below will give a nicely formatted details of a booking )
	
	$ h21 book add --search_id --user_id

---------------------------------------------------------------------------------------------
-> Use Case: View booking
   $ h21 book view --booking_id 

--------------------------------------------------------------------------------------------
-> Use Case: Cancel booking
	(When the cancel command is executed, the program will ask you for todays date. This
	is to test the late cancellation policy. Based on the policy hours of the location
	if the cancellation is considered late, the program will print out a simple statement
	"Late fee was charged!", and then proceed on to cancellation, ie, marking the data in
	booking.txt with a '*' meaning its cancelled. The data is not deleted as this will 
	allow the program to count the number of cancellations in a date range along with the
	revenue)
	
   $ h21 book cancel --booking_id



