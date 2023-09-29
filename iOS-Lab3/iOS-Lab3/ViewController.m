//
//  ViewController.m
//  iOS-Lab3
//
//  Created by Maha Basheikh on 9/28/23.
//

#import "ViewController.h"
#import "Store.h"
#import "Item.h"

@interface ViewController ()
// @interface ViewController() <UIPickerViewDelegate, UIPickerViewDataSource> Already connected through Connections Inspector
@property (weak, nonatomic) IBOutlet UILabel *ticketType;
@property (weak, nonatomic) IBOutlet UILabel *quantity;
@property (weak, nonatomic) IBOutlet UILabel *totalCost;
@property (weak, nonatomic) IBOutlet UILabel *purchaseSuccessful;
@property (weak, nonatomic) IBOutlet UIPickerView *myPickerView;
@property (nonatomic) Store *Model;
@property bool isNewNumber;
@end

@implementation ViewController
-(Store*)Model {
    if(_Model == nil) {
        _Model = [[Store alloc]init];
    }
    return _Model;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    self.myPickerView.dataSource = self;
    // Do any additional setup after loading the view.
}

- (NSInteger)numberOfComponenetsInPickerView:(UIPickerView *) pickerView{
    return 1;
}

- (NSInteger)pickerView:(UIPickerView *) pickerView numberOfRowsInComponent:(NSInteger)component{
    return self.Model.listOfTickets.count;
}

- (NSString*) pickerView:(UIPickerView *) pickerView
            titleForROW:(NSInteger)row
           forComponent:(NSInteger)component{
    return @"a";
}

- (IBAction)digitPressed:(UIButton*)sender {
    
}

- (IBAction)buyPressed:(UIButton*)sender {
    self.isNewNumber = YES;
}

- (IBAction)enterPressed:(UIButton *)sender {
}



@end
