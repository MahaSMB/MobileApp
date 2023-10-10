//
//  ViewController.swift
//  ImageViewer
//
//  Created by Maha Basheikh on 2023-10-10.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    //var URLStr: URL?
    lazy var myDictionary = Model()
    //lazy var sharedService = Service()
    
    lazy var myList = Array(myDictionary.listOfImages)

    @IBOutlet weak var myImage: UIImageView!
    @IBOutlet weak var pickerView: UIPickerView!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    // Setting number of components of picker view
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    // Setting number of rows in Picker View
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return myList.count
    }
   
    
    // Getting data for Picker View
    func pickerView(_ pickerView: UIPickerView,
                 titleForRow row: Int,
               forComponent component: Int) -> String? {
        return myList[row].key
    }
    
    func pickerView(_ pickerView: UIPickerView,
                    didSelectRow row: Int,
                    inComponent component: Int) {
        //let rowStr = String (myList[row].key)
        let myURLStr = (myList[row].value)  // prints the value of the myDictionary

        //print(myURLStr) // testing to see what myURLStr prints
                
        Service.shared.getImage(urlStr: myURLStr) { data in
            if let data = data {
                DispatchQueue.main.async {
                    [unowned self] in
                    self.myImage.image = UIImage(data: data)
                }
            }
        }
        
    }
    
}

