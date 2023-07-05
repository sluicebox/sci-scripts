;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7424)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	smithTopicRm 0
)

(instance smithTopicRm of TopicRoom
	(properties
		modNum 740
		picture 7413
		dialogDoneFlag 65
	)

	(method (init)
		(if (not checking)
			(= initScene
				(cond
					((== gPrevRoomNum 7422) ; gastTopicRm
						(= south 740)
						-1
					)
					((IsFlag 605) 440)
					(else
						(SetFlag 605)
						439
					)
				)
			)
			(smiths init: setScript: FidgetScript)
			(mrSmith init: setScript: (FidgetScript new:))
			(grace init: setScript: (FidgetScript new:))
		)
		(super
			init:
				tSMThemselves
				tSMLudwig
				tSMBlackWolf
				tSMBlackWolf2
				tSMTarot
				tSMTarot2
				tSMDream
		)
	)

	(method (cleanUp)
		(PlayScene 446)
	)
)

(instance smiths of Prop
	(properties
		x 176
		y 176
		view 21763
		cycleSpeed 8
	)
)

(instance grace of Prop
	(properties
		x 408
		y 159
		view 23435
		cycleSpeed 8
	)
)

(instance mrSmith of Prop
	(properties
		x 454
		y 170
		view 22435
		cycleSpeed 8
	)
)

(instance tSMThemselves of Topic ; "Themselves"
	(properties
		sceneNum 447
		flagNum 303
		noun 33
	)
)

(instance tSMLudwig of Topic ; "Ludwig II"
	(properties
		sceneNum 449
		flagNum 305
		noun 35
	)
)

(instance tSMBlackWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 450
		flagNum 306
		noun 36
	)
)

(instance tSMBlackWolf2 of Topic ; "The Black Wolf"
	(properties
		sceneNum 451
		flagNum 307
		readyFlagNum 306 ; "The Black Wolf"
		noun 36
	)
)

(instance tSMTarot of Topic ; "Tarot Reading"
	(properties
		sceneNum 453
		flagNum 308
		readyFlagNum 306 ; "The Black Wolf"
		noun 38
	)
)

(instance tSMTarot2 of Topic ; "Gabriel's Tarot"
	(properties
		sceneNum 454
		flagNum 309
		readyFlagNum 308 ; "Tarot Reading"
		noun 39
	)
)

(instance tSMDream of Topic ; "Ludwig Dream"
	(properties
		sceneNum 457
		flagNum 310
		readyFlagNum 624
		noun 40
	)
)

