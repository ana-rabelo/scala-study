package vending

import DomainError.*
import scala.annotation.targetName
import java.security.cert.Extension

// TODO: Create the simple types
//       On name collision (two opaque types in the same file are based on the same type and have equal extension methods),
//       use the  @targetName annotation.
object SimpleTypes:
  
  type Result[A] = Either[DomainError,A]

  // TODO: Create the opaque type Money, which is an Integer and can never be negative
  // TODO: Extension method to, which returns the corresponding Int
  // TODO: Extension methods for comparison ( <, > ) between Money
  // TODO: Extension methods for math ( +, -, * ) between Money
  // TODO: Extension methods for math ( / ), division by Denomination, returning a Quantity
  // TODO: Extension method isZero, returning a Boolean 
  opaque type Money = Int
  object Money:
    def from(m: Int): Result[Money] = if m >= 0 then Right(m) else Left(InvalidMoney(m))
    
    extension (m: Money)
      @targetName("Money")
      def to: Int = m
      def <(otherMoney: Money): Boolean = m < otherMoney
      def >(otherMoney: Money): Boolean = m > otherMoney
      def +(otherMoney: Money): Int = m + otherMoney
      def -(otherMoney: Money): Int = m - otherMoney
      def *(otherMoney: Money): Int = m * otherMoney
      def /(denom: Denomination): Quantity = m / denom
      def isZero: Boolean = m == 0

  
  // TODO: Create the opaque type Quantity,  which is an Integer and can never be negative
  // TODO: Extension method to, which returns the corresponding Int
  // TODO: Extension method isZero should also be created for this type
  // TODO: infix Extension method min, which returns the min Quantity
  opaque type Quantity = Int
    def from(q: Int): Result[Quantity] = if q >= 0 then Right(q) else Left(InvalidQuantity(q))

    extension (q: Quantity)
      @targetName("Quantity")
      def to: Int = q
      def isZero: Boolean = q == 0
      def min(otherQuantity: Quantity): Quantity = if q < otherQuantity then q else otherQuantity
  
  // TODO: Create an enum type for Denomination in which each case has a value in cents
  // TODO: Cases must be created for 1,2,5,10,20,50,100,200 (in cents)
  enum Denomination(val value: Money):
    case oneCent extends Denomination(1)
    case twoCent extends Denomination(2)
    case fiveCent extends Denomination(5)
    case tenCent extends Denomination(10)
    case twentyCent extends Denomination(20)
    case fiftyCent extends Denomination(50)
    case oneEuro extends Denomination(100)
    case twoEuro extends Denomination(200)
