'use strict';

angular.module('test')
	.controller('MainController', ['$scope', '$state', '$http',function($scope, $state, $http){
		// do stuff
	}])
	.controller('AllUserController', function ($scope, $state, $http) {

		$scope.postResultMessage = '';

			var url = "http://localhost:5000/api/user";
			$http.get(url).then(function (response) {
				$scope.response = response.data
			}, function error(response) {
				$scope.postResultMessage = "Erro com status: " + response.statusText;
			});

	}).controller('UserAddController', function ($scope, $state, $http) {


	$scope.submitForm = function(){
		var url = "http://localhost:5000/api/user";

		var config = {
			headers : {
				'Accept': 'application/json'
			}
		}
		var data = {
			nome: $scope.nome,
			email: $scope.email,
			telefone: $scope.telefone,
			sexo: $scope.sexo
		};

		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Erro com status: " +  response.statusText;
		});

		$scope.nome = "";
		$scope.email = "";
		$scope.telefone = "";
		$scope.sexo = "";
	}
}).controller('UserUpdateController', function ($scope, $state, $http) {

	$scope.getUserById = function() {

		var id = $scope.idUser;
		var url = "http://localhost:5000/api/user/"+id;

		$http.get(url).then(function (response) {
			$scope.response = response.data
			$scope.nome = response.data.nome;
			$scope.email = response.data.email;
			$scope.telefone = response.data.telefone;
			$scope.sexo = response.data.sexo;
			$scope.id = response.data.id;
		}, function error(response) {
			$scope.postResultMessage = "Erro com status: " + response.statusText;
		});
	}

	$scope.updateUser = function(){
		var id = $scope.idUser;
		var url = "http://localhost:5000/api/user/"+id;

		var config = {
			headers : {
				'Accept': 'application/json'
			}
		}
		var data = {
			nome: $scope.nome,
			email: $scope.email,
			telefone: $scope.telefone,
			sexo: $scope.sexo
		};

		$http.put(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Erro com status: " +  response.statusText;
		});

		$scope.nome = "";
		$scope.email = "";
		$scope.telefone = "";
		$scope.sexo = "";
		$scope.id = "";
		$scope.userId = "";
	}

	$scope.deleteUser = function(){
		var id = $scope.idUser;
		var url = "http://localhost:5000/api/user/"+id;

		var config = {
			headers : {
				'Accept': 'application/json'
			}
		}
		var data = {};

		$http.delete(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Erro com status: " +  response.statusText;
		});

		$scope.nome = "";
		$scope.email = "";
		$scope.telefone = "";
		$scope.sexo = "";
		$scope.id = "";
		$scope.userId = "";
	}
});

