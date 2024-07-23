import scala.util.Random
import scala.io.StdIn.readLine

object GuessWho extends App {

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

  val person1: Character = Character(name = "James", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = true, hasGlasses = false, hasEarRings = false, isMale = true, hasFacialHair = false)
  val person2: Character = Character(name = "Dave", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = false, hasGlasses = true, hasEarRings = true, isMale = true, hasFacialHair = true)
  val person3: Character = Character(name = "Maria", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = true, isMale = false, hasFacialHair = false)
  val person4: Character = Character(name = "Sarah", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = false, isMale = false, hasFacialHair = false)
  val person5: Character = Character(name = "John", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = false, isMale = true, hasFacialHair = true)
  val person6: Character = Character(name = "Emma", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = true, hasEarRings = false, isMale = false, hasFacialHair = false)
  val person7: Character = Character(name = "Michael", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = true, hasEarRings = false, isMale = true, hasFacialHair = true)
  val person8: Character = Character(name = "Sophia", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = true, hasGlasses = false, hasEarRings = true, isMale = false, hasFacialHair = false)
  val person9: Character = Character(name = "Daniel", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = true, isMale = true, hasFacialHair = true)

  val characters: List[Character] = List(person1, person2, person3, person4, person5, person6, person7, person8, person9)

  val questions: List[String] = List(
    "Is their hair colour black?",
    "Is their hair colour brown?",
    "Is their hair colour blonde?",
    "Do they have black eyes?",
    "Do they have blue eyes?",
    "Do they wear glasses?",
    "Do they wear earrings?",
    "Are they male?",
    "Do they have facial hair?"
  )

  def createQuestionsMap(character: Character): Map[Int, Boolean] = {
    Map(
      1 -> character.hasBlackHair,
      2 -> character.hasBrownHair,
      3 -> character.hasBlondeHair,
      4 -> character.hasBlackEyes,
      5 -> character.hasBlueEyes,
      6 -> character.hasGlasses,
      7 -> character.hasEarRings,
      8 -> character.isMale,
      9 -> character.hasFacialHair
    )
  }

  val questionsMap: Map[Character, Map[Int, Boolean]] = characters.map { character =>
    character -> createQuestionsMap(character)
  }.toMap



  def getRandomCharacter(character: List[Character]):Character ={
    val random = new Random()
    character(random.nextInt(character.length))
  }


  val random = new Random()
  var remainingCharacters = characters
  val selectedCharacter = getRandomCharacter(characters)
  // println("RANDOM",selectedCharacter)
  println(s" The character is : ${selectedCharacter.name}!")

  var askedQuestions = List[Int]()







  while (remainingCharacters.length > 1) {
    println(s"Characters remaining: ${remainingCharacters.map(_.name)}")
    var askQuestion = random.nextInt(questionsMap(selectedCharacter).size) + 1
    if (askedQuestions.contains(askQuestion)){
      do {
        askQuestion = random.nextInt(questionsMap(selectedCharacter).size)  + 1
      } while (askedQuestions.contains(askQuestion))
    }
    askedQuestions =  askQuestion :: askedQuestions
    println(s" ${askQuestion}: ${questions(askQuestion-1)}")
    val userInput = readLine("True or False? ").toLowerCase.trim == "true"
    val newRemainingCharacters = remainingCharacters.filter(character =>
      questionsMap(character)(askQuestion) == userInput)
    if (newRemainingCharacters.isEmpty) {
      println("No characters left that match your criteria")
    } else {
      remainingCharacters = newRemainingCharacters
    }
  }

  if (remainingCharacters.nonEmpty) {
    println(s"Your chosen character is ${remainingCharacters.head.name}.")
  } else {
    println("Cannot determine the chosen character")
  }
}