//
//  CalBrain.swift
//  Calculator_MahaB
//
//  Created by Maha Basheikh on 2023-10-05.
//

import UIKit

class CalBrain: NSObject {    
    private lazy var items = NSMutableArray()
    
    func pushItem(number: Double) {
        //self.items.addObjects(from: number)
        
        items.add(number)
    }
    func popItem() -> Double {
        if items.count > 0 {
            //var lastItem: Double
            
            if let lastItem = items.lastObject as? Double {
                items.removeLastObject()
                
                return lastItem
            }
        }
        else {
            return -1.0
        }
              
        return -1.0
    }
    func calculate(opr: String) -> Double? {
        if opr == "+" {
            return popItem() + popItem()
        }
        if opr == "-" {
            return popItem() - popItem()
        }
        if opr == "✖️" {
            return popItem() * popItem()
        }
        else if opr == "÷" {
            
            var numerator: Double
            var denominator: Double
            
            denominator = popItem()
            numerator = popItem()
            
            
            if denominator == 0 {
                print("Cannot divide by zero!")
                return nil
            }
            return numerator / denominator
        }
        else {
            print("Invalid operator")
        }
        return -1.0
    }
    
}

