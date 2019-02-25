/**
   @回溯-旅行商(TSP)问题
*/
#include<iostream>
#include<algorithm>
#define MAX 100		//城市个数上限
using  namespace std;
int n;                             //城市个数
int a[MAX][MAX];                   //城市间距离
int x[MAX];                       //记录当前路径，旅行顺序为x[1], x[2], ...
int bestx[MAX] = { 0 };           //记录最优路径
int bestp = 63355;              //最优路径长
int cp = 0;                    //当前路径长

void backpack(int t) {	//回溯函数，t代表
	if (t > n) {
		if ((a[x[n]][1]) && (a[x[n]][1] + cp < bestp)) {	//最后一个城市和出发城市联通，且总距离小于当前最小距离
			bestp = a[x[n]][1] + cp;						//则替换当前最优方案
			for (int i = 1; i <= n; i++) {
				bestx[i] = x[i];
			}
		}
	}
	else {
		for (int i = t; i <= n; i++) {
			/*约束为当前节点到下一节点的长度不为0,限界为走过的长度+当前要走的长度之和小于最优长度*/
			if ((a[x[t - 1]][x[i]]) && (cp + a[x[t - 1]][x[i]] < bestp)) {
				swap(x[t], x[i]);
				cp += a[x[t - 1]][x[t]];
				backpack(t + 1);
				cp -= a[x[t - 1]][x[t]];
				swap(x[t], x[i]);
			}
		}
	}
}
int main() {
	cout << "输入城市个数:" << endl;
	cin >> n;      //顶点数
	for (int i = 1; i <= n; i++) {
		x[i] = i;
	}
	cout << "输入城市之间的距离(0表示城市间不通):" << endl;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> a[i][j];
		}
	}
	backpack(2);
	cout << "最少旅行费用为: " << bestp << endl;
	cout << "旅行路径为:" << endl;
	for (int i = 1; i <= n; i++) {
		cout << bestx[i] << " ";
	}
	cout << bestx[1];
	return 0;
}
/*
4
0 30 6 4
30 0 5 10
6 5 0 20
4 10 20 0
*/
