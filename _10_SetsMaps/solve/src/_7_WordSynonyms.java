import java.util.*;

public class _7_WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = Util.scan();

        int cnt = Integer.parseInt(scan.nextLine());

        Map<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < cnt; i++) {
            String key = scan.nextLine();
            synonyms.putIfAbsent(key, new ArrayList<>());

            String synonym = scan.nextLine();
            synonyms.get(key).add(synonym);
        }

        for (String key : synonyms.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(key).append(" - ");

            String join = String.join(", ", synonyms.get(key));
            sb.append(join);
            System.out.println(sb);
        }

    }
}
