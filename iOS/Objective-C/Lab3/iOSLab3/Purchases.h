//
//  Purchases.h
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-09-29.
//

#import <Foundation/Foundation.h>
#import "Ticket.h"
#import "Store.h"

NS_ASSUME_NONNULL_BEGIN

@interface Purchases : NSObject
@property (nonatomic) NSString *title;
@property (nonatomic) int qty;
@property (nonatomic) double price;
@property (nonatomic) NSDate *purchaseDateAndTime;
- (instancetype)initWithTitle:(NSString *) title  andQty:(int) qty andPrice:(double) price andDate:(NSDate*)date;
@end

NS_ASSUME_NONNULL_END
