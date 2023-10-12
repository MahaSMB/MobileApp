//
//  ViewController.swift
//  Calculator_MahaB
//
//  Created by Maha Basheikh on 2023-10-05.

// This calculator runs as a postfix calculator

import UIKit

class ViewController: UIViewController {
    var isNewNumber = true // boolean to check if the number is a new number
    var mainAnswerDisplay: String? // variable for the main answer
    var expandedAnswerDisplay: String? // variable for the extended answer showing the full operation (not implemented)
    var newDigit: String? // new digit in the number
    var result: Double = 0.0 // result
    //var newNumber: String?

    @IBOutlet weak var expandedAnswerView: UILabel!  // label showing the extended answer for the full operation (not implemented)
    @IBOutlet weak var answerView: UILabel! // label for the main answer
    override func viewDidLoad() {
        super.viewDidLoad()
        isNewNumber = true // setting the isNewNumber to true
        
        // Do any additional setup after loading the view.
    }
    
    lazy var brain = CalBrain() // lazy loading the CalBrain
    
    // Creates a button which shows the button value in the main answer label when pressed
    @IBAction func digitPressed(_ sender: UIButton) {
        // if the label is empty
        if answerView.text!.isEmpty {
            isNewNumber = true // set the boolean to the number is new
        }
        else {
            isNewNumber = false // otherwise set the boolean to the number is not new
        }
        
        if isNewNumber { // if the number is new
            answerView.text = sender.currentTitle // save the text from the label in a string
            isNewNumber = false // set the boolean value to the number is not new
        }
        else {
            // if not a new number, assign string value to what's shown on the main answer display
            mainAnswerDisplay = answerView.text
            
            // For each new digit, assign a string value
            newDigit = sender.currentTitle
            
            //unwrapping mainAnswerDisplay optional
            if let possibleMainAnswerDisplay = mainAnswerDisplay, let possibleNewDigit = newDigit {
                let newNumber = possibleMainAnswerDisplay + possibleNewDigit
                
            // display the new value
            answerView.text = newNumber
            }
        }
    }
    
    // When the decimal point button is pressed
    @IBAction func decimalPointPressed(_ sender: UIButton) {
        if answerView.text!.isEmpty { // if the main answer label is not empty
            isNewNumber = true // set the boolean value to the number is new
        }
        else {
            isNewNumber = false // set the boolean value to the number is NOT new
        }
        
        if isNewNumber { // if the number is new
            answerView.text = sender.currentTitle // save the text from the label in a string
            isNewNumber = false // set the boolean value to the number is not new
        }
        else {
            // if not a new number, assign string value to what's shown on the main answer display
            mainAnswerDisplay = answerView.text
            
            // For each new digit, assign a string value
            newDigit = sender.currentTitle
            
            //unwrapping mainAnswerDisplay optional
            if let possibleMainAnswerDisplay = mainAnswerDisplay, let possibleNewDigit = newDigit {
                let newNumber = possibleMainAnswerDisplay + possibleNewDigit
                
            // display the new value
            answerView.text = newNumber
            }
        }
    }
    
    // When an operator button is pressed
    @IBAction func operatorPressed(_ sender: UIButton) {
        var newSign: String // declare a string to store the operator
        newSign = sender.currentTitle! // assign the operator from the main answer label to the string
        
        if let possibleResult = brain.calculate(opr: newSign) { // unwrap the string variable and perform the calculation. Store the result
            
            //let string = String(format: "%.2f", number)
                                    
            answerView.text = String(format:"%.2f", possibleResult) // output the result to the main answer label
            isNewNumber = true // set the boolean value to the number is new
        }
    }
    
    // Deletes just one digit from the answerView display
    @IBAction func backspacePressed(_ sender: UIButton) {
        if !answerView.text!.isEmpty { // if the main answer label is not empty
                        
            mainAnswerDisplay = answerView.text // transfer to a string variable
            
            // Count the number of characters in the string
            //let numberLength = mainAnswerDisplay!.count
            
            // Remove the last character in the string
            mainAnswerDisplay!.removeLast(1)
                        
            // Replace the string in the label
            answerView.text = mainAnswerDisplay!
        }
    }
    
    // Changing the sign of the number entered
    @IBAction func changeSignPressed(_ sender: UIButton) {
        if !answerView.text!.isEmpty { // if the main answer label is not empty
            mainAnswerDisplay = answerView.text // extract the text from it and store it in a string
            
            let resultSignChanged = Double (mainAnswerDisplay!) // Take the string, force unwrap it, cast it as a double and store it in a new variable
            
            answerView.text = String(format:"%.2f", resultSignChanged! * -1) // multiply that variable and output it to the main answer label
        }
    }
    
    // Button to clear the display completely
    @IBAction func deletePressed(_ sender: UIButton) {
        if !answerView.text!.isEmpty { // if the main answer label is not empty
            answerView.text = "" // wipe it clean
        }
        
    }
    
    // When the equal button is pressed
    @IBAction func equalPressed(_ sender: UIButton) {
        if !answerView.text!.isEmpty { // if the main answer display is not empty
            
            mainAnswerDisplay = answerView.text // extract its text and store it in a string
            
            if let possible_mainAnswerDisplay = mainAnswerDisplay { // unwrap that string and cast it as a double
                let resultDouble = Double (possible_mainAnswerDisplay)
                
                brain.pushItem(number: resultDouble!) // push that double onto the array
                
                answerView.text = "" // clear the main answer display to for the next entry
            }
        }
    }
    
    
}

