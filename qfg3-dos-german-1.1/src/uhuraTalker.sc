;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	uhuraTalker 0
	Uhura 1
)

(instance uhuraTalker of GloryTalker
	(properties
		x 10
		y 10
		view 972
		loop 1
		talkWidth 200
		back 57
		textX 15
		textY 120
		frame 2
		backColor 10
	)

	(method (init)
		(super init: uhuraBust uhuraEyes uhuraMouth &rest)
	)
)

(instance uhuraMouth of Prop
	(properties
		nsTop 39
		nsLeft 31
		view 972
		cycleSpeed 10
	)
)

(instance uhuraEyes of Prop
	(properties
		nsTop 26
		nsLeft 27
		view 972
		loop 2
		cycleSpeed 30
	)
)

(instance uhuraBust of Prop
	(properties
		view 972
		loop 3
	)
)

(instance Uhura of Actor
	(properties
		x 90
		y 160
		noun 1
		view 971
	)
)

