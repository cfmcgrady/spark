/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql

import java.util.concurrent.Executors

import org.apache.spark.SparkConf
import org.apache.spark.sql.test.SharedSQLContext

class ParserSuite extends QueryTest with TestContext {

  // scalastyle:off

  test("aa") {
    println("xxxxx")
    val sql =
      """
        |CREATE TEMPORARY VIEW kafkaTable
        |USING kafka
        |OPTIONS (
        |  kafka.bootstrap.servers "n1.cdh.host.dxy:9092,n2.cdh.host.dxy:9092,n5.cdh.host.dxy:9092",
        |  subscribe 'fchentest20190626'
        |)
      """.stripMargin
    val sql2 =
      """
        |CREATE TEMPORARY VIEW kafkaTable
        |USING kafka
        |OPTIONS (
        |  kafka.bootstrap.servers "192.168.0.109:9092",
        |  subscribe 'fchentest20190626'
        |)
      """.stripMargin
    spark.sql(sql2).explain(true)

    spark.sql("select 2").show()
    spark.sql("select * from kafkaTable").show()
    spark.sql("select 1").show()
  }
}
