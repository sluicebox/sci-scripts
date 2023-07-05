;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1369)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Drumboy 0
)

(instance Drumboy of Eco2Talker
	(properties
		x 5
		y 5
		view 1369
		loop 3
		talkWidth 150
		back 62
		textX 115
		textY 12
		dftBack 62
	)

	(method (init)
		(= font gUserFont)
		(super init: drumboyBust drumboyEyes drumboyMouth &rest)
	)
)

(instance drumboyMouth of Prop
	(properties
		nsTop 42
		nsLeft 17
		view 1369
	)
)

(instance drumboyBust of Prop
	(properties
		view 1369
		loop 1
	)
)

(instance drumboyEyes of Prop
	(properties
		nsTop 30
		nsLeft 29
		view 1369
		loop 2
	)
)

