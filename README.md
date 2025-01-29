# Shamir's Secret Sharing - Polynomial Reconstruction

## 📌 Overview

This project implements a simplified version of Shamir's Secret Sharing to reconstruct a secret using Lagrange Interpolation. Given a set of encoded (x, y) points from a JSON file, the program decodes the values, constructs the polynomial, and determines the constant term (c).

## 🚀 How It Works

Reads input from a JSON file containing values in different numerical bases.

Decodes the y-values into base-10.

Uses Lagrange Interpolation to reconstruct the polynomial.

Finds the secret (c), which is the constant term of the polynomial.

Prints the computed secret.

## 🔧 Setup & Execution

### 1️⃣ Prerequisites

Java 8 or above

JSON library (org.json)

A text editor or IDE (IntelliJ, VS Code, Eclipse)

SpringBoot

### 2️⃣ Clone the Repository
```
git clone https://github.com/Sk1458/CognizantTest.git
cd ShamirSecretSharing
```
### 3️⃣ Install Dependencies

Ensure you have the org.json library. If missing, add it using Maven:

<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20210307</version>
</dependency>

Or manually download json-20210307.jar and add it to the project.

### 4️⃣ Run the Program

javac ShamirSecretSharing.java
java ShamirSecretSharing input.json input2.json

## 📝 Example JSON Input
```
{
    "keys": {
        "n": 4,
        "k": 3
    },
    "1": { "base": "10", "value": "4" },
    "2": { "base": "2", "value": "111" },
    "3": { "base": "10", "value": "12" }
}
```
## 🏆 Expected Output
```
Secret for input1.json: 3
Secret for input2.json: <calculated_value>
```
## 💡 Key Features

✅ Reads and parses JSON input <br>
✅ Decodes numbers from different bases <br>
✅ Implements Lagrange Interpolation <br>
✅ Finds the constant term of the polynomial <br>
✅ Handles multiple test cases simultaneously

## 🔍 Troubleshooting

FileNotFoundException: Ensure the input JSON files exist in the same directory.

org.json.JSONException: Verify that your JSON file is correctly formatted.

Incorrect Secret Value: Double-check base conversions and interpolation logic
