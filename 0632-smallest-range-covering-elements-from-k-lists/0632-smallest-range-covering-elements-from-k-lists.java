class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int k=nums.size();
        List<Pair> pairList=new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            for(int num:nums.get(i)){
                pairList.add(new Pair(num,i));
            }
        }
        Collections.sort(pairList,(a,b)->a.val-b.val);
        int s=0;
        int e=0;
        int minLen=Integer.MAX_VALUE-1;
        int[] ans=new int[2];
        while(e<pairList.size()){
            map.put(pairList.get(e).pos,map.getOrDefault(pairList.get(e).pos,0)+1);
            while(s<=e && map.size()==k){
                if(minLen>(pairList.get(e).val-pairList.get(s).val)+1){
                    minLen=pairList.get(e).val-pairList.get(s).val+1;
                    ans=new int[]{pairList.get(s).val,pairList.get(e).val};
                }
                map.put(pairList.get(s).pos,map.get(pairList.get(s).pos)-1);
                if(map.get(pairList.get(s).pos)==0)
                    map.remove(pairList.get(s).pos);
                s++;

            }
            e++;
        }
        return ans;
    }
}
class Pair{
    int val;
    int pos;
    Pair(int v,int sec){
        this.val=v;
        this.pos=sec;
    }
}