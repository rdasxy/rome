//
//  RMAppDelegate.h
//  Rome
//
//  Created by Riddhiman Das on 6/29/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import <Cocoa/Cocoa.h>
#import "RMTeamWindowController.h"

@interface RMAppDelegate : NSObject <NSApplicationDelegate>
{
    NSStatusItem *statusItem;
    RMTeamWindowController *twc;
    IBOutlet NSMenu *menu;
}

@property (assign) IBOutlet NSWindow *window;

@property (weak) IBOutlet NSMenuItem *item1;

- (IBAction)showTeam:(id)sender;
- (void)setAvailable;
- (void)setBusy;
- (IBAction)saveAction:(id)sender;

@end
