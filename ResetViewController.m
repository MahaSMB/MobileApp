//
//  ResetViewController.m
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-10-02.
//

#import "ResetViewController.h"
#import "DetailsViewController.h"
#import "PurchasesViewController.h"
#import "ManagerViewController.h"

#import "Store.h"
#import "Ticket.h"
#import "Purchases.h"
#import "ViewController.h"

@interface ResetViewController () <UIPickerViewDelegate, UIPickerViewDataSource>
@property (weak, nonatomic) IBOutlet UILabel *resetMenuTitleLabel;
@property (weak, nonatomic) IBOutlet UILabel *restockQtyLabel;
@property (weak, nonatomic) IBOutlet UIPickerView *pickerView;
@property (nonatomic) NSMutableArray *ticketStock;
@end

@implementation ResetViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    self.resetMenuTitleLabel.text = self.resetMenuTitleText;
}

// Set number of components / columns in pickerview
-(NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView {
    return 1;
}

// dynamically set number of rows in pickerview
- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component {
    return self.storeItem.listOfTickets.count;
}

// Get the list of tickets from the Store class's storeItem and display them per each row of the pickerview
-(NSString *)pickerView:(UIPickerView *)pickerView
            titleForRow:(NSInteger)row
           forComponent:(NSInteger)component{
    //return @"a";
    return [self.storeItem ticketInfoToString:row];
}

-(void) pickerView: (UIPickerView *) pickerView
            didSelectRow:(NSInteger)row
             inComponent:(NSInteger)component {
    self.ticketLevelLbl.text = [self.storeItem ticketLevelAtRow:row];
    self.chosenRow = (int)row;
    //self.quantity.text = [self.storeItem ticketQtyAtRow:row];
    //self.price.text = [self.storeItem ticketPriceAtRow:row];
    
    
    if([self.quantityLbl.text isEqualToString:@""]) {
        self.purchaseConfirmationLbl.text = [NSString stringWithFormat:@"%@", @"Please select quantity"];
    }
}


- (IBAction)cancelButton:(UIButton *)sender {
}
- (IBAction)OKButton:(UIButton *)sender {
}



/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
