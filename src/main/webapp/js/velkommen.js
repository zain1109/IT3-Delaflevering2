async function Logud(){
    localStorage.setItem("token"," ");
    window.location.href="index.html"
}

async function Tilbage(){
    localStorage.setItem("token"," ");
    window.location.href="Forside.html"

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
    window.location.href="patienter.html"
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
    window.location.href = "EKGside.html"}