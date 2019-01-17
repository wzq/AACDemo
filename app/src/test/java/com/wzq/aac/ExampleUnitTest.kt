package com.wzq.aac

import org.junit.Test
import kotlin.random.Random

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)

        val ranges = arrayListOf<Range>()
        ranges.add(Range(7, 15, 20)) //yellow

        ranges.add(Range(6, 12, 17)) //green
        ranges.add(Range(3, 9, 29)) //blue
        ranges.add(Range(2, 6, 7))

        random(550, ranges)
    }



    val result = arrayListOf<List<Int>>()
    fun random(total: Int, range: List<Range>){
        val once = arrayListOf<Int>()
        range.forEach {
            if(it.time > 0){
                once.add(Random.nextInt(it.a, it.b))
                it.time = it.time -1
            }else
                once.add(0)
        }


        val onceTotal = once.sum()

        if (onceTotal == 0) {
            showResult(result)
            return
        }


        if (onceTotal > total) {
            showResult(result)
        }else {
            result.add(once)
            random(total-onceTotal, range)
        }
    }

    fun showResult(data: List<List<Int>>){
        var sum = 0
        data.forEach {
            sum += it.sum()
            println(it.toString())
        }
        println(sum)
    }

    data class Range(
            val a:Int,
            val b:Int,
            var time: Int
    )
}
