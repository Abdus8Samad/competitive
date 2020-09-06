class Interval:
    def __init__(self):
        self.start = 0
        self.end = 0
    def __init__(self,s,e):
        self.start = s
        self.end = e
def insert(intervals, myInterval):
    if intervals == None:
        intervals = []
        intervals.append(myInterval)
    elif len(intervals) == 0:
        intervals.append(myInterval)
        return intervals
    i = 0
    toInsert = myInterval
    for i in range(len(intervals)):
        current = Interval(intervals[i].start,intervals[i].end)
        if myInterval.start > current.end: continue
        elif current.start > myInterval.end:
            intervals.insert(i, toInsert)
            break
        else:
            toInsert.start = min(current.start, myInterval.start)
            toInsert.end = max(current.end, myInterval.end)
            intervals.remove(i)
            i-=1
    if i == len(intervals): intervals.append(toInsert)
    return intervals
myInterval = Interval(int(input()), int(input()))
n = int(input())
intervals = [Interval(int(input()), int(input())) for _ in range(n)]
for interval in insert(intervals, myInterval):
    print("["+str(interval.start)+","+str(interval.end)+"]")
