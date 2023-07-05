;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	yesufuTalker 0
	Yesufu 1
)

(instance Yesufu of Actor
	(properties
		noun 1
		view 980
	)
)

(instance yesufuTalker of GloryTalker
	(properties
		x 185
		y 10
		view 981
		loop 1
		talkWidth 260
		back 57
		textX -161
		textY 100
		frame 2
		backColor 12
	)

	(method (init)
		(super init: yesufuBust yesufuEyes yesufuMouth &rest)
	)
)

(instance yesufuMouth of Prop
	(properties
		nsTop 54
		nsLeft 39
		view 981
	)
)

(instance yesufuEyes of Prop
	(properties
		nsTop 38
		nsLeft 34
		view 981
		loop 2
	)
)

(instance yesufuBust of View
	(properties
		nsTop 21
		nsLeft 31
		view 981
		loop 3
	)
)

