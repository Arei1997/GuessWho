import scala.util.Random
object GuessWho extends App {


  case class character(name: String,
                       hairColour: String,
                       eyeColour: String,
                       glasses: Boolean,
                       earRings: Boolean,
                       gender: String,
                       facialHair: Boolean){
    def hasGlasses(): Boolean=this.glasses
  }


  val person1: character = character(name = "James", hairColour = "Black", eyeColour = "Black", glasses = true, earRings = true, gender = "male", facialHair = true)
  val person2: character = character(name = "Dave", hairColour = "Black", eyeColour = "Black", glasses = true, earRings = true, gender = "male", facialHair = true)
  val person3: character = character(name = "Maria", hairColour = "Blonde", eyeColour = "Black", glasses = false, earRings = true, gender = "female", facialHair = false)

  val characters: List[character] = List(person1, person2, person3)


  def glassesFilter(characters:List[character],glasses:Boolean):List[character] = {
    characters.filter(_.hasGlasses() == glasses)
  }


//  def pickRandomPerson(characters: List[character]): character = {
//    characters(Random.nextInt(characters.length))
//  }

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
  )


  val questionsMap: Map = (
    1 -> character.haircolourcheck,
    6 -> character.hasglasses(),
  )

}