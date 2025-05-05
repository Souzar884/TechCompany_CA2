/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author roger
 */
import java.util.*;

class SortUtil {
    public static void mergeSort(List<Employee> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
            List<Employee> left = new ArrayList<>(list.subList(0, mid));
            List<Employee> right = new ArrayList<>(list.subList(mid, list.size()));

            mergeSort(left);
            mergeSort(right);
            merge(list, left, right);
        }
    }

    private static void merge(List<Employee> list, List<Employee> left, List<Employee> right) {
        int i = 0, j = 0, k = 0;
        ;
    }
}