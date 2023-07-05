;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8110)
(include sci.sh)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	topic810 0
)

(instance topic810 of TopicRoom
	(properties
		modNum 810
		picture 8122
		south 810 ; rm810
		BAD_SELECTOR 490
		BAD_SELECTOR 47
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(frau init: setScript: FidgetScript)
			(grace init:)
		)
		(super init: tTicket tIsMuseum tSeeDiary tMoreOpera)
	)
)

(instance tTicket of Topic
	(properties
		BAD_SELECTOR 491
		BAD_SELECTOR 276
		noun 29
		BAD_SELECTOR 810
	)
)

(instance tIsMuseum of Topic
	(properties
		BAD_SELECTOR 492
		BAD_SELECTOR 277
		noun 27
	)
)

(instance tSeeDiary of Topic
	(properties
		BAD_SELECTOR 493
		BAD_SELECTOR 278
		BAD_SELECTOR 622
		noun 26
		BAD_SELECTOR 810
	)
)

(instance tMoreOpera of Topic
	(properties
		BAD_SELECTOR 494
		BAD_SELECTOR 279
		BAD_SELECTOR 623
		noun 28
	)
)

(instance grace of Prop
	(properties
		sightAngle 360
		x 62
		y 333
		view 10488
	)
)

(instance frau of Prop
	(properties
		x 520
		y 127
		priority 400
		fixPriority 1
		view 21488
	)
)

