import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AllListManager {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner typed = new Scanner(System.in);


        int option=0;

        while (option !=4) {
            showMenu();
            try {
                option = typed.nextInt();
                typed.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("invalid option, pick 1 2 3 or 4");
                typed.nextLine();
                option=0;
                continue;
            }
            switch (option){
                case 1 :
                    addTasks(tasks,typed);
                    break;
                case 2 :
                    viewTasks(tasks);
                    break;
                case 3 :
                    markAsCompleted(tasks, typed);
                    break;
                case 4 :
                    System.out.println("---------- EXIT ----------");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }
        typed.close();
    }
    private static void showMenu(){
        System.out.println("Pick a option\n");
        System.out.println("1 - Add Taks");
        System.out.println("2 - To view Taks");
        System.out.println("3 - Mark Taks as Fineshed");
        System.out.println("4 - Exit");
    }
    private  static void addTasks(ArrayList<Task> tasks, Scanner scanner){
        System.out.print("Include description :");
        String descp = scanner.nextLine();
        Task newtask = new Task(descp,false);
        tasks.add(newtask);
    }
    private static void viewTasks(ArrayList<Task> tasks){
        if(tasks.isEmpty()) {
            System.out.println("\n The Tasks list is empty!");
            return;
        }
        System.out.println("-------------Your Tasks-------------");
        for (int i=0; i < tasks.size(); i++){
            Task tasksview = tasks.get(i);
            String status = tasksview.isCompleted() ? "[X]" : "[ ]";
            System.out.printf("%d. %s %s%n", (i + 1), status, tasksview.getDescription());
        }
        System.out.println("------------------------------------");
    }
    private static void markAsCompleted(ArrayList<Task> tasks, Scanner typed){
        if(tasks.isEmpty()) {
            System.out.println("Don´t are there tasks to mark  ");
        }
        viewTasks(tasks);
        System.out.println("Enter the task number to change");
        int numbertask;
        try {
            numbertask = typed.nextInt();
        }catch(InputMismatchException e){
            System.out.println("X - Invalid entry, Please, enter number of list");
            typed.nextLine();
            return;
        }
        int index = numbertask -1;
        if(index >=0 && index < tasks.size()) {
            Task taskToEdit = tasks.get(index);
            boolean newStatus = !taskToEdit.isCompleted();
            taskToEdit.setCompleted(newStatus);
            String statusTexto = newStatus ? "COMPLETED" : "PENDING";
            System.out.println("Task " + taskToEdit + " marked as " + statusTexto + ".");
            System.out.println("Details: " + taskToEdit.getDescription());
        } else {
            System.out.println("X - Invalid Task number. Please, enter number of list.");
        }

    }
}



