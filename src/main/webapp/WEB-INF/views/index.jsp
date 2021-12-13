<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Apartments</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="format-detection" content="telephone=no"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/resources/js/index.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/modal-style.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/slider-style.css"/>

    <style>
        .error {
            color: #ff0000;
        }
        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<header>
    <a href="#openModal" class="button">Add apartament</a>

    <div id="openModal" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <a href="#close" title="Close" class="close">X</a>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form id="fileUploadForm" method="POST" enctype="multipart/form-data" action="/flat/save">
                            <div class="row">
                                <div class="col-25">
                                    <label for="address">Address</label>
                                </div>
                                <div class="col-75">
                                    <input id="address" type="text" class="address" name="address"
                                           placeholder="Address">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-25">
                                    <label for="photos">Photos</label>
                                </div>
                                <div class="col-75">
                                    <input class="photos" type="file" accept="image/*" id="photos" multiple
                                           name="photos" placeholder="Photos">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-25">
                                    <label for="rooms">Rooms</label>
                                </div>
                                <div class="col-75">
                                    <input id="rooms" type="text" class="rooms" name="rooms" placeholder="Count rooms">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-25">
                                    <label for="square">Square</label>
                                </div>
                                <div class="col-75">
                                    <input id="square" type="text" class="square" name="square"
                                           placeholder="Square apartament">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-25">
                                    <label for="description">Description</label>
                                </div>
                                <div class="col-75">
                                    <textarea id="description" type="text" class="description"
                                              name="description" placeholder="Description"></textarea>
                                </div>
                            </div>

                            <input id="latitude" type="hidden" id="latitude" class="latitude" name="latitude">
                            <input id="longitude" type="hidden" id="longitude" class="longitude" name="longitude">

                            <div class="row">
                                <div class="col-25">
                                    <button type="submit" id="button-file" class="button">Create!</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</header>
<div id="map"></div>
<footer></footer>

<script> let flatDtosJson = ${flatDtosJson}; </script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPewRTn3qee2MiJYqQh01EzCQaB_-eReA&libraries=places&callback=initMap"></script>
</body>
</html>
