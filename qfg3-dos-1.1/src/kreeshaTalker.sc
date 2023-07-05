;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	kreeshaTalker 0
)

(instance kreeshaTalker of GloryTalker
	(properties
		x 10
		y 10
		view 276
		loop 1
		talkWidth 260
		color 37
		back 57
		textX 15
		textY 100
		backColor 37
	)

	(method (init)
		(super init: kreeshaBust kreeshaEyes kreeshaMouth &rest)
	)
)

(instance kreeshaMouth of Prop
	(properties
		nsTop 49
		nsLeft 50
		view 276
	)
)

(instance kreeshaEyes of Prop
	(properties
		nsTop 39
		nsLeft 49
		view 276
		loop 2
	)
)

(instance kreeshaBust of View
	(properties
		nsTop 27
		nsLeft 45
		view 276
		loop 3
	)
)

