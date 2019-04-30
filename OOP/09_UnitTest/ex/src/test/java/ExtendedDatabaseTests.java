import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;


public class ExtendedDatabaseTests {
    private static final Person PERSON_INITIAL = new Person(1, "Gosho");
    private static final Person SECOND_PERSON_INITIAL = new Person(PERSON_INITIAL.getId() + 1, PERSON_INITIAL.getUsername() + "Test");
    private Database db;

    @Before
    public void createDB() throws OperationNotSupportedException {
        db = new Database(PERSON_INITIAL);
    }

    @Test
    public void constructorShouldCorrectCreateDB() {
        Assert.assertEquals(1, db.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addShouldThrowErrorForNull() throws OperationNotSupportedException {
        db.add(null);
    }

    @Test
    public void addShouldAddPerson() throws OperationNotSupportedException {
        db.add(SECOND_PERSON_INITIAL);
        Assert.assertEquals(2, db.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeShouldThrowErrorForZeroLength() throws OperationNotSupportedException {
        db.remove();
        db.remove();
    }

    @Test
    public void removeShouldRemoveSuccess() throws OperationNotSupportedException {
        db.remove();
        Assert.assertEquals(0,db.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdShouldThrowErrorForMoreThanOneSameId() throws OperationNotSupportedException {
        db.add(PERSON_INITIAL);
        db.findById(PERSON_INITIAL.getId());
    }

    @Test
    public void findByIdShouldWorkCorrectly() throws OperationNotSupportedException {
        db.add(SECOND_PERSON_INITIAL);
        Assert.assertEquals(PERSON_INITIAL, db.findById(PERSON_INITIAL.getId()));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowErrorForMoreThanOneSameId() throws OperationNotSupportedException {
        db.add(PERSON_INITIAL);
        db.findByUsername(PERSON_INITIAL.getUsername());
    }

    @Test
    public void findByUsernameShouldWorkCorrectly() throws OperationNotSupportedException {
        db.add(SECOND_PERSON_INITIAL);
        Assert.assertEquals(PERSON_INITIAL, db.findByUsername(PERSON_INITIAL.getUsername()));
    }

}
