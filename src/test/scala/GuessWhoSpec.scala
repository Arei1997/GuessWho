// File path: src/test/scala/GuessWho2Spec.scala

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.util.Random

class GuessWho2Spec extends AnyFlatSpec with Matchers {

  import GuessWho2._

  "Character creation" should "create a character with correct attributes" in {
    val character = Character(name = "Test", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = true, hasEarRings = false, isMale = true, hasFacialHair = false)
    character.name should be ("Test")
    character.hasBlackHair should be (true)
    character.hasBlueEyes should be (false)
  }
}