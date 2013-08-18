import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HashMapTest {

    private HashMap hashMap;

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMap();
    }

    @Test
    public void should_add_object_to_map_when_key_equals_but_object_differs() throws Exception {
        hashMap.put("1", new Integer(0));
        hashMap.put("1", new Integer(10));
        assertThat(hashMap.size(), is(1));
    }

    @Test
    public void should_put_object_in_when_key_is_null() throws Exception {
        hashMap.put(null,3);

        assertThat((Integer) hashMap.get(null),is(3));
    }
}
