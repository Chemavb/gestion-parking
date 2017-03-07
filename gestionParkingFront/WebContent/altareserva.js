var app = angular.module('ParkingApp', [])
.controller("ParkingController", function($scope, $http) {
	
	var urlReserva = 'http://localhost:8080/gestionParking/rest/reserva/';	
	var urlReservas = 'http://localhost:8080/gestionParking/rest/reservas';	
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
	
	load_propietario = function(){
		console.log("cargar propietario");
		$http.get(urlPropietario + $scope.nuevaReserva.propietario.dni)
		.success(function(response){
			$scope.propietario = response;
		}, function errorCallback(response){
			
			alert(response.statusText);
			
		})
	}
	
	// ****************************************************************************
	
	// HTTP POST: Dar de alta un propietario
	
	$scope.nuevaReserva = { codigo:"",
							propietario:{
								dni: ""
							},
							plaza: {},
							fecha: "",
							inicio: "",
							fin: "",
							observaciones: ""};
		
	
	$scope.alta_reserva1 = function() {
		console.log("entramos en alta reserva 1");
		load_propietario();
		$scope.nuevaReserva["propietario"] = $scope.propietario;
		$scope.nuevaReserva["plaza"] = $scope.propietario.plaza;
		
		console.log($scope.nuevaReserva);
		alta_reserva2();
	}
	
	alta_reserva2 = function(){
		console.log("entramos en alta reserva 2");
		$http(
				{
					method:'POST',
					url:urlReserva,
					data:angular.toJson($scope.nuevaReserva),
					headers:{
						'Content-Type': 'application/json'
					}
				}
		).then(_success, _error);
	}
	
});