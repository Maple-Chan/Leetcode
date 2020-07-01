#define offer6
#ifdef offer6

 #include <vector>
 #include <stack>
 #include <iostream>
 using namespace std;


 /*
	 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

 /**
 *
 */


 struct ListNode {
         int val;
         struct ListNode *next;
         ListNode(int x) :
               val(x), next(NULL) {
         }
  };

 class Solution {
 public:
     /**
      * 遍历链表，把每个元素存入数组中，最后放入vector当中
      * 
     */
     vector<int> printListFromTailToHead(ListNode* head) {

		 ListNode* curptr = head;
		 stack<ListNode*> list2stack;
		 vector<int> retvector;

		 if (curptr == NULL) {
			 /*抛出异常。。。*/
			 return retvector;
		 }


		 list2stack.push(curptr);
         while (curptr->next != NULL)
         {
             /* code */
             list2stack.push(curptr->next);
             curptr = curptr->next;
         }

         while (!list2stack.empty())
         {
			 /* code */
             int data = list2stack.top()->val;list2stack.pop();
             retvector.push_back(data);
             
         }
		 //vector<int>::iterator itr;
		 //for(itr = retvector.begin();itr != retvector.end();++itr)
		 //{
			// cout << *(itr) << endl;
		 //}

         return retvector;
     }

     ListNode* createList(vector<int> vec){
         if(vec.empty()){
             return nullptr;
         }

         size_t sizevec = vec.size();
         int passData = 0;
         ListNode* Head = new ListNode(vec[passData]);
         ListNode* curptr = Head;
         passData ++ ;


         ListNode* newNode = nullptr;
         while (passData < sizevec)
         {
             /* code */
             newNode = new ListNode(vec[passData]);
             curptr->next = newNode;
             curptr = newNode;
			 passData++;
         }
         return Head;
     }
 };


 /*
     测试函数
 */
 int main(){
     vector<int> vec = {2,3,5,7,10,4,5};
     Solution so;
     ListNode* head = so.createList(vec);

	 so.printListFromTailToHead(head);

	 // 显示链表数据
     ListNode* cur = head;
     cout << head->val<<endl;
     while (cur->next != NULL)
     {
         /* code */
         cout << cur->next->val << endl;
         cur = cur->next;
     }

	 system("pause");


     return 0;
 }


#endif offer6