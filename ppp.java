package user_pass;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Bank_management extends p1{

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("============================");
        System.out.println("|| WELCOME TO BANK PORTAL ||");
        System.out.println("============================");

        System.out.println("================");
        System.out.println("ENTER NUMBER OF USERS");
        int n = sc.nextInt();
        Bank_management bank[] = new Bank_management[n];

        for (int i = 0; i < n; i++) {
            bank[i] = new Bank_management();
            bank[i].enter();
        }
        int X;
        do {
            System.out.println();
            System.out.println("===========================================");
            System.out.println("CHOOSE OPTION AS PER GIVEN BELOW TO ACTION");
            System.out.println("===========================================");
            System.out.println("PRESS [1] FOR CHECK STATUS OF ACCOUNT BY ENTER ACCOUNT NUM :");
            System.out.println("PRESS [2] FOR DEPOSIT MONEY: ");
            System.out.println("PRESS [3] FOR WITHDRAW MONEY:");
            System.out.println("PRESS [4] TO CHECK ELIGIBILITY FOR PAN CARD");
            System.out.println("PRESS [5] FOR LOAN APPLICATION");
            System.out.println("PRESS [6] FOR DISPLAY ALL ACCOUNTS DETAILS");
            System.out.println("PRESS [7] FOR MODIFY NAME BY USING ACCOUNT NUMBER");
            System.out.println("PRESS [8] FOR CHECK HISTORY");
            System.out.println("PRESS [9] FOR CHECK BANK BALANCE");
            System.out.println("PRESS [10] FOR EXIT");
            System.out.println("============================================");
            System.out.println();
            System.out.println("ENTER OPTION:");
            X = sc.nextInt();
            sc.nextLine();


            switch (X) {

                case 1:
                    System.out.println("ENTER ACCOUNT NUMBER:");
                    String I = sc.nextLine();

                    boolean L = false;
                    for (int i = 0; i < n; i++) {
                        if (bank[i].accno.equals(I)) {
                            bank[i].print();
                            L = true;
                            break;
                        }
                    }
                    if (!L) {
                        System.out.println("NOT FOUND");
                    }

                    break;

                case 2:

                    System.out.println("ENTER ACCOUNT NUMBER:");
                    String a = sc.nextLine();

                    boolean f = false;
                    for (int i = 0; i < n; i++) {

                        if (bank[i].accno.equals(a)) {
                            bank[i].deposit();
                            bank[i].old_print();
                            f = true;
                            break;
                        }
                    }
                    if (!f) {
                        System.out.println("NOT FOUND");
                    }
                    else
                    {
                        System.out.println("Enter valid password");
                    }
                    break;

                case 3:

                    System.out.println("ENTER ACCOUNT NUMBER:");
                    String b = sc.nextLine();
                    boolean e = false;
                    for (int i = 0; i < n; i++) {
                        if (bank[i].accno.equals(b)) {
                            bank[i].withdraw();
                            bank[i].old_print("yes");
                            e = true;
                            break;
                        }
                    }
                    if (!e) {
                        System.out.println("not found");
                    }
                    break;

                case 4:

                    System.out.println("ENTER ACCOUNT NUMBER :");
                    String c = sc.nextLine();
                    boolean z = false;
                    for (int i = 0; i < n; i++) {
                        if (bank[i].accno.equals(c)) {
                            bank[i].pancard();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        System.out.println("NOT FOUND");
                    }
                    break;

                case 5:

                    System.out.println("ENTER ACCOUNT NUMBER:");
                    String l = sc.nextLine();
                    boolean w = false;
                    for (int i = 0; i < n; i++) {

                        if (bank[i].accno.equals(l)) {
                            bank[i].loan_conditions();
                            System.out.println("WANT TO APPLY FOR LOAN APPLICATION ?");
                            System.out.println("'Y' FOR YES AND 'N' FOR NO");
                            char k = sc.next().charAt(0);
                            if (k == 'Y') {
                                bank[i].loan();
                            } else {
                                System.out.println("THANK YOU");
                            }
                            w = true;
                            break;
                        }
                    }
                    if (!w) {
                        System.out.println("NOT FOUND");
                    }
                    break;

                case 6:

                    System.out.println("HERE ARE ALL DETAILS :");
                    for (int i = 0; i < n; i++) {
                        bank[i].print();
                        System.out.println();
                    }
                    break;

                case 7:

                    System.out.println("ENTER ACCOUNT NUMBER TO CHANGE NAME:");
                    String ac = sc.nextLine();
                    boolean op = false;
                    for (int i = 0; i < n; i++) {
                        if (bank[i].accno.equals(ac)) {
                            System.out.println("ENTER NEW NAME:");
                            String newname = sc.nextLine();
                            bank[i].setname(newname);
                            System.out.println(("NAME MODIFICATION HAS DONE SUCCESSFULLY"));
                            System.out.println();
                            bank[i].print();
                            op = true;
                            break;
                        }
                    }
                    if (!op) {
                        System.out.println("NOT FOUND");
                    }

                case 8:
                    System.out.println("ENTER THE ACCOUNT NUMBER FOR ACCOUNT HISTORY");
                    int acc=sc.nextInt();
                    FileReader fr=new FileReader(acc+".txt");
                    BufferedReader br=new BufferedReader(fr);
                    String line;
                    while ((line=br.readLine())!=null) {
                        System.out.println(line);
                    }

                case 9:

                    System.out.println("ENTER ACCOUNT NUMBER:");
                    String a1 = sc.nextLine();
                    boolean f1 = false;
                    for (int i = 0; i < n; i++) {

                        if (bank[i].accno.equals(a1)) {
                            bank[i].print();
                            f1 = true;
                            break;
                        }
                    }
                    if (!f1) {
                        System.out.println("NOT FOUND");
                    }
                    break;

            }
        } while (X!=10);
        sc.close();
    }
}