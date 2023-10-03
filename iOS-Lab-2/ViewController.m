//
//  ViewController.m
//  
//
//  Created by Maha Basheikh on 2023-09-20.
//

#import "ViewController.h"
#import "CalBrain.h" // import the calBrian implementation

@interface ViewController ()
// create a display object
@property(weak,nonatomic)IBOutlet UILabel *myDisplay;

// create a boolean value
@property bool isNewNumber;

// create CalBrain object myModel
@property (nonatomic)CalBrain * myModel;
@end

@implementation ViewController

//lazy loading (only loads when the getter for myModel is used)
-(CalBrain*)myModel{

if (_myModel == nil){
    // allocate memory for mymodel obj
    _myModel =  [[CalBrain alloc]init];

}
    return _myModel;
}
// create a button which shows the button value in the display when pressed
- (IBAction)DigitPressed:(UIButton *)sender {
    // Display if new number
    if(self.isNewNumber){
        // Display the entered number
        self.myDisplay.text = sender.titleLabel.text;
        // Set the isNumber to No
        self.isNewNumber = NO;
    }else{
        // if not new number assing string value to what is shown in the display
        NSString *valueOnDisplay = self.myDisplay.text;
        
        // assing string to the new digit entered
        NSString *newDigit = sender.titleLabel.text;
        
        // save both nubmeres in string format (concatenate)
        NSString *newNumber = [NSString stringWithFormat:@"%@%@",valueOnDisplay,newDigit];
        
        // display the new concatenated value
        self.myDisplay.text = newNumber;
    }
}

// Function to calculate the result based on the operator
- (IBAction)Operator_pressed:(UIButton*)sender {
//  Get the operator from user, set it as a string and save in newSign
    NSString *newSign = sender.titleLabel.text;
    
    //Call the calculate function and send parameter newSign and
    //store in the variable result.
     double result = [self.myModel calculate:newSign];
    
  // change the format to string and display it
    self.myDisplay.text = [NSString stringWithFormat:@"%0.2f",result];
    
    // change the bool to yes so we can clear previous result and enter a new one
    self.isNewNumber = YES;
    

   
}
// Function used to push values to array and clear the display
- (IBAction)Enter_pressed:(UIButton*)sender {
    // Check if the display is empty or not by checking its length
    if(self.myDisplay.text.length > 0){
        // if not empty get the value and store it as  string
        NSString *valueOnDisplay = self.myDisplay.text;
        
        // Call pushItem function from calBrain and
        //push the value to the array
        [self.myModel pushItem:(valueOnDisplay.doubleValue)];
        
        // clear the display
        self.myDisplay.text = @"";
    }

    
  
}
- (IBAction)Clear_pressed:(UIButton *)sender {
    // check if the display is empty or not
    if(self.myDisplay.text.length >0){
    // clear what in the display when clicked
        self.myDisplay.text = @"";
    }
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    // change the boolean value to yes so we can enter a new value
    self.isNewNumber = YES;
}



@end
