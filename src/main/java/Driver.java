
public class Driver {

    public static void main(String[] args) throws Exception {

        UnitMultiplication multiplication = new UnitMultiplication();
        UnitSum sum = new UnitSum();

        //args0: dir of transition.txt
        //args1: dir of PageRank.txt
        //args2: dir of unitMultiplication result
        //args3: times of convergence
        //run MR1, MR2
        //iteration
        //MR1: transition.txt pr.txt -> multiplication.txt
        //MR2: multiplication.txt -> pr1.txt
        //MR1: transition.txt pr1.txt -> mutiplication1.txt
        //MR2: multiplication.txt -> pr2.txt
        //hadoop jar mr.jar /int /out....
        String transitionMatrix = args[0];
        String prMatrix = args[1];
        String unitState = args[2];
        int count = Integer.parseInt(args[3]);
        for(int i=0;  i<count;  i++) {
            String[] args1 = {transitionMatrix, prMatrix+i, unitState+i};
            multiplication.main(args1);
            String[] args2 = {unitState + i, prMatrix+(i+1)};
            sum.main(args2);
        }
    }
}
