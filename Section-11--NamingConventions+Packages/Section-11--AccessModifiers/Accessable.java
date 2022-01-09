public interface Accessable {
//    Challenge:
//    In the following interface declaration, what is the visibility of:
//
//    1. the Accessible interface? - all classes in the current package/program
//    2. the int variable SOME_CONSTANT? - all interface variables are public static final so the value is public
//    3. methodA? public because it is "**public** void methodA();"
//    4. methodB and methodC? - all interface methods are automatically public
//
//    Hint: think back to the lecture on interfaces before answering

    interface Accessible {
        int SOME_CONSTANT = 100;

        public void methodA();

        void methodB();

        boolean methodC();
    }
}
