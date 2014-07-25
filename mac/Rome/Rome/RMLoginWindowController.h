//
//  RMLoginWindowController.h
//  Rome
//
//  Created by Tam Tran on 7/6/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import <Cocoa/Cocoa.h>
#import "RMUser.h"
#import "RMContext.h"
#import "UNIRest.h"
#import "RMAppDelegate.h"







@interface RMLoginWindowController : NSWindowController{
    
    IBOutlet NSMenu *menu;
    RMLoginWindowController *postLogin;
}

@property (weak) IBOutlet NSTextField *login_view_title;
@property (weak) IBOutlet NSTextField *email_input;
@property (weak) IBOutlet NSSecureTextField *password_input;

- (IBAction)login_button:(id)sender;

@end
