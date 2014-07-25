//
//  RMSerialization.h
//  Rome
//
//  Created by Riddhiman Das on 6/29/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "RMUser.h"

@interface RMContext : NSObject
+ (NSString*) serializationPath;
+ (void) saveUser: (RMUser*) user;
+ (BOOL) isUserLoggedIn;
+ (RMUser*) getCurrentUser;
+ (void) signOut;
@end
