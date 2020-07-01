/*
 * @lc app=leetcode.cn id=225 lang=cpp
 *
 * [225] 用队列实现栈
 */

// @lc code=start

#include <queue>
#include <iostream>
using namespace std;


/**
 * 16/16 cases passed (4 ms)
 * Your runtime beats 66.81 % of cpp submissions
 * Your memory usage beats 5.12 % of cpp submissions (9 MB)
 * 
*/
class StackEmptyException {
public:
	const char* ExceptionMessage()const throw() {
		return "Stack is empty!";
	}
};



class MyStack {
public:
    /** Initialize your data structure here. */
    MyStack() {
        is1Top = true;
    }
    
    /** Push element x onto stack. */
    void push(int x) {

        if(is1Top){
            queue1.push(x);
        }
        else
        {
            queue2.push(x);
        }
        
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        if(empty())
            throw StackEmptyException();

        int retpop = 0;
        if(is1Top){
            while (queue1.size() > 1)
            {
                /* code */
                queue2.push(queue1.front());
                queue1.pop();
            }
            if (queue1.size() == 1)
            {
                retpop=queue1.front();
                queue1.pop();
            }
            is1Top = !is1Top;
        }else
        {
            /* code */
            while (queue2.size() > 1)
            {
                /* code */
                queue1.push(queue2.front());
                queue2.pop();
            }
            if (queue2.size() == 1)
            {
                retpop=queue2.front();
                queue2.pop();
            }
            is1Top = !is1Top; // 
        }
        return retpop;   
    }
    
    /** Get the top element. */
    int top() {
                if(empty())
            throw StackEmptyException();

        int retpop = 0;
        if(is1Top){
            while (queue1.size() > 1)
            {
                /* code */
                queue2.push(queue1.front());
                queue1.pop();
            }
            if (queue1.size() == 1)
            {
                retpop=queue1.front();
            }
            is1Top != is1Top;
        }else
        {
            /* code */
            while (queue2.size() > 1)
            {
                /* code */
                queue1.push(queue2.front());
                queue2.pop();
            }
            if (queue2.size() == 1)
            {
                retpop=queue2.front();
            }
            is1Top != is1Top;
        }
        return retpop;   
    }
    
    /** Returns whether the stack is empty. */
    bool empty() {
        if(queue1.size() == 0 && queue2.size()== 0){
            return  true;
        }
        return false;
    }

private:
    queue<int> queue1;
    queue<int> queue2;
    bool is1Top; // 如果true 说明需要从queue1当中获取最新的栈顶。
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */
// @lc code=end


int main(){
    MyStack stack;
    try
    {
        stack.push(1);
        stack.push(2);  
        stack.push(3);  
        stack.push(4);  
        stack.push(5);  
        stack.push(6);  
        stack.push(7);  

        cout << stack.pop() <<endl;  // 返回 2
        cout << stack.pop() <<endl;   // 返回 2
        cout << stack.pop() <<endl;   // 返回 1
        cout << stack.pop() <<endl;   // 返回 2
        cout << stack.pop() <<endl;   // 返回 1
        cout << stack.pop() <<endl;   // 返回 2
        cout << stack.pop() <<endl;   // 返回 1
        cout <<" is empty:"<< stack.empty(); // 返回 false
    }
    catch(const StackEmptyException& e)
    {
        std::cerr << e.ExceptionMessage() << '\n';
    }

    return 0;
}
