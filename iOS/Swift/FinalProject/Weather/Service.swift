//
//  Service.swift
//  Weather
//
//  Created by Maha Basheikh on 2023-10-12.
//

import UIKit
import CoreData

class Service {
    private init(){}
    static var shared = Service()
    func getDataFrom(URLStr: String, completion: @escaping (Result<Data,Error>)->()) {
        guard let url = URL(string: URLStr) else {return}

        URLSession.shared.dataTask(with: url) { data, response, error in
            if let error = error {
                completion(.failure(error))
            }
            else if let data = data {
                completion(.success(data))
            }
        }.resume()
        }
    }

