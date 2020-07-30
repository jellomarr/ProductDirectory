<?php
 
    /*
	* Based on code from Belal Khan
	* website: www.simplifiedcoding.net 
	https://www.simplifiedcoding.net/android-mysql-tutorial-to-perform-basic-crud-operation/
	
	Hans Magnaye: I have mostly used Khan's code, the only thing that I have changed is the switch statements from lines 48-? to reflect the methods that are contained in DbOperation.php
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
			
			//the READ operation
			//if the call is getheroes
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
			
			case 'getproductsknowingproduct':
				$db = new DbOperation();

				if(isset($_GET['productsearchterm'])){
					$db = new DbOperation();
					if($db->getProductsKnowingProducts($_GET['productsearchterm'])){
						$response['products'] = $db->getProductsKnowingProducts($_GET['productsearchterm']);
						$response['error'] = false; 
						$response['message'] = 'product pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'Some error occurred please try again';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nothing to delete, provide an product';
				}

			break; 

			case 'getproductsknowingdepartment':
				$db = new DbOperation();
				
				if(isset($_GET['departmentsearchterm'])){
					$db = new DbOperation();
					if($db->getProductsKnowingDepartment($_GET['departmentsearchterm'])){
						$response['products'] = $db->getProductsKnowingDepartment($_GET['departmentsearchterm']);
						$response['error'] = false; 
						$response['message'] = 'product pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'Some error occurred please try again';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nothing to delete, provide an product';
				}

			break; 


			case 'getproductsknowingstores':
				if(isset($_GET['storesearchterm'])){
					$db = new DbOperation();
					if($db->getProductsKnowingStore($_GET['storesearchterm'])){
						$response['products'] = $db->getProductsKnowingStore($_GET['storesearchterm']);
						$response['error'] = false; 
						$response['message'] = 'product pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'Some error occurred please try again';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nothing to delete, provide an product';
				}

				

			break; 


			case 'getproductsknowingproductanddepartment':
				$db = new DbOperation();

				if (isset($_GET['productsearchterm']) and isset($_GET['departmentsearchterm'])) {
					$db = new DbOperation();
					if($db->getProductsKnowingProductAndDepartment($_GET['productsearchterm'], $_GET['departmentsearchterm'])){
						$response['product'] =$db->getProductsKnowingProductAndDepartment($_GET['productsearchterm'], $_GET['departmentsearchterm']);
						$response['message'] = 'product pulled successfully';
						$response['error'] = false; 
					}else{
						$response['error'] = true; 
						$response['message'] = 'Some error occurred please try again';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nothing to delete, provide an product';
				}

			break; 

			break;
			
			case 'getproductsknowingproductandstores':
				$db = new DbOperation();

				if (isset($_GET['productsearchterm']) and isset($_GET['storesearchterm'])) {
					$db = new DbOperation();
					if($db->getProductsKnowingProductsAndStore($_GET['productsearchterm'], $_GET['storesearchterm'])){
						$response['product'] = $db->getProductsKnowingProductsAndStore($_GET['productsearchterm'], $_GET['storesearchterm']);
						$response['message'] = 'product pulled successfully';
						$response['error'] = false; 
					}else{
						$response['error'] = true; 
						$response['message'] = 'Some error occurred please try again';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nothing to delete, provide an product';
				}

			break; 

			case 'getproductsknowingdepartmentandstores':
				$db = new DbOperation();

				if(isset($_GET['departmentsearchterm']) and isset($_GET['storesearchterm'])){
					$db = new DbOperation();
					if($db->getProductsKnowingStoreAndDepartment($_GET['storesearchterm'],$_GET['departmentsearchterm'])){
					    $response['products'] = $db->getProductsKnowingStoreAndDepartment($_GET['storesearchterm'],$_GET['departmentsearchterm']);
						$response['error'] = false; 
						$response['message'] = 'product pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'Some error occurred please try again';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nothing to delete, provide an product';
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
						$response['message'] = 'product pulled successfully';
					}else{
						$response['error'] = true; 
						$response['message'] = 'Some error occurred please try again';
					}
				}else{
					$response['error'] = true; 
					$response['message'] = 'Nothing to delete, provide an product';
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
	
	
