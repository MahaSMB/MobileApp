//
//  CitiesViewController.swift
//  Weather
//
//  Created by Maha Basheikh on 2023-10-12.
//

import UIKit

class CitiesViewController: UIViewController, UITableViewDelegate, UITableViewDataSource, UISearchBarDelegate {
    
    func numberOfSections(in tableView: UITableView) -> Int {

        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell2", for: indexPath)

        // Configure the cell...
        
        cell.textLabel?.text = "hihi 2"

        return cell
    }
    
    // When search bar button is clicked, Segue to AttractionsViewController
    func searchBarSearchButtonClicked(_ searchBar: UISearchBar) {
        if let text = searchBar.text {
            print(text) // text from search bar
          
            
            let SearchViewController: SearchViewController = SearchViewController()
            SearchViewController.userInputRequest = text
                    navigationController?.pushViewController(SearchViewController, animated: true)
        }
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }

    /*
     https://stackoverflow.com/questions/40630153/create-a-segue-to-another-view-controller-through-search-bar
     */
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
