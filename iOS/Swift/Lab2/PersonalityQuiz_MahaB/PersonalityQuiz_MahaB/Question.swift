//
//  Question.swift
//  PersonalityQuiz_MahaB
//
//  Created by Maha Basheikh on 2023-10-07.
//

import Foundation

struct Question {
    var text: String
    var type: ResponseType
    var answers: [Answer]
}

struct Answer {
    var text: String
    var type: ExerciseType
}

enum ResponseType {
    case single, multiple, ranged
}

enum ExerciseType: Character {
    //Swimming pool, garden for yoga, gym for strength training, park path for cycling
    case swimming = "🏊🏽‍♀️", yoga = "🧘🏾‍♀️", strengthTraining = "🏋🏽‍♀️", cycling = "🚴🏽‍♀️"
    
    var definition: String {
        switch self {
        case .swimming:
            return "These are mainly aerobic exercises that will increase your breathing and heart rate. They keep the circulatory system and lungs healthy, prevet diabetes and heart disease, and help you build up endurance"
        case .yoga:
            return "Balance can strengthen the body’s core and help prevent falls. Some good balance exercises include heel-to-toe walking, standing on one foot, and ta chi. \r\n Flexibility exercises can keep your body limber and help you maintain a wide range of motion. This is important because range of motion is often limited by things like arthritis. Yoga and stretching are good practices for flexibility."
        case .strengthTraining:
            return "These exercises are designed to keep your bones and muscles strong. Strength training is beneficial in reducing falls and helping you do everyday activities that require lifting, such as carrying groceries. Some examples of strength training include lifting free weights and using resistance."
        case .cycling:
            return "These are mainly aerobic exercises that will increase your breathing and heart rate. They keep the circulatory system and lungs healthy, prevet diabetes and heart disease, and help you build up endurance"
        }
    }
}


