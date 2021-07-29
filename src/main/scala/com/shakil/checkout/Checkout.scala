package com.shakil.checkout

case class Checkout (items: List[SKU], discounts: Set[SpecialPrice]) {
  def total: Double = {
    items
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .map { case (x, y) => eachSkuTotal(x, y) }
      .sum

  }

  private def eachSkuTotal(sku: SKU, n: Int): Double = {
    val offer = discounts.find(_.item == sku)
    offer match {
      case Some(x) =>
        val promo = n / x.quantity * x.price
        val nonPromo = sku.unitPrice * (n % x.quantity)
        promo + nonPromo
      case None => sku.unitPrice * n
    }
  }
}
