import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ListIteratorTests {
    private static final String[] STRINGS_INITIAL = new String[]{"One", "Two", "Three"};


    private ListIterator listIterator;

    @Before
    public void createListIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator(STRINGS_INITIAL);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowErrorForNull() throws OperationNotSupportedException {
        ListIterator listIteratorNull = new ListIterator(null);
    }

    @Test
    public void constructorShouldCreateListIteratorCorrectly() throws NoSuchFieldException, IllegalAccessException {
        Field elements = ListIterator.class.getDeclaredField("elements");
        elements.setAccessible(true);
        Assert.assertEquals(Arrays.toString(STRINGS_INITIAL).length(), elements.get(listIterator).toString().length());
    }

    @Test
    public void moveShouldGiveFalse() {
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.move());

    }

    @Test
    public void moveShouldGiveTrue() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void printShouldGiveOneAsString() {
        Assert.assertEquals(STRINGS_INITIAL[0], listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldThrowErrorForSizeZeroListIterator() throws OperationNotSupportedException {
        ListIterator listIteratorNull = new ListIterator(new String[0]);
        listIteratorNull.print();
    }
}
