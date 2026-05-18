# Job scheduler LLD implementation 

Requirement:
Take input of different jobs to be executed - done
 the time for execution of that job will also be taken as input -done
 A worker will schedule the jobs when the time comes for it to be executed.
4. the retry mechanism is also expected.
5. >= expected time
6. way to cancel the job -> by job metadata
7. status tracking of the job
8. cancel only if the job has not started yet


Learning :
Use of DelayQueue<Job> instead of PriorityBlockingQueue<Job>
But for delay queue you need to have elements of Type Delayed and you need to Override getDelay and compareTo function 
