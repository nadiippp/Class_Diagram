import java.util.Scanner;

class User {
    private String nama;
    private int targetAir;

    public User(String nama, int targetAir) {
        this.nama = nama;
        this.targetAir = targetAir;
    }

    public String getNama() {
        return nama;
    }

    public int getTargetAir() {
        return targetAir;
    }
}

class Tracker {
    private User user;
    private int totalMinum;

    public Tracker(User user) {
        this.user = user;
        this.totalMinum = 0;
    }

    public void tambahMinum(int jumlah) {
        totalMinum += jumlah;
        System.out.println("[INFO] Berhasil menambah " + jumlah + " ml");
    }

    public void cekStatus() {
        System.out.println("\n=== STATUS MINUM ===");
        System.out.println("Nama   : " + user.getNama());
        System.out.println("Target : " + user.getTargetAir() + " ml");
        System.out.println("Total  : " + totalMinum + " ml");

        if (totalMinum < user.getTargetAir()) {
            System.out.println("Status : Kurang minum");
        } else if (totalMinum == user.getTargetAir()) {
            System.out.println("Status : Cukup");
        } else {
            System.out.println("Status : Lebih");
        }
    }
}

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan target minum harian (ml): ");
        int target = input.nextInt();

        User user = new User(nama, target);
        Tracker tracker = new Tracker(user);

        int pilihan;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah minum");
            System.out.println("2. Cek status");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah minum (ml): ");
                    int jumlah = input.nextInt();
                    tracker.tambahMinum(jumlah);
                    break;

                case 2:
                    tracker.cekStatus();
                    break;

                case 3:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 3);

        input.close();
    }
}