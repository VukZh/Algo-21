package findprefixesapp;

public class FindPrefixes {

    private int lenghtStr; // размер строки
    private int[] Z; // массив Z
    private final String str;

    public FindPrefixes(String s) { // инициализация Z (0 элемент - длина строки, остальные - 0)
        str = s;
        lenghtStr = s.length();
        Z = new int[lenghtStr];
    }

    public int[] FindPrefixes() { // поиск префиксов
        if (lenghtStr == 0) {
            return null;
        }

        Z[0] = lenghtStr;  // инициализация Z (0 элемент - длина строки, остальные - 0)
        for (int i = 1; i < lenghtStr; i++) {
            Z[i] = 0;
        }

        for (int i = 1; i < lenghtStr; i++) { // поиск посимвольно в строке
            int j = 0; // длина префикса
            while (str.charAt(i + j) == str.charAt(0 + j)) { // итерация длины префикса при совпадении символов
                j++;
                if ((i + j) >= lenghtStr) { // выход при выходе за длину строки
                    break;
                }
            }
            if (j != 0) { // заносим ненулевой префикс
                Z[i] = j;
            }
//            System.out.println("I " + i + " J " + j);
        }
        return Z;
    }

    public void OUT() { // вывод массива Z
        System.out.println("String: " + str);
        System.out.print("Z array: ");
        System.out.print("[");
        for (int i = 0; i < lenghtStr; i++) {
            System.out.print(" " + Z[i] + ", ");
        }
        System.out.println("]");
    }

}
