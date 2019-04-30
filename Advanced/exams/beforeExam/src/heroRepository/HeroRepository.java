package heroRepository;

import java.util.HashMap;
import java.util.Map;

public class HeroRepository {
        private Map<String, Hero> data;

    public HeroRepository() {
        data = new HashMap<>();
    }


    public void add(Hero entity) {
        this.data.putIfAbsent(entity.getName(), entity);
    }

    public void remove(String name) {
        this.data.remove(name);
    }

    public Hero getHeroWithHighestStrength() {
        String heroName = data.keySet().stream()
                .sorted((f, s) ->
                        Integer.compare(data.get(s).getItem().getStrength(),data.get(f).getItem().getStrength()))
        .toArray()[0].toString();
        return  this.data.get(heroName);
    }

    public Hero getHeroWithHighestAgility() {
        String heroName = data.keySet().stream()
                .sorted((f, s) ->
                        Integer.compare(data.get(s).getItem().getAgility(),data.get(f).getItem().getAgility()))
                .toArray()[0].toString();
        return  this.data.get(heroName);
    }

    public Hero getHeroWithHighestIntelligence() {
        String heroName = data.keySet().stream()
                .sorted((f, s) ->
                        Integer.compare(data.get(s).getItem().getIntelligence(),data.get(f).getItem().getIntelligence()))
                .toArray()[0].toString();
        return  this.data.get(heroName);
    }

    public int getCount(){
        return this.data.size();
    }

    @Override
    public String toString() {
        String heroRepo = "";
        for (String name : data.keySet()) {
            heroRepo += "%n" + this.data.get(name).toString();
        }
        return heroRepo;
    }
}
