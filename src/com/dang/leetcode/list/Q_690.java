package com.dang.leetcode.list;

import java.util.*;

/**
 * 员工的重要性(https://leetcode-cn.com/problems/employee-importance/)
 * @author dht
 * @date 17/11/2019
 */
public class Q_690 {

    private Map<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        Employee target = null;
        map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
            if (e.id == id) target = e;
        }
        return getImportance(target);
    }

    private int getImportance(Employee e) {
        int sum = e.importance;
        for (int i : e.subordinates) {
            sum += getImportance(map.get(i));
        }
        return sum;
    }

}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
