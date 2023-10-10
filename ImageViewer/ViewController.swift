//
//  ViewController.swift
//  ImageViewer
//
//  Created by Maha Basheikh on 2023-10-10.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {


    @IBOutlet weak var pickerView: UIPickerView!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    // Setting number of components of picker view
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1;
    }
    
    // Setting number of rows in Picker View
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return 5;
    }
   
    // 
     
    
    // Getting data for Picker View
    func pickerView(_ pickerView: UIPickerView,
                 titleForRow row: Int,
               forComponent component: Int) -> String? {
        return "String"
    }
    
}

