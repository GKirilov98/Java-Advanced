import Interfaces.Target;
import Interfaces.Weapon;
import fake.FakeAxe;
import fake.FakeDummy;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    static final int TARGET_EXPERIENCES = 10;

    @Test
    public void shouldHeroGainsExperienceWhenTargetDies(){
        FakeAxe fakeAxe = new FakeAxe();
        FakeDummy fakeDummy = new FakeDummy();
        Hero hero = new Hero(RGPConst.HERO_NAME, fakeAxe);
        int experienceBeforeAttack = hero.getExperience();
        hero.attack(fakeDummy);
        Assert.assertEquals(experienceBeforeAttack + fakeDummy.giveExperience(),
                hero.getExperience());

    }

    //MOCKITO TEST
    @Test
    public void shouldHeroGainsExperienceWithMockitoTest(){
        Weapon mockitoWeapon = Mockito.mock(Weapon.class);
        Target mockitoTarget = Mockito.mock(Target.class);

        Mockito.when(mockitoTarget.isDead()).thenReturn(true);
        Mockito.when(mockitoTarget.giveExperience()).thenReturn(RGPConst.DUMMY_EXPERIENCE);

        Hero hero = new Hero(RGPConst.HERO_NAME, mockitoWeapon);
        hero.attack(mockitoTarget);
        Assert.assertEquals( RGPConst.DUMMY_EXPERIENCE, hero.getExperience());
    }
}
