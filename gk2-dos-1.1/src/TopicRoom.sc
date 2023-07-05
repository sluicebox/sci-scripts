;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use TopicPrint)
(use Cursor)
(use System)

(class TopicRoom of GK2Room
	(properties
		initScene -1
		topicList -1
		subTopicList -1
		dialogDoneFlag -1
		checking 0
	)

	(method (init param1 &tmp temp0 temp1 temp2)
		(if (not checking)
			(gSounds eachElementDo: #fade 0 10 10 0)
			(super init:)
			(gEgo setScale: 0)
		)
		(if (== topicList -1)
			(= topicList (List new:))
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(topicList add: [param1 temp0])
		)
		(= temp2 (topicList firstTrue: #yo))
		(if checking
			(= checking 0)
			(if topicList
				(topicList eachElementDo: #releaseSub)
				(topicList release:)
			)
			(return temp2)
		)
		(= north (if south south else gPrevRoomNum))
		(if temp2
			(if (!= initScene -1)
				(PlayScene initScene)
			)
			(GKHotCursor cage: 60 352 460 475)
			(SetFlag 8)
			(if (not (= temp1 (self converse:)))
				(self cleanUp:)
				(gGame newRoom: north)
			else
				(gGame newRoom: temp1)
			)
		else
			(ClearFlag 8)
			(gGame newRoom: north)
		)
	)

	(method (dispose)
		(if
			(and
				topicList
				(not (topicList firstTrue: #yo 1))
				(!= dialogDoneFlag -1)
			)
			(SetFlag dialogDoneFlag)
		)
		(GKHotCursor cage:)
		(gSounds eachElementDo: #fade 127 10 10 0)
		(if topicList
			(topicList eachElementDo: #releaseSub)
			(topicList release:)
		)
		(super dispose: &rest)
	)

	(method (knock)
		(if (and argc (IsFlag dialogDoneFlag))
			(return 0)
		else
			(= checking 1)
			(self init:)
		)
	)

	(method (cleanUp))

	(method (checkTopics param1 &tmp temp0)
		(if (= temp0 (if argc param1 else topicList))
			(temp0 firstTrue: #yo)
		)
	)

	(method (converse param1 &tmp temp0 temp1)
		(= temp0
			(cond
				(argc param1)
				((!= subTopicList -1) subTopicList)
				((!= topicList -1) topicList)
				(else
					(return 0)
				)
			)
		)
		(if (temp0 isEmpty:)
			(return 0)
		else
			(temp0 eachElementDo: #addMe)
			(cond
				((!= (TopicPrint yOff:) 0)
					(if (not (= temp1 (TopicPrint init:)))
						(if (!= subTopicList -1)
							(= subTopicList -1)
							(self converse:)
						else
							(return 0)
						)
					else
						(PlayScene (temp1 sceneNum:))
						(if (and (temp1 nextRoomNum:) (temp1 nextRoomCheck:))
							(return (temp1 nextRoomNum:))
						else
							(self converse:)
						)
					)
				)
				((!= subTopicList -1)
					(= subTopicList -1)
					(self converse:)
				)
				(else
					(return 0)
				)
			)
		)
	)
)

