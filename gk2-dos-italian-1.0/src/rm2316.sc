;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2316)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Motion)
(use Actor)
(use System)

(public
	rm2316 0
)

(instance rm2316 of TopicRoom
	(properties
		modNum 230
		picture 2321
		south 230 ; hellZooRm
		BAD_SELECTOR 40
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(gEgo
				setScale: 0
				view: 21027
				setLoop: 0 1
				posn: 458 60
				cel: 0
				init:
				setScript: FidgetScript
			)
			(thomas init: setScript: sThomasFidget)
		)
		(tMissingWolves
			BAD_SELECTOR: tGotOut tKillings tLookLike
			BAD_SELECTOR: 1
		)
		(tMissingWolves2 BAD_SELECTOR: tGotOut tKillings tLookLike)
		(super
			init:
				tThomas1
				tThomas2
				tKlingman
				tWolves
				tMissingWolves
				tMissingWolves2
		)
	)

	(method (BAD_SELECTOR)
		(PlayScene 33 0 230) ; hellZooRm
	)
)

(instance thomas of Prop
	(properties
		x 173
		y 321
		view 51027
	)
)

(instance tThomas1 of Topic
	(properties
		BAD_SELECTOR 34
		BAD_SELECTOR 101
		noun 9
	)
)

(instance tThomas2 of Topic
	(properties
		BAD_SELECTOR 35
		BAD_SELECTOR 102
		BAD_SELECTOR 101
		noun 10
	)
)

(instance tKlingman of Topic
	(properties
		BAD_SELECTOR 41
		BAD_SELECTOR 103
		BAD_SELECTOR 102
		noun 11
	)
)

(instance tWolves of Topic
	(properties
		BAD_SELECTOR 36
		BAD_SELECTOR 104
		noun 12
	)
)

(instance tMissingWolves of Topic
	(properties
		BAD_SELECTOR 37
		BAD_SELECTOR 105
		noun 13
	)
)

(instance tMissingWolves2 of Topic
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 127
		BAD_SELECTOR 105
		noun 13
	)
)

(instance tGotOut of Topic
	(properties
		BAD_SELECTOR 38
		BAD_SELECTOR 106
		noun 14
	)
)

(instance tKillings of Topic
	(properties
		BAD_SELECTOR 39
		BAD_SELECTOR 107
		noun 15
	)
)

(instance tLookLike of Topic
	(properties
		BAD_SELECTOR 40
		BAD_SELECTOR 108
		noun 16
	)
)

(instance sThomasFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(thomas cel: 0 setLoop: (Random 0 1) 1 setCycle: End)
				(= seconds (Random 2 9))
			)
			(2
				(if (== (thomas loop:) 0)
					(thomas cel: 1)
				else
					(thomas cel: 13)
				)
				(= cycles 30)
			)
			(3
				(if (== (thomas loop:) 0)
					(thomas cel: 0)
				else
					(thomas cel: 14)
				)
				(= cycles 1)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 12 30))
			)
			(1
				(self init:)
			)
		)
	)
)

