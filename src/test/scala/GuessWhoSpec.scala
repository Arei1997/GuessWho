import org.scalatest.funsuite.AnyFunSuite

class GuessWhoTest extends AnyFunSuite {

  val characters: List[GuessWho.Character] = List(
    GuessWho.Character(name = "James", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = true, hasGlasses = false, hasEarRings = false, isMale = true, hasFacialHair = false),
    GuessWho.Character("Dave", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = false, hasGlasses = true, hasEarRings = true, isMale = true, hasFacialHair = true),
    GuessWho.Character(name = "Maria", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = true, isMale = false, hasFacialHair = false)
  )


  test("createQuestionsMap should create correct mapping") {
    val james = characters.head
    val questionsMap = GuessWho.createQuestionsMap(james)
    assert(questionsMap(1) == true)  // hasBlackHair
    assert(questionsMap(5) == true) // hasBlueEyes
    assert(questionsMap(6) == false) // hasBlueEyes
    assert(questionsMap(9) == false) // hasFacialHair
  }
}

