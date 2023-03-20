import java.util.*;

public class program {
    public static void main(String[] args) {
        ArrayList<Laptop> laptops = getLaptopList();
        HashMap<Integer, String> sortingValues = getSortingMap();
        HashMap<String, ArrayList<String>> allStr = getStringChoices(sortingValues, laptops);
        Scanner sc = new Scanner(System.in);
        int first = filter1(sortingValues, sc);
        int second = filter2(sortingValues, laptops, allStr, sc, first);
        result(first, second, allStr, laptops);
        sc.close();
    }

    public static ArrayList<Laptop> getLaptopList() {
        ArrayList<Laptop> al = new ArrayList<>();
        Laptop lenovo = new Laptop("Lenovo", "White", 16, 512, "Windows 10");
        Laptop macbook = new Laptop("Apple MacBook Air 13\"", "Silver", 8, 256, "MacOS");
        Laptop asus = new Laptop("ASUS TUF Gaming", "Black", 16, 1024, "Windows 10 Home");
        Laptop huawei = new Laptop("Huawei D15", "Red", 16, 512, "Windows 10");
        Laptop dell = new Laptop("DELL XPS15", "Black", 16, 512, "Linux");
        al.add(lenovo);
        al.add(macbook);
        al.add(asus);
        al.add(huawei);
        al.add(dell);
        return al;
    }

    public static HashMap<Integer, String> getSortingMap() {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "ОЗУ");
        hm.put(2, "Объем ЖД");
        hm.put(3, "Операционная система");
        hm.put(4, "Цвет");
        return hm;
    }
    public static int filter1(HashMap<Integer, String> hm, Scanner sc) {
        System.out.println("Выберите цифру, соответствующую критерию:");

        for (var el: hm.entrySet()) System.out.println(el.getKey() + ". " + el.getValue());

        System.out.print("\nКритерий ");
        int choice = sc.nextInt();
        sc.nextLine();

        return choice;
    }

    public static int filter2(HashMap<Integer, String> hm, ArrayList<Laptop> al, HashMap<String, ArrayList<String>> strMap, Scanner sc, int first) {
        int choice = -1;
        if (first > 0 && first < 3) {
            System.out.println("Память не менее (Гб) (" + hm.get(first) + ").");
            choice = sc.nextInt();
            sc.nextLine();
        } else if (first > 2 && first < 5) {
            ArrayList<String> strChoices = strMap.get(hm.get(first));
            System.out.println("Выберите один из подходящих вариантов (" + hm.get(first) + "):");
            for (int i = 0; i < strChoices.size(); i++) {
                System.out.println((i + 1) + ". " + strChoices.get(i));
            }
            System.out.print("\nВаш выбор: ");
            choice = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Такого выбора нет!");
        }
        return choice;
    }

    public static HashMap<String, ArrayList<String>> getStringChoices(HashMap<Integer, String> hm, ArrayList<Laptop> al) {
        HashMap<String, ArrayList<String>> strMap = new HashMap<>();
        HashSet<String> os = new HashSet<>();
        HashSet<String> colors = new HashSet<>();
        ArrayList<String> osList = new ArrayList<>();
        ArrayList<String> colorList = new ArrayList<>();
        for (Laptop el: al) {
            os.add(el.os);
            colors.add(el.color);
        }
        osList.addAll(os);
        colorList.addAll(colors);
        strMap.put(hm.get(3), osList);
        strMap.put(hm.get(4), colorList);
        return strMap;
    }

    public static void result(int first, int second, HashMap<String, ArrayList<String>> strMap, ArrayList<Laptop> al) {
        ArrayList<Laptop> matching = new ArrayList<>();
        switch (first) {
            case 1:
                for (Laptop el: al)
                    if (el.ramGB >= second)
                        matching.add(el);
                break;

            case 2:
                for (Laptop el: al)
                    if (el.romGB >= second)
                        matching.add(el);
                break;

            case 3:
                if (strMap.get("Операционная система").size() <= second - 1 || second < 1) {
                    System.out.println("Такого выбора нет!");
                    break;
                }
                for (Laptop el: al)
                    if (strMap.get("Операционная система").get(second - 1).equals(el.os))
                        matching.add(el);
                break;
            case 4:
                if (strMap.get("Цвет").size() <= second - 1 || second < 1) {
                    System.out.println("Такого выбора нет!");
                    break;
                }
                for (Laptop el: al)
                    if (strMap.get("Цвет").get(second - 1).equals(el.color))
                        matching.add(el);
                break;
            default:
                break;
        }
        if (matching.size() < 1) System.out.println("Нет подходящих вариантов");
        else {
            System.out.println("\nПо критерию найдены:\n");
            for (Laptop el: matching) el.getInfo();
        }
    }
}
