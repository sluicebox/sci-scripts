;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	elderTalker 0
	Elder 1
	elderBust 2
	elderMouth 3
	elderEyes 4
)

(instance Elder of Actor
	(properties
		view 412
	)
)

(instance elderTalker of GloryTalker
	(properties
		x 10
		y 10
		view 413
		loop 1
		talkWidth 125
		back 57
		textX 150
		textY 3
	)

	(method (init)
		(super init: elderBust elderEyes elderMouth &rest)
	)
)

(instance elderBust of Prop
	(properties
		nsTop 18
		nsLeft 31
		view 413
		loop 3
	)
)

(instance elderMouth of Prop
	(properties
		nsTop 53
		nsLeft 39
		view 413
		cycleSpeed 10
	)
)

(instance elderEyes of Prop
	(properties
		nsTop 37
		nsLeft 31
		view 413
		loop 2
		cycleSpeed 30
	)
)

