

let tok = localStorage.getItem("token");
if (!tok) {
    window.location.href = "Forside.html"
}

function logud() {
    window.location.replace("Forside.html")
}

async function hentEKG(){
    const res = await  fetch("rest/ekgs/1110109996"); //Using dummy CPR
    const json = await res.json(); //Conversion to json;
    alert(JSON.stringify(json)) //Just checking what came back
    //Lets draw some
    const ekg = json[0]; //Take first EKG on list
    console.log(ekg) //log the ekg
    const samples = ekg.samples // Getting ekg samples
    console.log(samples) //See if we got some samples
    const context = document.getElementById("mycanvas").getContext("2d");
    context.beginPath()
    for(let i=0;i<samples.length;i++){
        const sample = samples[i];
        console.log("sample: " + sample)
        context.lineTo(sample[0], sample[1]);
    }
    context.stroke();
}

let data = {

    datasets: [
        {
            label: "(EKG) Elektrokardiogram ",
            backroundColor: 'rgb(255,99,132)',
            borderColor: 'rgb(255,99,132)',
            data: [],
        }
    ]
}

const config = {
    type: 'line',
    data: data,
    options: {}
}

 plotEkg(data.datasets[0].data);

function plotEkg(data) {

    let canvas = new Chart(
        document.getElementById("ekgplot"),
        config
    );
    let context = canvas.getContext("2d");
    for (i = 0; i < data.length; i++) {
        context.lineTo(i, 300 - data[i] * 100)
        context.stroke()
    }

}