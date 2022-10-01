import java.util.Stack;
public class HanoiTower {
    static Stack<Integer> A = new Stack<Integer>();
    static Stack<Integer> B = new Stack<Integer>();
    static Stack<Integer> C = new Stack<Integer>();
    public static void main(String[] args) {
        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);
        System.out.println(A);
        hanoi(A.size(), A, B, C);
    }
    // Hanoi tower is a mapping of p:N => S, where N is natural number, and S is a sequence of operation
    // (Yes, this can be interpret as a recursive defined sequencece)
    // S is the permutation/elements in S3 group: permutations of 3 distinct elements
    // it has the pattern of
    // p(1)= 1 (permutation for disk 1)= 1 to 3(from rod 1 to rod 3),
    // p(2)= 1,2,1 = (1 to 2), (1 to 3), (2 to 3)
    // p(3)=1,2,1,3,1,2,1 = 1 to 3, 1 to 2, 3 to 2, 1 to 3, 2 to 1, 2 to 3, 1 to 3
    // Notice that permutation of even number of elements is distinct from permutation of odd number of elements, so the operation must switch everytime
    // p(4) = 1,2,1,3,1,2,1,4,... =(1 to 2),(1 to 3),(2 to 1),...
    // once we perform permutation p reach n-1, we perform (1,3) and then we start doing a sequence of similar permutation:
    // p(n) = p(n-1)(1,3)g(n-1)),     from the equation in the left, we see that this operation is consist of 3 parts
    // where p(n-1) recursively move item from rod 1 to rod 2, (1,3) move the last item from rod 1 to rod 3
    // and g(n-1) recursively move item from rod 2 to rod 3
    // we actually did a permutation for every thing from rod 1 to rod 3
    // the computation of permutation is from right to left as the way matrix operation works
    // (1,2)(1,3)(2,3)= (from rod 3 to 2, then rod 3 to 1, and from rod 2 to 1)=(1,3) permutation
    public static void hanoi(int height, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> holder) {
        if (height>0){
            // when height > 0, go all the way to height = 0
            // h = 0 does nothing since there is nothing for permutation
            // notice each time we get (2,3) permutation of rod, if h = 1 (odd), send disk from rod 1 to rod 3.
            // then we start h = 2(even), send disk from rod 1 to rod 2. another (2,3) permutation
            // p(n-1) switch rod 2 to rod 3
            hanoi(height-1, source, holder, destination);
            destination.push(source.pop());
            System.out.println("==========");
            System.out.println(A);//
            System.out.println(C);//
            System.out.println(B);// 
            System.out.println();
            // g(n-1) switch rod 2 to rod 3
            hanoi(height-1,holder,destination,source);
        }
    }
}