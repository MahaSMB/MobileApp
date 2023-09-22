//
//  CalBrain.m
//  Sep21iosLab1
//
//  Created by Nazia Ahmed on 2023-09-21.
//
#import "CalBrain.h"

@interface CalBrain ()
@property (nonatomic) NSMutableArray *items;
@end


//private property of items : nsmutableArray
@implementation CalBrain

//- (instancetype)init {
//    self = [super init];
//    if (self) {
//        _items = [NSMutableArray array];
//    }
//    return self;
//}

-(NSMutableArray*)items{
 
    if (_items == nil){
        _items =  [[NSMutableArray alloc]init];
    }
        return _items;
}


-(void)pushItem : (double)number{
    //add this number to my items list
    [self.items addObject:@(number)];
}
-(double)calculate:(NSString *)opr{
    //check what opr is + or - * /
    //if opr == +
    //return pop + pop
    if ([opr isEqualTo:@"+"]){
        return [self popItem] + [self popItem];
    }
    else if([opr isEqualTo:@"-"]){
        return [self popItem] + [self popItem];
    }
    else if([opr isEqualTo:@"*"]){
        return [self popItem] + [self popItem];
    }
    else if ([opr isEqualTo:@"/"]){
        double num1 = [self popItem];
        double num2 = [self popItem];
        if (num2 == 0){
            NSLog(@"Cannot divide by zero. ");
            return NAN;
        }
        return num1/num2;
    }
    else {
        NSLog(@"Error");
    }
    return NAN;
}

-(double)popItem{
    //remove and return the last item of the array
    if([self.items count] == 0){ 
        NSLog(@"Stack does not have anything");
        return NAN;
    }
      
    double popItem = [[self.items lastObject]doubleValue];
    [self.items removeLastObject];
    return popItem;
}

@end













