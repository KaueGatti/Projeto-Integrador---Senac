var btnsAside = document.getElementsByClassName("btnAside");

for (var i = 0; i < btnsAside.length; i++) {
    btnsAside[i].onclick = function () {
        var srcImg = this.firstElementChild.getAttribute("src");
        if (!this.getAttribute("class").includes("Selected", 0)) {
            this.setAttribute("class", this.getAttribute("class") + "Selected");
            this.firstElementChild.setAttribute("src", srcImg.replace(".png", "Selected.png"));
        } else {
            this.setAttribute("class", this.getAttribute("class").replace("Selected", ""));
            this.firstElementChild.setAttribute("src", srcImg.replace("Selected", ""));
        }
    }
}