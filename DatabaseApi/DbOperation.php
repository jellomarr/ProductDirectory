<?php
 
class DbOperation
{
    //Database connection link
    private $con;
 
    //Class constructor
    function __construct()
    {
        //Getting the DbConnect.php file
        
        require_once 'DbConnect.php';
 
        //Creating a DbConnect object to connect to the database
        $db = new DbConnect();
 
        //Initializing our connection link of this class
        //by calling the method connect of DbConnect class
        $this->con = $db->connect();
	}
	
	
	/*
	* written for ease of coding the major SQL query
	*/
	function majorSQLQuery($conditionals){
		$majorSqlQuery = "SELECT Products.product_id, Products.product_name, Products.product_name, Products.price, Products.image_url, Products.weight, Products.width, Products.height, Products.feature, Products.description, GROUP_CONCAT(DISTINCT Store.store_name) as \"product_stores\", GROUP_CONCAT(DISTINCT Department.department_name) as \"product_departments\", GROUP_CONCAT(DISTINCT CONCAT_WS(\" \", Store.street_address, Store.postcode, Store.suburb, Store.State)) as \"store_address/es\", GROUP_CONCAT(DISTINCT Store.phone_number) as \"store_phone_number/s\", Department_Phone_Number.department_phone_number FROM Products LEFT JOIN Product_Department ON Products.product_id = Product_Department.product_id LEFT JOIN Department ON Product_Department.department_id = Department.department_id LEFT JOIN Location_Department ON Department.department_id = Location_Department.department_id_fk LEFT JOIN Department_Phone_Number ON Location_Department.department_phone_number_fk = Department_Phone_Number.department_phone_number_id LEFT JOIN Store ON Location_Department.store_id_fk = Store.store_id GROUP BY Products.product_id" ;

		$majorSqlQuery = $majorSqlQuery + " " + $conditionals + " GROUP BY Products.product_id";
        
		return $majorSqlQuery;

	}
	
	/*
	* The read operation for getting all the departments in HnG
	* When this method is called it is returning all the existing record of the database
	*/
	function getDepartments(){
		$stmt = $this->con->prepare("SELECT Department.department_name FROM Department");
		$stmt->execute();
		$stmt->bind_result($department_name);
		
		$departments = array(); 
		
		while($stmt->fetch()){
			$department  = array();
			$department["department_name"] = $department_name;
			array_push($departments, $department); 
		}
		
		return $departments; 
	}

	/*
	* The read operation for getting all the stores in the HnG chains
	* When this method is called it is returning all the existing record of stores
	*/

	function getStores(){
		$stmt = $this->con->prepare("SELECT Store.store_name FROM Store");
		$stmt->execute();
		$stmt->bind_result($store_name);
		
		$stores = array(); 
		
		while($stmt->fetch()){
			$store = array();
			$store["name"] = $store_name;
			array_push($stores, $store); 
		}
		
		return $stores; 
	}

	function getProductsKnowingStoreAndDepartmentAndProducts($product_name_search, $store_name_search, $department_search){

		$sql = "SELECT Products.product_id, Products.product_name, Products.price, Products.image_url, Products.weight, Products.width, Products.height, Products.feature, Products.description, GROUP_CONCAT(DISTINCT Store.store_name) as \"product_stores\", GROUP_CONCAT(DISTINCT Department.department_name) as \"product_departments\", GROUP_CONCAT(DISTINCT CONCAT_WS(\" \", Store.street_address, Store.postcode, Store.suburb, Store.State)) as \"store_addresses\", GROUP_CONCAT(DISTINCT Store.phone_number) as \"store_phone_numbers\", Department_Phone_Number.department_phone_number FROM Products LEFT JOIN Product_Department ON Products.product_id = Product_Department.product_id LEFT JOIN Department ON Product_Department.department_id = Department.department_id LEFT JOIN Location_Department ON Department.department_id = Location_Department.department_id_fk LEFT JOIN Department_Phone_Number ON Location_Department.department_phone_number_fk = Department_Phone_Number.department_phone_number_id LEFT JOIN Store ON Location_Department.store_id_fk = Store.store_id  WHERE Products.product_name LIKE CONCAT(?,'%') AND Store.store_name = ? AND Department.department_name = ? GROUP BY Products.product_id";
		$stmt = $this->con->prepare($sql);
		$stmt->bind_param("sss", $product_name_search, $store_name_search, $department_search);
		$stmt->execute();
		$stmt->bind_result($product_id, $product_name, $price, $image_url, $weight, $width, $height, $feature, $description, $product_stores, $product_departments, $store_addresses, $store_phone_numbers, $department_phone_number);

		$products = array();
		
		while($stmt->fetch()){
			$product = array();
			$product["product_id"] = $product_id;
			$product["product_name"] = $product_name;
			$product["price"] = $price;
			$product["image_url"] = $image_url;
			$product["weight"] = $weight;
			$product["width"] = $width;
			$product["feature"] = $feature;
			$product["height"] = $height;
			$product["description"] = $description;
			$product["product_stores"] = $product_stores;
			$product["product_departments"] = $product_departments;
			$product["store_addresses"] = $store_addresses;
			$product["store_phone_numbers"] = $store_phone_numbers;
			array_push($products, $product); 
		}
		
		return $products;
	}

