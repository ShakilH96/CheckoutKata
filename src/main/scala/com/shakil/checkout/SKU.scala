package com.shakil.checkout

sealed trait SKU {val unitPrice: Double}

case object A extends SKU { val unitPrice = 0.50 }
case object B extends SKU { val unitPrice = 0.30 }
case object C extends SKU { val unitPrice = 0.20 }
case object D extends SKU { val unitPrice = 0.15 }
