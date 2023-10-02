//
//  Purchases.m
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-09-29.
//

#import "Purchases.h"
#import "Ticket.h"
#import "Store.h"

@implementation Purchases
- (instancetype)initWithTitle:(NSString *) title  andQty:(int) qty andPrice:(double) price andDate:(NSDate*)date{
    self = [super init];
        if (self) {
            self.title = title;
            self.qty = qty;
            self.price = price;
            self.purchaseDateAndTime = date;
    }
    return self;
}

@end
