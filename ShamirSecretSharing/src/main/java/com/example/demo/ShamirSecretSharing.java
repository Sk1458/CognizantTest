package com.example.demo;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;

public class ShamirSecretSharing {
	
	public static void main(String[] args) {
        // Define the file paths
        String file1 = "C:\\Users\\Saikumar\\Desktop\\COGNIZANT\\input.json";
        String file2 = "C:\\Users\\Saikumar\\Desktop\\COGNIZANT\\input2.json";

        // Solve for both test cases
        System.out.println("🔹 Solving First Test Case:");
        solveTestCase(file1);

        System.out.println("\n🔹 Solving Second Test Case:");
        solveTestCase(file2);
    }

    public static void solveTestCase(String filePath) {
        try {
            // Step 1: Read JSON File
            FileReader reader = new FileReader(filePath);
            JSONObject json = new JSONObject(new JSONTokener(reader));

            // Extract 'n' and 'k'
            JSONObject keys = json.getJSONObject("keys");
            int n = keys.getInt("n");
            int k = keys.getInt("k");

            // Extract (x, y) pairs
            List<Double> xValues = new ArrayList<>();
            List<Double> yValues = new ArrayList<>();

            for (String key : json.keySet()) {
                if (!key.equals("keys")) { // Ignore the "keys" object
                    JSONObject point = json.getJSONObject(key);
                    int x = Integer.parseInt(key);
                    int base = point.getInt("base");
                    String value = point.getString("value");

                    // Decode y-value from given base
                    double y = new java.math.BigInteger(value, base).doubleValue();

                    xValues.add((double) x);
                    yValues.add(y);
                }
            }

            // Step 3: Find constant 'c' using Lagrange Interpolation
            double c = lagrangeInterpolation(xValues, yValues, 0);
            System.out.println("🔑 Secret constant (c) = " + (long) c);

        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Lagrange Interpolation to find f(0)
    public static double lagrangeInterpolation(List<Double> x, List<Double> y, double x0) {
    	int n = x.size();
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            double term = y.get(i);
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    term *= (x0 - x.get(j)) / (x.get(i) - x.get(j));
                }
            }
            result += term;
        }
        return Math.round(result);  // Ensure integer output
    }

}
