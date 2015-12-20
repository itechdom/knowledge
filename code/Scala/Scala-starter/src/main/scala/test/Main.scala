package test

class Hello(arg:String) {
  def hello(arg:String) = {
    arg
  }
  
}

object Main {

  def main(args: Array[String]): Unit = {
    args.foreach(println) 
    var he = new Hello("Hellooo")
    println(he.hello("hi"))
  }

}
