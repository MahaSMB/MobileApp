//
//  CalBrain.h
//  Sep21_Calculator
//
//  Created by Maha Basheikh on 2023-09-21.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface CalBrain : NSObject
// declared function to push number  to NSMutableArray
-(void)pushItem :(double)number;

// declared function to calculate based on the operator
-(double)calculate:(NSString*)opr;

@end

NS_ASSUME_NONNULL_END
