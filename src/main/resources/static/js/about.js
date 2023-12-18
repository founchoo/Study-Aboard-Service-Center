function seeMore(ele) {
    var currentDetailProfileEle = document.getElementById("detailProfile" + ele.id[ele.id.length - 1]);
    currentDetailProfileEle.classList.remove("hide-element");
    currentDetailProfileEle.classList.add("show-element");
}

function hideDetailEle(ele) {
    var currentDetailProfileEle = document.getElementById("detailProfile" + ele.id[ele.id.length - 1]);
    currentDetailProfileEle.classList.remove("show-element");
    currentDetailProfileEle.classList.add("hide-element");
}