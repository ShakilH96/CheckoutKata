

class CheckoutTest extends testBase {

  "Checkout" should "not apply any discount if minimum number for discounts not bought" in {
    customer.total should be (1.85)
  }

  "Checkout" should "accept SKU's in any order and apply the correct discounts" in {
    customer1.total should be (3.25)
    customer2.total should be (1.15)
  }

  "Checkout" should "not apply any discounts if no specialPrices specified" in {
    customer3.total should be (2.75)
  }

  "Checkout" should "return total (0) for no items and no specialPrices" in {
    customer4.total should be (0)
  }

}
