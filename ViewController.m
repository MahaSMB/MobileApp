//
//  ViewController.m
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-09-29.
//

#import "ViewController.h"
#import "Ticket.h"
#import "Store.h"
#import "Purchases.h"
#import "ManagerViewController.h"

//@interface ViewController ()
@interface ViewController() <UIPickerViewDelegate, UIPickerViewDataSource>
@property (weak, nonatomic) IBOutlet UILabel *quantityLbl;
@property (weak, nonatomic) IBOutlet UILabel *priceLbl;
@property (weak, nonatomic) IBOutlet UILabel *purchaseConfirmationLbl;
@property (weak, nonatomic) IBOutlet UILabel *ticketLevelLbl;
@property (weak, nonatomic) IBOutlet UIPickerView *pickerView;
@property (nonatomic) Store *storeItem;
@property (nonatomic) Ticket *ticketItem; // not currently using


@property bool isNewNumber;
@property (nonatomic) int chosenRow;
@property (nonatomic) BOOL nextNumber; // not currently using
@property (nonatomic) double finalPrice;
@property (nonatomic) NSMutableArray *inventoryAfterPurchase; // not currently using
@property BOOL isInStock;

@end

@implementation ViewController
-(Store *)storeItem {
    if(_storeItem == nil) {
        _storeItem = [[Store alloc]init];
    }
    return _storeItem;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    self.pickerView.dataSource = self;
    self.pickerView.delegate = self;
    self.isNewNumber = YES;
    //[self.pickerView reloadAllComponents];
    // Do any additional setup after loading the view.
}

