;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	monkeyTalker 0
	Manu 1
)

(instance monkeyTalker of GloryTalker
	(properties
		x 200
		y 10
		view 986
		loop 1
		talkWidth 260
		back 57
		textX -175
		textY 100
		frame 0
		backColor 11
	)

	(method (init)
		(super init: monkeyBust monkeyEyes monkeyMouth &rest)
	)
)

(instance monkeyMouth of Prop
	(properties
		nsTop 42
		nsLeft 28
		view 986
	)
)

(instance monkeyEyes of Prop
	(properties
		nsTop 32
		nsLeft 30
		view 986
		loop 2
	)
)

(instance monkeyBust of View
	(properties
		nsTop 24
		nsLeft 26
		view 986
		loop 3
	)
)

(instance Manu of Actor
	(properties
		x 90
		y 160
		noun 1
		view 985
	)
)

