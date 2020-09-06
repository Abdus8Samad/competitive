#include <bits/stdc+.h>

using namespace std;

class Interval{
	int start,end;
	Interval(){start=end=0;}
	Interval(int s, int e){start=s;end=e;}
}

vector<Interval> insert(vector<Interval> intervals, Interval myInterval){
	if(intervals == null){
		vector<Interval> ret;
		ret.push_back(myInterval);
		return ret;
	} else if(intervals.size() == 0){
		intervals.push_back(myInterval);
		return intervals;
	}
	int i=0;
	for(;i<intervals.size();i++){
		Interval current = intervals[i];
		if(current.end < myInterval.start) continue;
		else if(current.start > myInterval.end){
			intervals.insert(i, toInsert);
			break;
		} else {
			toInsert.start = Math.min(current.start, myInterval.start)
			toInsert.end = Math.max(current.end, myInterval.end)
			intervals.remove(i);
			i--;
		}
	}
	if(i == intervals.size()){
		intervals.push_back(myInterval);
	}
	return intervals;
}

int main(){
	int start,end;
	cin >> start >> end;
	Interval myInterval = new Interval(start, end);
	vector<Interval> input;
	int n;
	cin >> n;
	for(int i=0;i<n;i++){
		cin >> start >> end;
		Interval temp = new Interval(start, end);
		input.push_back(temp);
	}
	for(Interval elem : insert(input, myInterval)){
		cout << "[" + elem.start + "," + elem.end + "]";
	}
	return 0;
}
