//
//  Store.m
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-09-29.
//

#import "Store.h"
#import "Ticket.h"
#import "Purchases.h"

@interface Store()
@property (nonatomic) NSMutableArray *listOfTickets;
// @property (nonatomic) NSMutableArray *transactions;


@end

@implementation Store

// List of Ticket objects
-(NSMutableArray*) listOfTickets {
    if (_listOfTickets == nil)
        _listOfTickets = [[NSMutableArray alloc]initWithObjects:
                          [[Ticket alloc]initWithTitle:@"Balcony Level" andQty:50 andPrice:75],
                          [[Ticket alloc]initWithTitle:@"Lower Level" andQty:30 andPrice:300],
                          [[Ticket alloc]initWithTitle:@"Courtside Level" andQty:10 andPrice:1620],
                          nil];
    return _listOfTickets;
}

// To be filled with objects of Purchases
-(NSMutableArray*) transactions {
    if (_transactions == nil)
        _transactions = [[NSMutableArray alloc]init];
    return _transactions;
}


-(NSString *) ticketInfoToString:(NSInteger) row {
    Ticket *selected = [self.listOfTickets objectAtIndex:row];
    return [NSString stringWithFormat:@"%@  Qty:%d  $%.2f", selected.title, selected.qty, selected.price];
}

//-(id)ticketInfoAtRow:(NSInteger)row {
//    Ticket *selected = [self.listOfTickets objectAtIndex:row];
//    NSString *ticketLevel = selected.title;
//    int quantity = selected.qty;
//    float price = selected.price;
//
//    return [NSString stringWithFormat:@"%@ Qty:%d Price:%.2f$", ticketLevel, quantity, price];
//}

-(int)ticketStockAtRow:(NSInteger)row {
    Ticket *selected = [self.listOfTickets objectAtIndex:row];
    int quantity = selected.qty;
    return quantity;
}

-(double)ticketPriceAtRow:(NSInteger)row {
    Ticket *selected = [self.listOfTickets objectAtIndex:row];
    float price = selected.price;
    return price;
}

-(id)ticketLevelAtRow:(int)row {
    Ticket *selected = [self.listOfTickets objectAtIndex:row];
    NSString *ticketLevel = selected.title;
    return ticketLevel;
}

-(double)finalSalePriceforTickets:(NSInteger)chosenQty andForRow:(int) row{
    Ticket *ticketLevel = [self.listOfTickets objectAtIndex:row];
    int ticketStock = ticketLevel.qty;
    if(chosenQty <= ticketStock) { // change ticketLevel to be inventory stock
        return (chosenQty * ticketLevel.price);
    }
    else {
        return -1;
    }
}

-(void)reduceQtyAfterPurchase:(int)QtyToReducyBy TicketLevel:(int) row {
    Ticket *selected = [self.listOfTickets objectAtIndex:row];
    if (QtyToReducyBy <= selected.qty && QtyToReducyBy > 0) {
        //NSLog(@"Quantity Before Purchase: %d", selected.qty);
        selected.qty = selected.qty - QtyToReducyBy; // Changed the quantity available for the ticket
        //NSLog(@"Quantity After Purchase: %d", selected.qty);
        [self.listOfTickets replaceObjectAtIndex:row withObject:selected]; // Replaced the object in stock to change it's quantity in stock
        
        // Debugging to check why quantity isn't updating after purchase
//        for (int i = 0; i < self.listOfTickets.count; i++) {
//            Ticket *ticketLevel = [self.listOfTickets objectAtIndex:i];
//
//            NSLog(@"Ticket %@ row %d after purchase has stock of %d", ticketLevel.title, i, ticketLevel.qty);
//        }
        
        NSDate *date = [NSDate date];
        Purchases *purchase = [[Purchases alloc]initWithTitle:selected.title andQty:QtyToReducyBy andPrice:(QtyToReducyBy * selected.price) andDate:date];
        [self.transactions addObject:purchase]; // adding the purchase to the history of transactions array
        NSLog(@"# of transactions in NSMutableArray %d", (int)self.transactions.count);
    }
}

-(NSString *)TicketLevelPurchasedAtRow:(int)row {
    Purchases *purchase = [self.transactions objectAtIndex:row];
    
    return [NSString stringWithFormat:@"%@", purchase.title];
}

-(NSString *)TicketQtyPurchasedAtRow:(int)row {
    Purchases *purchase = [self.transactions objectAtIndex:row];
    
    return [NSString stringWithFormat:@"%d", (int)purchase.qty];
}

-(id)TicketItemPurchasedAtRow:(int)row {
    Ticket *ticket = [self.listOfTickets objectAtIndex:row];    
    return ticket;
}

-(id)TransactionItemAtRow:(int)row {
    Purchases *purchase = [self.transactions objectAtIndex:row];
    return purchase;
}

@end
