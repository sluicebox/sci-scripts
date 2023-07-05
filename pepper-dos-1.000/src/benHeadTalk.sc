;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2014)
(include sci.sh)
(use Main)
(use TalkerWindow)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	benHeadTalk 0
	setUpBen 2
)

(local
	local0
	local1
	local2
)

(instance benHeadTalk of Talker
	(properties
		talkWidth 135
		color 1
		back 5
		view 2000
		textX 130
	)

	(method (dispose)
		(= gSystemWindow local0)
		(if (== global194 10)
			(gGame detailLevel: local2)
			(water dispose:)
		)
		(super dispose: &rest)
	)

	(method (init)
		(= local0 gSystemWindow)
		(= gSystemWindow TalkerWindow)
		(if (== global194 10)
			(= local2 (gGame _detailLevel:))
			(gGame detailLevel: 0)
			(water init: setCycle: Fwd)
		)
		(super init: 0 0 benEyes benFrame &rest)
	)
)

(instance water of Prop
	(properties
		x 71
		y 131
		view 3012
		loop 4
	)

	(method (init)
		(self setPri: 15)
		(super init: &rest)
	)
)

(instance benFrame of View
	(properties
		x 9
		y 14
		loop 3
		priority 15
		signal 24592
	)
)

(instance benEyes of Prop
	(properties
		loop 2
		priority 15
		signal 24592
	)
)

(instance setUpBen of Code
	(properties)

	(method (doit param1)
		(if (== gCurRoomNum 530)
			(= local1 1)
		)
		(switch param1
			(10
				(benHeadTalk view: 3012 x: 42 y: 109)
				(benFrame view: 3012)
				(benEyes view: 3012 x: 70 y: 68)
			)
			(98
				(benHeadTalk view: 3007 x: 38 y: 103)
				(benFrame view: 3007)
				(benEyes view: 3007 x: 66 y: 63)
			)
			(13
				(benHeadTalk view: 3008 y: 77)
				(if local1
					(benHeadTalk x: 250 textX: -155 textY: 10)
				else
					(benHeadTalk x: 85)
				)
				(benFrame view: 3008 x: (if local1 174 else 9))
				(benEyes view: 3008 x: (if local1 250 else 85) y: 78)
			)
		)
	)
)

