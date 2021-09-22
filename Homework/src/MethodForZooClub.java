import java.util.*;

public interface MethodForZooClub {
    public static void main(){
        System.out.println("............................................................");
        System.out.println("Натисніть 1 --->Додати учасника клубу\nНатисніть 2 --->Додати тваринку до учасника клубу\nНатисніть 3 --->Видалити тваринку з учасника клубу\nНатисніть 4 --->Видалити учасника з клубу\nНатисніть 5 --->Видалити конкретну тваринку зі всіх власників\nНатисніть 6 --->Вивести на екран зооклуб\nНатисніть 7 --->Вийти з програми");
        System.out.println("````````````````````````````````````````````````````````````");
    }
     static void AddPersonForZooClub(Map<Person,ArrayList<Animal>> map){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть своє ім'я : ");
        String name = sc.next();
        System.out.print("Введіть свій вік : ");
        int age = sc.nextInt();
        map.put(new Person(name,age),new ArrayList<>());
         PrintMyZooClubBelow(map);
     }

    static void PrintMyZooClub(Map<Person, ArrayList<Animal>> map) {
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Person, ArrayList<Animal>> next1 = iterator.next();
            System.out.print(next1.getKey() + "------>");
            List<Animal> animals = next1.getValue();
            Iterator<Animal> iterator1 = animals.iterator();
            while (iterator1.hasNext()) {
                Animal next2 = iterator1.next();
                System.out.print(next2);
            }
            System.out.println();
        }
    }

    static void AddAnimalForPerson(Map<Person,ArrayList<Animal>> map){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Введіть своє ім'я в клубі: ");
            String namePerson = sc.next();
            boolean flag = CheckForNamePerson(map, namePerson);
            if (flag){
                System.out.print("Введіть ім'я свого улябеленця: ");
                String name = sc.next();
                System.out.print("Хто він(Пес,Кіт): ");
                String  typeAnimal = sc.next();
                Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<Person, ArrayList<Animal>> next = iterator.next();
                    if (next.getKey().getName().equalsIgnoreCase(namePerson)){
                        List<Animal> animals = next.getValue();
                        animals.add(new Animal(typeAnimal,name));
                        next.setValue((ArrayList<Animal>) animals);
                    }
                }
                PrintMyZooClubBelow(map);
                break;
            }if (!flag){
                System.out.println("Такого ім'я немає в клубі,введіть ще раз....... ");
                System.out.println();
                System.out.println();
            }
        }



    }

    private static void PrintMyZooClubBelow(Map<Person, ArrayList<Animal>> map) {
        System.out.println("_____________________________________________________________");
        System.out.println();
        PrintMyZooClub(map);
        System.out.println();
        System.out.println("_____________________________________________________________");
    }

    static void DeleteAnimalSiencePerson(Map<Person,ArrayList<Animal>> map) throws Exception {
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Введіть своє ім'я: ");
            String name = sc.next();
            boolean flag = CheckForNamePerson(map, name);
            if (flag){
                while (true){
                    System.out.print("Введіть ім'я улюбленця: ");
                    String nameAnimal = sc.next();
                    boolean flag1 = false;
                    Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator0 = map.entrySet().iterator();
                    while (iterator0.hasNext()){
                        Map.Entry<Person, ArrayList<Animal>> next = iterator0.next();
                        List<Animal> animals=next.getValue();
                        Iterator<Animal> iterator1 = animals.iterator();
                        while (iterator1.hasNext()){
                            Animal next2 = iterator1.next();
                            if (next2.getName().equalsIgnoreCase(nameAnimal)){
                                flag1=true;
                            }
                        }
                    }
                    if (flag1){
                        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
                        while (iterator.hasNext()){
                            Map.Entry<Person, ArrayList<Animal>> next = iterator.next();
                            List<Animal> animals=next.getValue();
                            Iterator<Animal> iterator1 = animals.iterator();
                            while (iterator1.hasNext()){
                                Animal next2 = iterator1.next();
                                if (next2.getName().equalsIgnoreCase(nameAnimal)){
                                    iterator1.remove();
                                }
                            }
                        }
                        PrintMyZooClubBelow(map);
                        break;
                    }
                    else if (!flag1){
                        System.out.println("Такого улюленця немає,введіть ще раз.......");
                        System.out.println();
                        System.out.println();
                    }
                }
                break;
            }
            else if (!flag){
                System.out.println("Такого ім'я немає в клубі,введіть ще раз....... ");
                System.out.println();
                System.out.println();
            }

        }
     }
    static void DeletePerson(Map<Person,ArrayList<Animal>> map) throws Exception{
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Введіть своє ім'я в клубі: ");
            String namePerson = sc.next();
            boolean flag = CheckForNamePerson(map, namePerson);
            if (flag){
                Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<Person, ArrayList<Animal>> next2 = iterator.next();
                    if (next2.getKey().getName().equalsIgnoreCase(namePerson)){
                        map.remove(next2.getKey(),next2.getValue());
                    }
                }
                PrintMyZooClubBelow(map);
                break;
            }else if (!flag){
                System.out.println("Такого ім'я в клубі немає,введіть ще раз...");
                System.out.println();
                System.out.println();
            }

        }
    }

    static boolean CheckForNamePerson(Map<Person, ArrayList<Animal>> map, String namePerson) {
        boolean flag = false;
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator0 = map.entrySet().iterator();
        while (iterator0.hasNext()) {
            Map.Entry<Person, ArrayList<Animal>> next3 = iterator0.next();
            if (next3.getKey().getName().equalsIgnoreCase(namePerson)) {
                flag = true;
            }
        }
        return flag;
    }

    static void DeleteTypeAnimal(Map<Person,ArrayList<Animal>> map) {
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Введіть яку тваринку ви хочене видалити: ");
            String typeAnimal = sc.next();
            boolean flag = false;
            flag = CheckIteratorForTypeAnimal(map, typeAnimal, flag);
            if (flag){
                Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<Person, ArrayList<Animal>> next2 = iterator.next();
                    List<Animal> animals = next2.getValue();
                    Iterator<Animal> iterator1 = animals.iterator();
                    while (iterator1.hasNext()){
                        Animal next = iterator1.next();
                        if (next.getTypeAimal().equalsIgnoreCase(typeAnimal)){
                            iterator1.remove();
                        }
                    }
                }
                PrintMyZooClubBelow(map);
                break;
            }else if (!flag){
                System.out.println("Такої тваринки немає,введіть ще раз.....");
                System.out.println();
                System.out.println();
            }
        }


    }
    private static boolean CheckIteratorForTypeAnimal(Map<Person, ArrayList<Animal>> map, String typeAnimal, boolean flag) {
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator0 = map.entrySet().iterator();
        while (iterator0.hasNext()){
            Map.Entry<Person, ArrayList<Animal>> next3 = iterator0.next();
            List<Animal> animals = next3.getValue();
            Iterator<Animal> iterator = animals.iterator();
            while (iterator.hasNext()){
                Animal next = iterator.next();
                if (next.getTypeAimal().equalsIgnoreCase(typeAnimal)){
                    flag =true;
                }
            }
        }
        return flag;
    }

    static void PrintAllZooClub(Map<Person,ArrayList<Animal>> map){
        PrintMyZooClub(map);
    }
}
