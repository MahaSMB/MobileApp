//
//  Item.m
//  iOS-Lab3
//
//  Created by Maha Basheikh on 9/28/23.
//

#import "Item.h"
@interface Item()

@end

@implementation Item

- (instancetype)initWithTitle:(NSString *) title  qty:(int) qty price:(float) price{
    self = [super init];
        if (self) {
            self.title = title;
            self.qty = qty;
            self.price = price;
    }
    return self;
}

@end
