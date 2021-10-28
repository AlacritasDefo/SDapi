package api.swapi;

import api.ApiJsonStringLoader;
import api.swapi.model.Planet;
import api.swapi.repository.PlanetRepository;
import controller.Menu;
import controller.MenuItem;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class SwapiApp {
    private static PlanetRepository planetRepository = new PlanetRepository();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Menu menu = new Menu(
                List.of(
                        MenuItem.builder()
                                .lable("Wyświetl planety")
                                .action(() -> {
                                    for(var planet: planetRepository.findAll()){
                                        System.out.printf("%-30s %12s\n", planet.getName(), planet.getPopulation());
                                    }

                                })
                                .build(),
                        MenuItem.builder()
                                .lable("Wybierz planetę")
                                .action(() -> {
                                    System.out.println("Wybrana planeta");
                                })

                                .build(),
                        MenuItem.builder()
                                .lable("Wyjście")
                                .action(() -> {
                                    System.exit(0);
                                })
                                .build()


                ));
        //TODO dodać kod sprawdzający czy wpisany numer opcji jest liczbą (int)
        while (true) {
            menu.print();
            if (scanner.hasNextInt()){
                int option = scanner.nextInt();
                menu.execute(option);
            }
            else {
                scanner.nextLine();
                System.out.println("Podaj numer opcji z menu");
            }

        }


    }
}
