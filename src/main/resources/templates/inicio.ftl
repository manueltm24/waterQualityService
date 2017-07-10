<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="dashBoardTemplate/images/favicon.png">
    <title>WQ</title>
    <!-- Bootstrap Core CSS -->
    <link href="dashBoardTemplate/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="dashBoardTemplate/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="dashBoardTemplate/bower_components/morrisjs/morris.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="dashBoardTemplate/css/style.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- Preloader -->
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>

    <!-- Page Content -->

        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-12">
                    <h4 class="page-title">Bienvenido a WaterQuality</h4>
                    <ol class="breadcrumb">
                        <li><a href="#">Monitor</a></li>
                    </ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <!--COLUMNA DE MONITORIAR VALORES-->
            <div class="row">
                <div class="col-md-12 col-lg-12 col-sm-12">
                    <div class="white-box">
                        <div class="row row-in">
                            <!--PH-->
                            <div class="col-lg-3 col-sm-6">
                                <div class="col-in text-center">
                                    <h5 class="text-danger">PH</h5>
                                    <h3 class="counter">${valorPH}</h3>
                                </div>
                            </div>
                            <!--TEMPERATURA-->
                            <div class="col-lg-3 col-sm-6">
                                <div class="col-in text-center">
                                    <h5 class="text-danger">Temperatura</h5>
                                    <h3 class="counter">${valorTemp}</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->

    <!-- /#page-wrapper -->
    <footer class="footer text-center"> Water Quality Proyecto Final de Carrera ISC </footer>

<!-- /#wrapper -->
<!-- jQuery -->
<script src="dashBoardTemplate/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="dashBoardTemplate/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="dashBoardTemplate/bower_components/metisMenu/dist/metisMenu.min.js"></script>
<!--Nice scroll JavaScript -->
<script src="dashBoardTemplate/js/jquery.nicescroll.js"></script>
<!--Morris JavaScript -->
<script src="dashBoardTemplate/bower_components/raphael/raphael-min.js"></script>
<script src="dashBoardTemplate/bower_components/morrisjs/morris.js"></script>
<!--Wave Effects -->
<script src="dashBoardTemplate/js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="dashBoardTemplate/js/myadmin.js"></script>
<script src="dashBoardTemplate/js/dashboard1.js"></script>
</body>

</html>
