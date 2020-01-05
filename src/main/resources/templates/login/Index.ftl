<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">

    <link rel="stylesheet" href="../../bootstrap-3.3.4/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../Flat-UI-master/dist/css/flat-ui.min.css"/>
    <script src="../../bootstrap-3.3.4/dist/js/jquery-1.11.3.min.js"></script>
    <script src="../../bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    <script src="../../Flat-UI-master/dist/js/flat-ui.min.js"></script>
    <title></title>
    <style>
        .row {
            margin-top: 20px;;
        }

        .center {
            text-align: center;
        }

        .pagination {
            background: #cccccc;
        }
    </style>
    <script>
        $(function () {
            $('#myTabs a').click(function (e) {
                $(this).tab('show')
            });
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
                    <li>欢迎您：${user.username}<a href="/sell/seller/login/loginOut">注销</a></li>
                <#else>
                    <li><a href="/sell/seller/login/start">登录</a></li>
                </#if>
                <li><a href="/sell/seller/login/registerInit">注册</a></li>
                <li>
                    <a href="Cart.ftl"><span class="glyphicon glyphicon-shopping-cart">购物车</span></a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<!--content-->
<div class="container">
    <div class="jumbotron">
        <h1>图书商城</h1>
        <p>...</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多</a></p>
    </div>

    <ul class="nav nav-tabs" id="myTabs">
        <li class="active"><a href="#">计算机</a></li>
        <li><a href="#">文学</a></li>
        <li><a href="#">军事科技</a></li>
        <li><a href="#">历史人文</a></li>
        <li><a href="#">金融财会</a></li>
        <li><a href="#">军事科技</a></li>
        <li><a href="#">历史人文</a></li>
    </ul>

    <div class="row">
        <#list productInfoVOList as productInfoVOList>
        <div class="col-sm-4 col-md-3">
            <div class="thumbnail">
                <a href="/sell/seller/bookInfo">
                    <img style="width: 100%; height: 200px; display: block;" alt="100%x200"
                         src="${productInfoVOList.productIcon}" data-src="holder.js/100%x200" >
                </a>
                <div class="caption center">
                    <h5>${productInfoVOList.productName}</h5>
                    <p><span>价格:</span><span>${productInfoVOList.productPrice}</span></p>
                    <p><a class="btn btn-primary btn-block" role="button" href="/sell/seller/bookInfo">查看详情</a></p>
                </div>
            </div>
        </div>
        </#list>
    </div>



    <nav class="center">
        <ul class="pagination  pagination-lg">
            <li>
                <a href="/sell/buyer/product/list?page=1" aria-label="Previous">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>

            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">末页</span>
                </a>
            </li>
        </ul>
    </nav>

</div>

</body>
</html>