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
		BAD_SELECTOR -1
		BAD_SELECTOR -1
		BAD_SELECTOR -1
		BAD_SELECTOR -1
		BAD_SELECTOR 0
	)

	(method (init param1 &tmp temp0 temp1 temp2)
		(if (not BAD_SELECTOR)
			(gSounds eachElementDo: #fade 0 10 10 0)
			(super init:)
			(gEgo setScale: 0)
		)
		(if (== BAD_SELECTOR -1)
			(= BAD_SELECTOR (List new:))
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(BAD_SELECTOR add: [param1 temp0])
		)
		(= temp2 (BAD_SELECTOR firstTrue: #BAD_SELECTOR))
		(if BAD_SELECTOR
			(= BAD_SELECTOR 0)
			(if BAD_SELECTOR
				(BAD_SELECTOR eachElementDo: #BAD_SELECTOR)
				(BAD_SELECTOR release:)
			)
			(return temp2)
		)
		(= north (if south south else gPrevRoomNum))
		(if temp2
			(if (!= BAD_SELECTOR -1)
				(PlayScene BAD_SELECTOR)
			)
			(GKHotCursor BAD_SELECTOR: 60 352 460 475)
			(SetFlag 8)
			(if (not (= temp1 (self BAD_SELECTOR:)))
				(self BAD_SELECTOR:)
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
				BAD_SELECTOR
				(not (BAD_SELECTOR firstTrue: #BAD_SELECTOR 1))
				(!= BAD_SELECTOR -1)
			)
			(SetFlag BAD_SELECTOR)
		)
		(GKHotCursor BAD_SELECTOR:)
		(gSounds eachElementDo: #fade 127 10 10 0)
		(if BAD_SELECTOR
			(BAD_SELECTOR eachElementDo: #BAD_SELECTOR)
			(BAD_SELECTOR release:)
		)
		(super dispose: &rest)
	)

	(method (BAD_SELECTOR)
		(if (and argc (IsFlag BAD_SELECTOR))
			(return 0)
		else
			(= BAD_SELECTOR 1)
			(self init:)
		)
	)

	(method (BAD_SELECTOR))

	(method (BAD_SELECTOR param1 &tmp temp0)
		(if (= temp0 (if argc param1 else BAD_SELECTOR))
			(temp0 firstTrue: #BAD_SELECTOR)
		)
	)

	(method (BAD_SELECTOR param1 &tmp temp0 temp1)
		(= temp0
			(cond
				(argc param1)
				((!= BAD_SELECTOR -1) BAD_SELECTOR)
				((!= BAD_SELECTOR -1) BAD_SELECTOR)
				(else
					(return 0)
				)
			)
		)
		(if (temp0 isEmpty:)
			(return 0)
		else
			(temp0 eachElementDo: #BAD_SELECTOR)
			(cond
				((!= (TopicPrint BAD_SELECTOR:) 0)
					(if (not (= temp1 (TopicPrint init:)))
						(if (!= BAD_SELECTOR -1)
							(= BAD_SELECTOR -1)
							(self BAD_SELECTOR:)
						else
							(return 0)
						)
					else
						(PlayScene (temp1 BAD_SELECTOR:))
						(if (and (temp1 BAD_SELECTOR:) (temp1 BAD_SELECTOR:))
							(return (temp1 BAD_SELECTOR:))
						else
							(self BAD_SELECTOR:)
						)
					)
				)
				((!= BAD_SELECTOR -1)
					(= BAD_SELECTOR -1)
					(self BAD_SELECTOR:)
				)
				(else
					(return 0)
				)
			)
		)
	)
)

