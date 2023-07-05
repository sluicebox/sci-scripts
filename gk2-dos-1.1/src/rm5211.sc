;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5211)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use Motion)
(use Actor)
(use System)

(public
	rm5211 0
)

(instance rm5211 of TopicRoom
	(properties
		modNum 520
		picture 5231
		south 520 ; greatRm
		dialogDoneFlag 61
	)

	(method (init)
		(if (not checking)
			(gEgo
				setScale: 0
				view: 21607
				setLoop: 0 1
				cel: 0
				posn: 472 130
				init:
				setScript: sDudeFidget
			)
			(pHennemann init: setScript: sHennemannFidget)
		)
		(super
			init: tClub tKlingmann tPriess1 tPriess2 tLodge1 tLodge2 tBlackWolf
		)
	)

	(method (cleanUp)
		(if (and (IsFlag 330) (IsFlag 334)) ; "Klingmann", "The Lodge"
			(SetFlag 655)
		)
		(PlayScene 1612)
	)
)

(instance tClub of Topic ; "The Club"
	(properties
		sceneNum 614
		flagNum 329
		noun 7
	)
)

(instance tKlingmann of Topic ; "Klingmann"
	(properties
		sceneNum 615
		flagNum 330
		readyFlagNum 329 ; "The Club"
		noun 8
	)
)

(instance tPriess1 of Topic ; "Preiss"
	(properties
		sceneNum 616
		flagNum 331
		noun 9
	)
)

(instance tPriess2 of Topic ; "Preiss"
	(properties
		sceneNum 617
		flagNum 332
		readyFlagNum 331 ; "Preiss"
		noun 10
	)
)

(instance tLodge1 of Topic ; "The Lodge"
	(properties
		sceneNum 620
		flagNum 333
		noun 11
	)
)

(instance tLodge2 of Topic ; "The Lodge"
	(properties
		sceneNum 621
		flagNum 334
		readyFlagNum 333 ; "The Lodge"
		noun 12
	)
)

(instance tBlackWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 622
		flagNum 335
		noun 13
	)
)

(instance pHennemann of Prop
	(properties
		x 258
		y 166
		view 22607
	)
)

(instance sDudeFidget of Script
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

(instance sHennemannFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pHennemann cel: 0 setCycle: End)
				(= seconds (Random 2 10))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

