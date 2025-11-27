package homework02;

import java.util.Scanner;

public class TarakanRaceAppl {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of tarakans: ");
        int tarakanCount = scanner.nextInt();
        System.out.print("Enter race distance (iteration): ");
        int distance = scanner.nextInt();
        TarakanRace race = new TarakanRace(distance, tarakanCount);
        race.startRace();
    }
}
