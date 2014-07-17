//
//  RMAppDelegate.h
//  Rome
//
//  Created by Riddhiman Das on 6/29/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import <Cocoa/Cocoa.h>



#import "RMContext.h"
#import "Unirest.h"
#import "RMLoginWindowController.h"
#import "RMTeamWindowController.h"

@interface RMAppDelegate : NSObject <NSApplicationDelegate>
{
    NSStatusItem *statusItem;
    IBOutlet NSMenu *menu;
    NSWindowController *lwc, *twc;
}

@property (assign) IBOutlet NSWindow *window;

@property (weak) IBOutlet NSMenuItem *item1;

- (void)displayLoginWindow;
- (void)displayTeamWindow;
- (void)setUserAvailable;
- (void)menuClear;
- (void)postSignInMenu;
- (void)postSignOutMenu;
- (void)signOut;
- (void)quit;

@end
