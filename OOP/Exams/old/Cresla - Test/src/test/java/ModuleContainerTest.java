import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ModuleContainerTest {

    private static final int ENERGY_OUTPUT = 10;
    private static final int HEAT_ABSORBING = 10;
    private static final int MODULE_CAPACITY = 2;
    private ModuleContainer moduleContainer;
    //TODO: Check Constructor
    @Before
    public void setUp() {
        this.moduleContainer = new ModuleContainer(MODULE_CAPACITY);
    }

    //Add Energy
    private EnergyModule seedEnergyMockitoModule(){
        EnergyModule energyModuleMockito = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMockito.getId()).thenReturn(1);
        Mockito.when(energyModuleMockito.getEnergyOutput()).thenReturn(ENERGY_OUTPUT);

        return energyModuleMockito;
    }


    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleShouldThrowForNull() {
        this.moduleContainer.addEnergyModule(null);
    }

    @Test
    public void addEnergyModuleShouldAddOneSuccessfull() {
        EnergyModule energyModule = this.seedEnergyMockitoModule();
        this.moduleContainer.addEnergyModule(energyModule);
        try {
            Field energyModulesField = this.moduleContainer.getClass().getDeclaredField("energyModules");
            energyModulesField.setAccessible(true);
            Map<Integer, EnergyModule> energyModulesMap = (Map<Integer, EnergyModule>) energyModulesField.get(moduleContainer);
            assertEquals(1, energyModulesMap.size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

@Test
    public void addEnergyModuleShouldAddOneSuccessfullMoreThanCapacity() {
        EnergyModule energyModule1 = this.seedEnergyMockitoModule();

        EnergyModule energyModule2 = this.seedEnergyMockitoModule();
        Mockito.when(energyModule2.getId()).thenReturn(2);

        EnergyModule energyModule3 = this.seedEnergyMockitoModule();
        Mockito.when(energyModule3.getId()).thenReturn(3);

        this.moduleContainer.addEnergyModule(energyModule1);
        this.moduleContainer.addEnergyModule(energyModule2);
        this.moduleContainer.addEnergyModule(energyModule3);
        try {
            Field modulesByInputField = this.moduleContainer.getClass().getDeclaredField("modulesByInput");
            modulesByInputField.setAccessible(true);
            LinkedList<Module> modulesByInputLinkedList = (LinkedList<Module>) modulesByInputField.get(moduleContainer);
            assertEquals(MODULE_CAPACITY, modulesByInputLinkedList.size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }



    //AddAbsorbingModule

    private AbsorbingModule seedAbsorbingModuleMockito() {
        AbsorbingModule absorbingModuleMockito = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMockito.getHeatAbsorbing()).thenReturn(HEAT_ABSORBING);
        return absorbingModuleMockito;
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleShouldThrowForNull() {
        this.moduleContainer.addAbsorbingModule(null);
    }

    @Test
    public void addAbsorbingModuleShouldAddSuccessOne() {
        AbsorbingModule absorbingModule = this.seedAbsorbingModuleMockito();
        Mockito.when(absorbingModule.getId()).thenReturn(11);
        this.moduleContainer.addAbsorbingModule(absorbingModule);
        try {
            Field absorbingModulesField = this.moduleContainer.getClass().getDeclaredField("absorbingModules");
            absorbingModulesField.setAccessible(true);
            Map<Integer, AbsorbingModule> absorbingModulesMap = (Map<Integer, AbsorbingModule>) absorbingModulesField.get(moduleContainer);
            assertEquals(1, absorbingModulesMap.size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addAbsorbingModuleShouldAddMoreThenCapacity() {
        AbsorbingModule absorbingModule = this.seedAbsorbingModuleMockito();
        Mockito.when(absorbingModule.getId()).thenReturn(11);

        AbsorbingModule absorbingModule22 = this.seedAbsorbingModuleMockito();
        Mockito.when(absorbingModule22.getId()).thenReturn(22);

        AbsorbingModule absorbingModule33 = this.seedAbsorbingModuleMockito();
        Mockito.when(absorbingModule33.getId()).thenReturn(33);

        this.moduleContainer.addAbsorbingModule(absorbingModule);
        this.moduleContainer.addAbsorbingModule(absorbingModule22);
        this.moduleContainer.addAbsorbingModule(absorbingModule33);
        try {
            Field modulesByInputField = this.moduleContainer.getClass().getDeclaredField("modulesByInput");
            modulesByInputField.setAccessible(true);
            LinkedList<Module> modulesByInputLinkedList = (LinkedList<Module>) modulesByInputField.get(moduleContainer);
            assertEquals(MODULE_CAPACITY, modulesByInputLinkedList.size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


//    @Test
//    public void addAbsorbingModuleShouldAddMoreThenCapacityCheckAbsorbingModule() {
//        AbsorbingModule absorbingModule = this.seedAbsorbingModuleMockito();
//        Mockito.when(absorbingModule.getId()).thenReturn(11);
//
//        AbsorbingModule absorbingModule22 = this.seedAbsorbingModuleMockito();
//        Mockito.when(absorbingModule22.getId()).thenReturn(22);
//
//        AbsorbingModule absorbingModule33 = this.seedAbsorbingModuleMockito();
//        Mockito.when(absorbingModule33.getId()).thenReturn(33);
//
//        this.moduleContainer.addAbsorbingModule(absorbingModule);
//        this.moduleContainer.addAbsorbingModule(absorbingModule22);
//        this.moduleContainer.addAbsorbingModule(absorbingModule33);
//        try {
//            Field absorbingModulesField = this.moduleContainer.getClass().getDeclaredField("absorbingModules");
//            absorbingModulesField.setAccessible(true);
//            Map<Integer, AbsorbingModule> absorbingModulesMap = (Map<Integer, AbsorbingModule>) absorbingModulesField.get(moduleContainer);
//            assertEquals(3, absorbingModulesMap.size());
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }



    @Test
    public void getTotalEnergyOutput() {
        long totalEneregy = this.moduleContainer.getTotalEnergyOutput();
        assertEquals(0, totalEneregy);
    }

    @Test
    public void getTotalEnergyOutputWithThreeEnergy() {
        EnergyModule energyModule1 = this.seedEnergyMockitoModule();

        EnergyModule energyModule2 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule2.getId()).thenReturn(2);
        Mockito.when(energyModule2.getEnergyOutput()).thenReturn(ENERGY_OUTPUT);

        this.moduleContainer.addEnergyModule(energyModule1);
        this.moduleContainer.addEnergyModule(energyModule2);

        long totalEnergyOutput = this.moduleContainer.getTotalEnergyOutput();
        assertEquals(ENERGY_OUTPUT * 2, totalEnergyOutput);
    }

    @Test
    public void getTotalHeatAbsorbing() {
        assertEquals(0, this.moduleContainer.getTotalHeatAbsorbing());
    }

    @Test
    public void getTotalHeatAbsorbingWithThreeEnergy() {
        AbsorbingModule absorbingModule = this.seedAbsorbingModuleMockito();
        Mockito.when(absorbingModule.getId()).thenReturn(11);

        AbsorbingModule absorbingModule22 = this.seedAbsorbingModuleMockito();
        Mockito.when(absorbingModule22.getId()).thenReturn(22);
        Mockito.when(absorbingModule22.getHeatAbsorbing()).thenReturn(HEAT_ABSORBING);

        this.moduleContainer.addAbsorbingModule(absorbingModule);
        this.moduleContainer.addAbsorbingModule(absorbingModule22);

        long totalHeatAbsorbing = this.moduleContainer.getTotalHeatAbsorbing();
        assertEquals(HEAT_ABSORBING * 2, totalHeatAbsorbing);
    }
}