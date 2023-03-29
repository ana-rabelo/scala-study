package tap

import scala.annotation.targetName
import scala.util.matching.Regex

object SimpleTypes :

  opaque type StringWithOnlyLeters = String
  object StringWithOnlyLeters:
    def from(s: String): Option[StringWithOnlyLeters] = if s.forall(_.isLetter) then Some(s) else None
  extension (s: StringWithOnlyLeters)
    @targetName("StringWithOnlyLetersTo")
    def to: String = s

  opaque type StringWithLettersAndSpaces = String
  object StringWithLettersAndSpaces:
    val lettersAndSpace: Regex = "[A-Za-z ]".r
    def from(s: String): Option[StringWithLettersAndSpaces] = if lettersAndSpace.findAllIn(s).mkString == s then Some(s) else None
  extension (s: StringWithLettersAndSpaces)
    @targetName("StringWithLettersAndSpacesTo")
    def to: String = s  

  opaque type PositiveInt = Int
  object PositiveInt:
    def from(i: Int): Option[PositiveInt] = if i > 0 then Some(i) else None
  extension (p: PositiveInt)
    @targetName("PositiveIntTo")
    def to: Int = p  