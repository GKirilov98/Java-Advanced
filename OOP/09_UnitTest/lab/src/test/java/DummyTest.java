import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private Dummy dummy;

    @Before
    public void initialised(){
        dummy = new Dummy(RGPConst.DUMMY_HEALTH,
                RGPConst.DUMMY_EXPERIENCE);
    }

    @Test
    public void shouldLoseHPIfAttacked(){
        dummy.takeAttack(RGPConst.DUMMY_TAKEATTACK);
        Assert.assertEquals(
                RGPConst.DUMMY_HEALTH - RGPConst.DUMMY_TAKEATTACK,
                dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowErrorForDeadDummyAttacked(){
        dummy.takeAttack(Integer.MAX_VALUE);
        dummy.takeAttack(RGPConst.DUMMY_TAKEATTACK);
    }

    @Test
    public void shouldDeadDummyCanGiveExperience(){
        dummy.takeAttack(Integer.MAX_VALUE);
        Assert.assertEquals( RGPConst.DUMMY_EXPERIENCE,dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldAliveDummyCanNotGiveExperience(){
        dummy.giveExperience();
    }
}
