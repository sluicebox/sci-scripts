;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	shamanTalker 0
)

(instance shamanTalker of GloryTalker
	(properties
		x 200
		y 15
		view 626
		loop 1
		talkWidth 260
		back 57
		textX -173
		textY 100
		frame 0
		backColor 44
	)

	(method (init)
		(super init: shamanBust shamanEyes shamanMouth &rest)
	)
)

(instance shamanMouth of Prop
	(properties
		nsTop 48
		nsLeft 18
		view 626
	)
)

(instance shamanEyes of Prop
	(properties
		nsTop 34
		nsLeft 16
		view 626
		loop 2
	)
)

(instance shamanBust of View
	(properties
		nsTop 19
		nsLeft 21
		view 626
		loop 3
	)
)

