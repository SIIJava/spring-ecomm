'use strict';

app.factory('ProduitService', ['$http', '$q', function($http, $q){
	
	return {
		
		fetchProduitList: function(){
			return $http.get('http://localhost:8080/produits')
				.then(
						function(response){
							return response.data;				
						}, 
						function(errResponse){
							console.error("Erreur d'acces a la lsite des produits")
							return $q.reject(errResponse);
						}
				);
		},
	
		fetchSpecificProduit: function(id){
			return $http.get('http://localhost:8080/produit/'+id)
				.then(
						function(response){
							return response.data;
						},
						function(errResponse){
							console.log("Erreur produit");
							return $q.reject(errResponse);
						}
				);
		},
		
		fetchBetweenProduit: function(min, max){
			return $http.get('http://localhost:8080/produits/min/'+min+'/max/'+max)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.log("Erreur produit");
						return $q.reject(errResponse);
					}		
			)
		}
	};
}])