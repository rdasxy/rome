//
//  RMUser.m
//  Rome
//
//  Created by Riddhiman Das on 6/29/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import "RMUser.h"

@implementation RMUser

@synthesize userID = _userID;
@synthesize userName = _userName;
@synthesize token = _token;
@synthesize firstName = _firstName;

- (id)initWithCoder:(NSCoder *)decoder {
    self = [super init];
    if (!self) {
        return nil;
    }
    
    self.userID = [decoder decodeIntegerForKey:@"userID"];
    self.userName = [decoder decodeObjectForKey:@"userName"];
    self.token = [decoder decodeObjectForKey:@"token"];
    self.firstName = [decoder decodeObjectForKey:@"firstName"];
    return self;
}

- (void)encodeWithCoder:(NSCoder *)encoder {
    [encoder encodeInteger:self.userID forKey:@"userID"];
    [encoder encodeObject:self.userName forKey:@"userName"];
    [encoder encodeObject:self.token forKey:@"token"];
    [encoder encodeObject:self.firstName forKey:@"firstName"];
}

@end
