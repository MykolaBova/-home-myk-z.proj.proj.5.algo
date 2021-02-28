

// https://carlosbf.medium.com/frequency-queries-solution-e776d6ac3aa6

vector<int> freqQuery(vector<vector<int>> queries) {

    int q;
    int type;
    int current_count;
    vector<int> query;
    vector<int> query_results;
    unordered_map<long, int> count_map;
    unordered_map<int, long> frequency_map;

    q = queries.size();

    for(int i =0 ; i < q ;i++){
        query = queries[ i ];
        type = query[0];
        switch(type){
            case 1:
                frequency_map[count_map[ query[1] ]]--;
                count_map[ query[1] ]++;
                frequency_map[count_map[ query[1] ]]++;
                break;
            case 2:
                current_count = count_map[ query[1] ];
                if(current_count > 0){
                    frequency_map[current_count]--;
                    count_map[ query[1] ]--;
                    frequency_map[count_map[ query[1] ]]++;
                }
                break;
            case 3:
                query_results.push_back(( frequency_map[query[1]] > 0 )? 1:0);
                break;
            default:
                break;
        }

    }
    return query_results;
}
