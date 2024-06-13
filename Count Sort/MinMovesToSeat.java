Problem Link: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/?envType=daily-question&envId=2024-06-13

//Optimized
class MinMovesToSeat {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int minCnt = 0;

        int p = 0;
        while(p<seats.length) {
            minCnt += Math.abs(seats[p] - students[p]);
            p++;
        }
        return minCnt;
    }
}

//Cyclic sort
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        //count sort
        int maxSeat = 0;
        int maxStudent  = 0;

        for(int i=0;i<n;i++) {
            if(seats[i] > maxSeat) 
                maxSeat = seats[i];
            if(students[i] > maxStudent)
                maxStudent = students[i];
        }

        int[] seatsArr = new int[maxSeat+1];
        int[] studentsArr = new int[maxStudent+1];

        //count the freqs
        for(int seat: seats) 
            seatsArr[seat]++;
        
        for(int student: students)
            studentsArr[student]++;
        
        System.out.println(Arrays.toString(seatsArr));
        System.out.println(Arrays.toString(studentsArr));

        //compare the positions
        int minCnt = 0;

        int seat=0;
        int student = 0;
        while(seat<=maxSeat && student <= maxStudent) {
            if(seatsArr[seat] > 0) {
                if(studentsArr[student] > 0) {
                    seatsArr[seat]--;
                    studentsArr[student]--;
                    minCnt += Math.abs(seat-student);
                } else {
                    student++;
                }
            } else {
                seat++;
            }
        }

        return minCnt;
    }
}
