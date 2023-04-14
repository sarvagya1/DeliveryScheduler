package org.example.business;

import org.example.exception.OverlapScheduleException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlapFetcher {
    public static int[][] deliveryTimingOverlap(int[][] intervalsGap) throws OverlapScheduleException {
        List< int[] > res = new ArrayList<>();

        if( intervalsGap.length == 0 || intervalsGap == null)
            return res.toArray( new int[0][]);

        Arrays.sort( intervalsGap, Comparator.comparingInt(a -> a[0]));

        int startInterval = intervalsGap[0][0];
        int endInterval = intervalsGap[0][1];

        for( int[] i : intervalsGap){
            if(i[0] <= endInterval){
                endInterval = Math.max(endInterval, i[1]);
            }
            else{
                res.add(new int[] {startInterval, endInterval});
                startInterval = i[0];
                endInterval = i[1];
                throw new OverlapScheduleException("Overlap of schedule");
            }
        }

        res.add( new int[] {startInterval, endInterval});  //last interval in result

        return res.toArray(new int[0][]);
    }
}
