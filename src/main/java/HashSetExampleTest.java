import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HashSetExampleTest {
   @Test
    public void should_initial_hashset_by_one_collection(){
       HashSet hashSet = new HashSet(Arrays.asList(2, 3, 3, 4));
       assertThat(hashSet.size(),is(3));
   }

    @Test
    public void should_add_correct_element_into_hashset() throws Exception {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        hashSet.add(5);
        assertThat(hashSet.iterator().next(),is(5));
    }

    @Test
    public void should_return_true_when_two_objects_are_have_same_name_and_age() throws Exception {
        HashSet<HashSetExample> hashSetExample = new HashSet<HashSetExample>();
        HashSetExample hashSetExample1 = new HashSetExample("first",45);
        HashSetExample hashSetExample2 = new HashSetExample("first",45);
        hashSetExample.add(hashSetExample1);
        hashSetExample.add(hashSetExample2);

        boolean equals = hashSetExample1.equals(hashSetExample2);
        assertThat(equals,is(true));
        assertThat(hashSetExample.size(),is(1));
    }
    @Test
    public void should_return_false_when_two_objects_have_different_age() throws Exception {
        HashSet<HashSetExample> hashSetExample = new HashSet<HashSetExample>();
        HashSetExample hashSetExample1 = new HashSetExample("first",46);
        HashSetExample hashSetExample2 = new HashSetExample("first",45);
        hashSetExample.add(hashSetExample1);
        hashSetExample.add(hashSetExample2);

        boolean equals = hashSetExample1.equals(hashSetExample2);
        assertThat(equals,is(false));
        assertThat(hashSetExample.size(),is(2));
    }
    @Test
    public void should_return_false_when_two_objects_have_different_name() throws Exception {
        HashSet<HashSetExample> hashSetExample = new HashSet<HashSetExample>();
        HashSetExample hashSetExample1 = new HashSetExample("first",45);
        HashSetExample hashSetExample2 = new HashSetExample("second",45);
        hashSetExample.add(hashSetExample1);
        hashSetExample.add(hashSetExample2);

        boolean equals = hashSetExample1.equals(hashSetExample2);
        assertThat(equals,is(false));
        assertThat(hashSetExample.size(),is(2));
    }

    @Test
    public void should_get_same_hash_code_for_example_with_same_name_and_age() throws Exception {
        HashSet<HashSetExample> hashSetExample = new HashSet<HashSetExample>();
        HashSetExample hashSetExample1 = new HashSetExample("first",45);
        HashSetExample hashSetExample2 = new HashSetExample("first",45);
        hashSetExample.add(hashSetExample1);
        hashSetExample.add(hashSetExample2);
        assertTrue(hashSetExample1.hashCode()==hashSetExample2.hashCode());

    }
}