	/*
	* The getProductsKnowingKeywords all good
	* When this method is called the record with the given id is updated with the new given values
	*/
   

	function getProductsKnowingProducts($product_name_search){

		$sql = "SELECT Products.product_id, Products.product_name, Products.price, Products.image_url, Products.weight, Products.width, Products.height, Products.feature, Products.description, GROUP_CONCAT(DISTINCT Store.store_name) as \"product_stores\", GROUP_CONCAT(DISTINCT Department.department_name) as \"product_departments\", GROUP_CONCAT(DISTINCT CONCAT_WS(\" \", Store.street_address, Store.postcode, Store.suburb, Store.State)) as \"store_addresses\", GROUP_CONCAT(DISTINCT Store.phone_number) as \"store_phone_numbers\", Department_Phone_Number.department_phone_number FROM Products LEFT JOIN Product_Department ON Products.product_id = Product_Department.product_id LEFT JOIN Department ON Product_Department.department_id = Department.department_id LEFT JOIN Location_Department ON Department.department_id = Location_Department.department_id_fk LEFT JOIN Department_Phone_Number ON Location_Department.department_phone_number_fk = Department_Phone_Number.department_phone_number_id LEFT JOIN Store ON Location_Department.store_id_fk = Store.store_id WHERE Products.product_name LIKE CONCAT(?,'%') GROUP BY Products.product_id";
		$stmt = $this->con->prepare($sql);
		$stmt->bind_param("s", $product_name_search);
		$stmt->execute();
		$stmt->bind_result($product_id, $product_name, $price, $image_url, $weight, $width, $height, $feature, $description, $product_stores, $product_departments, $store_addresses, $store_phone_numbers, $department_phone_number);

		$products = array();
		
		while($stmt->fetch()){
			$product = array();
			$product["product_id"] = $product_id;
			$product["product_name"] = $product_name;
			$product["price"] = $price;
			$product["image_url"] = $image_url;
			$product["weight"] = $weight;
			$product["width"] = $width;
			$product["feature"] = $feature;
			$product["height"] = $height;
			$product["description"] = $description;
			$product["product_stores"] = $product_stores;
			$product["product_departments"] = $product_departments;
			$product["store_addresses"] = $store_addresses;
			$product["store_phone_numbers"] = $store_phone_numbers;
			$product["department_phone_number"] = $department_phone_number;

			array_push($products, $product); 
		}
		
		return $products;
	}
	 

	function getProductsKnowingStore($store_name_search){
	    

		$sql = "SELECT Products.product_id, Products.product_name, Products.price, Products.image_url, Products.weight, Products.width, Products.height, Products.feature, Products.description, GROUP_CONCAT(DISTINCT Store.store_name) as \"product_stores\", GROUP_CONCAT(DISTINCT Department.department_name) as \"product_departments\", GROUP_CONCAT(DISTINCT CONCAT_WS(\" \", Store.street_address, Store.postcode, Store.suburb, Store.State)) as \"store_addresses\", GROUP_CONCAT(DISTINCT Store.phone_number) as \"store_phone_numbers\", Department_Phone_Number.department_phone_number FROM Products LEFT JOIN Product_Department ON Products.product_id = Product_Department.product_id LEFT JOIN Department ON Product_Department.department_id = Department.department_id LEFT JOIN Location_Department ON Department.department_id = Location_Department.department_id_fk LEFT JOIN Department_Phone_Number ON Location_Department.department_phone_number_fk = Department_Phone_Number.department_phone_number_id LEFT JOIN Store ON Location_Department.store_id_fk = Store.store_id  WHERE Store.store_name = ? GROUP BY Products.product_id";
		$stmt = $this->con->prepare($sql);
		$stmt->bind_param("s", $store_name_search);
		$stmt->execute();
		$stmt->bind_result($product_id, $product_name, $price, $image_url, $weight, $width, $height, $feature, $description, $product_stores, $product_departments, $store_addresses, $store_phone_numbers, $department_phone_number);

		$products = array();
		
		while($stmt->fetch()){
			$product = array();
			$product["product_id"] = $product_id;
			$product["product_name"] = $product_name;
			$product["price"] = $price;
			$product["image_url"] = $image_url;
			$product["weight"] = $weight;
			$product["width"] = $width;
			$product["feature"] = $feature;
			$product["height"] = $height;
			$product["description"] = $description;
			$product["product_stores"] = $product_stores;
			$product["product_departments"] = $product_departments;
			$product["store_addresses"] = $store_addresses;
			$product["store_phone_numbers"] = $store_phone_numbers;
			$product["department_phone_number"] = $department_phone_number;
			array_push($products, $product); 
		}
		
		return $products;
	}

