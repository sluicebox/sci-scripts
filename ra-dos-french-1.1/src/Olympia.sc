;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1892)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Olympia 25
)

(instance Olympia of Talker
	(properties
		x 5
		y 5
		view 1892
		loop 3
		talkWidth 150
		back 15
		textX 112
		textY 12
	)

	(method (init)
		(= font gUserFont)
		(super init: olympiaBust olympiaEyes olympiaMouth &rest)
	)
)

(instance olympiaBust of Prop
	(properties
		view 1892
		loop 1
	)
)

(instance olympiaEyes of Prop
	(properties
		nsTop 39
		nsLeft 31
		view 1892
		loop 2
	)
)

(instance olympiaMouth of Prop
	(properties
		nsTop 59
		nsLeft 26
		view 1892
	)
)

