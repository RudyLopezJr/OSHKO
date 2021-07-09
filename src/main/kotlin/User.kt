class User(
    var username: String,
    var email: String,
    var cel: String?,
    var password: String
) {

    /*
    init {
        println("El usuario $username ha sido registrado")
    }
     */
    fun imprimirNombre(){
        println("El usuario es: $username")
    }
}
