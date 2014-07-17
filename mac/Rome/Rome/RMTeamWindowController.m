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
        [window orderFront:nil];
    }
    return self;
}

- (void)windowDidLoad
{
    [super windowDidLoad];
    
    // Implement this method to handle any initialization after your window controller's window has been loaded from its nib file.
}

@end
