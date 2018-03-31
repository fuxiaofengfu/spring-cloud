package com.client.util;

import java.util.Arrays;

/**
 *
 */
public class SortUtil {


	public static void main(String[] args) {
		int[][] ss = {{1,2,3,4},{32,9,3,13,5,7},{65,12,5,6,10,8,6,99}};
		sort2DArray(ss);
		for (int i = ss.length-1 ; i >= 0; i--) {
			System.out.println(Arrays.toString(ss[i]));
		}
	}

	public static void sort2DArray(int[][] arr){
		int[] result = null;
		int[] subArrLen = new int[arr.length];
		int index = 0;
		for(int[] sub : arr){
			int destPos = 0;
			if(null == result){
				result = new int[sub.length];
			}else{
				destPos = result.length;
				result = Arrays.copyOf(result, result.length + sub.length);
			}
			System.arraycopy(sub,0,result,destPos,sub.length);
			subArrLen[index] = sub.length;
			index ++;
		}
		result = fastSort2(result);
		System.out.println(Arrays.toString(result));
		int result_start_index = 0;
		for (int i = 0; i < subArrLen.length; i++) {
			int[] newSubArr = new int[subArrLen[i]];
			for (int j = 0; j < subArrLen[i]; j++) {
				newSubArr[j] = result[ result_start_index + j];
			}
			result_start_index += newSubArr.length;
			arr[i] = newSubArr;
		}
	}

	public static int[] fastSort2(int[] arr){

		for (int i = 0; i < arr.length ; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int b = arr[j];//2
				if(arr[i] < b ){
					int tmp = arr[i];
					arr[i] = b;
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}

	public static int[] fastSort(int[] arr){

		if(arr.length<=1){
			return arr;
		}
		//基准值
		int tmp = arr[0];

		int[] small = null;
		int[] big = null;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>tmp){
				if(null == big){
					big = new int[]{arr[i]};
				}else{
					big = Arrays.copyOf(big,big.length + 1);
					big[big.length - 1] = arr[i];
				}
			}else{
				if(null == small){
					small = new int[]{arr[i]};
				}else {
					small = Arrays.copyOf(small,small.length + 1);
					small[small.length - 1] = arr[i];
				}
			}
		}

		if(null == big){
			big = new int[0];
		}
		if(null == small){
			small = new int[0];
		}
		int[] newBigArr = Arrays.copyOf(big, big.length +1+ small.length);
		newBigArr[big.length] = tmp;
		System.arraycopy(fastSort(small),0,fastSort(newBigArr),0,small.length);
		return newBigArr;
	}
}
