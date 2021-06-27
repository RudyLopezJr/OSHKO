package PosWork3

import javax.print.attribute.standard.JobOriginatingUserName

fun main(){

    val fresa = Product("Fresa", 48.0f)
    val manzanas = Product("Manzanas", 32.0f)

    val pesa = Product("pesa", 240.0f)
    val balon = Product("balon", 132.0f)

    val pc= Product("pc", 16000.0f)
    val mouse=Product("mouse", 120.0f)

    val shampoo= Product("shampoo", 48.0f)
    val bloqueador= Product("bloqueador", 52.0f)

    val myProducts: MutableList<Product> = mutableListOf(fresa, manzanas, pesa, balon, pc, mouse, shampoo, bloqueador)
    val myWallet:  MutableList<Product> = mutableListOf()

    val Lola18 = User("Lola18"," lolainthesky@gmail.com", "lolita18" )
    val MarioRamírez = User("Mario Ramírez"," m.ramirez12@hotmail.com", "1010mramram" )
    val ClaudiaV = User("Claudia V"," clau_valdez@gmail.com", "spike1123" )
    val MiguelAngel = User("Miguel Angel"," miguelitochamoy@gmail.com", "mikemiguelmigu3lo" )
    val Lazycat = User("a"," sussiegomezm@hotmail.com", "a" )

    val myUsers: MutableList<User> = mutableListOf(Lola18, MarioRamírez, ClaudiaV, MiguelAngel, Lazycat)


    var checker : Boolean
    var aux: Int

    var auxUser: String
    var auxContraseña: String

    var counter: Int
    var checker2: Boolean
    var aux2: Int

    var acum1: Float
    var aux3: Int

    do{
        checker = false
        println("1. Iniciar sesión")
        println("2. Registrarse")
        println("3. Salir ")
        print("Digite su opcion: ")
        aux = readLine()?.toInt()!!

        when(aux) {
            1 -> {
                print("Escribe tu usuario: ")
                auxUser = readLine().toString()

                print("Contraseña: ")
                auxContraseña = readLine().toString()

                checker = login(auxUser,auxContraseña, myUsers )
            }
            2 -> {
                myUsers += registerUser()
            }
            else -> return
        }

    } while(!checker)

    do{
        checker = false
        println("1. Mostrar productos")
        println("2. Ir al carrito")
        println("3. Salir ")
        print("Digite su opcion: ")

        aux = readLine()?.toInt()!!

        when(aux) {
            1 -> {
                counter = 1
                print("Numero \t Nombre\t  Precio \t \n")
                for(product in myProducts){
                    print("$counter \t\t ${product.name1}\t\t ${product.price}\t\n")
                    counter += 1
                 }
               checker2 = false

                println("A continuación seleccione los productos que desee agregar al carrito")
                println("Presione 0 para salir")
               do{
                   aux2 = readLine()?.toInt()!!
                   when(aux2){
                       0 -> checker2 = true
                       else -> {
                           myWallet += myProducts[aux2-1]
                           println("Se ha agregado el producto $aux2 con exito")
                       }
                   }

               } while(!checker2)
            }
            2 -> {
                checker2 = false
                do{
                    println("1. Proceder a la compra")
                    println("2. Mostrar productos")
                    println("3. Eliminar producto")
                    println("4. Salir")
                    print("Digite su opcion: ")

                    aux2 = readLine()?.toInt()!!

                    when(aux2){
                        1 -> {
                            println("Se ha hecho el pago con exito :D ")
                            checker2 = true
                        }
                        2 -> {
                            println("Sus productos son: ")
                            acum1 = 0f
                            counter = 1
                            print("Numero \t | Nombre \t | Precio \t\n ")
                            for(wallet in myWallet){
                                print("$counter \t | ${wallet.name1} \t | ${wallet.price} \t \n ")
                                acum1 += wallet.price
                                println("=============================")
                                counter += 1
                            }

                            println("Precio acumulado: $acum1")
                        }

                        3 -> {
                            println("Sus productos son: ")
                            acum1 = 0f
                            counter = 1

                            print("Numero \t | Nombre \t | Precio \t\n ")

                            for(wallet in myWallet){
                                print("$counter \t | ${wallet.name1} \t | ${wallet.price} \t \n ")
                                acum1 += wallet.price
                                counter += 1
                            }

                            println("Precio acumulado: $acum1")

                            print("Digite el número del producto a eliminar: ")
                            aux3 = readLine()?.toInt()!!

                            myWallet.removeAt(aux3 - 1)
                            println("Se ha eliminado el producto $aux3")
                        }
                        else -> checker2 = true
                    }



                }while(!checker2)
            }
            else -> return
        }

    } while(!checker)


}

fun registerUser() : User{
    var auxUsername : String
    var auxEmail: String
    var auxPassword: String

    print("Escriba su usuario: ")
    auxUsername = readLine().toString()
    print("Escriba su correo: ")
    auxEmail = readLine().toString()

    print("Escriba su contraseña: ")
    auxPassword = readLine().toString()

    val auxUser = User(auxUsername, auxEmail, auxPassword)

    return auxUser
}

fun registerProduct(): Product{
    var auxName: String
    var auxPrice: Float

    print("Escriba el nombre del producto: ")
    auxName = readLine().toString()
    print("Escriba el precio del producto: ")
    auxPrice = readLine()?.toFloat()!!

    var auxProduct = Product(auxName,auxPrice)
    return auxProduct
}

fun login(user1: String, pass:String, userList: MutableList<User>): Boolean{

    for(auxUser in userList){
        if( (user1 == auxUser.username || user1 == auxUser.email) && pass == auxUser.password){
            println("Inicio de sesión exitoso")
            return true
        }
    }

    println("email o contraseña incorrecto")
    return false

}