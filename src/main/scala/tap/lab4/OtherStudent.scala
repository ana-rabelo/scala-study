package tap

import SimpleTypes.*

final case class OtherStudent(firstName: String, lastName: String, age: Int)

object OtherStudent:
    def isValid(firstName: String, lastName: String, age: Int): Boolean = 
        if StringWithOnlyLeters.from(firstName).isDefined
        && StringWithOnlyLeters.from(lastName).isDefined
        && PositiveInt.from(age).isDefined then true else false
    
    def from(firstName: String, lastName: String, age: Int): Option[Student] =
        if (isValid(firstName, lastName, age)) Some(Student(firstName, lastName, age)) 
        else None

    def from(name: String, age: Int): Option[Student] = 
        if (StringWithLettersAndSpaces.from(name).isDefined)
            val Array(firstName, _, lastName) = name.split(" ")
            from(firstName, lastName, age)
        else None