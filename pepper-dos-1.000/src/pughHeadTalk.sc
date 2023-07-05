;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2006)
(include sci.sh)
(use Main)
(use TalkerWindow)
(use Talker)
(use Actor)

(public
	pughHeadTalk 0
)

(local
	local0
)

(instance pughHeadTalk of Talker
	(properties
		x 23
		y 108
		talkWidth 110
		color 1
		back 5
		view 3000
		textX 130
	)

	(method (dispose)
		(= gSystemWindow local0)
		(super dispose: &rest)
	)

	(method (init)
		(= local0 gSystemWindow)
		(= gSystemWindow TalkerWindow)
		(super init: 0 0 pughEyes pughFrame &rest)
	)
)

(instance pughFrame of View
	(properties
		x 9
		y 14
		view 3000
		loop 3
		priority 15
		signal 24592
	)
)

(instance pughEyes of Prop
	(properties
		x 61
		y 66
		view 3000
		loop 2
		priority 15
		signal 24592
	)
)

