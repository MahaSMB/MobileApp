//
//  ManagerViewController.h
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-10-01.
//

#import <UIKit/UIKit.h>
#import "PurchasesViewController.h"
#import "Store.h"
#import "Ticket.h"
#import "Purchases.h"
#import "ViewController.h"
#import "ResetViewController.h"


NS_ASSUME_NONNULL_BEGIN

@interface ManagerViewController : UIViewController
@property (nonatomic) NSString *managerMenuTitleText;
@property (nonatomic) NSMutableArray *transactionHistory;
@property (nonatomic) NSMutableArray *ticketStock;
@end

NS_ASSUME_NONNULL_END
