package id.kotlin.belajar

fun sum(a: Int, b: Int) = a.plus(b)

fun anotherArgs(name: String = "Budi", age: Int, isSingle: Boolean, idNumber: Int = 666, companyName: String) =
    println("$name, $isSingle, $idNumber, $companyName, $age")

fun myArgs(name: String, age: Int = 10) {
  println("$name and $age")
}

@Suppress("UNUSED")
fun test() {
  var abc = "abc" // Implicit declaration
  var xyz: String = "" // Exxplicit declaration
  var name: String? = null
  val xxx = 111 // Constant variable / value
  val list: List<String> = emptyList()

  val mutableList: MutableList<String> = mutableListOf()
  mutableList.add("Satu")
  mutableList.add("Dua")

  val arrayList: Array<String> = emptyArray()
  val mutableCollection: Collection<String> = emptyList()
}

class IniAdalahKelas {

  var variableSatu: Int = 1
  var isSukses: Boolean = false
}

data class IniAdalahDataKelas(
    var variableSatu: Int = 1,
    var isSukses: Boolean = false
)

fun main() {
  sum(5, 5)
  anotherArgs(name = "Budi", isSingle = false, companyName = "Bhinneka", age = 31)
  myArgs(age = 31, name = "Budi")

  val kelasSatu = IniAdalahKelas()
  kelasSatu.variableSatu = 10
  kelasSatu.isSukses = true

  val dataKelas = IniAdalahDataKelas()
  print(dataKelas)

  val dataKelasLainnya = dataKelas.copy(
      variableSatu = 100,
      isSukses = true
  )
  print(dataKelasLainnya)

  IniAdalahKelas().apply {
    variableSatu = 100
    isSukses = false
  }
}