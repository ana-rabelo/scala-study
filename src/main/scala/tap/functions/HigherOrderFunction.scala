

object HigherOrderFunction:
    def isEven(x: Int) = x % 2 == 0
    def isOdd(x: Int) = x % 2 != 0  
    def square(x: Int) = x * x
    def cube(x: Int) = x * x * x
    
    def isPrime(x: Int): Boolean = 
        if (x <= 1)
            false
        else if (x == 2)
            true
        else
            !(2 to (x - 1)).exists(i => x % i == 0)
    
    def hof( f :Int => Boolean, m: Int => Int, xs :List[Int] ): List[Int] ={ xs.filter(f).map(m) }

    def multiply(a: Int)(b: Int) = a * b

    def multiply_by_2 = multiply(2)
    def multiply_by_3 = multiply(3)