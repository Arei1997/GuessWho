import scala.util.Random
import scala.io.StdIn.readLine


object GuessWho extends App {


  case class Character(name: String,
                       hasBlackHair: Boolean,
                       hasBlondeHair: Boolean,
                       hasBrownHair: Boolean,
                       hasRedHair: Boolean,
                       hasBrownEyes: Boolean,
                       hasBlueEyes: Boolean,
                       hasGlasses: Boolean,
                       hasEarRings: Boolean,
                       isMale: Boolean,
                       hasFacialHair: Boolean
                      )

  // Characters as part of the guessing
  val person1: Character = Character(name = "James", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false,
    hasRedHair = true, hasBrownEyes = false, hasBlueEyes = true, hasGlasses = true, hasEarRings = true, isMale = true,
    hasFacialHair = true
  )
  val person2: Character = Character(name = "Dave", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false,
    hasRedHair = true, hasBrownEyes = false, hasBlueEyes = true, hasGlasses = true, hasEarRings = true, isMale = true,
    hasFacialHair = true
  )
  val person3: Character = Character(name = "Maria", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false,
    hasRedHair = true, hasBrownEyes = false, hasBlueEyes = false, hasGlasses = true, hasEarRings = false, isMale = false,
      hasFacialHair = false
  )
  val person4: Character = Character(name = "Sarah", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false,
    hasRedHair = false, hasBrownEyes = true, hasBlueEyes = false, hasGlasses = true, hasEarRings = false, isMale = false,
    hasFacialHair = false
  )
  val person5: Character = Character(name = "John", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false,
    hasRedHair = true, hasBrownEyes = false, hasBlueEyes = false, hasGlasses = false, hasEarRings = true, isMale = true,
    hasFacialHair = true
  )
  val person6: Character = Character(name = "Emma", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false,
    hasRedHair = true, hasBrownEyes = false, hasBlueEyes = true, hasGlasses = true, hasEarRings = false, isMale = false,
    hasFacialHair = false
  )
  val person7: Character = Character(name = "Michael", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false,
    hasRedHair = true, hasBrownEyes = false, hasBlueEyes = true, hasGlasses = false, hasEarRings = true, isMale = true,
    hasFacialHair = false
  )
  val person8: Character = Character(name = "Sophia", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false,
    hasRedHair = false, hasBrownEyes = true, hasBlueEyes = false, hasGlasses = true, hasEarRings = false, isMale = false,
    hasFacialHair = false
  )
  val person9: Character = Character(name = "Daniel", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false,
    hasRedHair = true, hasBrownEyes = false, hasBlueEyes = false, hasGlasses = true, hasEarRings = true, isMale = true,
    hasFacialHair = false
  )


  val allCharacters: List[Character] = List(person1, person2, person3, person4, person5, person6, person7, person8, person9)

  //List Of Questions
  val questions: List[String] = List(
    "1. Is their hair colour black?",
    "2. Is their hair colour brown?",
    "3. Is their hair colour blonde?",
    "4. Is their hair colour red?",
    "5. Do they have brown eyes?",
    "6. Do they have blue eyes?",
    "7. Do they wear glasses?",
    "8. Do they wear earrings?",
    "9. Are they male?",
    "10. Are they female?",
    "11. Do they have facial hair?",
    "12. Guess the character",
  )

  def getRandomCharacter: Character = {

    allCharacters(Random.nextInt(allCharacters.length))
  }


  def filterByCharacteristic(userInput: Int, characterList: List[Character], randomCharacter: Character): (List[Character], Boolean) = {
    val (filteredCharacters, matchesCharacteristic) = userInput match {
      case 1 => (characterList.filter(_.hasBlackHair == randomCharacter.hasBlackHair), randomCharacter.hasBlackHair)
      case 2 => (characterList.filter(_.hasBrownHair == randomCharacter.hasBrownHair), randomCharacter.hasBrownHair)
      case 3 => (characterList.filter(_.hasBlondeHair == randomCharacter.hasBlondeHair), randomCharacter.hasBlondeHair)
      case 4 => (characterList.filter(_.hasRedHair == randomCharacter.hasRedHair), randomCharacter.hasRedHair)
      case 5 => (characterList.filter(_.hasBrownEyes == randomCharacter.hasBrownEyes), randomCharacter.hasBrownEyes)
      case 6 => (characterList.filter(_.hasBlueEyes == randomCharacter.hasBlueEyes), randomCharacter.hasBlueEyes)
      case 7 => (characterList.filter(_.hasGlasses == randomCharacter.hasGlasses), randomCharacter.hasGlasses)
      case 8 => (characterList.filter(_.hasEarRings == randomCharacter.hasEarRings), randomCharacter.hasEarRings)
      case 9 => (characterList.filter(_.isMale == randomCharacter.isMale), randomCharacter.isMale)
      case 10 => (characterList.filter(_.isMale != randomCharacter.isMale), !randomCharacter.isMale)
      case 11 => (characterList.filter(_.hasFacialHair == randomCharacter.hasFacialHair), randomCharacter.hasFacialHair)
      case _ => (characterList, false)
    }
    (filteredCharacters, matchesCharacteristic)
  }


  def getCharacterNamesAsList(characters: List[Character]): List[String] = {
    characters.map(_.name)
  }


  def enumerateNames(characterList: List[String]): List[String] = {
    characterList.zipWithIndex.map { case (name, index) => s"${index + 1}. $name" }
  }

  val randomCharacter: Character = getRandomCharacter

  var characterBoard = allCharacters
  var isGameOver = false

  println("Welcome to Guess Who!")
  println("Try to guess the character by asking questions.")
  println(randomCharacter)
  println(enumerateNames(getCharacterNamesAsList(characterBoard)).mkString("\n"))

  while (!isGameOver) {

    println("\nQuestions:")
    questions.foreach(println)

    val userInput = readLine("Enter the number of your question: ").toInt

    if (userInput >= 1 && userInput <= 11) {
      val (filteredBoard, matches) = filterByCharacteristic(userInput, characterBoard, randomCharacter)
      characterBoard = filteredBoard
      println(s"${matches}")
      println(s"Characters remaining: ${characterBoard.map(_.name).mkString(", ")}")
    } else if (userInput == 12) {
      val guess = readLine("Enter the name of the character you want to guess: ")
      if (guess.equalsIgnoreCase(randomCharacter.name)) {
        println(s"Congratulations! You guessed correctly. The character was ${randomCharacter.name}.")
        isGameOver = true
      } else {
        println(s"Wrong guess! The character is not $guess.")
      }
    } else {
      println("Invalid input. Please enter a number between 1 and 12.")
    }

  }

}
