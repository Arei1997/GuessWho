import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class GuessWhoSpec extends AnyWordSpec{

  val testCharacter1: GuessWho.Character = new GuessWho.Character(
    "Bob", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBrownEyes = true,
    hasBlueEyes = false, hasGlasses = true, hasEarRings = true, isMale = true, hasFacialHair = true
  )
  val testCharacter2: GuessWho.Character = new GuessWho.Character(
    "Anne", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBrownEyes = false,
    hasBlueEyes = true, hasGlasses = true, hasEarRings = false, isMale = false, hasFacialHair = false
  )
  val testCharacter3: GuessWho.Character = new GuessWho.Character(
    "Charlie",  hasBlackHair = false, hasBlondeHair = false, hasBrownHair = true, hasBrownEyes = false,
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

        assert(result == (List(testCharacter1), true))

      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters without black hair" when {
      "the chosen character doesn't have black hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(1, allCharacters, testCharacter2)

        assert(result == (List(testCharacter2, testCharacter3), false))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters with brown hair" when {
      "the chosen character has brown hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(2, allCharacters, testCharacter3)

        assert(result == (List(testCharacter3), true))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters without brown hair" when {
      "the chosen character doesn't have brown hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(2, allCharacters, testCharacter1)

        assert(result == (List(testCharacter1, testCharacter2), false))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters with blonde hair" when {
      "the chosen character has blonde hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(3, allCharacters, testCharacter2)

        assert(result == (List(testCharacter2), true))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters without blonde hair" when {
      "the chosen character doesn't have blonde hair" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(3, allCharacters, testCharacter1)

        assert(result == (List(testCharacter1, testCharacter3), false))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters with brown eyes" when {
      "the chosen character has brown eyes" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(4, allCharacters, testCharacter1)

        assert(result == (List(
          testCharacter1),
          true)
        )
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters without brown eyes" when {
      "the chosen character doesn't have brown eyes" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(4, allCharacters, testCharacter2)

        assert(result == (List(testCharacter2, testCharacter3), false))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters with blue eyes" when {
      "the chosen character has blue eyes" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(5, allCharacters, testCharacter2)

        assert(result == (List(testCharacter2, testCharacter3), true))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters without blue eyes" when {
      "the chosen character doesn't have blue eyes" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(5, allCharacters, testCharacter1)

        assert(result == (List(testCharacter1), false))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters with glasses" when {
      "the chosen character has glasses" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(6, allCharacters, testCharacter1)

        assert(result == (List(testCharacter1, testCharacter2), true))
      }
    }
  }

  "GuessWho.filterByCharacteristic" should {
    "return a filtered list of characters without glasses" when {
      "the chosen character doesn't have glasses" in {
        val result: (List[GuessWho.Character], Boolean) = GuessWho.filterByCharacteristic(6, allCharacters, testCharacter3)

        assert(result == (List(testCharacter3), false))
      }
    }
  }
}