package tap

final case class Student(firstName: String, lastName: String, age: Int)

object Student:
    private val regex = """[a-zA-Z]+""".r

    def isValid(firstName: String, lastName: String, age: Int): Boolean =
        regex.matches(firstName) && regex.matches(lastName) && age > 0
    
    def from(firstName: String, lastName: String, age: Int): Option[Student] =
        if (isValid(firstName, lastName, age)) Some(Student(firstName, lastName, age)) 
        else None

    def from(name: String, age: Int): Option[Student] =
        if (name.split(" ").length == 3) 
            val Array(firstName, _, lastName) = name.split(" ")
            from(firstName, lastName, age)
        else None