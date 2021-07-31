package com.shakil.checkout

case class Checkout (items: List[SKU], discounts: Set[SpecialPrice]) {
  val total: Double = {
    items
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .map { case (sku, skuQuantity) => eachSkuTotal(sku, skuQuantity) }
      .sum

  }

  private def eachSkuTotal(sku: SKU, skuQuantity: Int): Double = {
    val offer: Option[SpecialPrice] = discounts.find(_.item == sku)
    offer match {
      case Some(promotion) =>
        val promo = skuQuantity / promotion.quantity * promotion.price
        val nonPromo = sku.unitPrice * (skuQuantity % promotion.quantity)
        promo + nonPromo
      case None => sku.unitPrice * skuQuantity
    }
  }
}
