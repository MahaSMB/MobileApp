//
//  CalBrain.swift
//  Calculator_MahaB
//
//  Created by Maha Basheikh on 2023-10-05.
//

import UIKit

class CalBrain: NSObject {
    // lazy loading the array
    private lazy var items = NSMutableArray()
    
    // method to push numbers to the array
    func pushItem(number: Double) {
        //self.items.addObjects(from: number)
        
        // add a number to the array
        items.add(number)
    }
    
    // method to pop or take out a number from the array to use
    func popItem() -> Double {
        if items.count > 0 { // if the array is not empty
            //var lastItem: Double
            
            //unwrap the optional as a double
            if let lastItem = items.lastObject as? Double {
                items.removeLastObject() // take out the last object from the array
                
                return lastItem //return it to the caller
            }
        }
        else {
            return -1.0 // if the array is empty, return a -1, signaling an error
        }
              
        return -1.0 // if the array is empty, return a -1, signalling an error
    }
    
    // method to calculate the operation
    func calculate(opr: String) -> Double? {
        if opr == "+" {
            return popItem() + popItem() // addition
        }
        else if opr == "-" {
            return popItem() - popItem() // subtraction
        }
        else if opr == "✖️" {
            return popItem() * popItem() // multiplication
        }
        else if opr == "÷" { // division
            
            // declaring the numerator and denominator
            var numerator: Double
            var denominator: Double
            
            // popping the numberator and denominator
            denominator = popItem()
            numerator = popItem()
            
            if denominator == 0 { // We are making sure to let the user know they can't divide from zero and exiting
                print("Cannot divide by zero!")
                return nil
            }
            return numerator / denominator // returning the result of the calculation
        }
        else {
            print("Invalid operator") // if an invalid is somehow entered
        }
        return -1.0
    }
    
}

