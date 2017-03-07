var app = angular.module('ParkingApp', [])
.controller("ParkingController", function($scope, $http) {
	
	var urlReserva = 'http://localhost:8080/gestionParking/rest/reserva/';	
	var urlReservas = 'http://localhost:8080/gestionParking/rest/reservas';	
	var urlPropietario = 'http://localhost:8080/gestionParking/rest/propietario/';	
	var urlPropietarios = 'http://localhost:8080/gestionParking/rest/propietarios';	
	var urlPlazaDisponible = 'http://localhost:8080/gestionParking/rest/plazasdisponiblespropietario/';	

	
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
		console.log("DNI: "+$scope.dni)
		$http.get(urlPropietario + $scope.dni)
		.success(function(response){
			$scope.propietario = response;
			console.log("PROPIETARIO: "+$scope.propietario)
			
			$scope.nuevaReserva["propietario"] = $scope.propietario;
			console.log("Propietario " + $scope.propietario);
			// TODO Esto con plaza existente
			$scope.nuevaReserva["plaza"] = $scope.plazasDisponiblesPropietario;
			terminar_reserva();
			console.log($scope.nuevaReserva);
			alta_reserva2();
			
		}, function errorCallback(response){
			
			alert(response.statusText);
			
		})
	}
	
	$scope.buscar_plazas_propietario = function(){
		$http.get(urlPlazaDisponible+$scope.dni+"&"+$scope.inicio+"&"+$scope.fin)
		.success(function(response){
			$scope.plazasDisponiblesPropietario = response;

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
	
	terminar_reserva = function() {
		console.log("Terminamos reserva");
		$scope.nuevaReserva["codigo"] = $scope.codigo;
		$scope.nuevaReserva["observaciones"] = $scope.observaciones;
		$scope.nuevaReserva["fecha"] = "2016-09-30";
		$scope.nuevaReserva["inicio"] = $scope.inicio;
		$scope.nuevaReserva["fin"] = "2016-09-30";
		
		
	}
	
	
	
});