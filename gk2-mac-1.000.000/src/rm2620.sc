;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2620)
(include sci.sh)
(use Main)
(use TopicRoom)
(use TopicPrint)
(use Motion)
(use Actor)
(use System)

(public
	rm2620 0
)

(instance rm2620 of TopicRoom
	(properties
		modNum 260
		picture 2632
		dialogDoneFlag 57
	)

	(method (init)
		(if (not checking)
			(gEgo
				setScale: 0
				view: 22578
				setLoop: 0 1
				cel: 0
				posn: 486 48
				init:
				setPri: 200 1
				setScript: sFidget
			)
			(pDorn init: setScript: sDornFidget)
		)
		(super
			init:
				tWhatExotics
				tHarvest
				tTalkGrossberg
				tExport
				tExportsEndUp
				tKeptWolves
		)
	)
)

(instance tWhatExotics of Topic ; "What kind of exotics did you get for Grossberg?"
	(properties
		sceneNum 594
		flagNum 323
		noun 14
	)
)

(instance tHarvest of Topic ; "Did Grossberg harvest the furs or did you?"
	(properties
		sceneNum 595
		flagNum 324
		readyFlagNum 323 ; "What kind of exotics did you get for Grossberg?"
		noun 15
	)
)

(instance tTalkGrossberg of Topic ; "Did you talk to Grossberg before he died?"
	(properties
		sceneNum 597
		flagNum 325
		noun 16
	)
)

(instance tExport of Topic ; "How did the 'export' go?"
	(properties
		sceneNum 598
		flagNum 326
		noun 17
	)
)

(instance tExportsEndUp of Topic ; "Where did the exports end up?"
	(properties
		sceneNum 599
		flagNum 327
		readyFlagNum 326 ; "How did the 'export' go?"
		noun 18
	)
)

(instance tKeptWolves of Topic ; "Can I see where you kept the wolves?"
	(properties
		sceneNum 600
		flagNum 328
		readyFlagNum 327 ; "Where did the exports end up?"
		noun 19
	)
)

(instance pDorn of Prop
	(properties
		x 206
		y 110
		view 21578
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 8 16))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sDornFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(pDorn cel: 0 setCycle: End)
				(= seconds (Random 2 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

