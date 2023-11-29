package _8_Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split(", ");

        Article article = new Article(tokens[0], tokens[1], tokens[2]);

        int cnt = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < cnt; i++) {
            tokens = scan.nextLine().split(": ");
            String command = tokens[0];
            String newElement = tokens[1];

            if (command.equals("Edit")) {
                article.edit(newElement);
            } else if (command.equals("ChangeAuthor")) {
                article.changeAuthor(newElement);
            } else if (command.equals("Rename")) {
                article.rename(newElement);
            }
        }
        System.out.println(article.toString());
    }
}
