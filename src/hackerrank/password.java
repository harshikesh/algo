package hackerrank;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 20/03/17.
 */
public class password {

        static char vowel[] = {'a','e','i','o','u','y'};
        static char cons[] = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            generatePassword(n);
        }
        static void generatePassword(int n){
            if(n == 1){
                for(int i=0; i<vowel.length;i++){
                    System.out.println(vowel[i]);
                }
                for(int i=0; i<cons.length;i++){
                    System.out.println(cons[i]);
                }
            }
            if(n==2){
                for(int i=0; i<vowel.length;i++){
                    for(int j=0; j<cons.length;j++){
                        System.out.println(""+vowel[i]+""+cons[j]);
                    }
                }
                for(int i=0; i<cons.length;i++){
                    for(int j=0; j<vowel.length;j++){
                        System.out.println(""+cons[i]+""+vowel[j]);
                    }
                }
            }
            if(n==3){
                for(int i=0; i<vowel.length;i++){
                    for(int j=0; j<cons.length;j++){
                        for(int k=0; k<vowel.length;k++){
                            System.out.println(""+vowel[i]+""+cons[j]+""+vowel[k]);
                        }
                    }
                }
                for(int i=0; i<cons.length;i++){
                    for(int j=0; j<vowel.length;j++){
                        for(int k=0; k<cons.length;k++){
                            System.out.println(""+cons[i]+""+vowel[j]+""+cons[k]);
                        }
                    }
                }
            }
            if(n==4){
                for(int i=0; i<vowel.length;i++){
                    for(int j=0; j<cons.length;j++){
                        for(int k=0; k<vowel.length;k++){
                            for(int l=0; l<cons.length;l++){
                                System.out.println(""+vowel[i]+""+cons[j]+""+vowel[k]+""+cons[l]);
                            }
                        }
                    }
                }
                for(int i=0; i<cons.length;i++){
                    for(int j=0; j<vowel.length;j++){
                        for(int k=0; k<cons.length;k++){
                            for(int l=0; l<vowel.length;l++){
                                System.out.println(""+cons[i]+""+vowel[j]+""+cons[k]+""+vowel[l]);
                            }
                        }
                    }
                }
            }
            if(n==5){
                for(int i=0; i<vowel.length;i++){
                    for(int j=0; j<cons.length;j++){
                        for(int k=0; k<vowel.length;k++){
                            for(int l=0; l<cons.length;l++){
                                for(int m=0; m<vowel.length;m++){
                                    System.out.println(""+vowel[i]+""+cons[j]+""+vowel[k]+""+cons[l]+""+vowel[m]);
                                }
                            }
                        }
                    }
                }
                for(int i=0; i<cons.length;i++){
                    for(int j=0; j<vowel.length;j++){
                        for(int k=0; k<cons.length;k++){
                            for(int l=0; l<vowel.length;l++){
                                for(int m=0; m<cons.length;m++){
                                    System.out.println(""+cons[i]+""+vowel[j]+""+cons[k]+""+vowel[l]+""+cons[m]);
                                }
                            }
                        }
                    }
                }
            }
            if(n==6){
                for(int i=0; i<vowel.length;i++){
                    for(int j=0; j<cons.length;j++){
                        for(int k=0; k<vowel.length;k++){
                            for(int l=0; l<cons.length;l++){
                                for(int m=0; m<vowel.length;m++){
                                    for(int o=0; o<cons.length;o++){
                                        System.out.println(""+vowel[i]+""+cons[j]+""+vowel[k]+""+cons[l]+""+vowel[m]+cons[o]);
                                    }
                                }
                            }
                        }
                    }
                }
                for(int i=0; i<cons.length;i++){
                    for(int j=0; j<vowel.length;j++){
                        for(int k=0; k<cons.length;k++){
                            for(int l=0; l<vowel.length;l++){
                                for(int m=0; m<cons.length;m++){
                                    for(int o=0; o<vowel.length;o++){
                                        System.out.println(""+cons[i]+""+vowel[j]+""+cons[k]+""+vowel[l]+""+cons[m]+""+vowel[o]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
}
