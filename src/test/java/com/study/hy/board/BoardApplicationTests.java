package com.study.hy.board;

import org.junit.jupiter.api.Test;

class BoardApplicationTests {

	@Test
	void contextLoads() {
		int currentPage = 2;
		int totalNumber = 20;
		int pageSize = 5;
		int offset = pageSize * (currentPage - 1);
		System.out.println(offset);
	}

}
