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

}