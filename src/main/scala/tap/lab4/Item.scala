package tap

sealed trait Item

// Article: A single article with a description and a price
final case class Article(description: String, price: Double) extends Item

//Bundle: a number of items that are sold together. The bundle has a
// discount percentage, which must used to calculate the bundle’s price 
final case class Bundle(description: String, discount: Double, items: List[Item]) extends Item

//Multiple: a number of items that are sold together
final case class Multiple(count: Int, item: Item) extends Item


object ItemOps:
  // TODO: Use pattern matching to implement the price function
  def price(it: Item): Double = it match
    case Article(description, price) => price
    case Bundle(description, discount, items) => items.map(price).sum * (1 - discount)
    case Multiple(count, item) => count * price(item)
  
