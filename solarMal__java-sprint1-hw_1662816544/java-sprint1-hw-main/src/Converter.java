public class Converter {

    public double traveledDistanceConverter(double step){
            double distance = 75.0;
            double kilometer = (distance * step) / 100000;

        return kilometer;
    }

    public double burnedCalories(int step){
            int calories = step * 50;

            double kilocalorie = calories / 1000.0;

        return kilocalorie;
    }

}
