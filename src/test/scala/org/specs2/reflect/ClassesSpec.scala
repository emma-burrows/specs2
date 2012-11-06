package org.specs2
package reflect

import specification.Grouped
import Classes._

class ClassesSpec extends Specification with Grouped { def is =

  "it is possible to instantiate a Specification" ^
    "from a class name" ! g1.e1^
    "from a class having a parameter having a no-args constructor" ! g1.e2^
    "from a nested class" ! g1.e3^
    "from an object name" ! g1.e4^
  end

  "instantiations" - new g1 {

    e1 := tryToCreateObject[Specification]("org.specs2.reflect.FromClassName") must beSome
    e2 := tryToCreateObject[Specification]("org.specs2.reflect.FromClassNameWithArg") must beSome
    e3 := tryToCreateObject[Specification]("org.specs2.reflect.ClassesSpec$FromNestedClass") must beSome
    e4 := tryToCreateObject[Specification]("org.specs2.reflect.FromObjectName$") must beSome

  }

  class FromNestedClass extends Specification  { def is = ok }
}

class FromClassName extends Specification { def is = ok }

class System2
class System1(system2: System2)
class FromClassNameWithArg(system: System1) extends Specification  { def is = ok }

object FromObjectName extends Specification { def is = ok }
