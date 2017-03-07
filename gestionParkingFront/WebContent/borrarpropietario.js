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
	
	// HTTP DELETE: Eliminar propietario a partir de su DNI
	
	$scope.delete_propietario = function(){
		$http(
		{
			method: 'DELETE',
			url: urlPropietario + $scope.dni
		}		
		
		).then(_success, _error);
	}
	
});