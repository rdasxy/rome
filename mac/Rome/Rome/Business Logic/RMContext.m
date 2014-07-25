//
//  RMSerialization.m
//  Rome
//
//  Created by Riddhiman Das on 6/29/14.
//  Copyright (c) 2014 Laplacian. All rights reserved.
//

#import "RMContext.h"

@implementation RMContext

+ (NSString*) serializationPath
{
    NSFileManager* fileManager = [[NSFileManager alloc] init];
    NSString* bundleID = [[NSBundle mainBundle] bundleIdentifier];
    NSArray* urlPaths = [fileManager URLsForDirectory:NSApplicationSupportDirectory
                                            inDomains:NSUserDomainMask];
    
    NSURL* appDirectory = [[urlPaths objectAtIndex:0] URLByAppendingPathComponent:bundleID isDirectory:YES];
    
    if (![fileManager fileExistsAtPath:[appDirectory path]]) {
        [fileManager createDirectoryAtURL:appDirectory withIntermediateDirectories:NO attributes:nil error:nil];
    }
    NSLog(@"Serialization Path = %@", [appDirectory path]);
    return [appDirectory path];
}

+ (void) saveUser: (RMUser*) user
{
    NSString * path = [NSString stringWithFormat:@"%@/user", [RMContext serializationPath]];
    [NSKeyedArchiver archiveRootObject:user toFile:path];
    NSLog(@"Saved User to Path: %@", path);
}

+ (BOOL) isUserLoggedIn
{
    NSFileManager *fileManager = [NSFileManager defaultManager];
    NSString * path = [NSString stringWithFormat:@"%@/user", [RMContext serializationPath]];
    NSLog(@"Checked Path: %@", path);
    return ([fileManager fileExistsAtPath:path]);
}

+ (RMUser*) getCurrentUser
{
    NSString * path = [NSString stringWithFormat:@"%@/user", [RMContext serializationPath]];
    NSLog(@"Getting user from Path: %@", path);
    return [NSKeyedUnarchiver unarchiveObjectWithFile:path];
}

+ (void) signOut
{
    // TODO: Implement this
}

@end
