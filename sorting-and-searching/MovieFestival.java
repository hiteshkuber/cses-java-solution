import java.io.*;
import java.util.*;

public class MovieFestival {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        int[][] movies = new int[n][2];

        for (int i = 0; i < n; i++) {
            int start = fs.nextInt();
            int end = fs.nextInt();

            movies[i] = new int[]{start, end};
        }

        Arrays.sort(movies, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int count = n == 0 ? 0 : 1;

        int end = 0;

        if(n != 0) {
            end = movies[0][1];
        }

        for(int i = 1; i < n; i++) {
            if(movies[i][0] >= end) {
                end = movies[i][1];

                count++;
            } else {
                end = Math.min(end, movies[i][1]);
            }
        }

        System.out.print(count);
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
