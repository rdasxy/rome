//
//  RMTeamWindowController.m
//  Rome
//
//  Created by Tam Tran on 7/16/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import "RMTeamWindowController.h"

@interface RMTeamWindowController ()

@end

@implementation RMTeamWindowController


- (id)initWithWindow:(NSWindow *)window
{
    self = [super initWithWindow:window];
    if (self) {
        // Initialization code here.
    }
    return self;
}

- (void)windowDidLoad
{
    [super windowDidLoad];
    
    // Implement this method to handle any initialization after your window controller's window has been loaded from its nib file.
    tableData = [NSArray arrayWithObjects:@"Egg Benedict", @"Mushroom Risotto", @"Full Breakfast", @"Hamburger", @"Ham and Egg Sandwich", @"Creme Brelee", @"White Chocolate Donut", @"Starbucks Coffee", @"Vegetable Curry", @"Instant Noodle with Egg", @"Noodle with BBQ Pork", @"Japanese Noodle with Pork", @"Green Tea", @"Thai Shrimp Cake", @"Angry Birds Cake", @"Ham and Cheese Panini", nil];
 
   
    

    
}

- (IBAction)add_data:(id)sender {

    NSLog(@"Array Count: %lu", [tableData count]);
    
    
    
  

    
    
}
@end
