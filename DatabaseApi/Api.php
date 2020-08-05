<?php
 
    /*
	* Based on code from Belal Khan
	* website: www.simplifiedcoding.net 
	https://www.simplifiedcoding.net/android-mysql-tutorial-to-perform-basic-crud-operation/
	
	This mostly uses Khan's code, the only thing that has changed is the switch statements from lines 48- 217 to reflect the methods that are contained in DbOperation.php, which are all READ operations, as well as relevant error messages.
	*/

	//getting the dboperation class
	require_once 'DbOperation.php';

	//function validating all the paramters are available
	//we will pass the required parameters to this function 
	function isTheseParametersAvailable($params){
		//assuming all parameters are available 
		$available = true; 
		$missingparams = ""; 
		
		foreach($params as $param){
			if(!isset($_POST[$param]) || strlen($_POST[$param])<=0){
				$available = false; 
				$missingparams = $missingparams . ", " . $param; 
			}
		}
		
		//if parameters are missing 
		if(!$available){
			$response = array(); 
			$response['error'] = true; 
			$response['message'] = 'Parameters ' . substr($missingparams, 1, strlen($missingparams)) . ' missing';
			
			//displaying error
			echo json_encode($response);
			
			//stopping further execution
			die();
		}
	}
	
	//an array to display response
	$response = array();
	
	//if it is an api call 
	//that means a get parameter named api call is set in the URL 
	//and with this parameter we are concluding that it is an api call
	if(isset($_GET['apicall'])){
		
		switch($_GET['apicall']){
			
			//The following case statements are all READ operations.
		
			case 'getdepartment':
				$db = new DbOperation();
				$response['departments'] = $db->getDepartments();
				$response['error'] = false; 
				$response['message'] = 'Request successfully completed';
			break; 
						
			
			case 'getstores':
				
				$db = new DbOperation();
				$response['stores'] = $db->getStores();
				$response['error'] = false; 
				$response['message'] = 'Request successfully completed';

			break;
			
			//The following case statement is the basis of all the other case statements, with the only difference being the different methods used from DbOperation() and different status messages.
			case 'getproductsknowingproduct':
				$db = new DbOperation();
				// Checks if the parameter productsearchterm is set in the URL.
				if(isset($_GET['productsearchterm'])){
					$db = new DbOperation();
					if($db->getProductsKnowingProducts($_GET['productsearchterm'])){
						$response['products'] = $db->getProductsKnowingProducts($_GET['productsearchterm']);
						$response['error'] = false; 
						$response['message'] = 'products pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'products not pulled successfully';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'No products pulled, please provide an product';
				}

			break; 

			case 'getproductsknowingdepartment':
				$db = new DbOperation();
				
				if(isset($_GET['departmentsearchterm'])){
					$db = new DbOperation();
					if($db->getProductsKnowingDepartment($_GET['departmentsearchterm'])){
						$response['products'] = $db->getProductsKnowingDepartment($_GET['departmentsearchterm']);
						$response['error'] = false; 
						$response['message'] = 'products pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'products not pulled successfully';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'No products pulled, please provide an department';
				}

			break; 


			case 'getproductsknowingstores':
				if(isset($_GET['storesearchterm'])){
					$db = new DbOperation();
					if($db->getProductsKnowingStore($_GET['storesearchterm'])){
						$response['products'] = $db->getProductsKnowingStore($_GET['storesearchterm']);
						$response['error'] = false; 
						$response['message'] = 'products pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'products not pulled successfully';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'No products pulled, please provide an store location.';
				}

				

			break; 


			case 'getproductsknowingproductanddepartment':
				$db = new DbOperation();

				if (isset($_GET['productsearchterm']) and isset($_GET['departmentsearchterm'])) {
					$db = new DbOperation();
					if($db->getProductsKnowingProductAndDepartment($_GET['productsearchterm'], $_GET['departmentsearchterm'])){
						$response['products'] =$db->getProductsKnowingProductAndDepartment($_GET['productsearchterm'], $_GET['departmentsearchterm']);
						$response['message'] = 'products pulled successfully';
						$response['error'] = false; 
					}else{
						$response['error'] = true; 
						$response['message'] = 'products not pulled successfully';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'No products pulled, please provide an store location and department';
				}

			break; 

			break;
			
			case 'getproductsknowingproductandstores':
				$db = new DbOperation();

				if (isset($_GET['productsearchterm']) and isset($_GET['storesearchterm'])) {
					$db = new DbOperation();
					if($db->getProductsKnowingProductsAndStore($_GET['productsearchterm'], $_GET['storesearchterm'])){
						$response['products'] = $db->getProductsKnowingProductsAndStore($_GET['productsearchterm'], $_GET['storesearchterm']);
						$response['message'] = 'products pulled successfully';
						$response['error'] = false; 
					}else{
						$response['error'] = true; 
						$response['message'] = 'products not pulled successfully';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'No products pulled, please provide an product and store location';
				}

			break; 

			case 'getproductsknowingdepartmentandstores':
				$db = new DbOperation();

				if(isset($_GET['departmentsearchterm']) and isset($_GET['storesearchterm'])){
					$db = new DbOperation();
					if($db->getProductsKnowingStoreAndDepartment($_GET['storesearchterm'],$_GET['departmentsearchterm'])){
					    $response['products'] = $db->getProductsKnowingStoreAndDepartment($_GET['storesearchterm'],$_GET['departmentsearchterm']);
						$response['error'] = false; 
						$response['message'] = 'products pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'products not pulled successfully';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'No products pulled, please provide an department and store location';
				}

			break;
			
			case 'getproductsknowingproductanddepartmentandstores':
				$db = new DbOperation();

				if((isset($_GET['productsearchterm'])) and (isset($_GET['departmentsearchterm'])) and (isset($_GET['storesearchterm']))){
					$db = new DbOperation();
					$response['products'] = $db->getProductsKnowingStoreAndDepartmentAndProducts( $_GET['productsearchterm'], $_GET['storesearchterm'], $_GET['departmentsearchterm']);
					if($db->getProductsKnowingStoreAndDepartmentAndProducts($_GET['productsearchterm'], $_GET['storesearchterm'], $_GET['departmentsearchterm'])){
						$response['products'] = $db->getProductsKnowingStoreAndDepartmentAndProducts( $_GET['productsearchterm'], $_GET['storesearchterm'], $_GET['departmentsearchterm']);
						$response['error'] = false; 
						$response['message'] = 'products pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'products not pulled successfully';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'No products pulled, please provide an product name, department and store location';
				}

			break; 


		}
		
	}else{
		//if it is not api call 
		//pushing appropriate values to response array 
		$response['error'] = true; 
		$response['message'] = 'Invalid API Call';
	}
	
	//displaying the response in json structure 
	echo json_encode($response);
	
	
