(function() {
    "use strict";

    angular.module("todoApp")
        .controller("TodoCtrl", ["$window", "$http", "$routeParams", "$location", TodoCtrl]);

    function TodoCtrl($window, $http, $routeParams, $location) {
        var BASE_URL = 'http://localhost:8080'
        var vm = this
       	vm.currentTodo = {}

       	if(isEdit()){
       		getTodo()
       	}else{
       		loadTodos()
       	}
       	

       	vm.saveTodo = saveTodo
       	vm.deleteTodo = deleteTodo
       	vm.openEdit = openEdit
       	vm.updateStatus = updateStatus

        vm.todos = []
        
        function isEdit(){
        	return $routeParams.id ? true : false
        }


        function loadTodos(){
        	$http.get(BASE_URL + "/todo").then(function(response){
        		vm.todos = response.data
        	});
        }

        function getTodo(){
        	$http.get(BASE_URL + "/todo/" + $routeParams.id).then(function(response){
        		vm.currentTodo = response.data
        	});
        }
        
        function saveTodo(isValid){
        	if(isValid){
        		if(!vm.currentTodo.id){
	        		create()
	        	}else{
	        		update()	
	        	}
        	}
        }

        function openEdit(id){
        	$location.path("/edit/" + id)
        }

        function create(){
        	$http.post(BASE_URL + "/todo", vm.currentTodo).then(successMessage, errorMessage);
        }

        function update(){
        	$http.put(BASE_URL + "/todo/" + vm.currentTodo.id, vm.currentTodo).then(successMessage, errorMessage);
        }


        function deleteTodo(id){
        	if(confirm("Você tem certeza que deseja deletar essa tarefa?")){
        		$http.delete(BASE_URL + "/todo/" + id).then(deleteSuccess, errorMessage)
        	}
        }

        function updateStatus(index, value){
//        	debugger
        	vm.todos[index].completed = value
        	$http.put(BASE_URL + "/todo/" + vm.todos[index].id, vm.todos[index]).then(function (){}, errorMessage);

        }

        function deleteSuccess(){
        	alert("Tarefa deletada com sucesso")
        	loadTodos()
        }

        function successMessage(){
        	alert("Tarefa salva com sucesso")
        	$location.path("/list")
        }

        function errorMessage(){
        	alert("Ops, ocorreu um erro, estamos trabalhando para corrigí-lo!")
        }


    }

})();