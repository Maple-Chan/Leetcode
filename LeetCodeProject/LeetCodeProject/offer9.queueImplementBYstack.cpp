//#define QUEUE_IMPLEMENT_BY_STACK

#ifdef QUEUE_IMPLEMENT_BY_STACK


/*
 * @lc app=leetcode.cn id=232 lang=cpp
 *
 * [232] ?????????
 */

 // @lc code=start

#include <stack>
#include <iostream>
using namespace std;


class QueueEmptyException {
public:
	const char* ExceptionMessage()const throw() {
		return "Queue is empty!";
	}
};

/**
 *
 * 17/17 cases passed (4 ms)
 * Your runtime beats 67.97 % of cpp submissions
 * Your memory usage beats 5.51 % of cpp submissions (9.1 MB)
 *
*/

class MyQueue {
public:
	/** Initialize your data structure here. */
	MyQueue() {

	}

	/** Push element x to the back of queue. */
	void push(int x) {
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	int pop() {
		int ret = 0;
		if (!stack2.empty()) {
			ret = stack2.top();
			stack2.pop();
		}
		else
		{
			if (stack1.empty()) {
				throw QueueEmptyException();
			}
			else
			{
				while (!stack1.empty())
				{
					/* code */
					stack2.push(stack1.top());
					stack1.pop();
				}
				ret = stack2.top();
				stack2.pop();
			}
		}

		return ret;

	}

	/** Get the front element. */
	int peek() {
		int ret = 0;
		if (!stack2.empty()) {
			ret = stack2.top();
		}
		else
		{
			if (stack1.empty()) {
				throw QueueEmptyException();
			}
			else
			{
				while (!stack1.empty())
				{
					/* code */
					stack2.push(stack1.top());
					stack1.pop();
				}
				ret = stack2.top();
			}
		}
		return ret;

	}

	/** Returns whether the queue is empty. */
	bool empty() {
		if (stack1.empty() && stack2.empty()) {
			return true;
		}
		return false;
	}

private:
	stack<int> stack1;
	stack<int> stack2;


};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
 // @lc code=end

int main() {

	MyQueue queue;
	try
	{
		queue.push(1);
		queue.push(2);
		cout << queue.peek() <<endl;  // ???? 1
		cout << queue.pop() << endl;  // ???? 1
		cout << queue.pop() << endl;  // ???? 2
		cout << queue.pop() << endl;  // ???? 2
		cout << queue.empty() << endl; // ???? false
	}
	catch (const QueueEmptyException& e)
	{
		std::cerr << e.ExceptionMessage() << '\n';
	}

	return 0;
}



#endif // QUEUE_IMPLEMENT_BY_STACK