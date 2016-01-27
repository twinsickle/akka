/**
 * Copyright (C) 2015-2016 Typesafe Inc. <http://www.typesafe.com>
 */
package akka.persistence.query.javadsl

import akka.NotUsed
import akka.stream.javadsl.Source
import akka.persistence.query.EventEnvelope

/**
 * A plugin may optionally support this query by implementing this interface.
 */
trait CurrentEventsByTagQuery extends ReadJournal {

  /**
   * Same type of query as [[EventsByTagQuery#eventsByTag]] but the event stream
   * is completed immediately when it reaches the end of the "result set". Events that are
   * stored after the query is completed are not included in the event stream.
   */
  def currentEventsByTag(tag: String, offset: Long): Source[EventEnvelope, NotUsed]

}
