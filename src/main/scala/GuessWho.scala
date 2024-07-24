import scala.util.Random
import scala.io.StdIn.readLine

object GuessWho extends App {

  sealed trait HairColour
  object HairColour {
    case object Brown extends HairColour
    case object Black extends HairColour
    case object Blonde extends HairColour
  }

  sealed trait EyeColour
  object EyeColour {
    case object Brown extends EyeColour
    case object Blue extends EyeColour
  }

  case class Character(name: String,
                       hairColour: HairColour,
                       eyeColour: EyeColour,
                       hasGlasses: Boolean,
                       hasEarRings: Boolean,
                       isMale: Boolean,
                       hasFacialHair: Boolean)

  // Characters as part of the guessing
  val person1: Character = Character("James", HairColour.Black, EyeColour.Blue, true, true, true, true)
  val person2: Character = Character("Dave", HairColour.Black, EyeColour.Blue, true, true, true, true)
  val person3: Character = Character("Maria", HairColour.Blonde, EyeColour.Brown, true, false, false, false)
  val person4: Character = Character("Sarah", HairColour.Blonde, EyeColour.Brown, true, false, false, false)
  val person5: Character = Character("John", HairColour.Black, EyeColour.Brown, false, true, true, true)
  val person6: Character = Character("Emma", HairColour.Brown, EyeColour.Blue, true, false, false, false)
  val person7: Character = Character("Michael", HairColour.Brown, EyeColour.Blue, false, true, true, false)
  val person8: Character = Character("Sophia", HairColour.Blonde, EyeColour.Brown, true, false, false, false)
  val person9: Character = Character("Daniel", HairColour.Brown, EyeColour.Brown, true, true, true, false)

  val allCharacters: List[Character] = List(person1, person2, person3, person4, person5, person6, person7, person8, person9)

  // List Of Questions
  val questions: List[String] = List(
    "1. Is their hair colour black?",
    "2. Is their hair colour brown?",
    "3. Is their hair colour blonde?",
    "4. Do they have brown eyes?",
    "5. Do they have blue eyes?",
    "6. Do they wear glasses?",
    "7. Do they wear earrings?",
    "8. Are they male?",
    "9. Are they female?",
    "10. Do they have facial hair?",
    "11. Guess the character"
  )

  def getRandomCharacter: Character = {
    allCharacters(Random.nextInt(allCharacters.length))
  }

  def filterByCharacteristic(userInput: Int, characterList: List[Character], randomCharacter: Character): (List[Character], Boolean) = {
    val (filteredCharacters, matchesCharacteristic) = userInput match {
      case 1 => (characterList.filter(_.hairColour == HairColour.Black), randomCharacter.hairColour == HairColour.Black)
      case 2 => (characterList.filter(_.hairColour == HairColour.Brown), randomCharacter.hairColour == HairColour.Brown)
      case 3 => (characterList.filter(_.hairColour == HairColour.Blonde), randomCharacter.hairColour == HairColour.Blonde)
      case 4 => (characterList.filter(_.eyeColour == EyeColour.Brown), randomCharacter.eyeColour == EyeColour.Brown)
      case 5 => (characterList.filter(_.eyeColour == EyeColour.Blue), randomCharacter.eyeColour == EyeColour.Blue)
      case 6 => (characterList.filter(_.hasGlasses == randomCharacter.hasGlasses), randomCharacter.hasGlasses)
      case 7 => (characterList.filter(_.hasEarRings == randomCharacter.hasEarRings), randomCharacter.hasEarRings)
      case 8 => (characterList.filter(_.isMale == randomCharacter.isMale), randomCharacter.isMale)
      case 9 => (characterList.filter(_.isMale != randomCharacter.isMale), !randomCharacter.isMale)
      case 10 => (characterList.filter(_.hasFacialHair == randomCharacter.hasFacialHair), randomCharacter.hasFacialHair)
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
  println("Welcome to Guess Who!")
  println("Try to guess the character by asking questions.")
  println(randomCharacter) // For testing, you might want to hide this in actual gameplay

  // Function gameLoop takes in the current character board (list of characters) and the randomly chosen character
  def gameLoop(characterBoard: List[Character], randomCharacter: Character): String = {
    // Print the enumerated list of character names
    println(enumerateNames(getCharacterNamesAsList(characterBoard)).mkString("\n"))

    println("\nQuestions:")
    questions.foreach(println)

    val userInput = readLine("Enter the number of your question: ")

    // Added input validation
    if (userInput.matches("\\d+") && userInput.toInt >= 1 && userInput.toInt <= 11) {
      val input = userInput.toInt

      if (input == 11) {
        val guess = readLine("Enter the name of the character you want to guess: ")
        // Check if the user's guess is correct
        if (guess.equalsIgnoreCase(randomCharacter.name)) {
          s"Congratulations! You guessed correctly. The character was ${randomCharacter.name}."
        } else {
          s"Wrong guess! The character is not $guess."
        }
      } else {
        val (filteredBoard, matches) = filterByCharacteristic(input, characterBoard, randomCharacter)
        println(s"Matches characteristic? $matches")
        println(s"Characters remaining: ${filteredBoard.map(_.name).mkString(", ")}")
        // Recursively call gameLoop with the filtered board
        if (filteredBoard.isEmpty) {
          s"No characters remaining. The character was ${randomCharacter.name}."
        } else {
          gameLoop(filteredBoard, randomCharacter)
        }
      }
    } else {
      println("Invalid input. Please enter a number between 1 and 11.")
      gameLoop(characterBoard, randomCharacter)
    }
  }

  println(gameLoop(allCharacters, randomCharacter))
}
