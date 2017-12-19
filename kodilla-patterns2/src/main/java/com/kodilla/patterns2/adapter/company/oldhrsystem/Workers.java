package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"0123456789", "John", "Smith"},
            {"1123456789", "John1", "Smith1"},
            {"2123456789", "John2", "Smith2"},
            {"3123456789", "John3", "Smith3"},
            {"4123456789", "John4", "Smith4"},
    };
    private double[] salaries = {
            4000,
            3000,
            1000,
            1000,
            5001
    };

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        } else {
            return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] +  ", " + salaries[n];
        }
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
