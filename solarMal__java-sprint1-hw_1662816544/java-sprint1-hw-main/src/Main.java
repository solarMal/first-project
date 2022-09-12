import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();
        StepTracker stepTracker = new StepTracker();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите один из пунктов:");
        while (true) {
            int month;
            int day;
            int step;
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Выберите месяц: 1. Январь, 2. Февраль, 3. Март, 4. Апрель, 5. Май, 6. Июнь," +
                        "7. Июль, 8. Август, 9. Сентябрь, 10. Октябрь, 11. Ноябрь, 12. Декабрь");
                month = scanner.nextInt() - 1;
                if (month < 0 || month > 11){
                    System.out.println("введите значение от 1 до 12");
                    continue;
                }
                System.out.println("Выберите номер дня от 1-30");
                day = scanner.nextInt() - 1;
                if (day < 0 || day > 29){
                    System.out.println("введите значение от 1 до 30");
                    continue;
                }
                System.out.println("введите колличество шагов пройденых в этот день");
                step = scanner.nextInt();
                stepTracker.stepsOfDays(stepTracker.monthToData[month], day, step);
            } else if (command == 2) {
                System.out.println("Выберите месяц: 1. Январь, 2. Февраль, 3. Март, 4. Апрель, 5. Май, 6. Июнь," +
                        "7. Июль, 8. Август, 9. Сентябрь, 10. Октябрь, 11. Ноябрь, 12. Декабрь");
                month = scanner.nextInt();

                System.out.println("Количество пройденных шагов по дням:");
                stepTracker.numberOfStepsTakenPerDay(stepTracker.monthToData[month]);
                System.out.println();

                System.out.println("общее колличество шагов за месяц "
                        + stepTracker.stepPerMonth(stepTracker.monthToData[month]));

                System.out.println("максимально пройденое колличество шагов в месяце " +
                        stepTracker.maximumNumberOfStepsTakenPerMonth(stepTracker.monthToData[month]));

                System.out.println("Среднее колличество шагов за месяц "
                        + stepTracker.averageNumberOfSteps(stepTracker.monthToData[month]));

                System.out.println("пройденная дистанция в киллометрах " +
                        converter.traveledDistanceConverter(stepTracker.stepPerMonth(stepTracker.monthToData[month])) +
                        " километров за месяц");

                System.out.println("колличество сожжённых килокалорий "
                        + converter.burnedCalories(stepTracker.stepPerMonth(stepTracker.monthToData[month])) + " килокалорий");

                System.out.println("колличество дней когда вы прошли больше шагов, чем целевое значение " +
                        stepTracker.maximumNumberOfConsecutiveDays(stepTracker.monthToData[month]) + " дня");
            } else if (command == 3) {
                System.out.println("введите новое целевое колличество шагов");
                int setSteps = scanner.nextInt();
                stepTracker.setTargetNumberOfSteps(setSteps);
            } else if (command == 0) {
                return;
            } else {
                System.out.println("выберите действие из списка меню:");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
    }
}
