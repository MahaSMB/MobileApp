//
//  ManagerViewController.m
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-10-01.
//

#import "ManagerViewController.h"
#import "PurchasesViewController.h"
#import "Store.h"
#import "Ticket.h"
#import "Purchases.h"
#import "ViewController.h"
#import "ResetViewController.h"

@interface ManagerViewController ()
@property (weak, nonatomic) IBOutlet UILabel *managerPanelTitle;

@end

@implementation ManagerViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.managerPanelTitle.text = self.managerMenuTitleText;
    // Do any additional setup after loading the view.
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    
    
    if([segue.identifier isEqualToString:@"Transactions"]){
        PurchasesViewController *pvc = (PurchasesViewController *)segue.destinationViewController;
        pvc.purchaseTransactionHistoryMenuTitleText = @"Purchase Transaction History";
        pvc.transactionHistory = self.transactionHistory;
        
    }
    else if ([segue.identifier isEqualToString:@"Reset"]){
        ResetViewController *rvc = (ResetViewController *)segue.destinationViewController;
        
        rvc.resetMenuTitleText = @"Reset Menu";

        
    }
    else {
        
    }
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
