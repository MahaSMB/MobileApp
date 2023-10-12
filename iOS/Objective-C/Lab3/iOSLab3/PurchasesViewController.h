//
//  PurchasesViewController.h
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-10-01.
//

#import <UIKit/UIKit.h>
#import "PurchasesViewController.h"
#import "Store.h"
#import "Ticket.h"
#import "Purchases.h"
#import "ManagerViewController.h"
#import "ViewController.h"
#import "DetailsViewController.h"
#import "ResetViewController.h"




NS_ASSUME_NONNULL_BEGIN

@interface PurchasesViewController : UIViewController
@property (nonatomic) NSString *purchaseTransactionHistoryMenuTitleText;
@property (nonatomic) Store *transactionHistoryStoreObject;
@property (nonatomic) NSMutableArray *transactionHistory;
@property (nonatomic) Purchases *purchaseTransaction;
@end

NS_ASSUME_NONNULL_END
