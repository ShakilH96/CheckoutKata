

class CheckoutTest extends testBase {

  "Checkout" should "accept SKU's in any order and apply the correct discounts" in {

    customer1.total should be (3.25)
    customer2.total should be (1.15)
  }

  "Checkout" should "not apply any discount if minimum number of items not bought" in {

    customer.total should be (1.85)
  }
}
