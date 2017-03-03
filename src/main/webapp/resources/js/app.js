'use strict';

var app = angular.module('ecommocomApp', ['ui.router', 'ui.bootstrap']);

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

	$urlRouterProvider.otherwise("/seconde");

	$stateProvider
	.state('vente', {
		url: "/produits",
		templateUrl: 'resources/template/produits.html',
		controller : "ProduitListController as pdtListCtrl",
		resolve: {
			async: ['ProduitService', function(ProduitService){
				return ProduitService.fetchProduitList();
			}]
		}
	})
	.state('produit', {
		url: "/produit/produitId:^[1-9][0-9]{0,8}$",
		templateUrl: function(params){ return 'produit/'+params.produitId; },
		controller : "ProduitController as pdtCtrl",
		resolve: {
			async: ['ProduitService', '$stateParams', function(ProduitService, $stateParams){
				return ProduitService.fetchSpecificProduit($stateParams.produitId)
			}]
		}
	})
	.state('produitbetween', {
		url: "/produit/min/minValue:^[1-9][0-9]{0,8}$/max/maxValue:^[1-9][0-9]{0,8}$",
		templateUrl: 'resources/template/produits.html',
		controller : "ProduitBetweenController as pdtBtwnCtrl",
		resolve: {
			async: ['ProduitService', '$stateParams', function(ProduitService, $stateParams){
				return ProduitService.fetchBetweenProduit($stateParams.produitId)
			}]
		}
	});



}]);