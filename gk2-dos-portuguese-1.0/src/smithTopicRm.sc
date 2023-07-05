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
		BAD_SELECTOR 65
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(= BAD_SELECTOR
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

	(method (BAD_SELECTOR)
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

(instance tSMThemselves of Topic
	(properties
		BAD_SELECTOR 447
		BAD_SELECTOR 303
		noun 33
	)
)

(instance tSMLudwig of Topic
	(properties
		BAD_SELECTOR 449
		BAD_SELECTOR 305
		noun 35
	)
)

(instance tSMBlackWolf of Topic
	(properties
		BAD_SELECTOR 450
		BAD_SELECTOR 306
		noun 36
	)
)

(instance tSMBlackWolf2 of Topic
	(properties
		BAD_SELECTOR 451
		BAD_SELECTOR 307
		BAD_SELECTOR 306
		noun 36
	)
)

(instance tSMTarot of Topic
	(properties
		BAD_SELECTOR 453
		BAD_SELECTOR 308
		BAD_SELECTOR 306
		noun 38
	)
)

(instance tSMTarot2 of Topic
	(properties
		BAD_SELECTOR 454
		BAD_SELECTOR 309
		BAD_SELECTOR 308
		noun 39
	)
)

(instance tSMDream of Topic
	(properties
		BAD_SELECTOR 457
		BAD_SELECTOR 310
		BAD_SELECTOR 624
		noun 40
	)
)

