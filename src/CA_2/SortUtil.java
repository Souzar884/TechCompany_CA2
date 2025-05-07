/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author roger
 */

// This utility class implements the recursive Merge Sort algorithm
// to alphabetically sort a list of Employee objects by name.

import java.util.*;

class SortUtil {
    public static void mergeSort(List<Employee> list) {  // Public method to apply merge sort on a list of employees
        if (list.size() > 1) {  // Base case: If the list has 1 or no elements, it's already sorted
            int mid = list.size() / 2;  // Find the middle index of the list
            
             // Split the list into left and right halves
            List<Employee> left = new ArrayList<>(list.subList(0, mid)); 
            List<Employee> right = new ArrayList<>(list.subList(mid, list.size()));
            
            // Recursively sort both halves
            mergeSort(left);
            mergeSort(right);
            
            merge(list, left, right); // Merge the sorted halves into the original list
        }
    }

    private static void merge(List<Employee> list, List<Employee> left, List<Employee> right) { // Private helper method to merge two sorted lists into one
        int i = 0, j = 0, k = 0;
       while (i < left.size() && j < right.size()) { // Compare elements from both lists and insert the smallest one into the result
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) < 0) { // Compare employee names alphabetically (case-insensitive)
                list.set(k++, left.get(i++));  // add from left list
            } else {
                list.set(k++, right.get(j++)); // add from right list
            }
        }
        while (i < left.size()) list.set(k++, left.get(i++)); // Add any remaining elements from the left list
        while (j < right.size()) list.set(k++, right.get(j++)); // Add any remaining elements from the right list
    }
}
