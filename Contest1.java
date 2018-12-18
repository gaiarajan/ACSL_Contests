//*******************************************************************
//  Gayatri Rajan
//  Phillips Academy, Andover
//  Senior-3
//*******************************************************************
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigInteger;
public class Contest1 {
    public static void main(String[] args) {
        List < BigInteger > ints = new ArrayList < BigInteger > ();
        int sumArray[];
        List < String > tokens = new ArrayList < > ();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String array1[] = scanner.nextLine().split(" ");
            tokens.add(array1[0]);
            tokens.add(array1[1]);
        } //   25768437216701562 7
        scanner.close();
        for (int i = 0; i < tokens.size(); i++) {
            BigInteger result1 = new BigInteger(tokens.get(i));
            ints.add(result1);
        }
        for (int j = 0; j < 10; j += 2) {
            BigInteger sum1 = getSum(ints.get(j), ints.get(j + 1));
            System.out.println("This is the final sum for line " + ((j + 2) / 2) + " : " + sum1);
        }
    }
    public static BigInteger getSum(BigInteger number, BigInteger intFilter) {
        List < BigInteger > sumCreator = new ArrayList < BigInteger > ();
        double digits = getDigits(number);
        double filter = intFilter.doubleValue();;
        double numberOfSplits = digits / filter;
        BigInteger newNumber = getNewNumber(number, numberOfSplits, filter);
        String numberAsString = String.valueOf(newNumber);
        int filterParameter = 0;
        BigInteger one = new BigInteger("1");
        for (int k = 0; k < numberOfSplits; k++) {
            sumCreator.add(new BigInteger(numberAsString.substring(((filterParameter) * (intFilter.intValue())), ((filterParameter + 1) * (intFilter.intValue())))));
            filterParameter++;
        }
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < (sumCreator.size()); i++) {
            sum = sum.add(sumCreator.get(i));
        }
        return sum;
    }

    public static double getDigits(BigInteger number) {
        double digits = 0;
        BigInteger ten = new BigInteger("10");
        BigInteger zero = new BigInteger("0");
        while (number.compareTo(zero) == 1) {
            number = number.divide(ten);
            digits++;
        }
        return digits;
    }

    public static BigInteger getNewNumber(BigInteger number, double numberOfSplits, double filter) {
        BigInteger newNumber = number;
        List < BigInteger > numbers = new ArrayList < BigInteger > ();
        numbers.add(newNumber);
        while (numberOfSplits != (int) numberOfSplits) {
            String newNumberString = newNumber.toString() + "0";
            numbers.add(new BigInteger(newNumberString));
            newNumber = (numbers.get(numbers.size() - 1));
            numberOfSplits = (getDigits(numbers.get(numbers.size() - 1))) / filter;
        }
        return newNumber;
    }
}
