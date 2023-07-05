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
		dialogDoneFlag 48
	)

	(method (init)
		(if (not checking)
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
				tBismarck
				tBlackWolf1
				tBlackWolf2
				tBlackWolf3
				tAccident1
				tAccident2
		)
	)

	(method (cleanUp)
		(if (not (self checkTopics:))
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

(instance tHimself of Topic ; "Himself"
	(properties
		sceneNum 504
		flagNum 280
		noun 3
	)
)

(instance tDiary of Topic ; "Ludwig's Diary"
	(properties
		sceneNum 513
		flagNum 281
		noun 4
	)
)

(instance tL2_1 of Topic ; "Ludwig II"
	(properties
		sceneNum 505
		flagNum 282
		noun 7
	)
)

(instance tL2_2 of Topic ; "Ludwig II"
	(properties
		sceneNum 506
		flagNum 283
		readyFlagNum 282 ; "Ludwig II"
		noun 8
	)
)

(instance tMidnight of Topic ; "Midnight Sleigh Rides"
	(properties
		sceneNum 517
		flagNum 284
		noun 5
	)
)

(instance tFear of Topic ; "Servant's Fears", UNUSED
	(properties
		sceneNum 518
		flagNum 285
		readyFlagNum 291 ; "Hunting Accident"
		noun 6
	)
)

(instance tBismarck of Topic ; "Bismark"
	(properties
		sceneNum 507
		flagNum 286
		readyFlagNum 292
		noun 9
	)
)

(instance tBlackWolf1 of Topic ; "The Black Wolf"
	(properties
		sceneNum 510
		flagNum 287
		noun 10
	)
)

(instance tBlackWolf2 of Topic ; "The Black Wolf"
	(properties
		sceneNum 511
		flagNum 288
		readyFlagNum 287 ; "The Black Wolf"
		noun 11
	)
)

(instance tBlackWolf3 of Topic ; "The Black Wolf"
	(properties
		sceneNum 512
		flagNum 289
		readyFlagNum 288 ; "The Black Wolf"
		noun 12
	)
)

(instance tAccident1 of Topic ; "Hunting Accident"
	(properties
		sceneNum 515
		flagNum 290
		noun 13
	)
)

(instance tAccident2 of Topic ; "Hunting Accident"
	(properties
		sceneNum 516
		flagNum 291
		readyFlagNum 290 ; "Hunting Accident"
		noun 14
	)
)

