/**
   @����-������(TSP)����
*/
#include<iostream>
#include<algorithm>
#define MAX 100		//���и�������
using  namespace std;
int n;                             //���и���
int a[MAX][MAX];                   //���м����
int x[MAX];                       //��¼��ǰ·��������˳��Ϊx[1], x[2], ...
int bestx[MAX] = { 0 };           //��¼����·��
int bestp = 63355;              //����·����
int cp = 0;                    //��ǰ·����

void backpack(int t) {	//���ݺ�����t����
	if (t > n) {
		if ((a[x[n]][1]) && (a[x[n]][1] + cp < bestp)) {	//���һ�����кͳ���������ͨ�����ܾ���С�ڵ�ǰ��С����
			bestp = a[x[n]][1] + cp;						//���滻��ǰ���ŷ���
			for (int i = 1; i <= n; i++) {
				bestx[i] = x[i];
			}
		}
	}
	else {
		for (int i = t; i <= n; i++) {
			/*Լ��Ϊ��ǰ�ڵ㵽��һ�ڵ�ĳ��Ȳ�Ϊ0,�޽�Ϊ�߹��ĳ���+��ǰҪ�ߵĳ���֮��С�����ų���*/
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
	cout << "������и���:" << endl;
	cin >> n;      //������
	for (int i = 1; i <= n; i++) {
		x[i] = i;
	}
	cout << "�������֮��ľ���(0��ʾ���м䲻ͨ):" << endl;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> a[i][j];
		}
	}
	backpack(2);
	cout << "�������з���Ϊ: " << bestp << endl;
	cout << "����·��Ϊ:" << endl;
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