import java.io.*;
import java.util.*;

public class RestaurantCustomers {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        int[] enter = new int[n];
        int[] exit = new int[n];

        for (int i = 0; i < n; i++) {
            int start = fs.nextInt();
            int end = fs.nextInt();

            enter[i] = start;
            exit[i] = end;
        }

        Arrays.sort(enter);
        Arrays.sort(exit);

        int max = 0;
        int current = 0;

        int enter_idx = 0;
        int exit_idx = 0;

        while(enter_idx < n) {
            if(enter[enter_idx] < exit[exit_idx]) {
                current++;
                enter_idx++;

                max = Math.max(max, current);
            } else if(enter[enter_idx] > exit[exit_idx]) {
                current--;
                exit_idx++;
            } else {
                enter_idx++;
                exit_idx++;
            }
        }

        System.out.print(max);
    }

    // Very fast input reader
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}
