public class ManualTimer {
    private Timer dub_timer;
    private int counter = 600;
    private JLabel label;

    public ManualTimer(JLabel label1) {
        this.label = label1;
        dub_timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counter--;
                if (counter >= 0) {
                    label.setText("Time left: " + counter + " seconds");
                } else {
                    dub_timer.stop(); // ✅ FIXED: use the correct variable name
                    label.setText("Time's up!");
                }
            }
        });
    }

    public void start() {
        dub_timer.start(); // optional start method
    }

    public void stop() {
        dub_timer.stop(); // optional stop method
    }
}
