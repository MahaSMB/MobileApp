//
//  CalBrain.h
//  Sep21iosLab1
//
//  Created by Nazia Ahmed on 2023-09-21.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface CalBrain : NSObject

// Function 1: Push Item to the array.
-(void)pushItem : (double)number;


-(double)calculate : (NSString*)opr;
 
@end

NS_ASSUME_NONNULL_END
