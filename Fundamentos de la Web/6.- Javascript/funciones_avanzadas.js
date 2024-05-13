var edad = 14;
var mensaje = "";

if(edad > 18){
    mensaje = "La persona es mayor de edad";
} else {
    mensaje = "La persona es menor de edad";
}

//Operador ternario: (condicional) ? "Si se cumple" : "no se cumple"

mensaje = (edad > 18) ? "La persona es mayor de edad" : "La persona es menor de edad";
console.log(mensaje);

var edad_infante = 3;
var mensaje_infante = "";

if(edad_infante < 2) {
    mensaje_infante = "Es un bebe";
} else if(edad_infante < 5) {
    mensaje_infante = "Es un toddler";
} else if(edad_infante < 12){
    mensaje_infante = "Es un niño";
} else {
    mensaje_infante = "Es un preadolescente";
}

mensaje_infante = (edad_infante < 2) ? "Es un bebe" : (edad_infante < 5) ? "Es un toddler": (edad_infante < 12) ? "Es un niño" : "Es un preadolescente";

console.log(mensaje_infante);

//Función Flecha: var nombreFuncion = (parametros) => codigo

function sumatoria(num1, num2) {
    return num1 + num2;
}

var sumatoriaFlecha = (num1, num2) => num1+num2;

function recorrido(numero) {
    for(let i=0; i <= numero; i++) {
        console.log(i);
    }
}

var recorridoFlecha = numero => {
    for(let i=0; i <= numero; i++) {
        console.log(i);
    }
}

var doble = numero => 2*numero;

var doble_de_3 = doble(3);
console.log(doble_de_3);


/* 
Función que reciba un arreglo y regrese la suma de los números positivos e imprima la suma de los números negativos
Funciones Flecha
Operador Ternario
arr = [1, -1, 2, -2, 3, -3]
imprimir -6
return 6
 */
var sumaPositivos = arr => {
    var positivos = 0; //suma nums positivos
    var negativos = 0; //suma nums negativos;
    for(let i=0; i<arr.length; i++) {
        positivos += arr[i] > 0 ? arr[i] : 0;
        negativos += arr[i] < 0 ? arr[i] : 0;
    }
    console.log(negativos);
    return positivos;
}
