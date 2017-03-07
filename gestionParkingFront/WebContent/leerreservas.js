var app = angular.module('ParkingApp', [])
.controller("ParkingController", function($scope, $http) {
	
	var urlReserva = 'http://localhost:8080/gestionParking/rest/reserva/';	
	var urlReservas = 'http://localhost:8080/gestionParking/rest/reservas';	
	
	// ******* Funciones varias....
	
	function _success(response){
		alert(response);
	}
	
	function _error(response){
		console.log(response.statusText);
		alert("ERROR: " + response.statusText);
	}
	
  // ****************************************************************************
	
	// HTTP GET: Recuperar la lista entera de propietarios
	

	$scope.load_reservas = function(){
		$http.get(urlReservas)
		.success(function(response){
			$scope.reservas = response;
		})
	}
	
});