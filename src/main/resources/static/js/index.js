function predict() {
    var ielts = document.getElementById("ielts");
    var toefl = document.getElementById("toefl");
    var ieltsScore = parseFloat(ielts.value);
    var toeflScore = parseInt(toefl.value);
    var currentIndex = 0;
    var currentPossibilityEle = document.getElementById("possibility" + currentIndex);
    while (currentPossibilityEle != null) {
        currentPossibilityEle.className = "badge visually-hidden";
        var currentIELTSEle = document.getElementById("ielts" + currentIndex);
        var currentTOEFLEle = document.getElementById("toefl" + currentIndex);
        var universityIelts = 0;
        if (currentIELTSEle != null) {
            universityIelts = parseFloat(currentIELTSEle.innerText.split(" ")[1]);
        }
        var universityToefl = 0;
        if (currentTOEFLEle != null) {
            universityToefl = parseInt(currentTOEFLEle.innerText.split(" ")[1]);
        }
        var score = null;
        if (isNaN(toeflScore) && universityIelts != 0) {
            score = 50 + (ieltsScore - universityIelts) / 0.5 * 25;
        } else if (isNaN(ieltsScore) && universityToefl != 0) {
            score = 50 + (toeflScore - universityToefl) * 5;
        }
        if (score != null) {
            currentPossibilityEle.classList.remove("visually-hidden");
            currentPossibilityEle.classList.add("animate__animated", "animate__flash");
            if (score < 0) {
                score = 0;
            } else if (score > 100) {
                score = 100;
            }
            if (score < 40) {
                currentPossibilityEle.classList.add("badge-danger");
                currentPossibilityEle.innerText = "Danger";
            } else if (score < 60) {
                currentPossibilityEle.classList.add("badge-warning");
                currentPossibilityEle.innerText = "Warning";
            } else if (score < 80) {
                currentPossibilityEle.classList.add("badge-info");
                currentPossibilityEle.innerText = "Info";
            } else {
                currentPossibilityEle.classList.add("badge-success");
                currentPossibilityEle.innerText = "Success";
            }
        }
        currentIndex++;
        currentPossibilityEle = document.getElementById("possibility" + currentIndex);
    }
}

function reset() {
    var ielts = document.getElementById("ielts");
    var toefl = document.getElementById("toefl");

    var currentIndex = 0;
    var currentPossibilityEle = document.getElementById("possibility" + currentIndex);
    while (currentPossibilityEle != null) {
        currentPossibilityEle.className = "badge visually-hidden";
        currentIndex++;
        currentPossibilityEle = document.getElementById("possibility" + currentIndex);
    }
    ielts.value = "";
    ielts.disabled = false;
    toefl.value = "";
    toefl.disabled = false;
    changePredictVisibility();
}

function ieltsCheck(ele) {
    var toefl = document.getElementById("toefl");
    ele.value = ele.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
    if (ele.value != "") {
        toefl.disabled = true;
        if (ele.value < 0) {
            ele.value = 0;
        } else if (ele.value > 9) {
            showErrorToast();
            ele.value = "";
            changePredictVisibility();
            return;
        }
        if (ele.value % 0.5 != 0) {
            showErrorToast();
            ele.value = "";
            changePredictVisibility();
            return;
        }
    } else {
        toefl.disabled = false;
    }
    changePredictVisibility();
}

function toeflCheck(ele) {
    var ielts = document.getElementById("ielts");
    ele.value = ele.value.replace(/[^0-9]/g, '');
    if (ele.value != "") {
        ielts.disabled = true;
        if (ele.value < 0) {
            ele.value = 0;
        } else if (ele.value > 120) {
            showErrorToast();
            ele.value = "";
            changePredictVisibility();
            return;
        }
    } else {
        ielts.disabled = false;
    }
    changePredictVisibility();
}

function changePredictVisibility() {
    var ielts = document.getElementById("ielts");
    var toefl = document.getElementById("toefl");
    var predict = document.getElementById("predict");
    if (ielts.value == "" && toefl.value == "") {
        predict.classList.add("disabled");
    } else {
        predict.classList.remove("disabled");
    }
}

function toggleScoreKind(ele) {
    if (ele.classList.contains('fa-toggle-on')) {
        document.getElementById('ielts').classList.remove('visually-hidden');
        document.getElementById('toefl').classList.add('visually-hidden');
        ele.classList.add('fa-toggle-off');
        ele.classList.remove('fa-toggle-on');
    } else {
        document.getElementById('ielts').classList.add('visually-hidden');
        document.getElementById('toefl').classList.remove('visually-hidden');
        ele.classList.add('fa-toggle-on');
        ele.classList.remove('fa-toggle-off');
    }
    reset();
}

