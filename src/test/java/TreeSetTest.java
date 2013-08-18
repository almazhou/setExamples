import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class TreeSetTest {


    private TreeSet<MyTreeSet> myTreeSets;

    @Before
    public void setUp() throws Exception {
        myTreeSets = new TreeSet<MyTreeSet>() {{
            add(new MyTreeSet("0", 0));
            add(new MyTreeSet("1", 1));
            add(new MyTreeSet("2", 2));
        }};
    }

    @Test
    public void should_add_unrepeated_elements_into_collections() throws Exception {
        TreeSet<MyTreeSet> clone = (TreeSet<MyTreeSet>) myTreeSets.clone();

        myTreeSets.addAll(clone);

        assertThat(myTreeSets.size(), is(3));
    }

    @Test
    public void should_add_get_least_element_for_ceiling() throws Exception {
        MyTreeSet set1 = new MyTreeSet("5", 2);
        MyTreeSet ceiling = myTreeSets.ceiling(set1);
        assertThat(ceiling.getName(), is("2"));
    }

    @Test
    public void should_the_comparator_of_tree_set_be_null() throws Exception {
        assertThat(myTreeSets.comparator(), nullValue());
    }

    @Test
    public void should_get_descending_iterator() throws Exception {
        Iterator<MyTreeSet> myTreeSetIterator = myTreeSets.descendingIterator();
        assertThat(myTreeSetIterator.next().getName(), is("2"));
    }

    @Test
    public void should_get_reverse_set_by_using_descending_set() throws Exception {
        NavigableSet<MyTreeSet> myTreeSets1 = myTreeSets.descendingSet();
        assertThat(myTreeSets1.iterator().next().getName(), is("2"));
    }

    @Test
    public void should_get_lowest_element_using_first() throws Exception {
        assertThat(myTreeSets.first().getName(), is("0"));

    }

    @Test
    public void should_get_greatest_element_less_than_given_element() throws Exception {
        MyTreeSet floor = myTreeSets.floor(new MyTreeSet("4", 4));
        assertThat(floor.getName(), is("2"));
    }

    @Test
    public void should_get_subset_which_less_than_specific_element_using_headset() throws Exception {
        SortedSet<MyTreeSet> myTreeSets1 = myTreeSets.headSet(new MyTreeSet("2", 2));
        assertThat(myTreeSets1.size(), is(2));
    }

    @Test
    public void should_get_subset_no_more_than_given_element_using_headset() throws Exception {
        NavigableSet<MyTreeSet> myTreeSets1 = myTreeSets.headSet(new MyTreeSet("2", 2), true);
        assertThat(myTreeSets1.size(), is(3));
    }

    @Test
    public void should_get_element_greater_than_given_element_by_using_higher() throws Exception {
        MyTreeSet higher = myTreeSets.higher(new MyTreeSet("0", 0));
        assertThat(higher.getName(), is("1"));
    }

    @Test
    public void should_get_highest_element_when_using_last() throws Exception {
        MyTreeSet last = myTreeSets.last();
        assertThat(last.getName(), is("2"));
    }

    @Test
    public void should_get_lower_element_by_using_lower() throws Exception {
        MyTreeSet lower = myTreeSets.lower(new MyTreeSet("2", 2));
        assertThat(lower.getName(), is("1"));
    }

    @Test
    public void should_get_remove_the_first_element_by_using_pollfirst() throws Exception {
        MyTreeSet myTreeSet = myTreeSets.pollFirst();
        assertThat(myTreeSet.getName(), is("0"));
        assertThat(myTreeSets.size(), is(2));
    }

    @Test
    public void should_remove_last_element_by_using_polllast() throws Exception {
        MyTreeSet myTreeSet = myTreeSets.pollLast();
        assertThat(myTreeSet.getName(), is("2"));
        assertThat(myTreeSets.size(), is(2));
    }

    @Test
    public void should_not_remove_when_there_is_not_this_element() throws Exception {
        boolean remove = myTreeSets.remove(new MyTreeSet("1", 2));
        assertThat(remove, is(true));
        assertThat(myTreeSets.size(), is(2));
    }

    @Test
    public void should_get_subset_greater_than_and_less_than_by_using_subset() throws Exception {
        boolean inclusive = false;
        boolean exclusive = false;
        NavigableSet<MyTreeSet> myTreeSets1 = createSubset(inclusive, exclusive);
        assertThat(myTreeSets1.size(), is(1));
        NavigableSet<MyTreeSet> subset = createSubset(true, false);
        assertThat(subset.size(), is(2));
        NavigableSet<MyTreeSet> subset1 = createSubset(true, true);
        assertThat(subset1.size(), is(3));
    }

    @Test
    public void should_get_greater_or_equal_to_set_of_given_element() throws Exception {
        SortedSet<MyTreeSet> myTreeSets1 = myTreeSets.tailSet(new MyTreeSet("1", 1));
        assertThat(myTreeSets1.size(), is(2));
    }

    @Test
    public void should_add_new_value_to_replace_old_value_with_same_key() throws Exception {
        List<MyTreeSet> list = Arrays.asList(new MyTreeSet("0", 0));
        HashSet<MyTreeSet> myTreeSets1 = new HashSet<MyTreeSet>(list);
        boolean add = myTreeSets1.add(new MyTreeSet("1", 0));
        System.out.println(Math.pow(2, 30) - (1 << 30));
        assertFalse(add);
        assertThat(myTreeSets.iterator().next().getName(), is("0"));
    }


    private NavigableSet<MyTreeSet> createSubset(boolean inclusive, boolean exclusive) {
        myTreeSets.add(new MyTreeSet("3", 3));
        return myTreeSets.subSet(new MyTreeSet("1", 1), inclusive, new MyTreeSet("3", 3), exclusive);
    }

}
