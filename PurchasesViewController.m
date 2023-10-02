//
//  PurchasesViewController.m
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-10-01.
//


#import "Store.h"
#import "Ticket.h"
#import "Purchases.h"
#import "ManagerViewController.h"
#import "ViewController.h"
#import "PurchasesViewController.h"
#import "DetailsViewController.h"
#import "ResetViewController.h"


// set up the protocol
@interface PurchasesViewController () <UITableViewDelegate, UITableViewDataSource>
@property (weak, nonatomic) IBOutlet UILabel *purchaseTransactionHistoryLabel;
@property (nonatomic) Store *purchasesStoreItem;
@property (nonatomic) Purchases *purchasesItem;
@property (nonatomic) int selectedRow;



@end

@implementation PurchasesViewController
-(NSMutableArray *) transactionHistory {
    if (_transactionHistory == nil){
        _transactionHistory = [[NSMutableArray alloc]init];
    }
    return _transactionHistory;
}

-(Purchases*) purchaseTransaction {
    if (_purchaseTransaction == nil)
        _purchaseTransaction = [[Purchases alloc]init];
    return _purchaseTransaction;
}

- (void)viewDidLoad {
    self.title = @"Home";
    [super viewDidLoad];
    self.purchaseTransactionHistoryLabel.text = self.purchaseTransactionHistoryMenuTitleText;
    
    // Do any additional setup after loading the view.
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    // return the number of of rows dependent on number of transactions in the purchase history
    return self.transactionHistory.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView
         cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    UITableViewCell *myCell = [tableView dequeueReusableCellWithIdentifier:@"cell" forIndexPath:indexPath];
    
    Purchases *transaction = [self.transactionHistory objectAtIndex:indexPath.row];
    myCell.textLabel.text = transaction.title;
    myCell.detailTextLabel.text = [NSString stringWithFormat:@"%d", transaction.qty];
        
    //NSLog(@"Purchase History Page: Purchases made for %@ tickets for a quantity of %@ .", myCell.textLabel.text, myCell.detailTextLabel.text);
        
    return myCell;
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    self.selectedRow = (int) indexPath.row;
    
    DetailsViewController *dvc = [self.storyboard instantiateViewControllerWithIdentifier:@"DetailsViewController"];
    dvc.purchaseTransaction = [self.transactionHistory objectAtIndex:self.selectedRow];
    
    [self presentViewController:dvc animated:YES completion:nil];
    
}

-(void)backClick {
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.

    if([segue.identifier isEqualToString:@"Details"]){
        DetailsViewController *dvc = segue.destinationViewController;
        dvc.detailsMenuTitleText = @"Purchase Transaction Details";
        dvc.transactionHistory = self.transactionHistory;
        dvc.purchaseTransaction = [self.transactionHistory objectAtIndex:self.selectedRow];
        
        
    }
}

// To save for later use
// To delete a row from table view
//-(void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
//
//}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
