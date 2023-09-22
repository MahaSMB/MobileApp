//
//  CalBrain.h
//  Sep21_Calculator
//
//  Created by mays on 2023-09-21.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface CalBrain : NSObject
// declare function to push number  to array
-(void)pushItem :(double)number;
// declare function to calcalate based on the oprator
-(double)calculate:(NSString*)opr;

@end

NS_ASSUME_NONNULL_END
