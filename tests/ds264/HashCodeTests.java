package ds264;

import org.junit.jupiter.api.Test;

public class HashCodeTests {



    @Test void xx() {
        Integer i = 22;

        int hcode  = i.hashCode();

        Boolean fact = true;
        hcode = fact.hashCode();

        String name = "joe";
        hcode = name.hashCode();

        hcode = name.hashCode();



        String s1 = "134463457";
        String s2 = "134463215";

        int s1hash = s1.hashCode();
        int s2hash = s2.hashCode();

         s2hash = s2.hashCode();

    }
}
