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
		BAD_SELECTOR 61
	)

	(method (init)
		(if (not BAD_SELECTOR)
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

	(method (BAD_SELECTOR)
		(if (and (IsFlag 330) (IsFlag 334))
			(SetFlag 655)
		)
		(PlayScene 1612)
	)
)

(instance tClub of Topic
	(properties
		BAD_SELECTOR 614
		BAD_SELECTOR 329
		noun 7
	)
)

(instance tKlingmann of Topic
	(properties
		BAD_SELECTOR 615
		BAD_SELECTOR 330
		BAD_SELECTOR 329
		noun 8
	)
)

(instance tPriess1 of Topic
	(properties
		BAD_SELECTOR 616
		BAD_SELECTOR 331
		noun 9
	)
)

(instance tPriess2 of Topic
	(properties
		BAD_SELECTOR 617
		BAD_SELECTOR 332
		BAD_SELECTOR 331
		noun 10
	)
)

(instance tLodge1 of Topic
	(properties
		BAD_SELECTOR 620
		BAD_SELECTOR 333
		noun 11
	)
)

(instance tLodge2 of Topic
	(properties
		BAD_SELECTOR 621
		BAD_SELECTOR 334
		BAD_SELECTOR 333
		noun 12
	)
)

(instance tBlackWolf of Topic
	(properties
		BAD_SELECTOR 622
		BAD_SELECTOR 335
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

