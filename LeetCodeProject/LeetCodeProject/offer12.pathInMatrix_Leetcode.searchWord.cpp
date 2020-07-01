//#define PATH_IN_MATRIX
#ifdef PATH_IN_MATRIX


/*
 * @lc app=leetcode.cn id=79 lang=cpp
 *
 * [79] ��������
 */

 // @lc code=start

#include <vector>
#include <iostream>
#include <string>
using namespace std;

/**
 * ˼·�����ݷ���
 *
*/

/*

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

���� word = "ABCCED", ���� true.
���� word = "SEE", ���� true.
���� word = "ABCB", ���� false.

*/
class Solution {
public:
	bool exist(vector<vector<char>>& board, string word) {


		size_t index = 0;
		size_t row = board.size();
		size_t col = board[0].size();

		// ��ʼ��visited����
		vector<bool> init_visited(col, false);
		vector<vector<bool>> visited(row, init_visited);

		bool haspath = false;

		for (int i = 0; i < row; ++i) {

			for (int j = 0; j < col; ++j) {
				haspath = findWordCore(board, visited, row, col, word, 0, i, j);
				if(haspath)
					return true;
			}
		}


		return haspath;
	}

	bool findWordCore(
		vector<vector<char>>& board,
		vector<vector<bool>>& visited,
		size_t rowtotal,
		size_t coltotal,
		string word,
		size_t& next_IndexInWord,
		size_t next_row,
		size_t next_col) {

		if (next_IndexInWord == word.size()) {
			return true;
		}

		bool hasPath = false;
		if (
			next_row < rowtotal &&
			next_col < coltotal &&
			board[next_row][next_col] == word[next_IndexInWord] &&
			!visited[next_row][next_col]) {
			++next_IndexInWord;

			visited[next_row][next_col] = true;

			hasPath = findWordCore(
				board,
				visited,
				rowtotal,
				coltotal,
				word,
				next_IndexInWord,
				next_row,
				next_col - 1
			) || findWordCore(
				board,
				visited,
				rowtotal,
				coltotal,
				word,
				next_IndexInWord,
				next_row,
				next_col + 1
			) || findWordCore(
				board,
				visited,
				rowtotal,
				coltotal,
				word,
				next_IndexInWord,
				next_row - 1,
				next_col
			) || findWordCore(
				board,
				visited,
				rowtotal,
				coltotal,
				word,
				next_IndexInWord,
				next_row + 1,
				next_col
			);

			if (!hasPath)
			{
				/* code */
				--next_IndexInWord;
				visited[next_row][next_col] = false;
			}

		}
		// �Żص�ǰ�ӽڵ������Ƿ����·��
		return hasPath;

	}

};
// @lc code=end


int main()
{

	vector<vector<char>> board= {
		{'A','B','C','E'},
		{'S','F','C','S'},
		{'A','D','E','E'}
	};
	string word = "ABCCED";


	Solution so;

	bool path =	so.exist(board, word);

	if (path) {
		cout << "true" << endl;
	}
	else {
		cout << "false" << endl;
	}


	return 0;
}

#endif // PATH_IN_MATRIX