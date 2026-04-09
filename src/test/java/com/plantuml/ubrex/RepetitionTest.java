package com.plantuml.ubrex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RepetitionTest {

	// ========== Exact {n} ==========

	@Test
	public void testExact6_match() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("he〇{6}lo");
		assertEquals("hellllllo", cut.match(TextNavigator.build("hellllllo")).getAcceptedMatch());
	}

	@Test
	public void testExact6_noMatch() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("he〇{6}lo");
		assertEquals("", cut.match(TextNavigator.build("helllllo")).getAcceptedMatch());
	}

	@Test
	public void testExact2() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{2}a");
		assertTrue(cut.match("aa").exactMatch());
		assertFalse(cut.match("a").exactMatch());
		assertFalse(cut.match("aaa").exactMatch());
	}

	@Test
	public void testExactMultiDigit() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{12}x");
		final String twelve = "xxxxxxxxxxxx";
		assertTrue(cut.match(twelve).exactMatch());
		assertFalse(cut.match(twelve + "x").exactMatch());
		assertFalse(cut.match(twelve.substring(1)).exactMatch());
	}

	// ========== Range {m-n} ==========

	@Test
	public void testRange1to3() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{1-3}aZ");
		assertTrue(cut.match("aZ").exactMatch());
		assertTrue(cut.match("aaZ").exactMatch());
		assertTrue(cut.match("aaaZ").exactMatch());
		assertFalse(cut.match("Z").exactMatch());
		assertFalse(cut.match("aaaaZ").exactMatch());
	}

	@Test
	public void testRange2to2() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{2-2}a");
		assertTrue(cut.match("aa").exactMatch());
		assertFalse(cut.match("a").exactMatch());
		assertFalse(cut.match("aaa").exactMatch());
	}

	// ========== Min or more {n+} ==========

	@Test
	public void testMinOrMore2() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{2+}aZ");
		assertFalse(cut.match("aZ").exactMatch());
		assertTrue(cut.match("aaZ").exactMatch());
		assertTrue(cut.match("aaaZ").exactMatch());
		assertTrue(cut.match("aaaaaZ").exactMatch());
	}

	@Test
	public void testMinOrMore1() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{1+}b");
		assertTrue(cut.match("b").exactMatch());
		assertTrue(cut.match("bb").exactMatch());
		assertTrue(cut.match("bbbbb").exactMatch());
		assertFalse(cut.match("").exactMatch());
	}

	// ========== Combined {m;n;...} ==========

	@Test
	public void testCombinedExact() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{1;3;5}xZ");
		assertTrue(cut.match("xZ").exactMatch());
		assertFalse(cut.match("xxZ").exactMatch());
		assertTrue(cut.match("xxxZ").exactMatch());
		assertFalse(cut.match("xxxxZ").exactMatch());
		assertTrue(cut.match("xxxxxZ").exactMatch());
	}

	@Test
	public void testCombinedRangeAndMore() {
		// 2 times, or 4 to 6 times, or 8+ times
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{2;4-6;8+}aZ");
		assertFalse(cut.match("aZ").exactMatch());
		assertTrue(cut.match("aaZ").exactMatch());
		assertFalse(cut.match("aaaZ").exactMatch());
		assertTrue(cut.match("aaaaZ").exactMatch());
		assertTrue(cut.match("aaaaaZ").exactMatch());
		assertTrue(cut.match("aaaaaaZ").exactMatch());
		assertFalse(cut.match("aaaaaaaZ").exactMatch());
		assertTrue(cut.match("aaaaaaaaZ").exactMatch());
		assertTrue(cut.match("aaaaaaaaaaZ").exactMatch());
	}

	// ========== Repetition.parse + match unit tests ==========

	@Test
	public void testParseExact() {
		final Repetition rep = Repetition.parse(TextNavigator.build("3}"));
		assertTrue(rep.match(3));
		assertFalse(rep.match(2));
		assertFalse(rep.match(4));
	}

	@Test
	public void testParseMultiDigitExact() {
		final Repetition rep = Repetition.parse(TextNavigator.build("15}"));
		assertTrue(rep.match(15));
		assertFalse(rep.match(1));
		assertFalse(rep.match(5));
		assertFalse(rep.match(14));
	}

	@Test
	public void testParseRange() {
		final Repetition rep = Repetition.parse(TextNavigator.build("2-5}"));
		assertFalse(rep.match(1));
		assertTrue(rep.match(2));
		assertTrue(rep.match(3));
		assertTrue(rep.match(4));
		assertTrue(rep.match(5));
		assertFalse(rep.match(6));
	}

	@Test
	public void testParseMinOrMore() {
		final Repetition rep = Repetition.parse(TextNavigator.build("3+}"));
		assertFalse(rep.match(2));
		assertTrue(rep.match(3));
		assertTrue(rep.match(4));
		assertTrue(rep.match(100));
	}

	@Test
	public void testParseCombined() {
		final Repetition rep = Repetition.parse(TextNavigator.build("1;5;4-6}"));
		assertTrue(rep.match(1));
		assertFalse(rep.match(2));
		assertFalse(rep.match(3));
		assertTrue(rep.match(4));
		assertTrue(rep.match(5));
		assertTrue(rep.match(6));
		assertFalse(rep.match(7));
	}

	@Test
	public void testParseCombinedWithMore() {
		final Repetition rep = Repetition.parse(TextNavigator.build("2;4-6;8+}"));
		assertFalse(rep.match(0));
		assertFalse(rep.match(1));
		assertTrue(rep.match(2));
		assertFalse(rep.match(3));
		assertTrue(rep.match(4));
		assertTrue(rep.match(5));
		assertTrue(rep.match(6));
		assertFalse(rep.match(7));
		assertTrue(rep.match(8));
		assertTrue(rep.match(9));
		assertTrue(rep.match(50));
	}

	// ========== With character sets ==========

	@Test
	public void testRangeWithCharSet() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{1-2}「ab」Z");
		assertTrue(cut.match("aZ").exactMatch());
		assertTrue(cut.match("bZ").exactMatch());
		assertTrue(cut.match("abZ").exactMatch());
		assertTrue(cut.match("baZ").exactMatch());
		assertFalse(cut.match("aabZ").exactMatch());
		assertFalse(cut.match("cZ").exactMatch());
	}

	@Test
	public void testRangeWithDigitClass() {
		UnicodeBracketedExpression cut = UnicodeBracketedExpression.build("〇{1-4}〴d");
		assertTrue(cut.match("1").exactMatch());
		assertTrue(cut.match("12").exactMatch());
		assertTrue(cut.match("123").exactMatch());
		assertTrue(cut.match("1234").exactMatch());
		assertFalse(cut.match("12345").exactMatch());
		assertFalse(cut.match("").exactMatch());
	}

}
