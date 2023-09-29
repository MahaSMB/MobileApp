//
//  main.m
//  Sep21_Calculator
//
//  Created by mays on 2023-09-20.
//

#import <Foundation/Foundation.h>
#import "CalBrain.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // create CalBrain obj called myCal
      
        CalBrain *myCal = [[CalBrain alloc]init];
        //Call the function pushItem and send the vuale
        [myCal pushItem:4];
        // Call eh function pushItem and send value
        [myCal pushItem:2];
        
        // Call the function calculate with oprator + to calculate two double 
        //values and store the reutne rvalue form the calculate in the double var result 
    
        double result = [myCal calculate:@"/"];
        // print the result
        NSLog(@"The result is %f",result);
       
    }
    return 0;
}
