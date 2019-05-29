// 某数组原本的值与对应下标相同，现在缺了一个数，请获取该缺失的数字的下标
public int getLostNum(int [] array){
	if(array == null || array.length == 0) return -1;
	int start = 0, end = array.length-1;
	while (start <= end){
		int mid = （right+left)>>1;

		if(mid == array[mid]){
			start = mid+1;
		}else{
			if(mid == 0 || mid-1 == array[mid-1]){
				return mid;
			}else{
				end = mid - 1;
			}
		}
	}

	if(start == array.length) return length; //数字没有缺失

	return -1; //无效的输入
}
