package me.bingbingpa.book.java_algorithm_interview.ch07

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class P11_ProductOfArrayExceptSelf {

    /**
     * 자신을 제외한 배열의 곱
     * Input: [1,3,5,7]
     * Output: [105,35,21,15]
     * @see <a href="https://leetcode.com/problems/product-of-array-except-self/"> https://leetcode.com/problems/product-of-array-except-self/
     */
    @MethodSource("getParameters")
    @ParameterizedTest
    fun `자신을 제외한 배열의 곱`(nums: IntArray, expected: IntArray) {
        //given & when
        val result = solution(nums)

        //then
        Assertions.assertThat(result).isEqualTo(expected)
    }

    private fun getParameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(24, 12, 8, 6),
            ),
            Arguments.of(
                intArrayOf(-1, 1, 0, -3, 3),
                intArrayOf(0, 0, 9, 0, 0),
            ),
        )
    }

    private fun solution(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var p = 1
        for (i in nums.indices) {
            result[i] = p
            p *= nums[i]
        }
        p = 1
        for (i in nums.indices.reversed()) {
            result[i] *= p
            p *= nums[i]
        }
        return result
    }
}