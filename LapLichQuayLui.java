import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Activity {
    int start, finish;
    public Activity() {
    }

    public Activity(int start, int finish) {
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }

}
class LapLichQuayLui{
    private static List<Activity> activity;
    private static LinkedList<Activity> actResult = new LinkedList<>();

    private static void init() {
        activity = new ArrayList<>();
        activity.add(new Activity(5, 9));
        activity.add(new Activity(1, 2));
        activity.add(new Activity(3, 4));
        activity.add(new Activity(0, 6));
        activity.add(new Activity(5, 7));
        activity.add(new Activity(8, 9));
    }

    public static void lapLich() {
        for (int i = 0; i <= activity.size(); i++) {
            for (int j = 0; j <= activity.size(); i++) {
                if (activity.get(j).getFinish() + 1 < activity.get(i).getStart() || activity.get(j).getStart() > activity.get(i).getFinish() + 1) {
                    actResult.add(activity.get(j));
                }
            }
        }

    }
}
