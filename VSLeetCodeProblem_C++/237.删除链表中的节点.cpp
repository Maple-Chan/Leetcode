/*
 * @lc app=leetcode.cn id=237 lang=cpp
 *
 * Accepted
 * 41/41 cases passed (16 ms)
 * Your runtime beats 37.36 % of cpp submissions
 * Your memory usage beats 5.03 % of cpp submissions (9.5 MB)
 * 
 * [237] 删除链表中的节点
 */
#include <iostream>
using namespace std;
 struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };
// @lc code=start


// Definition for singly-linked list.
class mException
{
private:
    /* data */
    string message;
public:
    mException(string message/* args */);
    ~mException();

    string getMessage()const{
        return message;
    }
};

mException::mException(string message/* args */)
{
    this->message = message;
}

mException::~mException()
{
}



/*
    思路，只给了当前节点，将后续数据往前移动，删除最后一个节点就行
*/
class Solution {
public:
    void deleteNode(ListNode* node) {
        if( node == NULL){
            throw mException("Exceptiong of NULL Node");
            return;
        }
        ListNode *ptr = node, *pre = ptr;
        
        while (ptr->next != NULL)
        {
            /* code */
            ptr->val = ptr->next->val;
            pre = ptr;
            ptr = ptr->next;
        }
        
        pre->next = NULL;

        ptr->next = ptr;
        delete ptr;
        ptr = NULL;

    }
};
// @lc code=end


int main(){
    Solution so;
    ListNode* node = NULL;
    try
    {
        /* code */
        so.deleteNode(node);


    }
    catch(const mException e)
    {
        std::cerr << e.getMessage() << '\n';
    }
    


    return 0;
}