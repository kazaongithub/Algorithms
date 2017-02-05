#!/usr/bin/perl

## 
## Removing duplicates with hash
##

use warnings;
use strict;

## This function takes array as parameter
## Returns the array that contains the unique elements
## Using hash technique
sub remove_duplicates_from_array
{
    my $array = shift;

    ## Coverting array to hash
    my %hash = map { $_, 1 } @{$array};

    ## Get the keys
    @$array = keys %hash;
    
    ## Finally return the array that contains unique elements
    return $array;
}

sub main
{

    my $array_size = shift;

    ## Range from generating random number
    my $range = 2 * $array_size;

    ## Fill the array with random numbers
    my $array = [];
    foreach my $i (0..$array_size-1) {
        $$array[$i] = int(rand($range)) + 1;
    } 

    ## Calculate time
    my $now = time;
    $array = remove_duplicates_from_array($array);
    $now = time - $now;

    #print join (", ", @array) . "\n";
    #print join (", ", @$unique_array) . "\n";

    printf("Array Size - %d,\tTime - %02dMin : %02dSec\n", $array_size, int(($now % 3600) / 60), int($now % 60));
}

print "\n\n### Time taken to remove duplicates using hash technique\n";
# Test for 1 Lakh
main(100000);

# Test for 10 Lakh
&main(1000000);

# Test for 1 Crore
&main(10000000);

# Test for 10 Crore
&main(100000000);
print "### Done\n\n";
