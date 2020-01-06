<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">

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
        .center{
            text-align: center;
        }
    </style>
</head>
<body>

<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">这什么东西</span>
            </button>
            <a class="navbar-brand" href="Index.ftl">图书商城</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="Index.ftl">首页</a></li>
                <li><a href="Order.ftl">我的订单</a></li>
                <li><a href="UserInfo.ftl">个人中心</a></li>
                <li><a href="FriendLink.ftl">友情链接</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right hidden-sm">
                <#if Session["user"]?exists>
                    <li>欢迎您：${user.username}<a href="/sell/seller/loginOut">注销</a></li>
                <#else>
                    <li><a href="/sell/seller/start">登录</a></li>
                </#if>
                <li><a href="/sell/seller/login/registerInit">注册</a></li>
                <li>
                    <a href="Cart.ftl"><span class="glyphicon glyphicon-shopping-cart">购物车</span></a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<!--content-->
<div class="row thumbnail">
    <div class="col-sm-4">
            <img style="width: 100%; height: 500px; display: block;" src="${productInfo.productIcon}"  data-holder-rendered="true">
            <div class="caption center">
                <h3>${productInfo.productName}</h3>
                <p>价格:${productInfo.productPrice}</p>
                <p>库存:${productInfo.productStock}</p>
                <p><a class="btn btn-primary btn-block" role="button" href="#">立即购买</a> <a class="btn btn-default btn-block" role="button" href="#">加入购物车</a></p>
            </div>
    </div>
    <div class="col-sm-8">
        <div class="caption">
                <h3>图书介绍</h3>
                <p>${productInfo.productDescription}</p>

            </div>

    </div>

</div>


</body>
</html>