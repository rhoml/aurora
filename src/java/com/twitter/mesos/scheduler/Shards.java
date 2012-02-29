package com.twitter.mesos.scheduler;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import com.twitter.mesos.gen.TwitterTaskInfo;
import com.twitter.mesos.gen.storage.TaskUpdateConfiguration;

/**
 * Utility class for dealing with individual shards of a job.
 *
 * @author William Farner
 */
public final class Shards {

  private Shards() {
    // Utility.
  }

  /**
   * Gets the original task configuration for a shard update.  Result may be null if the update
   * adds the shard.
   */
  public static final Function<TaskUpdateConfiguration, TwitterTaskInfo> GET_ORIGINAL_CONFIG =
      new Function<TaskUpdateConfiguration, TwitterTaskInfo>() {
        @Nullable
        @Override public TwitterTaskInfo apply(TaskUpdateConfiguration updateConfig) {
          return updateConfig.getOldConfig();
        }
      };

  /**
   * Gets the updated task configuration for a shard update.  Result may be null if the update
   * removes the shard.
   */
  public static final Function<TaskUpdateConfiguration, TwitterTaskInfo> GET_NEW_CONFIG =
      new Function<TaskUpdateConfiguration, TwitterTaskInfo>() {
        @Nullable
        @Override public TwitterTaskInfo apply(TaskUpdateConfiguration updateConfig) {
          return updateConfig.getNewConfig();
        }
      };
}
