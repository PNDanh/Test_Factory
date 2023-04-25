var myApp = angular.module("myApp", []);
myApp.controller("myCtrl", function ($http, $scope) {
    var api = "http://localhost:8080/baitest";

    $scope.listST = [];
    $http.get(api + "/listStatus")
        .then(function (Response) {
            $scope.listST = Response.data;
        })

    $scope.listCT = [];
    $http.get(api + "/listCategory")
        .then(function (Response) {
            $scope.listCT = Response.data;
        })

    $scope.listSCT = [];
    $http.get(api + "/listSubCategory")
        .then(function (Response) {
            $scope.listSCT = Response.data;
        })

    $scope.listBR = [];
    $http.get(api + "/listBrand")
        .then(function (Response) {
            $scope.listBR = Response.data;
        })

    $scope.listPR = [];
    $http.get(api)
        .then(function (Response) {
            $scope.listPR = Response.data;
        })

    $scope.product = {
        id: 0,
        productName: "",
        color: "",
        quantity: 0,
        sellPrice: 0.0,
        originPrice: 0.0,
        description: "",
        status: {
            id: 0,
            statusName: ""
        },
        subCategory: {
            id: 0,
            subCateCode: "",
            subCateName: "",
            category: {
                id: 0,
                cateCode: "",
                cateName: ""
            }
        },
        product_Brand: [
            {
                id: 0,
                brandName: ""
            }]
    }

    $scope.idCTadd = -1;
    $scope.add = function (event) {
        $http.post(api, $scope.product)
            .then(function () {
                alert("Thêm thành công")
                $scope.listPR.push($scope.product);
            })
    }

    $scope.productHT = {
        id: 0,
        productName: "",
        color: "",
        quantity: 0,
        sellPrice: 0.0,
        originPrice: 0.0,
        description: "",
        status: {
            id: 0,
            statusName: ""
        },
        subCategory: {
            id: 0,
            subCateCode: "",
            subCateName: "",
            category: {
                id: 0,
                cateCode: "",
                cateName: ""
            }
        },
        product_Brand: [
            {
                id: 0,
                brandName: ""
            }]
    }

    $scope.index = -1;
    $scope.idCTdt = -1;
    $scope.idSCTdt = -1;
    $scope.idBRdt = -1;

    $scope.detail = function (index) {
        $scope.index = index;
        $scope.idCTdt = $scope.listPR[$scope.index].subCategory.category.id;
        $scope.idSCTdt = $scope.listPR[$scope.index].subCategory.id;
        $scope.idBRdt = $scope.listPR[$scope.index].product_Brand[0].id;
        $scope.listSCTbyId = [];
        $http.get(api + "/listSubCategory/" + $scope.idCTdt)
            .then(function (Response) {
                $scope.listSCTbyId = Response.data;
            })

        $http.get(api + "/" + $scope.listPR[$scope.index].id)
            .then(function (Response) {
                $scope.productHT = Response.data;
            })
    }
    
    $scope.onClick = function (){
        $http.get(api + "/listBrand/"+$scope.idBRdt)
        .then(function (Response) {
            $scope.productHT.product_Brand[0].id = Response.data.id;
            $scope.productHT.product_Brand[0].brandName = Response.data.brandName;
            console.log($scope.productHT.product_Brand[0]);
        })
    }
    $scope.update = function (event) {
        console.log($scope.productHT);
        $http.put(api + "/" + $scope.listPR[$scope.index].id, $scope.productHT)
            .then(function () {
                $scope.listPR[$scope.index] = $scope.productHT;
                alert("Cập nhật thành công");
            })
    }

    $scope.delete = function (index) {
        $http.delete(api + "/" + $scope.listPR[index].id)
            .then(function () {
                alert("Xóa thành công")
                $scope.listPR.splice(index, 1);
            })
    }

    $scope.onChange = function (id) {
        $scope.listSCTbyId = [];
        $http.get(api + "/listSubCategory/" + id)
            .then(function (Response) {
                $scope.listSCTbyId = Response.data;
            })
    }
})
