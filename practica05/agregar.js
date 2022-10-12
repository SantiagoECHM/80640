//var todo =document.getElementById("todo").value;
function leer(){
    return document.getElementById("todo").value;

}

function agregar(){
    nodo=document.createElement("li");
    //texto=document.createTextNode("hola");
    //texto=document.createTextNode(document.getElementById("todo").value);
    texto=document.createTextNode(leer());
    console.log(texto);
    nodo.appendChild(texto);
    document.getElementById("lista").appendChild(nodo);
}
function buscarId(){
    listaTodo = document.getElementsByTagName("li");
    
    /*for(const element of listaTodo){
        if (element.textContent ==leer()){
            console.log("Sí");
        }
        else{
            console.log("No");
        }
    }*/    
    if (document.getElementById(leer()== null)) {
        alert("ya existe");
    }
    else{
        alert("no existe");
    }
}
function buscarFor(){
    listaTodo=document.getElementsByTagName("li");
    for (let i = 0; i < listaTodo.length; i++) {
        const tarea =listaTodo[i];
        if (leer()==tarea.textContent) {
            console.log("ya existe");
        }
    }
}
function buscarOf(){
    listaTodo = document.getElementsByTagName("li");
    for (const tarea of listaTodo) {
        if (leer()==tarea.textContent) {
            
        }
        console.log(tarea);
    }
}

function buscar(){
    listaTodo = document.getElementsByTagName("li");
    for (const tarea in listaTodo) {
        if(Object.hasOwnProperty.call(listaTodo, tarea)){
            console.log(listaTodo[tarea].childNodes[0]);
            if(leer()==listaTodo[tarea].childNodes[0]){
                console.log("Existe");
            }
            else{
                console.log("no existe");
            }
        }
    }
}
