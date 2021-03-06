package com.epam.rd.autocode.dao;

import com.epam.rd.autocode.dao.impl.SimpleDepartmentDao;
import com.epam.rd.autocode.dao.impl.SimpleEmployeeDao;

public class DaoFactory {
    public EmployeeDao employeeDAO() {
        return new SimpleEmployeeDao();
    }

    public DepartmentDao departmentDAO() {
        return new SimpleDepartmentDao();
    }
}
