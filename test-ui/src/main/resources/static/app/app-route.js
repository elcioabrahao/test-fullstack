
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {

	$stateProvider.state('app', {
		url: '/home',
		templateUrl: '/app/app-template.html',
		controller: 'MainController'
	});

	$stateProvider.state('user', {
		url: '/user',
		templateUrl: '/app/user-template.html',
		controller: 'AllUserController'
	});

	$stateProvider.state('add', {
		url: '/user/add',
		templateUrl: '/app/user-add-template.html',
		controller: 'UserAddController'
	});

	$stateProvider.state('edit', {
		url: '/user/edit',
		templateUrl: '/app/user-editar-template.html',
		controller: 'UserAddController'
	});


}]);