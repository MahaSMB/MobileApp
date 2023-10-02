//
//  Ticket.m
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-09-29.
//

#import "Ticket.h"
@interface Ticket()
@end
@implementation Ticket
- (instancetype)initWithTitle:(NSString *) title  andQty:(int) qty andPrice:(double) price{
    self = [super init];
        if (self) {
            self.title = title;
            self.qty = qty;
            self.price = price;
    }
    return self;
}


@end
