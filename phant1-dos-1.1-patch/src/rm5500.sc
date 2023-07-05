;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5500)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Feature)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	rm5500 0
)

(instance rm5500 of ScaryRoom
	(properties
		stepSound 4
	)

	(method (init)
		(= picture
			(cond
				((IsFlag 159) 5312)
				((IsFlag 158) 5311)
				(else 5310)
			)
		)
		(cond
			((IsFlag 159)
				(holeExit init: 1)
			)
			((not (IsFlag 158))
				(fireplace init: setHotspot: 4 3) ; Do, Move
			)
			((and (not (IsFlag 107)) (not (IsFlag 108)))
				(fireplace init: setHotspot: 4 3 10 11 35) ; Do, Move, invPoker, invHammer, ???
			)
			((and (IsFlag 107) (IsFlag 108))
				(fireplace init: setHotspot: 4 3 35) ; Do, Move, ???
			)
			((IsFlag 107)
				(fireplace init: setHotspot: 4 3 11 35) ; Do, Move, invHammer, ???
			)
			((IsFlag 108)
				(fireplace init: setHotspot: 4 3 10 35) ; Do, Move, invPoker, ???
			)
		)
		(gEgo init: hide:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(gUser canControl: 0)
			)
			(else
				(gGame handsOn:)
				(gUser canControl: 0)
			)
		)
		(super init:)
		(southExit init: 3)
		(westExit init: 4)
	)
)

(instance sHandBricks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 2070 64 6)
					(gCurRoom drawPic: 5304)
				)
				(1
					(global114 pause:)
					(gCurRoom drawPic: 6550)
					(gGDacSound number: 5012 init: setLoop: 1 play: self)
				)
				(2
					(global114 endPause:)
					(proc1111_7 2071 54 6)
					(gCurRoom drawPic: -1)
				)
				(3
					(proc1111_7 2072 79 8)
					(gCurRoom drawPic: 5304)
				)
				(4
					(SetFlag 96)
					(gCurRoom drawPic: 5311)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gCurRoom drawPic: 5311)
					(global114 endPause: 1)
					(= global115 0)
					(SetFlag 96)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sPokerBricks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 2080 10 -9)
					(gCurRoom drawPic: 5304)
				)
				(1
					(gCurRoom drawPic: 5311)
					(if (IsFlag 108)
						(fireplace setHotspot: 4 3 35) ; Do, Move, ???
					else
						(fireplace setHotspot: 4 3 11 35) ; Do, Move, invHammer, ???
					)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom drawPic: 5311)
					(if (IsFlag 108)
						(fireplace setHotspot: 4 3 35) ; Do, Move, ???
					else
						(fireplace setHotspot: 4 3 11 35) ; Do, Move, invHammer, ???
					)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sHammerBricks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_7 2090 64 19)
					(gCurRoom drawPic: 5304)
				)
				(1
					(gCurRoom drawPic: 5311)
					(if (IsFlag 107)
						(fireplace setHotspot: 4 3 35) ; Do, Move, ???
					else
						(fireplace setHotspot: 4 3 10 35) ; Do, Move, invPoker, ???
					)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom drawPic: 5311)
					(if (IsFlag 107)
						(fireplace setHotspot: 4 3 35) ; Do, Move, ???
					else
						(fireplace setHotspot: 4 3 10 35) ; Do, Move, invPoker, ???
					)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFigurineBricks of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gCurRoom drawPic: -1)
					(gCurRoom picture: -1)
					(PlayVMD 0 {2100.vmd}) ; Open
					(proc26_0 2100 self)
				)
				(1
					(gEgo put: 21 5500) ; invFigurine
					(gCurRoom newRoom: 5100)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gEgo put: 21 5500) ; invFigurine
					(gCurRoom newRoom: 5100)
				)
			)
		)
	)
)

(instance sEnterChapel of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gCurRoom drawPic: 5305)
					(proc1111_6)
					(proc1111_7 2110 76 13 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 6500)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gCurRoom newRoom: 6500)
				)
			)
		)
	)
)

(instance sBrickFalls of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 158)
					(mantel init: setPri: 200)
					(proc1111_7 2051 68 -5)
					(brick init:)
					(gCurRoom drawPic: 5304)
				)
				(1)
				(2
					(brick dispose:)
				)
				(3)
				(4
					(mantel dispose:)
					(gCurRoom drawPic: 5311 0 1)
					(fireplace setHotspot: 4 3 10 11 35) ; Do, Move, invPoker, invHammer, ???
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 158)
					(proc1111_6)
					(if (gCast contains: mantel)
						(mantel dispose:)
					)
					(brick dispose:)
					(gCurRoom drawPic: 5311 0 1)
					(fireplace setHotspot: 4 3 10 11 35) ; Do, Move, invPoker, invHammer, ???
					(= global115 0)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance mantel of View
	(properties
		x 125
		y 39
		view 5307
	)
)

(instance brick of View
	(properties
		x 148
		y 61
		view 5304
	)
)

(instance fireplace of Feature
	(properties
		nsLeft 64
		nsTop 32
		nsRight 225
		nsBottom 91
		approachX 102
		approachY 126
		x 120
		y 92
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 158))
						(gGame handsOff:)
						(gCurRoom setScript: sBrickFalls)
					)
					((IsFlag 159)
						(gCurRoom newRoom: 6500)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: sHandBricks)
					)
				)
			)
			(10 ; invPoker
				(gGame handsOff:)
				(SetFlag 107)
				(gCurRoom setScript: sPokerBricks)
			)
			(11 ; invHammer
				(gGame handsOff:)
				(SetFlag 108)
				(gCurRoom setScript: sHammerBricks)
			)
			(35 ; ???
				(gGame handsOff:)
				(SetFlag 159)
				(gCurRoom setScript: sFigurineBricks)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance holeExit of ExitFeature
	(properties
		nsLeft 64
		nsTop 32
		nsRight 225
		nsBottom 91
		approachX 102
		approachY 126
		x 120
		y 92
		z 42
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(WalkieTalkie showFrame: 2110 0 76 13)
			(gCurRoom setScript: sEnterChapel)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nextRoom 5100
		appYOffset 20
	)
)

(instance westExit of ExitFeature
	(properties
		nextRoom 5100
	)
)

