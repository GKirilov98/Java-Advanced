package panzer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import panzer.contracts.*;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AssemblerTest {
    abstract class PartsImpl implements Part {
        private String model;
        private double weight;
        private BigDecimal price;

        protected PartsImpl(String model, double weight, BigDecimal price) {
            this.model = model;
            this.weight = weight;
            this.price = price;
        }

        @Override
        public double getWeight() {
            return this.weight;
        }

        @Override
        public BigDecimal getPrice() {
            return this.price;
        }

        @Override
        public String getModel() {
            return this.model;
        }

        @Override
        public String toString() {
            throw new Error("Eh NiceTry");
            //return "PartsImpl{}";
        }
    }
    class ArsenalPart extends PartsImpl implements AttackModifyingPart {
        private int attackModifier;

        public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
            super(model, weight, price);
            this.attackModifier = attackModifier;
        }

        @Override
        public int getAttackModifier() {
            return this.attackModifier;
        }
    }
    class EndurancePart extends PartsImpl implements HitPointsModifyingPart {
        private int hitPointsModifier;

        public EndurancePart(String model, double weight, BigDecimal price, int hitPointsModifier) {
            super(model, weight, price);
            this.hitPointsModifier = hitPointsModifier;
        }

        @Override
        public int getHitPointsModifier() {
            return this.hitPointsModifier;
        }
    }
    class ShellPart extends PartsImpl implements DefenseModifyingPart {

        private int defenseModifier;

        public ShellPart(String model, double weight, BigDecimal price, int defenseModifier) {
            super(model, weight, price);
            this.defenseModifier = defenseModifier;
        }

        @Override
        public int getDefenseModifier() {
            return this.defenseModifier;
        }
    }


    private static double WEIGHT_PART = 50.0;
    private static BigDecimal PRICE_PART = new BigDecimal(1000);
    private static long MODIFIER_PART_LONG = 10;
    private static int MODIFIER_PART = 10;


    private final Part ARSENAL_PART = new ArsenalPart("Arsenal", WEIGHT_PART, PRICE_PART, MODIFIER_PART);
    private final Part ENDURANCE_PART = new EndurancePart("Endurance", WEIGHT_PART, PRICE_PART, MODIFIER_PART);
    private final Part SHELL_PART = new ShellPart("Shell", WEIGHT_PART, PRICE_PART, MODIFIER_PART);

    Assembler assembler;

    @Before
    public void createAssembler() {
        assembler = new VehicleAssembler();
        assembler.addArsenalPart(ARSENAL_PART);
        assembler.addEndurancePart(ENDURANCE_PART);
        assembler.addShellPart(SHELL_PART);
    }

    @Test
    public void constructorShouldBeCreatedSuccessful(){
        try {
            Field arsenalParts = assembler.getClass().getDeclaredField("arsenalParts");
            arsenalParts.setAccessible(true);
            arsenalParts.getClass().getSimpleName();
            Assert.assertEquals( 1, ((Collection<? extends Part>) arsenalParts.get(assembler)).size());
        } catch (NoSuchFieldException  e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldArsenalModelGetModel(){
        try {
            Field arsenalParts = assembler.getClass().getDeclaredField("arsenalParts");
            arsenalParts.setAccessible(true);
            List<Part> part = (List<Part>) arsenalParts.get(assembler);
          Assert.assertEquals  ("Arsenal", part.get(0).getModel());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //Add
    @Test
    public void addArsenalPartShouldAddCorrectly(){
        List<Part> partList = new ArrayList<>();
        try {
            Field arsenalParts = assembler.getClass().getDeclaredField("arsenalParts");
            arsenalParts.setAccessible(true);
           partList.addAll((Collection<? extends Part>) arsenalParts.get(assembler));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(ARSENAL_PART, partList.get(0));
    }

    //AddWrong
    @Test(expected = ClassCastException.class)
    public void addArsenalPartShouldAddWrong(){
        assembler.addArsenalPart(SHELL_PART);
    }

    @Test(expected = ClassCastException.class)
    public void addArsenalPartShouldAddWrongSecond(){
        assembler.addArsenalPart(ENDURANCE_PART);
    }

    @Test(expected = ClassCastException.class)
    public void addShellPartShouldAddWrong(){
        assembler.addShellPart(ARSENAL_PART);
    }

    @Test(expected = ClassCastException.class)
    public void addShellPartShouldAddWrongSecond(){
        assembler.addArsenalPart(ENDURANCE_PART);
    }

    @Test(expected = ClassCastException.class)
    public void addEndurancePartShouldAddWrong(){
        assembler.addShellPart(ARSENAL_PART);
    }

    @Test(expected = ClassCastException.class)
    public void addEndurancePartShouldAddWrongSecond(){
        assembler.addEndurancePart(SHELL_PART);
    }

    //AddCorrectly
    @Test
    public void addEndurancePartShouldAddCorrectly(){
        List<Part> partList = new ArrayList<>();
        try {
            Field enduranceParts = assembler.getClass().getDeclaredField("enduranceParts");
            enduranceParts.setAccessible(true);
            partList.addAll((Collection<? extends Part>) enduranceParts.get(assembler));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(ENDURANCE_PART, partList.get(0));
    }

    @Test
    public void addShellPartShouldAddCorrectly(){
        List<Part> partList = new ArrayList<>();
        try {
            Field shellParts = assembler.getClass().getDeclaredField("shellParts");
            shellParts.setAccessible(true);
            partList.addAll((Collection<? extends Part>) shellParts.get(assembler));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(SHELL_PART, partList.get(0));
    }

    //TotalWeight
    @Test
    public void getTotalWeightShouldWorkCorrectly(){
        double totalWeight = assembler.getTotalWeight();
        Assert.assertEquals(WEIGHT_PART * 3, totalWeight, 0.01);
    }

    //TotalPrice
    @Test
    public void getTotalPriceShouldWorkCorrectly(){
        BigDecimal totalWeight = assembler.getTotalPrice();
        Assert.assertEquals(PRICE_PART.multiply(BigDecimal.valueOf(3)), totalWeight);
    }

    //Modifier
    @Test
    public void getAttackModifierShouldWorkCorrectly(){
        Assert.assertEquals(MODIFIER_PART_LONG, assembler.getTotalAttackModification());
    }

    @Test
    public void getTotalDefenseModificationShouldWorkCorrectly(){
        Assert.assertEquals(MODIFIER_PART_LONG, assembler.getTotalDefenseModification());
    }

    @Test
    public void getTotalHitPointModificationShouldWorkCorrectly(){
        Assert.assertEquals(MODIFIER_PART_LONG, assembler.getTotalHitPointModification());
    }
}
