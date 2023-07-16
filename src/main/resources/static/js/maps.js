function takeMyBookMap() {
//!globals----------------------------------------------------------------------------------------globals//
    G = { 
        myLocationMarker: null,
        myTradeLocationMarker: null,
        map: null,
        everyMarker: [],
        everyBookWorm: [] 
    }

    //ßpopulates everyBookWorm array
    fetch("/readEveryBookWorm")
    .then((response) => response.json())
    .then((data) => {
        // console.log(data);
        G.everyBookWorm = data;
        getDistanceFromMe();
        setTimeout(() => { populateMap(); }, 1000);
    });

//test
addressToCoords("Budapest, Hungary").then((coords) => { console.log("A beírt hely koordinátái:"+coords); });

//!map-------------------------------------------------------------------------------------------map//
    //ßinits stylized map
    G.map = new google.maps.Map(document.getElementById("googleMap"),{mapId: "d5a599b9e37961"});   //mapId won't be needed
    G.map.setOptions({ streetViewControl: false, mapTypeControl: false });                           //optionally //center: new google.maps.LatLng(50.50000, -0.120200), zoom: 5
    
    //ßsets starting view
    showMyLocation();

    // //ßinits a test marker with icon, tooltip, popup
    // let testMarker = marker({
    //     map: G.map,
    //     position: {lat: 48.25000, lng: 20.6209000},
    //     icon: "./books.svg",
    //     tooltip: "testTooltip",
    //     popupDesc: "testPopupDesc"
    // });        
    // G.everyMarker.push(testMarker);

    //ßreach marker via css:
    // img[src="https://www.gravatar.com/avatar/0a9745ea7ac5c90d7acadb02ab1020cd?s=32&d=identicon&r=PG&f=1"]{
    // border-radius:16px;
    // border:1px solid #000 !important;
    // }



//!functions----------------------------------------------------------------------------------------functions//
    //? inits a marker for every bookworm in G.everyBookWorm, popup contains the title of every book from currentBooks list that has the activeTrade flag set to true
    function populateMap() {
        G.everyBookWorm.forEach((bookWorm) => {
            let act = 0; let db = 0; 
            const m = marker({
                map: G.map,
                position: {lat: bookWorm.location.latitude, lng: bookWorm.location.longitude},
                icon: bookWorm.currentBooks.length > 3 ? "./books.svg" : "./smolBook1.svg",
                tooltip: bookWorm.nickName+"\n"+bookWorm.rank+"\nTrades: "+bookWorm.switchedBooks+"\n"+bookWorm.distanceFromMe+"km" ,
                //if every book is inactive, the popup will say "no active trades"
                popupDesc: bookWorm.currentBooks.length==0?"No Books":bookWorm.currentBooks.map((book) => {

                    db++;
                    if(book.activeTrade) {
                        act++;
                        return book.title+"<BR>";
                    }
                    else if(act == 0 && db == bookWorm.currentBooks.length) {
    
                        return "No Books For Trade";
                    }
                }).join("")
            },bookWorm.id);
            G.everyMarker.push(m);
        });
    }

    //?buils a marker with icon, tooltip, popup
    function marker(p_markerInfo, p_bookwormId)
    {
        //ß markerInfo requirements below
        // markerInfo = 
        // { 
        //     map: map, // google maps instance
        //     position: {lat: 0, lng: 0}, // google maps position
        //     icon: { url: "path", width: 32, height: 32, shape: {coords: [18, 18, 18], type: 'circle'}, isOptimized: false }, OR "path/to/icon.svg",
        //     tooltip: "tooltip",
        //     popupDesc: "popupDesc"
        // }

        const marker = new google.maps.Marker(
        {
            position: p_markerInfo.position,
            icon: p_markerInfo.icon,
            title: p_markerInfo.tooltip,
            map: p_markerInfo.map
        });

        const infowindow = new google.maps.InfoWindow(
        {
            content: p_markerInfo.popupDesc
        });

        marker.addListener('click', () =>
        {
            infowindow.open(this.map, marker);
        });
        marker.addListener('dblclick', () =>
        {
            if(p_markerInfo.icon == "./books.svg" || p_markerInfo.icon == "./smolBook1.svg") {
              console.log("double click");
              window.location.href = "/bookSearchByBookWormId?bookWormId="+marker.bookwormId;
            }
        });

        marker.bookwormId = p_bookwormId;
        return marker;        
    }

    //?adds marker to map indicating current location, sets view and zoom to that particular location
    function showMyLocation(p_icon="./bookWorm.svg", p_popUpContent="Hello World! I'm A Bookworm!")
    {
        myLocation()
        .then((coords) =>
        {
            console.log(coords.latitude);
            console.log(coords.longitude);

            let LatLng = new google.maps.LatLng(coords.latitude, coords.longitude);
            G.map.setCenter(LatLng);
            G.map.setZoom(15);

            //ßinits default location marker
            // const m = new google.maps.Marker(
            // {
            //     position: LatLng,
            //     map: G.map,
            //     title: 'Your Location'
            // });

            //ßinits custom location marker
            const m = marker({
                map: G.map,
                position: LatLng,
                icon: p_icon,
                tooltip: "This is you!",
                popupDesc: p_popUpContent
            });   

            //ßadds marker to global array
            G.myLocationMarker = m;
            G.everyMarker.push(m);
        })
        .catch((error) =>
        {
            console.log(error);
        });
    }

    //?returns my geolocation as a promise
    function myLocation() {
        return new Promise((resolve, reject) => {
            navigator.geolocation.getCurrentPosition((position) => {
                resolve(position.coords);
            });
        });
    }

    //?returns coordinates of a given address as a promise
    function addressToCoords(p_address) {
        return new Promise((resolve, reject) => {
            const geocoder = new google.maps.Geocoder();
            geocoder.geocode({ address: p_address }, (results, status) => {
                if (status == "OK") {
                    resolve(results[0].geometry.location);
                } else {
                    reject(status);
                }
            });
        });
    }

    //?returns address of a given coordinates as a promise
    function coordsToAddress(p_coords) {
        return new Promise((resolve, reject) => {
            const geocoder = new google.maps.Geocoder();
            geocoder.geocode({ location: p_coords }, (results, status) => {
                if (status == "OK") {
                    resolve(results[0].formatted_address);
                } else {
                    reject(status);
                }
            });
        });
    }

    //?harvensine formula
    function getDistanceFromMe() {
        myLocation()
        .then((coords) => {
            G.everyBookWorm.forEach((bookWorm) => {
                const R = 6371; // Radius of the earth in km
                const dLat = deg2rad(coords.latitude-bookWorm.location.latitude);  // deg2rad below
                const dLon = deg2rad(coords.longitude-bookWorm.location.longitude); 
                var a = Math.pow(Math.sin((dLat) / 2), 2) +
                Math.cos(coords.latitude) * Math.cos(bookWorm.location.latitude) *
                Math.pow(Math.sin((dLon) / 2), 2);
                const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
                const d = R * c; // Distance in km
                //until 1 decimal place
                bookWorm.distanceFromMe = Math.round(d*10)/10;
                console.log(bookWorm);
            });
        })
        .catch((error) => {
            console.log(error);
        });
    }

    function deg2rad(deg) {
        return deg * (Math.PI/180)
    }

    //?changes appearance of myTradeLocationBtn
    let myTradeLocationModeStatus = "off";
    const myTradeLocationBtn = document.querySelector("#myTradeLocationBtn");
    myTradeLocationBtn.addEventListener("click", changeMyTradeLocationBtnAppearance);
    function changeMyTradeLocationBtnAppearance() {
        const btn = myTradeLocationBtn;
        if(myTradeLocationModeStatus=="off") {
            myTradeLocationModeStatus = "on";
            myTradeLocationBtn.classList.add("active");
            //change cursor to crosshair
            G.map.setOptions({draggableCursor:'crosshair'});
            
        } else {
            myTradeLocationModeStatus = "off";
            myTradeLocationBtn.classList.remove("active");
            //change cursor to default
            G.map.setOptions({draggableCursor:'default'});
        }
    }
    
    //?if the user clicks myTradeLocation button, this function is called and it adds a marker to the map and sets the global variable G.myTradeLocationMarker to that marker, and posts the coordinates to the server
    myTradeLocationBtn.addEventListener("click", activateMyTradeLocationMode);
    function activateMyTradeLocationMode() {
        if(myTradeLocationModeStatus=="off") return;

        const currentUserId = document.querySelector("#userId").innerText;
        G.map.addListener("click", (e) => {

            //ßif there is already a marker, remove it
            if(G.myTradeLocationMarker) { G.myTradeLocationMarker.setMap(null); }
         
            const m = marker({
                map: G.map,
                position: e.latLng,
                icon: "./tradeLocation.svg",
                tooltip: "Trade Location",
                popupDesc: "This is your trade location. When you want to trade with someone, you meet them here."
            });
            G.myTradeLocationMarker = m;

            const coords = {
                latitude: e.latLng.lat(),
                longitude: e.latLng.lng()
            };

            fetch("/updateBookWormLocationById", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    id: currentUserId,
                    latitude: coords.latitude,
                    longitude: coords.longitude
                })
            })
            .then((res) => {
                console.log(res);
            })
            .catch((error) => {
                console.log(error);
            });
        });
    }

    //?if the user clicks myTradeLocation button it removes the click event listener from map
    myTradeLocationBtn.addEventListener("click", DeactivateMyTradeLocationMode);
    function DeactivateMyTradeLocationMode() {
        if(myTradeLocationModeStatus=="on") return;
        google.maps.event.clearListeners(G.map, "click");
    }
    
}//end of callback function takeMyBookMap

