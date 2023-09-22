//
//  ViewController.m
//  Calculator_Sep22_Mays
//
//  Created by mays on 2023-09-20.
//

#import "ViewController.h"
#import "CalBrain.h" // import the calBrian implementation

@interface ViewController ()
// create a display object
@property(weak,nonatomic)IBOutlet UILabel *myDisplay;
// create a boolean value
@property bool isNewNumber;
// create calbrain object mymodel
@property (nonatomic)CalBrain * myModel;
@end

@implementation ViewController

//laze loading when need it
-(CalBrain*)myModel{

if (_myModel == nil){
    // allocate memory for mymodel obj

    _myModel =  [[CalBrain alloc]init];

}
    return _myModel;
}
// create a button which shows the button value in the display when pressed
- (IBAction)DigitPressed:(UIButton *)sender {
    // check if new number display it
    if(self.isNewNumber){
        // display to the number
        self.myDisplay.text=sender.titleLabel.text;
        // Se the boolen var to no
        self.isNewNumber = NO;
    }else{
        // if not new number assing string value to what in the display
        NSString *valueOnDisplay=self.myDisplay.text;
        // assing string to the new digit entered
        NSString *newDigit = sender.titleLabel.text;
        // save both nubmeres in string foramat
        NSString *newNumber = [NSString stringWithFormat:@"%@%@",valueOnDisplay,newDigit];
        // display the new concatanate value
        self.myDisplay.text = newNumber;
    }
}

// Function to calculate the result based on the oprator
- (IBAction)Oprator_pressed:(UIButton*)sender {
//  Declare and intialize string to get the oprator sign from based on the label
    NSString *newSign = sender.titleLabel.text;
    //Call the calculate function and send parameter newSign and
    //store the double var result.
     double result = [self.myModel calculate:newSign];
  // change the format to string and display it
    self.myDisplay.text = [NSString stringWithFormat:@"%0.2f",result];
    // change the bool to yes so we clear previous result and enter new one
    self.isNewNumber = YES;
    

   
}
// Function used to push values to array and clear the display
- (IBAction)Enter_pressed:(UIButton*)sender {
    // Check if the display empty or not by check the length
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
    // change the boolean value to yes so we can enter new value
    self.isNewNumber = YES;
}



@end
