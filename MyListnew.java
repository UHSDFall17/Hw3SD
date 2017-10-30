
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
public class MyListnew {
	    public static void main(String[] args) throws ParseException {
	       int n=args.length;
	       Scanner scan=new Scanner(System.in);
	       Options options = new Options();
	       Option type = new Option("type",true, "int/string");
	       options.addOption(type);
	       Option key = new Option("key",true, "value to be searched");
	       options.addOption(key);
	       Option list = new Option("list",true, "list of values");
	       options.addOption(list);
	       try{
	       CommandLine cmd; 
	       CommandLineParser commanLineParser=new DefaultParser();
	       cmd = commanLineParser.parse(options,args);
	       String typevalue=cmd.getOptionValue("type");
	       String keyvalue=cmd.getOptionValue("key");
	       String firstvalue=cmd.getOptionValue("list");
	       List<String> rest=cmd.getArgList();
	       Comparable[] aList =new String[rest.size()+1];
	       aList[0]=firstvalue;
	       for(int i=1;i<aList.length;i++){
	    	   aList[i]=rest.get(i-1);
	       }    
	 int result=binSearch(aList,keyvalue);
	 if(result==-1)
	     System.out.println("Key not found!!");
	 else
		 System.out.println("Key found at"+ result);
	       }
	       catch(Exception e){
	       System.out.println(e);
	       }
	      
	       
	    }
	

		public static int binSearch(Comparable[] aList, Comparable keyvalue)
	    {
			
	         int low = 0;
	    int high = aList.length -1;
	    int mid;
	    while (low<=high) {
	        mid = (low+high) /2;
	        if (aList[mid].compareTo(keyvalue)<0){
	         low=mid+1;
	        }
	        else if (aList[mid].compareTo(keyvalue)>0) {
	            high=mid-1;
	        }
	        else {
	            return mid;
	        }
	        }
	
	    return -1;
   
	   }
	    



}
