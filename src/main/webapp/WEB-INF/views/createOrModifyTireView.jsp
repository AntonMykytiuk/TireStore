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
    </style>

</head>
<body>
    <div class="container" >
        <div class="col-sm-2">
        </div>
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3><c:out value="${pageTask}" /> Tire</h3>
                </div>
                <div class="panel panel-body">
                    <form:form action="" method="post" class="form-horizontal" role="form" modelAttribute="tire">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <form:label path="width" class="col-md-3">
                                        <p class="text-left">width: </p>
                                    </form:label>
                                    <form:input path="width" />
                                </div>
                                <div class="form-group">
                                    <form:label path="height" class="col-md-3">
                                        <p class="text-left">height: </p>
                                    </form:label>
                                    <form:input path="height" />
                                </div>
                                <div class="form-group">
                                    <form:label path="diameter" class="col-md-3">
                                        <p class="text-left">diameter: </p>
                                    </form:label>
                                    <form:input path="diameter" />
                                </div>
                                <div class="form-group">
                                    <form:label path="speedIndex" class="col-md-3">
                                        <p class="text-left">speed index: </p>
                                    </form:label>
                                    <form:input path="speedIndex" />
                                </div>
                            </div>
                            <div class="col-md-6"></div>

                            </div>
                        <div class="row">
                            <div class="col-md-1"></div>
                            <button type="submit" class="btn btn-default btn-lg">Save</button>
                            <button type="button" class="btn btn-default"
                                    onclick="location.reload();">Reset</button>
                            <button type="button" class="btn btn-default" onclick="location.href='<c:url
                                    value="/" />'">Cancel</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</body>
</html>
