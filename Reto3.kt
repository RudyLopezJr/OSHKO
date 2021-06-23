package Clase2

val nombres = listOf(
    "Kirby",
    "Ness",
    "Fox",
    "Luigi",
    "Mario",
    "Link",
    "Captain Falcon",
    "Samus",
    "Pikachu",
    "Jigglypuff",
    "Donkey Kong",
    "Yoshi"
)

fun main(){
    println(searchName("Pikachu") )
}

fun searchName(name: String): String{
    for ( currentName in nombres){
        if(name in currentName){
            return ("The name $name exits")
        }
    }
    return ("The name $name doesn't exits")
}