// Example POST method implementation:
async function postData(url = '', data = {}) {
  // Default options are marked with *
  const response = await fetch(url, {
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
    mode: 'cors', // no-cors, *cors, same-origin
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'same-origin', // include, *same-origin, omit
    headers: {
      'Content-Type': 'application/json'
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    redirect: 'follow', // manual, *follow, error
    referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  return response.json(); // parses JSON response into native JavaScript objects
}

isRequestData = false;
hasMore = true;
curPageIndex = 0;

isUniversityEleAtTop = true;
isPredictEleAtTop = true;
isWindowAtTop = true;

function goTop() {
    document.getElementById('university-ele').scrollTo({top: 0, behavior: 'smooth'});
    document.getElementById('predict-ele').scrollTo({top: 0, behavior: 'smooth'});
    window.scrollTo({top: 0, behavior: 'smooth'});
}

function changeGoTopVisibility() {
    if (isUniversityEleAtTop && isPredictEleAtTop) {
        document.getElementById('goTop').classList.remove('show-element');
        document.getElementById('goTop').classList.add('hide-element');
    } else {
        document.getElementById('goTop').classList.remove('hide-element');
        document.getElementById('goTop').classList.add('show-element');
    }
}

function listenOnUniversityEleScroll(el) {
    if (el.scrollTop == 0) {
        isUniversityEleAtTop = true;
    } else {
        isUniversityEleAtTop = false;
    }
    changeGoTopVisibility();
    if(el.scrollTop + el.clientHeight >= el.scrollHeight - 100) {
        if (!isRequestData && hasMore) {
            showInfoToast();
            isRequestData = true;
            curPageIndex++;
            postData('/getUniversity', { pageIndex: curPageIndex })
                .then(data => {
                    if (data.length == 0) {
                        hasMore = false;
                        hideLoadingHint();
                        return;
                    }
                    var id = el.children.length;
                    for (var i = 0; i < data.length; i++) {
                        var university = data[i];
                        var universityEle = document.createElement("div");
                        universityEle.className = "p-2";
                        universityEle.innerHTML = "<div class=\"bg-image hover-overlay ripple card rounded university-item\">" +
                                                        "<div class=\"p-2 row text-center d-flex align-items-center\">" +
                                                            "<div class=\"col-md-2\">" +
                                                                "<span class=\"badge badge-light\">Rank " + university.rank + "</span>" +
                                                                "<span id=\"possibility" + id + "\" class=\"badge visually-hidden\"></span>" +
                                                                "</div>" +
                                                                    "<div class=\"col-md-1\">" +
                                                                        "<img src=\"" + university.logoOut + "\" height=\"50px\" class=\"rounded-start\" alt=\"...\">" +
                                                                    "</div>" +
                                                                    "<label class=\"col-md-6\">" + university.name + "</label>" +
                                                                    "<div class=\"col-md-3\">" +
                                                                "<span id=\"ielts" + id + "\" class=\"badge badge-light\">IELTS " + university.ielts + "</span>" +
                                                                "<span id=\"toefl" + id + "\" class=\"badge badge-light\">TOEFL " + university.toefl + "</span>" +
                                                            "</div>" +
                                                        "</div>" +
                                                    "<a href=\"/detail?id=" + id + "\">" +
                                                        "<div class=\"mask\" style=\"background: hsl(0, 0%, 100%, 0.5);\"></div>" +
                                                    "</a>" +
                                                "</div>";
                        document.getElementById("university-ele").appendChild(universityEle);
                        id++;
                        var predictEle = document.getElementById("predict");
                        if (!predictEle.classList.contains("disabled")) {
                            predict();
                        }
                    }
                    isRequestData = false;
                });
        }
    }
}

function listenOnPredictEleScroll(el) {
    if (el.scrollTop == 0) {
        isPredictEleAtTop = true;
    } else {
        isPredictEleAtTop = false;
    }
    changeGoTopVisibility();
}

window.onscroll = function() {
    if (window.scrollY == 0) {
        isPredictEleAtTop = true;
    } else {
        isPredictEleAtTop = false;
    }
    changeGoTopVisibility();
}

window.onload = function() {
    changeGoTopVisibility();
}
