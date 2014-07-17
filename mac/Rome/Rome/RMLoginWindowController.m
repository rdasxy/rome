//
//  RMLoginWindowController.m
//  Rome
//
//  Created by Tam Tran on 7/6/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import "RMLoginWindowController.h"
#import "RMAppDelegate.h"


@interface RMLoginWindowController ()

@end

@implementation RMLoginWindowController
@synthesize email_input;
@synthesize login_view_title;
@synthesize password_input;

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

- (IBAction)login_button:(id)sender {
   
//    NSDictionary* headers = @{@"accept": @"application/json"};
//    NSDictionary* parameters = @{@"email": [email_input stringValue], @"password": [password_input stringValue]};
//    
//    [[UNIRest post:^(UNISimpleRequest* request) {
//        [request setUrl:@"http://localhost:8080/user/login"];
//        [request setHeaders:headers];
//        [request setParameters:parameters];
//    }] asJsonAsync:^(UNIHTTPJsonResponse* response, NSError *error) {
//        // This is the asyncronous callback block
//        NSInteger* code = [response code];
//        NSDictionary* responseHeaders = [response headers];
//        UNIJsonNode* body = [response body];
//        NSData* rawBody = [response rawBody];
//        
//        NSDictionary *json_response = response.body.JSONObject;
//        
//        NSLog(@"JSON State Result:%@", json_response[@"status_code"]);
    

//  if([json_response[@"status_code"] intValue] == 200){
//        RMUser * user = [[RMUser alloc] init];
//        user.userID = 32324;
//        user.userName = @"ttran4040";
//        user.firstName = @"Tam";
//        user.token = @"dlkjdsfkljhfsd";
//        [RMContext saveUser:user];
//        [self close];
    
if([[email_input stringValue] isEqualToString:@"Email"] && [[password_input stringValue] isEqualToString:@"123"] ){
    RMAppDelegate *appDelegate = (RMAppDelegate *)[[NSApplication sharedApplication] delegate];
    [appDelegate setUserAvailable];
    [self close];
    
  }
else{
    [login_view_title setStringValue:@"Failed, please try again."];
}
    

}
@end
