/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author roger
 */

// This utility class implements a non-recursive Binary Search
// to find an employee by name in a sorted list.

import java.util.*;

class SearchUtil {  // Binary search method to find an employee by name
    public static Employee binarySearch(List<Employee> sortedList, String name) {
        int low = 0, high = sortedList.size() - 1; // Start and end index of the search range
        
        while (low <= high) { // Loop while the search range is valid
            int mid = (low + high) / 2; // Find the middle index
            int cmp = sortedList.get(mid).getName().compareToIgnoreCase(name);
            
            if (cmp == 0) 
                return sortedList.get(mid); // Found a match
            
            else if (cmp < 0) 
                low = mid + 1;  // Target name is after the middle, move to the right half
            
            else 
                high = mid - 1; // Target name is before the middle, move to the left half
        }
        return null; // If not found, return null
    }
}
