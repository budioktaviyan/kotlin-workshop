package id.kotlin.belajar

inline fun <reified T : Any> clazz() = T::class.java

fun main() {
  println(ActivitySatu::class.java.simpleName)
  println(clazz<ActivitySatu>().simpleName)
}

class ActivitySatu

class GenericClass<T> {}
class KelasVarian<in T>
interface Covarian<out T>

interface IniInterface {

  interface IniInterfaceLagi
}