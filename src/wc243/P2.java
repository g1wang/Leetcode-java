package wc243;

public class P2 {
    public String maxValue(String n, int x) {
        int idx = 0;int flag=1;

        if (n.charAt(0)=='-') {
            idx++;
            x*=-1;
            flag=-1;
        }
        while (idx<n.length()){
            if (n.charAt(idx)*flag<x){
                return n.substring(0,idx)+Math.abs(x)+n.substring(idx);
            }
            idx++;
        }
        return n+x;
    }
}
