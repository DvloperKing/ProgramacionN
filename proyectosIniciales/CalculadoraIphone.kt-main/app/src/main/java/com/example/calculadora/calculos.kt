package com.example.calculadora
class Calculations {
    // Function to validate an expression
    fun ValidateExpression(expression: String): Double? {
        // Replace commas with dots in the expression
        val correctedExpression = expression.replace(',', '.')

        // List of Values and Operators
        val values = mutableListOf<Double>()
        val operators = mutableListOf<Char>()

        // Operator Precedence
        val operatorPrecedence = mapOf('+' to 1, '-' to 1, 'X' to 2, '/' to 2)

        // Function to calculate and add to the list
        fun applyOperator() {
            if (operators.isNotEmpty() && values.size >= 2) {
                val b = values.removeAt(values.size - 1)
                val a = values.removeAt(values.size - 1)
                val operator = operators.removeAt(operators.size - 1)
                when (operator) {
                    '+' -> values.add(a + b)
                    '-' -> values.add(a - b)
                    'X' -> values.add(a * b)
                    '/' -> {
                        if (b == 0.0) {
                            throw ArithmeticException("Division by zero")
                        }
                        values.add(a / b)
                    }
                }
            }
        }

        // Validations
        var tempNumber = ""
        for (char in correctedExpression) {
            // Check to consider the dot and perform calculations with decimal numbers
            when {
                char.isDigit() || char == '.' -> {
                    tempNumber += char
                }
                // Check to consider operators
                char in "+-X/" -> {
                    if (tempNumber.isNotEmpty()) {
                        values.add(tempNumber.toDouble())
                        tempNumber = ""
                    }
                    // Operator Precedence
                    while (operators.isNotEmpty() && operatorPrecedence.getOrDefault(char, 0)
                        <= operatorPrecedence.getOrDefault(operators.last(), 0)
                    ) {
                        applyOperator()
                    }
                    operators.add(char)
                }
                char == '(' -> operators.add(char)
                char == ')' -> {
                    if (tempNumber.isNotEmpty()) {
                        values.add(tempNumber.toDouble())
                        tempNumber = ""
                    }
                    while (operators.isNotEmpty() && operators.last() != '(') {
                        applyOperator()
                    }
                    if (operators.isNotEmpty() && operators.last() == '(') {
                        operators.removeAt(operators.size - 1)
                    } else {
                        return null // Invalid expression (unbalanced parentheses)
                    }
                }
                char != ' ' -> return null // Invalid character
            }
        }
        if (tempNumber.isNotEmpty()) {
            values.add(tempNumber.toDouble())
        }
        while (operators.isNotEmpty()) {
            if (operators.last() == '(' || operators.last() == ')') return null // Unbalanced parentheses
            applyOperator()
        }
        return if (values.size == 1 && operators.isEmpty()) values[0] else null // Valid expression
    }
}
