import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmploeeBook[] emploee = new EmploeeBook[10];
        emploee[0] = new EmploeeBook("Ivanov Ivan Ivanovich", "1", 86811);
        emploee[1] = new EmploeeBook("Petrov Petr Petrovich", "2", 80000);
        emploee[2] = new EmploeeBook("Ivanov Petr Ivanovich", "3", 79500);
        emploee[3] = new EmploeeBook("Ivanov Ivan Petrovich", "4", 72000);
        emploee[4] = new EmploeeBook("Kumov Ivan Vasilievich", "5", 73000);
        emploee[5] = new EmploeeBook("Sizov Petr Olegovich", "5", 84667);
        emploee[6] = new EmploeeBook("Shlikov Oleg Petrovich", "4", 125400);
        emploee[7] = new EmploeeBook("Krotov Oleg Ivanovich", "3", 95640);
        emploee[8] = new EmploeeBook("Vasin Alex Ivanovich", "2", 99800);
        emploee[9] = new EmploeeBook("Vasin Alex Petrovich", "1", 88500);

        int salaryMinId = 0, salaryMaxId = 0;
        float salaryTotalSum = 0, salaryMedianna;

        salaryMinId = getMinSalaryId(emploee);
        System.out.print("Сотрудник - " + emploee[salaryMinId].getEmploee());
        System.out.println(" c наименьшей з/п - " + emploee[salaryMinId].getSalary());

        salaryMaxId = getMaxSalaryId(emploee);
        System.out.print("Сотрудник - " + emploee[salaryMaxId].getEmploee());
        System.out.println(" c наибольшей з/п - " + emploee[salaryMaxId].getSalary());

        salaryTotalSum = getSalaryTotalSum(emploee);
        System.out.printf("Всего затраты на з/п - %.2f\n", salaryTotalSum);

        salaryMedianna = getSalaryMedianna(emploee);
        System.out.printf("Средняя з/п - %.2f\n", salaryMedianna);

        getFullListOfName(emploee);
        getListOfName(emploee);
        getId(emploee);
    }

    public static int getMinSalaryId(EmploeeBook[] temp) {
        int res = temp[0].getSalary();
        int salaryMinId = 0;
        for (int i = 1; i < temp.length; i ++) {
            if (res > temp[i].getSalary()) {
                res = temp[i].getSalary();
                salaryMinId = i;
            }
        }
        return salaryMinId;
    }
    public static int getMaxSalaryId(EmploeeBook[] temp) {
        int res = temp[0].getSalary();
        int salaryMaxId = 0;
        for (int i = 1; i < temp.length; i ++) {
            if (res < temp[i].getSalary()) {
                res = temp[i].getSalary();
                salaryMaxId = i;
            }
        }
        return salaryMaxId;
    }
    public static float getSalaryTotalSum(EmploeeBook[] temp) {
        int totalSum = temp[0].getSalary();
        for (int i = 1; i < temp.length; i++) {
            totalSum += temp[i].getSalary();
        }
        return totalSum;
    }
    public static float getSalaryMedianna(EmploeeBook[] temp) {
        float totalSum = temp[0].getSalary();
        for (int i = 1; i < temp.length; i++) {
            totalSum += temp[i].getSalary();
        }
        return totalSum/temp.length;
    }
    public static void getId(EmploeeBook[] emploees) {
        for (int i = 0; i < 10; i++) {
            System.out.print(emploees[i].getId() + " ");
        }
    }
    public static void getFullListOfName(EmploeeBook[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }
    public static void getListOfName(EmploeeBook[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i].getEmploee());
        }
    }
}