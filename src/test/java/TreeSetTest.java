import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TreeSetTest {


    private TreeSet<MyTreeSet> myTreeSets;

    @Before
    public void setUp() throws Exception {
        myTreeSets = new TreeSet<MyTreeSet>(){{
            add(new MyTreeSet("0",0));
            add(new MyTreeSet("1",1));
            add(new MyTreeSet("2",2));
        }};
    }

    @Test
    public void should_add_unrepeated_elements_into_collections() throws Exception {
        TreeSet<MyTreeSet> clone = (TreeSet<MyTreeSet>) myTreeSets.clone();

        myTreeSets.addAll(clone);

        assertThat(myTreeSets.size(),is(3));
    }
    @Test
    public void should_add_get_least_element_for_ceiling() throws Exception {
        MyTreeSet set1 = new MyTreeSet("5", 2);
        MyTreeSet ceiling = myTreeSets.ceiling(set1);
        assertThat(ceiling.getName(),is("2"));
    }


}
