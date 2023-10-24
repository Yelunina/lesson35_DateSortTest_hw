package ait.arrays.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DateSortTest {
    Comparator<String> comparator;

    @BeforeEach
    void setUp() {
        comparator = (s1, s2) -> {
            String[] dates1 = s1.split("-");
            String[] dates2 = s2.split("-");
            for (int i = dates1.length - 1; i >= 0; i--) {
                int date1 = Integer.parseInt(dates1[i]);
                int date2 = Integer.parseInt(dates2[i]);
                if (date1 > date2) {
                    return 1;
                }
                if (date1 < date2) {
                    return -1;
                }
            }
            return 0;
        };
    }

    @Test
    void testDateSort() {
        String[] dates = {
                "07-05-1990",
                "28-01-2010",
                "11-08-1990",
                "15-01-2010",
                "16-06-1970"
        };
        String[] expected = {
                "16-06-1970",
                "07-05-1990",
                "11-08-1990",
                "15-01-2010",
                "28-01-2010"
        };
        printArray(dates);
        Arrays.sort(dates, comparator);
        printArray(dates);
        assertArrayEquals(expected, dates);
    }

    private void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }
}