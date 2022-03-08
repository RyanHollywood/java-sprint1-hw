import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<String[]> reportRows;
    int monthNumber;

    //конструктор класса
    MonthlyReport() {
        reportRows = new ArrayList<>();
    }

    void readingCSV(ArrayList<String[]> content, int monthNumberInFile) {
        reportRows = content;
        monthNumber = monthNumberInFile - 1;
    }

    //самый прибыльный товар
    String getMaxProfitName() {
        String maxProfName = "";
        double maxProf = 0;
        for (String[] line : reportRows) {
            if ((Double.parseDouble(line[2]) * Double.parseDouble(line[3])) > maxProf && !Boolean.parseBoolean(line[1])) {
                maxProf = Double.parseDouble(line[2]) * Double.parseDouble(line[3]);
                maxProfName = line[0];
            }
        }
        return maxProfName;
    }

    //самая большая трата
    String getMaxExpName() {
        String maxExpName = "";
        double maxExp = 0;
        for (String[] line : reportRows) {
            if ((Double.parseDouble(line[2]) * Double.parseDouble(line[3])) > maxExp && Boolean.parseBoolean(line[1])) {
                maxExp = Double.parseDouble(line[2]) * Double.parseDouble(line[3]);
                maxExpName = line[0];
            }
        }
        return maxExpName;
    }

    //сумма по названию товара
    double getSumByName(String name) {
        double sum = 0;
        for (String[] line : reportRows) {
            if (line[0].equals(name)) {
                sum = Double.parseDouble(line[2]) * Double.parseDouble(line[3]);
            }
        }
        return sum;
    }

    //месяц
    String getMonthName(int monthNumber) {
        String[] year = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return year[monthNumber];
    }

    //Отчет за месяц - для сверки
    ArrayList<String> makeReportToPrint() {
        ArrayList<String> report = new ArrayList<>();
        report.add(getMonthName(monthNumber));
        report.add("Самый прибыльный товар: " + getMaxProfitName() + " " + getSumByName(getMaxProfitName()));
        report.add("Самая большая трата: " + getMaxExpName() + " " + getSumByName(getMaxExpName()));
        return report;
    }

    //Расходы за месяц - для сверки
    double getMonthlyExp() {
        double monthlyExp = 0;
        for (String[] line : reportRows) {
            if (Boolean.parseBoolean(line[1])) {
                monthlyExp = monthlyExp + Double.parseDouble(line[2]) * Double.parseDouble(line[3]);
            }
        }
        return monthlyExp;
    }

    //Доход за месяц - для сверки
    double getMonthlyIncome() {
        double monthlyIncome = 0;
        for (String[] line : reportRows) {
            if (!Boolean.parseBoolean(line[1])) {
                monthlyIncome = monthlyIncome + Double.parseDouble(line[2]) * Double.parseDouble(line[3]);
            }
        }
        return monthlyIncome;
    }
}
