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
		BAD_SELECTOR 57
	)

	(method (init)
		(if (not BAD_SELECTOR)
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

(instance tWhatExotics of Topic
	(properties
		BAD_SELECTOR 594
		BAD_SELECTOR 323
		noun 14
	)
)

(instance tHarvest of Topic
	(properties
		BAD_SELECTOR 595
		BAD_SELECTOR 324
		BAD_SELECTOR 323
		noun 15
	)
)

(instance tTalkGrossberg of Topic
	(properties
		BAD_SELECTOR 597
		BAD_SELECTOR 325
		noun 16
	)
)

(instance tExport of Topic
	(properties
		BAD_SELECTOR 598
		BAD_SELECTOR 326
		noun 17
	)
)

(instance tExportsEndUp of Topic
	(properties
		BAD_SELECTOR 599
		BAD_SELECTOR 327
		BAD_SELECTOR 326
		noun 18
	)
)

(instance tKeptWolves of Topic
	(properties
		BAD_SELECTOR 600
		BAD_SELECTOR 328
		BAD_SELECTOR 327
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

