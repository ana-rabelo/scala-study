package vending

import SimpleTypes.{Denomination, Money, Quantity, Result}

object VendingMachineService extends VendingMachine:

  // TODO: Given a map of existing quantity of denomination, in the vending machine to give as change, calculate and
  //       return the quantities of each denomination needed to give the required change. If exact change is impossible,
  //       a domain error should be returned.
  //       Suggestion:
  //            1. sorted the list of tuples (Denomination,Quantity) from the map, with descending Denomination order
  //            2. Fold the sorted list over a tuple (Map[Denomination,Quantity], Money), starting with the complete
  //                  Money to give as change and and empty map. The fold should add to the map, reducing the change money.
  //            3. Check if the change returned by the fold is zero, is the case, the change is possible, otherwise a
  //                domain error should be returned
  def calculateChange(m: Map[Denomination,Quantity], change: Money): Result[Map[Denomination,Quantity]] = ???