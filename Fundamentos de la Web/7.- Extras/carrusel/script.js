var currentSlide = 0;

setInterval(nextSlide, 3000);

function showSlide(n) {
    currentSlide = n;

    document.querySelector('.db').classList.remove('db'); //No se vea

    let slides = document.getElementsByClassName('slide'); //Lista con todos los elementso que tienen clase slide

    slides[n].classList.add("db");

    //quitarle lo activo al dot active
    document.querySelector('.active').classList.remove('active');

    //lista dots
    let dots = document.getElementsByClassName('dot'); //Lista con elementos clase dot

    //dot indice n darle class active
    dots[n].classList.add("active");
}

function nextSlide() {
    currentSlide++;
    if(currentSlide > 2) {
        currentSlide = 0;
    }
    console.log(currentSlide);
    showSlide(currentSlide);
}

function prevSlide() {
    currentSlide--;
    if(currentSlide < 0) {
        currentSlide = 2;
    }
    console.log(currentSlide);
    showSlide(currentSlide);
}

document.onkeydown = function (e) {
    switch (e.keyCode) {
        case 37:
            prevSlide();
            break;
        case 39:
            nextSlide();
            break;
    }
    
};