import java.util.ArrayList;
import java.util.List;

public class Main {
    // EmpoleeBook [] emploee = new EmpoleeBook[10];
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

        List<String> emploees = new ArrayList<>();
        List<String> departments = new ArrayList<>();
        int[] salar = new int[emploee.length];

        int salaryMinId = 0, salaryMaxId = 0;
        float salaryTotalSum = 0;

        for (int i = 0; i < emploee.length; i++) {
            emploees.add(emploee[i].getEmploee());
            departments.add(emploee[i].getDepartment());
            salar[i] = emploee[i].getSalary();
            emploee[i].setCount(i);
        }

        salaryMinId = getMinSalaryId(salar);
        System.out.print("Сотрудник - " + emploee[salaryMinId].getEmploee());
        System.out.println(" c наименьшей з/п - " + emploee[salaryMinId].getSalary());

        salaryMaxId = getMaxSalaryId(salar);
        System.out.print("Сотрудник - " + emploee[salaryMaxId].getEmploee());
        System.out.println(" c наибольшей з/п - " + emploee[salaryMaxId].getSalary());

        salaryTotalSum = getSalaryTotalSum(salar);
        System.out.printf("Всего затраты на з/п - %.2f\n",salaryTotalSum);
        System.out.printf("Средняя з/п - %.2f\n",salaryTotalSum/emploee.length);

        getFullListOfName(emploees, departments, salar);
        getListOfName(emploees);
        for (int i = 0; i < emploee.length; i++) {
            System.out.print(emploee[i].getId() + " ");
        }
    }

    public static int getMinSalaryId(int[] temp) {
        int res = temp[0];
        int salaryMinId = 0;
        for (int i = 1; i < temp.length; i ++) {
            if (res > temp[i]) {
                res = temp[i];
                salaryMinId = i;
            }
        }
        return salaryMinId;
    }
    public static int getMaxSalaryId(int[] temp) {
        int res = temp[0];
        int salaryMaxId = 0;
        for (int i = 1; i < temp.length; i ++) {
            if (res < temp[i]) {
                res = temp[i];
                salaryMaxId = i;
            }
        }
        return salaryMaxId;
    }
    public static int getSalaryTotalSum(int[] temp) {
        int totalSum = temp[0];
        for (int i = 1; i < temp.length; i++) {
            totalSum += temp[i];
        }
        return totalSum;
    }
    public static void getFullListOfName(List<String> name, List<String> dep, int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.println("Сотрудник - "  + name.get(i) + ", отдел - " + dep.get(i) + ", з/п - " + temp[i]);
        }
    }
    public static void getListOfName(List<String> name) {
        for (int i = 0; i < name.size(); i++) {
            System.out.println(name.get(i));
        }
    }

}