	function getProductsKnowingDepartment($department_name_search){

		$sql = "SELECT Products.product_id, Products.product_name, Products.price, Products.image_url, Products.weight, Products.width, Products.height, Products.feature, Products.description, GROUP_CONCAT(DISTINCT Store.store_name) as \"product_stores\", GROUP_CONCAT(DISTINCT Department.department_name) as \"product_departments\", GROUP_CONCAT(DISTINCT CONCAT_WS(\" \", Store.street_address, Store.postcode, Store.suburb, Store.State)) as \"store_addresses\", GROUP_CONCAT(DISTINCT Store.phone_number) as \"store_phone_numbers\", Department_Phone_Number.department_phone_number FROM Products LEFT JOIN Product_Department ON Products.product_id = Product_Department.product_id LEFT JOIN Department ON Product_Department.department_id = Department.department_id LEFT JOIN Location_Department ON Department.department_id = Location_Department.department_id_fk LEFT JOIN Department_Phone_Number ON Location_Department.department_phone_number_fk = Department_Phone_Number.department_phone_number_id LEFT JOIN Store ON Location_Department.store_id_fk = Store.store_id  WHERE Department.department_name = ? GROUP BY Products.product_id";
		$stmt = $this->con->prepare($sql);
		$stmt->bind_param("s", $department_name_search);
		$stmt->execute();
		$stmt->bind_result($product_id, $product_name, $price, $image_url, $weight, $width, $height, $feature, $description, $product_stores, $product_departments, $store_addresses, $store_phone_numbers, $department_phone_number);

		$products = array();
		
		while($stmt->fetch()){
			$product = array();
			$product["product_id"] = $product_id;
			$product["product_name"] = $product_name;
			$product["price"] = $price;
			$product["image_url"] = $image_url;
			$product["weight"] = $weight;
			$product["width"] = $width;
			$product["feature"] = $feature;
			$product["height"] = $height;
			$product["description"] = $description;
			$product["product_stores"] = $product_stores;
			$product["product_departments"] = $product_departments;
			$product["store_addresses"] = $store_addresses;
			$product["store_phone_numbers"] = $store_phone_numbers;
			$product["department_phone_number"] = $department_phone_number;
			array_push($products, $product); 
		}
		
		return $products;
	}

	/*
	* to be dealt with
	*/

	function getProductsKnowingProductsAndStore($product_name_search, $store_search){

		$sql = "SELECT Products.product_id, Products.product_name, Products.price, Products.image_url, Products.weight, Products.width, Products.height, Products.feature, Products.description, GROUP_CONCAT(DISTINCT Store.store_name) as \"product_stores\", GROUP_CONCAT(DISTINCT Department.department_name) as \"product_departments\", GROUP_CONCAT(DISTINCT CONCAT_WS(\" \", Store.street_address, Store.postcode, Store.suburb, Store.State)) as \"store_addresses\", GROUP_CONCAT(DISTINCT Store.phone_number) as \"store_phone_numbers\", Department_Phone_Number.department_phone_number FROM Products LEFT JOIN Product_Department ON Products.product_id = Product_Department.product_id LEFT JOIN Department ON Product_Department.department_id = Department.department_id LEFT JOIN Location_Department ON Department.department_id = Location_Department.department_id_fk LEFT JOIN Department_Phone_Number ON Location_Department.department_phone_number_fk = Department_Phone_Number.department_phone_number_id LEFT JOIN Store ON Location_Department.store_id_fk = Store.store_id  WHERE Products.product_name LIKE CONCAT(?,'%') AND Store.store_name = ? GROUP BY Products.product_id";
		$stmt = $this->con->prepare($sql);
		$stmt->bind_param("ss", $product_name_search, $store_search);
		$stmt->execute();
		$stmt->bind_result($product_id, $product_name, $price, $image_url, $weight, $width, $height, $feature, $description, $product_stores, $product_departments, $store_addresses, $store_phone_numbers, $department_phone_number);

		$products = array();
		
		while($stmt->fetch()){
			$product = array();
			$product["product_id"] = $product_id;
			$product["product_name"] = $product_name;
			$product["price"] = $price;
			$product["image_url"] = $image_url;
			$product["weight"] = $weight;
			$product["width"] = $width;
			$product["feature"] = $feature;
			$product["height"] = $height;
			$product["description"] = $description;
			$product["product_stores"] = $product_stores;
			$product["product_departments"] = $product_departments;
			$product["store_addresses"] = $store_addresses;
			$product["store_phone_numbers"] = $store_phone_numbers;
			$product["department_phone_number"] = $department_phone_number;
			array_push($products, $product); 
		}
		
		return $products;


	}
	
