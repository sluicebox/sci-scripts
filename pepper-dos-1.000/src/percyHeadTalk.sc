;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2020)
(include sci.sh)
(use Main)
(use TalkerWindow)
(use Talker)
(use Actor)

(public
	percyHeadTalk 0
)

(local
	local0
)

(instance percyHeadTalk of Talker
	(properties
		x 67
		y 97
		talkWidth 110
		color 1
		back 5
		view 3010
		textX 130
	)

	(method (dispose)
		(= gSystemWindow local0)
		(super dispose: &rest)
	)

	(method (init)
		(= local0 gSystemWindow)
		(= gSystemWindow TalkerWindow)
		(if (== global194 51)
			(= view 3011)
			(percyFrame view: 3011)
			(percyEyes view: 3011)
		)
		(super init: 0 0 percyEyes percyFrame &rest)
	)
)

(instance percyFrame of View
	(properties
		x 9
		y 14
		view 3010
		loop 3
		priority 14
		signal 24592
	)
)

(instance percyEyes of Prop
	(properties
		x 71
		y 60
		view 3010
		loop 2
		priority 15
		signal 24592
	)
)

