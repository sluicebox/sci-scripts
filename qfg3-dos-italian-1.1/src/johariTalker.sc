;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	johariTalker 0
	Johari 1
)

(instance johariTalker of GloryTalker
	(properties
		x 185
		y 2
		view 976
		loop 1
		talkWidth 260
		back 57
		textX -161
		textY 150
		frame 2
		backColor 12
	)

	(method (init)
		(super init: johariBust johariEyes johariMouth &rest)
	)
)

(instance johariMouth of Prop
	(properties
		nsTop 41
		nsLeft 25
		view 976
	)
)

(instance johariEyes of Prop
	(properties
		nsTop 34
		nsLeft 25
		view 976
		loop 2
	)
)

(instance johariBust of View
	(properties
		nsTop 22
		nsLeft 27
		view 976
		loop 3
	)
)

(instance Johari of Actor
	(properties
		x 90
		y 160
		noun 1
		view 975
	)
)

