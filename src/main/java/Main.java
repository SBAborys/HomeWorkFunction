import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println(calculateFunction(3));
    }

    public final static double a = -0.5;
    public final static double b = 2;
/*
    3. У головному класі описати метод, що обчислює значення функції, яка задана у таблиці і у тестовому класі - тестові
        методи для нього. Діяти у такій послідовності: спочатку створити один тестовий метод, згенерувати метод обчислення
        функції. Виконати тестування та пересвідчитись, що тест працює, тобто тестування згенерованого метода повинно
        завершитися «помилкою». Реалізувати метод. Виконати тестування. Пересвідчившись, що тест проходить, створити ще
        декілька тестових методів для метода обчислення функції. Виконати тестування.
 */

    public double calculateFunction(double x){
        double y;
        x = new BigDecimal(x).setScale(3, RoundingMode.HALF_UP).doubleValue(); //round x to 3 decimals

        if (x > 0.7 && x <= 1.4){
            y = a * x * x *Math.log(x);

        } else if (x <= 0.7) {
            y = 1;

        }else {
            y = Math.exp(a * x) * Math.cos(b) * x;

        }
        return y;
    }

/*
    4. Розробити метод, що за вказаними значеннями кроку, початку та кінця інтервалу обчислює кількість кроків для
        табулювання та тестові методи для нього і виконати тестування (порядок дій см. у п.3).
 */

    public int stepsCount(double xMin, double xMax, double step){
        return (int) ((xMax - xMin) / step + 1);
    }

/*
    5. Створити методи, що створюють масиви значень функції (y) та її аргументу (x) в усіх точках вказаного інтервалу із
        заданим кроком. (розмір масивів обчислити програмно за допомогою метода з п.4). Створити тестові методи для них і
        виконати тестування (порядок дій – см п.3).
 */
    public double[] createArrayForX(double xMin, double xMax, double step){
        double[] arrayX = new double[stepsCount(xMin, xMax, step)];
        for (int i = 0; i <= arrayX.length - 1; i++) {
            arrayX[i] = xMin;
            xMin += step;
        }
        return arrayX;
    }

    public double[] createArrayForY(double xMin, double xMax, double step){
        double[] arrayX = createArrayForX(xMin, xMax, step);
        double[] arrayY = new double[stepsCount(xMin, xMax, step)];
        for (int i = 0; i <= arrayY.length - 1; i++) {
            arrayY[i] = calculateFunction(arrayX[i]);
        }
        return arrayY;
    }

/*
    6. Створити методи, які після формування масивів, знаходять номери найбільшого та найменшого елементів масиву
        значень функції, та методи, що обчислюють та суму та середнє арифметичне елементів масиву значень функції. Методи
        створювати разом з тестами та постійно виконувати тестування.
 */

    private double[] sortArray(double[] array){
        double[] tempArray = Arrays.copyOf(array, array.length);
        Arrays.sort(tempArray);
        return tempArray;
    }

    public int indexOfMaxElement(double[] array){
        double[] tempArray = sortArray(array);

        double max = tempArray[tempArray.length - 1];
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == max){
                index = i + 1;
                break;
            }
        }
        return index;
    }

    public int indexOfMinElement(double[] array){
        double[] tempArray = sortArray(array);

        double min = tempArray[0];
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == min){
                index = i + 1;
                break;
            }
        }
        return index;
    }

    public double sumOfElementsOfArray(double[] array){
        double sum = 0;
        for (double x : array) {
            sum += x;
        }
        return sum;
    }

    public double avgOfElementsOfArray(double[] array) {
        return sumOfElementsOfArray(array) / array.length;
    }

    /*
        7. Створити методи виведення найбільшого та найменшого елементів масиву значень функції, вказавши їхні номери і
            відповідні значення аргументу.
     */

    public void printMinElementOfArray(double[] array){
        int numOfElement = indexOfMinElement(array);
        System.out.println(numOfElement + ": " + array[numOfElement - 1]);
    }

    public void printMaxElementOfArray(double[] array){
        int numOfElement = indexOfMaxElement(array);
        System.out.println(numOfElement + ": " + array[numOfElement - 1]);
    }
}
