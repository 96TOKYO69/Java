import java.util.*;

public class Zadanie14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nЧисла в порядке убывания частоты встречаемости:");

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<Integer, Integer> entry : sortedList) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
