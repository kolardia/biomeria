package com.kolardia.myapplication;

/**
 * Created by Kolardia on 2015-12-12.
 */


import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.stat.StatUtils;

import java.util.ArrayList;
import java.util.List;

class Punkt
{
    double x;
    double y;
    int force;
}

public class DTW {

    public Double algorytmDTW(ArrayList<Punkt> sample, ArrayList<Punkt> templete) {
        Double[][] DTW = new Double[sample.size()][templete.size()];

        for (int i = 1; i < sample.size(); i++) {
            DTW[i][0] = Double.MAX_VALUE;
        }
        for (int i = 1; i < templete.size(); i++) {
            DTW[0][i] = Double.MAX_VALUE;
        }

        DTW[0][0] = 0.0;

        for (int i = 1; i < sample.size(); i++) {
            for (int j = 1; j < templete.size(); j++) {
                double cost = algorytmTaxi(sample.get(i), templete.get(j));
                DTW[i][j] = cost + StatUtils.min(new double[]{DTW[i-1][j], DTW[i][j-1], DTW[i-1][j-1]});
            }
        }

        double resultDystance = DTW[sample.size() - 1][templete.size() - 1];
        return resultDystance;
    }
        private double algorytmEuklidesa(Punkt p1, Punkt p2) {
        EuclideanDistance euclides = new EuclideanDistance();

         double distance = euclides.compute(new double[]{p1.x, p2.x}, new double[]{p1.y, p2.y});
            return distance;
         }
        public double algorytmTaxi(Punkt p1, Punkt p2) {
            return Math.abs(p1.force - p2.force) + Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }
        public double algorytmMaximum(Punkt p1, Punkt p2) {
             return Math.max(Math.max(Math.abs(p1.force - p2.force), Math.abs(p1.x - p2.x)), Math.abs(p1.y - p2.y));
        }

}


