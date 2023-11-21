//
//  Item.h
//  iOS-Lab3
//
//  Created by Maha Basheikh on 9/28/23.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Item : NSObject
@property (nonatomic) NSString *title;
@property (nonatomic) int qty;
@property (nonatomic) float price;
-(instancetype)initWithTitle:(NSString *) title  qty:(int) qty price:(float) price;
@end

NS_ASSUME_NONNULL_END
