;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	rakeeshTalker 0
	Rakeesh 1
)

(instance rakeeshTalker of GloryTalker
	(properties
		x 15
		y 15
		view 961
		loop 1
		talkWidth 130
		back 57
		textX 140
		textY 3
		backColor 45
	)

	(method (init)
		(super init: rakeeshBust rakeeshEyes rakeeshMouth &rest)
	)
)

(instance rakeeshMouth of Prop
	(properties
		nsTop 34
		nsLeft 46
		view 961
	)
)

(instance rakeeshEyes of Prop
	(properties
		nsTop 29
		nsLeft 46
		view 961
		loop 2
	)
)

(instance rakeeshBust of View
	(properties
		nsTop 25
		nsLeft 43
		view 961
		loop 3
	)
)

(instance Rakeesh of Actor
	(properties
		x 90
		y 160
		noun 1
		view 960
	)
)

