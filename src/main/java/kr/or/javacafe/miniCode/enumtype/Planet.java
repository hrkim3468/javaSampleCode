package kr.or.javacafe.miniCode.enumtype;

public enum Planet {
	
	MERCURY(3.302e+23, 2.439e6), 
	VENUS(4.869e+24, 6.052e6), 
	EARTH(5.975e+24, 6.378e6), 
	MARS(6.419e+23, 3.393e6), 
	JUPITER(1.899e+27, 7.149e7), 
	SATURN(5.685e+26, 6.027e7), 
	URANUS(8.683e+25, 2.556e7), 
	NEPTUNE(1.024e+26, 2.477e7);
	
	// 생성자 (Enum은 불변객체이므로 Enum에 설정된 값을 맵핑하려면 생성자가 필요하다.)
	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		surfaceGravity = G * mass / (radius * radius);
	}

	// 멤버변수
	private final double mass; 				// In kilograms
	private final double radius; 			// In meters
	private final double surfaceGravity; 	// In m / s^2

	// 만유인력 상수 (m^3 / kg s^2)
	private static final double G = 6.67300E-11;


	public double mass() {
		return mass;
	}

	public double radius() {
		return radius;
	}

	public double surfaceGravity() {
		return surfaceGravity;
	}

	public double surfaceWeight(double mass) {
		return mass * surfaceGravity; // F = ma
	}
}

