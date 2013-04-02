angular.module('portal.services').factory('Users', ['$resource', '$http', function($resource, $http) {
    return $resource("/delegate/services/users");
}]);

angular.module('portal.controllers').controller('UsersListController', ['$scope', '$location', 'Users', function($scope, $location, Users) {
    $scope.users = Users.query();    
}]);