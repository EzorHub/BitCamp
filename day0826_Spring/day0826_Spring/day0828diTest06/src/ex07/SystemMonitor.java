package ex07;

public class SystemMonitor {

	private int periodTime;

	public void setPeriodTime(int periodTime) {
		this.periodTime = periodTime;
	}

	public void monitor() {
		System.out.println(periodTime + "분 간격으로 모니터링합니다.");

	}

}
