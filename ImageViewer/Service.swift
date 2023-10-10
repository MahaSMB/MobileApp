//
//  Service.swift
//  ImageViewer
//
//  Created by Maha Basheikh on 2023-10-10.
//

import UIKit

class Service {
    private init() {}
    static var shared = Service()
    func getImage(urlStr: String, completion: @escaping (Data?)->()){
        guard let url = URL( string: urlStr) else {return}
        let myQ = DispatchQueue(label: "myQ")
        myQ.async {
            let data = try? Data(contentsOf: url)
            completion(data)
        }
    }
}
