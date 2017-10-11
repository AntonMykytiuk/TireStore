<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <title>Tires</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link rel="stylesheet" href=<c:url value="/resources/bootstrap.min.css" /> />
    <style>
        .container {
            margin-top:30px;
        }
        .mybutton {
            margin: 20px;
        }
        .bottommargin {
            margin-bottom: 30px;
        }
        .myinbold {
            font-weight: 600;
        }
    </style>
</head>

<body>
    <div class="container" >
        <div class="col-sm-2">
        </div>
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>Tires</h3>

                </div>
                <div class="panel panel-body">
                    <table class="table">
                        <tbody>
                            <!-- foreach -->
                            <c:forEach items="${tireList}" var="tireList">
                                <tr>
                                    <td class="col-sm-4">
                                        <div class="col-sm-6">
                                        <h5>width</h5>
                                        </div>
                                        <div class="col-sm-2">
                                            <h5 class="myinbold">${tireList.width}</h5>
                                        </div>
                                        <div class="col-sm-4">
                                            <h5>mm</h5>
                                        </div>
                                        <div class="col-sm-6">
                                            <h5>height</h5>
                                        </div>
                                        <div class="col-sm-2">
                                            <h5 class="myinbold">${tireList.height}</h5>
                                        </div>
                                        <div class="col-sm-4">
                                            <h5>%</h5>
                                        </div>
                                        <div class="col-sm-6">
                                            <h5>diameter</h5>
                                        </div>
                                        <div class="col-sm-2">
                                            <h5 class="myinbold">${tireList.diameter}</h5>
                                        </div>
                                        <div class="col-sm-4">
                                            <h5>inches</h5>
                                        </div>
                                        <div class="col-sm-6">
                                            <h5>speed index</h5>
                                        </div>
                                        <div class="col-sm-6">
                                            <h5 class="myinbold">${tireList.speedIndex}</h5>
                                        </div>
                                    </td>
                                    <td class="col-sm-6">

                                    </td>
                                    <td class="col-sm-2">
                                        <div class="mybutton">
                                            <a href=<c:url value="/modify/${tireList.id}" />>
                                                <button class="btn btn-default">Modify</button>
                                            </a>
                                        </div>
                                        <div class="mybutton">
                                            <a href=<c:url value="/delete/${tireList.id}" />>
                                                <button class="btn btn-default">Delete</button>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <a class="btn btn-default btn-lg btn-block bottommargin" href=<c:url value ="/create" />>Create new tire</a>
        </div>
        <div class="col-md-2">
        </div>

    </div>

</body>
</html>

