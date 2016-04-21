package Numbe_1;

/**
 * P145 ��Ȩ quick-union,��֤���ǽ���С�����ӵ��������������ĸ߶ȣ��Ӷ�����find()�����Ĵ���
 * args:4 3 3 8 6 5 9 4 2 1 8 9 5 0 7 2 6 1 1 0 6 7
 * @author he
 *
 */
public class WeightedQuickUnionUF {
	private int id[];// ��������
	private int sz[];// ģ�����ĸ߶ȵ�����ͬ�����ĸ߶�
	private int count;// ��ͨ����������

	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		// ���߶�С�������ӵ�������
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}else {
			id[j]=i;
			sz[i]+=sz[j];
		}

		count--;
	}
	
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	
	public int count(){
		return count;
	}

	public static void main(String[] args) {
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
		for (int i = 0; i < args.length; i += 2) {
			int p = Integer.parseInt(args[i]);
			int q = Integer.parseInt(args[i + 1]);
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		System.out.println(uf.count() + " components");// 2
	}
	
}