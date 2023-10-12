//
//  CalBrain.m
//  
//
//  Created by Maha Basheikh on 2023-09-21.
//

#import "CalBrain.h" // added the class header file



@interface CalBrain()

//private property of items : nsmutableArray
@property(nonatomic,strong)NSMutableArray *items;
@end
@implementation CalBrain
// lazy load
-(NSMutableArray*)items{
    // if intem index not empty
    if (_items == nil){

        _items =  [[NSMutableArray alloc]init];
    }
        return _items;
}

-(void)pushItem:(double)item{
    //added this number to my items list
    [self.items addObject:@(item)];
   
}
// calculate the function
-(double)calculate:(NSString *)opr{
    
    //check what opr is +, -, *, or /
    
    if([opr isEqualToString:@"+"]){
        // if operator is + symbol then add two numbers
        return [self popItem] + [self popItem];
        // if operator is -  symbol then subtract two numbers
    }
    else if ([opr isEqualToString:@"-"]){
        return [self popItem] - [self popItem];
        // if operator is *  symbol then multiply two numbers
    }
    else if ([opr isEqualToString:@"*"]){
        return [self popItem] * [self popItem];
        // if operator is / symbol then divide two numbers
    }
    else if ([opr isEqualToString:@"/"]){
        // Store the last value popped
        double num2 = [self popItem];
        
        // Store the first value popped
        double num1 = [self popItem];
        if(num2 == 0){
            // print not allowed to divide by 0
            NSLog(@"can not divied by zero");
            
            // return NAN if user tried to divide by 0
            return  NAN;
        }
        // else return the division value
        return num1 / num2;
    }else{
        // print in case invalid operator then return NAN
        NSLog(@"Error: Invalid operator.");
        
    }
    return NAN;
}


-(double)popItem{
    //remove and return the last item of the array
   // Check
    if([self.items count] > 0){
        // Store the last item from the array in the variable lastItem
        double lastItem =[[self.items lastObject] doubleValue];
        
        // Remove the last item from the array
        [self.items removeLastObject];
        return  lastItem;
    }
    else{
        return  NAN; // if there are no items in the array, return NAN
    }
    
}

@end
