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
    var chosenRow = -1
    //lazy var sharedService = Service()
    
    // UISwipeGestureRecognizer
    
    lazy var myList = Array(myDictionary.listOfImages)

    @IBOutlet var swipeGestureItem: UISwipeGestureRecognizer!
    @IBOutlet weak var myImage: UIImageView!
    @IBOutlet weak var pickerView: UIPickerView!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        //UIImage has user interaction disabled by default
        myImage.isUserInteractionEnabled = true
        
        myImage.addGestureRecognizer(createSwipeGestureRecognizer(for: .left))
        myImage.addGestureRecognizer(createSwipeGestureRecognizer(for: .right))
        
        pickerView.reloadAllComponents()
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
        self.chosenRow = Int (row) // setting a variable that can be accessed outside of this function
        //print(myURLStr) // testing to see what myURLStr prints
                
        //self.myImage.image = getArrayImage(myURLStr)
        Service.shared.getImage(urlStr: myURLStr) { data in
            if let data = data {
                DispatchQueue.main.async {
                    [unowned self] in
                    self.myImage.image = UIImage(data: data)
                }
            }
        }
    }
    
//    func getArrayImage(urlStr: stringURL) ->(UIImageView) {
//        Service.shared.getImage(urlStr: stringURL) { data in
//            if let data = data {
//                DispatchQueue.main.async {
//                    [unowned self] in
//                    self.myImage.image = UIImage(data: data)
//                }
//            }
//        }
//    }
    
    @objc func didSwipe(_ sender: UISwipeGestureRecognizer) {
       
        var frame = myImage.frame
        
        switch sender.direction {
        case .left:
            frame.origin.x -= 100.0
            frame.origin.x = max(0.0, frame.origin.x)
            let myURLStr = myList[chosenRow - 1].value
            // Changing to the image prior
           
            Service.shared.getImage(urlStr: myURLStr) { data in
                if let data = data {
                    DispatchQueue.main.async {
                        [unowned self] in
                        self.myImage.image = UIImage(data: data)
                    }
                }
            }
            // Updating the Picker View to reflect
            pickerView.selectRow(chosenRow, inComponent: 0, animated: true)
            pickerView.reloadAllComponents()
        case .right:
            frame.origin.x += 100.0
            
            if frame.maxX > view.bounds.maxX {
                frame.origin.x = view.bounds.width - frame.width
            }
            // changing to the image after
            let myURLStr = myList[chosenRow - 1].value
            // Changing to the image prior
            
            Service.shared.getImage(urlStr: myURLStr) { data in
                if let data = data {
                    DispatchQueue.main.async {
                        [unowned self] in
                        self.myImage.image = UIImage(data: data)
                    }
                }
            }
            // Change the row of the Picker View
            pickerView.selectRow(chosenRow, inComponent: 0, animated: true)
            pickerView.reloadAllComponents()
        default:
            break
        }
        
        UIImageView.animate(withDuration: 0.25) {
            self.myImage.frame = frame
        }
    }
    
    func createSwipeGestureRecognizer(for direction: UISwipeGestureRecognizer.Direction) -> UISwipeGestureRecognizer {
        let swipeGestureRecognizer = UISwipeGestureRecognizer(target: self, action: #selector(didSwipe(_:)))
        
        swipeGestureRecognizer.direction = direction
        
        return swipeGestureRecognizer
    }

    // references:
    // Gestures: https://www.youtube.com/watch?v=rjQWKfEc9lY&t=3s
    // https://cocoacasts.com/swift-fundamentals-working-with-swipe-gesture-recognizers-in-swift
    // https://stackoverflow.com/questions/17927688/gesture-recognizer-swipe-on-uiimageview
}

