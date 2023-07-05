;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use GloryTalker)
(use Actor)

(public
	storyTalker 0
	StoryTeller 1
)

(instance storyTalker of GloryTalker
	(properties
		x 5
		y 10
		view 422
		loop 1
		talkWidth 140
		back 57
		textX 145
		textY 3
	)

	(method (init)
		(super init: storyBust storyEyes storyMouth &rest)
	)
)

(instance storyMouth of Prop
	(properties
		nsTop 45
		nsLeft 42
		view 422
		cycleSpeed 10
	)
)

(instance storyEyes of Prop
	(properties
		nsTop 33
		nsLeft 44
		view 422
		loop 2
		cycleSpeed 30
	)
)

(instance storyBust of Prop
	(properties
		nsTop 16
		nsLeft 39
		view 422
		loop 3
	)
)

(instance StoryTeller of Actor
	(properties
		view 421
	)
)

