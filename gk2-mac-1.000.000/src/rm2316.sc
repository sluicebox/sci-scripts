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
		dialogDoneFlag 40
	)

	(method (init)
		(if (not checking)
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
		(tMissingWolves setSubList: tGotOut tKillings tLookLike setFlag: 1)
		(tMissingWolves2 setSubList: tGotOut tKillings tLookLike)
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

	(method (cleanUp)
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

(instance tThomas1 of Topic ; "Himself"
	(properties
		sceneNum 34
		flagNum 101
		noun 9
	)
)

(instance tThomas2 of Topic ; "Himself"
	(properties
		sceneNum 35
		flagNum 102
		readyFlagNum 101 ; "Himself"
		noun 10
	)
)

(instance tKlingman of Topic ; "Doktor Klingmann"
	(properties
		sceneNum 41
		flagNum 103
		readyFlagNum 102 ; "Himself"
		noun 11
	)
)

(instance tWolves of Topic ; "Wolves"
	(properties
		sceneNum 36
		flagNum 104
		noun 12
	)
)

(instance tMissingWolves of Topic ; "Missing Wolves"
	(properties
		sceneNum 37
		flagNum 105
		noun 13
	)
)

(instance tMissingWolves2 of Topic ; "Missing Wolves"
	(properties
		sceneNum -1
		flagNum 127
		readyFlagNum 105 ; "Missing Wolves"
		noun 13
	)
)

(instance tGotOut of Topic ; "How did the wolves get out?"
	(properties
		sceneNum 38
		flagNum 106
		noun 14
	)
)

(instance tKillings of Topic ; "What do you think about the wolves killing people?"
	(properties
		sceneNum 39
		flagNum 107
		noun 15
	)
)

(instance tLookLike of Topic ; "What did the wolves look like?"
	(properties
		sceneNum 40
		flagNum 108
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

