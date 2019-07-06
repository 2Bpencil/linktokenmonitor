var socket;


function handlePushMsg(msg){

    var jsonObj = eval('(' + msg + ')')

    console.log(jsonObj);

    $('#'+jsonObj.accountNum+'_amount').html(jsonObj.amount);
    $('#'+jsonObj.accountNum+'_expenditureIncomeState').html(jsonObj.expenditureIncomeState);
    $('#'+jsonObj.accountNum+'_totalAmount').html(jsonObj.totalAmount);
    $('#'+jsonObj.accountNum+'_transTime').html(jsonObj.transTime);
    if(jsonObj.warn == 0){//正常不用警告

    }else{//发出警告

    }

}

if(typeof(WebSocket) == "undefined") {
    console.log("您的浏览器不支持WebSocket");
}else{
    console.log("您的浏览器支持WebSocket");

    //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
    socket = new WebSocket("ws://localhost:8080/websocket");
    //打开事件
    socket.onopen = function() {
        console.log("Socket 已打开");
    };
    //获得消息事件
    socket.onmessage = function(msg) {
        handlePushMsg(msg.data)
    };
    //关闭事件
    socket.onclose = function() {
        console.log("Socket已关闭");
    };
    //发生了错误事件
    socket.onerror = function() {
        alert("Socket发生了错误");
    }

    //关闭连接
    function closeWebSocket() {
        socket.close();
    }

}
