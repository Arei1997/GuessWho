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
  val person1: Character = Character("James", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasRedHair = true, hasBrownEyes = false, hasBlueEyes = true, hasGlasses = true, hasEarRings = true, isMale = true, hasFacialHair = true)
  val person2: Character = Character("Dave", true, false, false, true, false, true, true, true, true, true)
  val person3: Character = Character("Maria", false, true, false, true, false, false, true, false, false, false)
  val person4: Character = Character("Sarah", false, true, false, false, true, false, true, false, false, false)
  val person5: Character = Character("John", true, false, false, true, false, false, false, true, true, true)
  val person6: Character = Character("Emma", false, true, false, true, false, true, true, false, false, false)
  val person7: Character = Character("Michael", true, false, false, true, false, true, false, true, true, false)
  val person8: Character = Character("Sophia", false, true, false, false, true, false, true, false, false, false)
  val person9: Character = Character("Daniel", true, false, false, true, false, false, true, true, true, false)


  val characters: List[Character] = List(person1, person2, person3, person4, person5, person6, person7, person8, person9)

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
  )

  def getRandomCharacter:Character = {

    characters(Random.nextInt(characters.length))
  }

  val randomCharacter: Character = getRandomCharacter

  def filterByCharacteristic(userInput: Int, characterList:List[Character]): List[Character] = {
    val questionsMap: Map[Int, List[Character]] = Map(
      1 -> characterList.filter(_.hasBlackHair),
      2 -> characterList.filter(_.hasBrownHair),
      3 -> characterList.filter(_.hasBlondeHair),
      4 -> characterList.filter(_.hasRedHair),
      5 -> characterList.filter(_.hasBrownEyes),
      6 -> characterList.filter(_.hasBlueEyes),
      7 -> characterList.filter(_.hasGlasses),
      8 -> characterList.filter(_.hasEarRings),
      9 -> characterList.filter(_.isMale),
      10 -> characterList.filter(!_.isMale),
      11 -> characterList.filter(_.hasFacialHair),

    )
    questionsMap(userInput)


  }

  filterByCharacteristic(1, characters)

  def getCharacterNamesAsList(characters:List[Character]): List[String] = {
    characters.map(_.name)
  }


  def enumerateNames(characterList: List[String]): List[String] = {
    characterList.zipWithIndex.map { case (name, index) => s"${index + 1}. $name" }
  }



}

// update the filtered list

// guess character
// choose a character to guess
// whoever is remaining make them an option to choose.