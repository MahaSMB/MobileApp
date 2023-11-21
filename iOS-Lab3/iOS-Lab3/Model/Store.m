//
//  Store.m
//  iOS-Lab3
//
//  Created by Maha Basheikh on 9/28/23.
//

#import "Store.h"
#import "Item.h"

@interface Store()

@end

@implementation Store
-(NSMutableArray*) listOfTickets {
    if (_listOfTickets == nil){
        _listOfTickets = [[NSMutableArray alloc]initWithObjects:
                          [[Item alloc]initWithTitle:@"Balcony Level Ticket" qty:6 price:2300.00],
        [[Item alloc]initWithTitle:@"Lower Level Ticket" qty:12 price:2300.00], [[Item alloc]initWithTitle:@"Courtside Level Ticket" qty:12 price:2300.00], nil];
    }
    
    return _listOfTickets;
}

// Calculate method

@end
