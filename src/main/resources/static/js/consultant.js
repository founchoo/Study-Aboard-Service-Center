function askQuestion(msg) {
	var item = document.createElement("div");
	item.className = "d-flex flex-row justify-content-end mb-4 pt-1 animate__animated animate__fadeIn";
	item.innerHTML = "<p class='small p-2 me-3 mb-1 text-white rounded-3 bg-primary'>" + msg + "</p>";
	return item;
}

function replyQuestion(msg) {
	var item = document.createElement("div");
	item.className = "d-flex flex-row justify-content-start animate__animated animate__fadeInLeft";
	item.innerHTML = "<p class='small p-2 ms-3 mb-1 rounded-3' style='background-color: #f5f6f7;'>" + msg + "</p>";
	return item;
}

function getResponseMsg(msg) {

    var headerEle = document.getElementById("ai-header");
    var thinkingEle = document.getElementById("ai-thinking");

    headerEle.innerText = "AI is thinking";
    thinkingEle.style.visibility = "visible";

    var request = new XMLHttpRequest();


    request.open("GET", window.location.href + "/send?msg=" + msg);

    request.send();

    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {
            var msgList = document.getElementById("list");
            var response = request.responseText;
            msgList.appendChild(replyQuestion(response));
	        msgList.scrollTo({top: msgList.scrollHeight, behavior: 'smooth'});
            headerEle.innerText = "Ask anything";
            thinkingEle.style.visibility = "hidden";
        }
    }
}

function add() {
    if (event.keyCode != 13) {
        return;
    }
	var msgList = document.getElementById("list");
	var inputElement = document.getElementById("exampleFormControlInput1");
	if (inputElement.value == "") {
        return;
    }
	var askMsg = inputElement.value;
	var askMsgEle = askQuestion(askMsg);
	msgList.appendChild(askMsgEle);
	msgList.scrollTo({top: msgList.scrollHeight, behavior: 'smooth'});
	inputElement.value = "";
	inputElement.focus();
	getResponseMsg(askMsg);
}
