var app = angular.module('ParkingApp', [])
.controller("ParkingController", function($scope, $http) {
	
	var urlPlazaDisponible = 'http://localhost:8080/gestionParking/rest/plazasdisponibles/';	
	
	// ******* Funciones varias....
	
	function _success(response){
		alert(response);
	}
	
	function _error(response){
		console.log(response.statusText);
		alert("ERROR: " + response.statusText);
	}
	

	$scope.buscar_plazas = function(){
		$http.get(urlPlazaDisponible+$scope.inicio+"&"+$scope.fin)
		.success(function(response){
			$scope.plazasDisponibles = response;
		})
	}
	
});