package fromWeb;

import java.util.PriorityQueue;

public class MiddleInStream {
		private static int count = 0;
		private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
		 
		public static void Insert(Integer num) {
		    if (count %2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
		        //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
		        //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
		        maxHeap.offer(num);
		        int filteredMaxNum = maxHeap.poll();
		        //2.筛选后的【大根堆中的最大元素】进入小根堆
		        minHeap.offer(filteredMaxNum);
		    } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
		        //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
		        //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
		        minHeap.offer(num);
		        int filteredMinNum = minHeap.poll();
		        //2.筛选后的【小根堆中的最小元素】进入大根堆
		        maxHeap.offer(filteredMinNum);
		    }
		    count++;
		}
		 
		public static Double GetMedian() {
		    if (count %2 == 0) {
		        return new Double((minHeap.peek() + maxHeap.peek())) / 2;
		    } else {
		        return new Double(minHeap.peek());
		    }
		}
		
		public static void main(String[] args) {
			Insert(3);
			Insert(5);
			Insert(9);
			Insert(7);
			Insert(6);
			Insert(4);
			Insert(2);
			
			System.out.println(GetMedian());
		}
}
