//
//  RMTeamWindowController.m
//  Rome
//
//  Created by Riddhiman Das on 6/29/14.
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
        NSLog(@"We\'re initialized");
    }
    return self;
}

- (void)windowDidLoad
{
    [super windowDidLoad];
            NSLog(@"We\'re Loaded");
    
    // Implement this method to handle any initialization after your window controller's window has been loaded from its nib file.
}

@end
