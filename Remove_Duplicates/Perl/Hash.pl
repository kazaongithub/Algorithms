#!/usr/bin/perl

use warnings;
use strict;
use Data::Dumper;
use Time::HiRes;

my $range = 10;

print "Enter the size of array: ";
my $array_size = <STDIN>;

my @array;
foreach my $i (0..$array_size-1) {
    $array[$i] = int(rand($range)) + 1;
}

my ($start_sec, $start_usec) = Time::HiRes::gettimeofday();;
my %hash = map { $_, 1 } @array;
my @unique = keys %hash;
my ($end_sec, $end_usec) = Time::HiRes::gettimeofday();

my $duration = $end_sec - $start_sec;

#print join (" ", @array) . "\n";
#print join (" ", @unique) . "\n";
printf("Duration: %.2f\n", $duration);
