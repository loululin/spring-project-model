<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>my websocket</title>
</head>
<body>
<div id='msgcount'></div>
		<script type="text/javascript" src='./jquery.js'></script>
<script type="text/javascript">
    function getUserIP(onNewIP) { //  onNewIp - your listener function for new IPs
        //compatibility for firefox and chrome
        var myPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;
        var pc = new myPeerConnection({
                iceServers: []
            }),
            noop = function () {
            },
            localIPs = {},
            ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g,
            key;

        function iterateIP(ip) {
            if (!localIPs[ip]) onNewIP(ip);
            localIPs[ip] = true;
        }

        //create a bogus data channel
        pc.createDataChannel("");

        // create offer and set local description
        pc.createOffer().then(function (sdp) {
            sdp.sdp.split('\n').forEach(function (line) {
                if (line.indexOf('candidate') < 0) return;
                line.match(ipRegex).forEach(iterateIP);
            });

            pc.setLocalDescription(sdp, noop, noop);
        }).catch(function (reason) {
            // An error occurred, so handle the failure to connect
        });

        //sten for candidate events
        pc.onicecandidate = function (ice) {
            if (!ice || !ice.candidate || !ice.candidate.candidate || !ice.candidate.candidate.match(ipRegex)) return;
            ice.candidate.candidate.match(ipRegex).forEach(iterateIP);
        };
    }

    // Usage
    getUserIP(function (ip) {
        // alert("Got IP! :" + ip);
        var local="localhost:8081";
        var remote="192.168.5.12:8093";

        var webSocket = null;
        if ('WebSocket' in window) {
            webSocket = new WebSocket("ws://" +remote+ "/spring-model/socket/" + ip);
        }
        else if ('MozWebSocket' in window) {
            webSocket = new MozWebSocket("ws://" +remote+ "/spring-model/socket/" + ip);
        }
        else {
            alert('Not support webSocket');
        }

        //socket connected
        webSocket.onopen = function (event) {
            // alert("websocket connected");
        }
        //websocket received message
        webSocket.onmessage = function (event) {
            console.info(event);
            $("#msgcount").append("(<font color='red'>"+event.data+"</font>)<br/>")
            // alert(event.data);
        }
        //websocket on error
        webSocket.onerror = function (event) {
            console.info("websocket on error");
            // alert("websocket on error" + event);
        }

        //websocket on close
        webSocket.onclose = function () {
            console.info("websocket on close");
        }

        //browser closed or refresh
        window.onbeforeunload = function (event) {
            webSocket.close();
        }
    });

</script>
</body>
</html>