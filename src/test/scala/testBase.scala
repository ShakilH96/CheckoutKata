import com.shakil.checkout._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

abstract class testBase extends AnyFlatSpec with Matchers{

  val promoForA = SpecialPrice(A, 3, 1.30)
  val promoForB = SpecialPrice(B, 2, 0.45)

  val customer = Checkout(List(A,B,C,A,D,C),Set(promoForA, promoForB))

  val customer1 = Checkout(List(B,A,A,C,B,A,A,B,C,B,D),Set(promoForA, promoForB))
  val customer2 = Checkout(List(B,A,C,B), Set(promoForA,promoForB))

  val customer3 = Checkout(List(B,D,B,B,A,A,C,A), Set.empty)
  val customer4 = Checkout(List.empty, Set.empty)





}
