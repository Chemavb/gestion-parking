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
	
	// HTTP POST: Dar de alta un propietario
	
	$scope.nuevoPropietario = {	dni:"", 
								nombre:"", 
								apellido1:"",
								apellido2:"",
								telefonoFijo:"",
								telefonoMovil:"",
								email:"",
								direccion:"",
								numero:"",
								planta:"",
								puerta:"",
								plaza:{
									numero:"",
									planta: "",
									largo: "",
									ancho: "",
									bloqueada: "",
									observaciones: "",
								}
	
	}
	
	$scope.update_propietario = function(){
		
		$http(
				{
					method:'PUT',
					url:urlPropietario,
					data:angular.toJson($scope.nuevoPropietario),
					headers:{
						'Content-Type': 'application/json'
					}
				}
		).then(_success, _error);
	}
	
});