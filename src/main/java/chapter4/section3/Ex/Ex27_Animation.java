package chapter4.section3.Ex;

import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.HashSet;

public class Ex27_Animation {
    private class Coordinate{
        double xCoordinate;
        double yCoordinate;

        public Coordinate(double xCoordinate , double yCoordinate)
        {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }
    }


    public class PrimMSTAnimations{
        private Edge[] edgeTo;
        private double[] distTo;
        private boolean[] marked;
        private IndexMinPQ<Double> priorityQueue;

        private double weight;
        private double radiusOfCircleAroundVertex;
        private HashSet<Integer> verticesInMst;

        public PrimMSTAnimations(EdgeWeighedGraph g, double xScaleLow, double xScaleHigh
                ,double yScaleLow, double yScaleHigh, double radiusOfCircleAroundVertex)
        {
            edgeTo = new Edge[g.vertices()];
            distTo = new double[g.vertices()];
            marked = new boolean[g.vertices()];
            this.radiusOfCircleAroundVertex = radiusOfCircleAroundVertex;
            verticesInMst = new HashSet<>();

            Coordinate[] randomCoordinates = getRandomCoordinates(g);
            initCanvas(xScaleLow, xScaleHigh, yScaleLow, yScaleHigh);

            drawInitialVerticies(randomCoordinates);
            drawInitialEdges(g, randomCoordinates);

            for (int i = 0; i < g.vertices(); i++) {
                distTo[i] = Double.POSITIVE_INFINITY;
            }

            priorityQueue = new IndexMinPQ<>(g.vertices());
            distTo[0] = 0.0;
            priorityQueue.insert(0, 0.0);

            while(!priorityQueue.isEmpty())
            {
                int vertexToVisit = priorityQueue.delMin();

                visit(g, vertexToVisit, randomCoordinates);
            }

        }

        private void visit(EdgeWeighedGraph g, int vertex, Coordinate[] coordinates) {

            marked[vertex ] = true;

            for(Edge edge: g.adjacent(vertex)){
                int other = edge.other(vertex);

                if(marked[other]){
                    if(edgeTo[vertex].other(vertex) != other){
                        drawIneligibleEdge(vertex, other, coordinates);
                    }
                    continue;
                }

                if(edge.weight()<distTo[other]){
                    if(edgeTo[other] != null){
                        int previousBestVertexConnectedToOhter = edgeTo[other].other(other);
                        drawIneligibleEdge(previousBestVertexConnectedToOhter,other,coordinates);
                    }

                    if(distTo[other] != Double.POSITIVE_INFINITY)
                    {
                        weight -=distTo[other];
                    }

                    weight +=edge.weight();

                    edgeTo[other] = edge;
                    distTo[other] = edge.weight();

                    if(priorityQueue.contains(other))
                    {
                        priorityQueue.decreaseKey(other, distTo[other]);
                    }
                    else{
                        priorityQueue.insert(other, distTo[other]);
                    }
                }
                else {
                    drawIneligibleEdge(vertex, other, coordinates);
                }
            }
        }

        private void drawIneligibleEdge(int vertex1, int vertex2, Coordinate[] coordinates) {
            StdDraw.setPenRadius(0.005D);
            StdDraw.setPenColor(Color.LIGHT_GRAY);

            StdDraw.line(coordinates[vertex1].xCoordinate, coordinates[vertex1].yCoordinate,
                    coordinates[vertex2].xCoordinate, coordinates[vertex2].yCoordinate);
        }

        private void drawInitialEdges(EdgeWeighedGraph g, Coordinate[] coordinates) {
            StdDraw.setPenRadius(0.002D);
            StdDraw.setPenColor(Color.BLACK);
            for (int vertex = 0; vertex < g.vertices(); vertex++) {
                for(Edge edge: g.adjacent(vertex))
                {
                    int other = edge.other(vertex);
                    if(vertex > other)
                    {
                        StdDraw.line(coordinates[vertex].xCoordinate, coordinates[vertex].yCoordinate
                        , coordinates[other].xCoordinate, coordinates[other].yCoordinate);
                    }
                }

            }
            sleep();

        }

        private void sleep(){
            try {
                //Thread.sleep(100);
                Thread.sleep(3000); //用来观察
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        private void drawInitialVerticies(Coordinate[] coordinates) {
            for (int vertexId = 0; vertexId < coordinates.length; vertexId++) {
                StdDraw.setPenColor(Color.LIGHT_GRAY);
                StdDraw.filledCircle(coordinates[vertexId].xCoordinate, coordinates[vertexId].yCoordinate,radiusOfCircleAroundVertex);

                StdDraw.setPenColor(Color.BLACK);
                StdDraw.circle(coordinates[vertexId].xCoordinate, coordinates[vertexId].yCoordinate,radiusOfCircleAroundVertex);

                StdDraw.setPenColor(Color.BLACK);
                StdDraw.text(coordinates[vertexId].xCoordinate, coordinates[vertexId].yCoordinate,String.valueOf(vertexId));


            }

        }

        private void initCanvas(double xScaleLow, double xScaleHigh, double yScaleLow, double yScaleHigh) {
            StdDraw.setCanvasSize(1000, 1000);
            StdDraw.setXscale(xScaleLow, xScaleHigh);
            StdDraw.setYscale(xScaleLow, xScaleHigh);

        }

        private Coordinate[] getRandomCoordinates(EdgeWeighedGraph g) {

            Coordinate[] vertexCoordinates = new Coordinate[g.vertices()];
            for (int vertex = 0; vertex < g.vertices(); vertex++) {
                double randomXCoordinates = StdRandom.uniform(1000);
                double randomYCoordinates = StdRandom.uniform(1000);

                vertexCoordinates[vertex] = new Coordinate(randomXCoordinates, randomYCoordinates);
            }

            return vertexCoordinates;
        }
    }


    public static void main(String[] args) {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph g = new EdgeWeighedGraph(in);

        new Ex27_Animation().new PrimMSTAnimations(g, -1, 1001, 01 , 1001,15);

    }

}
