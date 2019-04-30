import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

public class DatabaseTests {

    private static final Integer[] INITIAL_DATA = new Integer[]{1, 2, 3};
    private static final int INVALID_SIZE_ARR = 17;
    private static final int ELEMENT_TO_ADD = 12;
    private Database db;

    @Before
    public void createDB() throws OperationNotSupportedException {
         db = new Database(INITIAL_DATA);
    }

    //Constructor
    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowCapacityErrorMoreThan16() throws OperationNotSupportedException {
        Database db = new Database(new Integer[INVALID_SIZE_ARR]);
    }

    @Test
    public void constructorShouldSuccessCreateDB() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Field elementsCount = Database.class.getDeclaredField("elementsCount");
        elementsCount.setAccessible(true);
        Assert.assertEquals(INITIAL_DATA.length, elementsCount.getInt(this.db));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowCapacityErrorLessThan1() throws OperationNotSupportedException {
        Database db = new Database();
    }

    //Add
    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowErrorForNullElement() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test
    public void addShouldAddSuccess() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Field elementsCount = Database.class.getDeclaredField("elementsCount");
        elementsCount.setAccessible(true);
        int dbLength = elementsCount.getInt(this.db);
        this.db.add(ELEMENT_TO_ADD);
        Assert.assertEquals(dbLength + 1, INITIAL_DATA.length + 1);
    }

    //Remove
    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowError() throws OperationNotSupportedException {
        for (int i = 0; i < INITIAL_DATA.length + 1; i++) {
            db.remove();
        }
    }

    @Test
    public void removeShouldSuccessRemoveElement() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        db.remove();
        Field elementsCount = Database.class.getDeclaredField("elementsCount");
        elementsCount.setAccessible(true);
        int dbLength = elementsCount.getInt(this.db);
        Assert.assertEquals(INITIAL_DATA.length - 1, dbLength);
    }

    //GetElements
    @Test
    public void getElementShouldNotGetNullValue() throws OperationNotSupportedException {
        Database db = new Database(INITIAL_DATA);
        Assert.assertArrayEquals(INITIAL_DATA, db.getElements());
    }
}
