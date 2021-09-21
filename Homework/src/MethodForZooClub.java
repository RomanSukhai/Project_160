import java.util.*;

public interface MethodForZooClub {
    public static void main(){
        System.out.println("............................................................");
        System.out.print("Натисніть 1 --->Додати учасника клубу\nНатисніть 2 --->Додати тваринку до учасника клубу\nНатисніть 3 --->Видалити тваринку з учасника клубу\nНатисніть 4 --->Видалити учасника з клубу\nНатисніть 5 --->Видалити конкретну тваринку зі всіх власників\nНатисніть 6 --->Вивести на екран зооклуб\nНатисніть 7 --->Вийти з програми");
        System.out.println("````````````````````````````````````````````````````````````");
    }
     static void AddPersonForZooClub(Map<Person,ArrayList<Animal>> map){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть своє ім'я : ");
        String name = sc.next();
        System.out.print("Введіть свій вік : ");
        int age = sc.nextInt();
        map.put(new Person(name,age),new ArrayList<>());
        System.out.println(map);
    }
     static void AddAnimalForPerson(Map<Person,ArrayList<Animal>> map){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть своє ім'я в клубі: ");
        String namePerson = sc.next();
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

    }
     static void DeleteAnimalSiencePerson(Map<Person,ArrayList<Animal>> map) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть своє ім'я в клубі: ");
        String namePerson = sc.next();
        System.out.print("Введіть ім'я свого улябеленця: ");
        String name = sc.next();
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Person, ArrayList<Animal>> next = iterator.next();
            if (next.getKey().getName().equalsIgnoreCase(namePerson)){
                List<Animal> animals = next.getValue();
                Iterator<Animal> iterator1 = animals.iterator();
                while (iterator1.hasNext()){
                    Animal next2 = iterator1.next();
                    if (next2.getName().equalsIgnoreCase(name)){
                        iterator1.remove();
                        System.out.println("________________");;
                        System.out.println("Видалена тваринка на ім'я : "+next2.getName()+" і це "+next2.getTypeAimal());
                    }
                }
            }
        }
    }
     static void DeletePerson(Map<Person,ArrayList<Animal>> map){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть своє ім'я в клубі: ");
        String namePerson = sc.next();
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Person, ArrayList<Animal>> next2 = iterator.next();
            if (next2.getKey().getName().equalsIgnoreCase(namePerson)){
                map.remove(next2.getKey(),next2.getValue());
            }
        }
    }
     static void DeleteTypeAnimal(Map<Person,ArrayList<Animal>> map){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть яку тваринку ви хочене видалити: ");
        String typeAnimal = sc.next();
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Person, ArrayList<Animal>> next2 = iterator.next();
            List<Animal> animals = next2.getValue();
            Iterator<Animal> iterator1 = animals.iterator();
            while (iterator.hasNext()){
                Animal next = iterator1.next();
                if (next.getTypeAimal().equalsIgnoreCase(typeAnimal)){
                    iterator1.remove();
                }
            }

        }
    }
     static void PrintAllZooClub(Map<Person,ArrayList<Animal>> map){
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Person,ArrayList<Animal>> next1 = iterator.next();
            System.out.print(next1.getKey()+"------>");
            List<Animal> animals = next1.getValue();
            Iterator<Animal> iterator1 = animals.iterator();
            while (iterator1.hasNext()){
                Animal next2 = iterator1.next();
                System.out.print(next2);
            }
            System.out.println();
        }
    }
}
