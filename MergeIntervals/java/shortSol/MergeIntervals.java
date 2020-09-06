import java.util.*;

class Interval{
	int start,end;
	Interval(){start=0;end=0;}
	Interval(int s,int e){start=s;end=e;}
}
class MergeIntervals{
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval myInterval){
		if(intervals == null){
			ArrayList<Interval> ret = new ArrayList<>();
			ret.add(myInterval);
			return ret;
		} else if(intervals.size() == 0){
			intervals.add(myInterval);
			return intervals;
		}
		Interval toInsert = myInterval;
		int i = 0;
		for(;i<intervals.size();i++){
			Interval current = new Interval(intervals.get(i).start, intervals.get(i).end);
			if(current.end < myInterval.start) continue;
			else if(current.start > myInterval.end){
				intervals.add(i, toInsert);
				break;
			} else {
				toInsert.end = Math.max(myInterval.end, current.end);
				toInsert.start = Math.min(current.start, myInterval.start);
				intervals.remove(i);
				i--;
			}
		}
		if(i == intervals.size()) intervals.add(toInsert);
		return intervals;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		Interval myInterval = new Interval(start, end);
		ArrayList<Interval> input = new ArrayList<>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			start = sc.nextInt();
			end = sc.nextInt();
			Interval temp = new Interval(start, end);
			input.add(temp);
		}
		for(Interval elem : insert(input, myInterval)){
			System.out.println("["+elem.start+","+elem.end+"]");
		}
		sc.close();
	}
}
