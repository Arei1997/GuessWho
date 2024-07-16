import org.scalatest.funsuite.AnyFunSuite

class GuessWhoTest extends AnyFunSuite {

  val characters: List[GuessWho.Character] = List(
    GuessWho.Character(name = "James", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = true, hasGlasses = false, hasEarRings = false, isMale = true, hasFacialHair = false),
    GuessWho.Character("Dave", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = false, hasGlasses = true, hasEarRings = true, isMale = true, hasFacialHair = true),
    GuessWho.Character(name = "Maria", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = true, isMale = false, hasFacialHair = false)
  )

  test("Character creation should be correct") {
    assert(characters.head.name == "James")
    assert(characters(1).isMale)
    assert(!characters(2).hasFacialHair)
  }

  test("createQuestionsMap should create correct mapping") {
    val james = characters.head
    val questionsMap = GuessWho.createQuestionsMap(james)
    assert(questionsMap(1) == true)  // hasBlackHair
    assert(questionsMap(5) == true)  // hasBlueEyes
    assert(questionsMap(9) == false) // hasFacialHair
  }

  test("Filter logic should correctly filter characters based on questions") {
    val james = characters.head
    val remainingCharacters = characters
    val questionsMap = GuessWho.createQuestionsMap(james)

    val filteredCharacters = remainingCharacters.filter(character => GuessWho.createQuestionsMap(character)(1) == questionsMap(1))

    assert(filteredCharacters.size == 2) // James and Dave have black hair
    assert(filteredCharacters.contains(characters.head))
    assert(filteredCharacters.contains(characters(1)))
  }
}
