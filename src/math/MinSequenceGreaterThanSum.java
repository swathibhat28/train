package math;

public class MinSequenceGreaterThanSum {
	

	//a = 2,1,1,4,3,6
	//sum = 8


	int findMinSequence(int []a,int sum){
	    int wL=0,wR=0,minSum=0,minSeq=a.length,l=0,r=0;
	    
	    for(int i=0;i<=a.length;i++){
	        minSum+=a[i];
	        
	        if(minSum < 0){
	            wL=i;
	            minSum=0;
	        }
	        
	        if(minSum <= sum){
	            wR = i;
	        }else{
	            while(minSum > sum && wL <=i){
	                 minSum -=a[wL];
	                 wL++;   
	            }
	            wR = i;
	        }
	        
	        if(minSeq > (wR-wL-1) && minSum > sum){
	            l = wL;
	            r = wR;
	            minSeq = l-r+1;
	        }
	    }
	    return minSeq;
	    
	}


}
