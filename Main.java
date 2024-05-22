package user_pass;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

abstract class BankAccount {
    Scanner sc = new Scanner(System.in);
    String name, type, accno;
    long num;
    int age,time;
    int password;
    public String pass;
    double balance, amount;
    double amount1, loanamt, A;

    public abstract void enter();

    abstract void deposit() throws Exception;

    abstract void withdraw() throws IOException;

    abstract void old_print();

    abstract void old_print(String pass);

    abstract void print();

    abstract void pancard();

    abstract void loan_conditions();

    abstract void loan();

    void setname(String name) {
        this.name = name;
    }
}

public class p1 extends BankAccount{
    public void enter() {

        System.out.println();
        System.out.println("PLEASE LOGIN TO PORTAL");
        for (int i = 0; i < 3; i++) {
            System.out.println("================================================================");
            System.out.println("ENTER PASSWORD IN FORM OF PIN:");
            System.out.println("PASSWORD MUST BE IN NUMBER NOT IN CHARACTERS OR LETTERS");
            System.out.println("====================================================================");
            while (true) {
                try {
                    password = sc.nextInt();
                    if (password < 0) {
                        System.out.println("ReEnter password");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("ReEnter password");
                    sc.nextLine();
                }
            }
            sc.nextLine();
            System.out.println();

            if (password == 1107) { // 1107 IS DEFAULT PASSWORD FOR LOGIN TO PORTAL
                System.out.println("=======================");
                System.out.println("WELCOME");
                System.out.println("ENTER USER  DETAIL:");
                System.out.println("=======================");

                System.out.println("ENTER THE USER NAME:");
                name = sc.nextLine();
                boolean flag = false;
                boolean tp=false;
                while(tp==false){
                    System.out.println("ENTER THE USER ACCOUNT TYPE:SAVE OR CURRENT");
                    type = sc.nextLine();

                    if (type.equalsIgnoreCase("save") || type.equalsIgnoreCase("current")) {
                        tp=true;
                    } else {
                        System.out.println("Enter valid account type");
                    }
                }
                do {
                    System.out.println("ENTER ACCOUNT NUMBER: IN DIGITS ONLY : LENGTH REQUIRED [6]");
                    accno = sc.nextLine();

                    if (accno.length() == 6) {

                        for (int j = 0; j < accno.length(); j++) {
                            if (accno.charAt(j) >= '0' && accno.charAt(j) <= '9') {
                                System.out.println("DONE");
                                flag = true;
                                break;
                            } else {
                                flag = false;
                                System.out.println("INVALID FORMAT TRY AGAIN");
                                break;
                            }
                        }
                    }
                } while (flag == false);

                System.out.println("ENTER USER MOBILE NUMBER:");
                while (true) {
                    try {
                        num = sc.nextLong();
                        break;
                    } catch (Exception e) {
                        sc.next();
                        System.out.println("Enter valid number....");
                    }
                }
                String no = Long.toString(num);
                if (no.length() == 10) {
                    System.out.println("ENTER USER CURRENT BALANCE:");
                    balance = sc.nextDouble();
                    break;
                } else {
                    System.out.println("Enter only 10 digit number....");
                }

                break;
            } else {

                if (i == 2) {
                    System.out.println("System has been turn off");
                    System.exit(0);
                } else {
                    System.out.println("REENTER THE PASSWORD:");
                }
            }
        }
    }

    void deposit() throws Exception {

        System.out.println("=============");
        System.out.println("DEPOSIT MONEY");
        System.out.println("=============");
        A = balance;

        System.out.println("ENTER AMOUNT USER WANT TO DIPOSIT:");
        amount = sc.nextDouble();

        balance = balance + amount;

        System.out.println("NOW CURRENT BALANCE IS:" + balance);
        FileWriter fw = new FileWriter(accno + ".txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(amount + " diposed in your account your acc no is " + accno);
        bw.newLine();
        bw.flush();
        bw.close();
        System.out.println("THANK YOU");
    }

    void withdraw() throws IOException {

        System.out.println("==============");
        System.out.println("WITHDRAW MONEY");
        System.out.println("==============");
        A = balance;

        System.out.println("ENTER AMOUNT USER WANT TO WITHDRAW:");
        amount1 = sc.nextDouble();

        if (balance >= amount1) {

            balance = balance - amount1;
            System.out.println("WITHDRAW OF " + amount1 + "/- AMOUNT IS SUCCESSFULLY DONE");
            System.out.println("NOW CURRENT BALANCE IS:" + balance);

            FileWriter fw = new FileWriter(accno + ".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(amount1 + " withdraw in your account your acc no is " + accno);
            bw.newLine();
            bw.flush();
            bw.close();
            System.out.println("THANK YOU");
        } else {
            System.out.println("USER DOESN'T HAVE SUFFICIENT AMOUNT TO WITHDRAW");
            System.out.println("THANK `YOU");
        }
    }

    void old_print() {
        System.out.println("============");
        System.out.println("USER DETAILS");
        System.out.println("============");
        System.out.println();
        System.out.println("NAME OF ACCOUNT HOLDER::" + name);
        System.out.println("ACCOUNT TYPE:" + type);
        System.out.println("ACCOUNT NUMBER:" + accno);
        System.out.println("MOBILE NUMBER:" + num);
        System.out.println("USER AMOUNT BEFORE ACTION:" + A);
        System.out.println("CURRENT BALANCE:" + balance);
        System.out.println("THANK YOU");
    }

    void old_print(String pass) {
        System.out.println("============");
        System.out.println("USER BALANCE");
        System.out.println("============");
        System.out.println();
        System.out.println("NAME OF ACCOUNT HOLDER::" + name);
        System.out.println("ACCOUNT TYPE:" + type);
        System.out.println("ACCOUNT NUMBER:" + accno);
        System.out.println("CURRENT BALANCE:" + balance);
    }

    void print() {

        System.out.println();
        System.out.println("=======================");
        System.out.println("NAME:" + name);
        System.out.println("ACCOUNT:" + type);
        System.out.println("ACCOUNT NUMBER:" + accno);
        System.out.println("MOBILE NUMBER::" + num);
        System.out.println("CURRENT BALANCE:" + balance);
        System.out.println("THANK YOU");
        System.out.println("=======================");
        System.out.println();
    }

    void pancard() {

        System.out.println("====================");
        System.out.println("PAN CARD APPLICATION");
        System.out.println("====================");

        System.out.println("ENTER BIRTH YEAR:");
        age = sc.nextInt();
        int ans = 2023 - age;

        if (ans >= 18) {
            System.out.println("===YOU ARE ELIGIBLE FOR PAN CARD===");
        } else {
            System.out.println("YOU ARE NOT ELIGIBLE FOR PAN CARD NOW===");
        }
    }

    void loan_conditions() {

        System.out.println("~");
        System.out.println("CONDITIONS FOR LOAN APPLICATION");
        System.out.println("~");
        System.out.println();
        System.out.println("USER MUST HAVE ACCOUNT IN RESPECTIVE BANK");
        System.out.println("USER HAVE TO PAY INEREST ON TIME");
        System.out.println("INTEREST RATE WILL BE 8% PER YEAR");
        System.out.println("MAXIMUM AMOUNT FOR LOAN IS 500000/-");
        System.out.println("AFTER TIME COMPLETE USER HAVE TO GIVE AMOUNT BAK WITH RESPECTIVE INTEREST");
        System.out.println("IF USER DON'T PAY RESPECTIVE AMOUNT ON TIME THEN STRICT ACTION WILL BE TAKEN");
        System.out.println("ALL TERMS AND CONDITIONS WILL BE APPLIED TO USER");
        System.out.println("THANK YOU");
        System.out.println("===============================================================================");
    }

    void loan() {

        System.out.println("======================");
        System.out.println("WELCOME TO LOAN PORTAL");
        System.out.println("======================");

        System.out.println("ENTER REQUIRED AMOUNT FOR LOAN:");
        loanamt = sc.nextDouble();

        System.out.println("ENTER A TIME TO REPAY THIS LOAN IN YEAR:");
        time = sc.nextInt();

        if (loanamt <= 500000) {
            System.out.println("AMOUNT VALIDATION SUCCESSFULLY DONE");
            System.out.println("INTEREST RATE WILL BE 8% PER YEAR");

            double interest = (loanamt * time * 0.08);
            loanamt = loanamt + interest;

            System.out.println("LOAN INTEREST AFTER TIME:" + interest);
            System.out.println("USER HAVE TO GIVE TOTAL AMOUNT " + loanamt + "/- AFTER TIME COMPLETE:");
            System.out.println("THANK YOU");

        } else {
            System.out.println("NOT VALID AMOUNT FOR LOAN");
            System.out.println("THANK YOU");
        }
    }

    void setname(String name) {
        this.name = name;
    }
}