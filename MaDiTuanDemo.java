import java.util.Scanner;
public class MaDiTuanDemo {
    static int A[][] = new int[5][5];
    static int X[] = {-2,-2,-1,-1, 1, 1, 2, 2};
    static int Y[] = { -1, 1,-2, 2,-2, 2,-1, 1};
    static int dem = 0;
    static int n,x,y;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        n = sc.nextInt();
        System.out.println("Nhap vi tri ban dau");
        System.out.println("Nhap x: ");
        x = sc.nextInt();
        System.out.println("Nhap y: ");
        y = sc.nextInt();
    }
    public void diChuyen(int x, int y){
        dem++;
        A[x][y] = dem;
        if(dem == n * n){
            System.out.println("Cach di");
            xuat();
//             System.out.println(dem);
            System.exit(0);
        }
        for (int i = 0; i < 8; i++){
            int u = x + X[i];
            int v = y + Y[i];
            if(u >= 0 && u < n && v >= 0 && v < n && A[u][v] == 0){
                diChuyen(u,v);
            }
        }
        dem--;  
        A[x][y] = 0;
    }

    public void xuat() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                System.out.format("%3d ", A[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MaDiTuanDemo mdt = new MaDiTuanDemo();
        mdt.Nhap();
        mdt.diChuyen(x, y);
        System.out.println("vo nghiem");
    }

}
