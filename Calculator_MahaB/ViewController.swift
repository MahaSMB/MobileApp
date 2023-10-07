//
//  ViewController.swift
//  Calculator_MahaB
//
//  Created by Maha Basheikh on 2023-10-05.
//

import UIKit

class ViewController: UIViewController {
    var isNewNumber = true
    var mainAnswerDisplay: String?
    var expandedAnswerDisplay: String?
    var newDigit: String?
    var result: Double = 0.0
    //var newNumber: String?

    @IBOutlet weak var expandedAnswerView: UILabel!
    @IBOutlet weak var answerView: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        isNewNumber = true
        
        // Do any additional setup after loading the view.
    }
    
    lazy var brain = CalBrain()
    
    @IBAction func digitPressed(_ sender: UIButton) {
        
        if answerView.text!.isEmpty {
            isNewNumber = true
        }
        else {
            isNewNumber = false
        }
        
        if isNewNumber {
            answerView.text = sender.currentTitle
            isNewNumber = false
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
    
    @IBAction func decimalPointPressed(_ sender: UIButton) {
        if answerView.text!.isEmpty {
            isNewNumber = true
        }
        else {
            isNewNumber = false
        }
        
        if isNewNumber {
            answerView.text = sender.currentTitle
            isNewNumber = false
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
    
    @IBAction func operatorPressed(_ sender: UIButton) {
        var newSign: String
        newSign = sender.currentTitle!
        
        if let possibleResult = brain.calculate(opr: newSign) {
            
            //let string = String(format: "%.2f", number)
                                    
            answerView.text = String(format:"%.2f", possibleResult)
            isNewNumber = true
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
    
    @IBAction func changeSignPressed(_ sender: UIButton) {
        if !answerView.text!.isEmpty {
            mainAnswerDisplay = answerView.text
            
            let resultSignChanged = Double (mainAnswerDisplay!)
            
            answerView.text = String(format:"%.2f", resultSignChanged! * -1)
        }
    }
    
    @IBAction func deletePressed(_ sender: UIButton) {
        if !answerView.text!.isEmpty {
            answerView.text = ""
        }
        
    }
    @IBAction func equalPressed(_ sender: UIButton) {
        if !answerView.text!.isEmpty {
            
            mainAnswerDisplay = answerView.text
            
            if let possible_mainAnswerDisplay = mainAnswerDisplay {
                let resultDouble = Double (possible_mainAnswerDisplay)
                
                brain.pushItem(number: resultDouble!)
                
                answerView.text = ""
            }
        }
    }
    
    
}

