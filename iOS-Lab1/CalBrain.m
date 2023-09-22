//
//  CalBrain.m
//  Sep21_Calculator
//
//  Created by mays on 2023-09-21.
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
    //add this number to my items list
   
    [self.items addObject:@(item)];
   
}
// calculate function
-(double)calculate:(NSString *)opr{
    
  
  
    //
    //check what opr is + or - * /
    // if oporatoer is + symbol then add two numbers
    if([opr isEqualToString:@"+"]){
         
        return [self popItem] +[self popItem];
        // if oporatoer is -  symbol then subtract two numbers
    }else if ([opr isEqualToString:@"-"]){
        return [self popItem] -[self popItem];
        // if oporatoer is *  symbol then multiply two numbers
    }else if ([opr isEqualToString:@"*"]){
        return [self popItem] * [self popItem];
        // if oporatoer is / symbol then divide two numbers
    }else if ([opr isEqualToString:@"/"]){
        // Store the last value poped
        double num2 = [self popItem];
        // Store the first value poped
        double num1 = [self popItem];
        if(num2 ==0){
            // print not allowed to divide
            NSLog(@"can not divied by zero");
            // return NAN
            return  NAN;
        }
        // return the division value
        return num1 / num2;
    }else{
        // print in case invalid oprator then return NAN
        NSLog(@"Error: Invalid operator.");
        
    }
    return NAN;
}


-(double)popItem{
    //remove and return the last item of the array
   // Check
    if([self.items count] > 0){
        // Store the last last item from the array in var lastItem
        double lastItem =[[self.items lastObject] doubleValue];
        // Remove the last item for the array
        [self.items removeLastObject];
        return  lastItem;
    }else{
        return  NAN;
    }
    
}



@end
