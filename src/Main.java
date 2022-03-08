import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Инициализация
        ReadCSV readCSV = new ReadCSV();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        ReportManager reportManager = new ReportManager();

        String command;

        //Основной цикл
        while (true) {
            //Вывод меню
            printMenu();
            //Чтение команды пользователя
            command = scanner.next();

            switch (command) {

                case "1":
                    for (int i = 1; i <= 3; i++) {
                        //Чтение файла
                        monthlyReport.readingCSV(readCSV.readFile("resources/m.20210" + i + ".csv"), i);
                        //Чтение очетов
                        reportManager.addMonthReport(monthlyReport.makeReportToPrint(), monthlyReport.getMonthlyIncome(), monthlyReport.getMonthlyExp());
                    }
                    break;
                case "2":
                    int year = 2021;
                    yearlyReport.readingSCV(readCSV.readFile("resources/y." + year + ".csv"), year);
                    //Чтение отчетов
                    reportManager.addYearReport(yearlyReport.makeReportToPrint(), yearlyReport.makeCheckReport());
                    break;
                case "3":
                    reportManager.checkReports();
                    break;
                case "4":
                    reportManager.printMonthlyReport();
                    break;
                case "5":
                    reportManager.printYearlyReport();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Такая команда не найдена");
            }
            if (command.equals("0")) {
                break;
            }
        }
    }

    static void printMenu() {
        //Меню - по ТЗ
        System.out.println();
        System.out.println("Введите номер команды от 1 до 6:");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        /*
        "Программа должна завершаться только при вводе оператором специальной
        последовательности символов."
        */
        System.out.println("0 - Выход");
    }
}

