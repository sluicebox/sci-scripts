;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1629)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Tailbat 0
)

(instance Tailbat of Eco2Talker
	(properties
		x 5
		y 5
		view 1629
		loop 3
		talkWidth 150
		back 5
		textX 115
		textY 12
		dftBack 5
	)

	(method (init)
		(= font gUserFont)
		(self setupTalker: 2)
		(super init: tailbatBust tailbatEyes tailbatMouth &rest)
	)
)

(instance tailbatMouth of Prop
	(properties
		nsTop 57
		nsLeft 19
		view 1629
	)
)

(instance tailbatBust of Prop
	(properties
		view 1629
		loop 1
	)
)

(instance tailbatEyes of Prop
	(properties
		nsTop 33
		nsLeft 31
		view 1629
		loop 2
	)
)

