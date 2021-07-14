package Postwork

import User

//SESIÓN 5 "PROGRAMACIÓN FUNCIONAL"
//Suponiendo que tenemos una lista de usuarios y queremos filtrar únicamente aquellos que registraron
// un número celular, considerariamos cel: como definitorio
/*
val lola18 = User("Lola18"," lolainthesky@gmail.com", null,  "lolita18" )
val marioRamirez = User("Mario Ramírez"," m.ramirez12@hotmail.com", null,  "1010mramram" )
val claudiaV = User("Claudia V"," clau_valdez@gmail.com", null, "spike1123" )
val miguelAngel = User("Miguel Angel"," miguelitochamoy@gmail.com","5511223344", "mikemiguelmigu3lo" )
val lazyCat = User("a"," sussiegomezm@hotmail.com","5512345678", "a" )

val myUsers: MutableList<User> = mutableListOf(lola18, marioRamirez, claudiaV, miguelAngel, lazyCat)

var registradosCel:MutableList<User> = mutableListOf<User>()
for (user in myUsers){
    if(user.cel!=null){
        registradosCel.add(user)
    }
}
println(registradosCel)*/

//"Mappeo"
//Esta es una Collection Transformation que crea colecciones a partir del resultado de operaciones hechas
// por una función lambda.
//Así, si tenemos una colección de precios libres y necesitamos sumarle el IVA, podemos hacer lo siguiente:
/*fun main(){
    val preciosLibres = setOf(48.0f,32.0f,240.0f,132.0f,16000.0f,120.0f,48.0f,52.0f)
    val preciosFinales = preciosLibres.map { it * 1.16 }
    println(preciosFinales)
}*/
