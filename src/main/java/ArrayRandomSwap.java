/**
 * Дан массив размерностью 20 элементов, заполненный случайными числами от -10 до 10.
 * Находим в нём максимальный отрицательный и минимальный положительный элементы массива
 * Меняем местами данные элементы
 * @author SNesterov
 * @version 0.1
 */

public class ArrayRandomSwap {

    public static void main(String[] args) {
        //Создаём массив и заполняем его случайными числами в диапазоне от -10 до 10
        int[] randomArray = new int[20];
        for (int i = 0; i < 20; i++){
            randomArray[i] = rnd(-10,10);
        }

        //Выводим содержимое массива
        System.out.println("Массив содержит следующие числа: ");
        for (int i = 0; i < 20; i++){
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();
        //Находим максимальный отрицательный и минимальный положительный элементы массива и выводим информацию о них
        int PositionMinElem = findPositionMinElem(randomArray);
        int PositionMaxElem = findPositionMaxElem(randomArray);

        if (PositionMinElem >= 0) {
            System.out.println("Максимальное отрицательное число в массиве: " + randomArray[PositionMinElem] + ", находится на позиции " + (PositionMinElem + 1));
        } else System.out.println("В массиве нет отрицательных чисел");

        if (PositionMaxElem >= 0) {
            System.out.println("Минимальное положительное число в массиве: " + randomArray[PositionMaxElem] + ", находится на позиции " + (PositionMaxElem + 1));
        } else System.out.println("В массиве нет положительных чисел");

        //Меняем местами максимальный отрицательный и минимальный положительный элементы массива если они есть
        if (PositionMinElem < 0 || PositionMaxElem < 0) {
            System.out.println("Невозможно поменять местами максимальной отрицательное число и минимальное положеительное, по причине отсутсвия одного из них");
        } else  {
            randomArray = swap(randomArray, findPositionMinElem(randomArray), findPositionMaxElem(randomArray));
            System.out.println("После замены местами минимального положительного элемента и максимального отрицательного, массив выглядит так: ");
            //Выводим массив после того как поменяли элементы местами
            for (int i = 0; i < 20; i++){
                System.out.print(randomArray[i] + " ");
            }
        }
    }

    /**
     * Функция для нахождения максимального отрицательного числа в массиве
     * @param someArray Массив в котором ищем число
     * @return возвращает номер элемента в массиве содержащего максимальное отрицательное число
     */
    public static int findPositionMinElem(int[] someArray) {
        int min = -1;
        for (int i = 0; i < someArray.length; i++) {
            if (someArray[i] < 0) {
                if (min >= 0) {
                    if (someArray[i] > someArray[min]) {
                        min = i;
                    }
                } else {
                    min = i;
                }
            }
        }
        return min;
    }

    /**
     * Функция для нахождения минимального положительного числа в массиве
     * @param someArray Массив в котором ищем число
     * @return возвращает номер элемента в массиве содержащего минимальное положительное число
     */
    public static int findPositionMaxElem(int[] someArray) {
        int max = -1;
        for (int i = 1; i < someArray.length; i++) {
            if (someArray[i] >= 0) {
                if (max >= 0) {
                    if (someArray[i] < someArray[max]) {
                        max = i;
                    }
                } else {
                    max = i;
                }
            }
        }
        return max;
    }

    /**
     * Функция, которая в массиве, меняет указанные элемен местами
     * @param someArray Массив в котором ищем число
     * @param firstElem Номер элемента в массиве который нужно поменять с другим
     * @param secondElem Номер элемента в массиве который нужно поменять с другим
     * @return Возвращает массив после произведения замены
     */
    public static int[] swap(int[] someArray, int firstElem, int secondElem) {
        int temp;
        temp = someArray[firstElem];
        someArray[firstElem] = someArray[secondElem];
        someArray[secondElem] = temp;
        return someArray;
    }

    /**
     * Функция для генерации целого псевдослучайного числа в указанном диапазоне
     * @param min минимальная граница диапазона
     * @param max максимальная граница диапазона
     * @return возвращает псевдослучайное целое число
     */
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
