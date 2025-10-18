import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AllListManager {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner typed = new Scanner(System.in);


        int option=0;

        while (option !=4) {
            try {
                System.out.println("Pick a option\n");
                System.out.println("1 - Add Taks");
                System.out.println("2 - To view Taks");
                System.out.println("3 - Mark Taks as Fineshed");
                System.out.println("4 - Exit");
                option = typed.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("invalid option, pick 1 2 3 or 4");
                typed.nextLine();
                option=0;
                continue;
            }

            if( option > 4 || option < 1 ) {
                System.out.println("Pick a valid option \n");
                System.out.println("1 - Add Taks");
                System.out.println("2 - To view Taks");
                System.out.println("3 - Mark Taks as Fineshed");
                System.out.println("4 - Exit");
                option = typed.nextInt();
            }else{
                switch (option){
                    case 1 :
                        typed.nextLine();
                        System.out.print("Include description :");
                        String descp = typed.nextLine();

                            System.out.print("\nIs Completed  Y/N ?");

                            String cpl = typed.nextLine().toLowerCase();
                            boolean completed = false;
                            if(!cpl.isEmpty() && cpl.charAt(0)=='y'){
                                completed = true;
                            }

                        Task newtask = new Task(descp, completed);
                        tasks.add(newtask);

                        System.out.println("✅ Task added successfully!");
                        break;





                    case 2 :
                        for(Task seach : tasks){
                            System.out.println("Name´s Task   :"+seach.getDescription()+" STATUS :"+ seach.isCompleted());

                        }
                        break;
                    case 3 :
                        for (int i= 0 ; i < tasks.size(); i++){
                            Task tk = tasks.get(i);
                            System.out.println("Task "+i+ " " + tk.getDescription() + " STATUS " +tk.isCompleted() );
                        }
                        System.out.println("Edit Taks STATUS !");
                        int edit = typed.nextInt();
                        Task edited = tasks.get(edit);
                        if(edited.isCompleted()){
                            edited.setCompleted(false);

                        }else{
                            edited.setCompleted(true);
                        }
                        System.out.println(edited.toString());


                        break;
                    case 4 :
                        System.out.println("---------- EXIT ----------");

                        break;



                    default:
                        throw new IllegalStateException("Unexpected value: " + option);
                }
            }

        }




        typed.close();

        }
    }