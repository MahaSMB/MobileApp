//
//  ViewController.swift
//  PersonalityQuiz_MahaB
//
//  Created by Maha Basheikh on 2023-10-07.
//

import UIKit

class IntroductionViewController: UIViewController {
    var numberToDisplay = 0
    var counter = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func beginQuiz(_ sender: Any) {
    }
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        if segue.identifier == "BeginQuiz",
            let QuestionViewController = segue.destination as? IntroductionViewController {
                QuestionViewController.numberToDisplay = counter
        }
    }
    
    @IBAction func unwindToQuizIntroduction(segue: UIStoryboardSegue) {
        
    }
    @IBAction func unWindToQuizIntro(_ sender: UIBarButtonItem) {
    }
}

