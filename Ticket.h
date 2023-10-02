//
//  Ticket.h
//  iOSLab3
//
//  Created by Maha Basheikh on 2023-09-29.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Ticket : NSObject
@property (nonatomic) NSString *title;
@property (nonatomic) int qty;
@property (nonatomic) double price;
-(instancetype)initWithTitle:(NSString *) title  andQty:(int) qty andPrice:(double) price;
//-(instancetype)init:(NSString *) title  qty:(int) qty price:(float) price;
@end

NS_ASSUME_NONNULL_END
