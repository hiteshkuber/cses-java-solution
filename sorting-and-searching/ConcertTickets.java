import java.io.*;
import java.util.*;

public class ConcertTickets {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int price = fs.nextInt();
            map.put(price, map.getOrDefault(price, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int offer = fs.nextInt();

            Map.Entry<Integer, Integer> e = map.floorEntry(offer);

            if (e == null) {
                sb.append("-1\n");
            } else {
                int ticket = e.getKey();
                sb.append(ticket).append('\n');

                int count = e.getValue() - 1;
                if (count == 0) {
                    map.remove(ticket);
                } else {
                    map.put(ticket, count);
                }
            }
        }

        System.out.print(sb);
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
