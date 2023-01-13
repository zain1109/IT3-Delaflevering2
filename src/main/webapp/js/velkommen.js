async function Logud(){
    localStorage.setItem("token"," ");
    window.location.href="index.html"
}

async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="vælgbruger.html"

}

async function opretPatient(){
    let token = localStorage.getItem("token")
    fetch("rest/tokentest",{
        method:"POST",
        body: token,
        headers: {
            "authorization": "Bearer "+localStorage.getItem("token")
        }
    })
    window.location.href="opretPatient.html"
}

async function hentkonsultationer() {
    let token = localStorage.getItem("token")
    fetch("rest/tokentest", {
        method: "POST",
        body: token,
        headers: {
            "authorization": "Bearer " + localStorage.getItem("token")
        }
    })
    window.location.href = "minekonsultationer.html"
}

async function ekgsessions() {
    let token = localStorage.getItem("token")
    fetch("rest/tokentest", {
        method: "POST",
        body: token,
        headers: {
            "authorization": "Bearer " + localStorage.getItem("token")
        }
    })
    window.location.href = "ekgVisual.html"