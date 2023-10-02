//
//  DetailsViewController.m
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-10-02.
//

#import "DetailsViewController.h"
#import "PurchasesViewController.h"

#import "Store.h"
#import "Ticket.h"
#import "Purchases.h"
#import "ViewController.h"
#import "ResetViewController.h"

@interface DetailsViewController ()
@property (weak, nonatomic) IBOutlet UILabel *ticketLevelLabel;
@property (weak, nonatomic) IBOutlet UILabel *ticketQtyLabel;
@property (weak, nonatomic) IBOutlet UILabel *purchasePriceLabel;
@property (weak, nonatomic) IBOutlet UILabel *purchaseDateLabel;

@end

@implementation DetailsViewController

-(NSMutableArray *) transactionHistory {
    if (_transactionHistory == nil){
        _transactionHistory = [[NSMutableArray alloc]init];
    }
    return _transactionHistory;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    self.ticketLevelLabel.text = self.purchaseTransaction.title;
    self.ticketQtyLabel.text = [NSString stringWithFormat:@"%d", self.purchaseTransaction.qty];
    self.purchasePriceLabel.text = [NSString stringWithFormat:@"%.2f", self.purchaseTransaction.price];
    self.purchaseDateLabel.text = [NSString stringWithFormat:@"%@", self.purchaseTransaction.purchaseDateAndTime];
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
