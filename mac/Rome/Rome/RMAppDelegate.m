//
//  RMAppDelegate.m
//  Rome
//
//  Created by Riddhiman Das on 6/29/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import "RMAppDelegate.h"


@implementation RMAppDelegate

- (void)applicationDidFinishLaunching:(NSNotification *)aNotification
{
    // Insert code here to initialize your application
}

-(void)awakeFromNib{
    statusItem =  [[NSStatusBar systemStatusBar] statusItemWithLength:NSVariableStatusItemLength];
    [statusItem setMenu:menu];
    [statusItem setHighlightMode:YES];
    [statusItem setImage: [NSImage imageNamed:@"icon_offline"]];
}

- (IBAction)signIn:(id)sender {
    // TODO: User Validation
    [statusItem setImage: [NSImage imageNamed:@"icon_available"]];
    [menu removeItemAtIndex:0];
    [menu removeItemAtIndex:0];
    
    [menu addItemWithTitle:@"Show Team"  action:@selector(showTeam:) keyEquivalent:@""];
    [menu addItemWithTitle:@"Available"  action:@selector(setAvailable) keyEquivalent:@""];
    [menu addItemWithTitle:@"Busy"  action:@selector(setBusy) keyEquivalent:@""];
    [menu addItemWithTitle:@"Quit"  action:@selector(quit:) keyEquivalent:@""];
}

- (IBAction)showTeam:(id)sender{
    twc = [[RMTeamWindowController alloc] initWithWindowNibName:@"RMTeamWindowController"];
    [twc showWindow:nil];
}

- (void)setAvailable{
//    [statusItem setImage: [NSImage imageNamed:@"icon_available"]];
}

- (void)setBusy{
//    [statusItem setImage: [NSImage imageNamed:@"icon_busy"]];
}

- (IBAction)quit:(id)sender {
    [NSApp terminate:nil];
}

@end
