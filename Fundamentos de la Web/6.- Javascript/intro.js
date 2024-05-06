var num = 1;
let texto = "Este es un texto"; //Solo existe en el bloque en el que se declara
const password = "NoVaACambiar"; //No puede ser alterada
var decimal = 1.11;
var bool = true; //true o false

console.log("¡Hola mundo!");
console.log(texto); //Imprime: "Este es un texto"

var despues; //por defecto si no tiene valor va a ser undefined
console.log(despues);
despues = "Texto colocado después";
console.log(despues);

var num1 = 1;
var num2 = 2;
var suma = num1 + num2; //1 + 2 = 3

var nombre = "Elena de Troya";"texto" 
var mensaje = "Mi nombre es:";
console.log(mensaje+nombre); //"Mi nombre es:Elena de Troya"

var otro_nombre = "Juana de Arco";
var edad = 18;
var otro_mensaje = "Mi nombre es: "+otro_nombre+" ¿cómo estás? Tengo "+edad+" años"; //Concatenación
var tercer_mensaje = `Mi nombre es: ${otro_nombre} ¿cómo estás? Tengo ${edad} años`; //Interpolación
console.log(otro_mensaje);
console.log(tercer_mensaje);

var apodo = "Chuy";
var texto_saludar = " ¡Hola! A mi me dicen '"+apodo+"' ";
var texto_saludar2 = ` ¡Hola A mi me dicen '${apodo}' `;

//camelCase PascalCase

var combinamosTexto = "ABC";
console.log(combinamosTexto + num1); //ABC1
console.log(combinamosTexto + num1 + num2); //ABC12
console.log(num1 + num2 + combinamosTexto); //3ABC
console.log(combinamosTexto + (num1 + num2)); //ABC3

var orden = 10 + 20 / 6;
console.log(orden); // 1.- (), 2.- /*%, 3.- -+

var n = 14;
n -= 4; //n = n - 4; + - * / %

var nombre_completo = "Pablo";
nombre_completo += " Picasso";
console.log(nombre_completo);

/* CONDICIONALES */
var bool2 = false;
if(bool2) { // a === b; a !== b; a < b; a <= b; a > b; a >= b
    console.log("Variable verdadera");
} else {
    console.log("Variable falsa");
}

if(n >= 15){ // 10 >= 15
    console.log("Número mayor a 15");
} else {
    console.log("Número menor a 15");
}

var edad_infante = 4;
if(edad_infante < 2){ // 4 < 2
    console.log("Es un bebe");
} else if(edad_infante < 5) { // 4 < 5
    console.log("Es un toddler");
} else {
    console.log("Es un niño");
}

var temperatura = 20;
var estaLloviendo = false;
if(temperatura >= 18 && !estaLloviendo ) { // && AMBAS condicionales se cumplan
    console.log("Vamos al parque a pasear");
}

var edad_conducir = 17;
var permisoPadres = true;
if(edad_conducir >= 18 || permisoPadres ) { // || una u otra debe de cumplirse
    console.log("Tienes permiso para obtener tu licencia de manejo");
}

/* BUCLES O CICLOS */

/*
i = 0
¡Hola!
¿Cómo estás?
--
i = 1
¡Hola!
¿Cómo estás?
--
i = 2
¡Hola!
¿Cómo estás?
--
i = 3
¡Hola!
¿Cómo estás?
--
i = 4
*/
for(let i=0; i < 4; i++) { //for(inicializar; condicional; paso)
    console.log("¡Hola!");
    console.log("¿Cómo estás?");
}

for(let i=10; i > 0; i--){
    console.log(i);
}

let x = 0;
while(x < 3){
    console.log("Entramos al while");
    x++;
}

var inicio = 2;
var final = 10;
/*
inicio = 2
final = 10
Entramos al nuevo while:2:10
inicio = 4
final = 9
---
Entramos al nuevo while:4:9
inicio = 6
final = 8
---
Entramos al nuevo while:6:8
inicio = 8
final = 7
*/
while (inicio < final) {
    console.log(`Entramos al nuevo while:${inicio}:${final}`);
    inicio += 2;
    final--;
}

var v1 = 1;
var v2 = "1";
if(v1 == v2) { // == comparación valor
    console.log("Son iguales");
}

if(v1 === v2) { // === comparación de valor y de tipo
    console.log("Son iguales y que tengan el mismo tipo");
}

/* ARRAYS - ARREGLOS: LISTA */
var hobbies = [
    "Leer",
    "Correr",
    "Bailar",
    "Cantar",
    "Tocar la guitarra",
    "Codear",
    "Jugar videojuegos"
];

console.log(hobbies[0]);
hobbies[2] = "Dormir";
console.log(hobbies);

console.log(hobbies.length);
for(let i=0; i < hobbies.length; i++) {
    console.log(hobbies[i]);
}

var combinado = [
    1.11,
    "texto",
    true,
    30,
    ["otra", "lista"]
]

combinado.push("nuevo elemento"); //Agrega un nuevo elemento al final de la lista
console.log(combinado);
combinado.pop(); //Elimina el último elemento de la lista
combinado.pop();
console.log(combinado);
var lista = [1, 2, 3, 4, 5];
var matriz = [
    lista, //[1, 2, 3, 4, 5, 6]
    [7, 8, 9, 10]
]



matriz[0].push(6);
console.log(matriz);

/* OBJETOS: claves y valores */
var estudiante = {
    id: 12345,
    "nombre": "Elena",
    "apellido": "De Troya",
    "edad": 25,
    "promedio": null,
    "hobbies": ["Leer", "Bailar", "Estudiar"],
    "direcciones": [
        {
            "calle": "Av. del Sol",
            "num": 123,
            "ciudad": "Bogota",
            "pais": "Colombia"
        },
        {
            "calle": "Blvd Acapulco",
            "num": 345,
            "ciudad": "Guadalajara",
            "pais": "Mexico"
        }
    ]
};

console.log(estudiante["nombre"]);
console.log(estudiante.apellido);
estudiante.apellido = "De Arco";
estudiante.promedio = 99.8;
console.log(estudiante);

estudiante["curso"] = "Java";
console.log(estudiante);

console.log(estudiante.direcciones[1].ciudad);

console.log(Object.hasOwn(estudiante, "nombre"));