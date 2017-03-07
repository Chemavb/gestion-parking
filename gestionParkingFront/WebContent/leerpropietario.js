var app = angular.module('ParkingApp', [])
.controller("ParkingController", function($scope, $http) {
	
	var urlPropietario = 'http://localhost:8080/gestionParking/rest/propietario/';	
	var urlPropietarios = 'http://localhost:8080/gestionParking/rest/propietarios';	
	
	// ******* Funciones varias....
	
	function _success(response){
		alert(response);
	}
	
	function _error(response){
		console.log(response.statusText);
		alert("ERROR: " + response.statusText);
	}
	
// ****************************************************************************
	
	//HTTP GET: Recuperar propietario a partir del DNI
	
	$scope.load_propietario = function(){
		$http.get(urlPropietario + $scope.dni)
		.success(function(response){
			$scope.propietario = response;
		}, function errorCallback(response){
			
			alert(response.statusText);
			
		})
	}
	
});