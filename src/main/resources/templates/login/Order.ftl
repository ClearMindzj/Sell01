<!DOCTYPE html>
<html>
<head lang="en">


    <link rel="stylesheet" href="../../bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../Flat-UI-master/dist/css/flat-ui.min.css"/>
    <script src="../../Flat-UI-master/dist/js/vendor/jquery.min.js"></script>
    <script src="../../bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    <script src="../../Flat-UI-master/dist/js/flat-ui.min.js"></script>
    <title></title>
    <style>
        .row{
            margin-left: 20px;
            margin-right: 20px;;
        }
        .line-center{
            line-height:50px;
            text-align: center;
        }
        .row input{
            width: 50px;
        }
        .list-group-item:hover{
            background: #27ae60;

        }
        .list-group-item div:first-child:hover{

            cursor: pointer;
        }
    </style>
    <script>
        function myClick(n){
           location.href = "OrderInfo.ftl";
        }
        function btnClick(){
            alert("btn");
            return false;
        }
        $(function(){

        })
    </script>
</head>
 <body>
<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">这什么东西</span>
            </button>
            <a class="navbar-brand" href="/sell/buyer/product/list?categoryType=1">图书商城</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/sell/buyer/product/list?categoryType=1">首页</a></li>
                <li><a href="/sell/buyer/order/listC?userId=${(user.userId)!}">我的订单</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <#if Session["user"]?exists>
                    <li>欢迎您：${user.username}<a href="/sell/seller/login/loginOut">注销</a></li>
                <#else>
                    <li><a href="/sell/seller/login/start">登录</a></li>
                </#if>
                <li><a href="/sell/seller/login/registerInit">注册</a></li>
                <li>
                    <a href="/sell/buyer/cart/list?userId=${(user.userId)!}"><span class="glyphicon glyphicon-shopping-cart">购物车</span></a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<!--content-->
<div class="container">
    <div class="row thumbnail center">
        <div class="col-sm-12">
            <h1 class="text-center" style="margin-bottom: 30px">我的订单</h1>
        </div>
        <div class="col-sm-12 thumbnail">
            <div class="col-sm-3 line-center">订单编号</div>
            <div class="col-sm-2 line-center">姓名</div>
            <div class="col-sm-2 line-center">手机号 </div>
            <div class="col-sm-2 line-center">订单总价</div>
            <div class="col-sm-3 line-center">地址</div>
        </div>
        <div class="list-group">


            <#list list as orderList>
            <div class="col-sm-12  list-group-item" >
                <div class="col-sm-3 line-center" onclick="myClick(4)">${orderList.orderId}</div>
                <div class="col-sm-2 line-center">${orderList.buyerName}</div>
                <div class="col-sm-2 line-center">${orderList.buyerPhone}</div>
                <div class="col-sm-2 line-center">${orderList.orderAmount}</div>
                <div class="col-sm-2 line-center">${orderList.buyerAddress}</div>
            </div>
            </#list>

    </div>
</div>


<!--footer-->
<div class="navbar navbar-default navbar-static-bottom">
    版权声明区
</div>
 </body>
</html>