Student name: Irmak Kavasoglu
Student ID: 2013400090
irmakkavasoglu@gmail.com

Q1:
The pseudocode here, and explanation below it.

////////////
function convert(vectorClock);

input: a vector clock named vectorClock, it is an array of integers.
output: an integer for the logical clock value.

logicalClock <- 0
for all value in vectorClock do
	logicalClock <- logicalClock + value
end for

return logicalClock
///////////

Vector clocks can give us total orders, but they cannot tell us what is the actual order that the events happened. They preserve the happens before relations but they do not know the exact timings.

Example: Take 2 processes, they start with clocks (1,0) and (0,1). They both have an event, and their vector clocks become (2,0) and (0,2). We do not know in which order these happened. Hence, the return value of logical clock can return a total order, but not the exact times of the processes.

We need to take into consideration 2 things.
1. Preserving event order in processes
2. Preseving happens before relations.

The convert function simply sums up all the values of the vector clock to produce a logical clock. Let's see how this works for the 2 constraints we have.

1. Preserving event order in processes
The vector clock always ticks for each event in the process i. Let's have a clock A[] for process i, at time t_0. For any time t > t_0, we know that A[i] > A_new[i]. We also know that other values in A, either stays the same or gets larger if we receive some message and update their values. Therefore, we can say that the sum of the clock A will always be smaller than sum of A_new. First condition holds.

2. Preserving happens before relations
When there is a message, there is a happens before relation. The way that the vector clock handles this is to use a max function; the receiving process will update its clock values to the maximum value of its own clock and the received clock. This makes sure that A_new > A and A_new > B, where the B is the received clock. We surely know that this process also means the sum of all values inside the clock satisfies the same condition, therefore the second condition holds too.

