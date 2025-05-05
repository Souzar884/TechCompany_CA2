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

class SearchUtil {
    public static Employee binarySearch(List<Employee> sortedList, String name) {
        int low = 0, high = sortedList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sortedList.get(mid).getName().compareToIgnoreCase(name);
            if (cmp == 0) return sortedList.get(mid);
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}
