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
		initScene 490
		dialogDoneFlag 47
	)

	(method (init)
		(if (not checking)
			(frau init: setScript: FidgetScript)
			(grace init:)
		)
		(super init: tTicket tIsMuseum tSeeDiary tMoreOpera)
	)
)

(instance tTicket of Topic ; "I'd like to buy a ticket."
	(properties
		sceneNum 491
		flagNum 276
		noun 29
		nextRoomNum 810 ; rm810
	)
)

(instance tIsMuseum of Topic ; "Is this the Ludwig Museum?"
	(properties
		sceneNum 492
		flagNum 277
		noun 27
	)
)

(instance tSeeDiary of Topic ; "Is there any way to see more of Ludwig's diary?"
	(properties
		sceneNum 493
		flagNum 278
		readyFlagNum 622
		noun 26
		nextRoomNum 810 ; rm810
	)
)

(instance tMoreOpera of Topic ; "Do you know anything about the 'new Wagner opera'?"
	(properties
		sceneNum 494
		flagNum 279
		readyFlagNum 623
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

