//
//  SearchViewController.swift
//  Weather
//
//  Created by Maha Basheikh on 2023-10-12.
//

import UIKit
import CoreData

struct City { // City?
    let name: String // name of city
    let main: String // Gives temp and numerical weather info
    let weather: [Weather] // Where icon is stored and gives descriptive weather info, e.g. "rain"
    let attractions: [Todo] // list of attractions
}

struct Main { // Gives weather info in numbers
    let temp: Float
    let pressure: Int
    let humidity: Int
    let temp_min: Float
    let temp_max: Float
}

struct Weather{
    let id: Int // e.g. 500
    let main: String // e.g. Rain
    //let description: String // e.g. light rain
    let icon: String // e.g. 10d
}
struct Todo { // Since array in database set as Type: "To Many" // Todo?
    let name: String
}

class SearchViewController: UITableViewController, UISearchBarDelegate {
    @IBOutlet weak var SVCSearchBar: UISearchBar!
    
    var userInputRequest = ""
    let delegate = UIApplication.shared.delegate as! AppDelegate
    
    func searchBar(_ searchBar: UISearchBar,
                   textDidChange searchText: String) {
        
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        
        /* Taken from Oct. 11 Zoom lecture circa 3:50 */
//        let city1 = City(delegate.persistentContainer.viewContext)
//        city1.name = "Toronto"
        
        
        /*Taken from Oct. 11 Zoom lecture circa 4:03*/
//        let address = Address(context: delegate.persistentContainer.viewContext)
//        address.url = "someURL"
//        m1.address = address
        //address.owner = m1 // setting the owner as m1 // inferred when inverses are set and thus not needed
        
        /*Taken from Oct. 11 Zoom lecture circa 4:12 */
//        let mark1 = Mark(context: delegate.persistentContainer.viewContext)
//        mark1.grade = 12.4
//        mark1.testName = "Midterm"
//        m1.addToMarks()
        
        /* Taken from Oct. 11 Zoom lecture circa 3:50 */
        //let m2 = Model(context: delegate.persistentContainer.viewContext)
        // m2.attribute = "someString"
        // m2.anotherAttribute = "someOtherString"
        
        /* Taken from Oct. 11 Zoom lecture circa 3:50 */
        //let m3 = Model(context: delegate.persistentContainer.viewContext)
        // m3.attribute = "someString"
        // m3.anotherAttribute = "someOtherString"
        

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        
        /* Taken from Zoom lecture circa 3:40 */
        delegate.saveContext()
        
        /* Taken from Zoom lecture circa 3:50 */
        
        // let fetchRequest = City.fetchRequest() // Will give all the Model object records
        
        //fetchRequest.predicate = NSPredicate (format: "name == %@", "Toronto") // Taken from Oct. 11 Zoom lecture circa 4:33
        
        // if let results = try? delegate.persistentContainer.viewContext.fetch(fetchRequest) // returns an object
        // for city in results {
        //}
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return 3
    }

   
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell1", for: indexPath)

        // Configure the cell...
        
        cell.textLabel?.text = "hihi 1"

        return cell
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
