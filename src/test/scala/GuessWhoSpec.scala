import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class GuessWhoSpec extends AnyWordSpec{

  val testCharacter1: GuessWho.Character = new GuessWho.Character(
    "Bob", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasRedHair = true, hasBrownEyes = false,
    hasBlueEyes = true, hasGlasses = true, hasEarRings = true, isMale = true, hasFacialHair = true
  )
  val testCharacter2: GuessWho.Character = new GuessWho.Character(
    "Anne", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasRedHair = true, hasBrownEyes = false,
    hasBlueEyes = true, hasGlasses = true, hasEarRings = false, isMale = false, hasFacialHair = false
  )
  val testCharacter3: GuessWho.Character = new GuessWho.Character(
    "Charlie",  hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasRedHair = true, hasBrownEyes = false,
    hasBlueEyes = true, hasGlasses = false, hasEarRings = true, isMale = true, hasFacialHair = false
  )

  val allCharacters: List[GuessWho.Character] = List(testCharacter1, testCharacter2, testCharacter3)

  "GuessWho.enumerateNames" should {
    "return an enumerated list of names" when {
      "given a list of names" in {
        val result: List[String] = GuessWho.enumerateNames(List("harry", "bob"))

        assert(result == List("1. harry", "2. bob"))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters" when {
      "hasBlackHair is true" in {
        val result: List[GuessWho.Character] = GuessWho.filterByCharacteristic(1, allCharacters)

        assert(result == List(
          GuessWho.Character("Bob", true, false, false, true, false, true, true, true, true, true),
          GuessWho.Character("Charlie", true, false, false, true, false, true, false, true, true, false)
        )
        )
      }
    }
  }


}
