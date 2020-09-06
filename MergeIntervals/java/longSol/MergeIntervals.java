import java.util.*;

class Interval{
    int start,end;
    Interval(){start=0;end=0;}
    Interval(int s, int e){start=s;end=e;}
}

public class Myclass{
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals,Interval myInterval){
	ArrayList<Interval> ans = new ArrayList<>();
        int i=0;
        for(;i<intervals.size();i++){
            if(intervals.get(i).end < myInterval.start){
                ans.add(intervals.get(i));
            } else break;
        } if(i == intervals.size()){
             ans.add(myInterval);
              return ans;    
        }
        if(intervals.get(i).start > myInterval.end){
            ans.add(myInterval);
            for(;i<intervals.size();i++) ans.add(intervals.get(i));
            return ans;
        }
        int start = Math.min(intervals.get(i).start, myInterval.start);
        for(;i<intervals.size();i++){
            int end = Math.max(intervals.get(i).end, myInterval.end);
            if(i+1 == intervals.size()){
                Interval temp = new Interval(start, end);
                ans.add(temp);
                return ans;
            }
            else if(end < intervals.get(i+1).start){
                Interval temp = new Interval(start, end);
                ans.add(temp);
                i++;
                break;
            }
        }
        for(;i<intervals.size();i++) ans.add(intervals.get(i));
        return ans;
    }
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int start = sc.nextInt();
	int end = sc.nextInt();
	Interval myInterval = new Interval(start, end);
	int n = sc.nextInt();
	ArrayList<Interval> input = new ArrayList<>();
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
