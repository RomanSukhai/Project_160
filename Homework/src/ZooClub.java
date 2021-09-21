import java.security.KeyStore;
import java.util.*;

public class ZooClub implements MethodForZooClub{

    public static void main(String[] args){
          Map<Person,ArrayList<Animal>> map = new HashMap<>();
          MethodForZooClub.main();
          Scanner sc = new Scanner(System.in);

          while (true){
              System.out.print("Введіть число: ");
              int number = sc.nextInt();
              switch (number){
                  case 1 :{
                      MethodForZooClub.AddPersonForZooClub(map);
                      MethodForZooClub.main();
                      break;
                  }case 2 :{
                      MethodForZooClub.AddAnimalForPerson(map);
                      MethodForZooClub.main();
                      break;
                  }case 3 :{
                      MethodForZooClub.DeleteAnimalSiencePerson(map);
                      MethodForZooClub.main();
                  }case 4 :{
                      MethodForZooClub.DeletePerson(map);
                      MethodForZooClub.main();
                  }case 5 :{
                      MethodForZooClub.DeleteAnimalSiencePerson(map);
                      MethodForZooClub.main();
                  }case 6 :{
                      MethodForZooClub.PrintAllZooClub(map);
                      MethodForZooClub.main();
                  }case 7 :{
                      System.exit(0);
                  }
              }
          }
    }

}
