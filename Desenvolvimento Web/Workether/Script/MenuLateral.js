let btns = document.getElementsByClassName("btnAside");

for (let i = 0; i < btns.length; i++) {
    btns[i].onclick = function () {
        let btnSelected = btns[i];
        let srcImgSelected = this.firstElementChild.getAttribute("src");
        if (!this.getAttribute("class").includes("Selected", 0)) {
            this.setAttribute("class", this.getAttribute("class") + " Selected");
            this.firstElementChild.setAttribute("src", srcImgSelected.replace(".png", "Selected.png"));
            for (let j = 0; j < btns.length; j++) {
                if (btns[j] !== btnSelected) {
                    let srcImg = btns[j].firstElementChild.getAttribute("src");
                    btns[j].setAttribute("class", btns[j].getAttribute("class").replace("Selected", ""));
                    btns[j].firstElementChild.setAttribute("src", srcImg.replace("Selected", ""));
                }
            }
        }
    }
}

let divLogo = document.getElementById("divLogo");

divLogo.onclick = function () {
    for (let j = 0; j < btns.length; j++) {
        let srcImg = btns[j].firstElementChild.getAttribute("src");
        btns[j].setAttribute("class", btns[j].getAttribute("class").replace("Selected", ""));
        btns[j].firstElementChild.setAttribute("src", srcImg.replace("Selected", ""));
    }
}