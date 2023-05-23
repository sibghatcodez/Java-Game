import java.util.Scanner;
import java.util.Random;

class NewClass {

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] enemies = { "Superman", "Spiderman", "Doodieman", "ArslanAsh", "Godzilla" };
        String[] moves = { "c", "f", "p" };
        Random rand = new Random();
        int index = rand.nextInt(enemies.length);
        String randomEnemy = enemies[index];

        System.out.println(YELLOW + "\n\n\t\t\t\tConsole Combat: " + WHITE + "Tekken Tournament");
        System.out.print("\n\t\t-> Choose your username: " + CYAN);
        String userName = scanner.next();
        int userHealth = rand.nextInt(31) + 70;
        int enemyHealth = rand.nextInt(31) + 70;

        System.out.println("\t\t\t\t>> Match started! <<");
        System.out.println(
                "\t\t\t\t" + CYAN + "" + userName + "" + WHITE + " V/S " + BLUE + "" + randomEnemy + "" + WHITE);
        System.out.println(
                "\t\t\t\t" + CYAN + "" + userName + "'s: " + GREEN + " hp " + userHealth + "" + WHITE);
        System.out.println(
                "\t\t\t\t" + CYAN + "" + randomEnemy + "'s: " + GREEN + " hp " + enemyHealth + "" + WHITE);
        System.out
                .println(RED + "\t\t\t\t\t\t\tMOVES: (c) to COBRA CLUTCH | (f) to Flying kick | (p) to Punch" + WHITE);

        while (userHealth > 0 && enemyHealth > 0) {
            System.out.print("\t\t\t\t\t\t\tPLAY MOVE: ");
            String userMove = scanner.next();
            int i = rand.nextInt(moves.length);
            String enemyMove = moves[i];

            if (userMove.equals("c") && enemyMove.equals("c")) {
                System.out.println(
                        BLUE + "\n\t\t\t\t->> Health decreases after enemy attack! <<-"
                                + WHITE);
                userHealth -= 5;
                enemyHealth -= 5;
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);
            } else if (userMove.equals("c") && enemyMove.equals("f")) {
                System.out.println(BLUE + "\n\t\t\t\t->> Enemy strikes back, health falls <<-" + WHITE);
                userHealth -= 10;
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);

            } else if (userMove.equals("c") && enemyMove.equals("p")) {
                System.out.println(
                        BLUE + "\n\t\t\t\t->> " + userName + " applies Cobra Clutch! Enemy health falls <<-" + WHITE);
                enemyHealth -= 15;
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);

            } else if (userMove.equals("f") && enemyMove.equals("c")) {
                System.out.println(
                        BLUE + "\n\t\t\t\t->> " + userName + " strikes with a flying kick! Enemy health falls <<-"
                                + WHITE);
                enemyHealth -= 10;
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);

            } else if (userMove.equals("f") && enemyMove.equals("f")) {
                System.out.println(
                        BLUE + "\n\t\t\t\t->> Both damaged! Battle rages on!! <<-" + WHITE);
                userHealth -= 5;
                enemyHealth -= 5;
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);

            } else if (userMove.equals("f") && enemyMove.equals("p")) {
                System.out.println(BLUE + "\n\t\t\t\t->> Enemy blocks the flying kick! No damage <<-" + WHITE);
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);

            } else if (userMove.equals("p") && enemyMove.equals("c")) {
                System.out
                        .println(BLUE + "\n\t\t\t\t->> " + userName + " punches the enemy! Enemy health falls <<-"
                                + WHITE);
                enemyHealth -= 5;
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);

            } else if (userMove.equals("p") && enemyMove.equals("f")) {
                System.out.println(BLUE + "\n\t\t\t\t->> " + userName + " misses the punch! No damage <<-" + WHITE);
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);

            } else if (userMove.equals("p") && enemyMove.equals("p")) {
                System.out.println(
                        BLUE + "\n\t\t\t\t->> Player wounded, enemy weakened.! <<-"
                                + WHITE);
                userHealth -= 5;
                enemyHealth -= 5;
                userEnemyHP(userName, userHealth, randomEnemy, enemyHealth, rand);
            }
        }
    }

    public static void userEnemyHP(String userName, int userHealth, String randomEnemy, int enemyHealth, Random rand) {
        final String CYAN = "\u001B[36m";
        final String GREEN = "\u001B[32m";
        final String WHITE = "\u001B[37m";
        userHealth -= rand.nextInt(20, 40);
        enemyHealth -= rand.nextInt(20, 40);
        System.out.println("\t\t\t\t" + CYAN + "" + userName + "'s: " + GREEN + " -hp " + userHealth + "" + WHITE);
        System.out.println("\t\t\t\t" + CYAN + "" + randomEnemy + "'s: " + GREEN + "-hp " + enemyHealth + "" + WHITE);
        System.out
                .println(RED + "\t\t\t\t\t\t\tMOVES: (c) to COBRA CLUTCH | (f) to Flying kick | (p) to Punch" + WHITE);

        if (userHealth <= 0) {
            System.out.println(RED + "\n\t\t\t\t->> " + randomEnemy + " wins the match by KO! <<-" + WHITE);
            System.exit(0);
        } else if (enemyHealth <= 0) {
            System.out.println(GREEN_BG + "\n\t\t\t\t->> " + userName + " wins the match by KO! <<-" + WHITE);
            System.exit(0);
        }
    }
}
