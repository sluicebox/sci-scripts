;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2016)
(include sci.sh)
(use Main)
(use TalkerWindow)
(use Talker)
(use Actor)

(public
	deborahTalker 0
)

(local
	local0
)

(instance deborahTalker of Talker
	(properties
		x 38
		y 79
		talkWidth 120
		color 1
		back 5
		view 3005
		textX 130
	)

	(method (dispose)
		(= gSystemWindow local0)
		(super dispose: &rest)
	)

	(method (init)
		(= local0 gSystemWindow)
		(= gSystemWindow TalkerWindow)
		(super init: 0 0 deborahEyes deborahFrame &rest)
	)
)

(instance deborahFrame of View
	(properties
		x 9
		y 14
		view 3005
		loop 3
		priority 15
		signal 24592
	)
)

(instance deborahEyes of Prop
	(properties
		x 55
		y 65
		view 3005
		loop 2
		priority 15
		signal 24592
	)
)

