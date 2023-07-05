;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1888)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	O_Riley 19
)

(instance O_Riley of Talker
	(properties
		name {O'Riley}
		x 5
		y 5
		view 1888
		loop 3
		talkWidth 150
		back 15
		textX 115
		textY 12
	)

	(method (init)
		(= font gUserFont)
		(super init: oRileyBust oRileyEyes oRileyMouth &rest)
	)
)

(instance oRileyBust of Prop
	(properties
		view 1888
		loop 1
	)
)

(instance oRileyEyes of Prop
	(properties
		nsTop 38
		nsLeft 31
		view 1888
		loop 2
	)
)

(instance oRileyMouth of Prop
	(properties
		nsTop 57
		nsLeft 30
		view 1888
	)
)

