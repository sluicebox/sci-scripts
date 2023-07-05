;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2600)
(include sci.sh)
(use Main)
(use ExitFeature)
(use RandCycle)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm2600 0
)

(instance rm2600 of ScaryRoom
	(properties
		picture 2320
	)

	(method (init)
		(if (== gChapter 5)
			(= picture 2321)
		)
		(gEgo posn: 22 111 view: 330 loop: 0 cel: 0 scaleSignal: 0 init:)
		(gEgo cycleSpeed: 8)
		(poker
			init:
			posn: (+ (gEgo x:) 73) (- (gEgo y:) 11)
			setHotspot: 4 3 ; Do, Move
		)
		(super init:)
		(if (== gChapter 5)
			(Load rsPIC 2341)
		else
			(Load rsPIC 2340)
		)
		(fire init:)
		(southExit init: 3 _approachVerbs: 0)
		(westExit init: 4 _approachVerbs: 0)
		(self setScript: getOnYourKnees)
	)
)

(instance getOnYourKnees of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setCycle: End self)
				)
				(1
					(gGame handsOn: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo view: 330 setCycle: 0 loop: 0)
					(gEgo cel: (gEgo lastCel:))
					(= global115 0)
					(gGame handsOn:)
					(User canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 4
	)
)

(instance getPoker of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo
						view: 331
						posn: 46 119
						loop: 0
						cel: 0
						setCycle: CT 6 1 self
					)
					(gEgo cycleSpeed: 8)
				)
				(1
					(sfx number: 2011 setLoop: 1 play:)
					(gEgo setCycle: End self)
					(poker dispose:)
				)
				(2
					(if (== gChapter 5)
						(gCurRoom drawPic: 2321)
					else
						(gCurRoom drawPic: 2320)
					)
					(gEgo view: 330 loop: 0)
					(gEgo
						posn: 22 111
						cel: (gEgo lastCel:)
						get: 4 ; invPoker
						setCycle: Beg self
					)
					(gEgo cycleSpeed: 8)
				)
				(3
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(= global115 0)
			(gEgo get: 4) ; invPoker
			(gCurRoom newRoom: 2200)
		)
	)
)

(instance standUpScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setCycle: Beg self)
					(gEgo cycleSpeed: 8)
				)
				(1
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo setCycle: 0)
					(= global115 0)
					(gCurRoom newRoom: 2200)
				)
			)
		)
	)
)

(instance poker of View
	(properties
		x 94
		y 100
		view 332
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: getPoker)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		x 159
		y 133
		nextRoom 2200
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: standUpScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fire of Prop
	(properties
		x 165
		y 107
		fixPriority 1
		view 2320
	)

	(method (init)
		(if (== gChapter 5)
			(= view 2321)
		)
		(super init: &rest)
		(self cycleSpeed: 8 setCycle: RandCycle -1)
	)
)

(instance westExit of ExitFeature
	(properties
		x 22
		y 67
		nextRoom 2200
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: standUpScr)
		else
			(super doVerb: theVerb)
		)
	)
)

