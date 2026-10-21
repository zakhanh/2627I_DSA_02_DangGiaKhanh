package Buoi7;
// Import các lớp cần thiết:
// Collections để đảo ngược thứ tự trong PriorityQueue,
// PriorityQueue để làm cấu trúc heap, Queue để khai báo biến chứa dữ liệu,
// Scanner để đọc dữ liệu từ đầu vào.
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// Lớp chính chứa chương trình tính trung vị liên tiếp khi nhập N số.
public class W7_25020212 {
    // Hàm main là điểm bắt đầu chạy chương trình.
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để đọc dữ liệu từ bàn phím.
        Scanner scanner = new Scanner(System.in);

        // N là số lượng số cần xử lý.
        int N;

        // Nếu đầu vào không phải số nguyên, dừng chương trình ngay.
        if (scanner.hasNextInt()) {
            N = scanner.nextInt();
        } else {
            return;
        }

        // maxPQ: chứa nửa trái, dùng PriorityQueue tối đa (đầu là giá trị lớn nhất).
        // Vì ta cần lấy phần tử lớn nhất của nửa trái, nên dùng Collections.reverseOrder().
        Queue<Integer> maxPQ = new PriorityQueue<>(N / 2 + 1, Collections.reverseOrder());

        // minPQ: chứa nửa phải, dùng PriorityQueue tối thiểu (đầu là giá trị nhỏ nhất).
        Queue<Integer> minPQ = new PriorityQueue<>(N / 2 + 1);

        // Lặp qua N số được nhập.
        for (int i = 0; i < N; i++) {
            // currentNumber là số đang xét ở lần lặp hiện tại.
            int currentNumber = scanner.nextInt();

            // Nếu maxPQ rỗng hoặc số mới nhỏ hơn hoặc bằng phần tử đầu của maxPQ,
            // thì đưa số mới vào nửa trái; ngược lại đưa vào nửa phải.
            if (maxPQ.isEmpty() || currentNumber <= maxPQ.peek()) {
                maxPQ.add(currentNumber);
            } else {
                minPQ.add(currentNumber);
            }

            // Sau khi thêm số mới, cần cân bằng 2 nửa để đảm bảo:
            // - tất cả phần tử trong maxPQ <= tất cả phần tử trong minPQ
            // - size(maxPQ) không vượt quá size(minPQ) + 1
            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            // median là trung vị của tập số hiện tại.
            double median;

            // Nếu 2 nửa có cùng kích thước, trung vị là trung bình của 2 đầu mút ở giữa.
            if (maxPQ.size() == minPQ.size()) {
                median = (maxPQ.peek() + minPQ.peek()) / 2.0;
            } else {
                // Nếu một nửa nhiều hơn một phần tử, trung vị là phần tử đầu của nửa lớn hơn.
                median = maxPQ.peek();
            }

            // In ra trung vị với 1 chữ số thập phân theo yêu cầu.
            System.out.printf("%.1f\n", median);
        }

        // Đóng Scanner để giải phóng tài nguyên.
        scanner.close();
    }
}
