import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.funsuite.AnyFunSuite


class GuessWhoTests extends AnyFunSuite {

  val person1: GuessWho.Character = GuessWho.Character("James", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = true, hasGlasses = false, hasEarRings = false, isMale = true, hasFacialHair = false)
  val person2: GuessWho.Character = GuessWho.Character("Dave", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = false, hasGlasses = true, hasEarRings = true, isMale = true, hasFacialHair = true)
  val person3: GuessWho.Character = GuessWho.Character("Maria", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = true, isMale = false, hasFacialHair = false)
  val person4: GuessWho.Character = GuessWho.Character("Sarah", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = false, isMale = false, hasFacialHair = false)
  val person5: GuessWho.Character = GuessWho.Character("John", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = false, isMale = true, hasFacialHair = true)
  val person6: GuessWho.Character = GuessWho.Character("Emma", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = true, hasEarRings = false, isMale = false, hasFacialHair = false)
  val person7: GuessWho.Character = GuessWho.Character("Michael", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = true, hasEarRings = false, isMale = true, hasFacialHair = true)
  val person8: GuessWho.Character = GuessWho.Character("Sophia", hasBlackHair = false, hasBlondeHair = true, hasBrownHair = false, hasBlackEyes = false, hasBlueEyes = true, hasGlasses = false, hasEarRings = true, isMale = false, hasFacialHair = false)
  val person9: GuessWho.Character = GuessWho.Character("Daniel", hasBlackHair = true, hasBlondeHair = false, hasBrownHair = false, hasBlackEyes = true, hasBlueEyes = false, hasGlasses = false, hasEarRings = true, isMale = true, hasFacialHair = true)

}