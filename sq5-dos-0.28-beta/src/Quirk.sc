;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1883)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Quirk 25
)

(instance Quirk of Talker
	(properties
		x 0
		y 25
		view 1002
		talkWidth 150
		textX 150
		textY 10
	)

	(method (init)
		(= font gUserFont)
		(if (== gCurRoomNum 1040)
			(Quirk view: 1009 x: 16 y: 27 textX: 128)
			(quirkBust view: 1009)
			(quirkEyes view: 1009 nsLeft: 69 nsTop: 11)
			(quirkMouth view: 1009 nsLeft: 51 nsTop: 29)
		else
			(quirkEyes setLoop: (Random 2 3))
		)
		(super init: quirkBust quirkEyes quirkMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance quirkBust of Prop
	(properties
		view 1002
	)
)

(instance quirkEyes of Prop
	(properties
		nsTop 22
		nsLeft 77
		view 1002
		loop 2
	)
)

(instance quirkMouth of Prop
	(properties
		nsTop 50
		nsLeft 74
		view 1002
		loop 1
	)
)

