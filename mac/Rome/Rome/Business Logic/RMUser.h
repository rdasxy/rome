//
//  RMUser.h
//  Rome
//
//  Created by Riddhiman Das on 6/29/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import <Foundation/Foundation.h>

// NSCoding implemented from http://nshipster.com/nscoding/

@interface RMUser : NSObject<NSCoding>
{
    NSString *_userName, *_firstName, *_token;
    NSUInteger _userID;
}

@property NSString * userName;
@property NSString * firstName;
@property NSString * token;
@property NSUInteger userID;
@end
