//
//  Store.h
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-09-29.
//

#import <Foundation/Foundation.h>
#import "Ticket.h"
#import "Purchases.h"

NS_ASSUME_NONNULL_BEGIN

@interface Store : NSObject
@property (nonatomic) double finalPriceForTickets;
@property (nonatomic) NSString *ticketLevelAtRow;
@property (nonatomic) int ticketStockAtRow;
@property (nonatomic) double ticketPriceAtRow;
@property (nonatomic) NSMutableArray *transactions;
-(NSMutableArray*) listOfTickets;
-(NSString *) ticketInfoToString:(NSInteger) row;
-(int)ticketStockAtRow:(NSInteger)row;
-(double)ticketPriceAtRow:(NSInteger)row;
-(id)ticketLevelAtRow:(int)row;
-(double)finalSalePriceforTickets: (NSInteger)chosenQty andForRow:(int) row;
-(void)reduceQtyAfterPurchase:(int)QtyToReducyBy TicketLevel:(int) row;
-(NSString *)TicketLevelPurchasedAtRow:(int)row;
-(NSString *)TicketQtyPurchasedAtRow:(int)row;
-(id)TicketItemPurchasedAtRow:(int)row;
-(id)TransactionItemAtRow:(int)row;
-(NSMutableArray*) transactions;
@end

NS_ASSUME_NONNULL_END
