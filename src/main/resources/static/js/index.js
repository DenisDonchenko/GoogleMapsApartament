var autocompletes;
var map;
var latitude;
var longitude;
var locations;

$(document).ready(function (event) {
    initializeMap();

    $('#fileUploadForm').submit(function (e) {
        $('.error').css('display', 'none');

        let regularSquare = '/^\d*(\.\d+)?$/';
        let regularCount = '^\d+$';

        if (($('#description').val().length == 0)) {
            $('#description').after('<span class="error">Description Can not be empty.</span>');
            return false;
        } else if (!isNumber($('#square').val())) {
            $('#square').after('<span class="error">Error input square.</span>');
            return false;
        } else if (!isNumber($('#rooms').val())) {
            $('#rooms').after('<span class="error">Error input.</span>');
            return false;
        } else if (($('#square').val().length == 0)) {
            $('#square').after('<span class="error">Can not be empty.</span>');
            return false;
        } else if (($('#rooms').val().length == 0)) {
            $('#rooms').after('<span class="error">Can not be empty.</span>');
            return false;
        } else if (($('#photos').val().length == 0)) {
            $('#photos').after('<span class="error">Can not be empty.</span>');
            return false;
        } else if ($('#square').val() < 1) {
            $('#square').after('<span class="error">Square cannot be less than 0 or equal to 0</span>');
            return false;
        } else if ($('#rooms').val() < 1) {
            $('#rooms').after('<span class="error">Count rooms cannot be less than 0 or equal to 0</span>');
            return false;
        } else {
            return true;
        }
    });
});

function isNumber(n) {
    return /^-?[\d.]+(?:e-?\d+)?$/.test(n);
}

document.addEventListener('DOMContentLoaded', function () {
    let scrollbar = document.body.clientWidth - window.innerWidth + 'px';
    document.querySelector('[href="#openModal"]').addEventListener('click', function () {
        document.body.style.overflow = 'hidden';
        document.querySelector('#openModal').style.marginLeft = scrollbar;
    });
    document.querySelector('[href="#close"]').addEventListener('click', function () {
        document.body.style.overflow = 'visible';
        document.querySelector('#openModal').style.marginLeft = '0px';
    });
});

function initializeMap() {
    if (flatDtosJson.length != 0) {
        let flatDtosJsonParse = JSON.parse(JSON.stringify(flatDtosJson));
        for (let i = 0; i < flatDtosJsonParse.length; i++) {
            locations = [
                {
                    'name': flatDtosJsonParse[i].address,
                    'lat': flatDtosJsonParse[i].latitude,
                    'lng': flatDtosJsonParse[i].longitude,
                    'is_exact': true
                }
            ];
            let contentWindowInfo = createContent(flatDtosJsonParse[i]);
            createMarker(flatDtosJsonParse[i].latitude, flatDtosJsonParse[i].longitude, contentWindowInfo);
        }
    }
}

function createContent(flatDtosJsonParse) {

    var sliderPhoto = `<p>Address - ${flatDtosJsonParse.address}</p>` +
        `<p>Count rooms - ${flatDtosJsonParse.rooms} </p>` +
        `<p>Square rooms - ${flatDtosJsonParse.square}</p>` +
        `<p>Description - ${flatDtosJsonParse.description}</p>`;

    sliderPhoto += '<div class="slider">\n';

    for (let i = 0; i < flatDtosJsonParse.photos.length; i++) {
        sliderPhoto += `<a href="#slide-${i}">${i}</a>\n`;
    }
    sliderPhoto += `<div class="slides">\n`;
    for (let i = 0; i < flatDtosJsonParse.photos.length; i++) {
        sliderPhoto += `<div id="slide-${i}">\n` +
            ` <img src="data:image/jpeg;base64,${flatDtosJsonParse.photos[i]}">` +
            `</div>`
    }
    sliderPhoto += '</div></div>';

    return sliderPhoto;
}

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 48.464717, lng: 35.046183},
        zoom: 5
    });

    initializeMap();

    let inputs = document.querySelector('#address');
    autocompletes = new google.maps.places.Autocomplete(inputs);

    google.maps.event.addListener(autocompletes, 'place_changed', function () {

        let place = autocompletes.getPlace();
        if (!place.geometry) {
            window.alert(`No details available for input:  ${place.name} `);
            return;
        }

        if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
        } else {
            map.setCenter(place.geometry.location);
            map.setZoom(10);
        }

        latitude = place.geometry.location.lat();
        longitude = place.geometry.location.lng();

        locations = {'name': ' ', 'lat': latitude, 'lng': longitude, 'is_exact': true};

        $('#latitude').val(latitude)
        $('#longitude').val(longitude)
    });
}

function createMarker(lat, lon, infoMWindowContent) {
    let newmarker = new google.maps.Marker({
        position: new google.maps.LatLng(lat, lon),
        map: map
    });

    newmarker['infowindow'] = new google.maps.InfoWindow({
        content: infoMWindowContent
    });

    google.maps.event.addListener(newmarker, 'click', function () {
        if (!newmarker.open) {
            this['infowindow'].open(map, this);
            newmarker.open = true;
        } else {
            this['infowindow'].close();
            newmarker.open = false;
        }
    });
}
