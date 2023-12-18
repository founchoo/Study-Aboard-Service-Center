document.addEventListener('DOMContentLoaded', (event) => {
    var nav = document.getElementById('navbarSupportedContent');
    var list = nav.getElementsByTagName('a');
    for (let i = 0; i < list.length; i++) {
        let cur = list[i];
        if (window.location.href.endsWith(cur.getAttribute('href'))) {
            cur.classList.add('active', 'animate__animated', 'animate__pulse');
        }
    }
});
