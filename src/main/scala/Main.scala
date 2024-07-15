import scala.util.Random
import scala.io.StdIn.readLine

object GuessWho extends App {

  // Define the Character case class with boolean attributes
  case class Character(name: String,
                       hasBlackHair: Boolean,
                       hasBlondeHair: Boolean,
                       hasBrownHair: Boolean,
                       hasBlackEyes: Boolean,
                       hasBlueEyes: Boolean,
                       hasGlasses: Boolean,
                       hasEarRings: Boolean,
                       isMale: Boolean,
                       hasFacialHair: Boolean)

  // Define characters with their attributes
  val person1: Character = Character(name = "James", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = true, hasEarRings = true, isMale = true, hasFacialHair = true)
  val person2: Character = Character("Dave", true, false, false, true, false, true, true, true, true)
  val person3: Character = Character("Maria", false, true, false, true, false, false, true, false, false)
  val person4: Character = Character("Sarah", false, true, false, false, true, false, true, false, false)
  val person5: Character = Character("John", true, false, false, true, false, false, false, true, true)
  val person6: Character = Character("Emma", false, true, false, true, false, true, true, false, false)
  val person7: Character = Character("Michael", true, false, false, true, false, true, false, true, true)
  val person8: Character = Character("Sophia", false, true, false, false, true, false, true, false, false)
  val person9: Character = Character("Daniel", true, false, false, true, false, false, true, true, true)

  // List of all characters
  val characters: List[Character] = List(person1, person2, person3, person4, person5, person6, person7, person8, person9)

  // List of questions
  val questions: List[String] = List(
    "1. Is their hair colour black?",
    "2. Is their hair colour brown?",
    "3. Is their hair colour blonde?",
    "4. Is their hair colour red?",
    "5. Do they have black eyes?",
    "6. Do they have blue eyes?",
    "7. Do they wear glasses?",
    "8. Do they wear earrings?",
    "9. Are they male?",
    "10. Do they have facial hair?"
  )

  // Map each person to their questions map
  val questionsMap: Map[Character, Map[Int, Boolean]] = Map(
    person1 -> Map(
      1 -> person1.hasBlackHair,
      2 -> person1.hasBrownHair,
      3 -> person1.hasBlondeHair,
      4 -> false,
      5 -> person1.hasBlackEyes,
      6 -> person1.hasBlueEyes,
      7 -> person1.hasGlasses,
      8 -> person1.hasEarRings,
      9 -> person1.isMale,
      10 -> person1.hasFacialHair
    ),
    person2 -> Map(
      1 -> person2.hasBlackHair,
      2 -> person2.hasBrownHair,
      3 -> person2.hasBlondeHair,
      4 -> false,
      5 -> person2.hasBlackEyes,
      6 -> person2.hasBlueEyes,
      7 -> person2.hasGlasses,
      8 -> person2.hasEarRings,
      9 -> person2.isMale,
      10 -> person2.hasFacialHair
    ),
    person3 -> Map(
      1 -> person3.hasBlackHair,
      2 -> person3.hasBrownHair,
      3 -> person3.hasBlondeHair,
      4 -> false,
      5 -> person3.hasBlackEyes,
      6 -> person3.hasBlueEyes,
      7 -> person3.hasGlasses,
      8 -> person3.hasEarRings,
      9 -> person3.isMale,
      10 -> person3.hasFacialHair
    ),
    person4 -> Map(
      1 -> person4.hasBlackHair,
      2 -> person4.hasBrownHair,
      3 -> person4.hasBlondeHair,
      4 -> false,
      5 -> person4.hasBlackEyes,
      6 -> person4.hasBlueEyes,
      7 -> person4.hasGlasses,
      8 -> person4.hasEarRings,
      9 -> person4.isMale,
      10 -> person4.hasFacialHair
    ),
    person5 -> Map(
      1 -> person5.hasBlackHair,
      2 -> person5.hasBrownHair,
      3 -> person5.hasBlondeHair,
      4 -> false,
      5 -> person5.hasBlackEyes,
      6 -> person5.hasBlueEyes,
      7 -> person5.hasGlasses,
      8 -> person5.hasEarRings,
      9 -> person5.isMale,
      10 -> person5.hasFacialHair
    ),
    person6 -> Map(
      1 -> person6.hasBlackHair,
      2 -> person6.hasBrownHair,
      3 -> person6.hasBlondeHair,
      4 -> false,
      5 -> person6.hasBlackEyes,
      6 -> person6.hasBlueEyes,
      7 -> person6.hasGlasses,
      8 -> person6.hasEarRings,
      9 -> person6.isMale,
      10 -> person6.hasFacialHair
    ),
    person7 -> Map(
      1 -> person7.hasBlackHair,
      2 -> person7.hasBrownHair,
      3 -> person7.hasBlondeHair,
      4 -> false,
      5 -> person7.hasBlackEyes,
      6 -> person7.hasBlueEyes,
      7 -> person7.hasGlasses,
      8 -> person7.hasEarRings,
      9 -> person7.isMale,
      10 -> person7.hasFacialHair
    ),
    person8 -> Map(
      1 -> person8.hasBlackHair,
      2 -> person8.hasBrownHair,
      3 -> person8.hasBlondeHair,
      4 -> false,
      5 -> person8.hasBlackEyes,
      6 -> person8.hasBlueEyes,
      7 -> person8.hasGlasses,
      8 -> person8.hasEarRings,
      9 -> person8.isMale,
      10 -> person8.hasFacialHair
    ),
    person9 -> Map(
      1 -> person9.hasBlackHair,
      2 -> person9.hasBrownHair,
      3 -> person9.hasBlondeHair,
      4 -> false,
      5 -> person9.hasBlackEyes,
      6 -> person9.hasBlueEyes,
      7 -> person9.hasGlasses,
      8 -> person9.hasEarRings,
      9 -> person9.isMale,
      10 -> person9.hasFacialHair
    )
  )

  // Random number generator
  val random = new Random()

  // Initialize remaining characters list
  var remainingCharacters = characters

  // Randomly select the character to guess
