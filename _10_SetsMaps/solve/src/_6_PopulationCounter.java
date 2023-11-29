import java.util.*;
import java.util.stream.Collectors;

public class _6_PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        String input = scan.nextLine();

        Map<String, Country> info = new TreeMap<>();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");

            String cityName = tokens[0];
            String countryName = tokens[1];
            long population = Long.parseLong(tokens[2]);

            info.putIfAbsent(countryName, new Country(countryName, 0));
            Country country = info.get(countryName);


            City city = new City(cityName, population);

            country.getCities().add(city);

            country.setPopulation(country.getPopulation() + population);

            input = scan.nextLine();
        }

        List<Country> sortedCollect = info.values()
                .stream()
                .sorted()
                .toList();

        for (Country country : sortedCollect) {
            System.out.println(country.toString());
        }
    }

    public static class City implements Comparable<City>{
        private String name;
        private long population;

        public City(String name, long population) {
            this.name = name;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }

        @Override
        public int compareTo(City other) {
            return Long.compare(other.getPopulation(), this.getPopulation());
        }
    }

    public static class Country implements Comparable<Country> {
        private String name;
        private List<City> cities;
        private long population;

        public Country(String name, int population) {
            this.name = name;
            this.cities = new ArrayList<>();
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<City> getCities() {
            return cities;
        }

        public void setCities(List<City> cities) {
            this.cities = cities;
        }

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("%s (total population: %d)%n", this.name, this.population));

            this.cities
                    .stream()
                    .sorted()
                    .forEach(c -> stringBuilder.append(String.format("=>%s: %d%n", c.getName(), c.getPopulation())));

            return stringBuilder.toString().trim();
        }

        @Override
        public int compareTo(Country other) {
            return Long.compare(other.getPopulation(), this.getPopulation());
        }
    }
}
