'use strict'

app.controller('ProduitListController', ['async', '$scope','ProduitService', function(async, $scope, ProduitService){
	
	
	console.log("produit list controller");
	var self = this;
	self.produits = async;
	
	$scope.listBetween = function(){
		console.log("between");
		self.produits = ProduitService.fetchProduitBetween($scope.min, $scope.max);
	}
}]);