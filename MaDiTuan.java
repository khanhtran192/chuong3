import java.util.Scanner;

public class MaDiTuan {
	private int kich_thuoc_bang;
	private int x, y;
	private int hang[];
	private int cot[];
	private boolean cx[][];
	private int a[][];
	private int dem;

	public void Input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap kich thuoc bang = ");
		kich_thuoc_bang = sc.nextInt();
		System.out.println("Nhap vi tri dau");
		System.out.print("Nhap x = ");
		x = sc.nextInt();
		System.out.print("Nhap y = ");
		y = sc.nextInt();
	}

	public void Init() {
		hang = new int[8];
		cot = new int[8];

		// Cac buoc di cua quan ma
		hang[0] = -2; cot[0] = +1;
		hang[1] = -1; cot[1] = +2;
		hang[2] = +1; cot[2] = +2;
		hang[3] = +2; cot[3] = +1;
		hang[4] = +2; cot[4] = -1;
		hang[5] = +1; cot[5] = -2;
		hang[6] = -1; cot[6] = -2;
		hang[7] = -2; cot[7] = -1;

		cx = new boolean[kich_thuoc_bang + 4][kich_thuoc_bang + 4];
		a = new int[kich_thuoc_bang + 4][kich_thuoc_bang + 4];

		int i, j;

		for (i = 0; i < kich_thuoc_bang + 4; i++) {
			for (j = 0; j < kich_thuoc_bang + 4; j++)
				cx[i][j] = false;
		}

		for (i = 2; i < kich_thuoc_bang + 2; i++) {
			for (j = 2; j < kich_thuoc_bang + 2; j++)
				cx[i][j] = true;
		}

		cx[x + 1][y + 1] = false;
		a[x + 1][y + 1] = 1;
		dem = 0;
	}

	public void Try2(int x0, int y0, int i) {
		int j;
		for (j = 0; j < 8; j++)
			if (cx[x0 + hang[j]][y0 + cot[j]] == true) {
				a[x0 + hang[j]][y0 + cot[j]] = i;
				cx[x0 + hang[j]][y0 + cot[j]] = false;
				if (i == kich_thuoc_bang * kich_thuoc_bang) {
					InKQ();
				} else {
					Try2(x0 + hang[j], y0 + cot[j], i + 1);
					cx[x0 + hang[j]][y0 + cot[j]] = true;
				}
				// cx[x0 + hang[j]][y0 + cot[j]] = true;
				
			}
	}

	public void InKQ() {
		dem++;
		System.out.println("Cach chay : ");
		int i, j;
		for (i = 2; i < kich_thuoc_bang + 2; i++) {
			for (j = 2; j < kich_thuoc_bang + 2; j++)
				System.out.format("%3d ", a[i][j]);
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		MaDiTuan t = new MaDiTuan();
		t.Input();
		t.Init();
		t.Try2(t.x + 1, t.y + 1, 2);
		if (t.dem == 0)
			System.out.println("Bai toan khong co nghiem");
	}

}