-(void)viewDidAppear:(BOOL)animated {
    self.chosenRow = -1;
    //self.nextNumber = YES;
    //self.finalPrice = 0.00;
    //self.ticketLevelLbl.text = @"";
    //self.quantityLbl.text = @"";
    //self.priceLbl.text = @"";
    //self.purchaseConfirmationLbl.text = @"";
    [self.pickerView reloadAllComponents]; // to reload and update stock
    
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

// Trying to change the font size for the pickerview rows. Unsuccessful
//- (UIView *)pickerView:(UIPickerView *)pickerView
//            viewForRow:(NSInteger)row
//          forComponent:(NSInteger)component
//           reusingView:(UIView *)view {
//    UILabel* tView = (UILabel*)view;
//
//    tView = [[UILabel alloc]init];
//    //[tView.NSTextAlignmentLeft = 0];
//    //[tView setBackgroundColor:[UIColor clearColor]];
//    [tView setFont:[UIFont boldSystemFontOfSize:15]];
//    tView.adjustsFontSizeToFitWidth = YES;
//
//
//    [tView setText:[self.storeItem.listOfTickets objectAtIndex:row]];
//
//    return tView;
//}

//- (NSInteger)selectedRowInComponent:(NSInteger)component;

- (IBAction)buyPressed:(UIButton *)sender {
    Store *storeObject = [[Store alloc]init]; // creating a store object to access the ticketStockAtRow  method
    int chosenQuantity = [self.quantityLbl.text intValue]; // leaving comment for clarity. Not using variable to save memory.
    double ticketPrice = [storeObject ticketPriceAtRow:self.chosenRow];
    //int stock = [storeObject ticketStockAtRow:self.chosenRow]; // leaving comment for clairty. Not using variable to save memory.
    //NSDate *UTIME_NOW;
    // if the chosen quantity by the user is less than or equal to the tickets in stock for that ticket level (row)
    //if (chosenQuantity <= [storeObject ticketStockAtRow:self.chosenRow]) {
    if (self.isInStock) {
        NSString *ticketLevel = [storeObject ticketLevelAtRow:self.chosenRow];
        NSDate *date = [NSDate date];
        Purchases *purchase = [[Purchases alloc]initWithTitle:ticketLevel andQty:chosenQuantity andPrice:ticketPrice andDate:date];
        //self.isInStock = YES;
        
        int ticketStockBefore = [storeObject ticketStockAtRow:self.chosenRow];
        NSLog(@"Quantity Before Purchase: %d", ticketStockBefore); // Debugging
        
        // Adjust stock at purchase
        [self.storeItem reduceQtyAfterPurchase:chosenQuantity TicketLevel:self.chosenRow];
        
        //self.storeItem = storeObject;
        [self.pickerView reloadAllComponents]; // reload the pickerview after updating inventory
        
        
        int ticketStockAfter = [storeObject ticketStockAtRow:self.chosenRow];
        NSLog(@"Quantity After Purchase: %d", ticketStockAfter); // Debugging

        
        NSLog(@"%@", [NSString stringWithFormat:@"%@ tickets were purchased at a quantity of %d for $%.2f at %@", purchase.title, purchase.qty, (purchase.price * purchase.qty), purchase.purchaseDateAndTime]);
        NSLog(@"Quantity remaining for %@ tickets is %d .", purchase.title, [storeObject ticketStockAtRow:self.chosenRow]);
        
        // Debugging
        for (int i = 0; i < storeObject.listOfTickets.count; i++) {
            Ticket *ticket = [storeObject.listOfTickets objectAtIndex:i];
            
            NSLog(@"Ticket %@ row %d after purchase has stock of %d", ticket.title, i, ticket.qty);
        }
        
        //NSLog(@"ChosenRow %d", self.chosenRow);
        self.purchaseConfirmationLbl.text = @"Purchase was successful!";
        
        // Clear labels values after purchase
        self.ticketLevelLbl.text = @"";
        self.quantityLbl.text = @"";
        self.priceLbl.text = @"";
        
    }
    else {
        //self.isInStock = NO;
        self.purchaseConfirmationLbl.text = @"Purchase failed ☹️";
        
        // Clear labels values after failed purchase
        self.ticketLevelLbl.text = @"";
        self.quantityLbl.text = @"";
        self.priceLbl.text = @"";
    }
    
    
    //self.isNewNumber = YES;
}

//-(void)updateListOfTickets: (NSMutableArray *) inventoryAfterPurchase {
//    Store *storeObject = [[Store alloc]init];
//    //storeObject.listOfTickets = self.inventoryAfterPurchase;
//    
//    //[self.listOfTickets replaceObjectAtIndex:row withObject:selected];
//    
//    for (int i = 0 ; i < storeObject.listOfTickets.count; i++) {
//        [storeObject.listOfTickets replaceObjectAtIndex:self.chosenRow withObject:selected];
//    }
//}

- (IBAction)digitPressed:(UIButton *)sender {
    if(self.isNewNumber) {
        self.quantityLbl.text = sender.titleLabel.text;
        self.isNewNumber = NO;
    }
    else {
        
        self.quantityLbl.text = [NSString stringWithFormat:@"%@%@", self.quantityLbl.text, sender.titleLabel.text];
    }
}

- (IBAction)enterPressed:(UIButton *)sender {
    // Check if the label is empty or not
    if(self.quantityLbl.text.length > 0) {
        // If the label isn't empty, get the value and store it as a string
        //NSString *quantityShown = self.quantityLbl.text;
        
        //store the value in the NSMutableArray of listOfTickets
        int quantity = [self.quantityLbl.text intValue]; 
        int selectedRow = (int)self.chosenRow;
        //[self.storeItem addObject
        Store *storeObject = [[Store alloc]init];
        // clear the label's display
        //self.quantityLbl.text = @"";
        self.finalPrice = [storeObject finalSalePriceforTickets:(quantity) andForRow:(selectedRow)];
        self.priceLbl.text = [NSString stringWithFormat:@"$%.2f",self.finalPrice];
        
        if (self.finalPrice != -1) {
            self.isInStock = YES;
            self.purchaseConfirmationLbl.text = @"Click Buy to finalize your purchase.";
        }
        else {
            self.isInStock = NO;
            self.purchaseConfirmationLbl.text = @"Not enough stock! Please try again.";
        }
    }
}

- (IBAction)clearPressed:(UIButton *)sender {
    // Check if quantity label is empty or not
    if(self.quantityLbl.text.length > 0) {
        // if quantity label isn't empty, clear it
        self.ticketLevelLbl.text = @"";
        self.quantityLbl.text = @"";
        self.priceLbl.text = @"";
    }
}

- (IBAction)managerPressed:(UIButton *)sender {
}

/*
 - (IBAction)buyPressed:(UIButton*)sender {
 self.isNewNumber = YES;
 }
 
 - (IBAction)managerPressed:(UIButton *)sender {
 }
 */

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    if([segue.identifier isEqualToString:@"Manager"]) {
        ManagerViewController *mvc = segue.destinationViewController;
        mvc.managerMenuTitleText = @"Manager Panel Menu";
        mvc.transactionHistory = self.storeItem.transactions;
        mvc.ticketStock = self.storeItem.listOfTickets;
    }
}

@end
