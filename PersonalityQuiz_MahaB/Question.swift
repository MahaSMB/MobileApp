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

enum ResponseType {
    case single, multiple, ranged
}

enum ExerciseType: Character {
    //Swimming pool, garden for yoga, gym for strength training, park path for cycling
    case swimming = "🏊🏽‍♀️", yoga = "🧘🏾‍♀️", strengthTraining = "🏋🏽‍♀️", cycling = "🚴🏽‍♀️"
    
    var definition: String {
        switch self {
        case .swimming:
            return " blah"
        case .yoga:
            return "bal blah"
        case .strengthTraining:
            return "bjajskdlfjl;"
        case .cycling:
            return "blah blah blah blah"
        }
    }
}


