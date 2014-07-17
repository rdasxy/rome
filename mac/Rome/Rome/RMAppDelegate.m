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

- (void)awakeFromNib{
    statusItem =  [[NSStatusBar systemStatusBar] statusItemWithLength:NSVariableStatusItemLength];
    [statusItem setMenu:menu];
    [statusItem setHighlightMode:YES];
    if ([[RMContext getCurrentUser] userID] !=0) {
        NSLog(@"Already logged in");
            [statusItem setImage: [NSImage imageNamed:@"icon_available"]];
            [self postSignInMenu];
                }
    else {
        NSLog(@"Not logged in");
            [statusItem setImage: [NSImage imageNamed:@"icon_offline"]];
            [self postSignOutMenu];
    }
}

//Display Windows
- (void)displayLoginWindow{
   lwc = [[RMLoginWindowController alloc] initWithWindowNibName:@"RMLoginWindowController"];
    [lwc showWindow:nil];
    RMUser * user = [[RMUser alloc] init];
    user.userID = 1;
    [RMContext saveUser:user];
}

- (void)displayTeamWindow{
    twc = [[RMTeamWindowController alloc] initWithWindowNibName:@"RMTeamWindowController"];
    [twc showWindow:nil];

    RMUser * user = [[RMUser alloc] init];
    user.userID = 1;
    [RMContext saveUser:user];

}

- (void)setUserAvailable{
    [statusItem setImage: [NSImage imageNamed:@"icon_available"]];
    [self postSignInMenu];
}

- (void)setUserBusy{
    [statusItem setImage: [NSImage imageNamed:@"icon_busy"]];
    [self postSignInMenu];
}

- (void)menuClear{
    [menu removeAllItems];
}

-(void)postSignInMenu{
    [menu removeAllItems];
    [menu addItemWithTitle:@"Show Team"  action:@selector(displayTeamWindow) keyEquivalent:@""];
    [menu addItemWithTitle:@"Available"  action:@selector(setUserAvailable) keyEquivalent:@""];
    [menu addItemWithTitle:@"Busy"  action:@selector(setUserBusy) keyEquivalent:@""];
    [menu addItemWithTitle:@"Sign out"  action:@selector(signOut) keyEquivalent:@""];
    [menu addItemWithTitle:@"Quit"  action:@selector(quit) keyEquivalent:@""];
}

- (void)postSignOutMenu{
    [menu removeAllItems];
    [menu addItemWithTitle:@"Sign in"  action:@selector(displayLoginWindow) keyEquivalent:@""];
    [menu addItemWithTitle:@"Quit"  action:@selector(quit) keyEquivalent:@""];
}

- (void)signOut{
    RMUser * user = [[RMUser alloc] init];
    user.userID = 0;
    [RMContext saveUser:user];
    [statusItem setImage: [NSImage imageNamed:@"icon_offline"]];
    [statusItem setMenu:menu];
    [statusItem setHighlightMode:YES];
    [self postSignOutMenu];
}

- (void)quit{
    [NSApp terminate:nil];
}

@end
