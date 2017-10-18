<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${pageTask}" /> Tire</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href=<c:url value="/resources/bootstrap.min.css" /> />
    <style>
        .container {
            margin-top:30px;
        }
        .mycontainer {
            margin-top: 20px;
        }
        .myimage {
            border: 0.5px solid gainsboro;
            height: 220px;
            width: 300px;
        }
        .wrapper {
            position: relative;
            overflow: hidden;
            display: inline-block;
        }
        .wrapper input[type=file] {
            font-size: 100px;
            position: absolute;
            left: 0;
            top: 0;
            opacity: 0;
        }
    </style>

</head>
<body>
    <div class="container" >
        <div class="col-sm-8 col-sm-offset-2">
            <div class="panel panel-default">

                <div class="panel-heading">
                    <h3><c:out value="${pageTask}" /> Tire</h3>
                </div>


                <div class="panel panel-body">
                    <div class="mycontainer">
                        <form:form action="" method="post" class="form-horizontal" role="form"
                                   enctype="multipart/form-data" modelAttribute="tire">
                            <div class="col-sm-5 col-sm-offset-1">
                                <div class="row">
                                    <div class="form-group">
                                        <form:label path="width" class="col-sm-5">
                                            <p class="text-left">width: </p>
                                        </form:label>
                                        <form:input path="width" class="col-sm-3" />
                                    </div>

                                    <div class="form-group">
                                        <form:label path="height" class="col-sm-5">
                                            <p class="text-left">height: </p>
                                        </form:label>
                                        <form:input path="height" class="col-sm-3" />
                                    </div>

                                    <div class="form-group">
                                        <form:label path="diameter" class="col-sm-5">
                                            <p class="text-left">diameter: </p>
                                        </form:label>
                                        <form:input path="diameter" class="col-sm-3" />
                                    </div>

                                    <div class="form-group">
                                        <form:label path="speedIndex" class="col-sm-5">
                                            <p class="text-left">speed index: </p>
                                        </form:label>
                                        <form:select path="speedIndex" items="${speedIndex}"
                                                     class="col-sm-3 input-sm" />
                                    </div>

                                    <div class="form-group">
                                        <form:label path="file" class="col-sm-5">
                                            <p class="text-left">upload image: </p>
                                        </form:label>
                                        <div class="btn btn-default btn-file col-sm-3 wrapper">
                                            <span>Browse</span>
                                            <form:input path="file" id="image" type="file" accept="image/*"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-5">
                                <div class="myimage">
                                    <div class="text-center">
                                        <img src="/images/tire_image_${tire.id}.${tire.imageExtension}"
                                        id="image_preview" class="img-responsive" alt="no image">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-sm-5 col-sm-offset-7">
                                    <div class="row">
                                        <button type="button" class="btn btn-default" onclick="location.href='<c:url
                                                value="/" />'">Cancel</button>
                                        <button type="button" class="btn btn-default"
                                                onclick="location.reload();">Reset</button>
                                        <button type="submit" class="btn btn-default btn-lg">Save</button>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>

                </div>
            </div>
        </div>
    </div>
<script src="/resources/jquery-3.2.1.min.js"></script>
<script src="/resources/addition.js"></script>
</body>
</html>
