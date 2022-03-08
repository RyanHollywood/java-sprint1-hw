import java.util.ArrayList;

public class ReportManager {

    //Отчеты для вывода по месяцам для вывода
    ArrayList<ArrayList<String>> reportByMonthToPrint;
    //Отчет для вывода по году
    ArrayList<ArrayList<String>> reportByYearToPrint;

    //Отчет по месяцам для сверки
    ArrayList<ArrayList<Double>> checkReportByMonth;
    //Отчет по году для сверки
    ArrayList<ArrayList<Double>> checkReportByYear;

    //Списки доходов и расходов по месяцам для добавления в отчет для сверки
    ArrayList<Double> checkReportByMonthIncome = new ArrayList<>();
    ArrayList<Double> checkReportByMonthExp = new ArrayList<>();


    //Конструктор класса
    ReportManager() {
        reportByMonthToPrint = new ArrayList<>();
        reportByYearToPrint = new ArrayList<>();
        checkReportByMonth = new ArrayList<>();
        checkReportByYear = new ArrayList<>();
    }

    void addMonthReport(ArrayList<String> reportToPrint, double monthIncome, double monthExp) {
        reportByMonthToPrint.add(reportToPrint);
        checkReportByMonthIncome.add(monthIncome);
        checkReportByMonthExp.add(monthExp);
    }

    void addYearReport(ArrayList<String> reportToPrint, ArrayList<ArrayList<Double>> checkReport) {
        reportByYearToPrint.add(reportToPrint);
        checkReportByYear = checkReport;
    }

    void checkReports() {
        System.out.println("Сверка отчетов");
        //Добавляем списки доходов и расходов по месяцам в отчет для сверки по месяцам
        checkReportByMonth.add(checkReportByMonthIncome);
        checkReportByMonth.add(checkReportByMonthExp);
        //Проверка считаны ли отчеты
        if (checkReportByYear.isEmpty() || checkReportByMonth.get(0).isEmpty() || checkReportByMonth.get(1).isEmpty()) {
            System.out.println("Отчёты не были считаны");
        } else {
            //Список месяцев с несоответствиями
            ArrayList<Integer> problemMonths = new ArrayList<>();
            //Сверяем доходы и расходы
            for (int i = 0; i < checkReportByYear.get(0).size(); i++) {
                if (!(checkReportByYear.get(0).get(i).equals(checkReportByMonth.get(0).get(i))) || !(checkReportByYear.get(1).get(i).equals(checkReportByMonth.get(1).get(i)))) {
                    problemMonths.add(i);
                }
            }
            //Выводим результат сверки
            if (problemMonths.isEmpty()) {
                System.out.println("Операция успешно завершена!");
            } else {
                System.out.println("Обнаружено несоответствие за следующие месяцы:");
                for (int monthNumber : problemMonths) {
                    System.out.println(getMonthName(monthNumber));
                }
            }
        }
    }

    void printMonthlyReport() {
        if (!reportByMonthToPrint.isEmpty()) {
            System.out.println("Месячные отчёты");
            for (ArrayList<String> arrayMonth : reportByMonthToPrint) {
                for (String s : arrayMonth) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("Отчёты не были считаны");
        }
    }

    void printYearlyReport() {
        if (!reportByYearToPrint.isEmpty()) {
            System.out.println("Годовой отчёт");
            for (ArrayList<String> arrayYear : reportByYearToPrint) {
                for (String s : arrayYear) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("Отчёт не был считан");
        }
    }

    String getMonthName(int monthNumber) {
        String[] year = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return year[monthNumber];
    }
}
