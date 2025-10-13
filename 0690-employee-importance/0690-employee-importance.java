/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idMapping = new HashMap<>();
        for (Employee employee : employees) {
            idMapping.put(employee.id, employee);
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        int total_importance = 0;
        total_importance += idMapping.get(id).importance;
        queue.offer(idMapping.get(id).subordinates);

        while(!queue.isEmpty()){
            List<Integer> sub = queue.poll();
            for (Integer _subordinate : sub) {
                total_importance += idMapping.get(_subordinate).importance;
                if (idMapping.get(_subordinate) != null) {
                    queue.offer(idMapping.get(_subordinate).subordinates );
                }
            }
        }
        return total_importance;
    }
}