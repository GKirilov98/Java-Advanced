import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private Axe axe;
    private Dummy dummy;

    @Before
    public void initialised(){
        axe = new Axe(RGPConst.AXE_ATTACK,
                RGPConst.AXE_DURABILITY);
        dummy = new Dummy(RGPConst.DUMMY_HEALTH,
                RGPConst.DUMMY_EXPERIENCE);
    }

    @Test
    public void shouldWeaponLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(RGPConst.AXE_DURABILITY - 1,
                axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldIfAttackWithBrokenWeaponThrowError(){
        axe.attack(dummy);
        axe.attack(dummy);
    }
}
