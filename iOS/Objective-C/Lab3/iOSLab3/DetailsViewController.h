//
//  DetailsViewController.h
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-10-02.
//

#import <UIKit/UIKit.h>
#import "PurchasesViewController.h"
#import "Store.h"
#import "Ticket.h"
#import "Purchases.h"
#import "ViewController.h"
#import "ResetViewController.h"

NS_ASSUME_NONNULL_BEGIN

@interface DetailsViewController : UIViewController
@property (nonatomic) NSString *detailsMenuTitleText;
@property (nonatomic) NSMutableArray *transactionHistory;
@property (nonatomic) Purchases *purchaseTransaction;
@end

NS_ASSUME_NONNULL_END
