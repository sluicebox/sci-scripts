;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 234)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	guardTalker 0
)

(instance guardTalker of GloryTalker
	(properties
		x 205
		y 2
		view 191
		loop 1
		talkWidth 260
		back 57
		textX -180
		textY 150
		backColor 14
	)

	(method (init)
		(super init: guardBust guardEyes guardMouth &rest)
	)
)

(instance guardMouth of Prop
	(properties
		nsTop 46
		nsLeft 46
		view 191
	)
)

(instance guardEyes of Prop
	(properties
		nsTop 35
		nsLeft 44
		view 191
		loop 2
	)
)

(instance guardBust of View
	(properties
		nsTop 24
		nsLeft 40
		view 191
		loop 3
	)
)

