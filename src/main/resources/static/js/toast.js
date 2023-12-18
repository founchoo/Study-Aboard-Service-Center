function showToast(toast) {
    toast.classList.add('show');
    setTimeout(function () {
        toast.classList.remove('show');
    }, 2000);
}

function showSuccessToast() {
    var toast = document.getElementById("success-toast");
    showToast(toast);
}

function showErrorToast() {
    var toast = document.getElementById("error-toast");
    showToast(toast);
}

function showInfoToast() {
    var toast = document.getElementById("info-toast");
    showToast(toast);
}