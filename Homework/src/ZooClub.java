import java.security.KeyStore;
import java.util.*;

public class ZooClub{

    public static void main(String[] args) throws Exception {
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
                      break;
                  }case 4 :{
                      MethodForZooClub.DeletePerson(map);
                      MethodForZooClub.main();
                      break;
                  }case 5 :{
                      MethodForZooClub.DeleteTypeAnimal(map);
                      MethodForZooClub.main();
                      break;
                  }case 6 :{
                      MethodForZooClub.PrintAllZooClub(map);
                      MethodForZooClub.main();
                      break;
                  }case 7 :{
                      System.exit(0);
                  }
              }
          }
    }

}
