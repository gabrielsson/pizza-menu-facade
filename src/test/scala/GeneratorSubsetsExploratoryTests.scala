import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.ImmutableMap
import org.paukov.combinatorics3.Generator
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers._
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.collection.JavaConverters._

class GeneratorSubsetsExploratoryTests extends AnyFlatSpec {

  it should
    "generate subsets of strings seq" in {


    val target: java.util.List[String] = Seq("a", "b").asJava

    target.size shouldBe 2
    val subsets = Generator.subset(target).simple().asScala.toSeq

    subsets.size shouldBe 4
    subsets.map(_.asScala.toSeq) should contain inOrder (Seq(), Seq("a"), Seq("b"), Seq("a", "b"))
  }

}
