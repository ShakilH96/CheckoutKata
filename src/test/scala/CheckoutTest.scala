

class CheckoutTest extends testBase {

  behavior of "Checkout"
  it should "not apply any discount if minimum number for discounts not bought" in {
    customer.total should be (1.85)
  }

  it should "accept SKU's in any order and apply the correct discounts" in {
    customer1.total should be (3.25)
    customer2.total should be (1.15)
  }

  it should "not apply some promotion in different SKU for given SKU" in {
    customer4.total should be (0.6)
    customer5.total should be (1.50)
  }

  it should "not apply any discounts if no specialPrices specified" in {
    customer6.total should be (2.75)
  }

  it should "return total 0 for no items and no specialPrices" in {
    customer7.total should be (0)
  }

}
