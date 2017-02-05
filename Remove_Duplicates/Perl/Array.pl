#!/usr/bin/perl 

##
## Removing duplicates with array sorting
##

use strict;
use warnings;

## This funtion takes the array as parameter
## Returns the array that contains the unique elements
sub remove_duplicates_from_array
{
    my $array = shift;

    ## The array holds all the unique elements from list
    my @unique_array = ();

    ## Intial check to remove duplicates
    my $checker = -12345654321;

    ## For each sorted elements from the array
    foreach my $element (sort(@$array)) {

        ## Move to next element if same
        if($checker == $element) {
            next;
        }

        ## replace old one with new found value
        else {
            $checker = $element;
            push (@unique_array, $checker);
        }
    }

    ## Finally return the array that contains unique elements
    return \@unique_array;
}

sub main
{
    ## Array size
    #print "Enter the size of array: ";
    #my $array_size = <STDIN>;

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

    print("Array Size - " . $array_size . "\t" . "Time - " . $now . " Seconds" . "\n");
}

print "\n\n### Remove duplicates using array sorting\n";
# Test for 1 Lakh
&main(100000);

# Test for 10 Lakh
&main(1000000);

# Test for 1 Crore
&main(10000000);

# Test for 10 Crore
&main(100000000);
print "### Done\n\n";
