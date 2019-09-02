package id.kotlin.belajar

import id.kotlin.belajar.Payment.Customer
import id.kotlin.belajar.Payment.Type
import id.kotlin.belajar.PaymentType.CASH
import id.kotlin.belajar.PaymentType.EMONEY

object IniSingleton {

  fun testSingle() {}
}

enum class PaymentType {
  CASH,
  EMONEY
}

val count = { a: Int, b: Int -> a * b }

fun printCount(a: Int, b: Int, func: (Int, Int) -> (Int)) {
  print(func(a, b))
}

sealed class Payment {
  data class Type(val id: Long, val value: String) : Payment()
  data class Customer(val name: String) : Payment()
}

fun main() {
  IniSingleton.testSingle()
  println(getPayment(EMONEY))

  val pertama = Pertama(
      listOf("Gojek", "Tokopedia", "Bukalapak"),
      listOf(2010, 2009, 2011)
  )

  val pertamaLagi = PertamaLagi(true)

  val hashTag = HashMap<String, Int>()
  hashTag["SATU"] = 1
  hashTag["DUA"] = 2

  val kedua = Kedua(
      Pair(pertama, listOf(pertamaLagi)),
      hashTag
  )

  val result = pertama.companies.map {
    kedua.objects.first.copy(years = listOf(1993), companies = listOf("Bhinneka"))
  }.filter { it.years.first() < 2010 }.take(1).last()
  println("Ini Perusahaan ${result.companies} || Tahun : ${result.years}")

  getPaymentStatus(Type(value = EMONEY.name, id = 1))

  printCount(7, 8, count)
  count(6, 7)
  error { "exception" }
}

data class Pertama(val companies: List<String>,
                   val years: List<Int>)

data class PertamaLagi(val status: Boolean)

data class Kedua(
    val objects: Pair<Pertama, List<PertamaLagi>>,
    val hashtag: Map<String, Int>
)

fun getPayment(type: PaymentType) =
    when (type) {
      CASH -> "Payment is Cash"
      EMONEY -> "Payment is E-Money"
    }

fun getPaymentStatus(payment: Payment) {
  when (payment) {
    is Type -> Type(id = 1, value = "Payment Method")
    is Customer -> Customer("Budi")
  }
}