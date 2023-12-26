var y = 3
val x = 4
val myName: String = "Maha"
val xl:Char = '$'
val bol:Boolean = true
val xx = "hi"
var firstName:String ?= null

fun main(args: Array<String>) {
    println("Enter the first number:")
    var x = readLine()!!.toInt()
    println("Enter the second number:")
    var y = readLine()!!.toInt()

    println("The sum = ${x + y}")
    println("The multiplication result = ${x * y}")
    println("The division result = ${x / y}")
//    firstName = "Maha"
//    println(firstName)
//    // Try adding program arguments via Run/Debug configuration.
//    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
}