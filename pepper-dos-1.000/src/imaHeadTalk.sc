;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2018)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use TalkerWindow)
(use Talker)
(use Actor)

(public
	imaHeadTalk 0
	imaText 1
)

(local
	local0
)

(instance imaHeadTalk of Talker
	(properties
		x 46
		y 95
		talkWidth 110
		color 15
		back 41
		view 3009
		textX 145
	)

	(method (dispose)
		(= gSystemWindow local0)
		(super dispose: &rest)
	)

	(method (init)
		(= local0 gSystemWindow)
		(= gSystemWindow TalkerWindow)
		(super init: 0 0 imaEyes imaFrame &rest)
	)
)

(instance imaFrame of View
	(properties
		x 9
		y 14
		view 3009
		loop 3
		priority 15
		signal 26640
	)
)

(instance imaEyes of Prop
	(properties
		x 65
		y 76
		view 3009
		loop 2
		priority 15
		signal 26640
	)
)

(instance imaText of BalloonTalker
	(properties
		x 140
		y 80
		talkWidth 125
	)
)

