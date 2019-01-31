//*******************************************************************
//  Gayatri Rajan
//  Phillips Academy, Andover
//  Senior-3
//*******************************************************************
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
public class Contest_2 {
 public static void main(String[] args) {
  List < String > strings = new ArrayList < > ();
  List < String > AB = new ArrayList < > ();
  List < String > BA = new ArrayList < > ();
  Scanner scanner = new Scanner(System.in);
  for (int i = 0; i < 10; i++) {
   strings.add(scanner.nextLine());
  } //   25768437216701562 7
  scanner.close();
  for (int j = 0; j < 10; j += 2) {
   AB.add(getABComparisons(strings.get(j), strings.get(j + 1)));
   BA.add(getBAComparisons(strings.get(j), strings.get(j + 1)));
  }
  for (int k = 0; k < 5; k++) {
   String yes = getFinalString(AB.get(k), BA.get(k));
   System.out.println("Final: " + yes);
  }
 }
 public static String getABComparisons(String A, String B) {
  List < String > arrA = new ArrayList < > (Arrays.asList(A.split(" ")));
  String AB = "";
  for (int i = 0; i < arrA.size(); i++) {
   if (B.contains(arrA.get(i))) {
    AB += (arrA.get(i));
    int index = B.indexOf(arrA.get(i));
    B = B.substring(0, index) + B.substring(index + (arrA.get(i)).length());
   }
  }

  return AB;
 }
 public static String getBAComparisons(String A, String B) {
  return getABComparisons(B, A);
 }
 public static String getFinalString(String AB, String BA) {
  List < Character > arrAB = cleanString(AB);
  String[] aBA = BA.split(" ");
  String sBA = "";
  String s1 = "";
  for (int i = 0; i < (aBA.length); i++) {
   sBA += aBA[i];
  }
  for (int j = 0; j < arrAB.size(); j++) {
   if (sBA.indexOf(arrAB.get(j)) >= 0) {
    sBA = sBA.substring(sBA.indexOf(arrAB.get(j)) + 1);
    s1 += arrAB.get(j);
   }
  }
  return s1;
 }
 public static List < Character > cleanString(String AB) {
  String[] aAB = AB.split(" ");
  String sAB = "";
  for (int i = 0; i < (aAB.length); i++) {
   sAB += aAB[i];
  }
  char[] cAB = sAB.toCharArray();
  List < Character > arrAB = new ArrayList < Character > ();
  for (int j = 0; j < cAB.length; j++) {
   arrAB.add(cAB[j]);
  }
  return arrAB;
 }
}
