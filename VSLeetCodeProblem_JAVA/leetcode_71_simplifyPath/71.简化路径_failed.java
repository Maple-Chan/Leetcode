package leetcode_71_simplifyPath;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class SolutionFailed {
    public String simplifyPath(String path) {
        char[] pathCharArray = path.toCharArray();
        StringBuffer sBuffer = new StringBuffer();
        Stack<String> stackDir = new Stack<>();



        if(pathCharArray[0] != '/'){
            sBuffer.append("/");
            return sBuffer.toString();
        }

        int passIndex = 0;
        StringBuffer tempBuffer = new StringBuffer();
        boolean isDotDirName = false;
        while(passIndex < pathCharArray.length){
            if(passIndex == 14){
                System.out.println(14);
            }
            
            if(pathCharArray[passIndex] <= 'z' && pathCharArray[passIndex] >= 'a' 
                    || pathCharArray[passIndex] != '/'
                    ){
                tempBuffer.append(pathCharArray[passIndex]);
            }
            else{
                

                stackDir.push(tempBuffer.toString());
                tempBuffer.delete(0, tempBuffer.length());
                if(stackDir.size() > 0 &&  stackDir.peek().equals("")){
                    stackDir.pop();
                }

                if(pathCharArray[passIndex] == '/'){

                    if(isDotDirName){
                        String s = stackDir.pop();
                        stackDir.push(s+tempBuffer.toString());
                    }

                    isDotDirName = false;

                    if(stackDir.size() > 0 && stackDir.peek().equals(".")){
                        stackDir.pop();
                        // stackDir.push(new String("/"));
                    }
                    else if(stackDir.size() > 0 &&  !stackDir.peek().equals("/")){
                        stackDir.push(new String("/"));
                    }
                    else if(stackDir.size() ==  0){
                        stackDir.push(new String("/"));
                    }
                }
                else if(pathCharArray[passIndex] == '.'){
                    if(stackDir.peek().length()>= 2 && stackDir.peek().contains(".")){
                        String s = stackDir.pop();
                        stackDir.push(s+".");
                        passIndex++;
                        continue;
                    }


                    if(stackDir.size() > 0 && !stackDir.peek().contains(".")){
                        stackDir.push(new String("."));
                        if(passIndex+1 < pathCharArray.length && pathCharArray[passIndex+1] != '/'){
                            isDotDirName= true;
                        }
                    }
                    else{
                        if(passIndex+1 < pathCharArray.length && pathCharArray[passIndex+1] != '/') {
                            String s = stackDir.pop();
                            stackDir.push(s+".");
                            passIndex++;
                            isDotDirName = true;
                            continue;
                        }


                        stackDir.pop();
                        if(stackDir.size() > 2){
                            stackDir.pop();
                            stackDir.pop();
                        }
                    }
                }
            }

            passIndex++;
        }


        if(isDotDirName && tempBuffer.length() > 0){
            String s = stackDir.pop(); 
            stackDir.push(s+tempBuffer.toString());
        }else if(tempBuffer.length() > 0) {
            stackDir.push(tempBuffer.toString());
        }

        if(stackDir.size() > 1 && (stackDir.peek().equals("/") || stackDir.peek().equals(".") )){
            stackDir.pop();
        }
        
        
        for (String string : stackDir) {
            // if(string.contains(".")){
            //     string.replaceFirst(".", "");
            // }
            sBuffer.append(string);
        }
        // sBuffer.reverse();


        return sBuffer.toString();
    }



    public static void main(String[] args) {
     
        SolutionFailed solution  = new SolutionFailed();

        String ret = solution.simplifyPath("/home/");

        System.out.println(ret);

    }
}
// @lc code=end

