class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        pos = opening(pos, op_start, op_end);

        for (String command : commands) {
            int m = Integer.valueOf(pos.substring(0, 2));
            int s = Integer.valueOf(pos.substring(3, 5));

            switch (command) {
                case "next":
                    s += 10;
                    if (s >= 60) {
                        s -= 60;
                        m++;
                    }

                    if (m > Integer.valueOf(video_len.substring(0, 2)) || 
                        (m == Integer.valueOf(video_len.substring(0, 2)) && s > Integer.valueOf(video_len.substring(3, 5)))) {
                        pos = video_len;
                    } else {
                        pos = String.format("%02d:%02d", m, s);
                    }
                    break;

                case "prev":
                    s -= 10;
                    if (s < 0) {
                        s += 60;
                        m--;
                    }

                    if (m < 0) {
                        pos = "00:00";
                    } else {
                        pos = String.format("%02d:%02d", m, s);
                    }
                    break;
            }
            pos = opening(pos, op_start, op_end);
        }

        return pos;
    }

    public String opening(String pos, String op_start, String op_end) {
        int posM = Integer.valueOf(pos.substring(0, 2));
        int posS = Integer.valueOf(pos.substring(3, 5));
        int op_sM = Integer.valueOf(op_start.substring(0, 2));
        int op_sS = Integer.valueOf(op_start.substring(3, 5));
        int op_eM = Integer.valueOf(op_end.substring(0, 2));
        int op_eS = Integer.valueOf(op_end.substring(3, 5));

        if ((posM > op_sM || (posM == op_sM && posS >= op_sS)) && 
            (posM < op_eM || (posM == op_eM && posS <= op_eS))) {
            return String.format("%02d:%02d", op_eM, op_eS);
        }

        return pos;
    }
}