	function getProductsKnowingStoreAndDepartment($store_name_search, $department_search){

		$sql = "SELECT Products.product_id, Products.product_name, Products.price, Products.image_url, Products.weight, Products.width, Products.height, Products.feature, Products.description, GROUP_CONCAT(DISTINCT Store.store_name) as \"product_stores\", GROUP_CONCAT(DISTINCT Department.department_name) as \"product_departments\", GROUP_CONCAT(DISTINCT CONCAT_WS(\" \", Store.street_address, Store.postcode, Store.suburb, Store.State)) as \"store_addresses\", GROUP_CONCAT(DISTINCT Store.phone_number) as \"store_phone_numbers\", Department_Phone_Number.department_phone_number FROM Products LEFT JOIN Product_Department ON Products.product_id = Product_Department.product_id LEFT JOIN Department ON Product_Department.department_id = Department.department_id LEFT JOIN Location_Department ON Department.department_id = Location_Department.department_id_fk LEFT JOIN Department_Phone_Number ON Location_Department.department_phone_number_fk = Department_Phone_Number.department_phone_number_id LEFT JOIN Store ON Location_Department.store_id_fk = Store.store_id  WHERE Store.store_name = ? AND Department.department_name = ? GROUP BY Products.product_id";
		$stmt = $this->con->prepare($sql);
		$stmt->bind_param("ss", $store_name_search, $department_search);
		$stmt->execute();
		$stmt->bind_result($product_id, $product_name, $price, $image_url, $weight, $width, $height, $feature, $description, $product_stores, $product_departments, $store_addresses, $store_phone_numbers, $department_phone_number);

		$products = array();
		
		while($stmt->fetch()){
			$product = array();
			$product["product_id"] = $product_id;
			$product["product_name"] = $product_name;
			$product["price"] = $price;
			$product["image_url"] = $image_url;
			$product["weight"] = $weight;
			$product["width"] = $width;
			$product["feature"] = $feature;
			$product["height"] = $height;
			$product["description"] = $description;
			$product["product_stores"] = $product_stores;
			$product["product_departments"] = $product_departments;
			$product["store_addresses"] = $store_addresses;
			$product["store_phone_numbers"] = $store_phone_numbers;
			$product["department_phone_numbers"] = $department_phone_number;
			array_push($products, $product); 
		}
		
		return $products;
	}

	function getProductsKnowingProductAndDepartment($product_name_search, $department_search){

		$sql = "SELECT Products.product_id, Products.product_name, Products.price, Products.image_url, Products.weight, Products.width, Products.height, Products.feature, Products.description, GROUP_CONCAT(DISTINCT Store.store_name) as \"product_stores\", GROUP_CONCAT(DISTINCT Department.department_name) as \"product_departments\", GROUP_CONCAT(DISTINCT CONCAT_WS(\" \", Store.street_address, Store.postcode, Store.suburb, Store.State)) as \"store_addresses\", GROUP_CONCAT(DISTINCT Store.phone_number) as \"store_phone_numbers\", Department_Phone_Number.department_phone_number FROM Products LEFT JOIN Product_Department ON Products.product_id = Product_Department.product_id LEFT JOIN Department ON Product_Department.department_id = Department.department_id LEFT JOIN Location_Department ON Department.department_id = Location_Department.department_id_fk LEFT JOIN Department_Phone_Number ON Location_Department.department_phone_number_fk = Department_Phone_Number.department_phone_number_id LEFT JOIN Store ON Location_Department.store_id_fk = Store.store_id  WHERE Products.product_name LIKE CONCAT(?,'%') AND Department.department_name = ? GROUP BY Products.product_id";
		$stmt = $this->con->prepare($sql);
		$stmt->bind_param("ss", $product_name_search, $department_search);
		$stmt->execute();
		$stmt->bind_result($product_id, $product_name, $price, $image_url, $weight, $width, $height, $feature, $description, $product_stores, $product_departments, $store_addresses, $store_phone_numbers, $department_phone_number);

		$products = array();
		
		while($stmt->fetch()){
			$product = array();
			$product["product_id"] = $product_id;
			$product["product_name"] = $product_name;
			$product["price"] = $price;
			$product["image_url"] = $image_url;
			$product["weight"] = $weight;
			$product["width"] = $width;
			$product["feature"] = $feature;
			$product["height"] = $height;
			$product["description"] = $description;
			$product["product_stores"] = $product_stores;
			$product["product_departments"] = $product_departments;
			$product["store_addresses"] = $store_addresses;
			$product["store_phone_numbers"] = $store_phone_numbers;
			$product["department_phone_number"] = $department_phone_number;
			array_push($products, $product); 
		}
		
		return $products;
	}


}