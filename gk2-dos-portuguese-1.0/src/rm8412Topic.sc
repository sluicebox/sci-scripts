;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8414)
(include sci.sh)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use Motion)
(use Actor)
(use System)

(public
	rm8412Topic 0
)

(instance rm8412Topic of TopicRoom
	(properties
		modNum 8412
		picture 8415
		BAD_SELECTOR 48
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(grace init: setScript: graceScript)
			(dall init: setScript: dalScript)
		)
		(super
			init:
				tHimself
				tDiary
				tL2_1
				tL2_2
				tMidnight
				tFear
				tBismarck
				tBlackWolf1
				tBlackWolf2
				tBlackWolf3
				tAccident1
				tAccident2
		)
	)

	(method (BAD_SELECTOR)
		(if (not (self sel_845:))
			(ClearFlag 408)
			(PlayScene 502)
		)
	)
)

(instance grace of Prop
	(properties
		sightAngle 360
		x 171
		y 162
		view 20504
	)

	(method (doVerb))
)

(instance dall of Prop
	(properties
		sightAngle 360
		x 425
		y 125
		view 24504
	)

	(method (doVerb))
)

(instance graceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 15))
			)
			(1
				(client cel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(client cel: 0 show:)
				(self changeState: 0)
			)
		)
	)
)

(instance dalScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 14 19))
			)
			(1
				(client cel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(client cel: 0 show:)
				(self changeState: 0)
			)
		)
	)
)

(instance tHimself of Topic
	(properties
		BAD_SELECTOR 504
		BAD_SELECTOR 280
		noun 3
	)
)

(instance tDiary of Topic
	(properties
		BAD_SELECTOR 513
		BAD_SELECTOR 281
		noun 4
	)
)

(instance tL2_1 of Topic
	(properties
		BAD_SELECTOR 505
		BAD_SELECTOR 282
		noun 7
	)
)

(instance tL2_2 of Topic
	(properties
		BAD_SELECTOR 506
		BAD_SELECTOR 283
		BAD_SELECTOR 282
		noun 8
	)
)

(instance tMidnight of Topic
	(properties
		BAD_SELECTOR 517
		BAD_SELECTOR 284
		noun 5
	)
)

(instance tFear of Topic
	(properties
		BAD_SELECTOR 518
		BAD_SELECTOR 285
		BAD_SELECTOR 291
		noun 6
	)
)

(instance tBismarck of Topic
	(properties
		BAD_SELECTOR 507
		BAD_SELECTOR 286
		BAD_SELECTOR 292
		noun 9
	)
)

(instance tBlackWolf1 of Topic
	(properties
		BAD_SELECTOR 510
		BAD_SELECTOR 287
		noun 10
	)
)

(instance tBlackWolf2 of Topic
	(properties
		BAD_SELECTOR 511
		BAD_SELECTOR 288
		BAD_SELECTOR 287
		noun 11
	)
)

(instance tBlackWolf3 of Topic
	(properties
		BAD_SELECTOR 512
		BAD_SELECTOR 289
		BAD_SELECTOR 288
		noun 12
	)
)

(instance tAccident1 of Topic
	(properties
		BAD_SELECTOR 515
		BAD_SELECTOR 290
		noun 13
	)
)

(instance tAccident2 of Topic
	(properties
		BAD_SELECTOR 516
		BAD_SELECTOR 291
		BAD_SELECTOR 290
		noun 14
	)
)

