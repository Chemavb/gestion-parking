var app = angular.module('ParkingApp', [])
.controller("ParkingController", function($scope, $http) {
	
	var urlReserva = 'http://localhost:8080/gestionParking/rest/reserva/';	
	var urlReservas = 'http://localhost:8080/gestionParking/rest/reverva';	
	
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
	
	$scope.delete_reserva = function(){
		$http(
		{
			method: 'DELETE',
			url: urlReserva + $scope.codigo
		}		
		
		).then(_success, _error);
	}
	
});