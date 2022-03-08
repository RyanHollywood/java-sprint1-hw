import java.util.ArrayList;

public class YearlyReport {
    ArrayList<String[]> reportRows;
    int year;

    //конструктор класса
    YearlyReport() {
        reportRows = new ArrayList<>();
    }

    void readingSCV(ArrayList<String[]> content, int yearNumberInFile) {
        reportRows = content;
        //выполнить проверку на четность строк?
        year = yearNumberInFile;
    }

    //Список расходов
    ArrayList<Double> getExpByMonthList() {
        ArrayList<Double> expByMonthList = new ArrayList<>();
        for (String[] line : reportRows) {
            if (Boolean.parseBoolean(line[2])) {
                expByMonthList.add(Double.parseDouble(line[1]));
            }
        }
        return expByMonthList;
    }

    //Список доходов
    ArrayList<Double> getIncomeByMonthList() {
        ArrayList<Double> incomeByMonthList = new ArrayList<>();

        for (String[] line : reportRows) {
            if (!Boolean.parseBoolean(line[2])) {
                incomeByMonthList.add(Double.parseDouble(line[1]));
            }
        }
        return incomeByMonthList;
    }

    //Список прибыли
    ArrayList<Double> getProfitByMonthList() {
        ArrayList<Double> profitByMonthList = new ArrayList<>();
        for (int i = 0; i < getIncomeByMonthList().size(); i++) {
            profitByMonthList.add(getIncomeByMonthList().get(i) - getExpByMonthList().get(i));
        }
        return profitByMonthList;
    }

    //По ТЗ - средний доход и средний расход за все месяцы в году - т.е. 12 месяцевы
    //Средний расход в году
    double getMedianExp() {
        double medianExp;
        double sum = 0;
        for (int i = 0; i < getExpByMonthList().size(); i++) {
            sum = sum + getExpByMonthList().get(i);
        }
        medianExp = sum / 12;
        return medianExp;
    }

    //Средний доход в году
    double getMedianIncome() {
        double medianProf;
        double sum = 0;
        for (int i = 0; i < getIncomeByMonthList().size(); i++) {
            sum = sum + getIncomeByMonthList().get(i);
        }
        medianProf = sum / 12;
        return medianProf;
    }

    //Отчет за год
    ArrayList<String> makeReportToPrint() {
        ArrayList<String> report = new ArrayList<>();
        report.add(String.valueOf(year));
        report.add("Прибыль по месяцам:");
        for (int i = 0; i < getProfitByMonthList().size(); i++) {
            report.add(getMonthName(i) + " " + getProfitByMonthList().get(i));
        }
        report.add("Средний расход за год: " + getMedianExp());
        report.add("Средний доход за год: " + getMedianIncome());
        return report;
    }

    //Месяц
    String getMonthName(int monthNumber) {
        String[] year = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return year[monthNumber];
    }

    //Отчет для сверки
    ArrayList<ArrayList<Double>> makeCheckReport() {
        ArrayList<ArrayList<Double>> checkReport = new ArrayList<>();
        checkReport.add(getIncomeByMonthList());
        checkReport.add(getExpByMonthList());
        return checkReport;
    }
}