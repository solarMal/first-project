public class StepTracker {

   int targetNumberOfSteps = 10000; //целевое колличество шагов
   MonthData[] monthToData;//поле указывает на массив обьектов класса MonthData
                  //класс StepTracker работает именно с MonthData
   Converter converter = new Converter();

   public StepTracker() { //в конструкторе мы инициализируем класс MonthData 12 раз по счёту месяцев в году
      monthToData = new MonthData[12];
      for (int i = 0; i < monthToData.length; i++) {
         monthToData[i] = new MonthData();
      }
   }

   void numberOfStepsTakenPerDay(MonthData monthToData){
      for (int i = 0; i < monthToData.days.length; i++){
         System.out.print(i + " день: ");
         System.out.print(monthToData.days[i] + ", ") ;
      }
   }

   void stepsOfDays(MonthData monthToData, int day, int step){//шаги за день
      monthToData.days[day] = step;
      System.out.println(day + " день: " + step);
   }

   public int stepPerMonth(MonthData monthToData){//шаги за месяц
      int result = 0;
      for (int i = 0; i < monthToData.days.length; i++){
         result += monthToData.days[i];
      }
      return result;
   }

   public int maximumNumberOfStepsTakenPerMonth(MonthData monthToData){//максимальное колличество шагов за месяц
      int result = 0;
      for (int i = 1; i < monthToData.days.length; i++){
         if (result < monthToData.days[i]){
            result = monthToData.days[i];
         }
      }
      return result;
   }

   public int averageNumberOfSteps(MonthData monthData){//среднее колличество шагов за месяц
      int result = 0;
      stepPerMonth(monthData);
         result += stepPerMonth(monthData);

      result = result / stepPerMonth(monthData);
      return result;
   }

   public int maximumNumberOfConsecutiveDays(MonthData monthToData){//максимальное количество подряд идущих дней
      int bestSeries = 0;
      int series = 0;
      for (int i = 0; i < monthToData.days.length; i++){
         if (monthToData.days[i] >= targetNumberOfSteps){
            series ++;
         }else {
            if (series > bestSeries){
               bestSeries = series;
               series = 0;
            }
         }
      }
      if (series > bestSeries){
         bestSeries = series;
         series = 0;
      }
      return bestSeries;
   }

   public void setTargetNumberOfSteps(int targetNumberOfSteps){
      if (targetNumberOfSteps > 0) {
         this.targetNumberOfSteps = targetNumberOfSteps;
      }else {
         System.out.println("введите значение больше 0");
      }
   }

}

