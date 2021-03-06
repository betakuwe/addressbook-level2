package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {
        // empty list
        assertFalse(Utils.isAnyNull());

        // lists without null objects
        assertFalse(Utils.isAnyNull(1));
        assertFalse(Utils.isAnyNull(1, "2"));
        assertFalse(Utils.isAnyNull(new Object()));
        assertFalse(Utils.isAnyNull(new Object(), new Object()));

        // lists with only one null object
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, 1, "", new Object()));
        assertTrue(Utils.isAnyNull(1, null, "", new Object()));
        assertTrue(Utils.isAnyNull(1, "", new Object(), null));

        // lists with multiple null objects
        assertTrue(Utils.isAnyNull(null, null));
        assertTrue(Utils.isAnyNull(1, null, null));
        assertTrue(Utils.isAnyNull(null, 1, null));
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, Integer.valueOf(1));
        assertNotUnique(null, 1, Integer.valueOf(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

}
