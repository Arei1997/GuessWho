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
    "Charlie",  hasBlackHair = false, hasBlondeHair = false, hasBrownHair = true, hasRedHair = true, hasBrownEyes = false,
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

  "GuessWho.getCharacterNamesAsList" should {
    "just the names of all the characters in the character class list" when {
      "given the list of all character classes" in {
        val result: List[String] = GuessWho.getCharacterNamesAsList(allCharacters)

        assert(result == List("Bob", "Anne", "Charlie")
        )
      }
    }
  }

  // filter by chracteristic
  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters with black hair" when {
      "the chosen character does have black hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(1, allCharacters, testCharacter1)

        assert(result == (List(
          GuessWho.Character("Bob", true, false, false, true, false, true, true, true, true, true),
          ),
          true)
        )
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters without black hair" when {
      "the chosen character doesn't have black hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(1, allCharacters, testCharacter2)

        assert(result == (List(
          GuessWho.Character("Anne", false, true, false, true, false, true, true, false, false, false),
          GuessWho.Character("Charlie", false, false, true, true, false, true, false, true, true, false)),
          false)
        )
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters with brown hair" when {
      "the chosen character has brown hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(2, allCharacters, testCharacter3)

        assert(result == (List(
          GuessWho.Character("Charlie", false, false, true, true, false, true, false, true, true, false)),
          true)
        )
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters without brown hair" when {
      "the chosen character doesn't have brown hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(2, allCharacters, testCharacter1)

        assert(result == (List(
          GuessWho.Character("Bob", true, false, false, true, false, true, true, true, true, true),
          GuessWho.Character("Anne", false, true, false, true, false, true, true, false, false, false)),
          false)
        )
      }
    }
  }


  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters with brown hair" when {
      "the chosen character has brown hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(2, allCharacters, testCharacter3)

        assert(result == (List(
          GuessWho.Character("Charlie", false, false, true, true, false, true, false, true, true, false)),
          true)
        )
      }
    }
  }
}