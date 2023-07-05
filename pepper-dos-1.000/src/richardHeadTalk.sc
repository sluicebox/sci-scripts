;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2012)
(include sci.sh)
(use Main)
(use TalkerWindow)
(use Talker)
(use Actor)

(public
	richardHeadTalk 0
)

(local
	local0
)

(instance richardHeadTalk of Talker
	(properties
		x 37
		y 77
		talkWidth 110
		color 1
		back 5
		view 3004
		textX 130
	)

	(method (dispose)
		(= gSystemWindow local0)
		(super dispose: &rest)
	)

	(method (init)
		(= local0 gSystemWindow)
		(= gSystemWindow TalkerWindow)
		(super init: 0 0 richardEyes richardFrame &rest)
	)
)

(instance richardFrame of View
	(properties
		x 9
		y 14
		view 3004
		loop 3
		priority 15
		signal 24592
	)
)

(instance richardEyes of Prop
	(properties
		x 56
		y 61
		view 3004
		loop 2
		priority 15
		signal 24592
	)
)

