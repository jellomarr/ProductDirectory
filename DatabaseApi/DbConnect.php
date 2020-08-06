<?php 
	
	/*
	* Based on code created by Belal Khan
	* website: www.simplifiedcoding.net 
	https://www.simplifiedcoding.net/android-mysql-tutorial-to-perform-basic-crud-operation/
	
	The following code the same as Khan's, except for changing the directory path in line 27.
	*/
	
	//Class DbConnect
	class DbConnect
	{
		//Variable to store database link
		private $con;
	 
		//Class constructor
		function __construct()
		{
	 
		}
	 
		//This method will connect to the database
		function connect()
		{
			//Including the constants.php file to get the database constants
			include_once 'Constants.php';
	 
			//connecting to mysql database
			$this->con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
	 
			//Checking if any error occured while connecting
			if (mysqli_connect_errno()) {
				echo "Failed to connect to MySQL: " . mysqli_connect_error();
			}
	 
			//finally returning the connection link 
			return $this->con;
		}
	 
	}