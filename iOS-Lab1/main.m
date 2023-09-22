//
//  main.m
//  Sep21iosLab1
//
//  Created by Nazia Ahmed on 2023-09-21.
//

#import <Foundation/Foundation.h>
#import "CalBrain.h"


int main(int argc, const char * argv[]) {
    @autoreleasepool {
        CalBrain *myCal = [[CalBrain alloc]init];
        
        [myCal pushItem:0];
        [myCal pushItem:100];
        
        double result = [myCal calculate:@"/"];
        
        NSLog(@"result is %f",result);
        
    }
    return 0;
}
