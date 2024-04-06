;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	rm15100 0
)

(instance rm15100 of ScaryRoom
	(properties
		picture 15100
		stepSound 4
	)

	(method (drawPic param1)
		(super drawPic: param1)
		(if (gCast contains: doorView)
			(switch param1
				(15100
					(doorView view: 15100 posn: 158 56 setPri: 91 show:)
				)
				(15120
					(doorView view: 15120 posn: 188 24 setPri: -1 show:)
				)
				(15130
					(doorView view: 15130 posn: 105 0 setPri: 10 show:)
				)
				(15140
					(doorView view: 15140 posn: 162 0 setPri: 60 show:)
				)
				(else
					(doorView hide:)
				)
			)
		)
		(if (gCast contains: paperView)
			(switch param1
				(15100
					(paperView view: 3582 posn: 163 90 setPri: 92 show:)
				)
				(15120
					(paperView view: 3581 posn: 205 109 setPri: -1 show:)
				)
				(15140
					(if (not (OneOf global198 3600 3610))
						(paperView view: 3583 posn: 172 122 setPri: -1 show:)
					else
						(paperView hide:)
					)
				)
				(else
					(paperView hide:)
				)
			)
		)
	)

	(method (notify)
		(underDoorScr register: 0 cue:)
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo init: setScaler: Scaler 160 44 153 91 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(14100
				(gEgo
					setScaler: Scaler 160 44 153 91
					normalize: 0
					posn: 144 91
				)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(14200
				(KillRobot)
				(gEgo
					setScaler: Scaler 160 44 153 91
					normalize: 0
					posn: 144 91
				)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(15200
				(gEgo normalize: 3 posn: 160 119)
				(if (and (IsFlag 120) (not (IsFlag 125)))
					(= picture 15140)
					(SetFlag 125)
					(self setScript: otherBabyScr)
				else
					(gCurRoom setScript: (ScriptID 0 5) self 10) ; takeLastStep
				)
			)
			(15500
				(gEgo normalize: 2 posn: 167 95)
				(= picture 15140)
				(doorView z: 1000)
				(gCurRoom setScript: from4thScr)
			)
			(19000
				(gEgo normalize: 2 posn: 167 95 hide:)
				(= picture 15140)
				(WalkieTalkie showFrame: 3651 0 0 0)
				(doorView z: 1000)
				(gCurRoom setScript: fromAtticScr)
			)
			(else
				(if (and (== gChapter 3) (IsFlag 120) (not (IsFlag 125)))
					(= picture 15140)
					(SetFlag 125)
					(self setScript: babyScr)
				else
					(= picture 15120)
					(self setScript: upTheStairs)
				)
			)
		)
		(cond
			((IsFlag 169)
				(upDoorExit init: 1)
			)
			((IsFlag 168)
				(upDoor init: setHotspot: 4 3 12 8 approachVerbs: 0) ; Do, Move, invStairKey, invLibKey
			)
			((IsFlag 167)
				(upDoor init: setHotspot: 4 3 12 8 9 approachVerbs: 0) ; Do, Move, invStairKey, invLibKey, invNewspaper
			)
			((IsFlag 170)
				(upDoor init: setHotspot: 4 3 7 12 8 approachVerbs: 0) ; Do, Move, invNail, invStairKey, invLibKey
			)
			((gEgo has: 2) ; invNail
				(upDoor init: setHotspot: 4 3 9 7 8 approachVerbs: 0) ; Do, Move, invNewspaper, invNail, invLibKey
			)
			(else
				(upDoor init: setHotspot: 4 3 7 8 approachVerbs: 0) ; Do, Move, invNail, invLibKey
			)
		)
		(if (and (IsFlag 167) (not (IsFlag 168)))
			(if (IsFlag 170)
				(underDoor init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
			else
				(underDoor init: setHotspot: 4 3 10 approachVerbs: 0) ; Do, Move, invPoker
			)
		)
		(doorView init:)
		(if (IsFlag 170)
			(paperView init:)
		)
		(nurseryDoor init: 4)
		(northExit init: 1)
		(southExit init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== gChapter 4)
				(OneOf newRoomNumber 14100 15500)
				(IsFlag 265)
				(not (IsFlag 3))
				(not (IsFlag 247))
			)
			(SetFlag 247)
			(ClearFlag 52)
		)
		(if
			(and
				(== gChapter 4)
				(OneOf newRoomNumber 14100 15500)
				(IsFlag 5)
				(not (IsFlag 325))
			)
			(SetFlag 325)
			(ClearFlag 264)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance doorView of View
	(properties
		x 158
		y 51
		view 15100
	)
)

(instance paperView of View
	(properties
		view 3581
	)
)

(instance sDownStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(if (and (== (gEgo x:) 167) (== (gEgo y:) 95))
						(gEgo setHeading: 270 self)
					else
						(gEgo setHeading: 0 self)
					)
				)
				(1
					(gEgo hide:)
					(DoRobot 1171 132 39 gEgo 5)
					(gCurRoom drawPic: 15120)
					(ClearFlag 121)
				)
				(2
					(if (gGDacSound handle:)
						(gGDacSound fade: 0 10 10 1 self)
					else
						(= cycles 2)
					)
				)
				(3
					(gCurRoom newRoom: 13500)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gGDacSound stop:)
					(gCurRoom newRoom: 13500)
				)
			)
		)
	)
)

(instance upTheStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 1170 125 39 gEgo 5)
				)
				(1
					(gEgo
						normalize: 2
						setScaler: Scaler 160 44 153 91
						posn: 145 95
					)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(gEgo
						normalize: 2
						setScaler: Scaler 160 44 153 91
						posn: 145 95
					)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance from4thScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3651 0 0)
				)
				(1
					(gEgo normalize: 2 posn: 167 95)
					(doorView z: 0)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 2 posn: 167 95)
					(doorView z: 0)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance fromAtticScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(gGame fade: 0 (gGame intensity:) 1)
					(KillRobot)
					(DoRobot 3651 0 0)
				)
				(2
					(gEgo normalize: 2 posn: 167 95 show:)
					(doorView z: 0)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 2 posn: 167 95 show:)
					(doorView z: 0)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance babyScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 2430 92 19 gEgo 40)
				)
				(1
					(gEgo
						normalize: 2
						setScaler: Scaler 160 44 153 91
						posn: 145 95
					)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo
						normalize: 2
						setScaler: Scaler 160 44 153 91
						posn: 145 95
					)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance otherBabyScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 2431 -3 23)
				)
				(1
					(gEgo
						normalize: 2
						setScaler: Scaler 160 44 153 91
						posn: 145 95
					)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo
						normalize: 2
						setScaler: Scaler 160 44 153 91
						posn: 145 95
					)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance paperUnderDoorScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3580 -12 -41)
					(gCurRoom drawPic: 15140)
					(SetFlag 170)
					(gEgo put: 3) ; invNewspaper
				)
				(1
					(gEgo normalize: 3 posn: 167 95)
					(paperView init:)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(paperView init:)
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(SetFlag 170)
					(gEgo put: 3) ; invNewspaper
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance tooLateScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3590 98 -5)
					(gCurRoom drawPic: 15140)
				)
				(1
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance unlockStairwellScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3630 119 -3 gEgo 200)
					(gCurRoom drawPic: 15140)
				)
				(1
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(upDoor dispose:)
					(upDoorExit init: 1)
					(SetFlag 169)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(SetFlag 169)
					(gEgo normalize: 3 posn: 167 95)
					(upDoor dispose:)
					(upDoorExit init: 1)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance openStairwellScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(if (not (IsFlag 46))
						(DoRobot 3640 130 0)
					else
						(DoRobot 3650 -2 0)
					)
					(doorView dispose:)
					(gCurRoom drawPic: 15140)
				)
				(1
					(if (not (IsFlag 46))
						(SetFlag 46)
						(WalkieTalkie showFrame: 3640 98 130 0)
					else
						(WalkieTalkie showFrame: 3650 28 -2 0)
					)
					(gCurRoom newRoom: 15500)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(SetFlag 46)
					(gCurRoom newRoom: 15500)
				)
			)
		)
	)
)

(instance noUseScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3542 133 -5)
					(gCurRoom drawPic: 15140)
				)
				(1
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance useNailScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3540 -7 -44)
					(gCurRoom drawPic: 15140)
				)
				(1
					(DoRobot 3541 -12 -42)
					(gCurRoom drawPic: 15130)
				)
				(2
					(gEgo put: 2) ; invNail
					(SetFlag 167)
					(underDoor init: setHotspot: 4 3 10 approachVerbs: 0) ; Do, Move, invPoker
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo put: 2) ; invNail
					(SetFlag 167)
					(underDoor init: setHotspot: 4 3 10 approachVerbs: 0) ; Do, Move, invPoker
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance useNailPaperScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3600 -10 -43)
					(paperView hide:)
					(gCurRoom drawPic: 15140)
				)
				(1
					(gEgo put: 2) ; invNail
					(SetFlag 167)
					(underDoor init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(paperView show:)
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gEgo put: 2) ; invNail
					(SetFlag 167)
					(underDoor init: setHotspot: 4 3 approachVerbs: 0) ; Do, Move
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance tryDoorScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 1180 -6 -44)
					(gCurRoom drawPic: 15140)
				)
				(1
					(DoRobot 1181 -13 -26)
					(gCurRoom drawPic: 15130)
				)
				(2
					(DoRobot 1182 -9 -43)
					(gCurRoom drawPic: 15140)
				)
				(3
					(gEgo view: 15150 loop: 0 cel: 0 x: 150 y: 73)
					(gCurRoom drawPic: 15150)
					(= seconds 5)
				)
				(4
					(DoRobot 1183 -9 -43)
					(gCurRoom drawPic: 15140)
				)
				(5
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(SetFlag 93)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(SetFlag 93)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance tryDoorAgainScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 1190 -9 -43)
					(gCurRoom drawPic: 15140)
				)
				(1
					(gEgo view: 15150 loop: 0 cel: 0 x: 150 y: 73)
					(gCurRoom drawPic: 15150)
					(= seconds 5)
				)
				(2
					(DoRobot 1191 -9 -43)
					(gCurRoom drawPic: 15140)
				)
				(3
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance startUnderDoorScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 167) (== (gEgo y:) 95))
							(self cue:)
						)
						((and (== (gEgo x:) 160) (== (gEgo y:) 119))
							(gEgo setHeading: 0 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(DoRobot 3550 77 -16)
					(gCurRoom drawPic: 15140)
				)
				(2
					(gCurRoom setScript: underDoorScr)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom setScript: underDoorScr)
				)
			)
		)
	)
)

(instance underDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				(gCurRoom drawPic: 15160)
				(proc1111_8)
				(theKey init: setHotspot: 4 3) ; Do, Move
				((ScriptID 0 14) init:) ; exitButt
				(gGame handsOn: 0)
			)
			(1
				(gGame handsOff:)
				(theKey dispose:)
				(proc1111_9)
				(ClearFlag 121)
				(if register
					(gCurRoom setScript: cantReachScr)
				else
					(gCurRoom setScript: justStandUpScr)
				)
			)
		)
	)
)

(instance theKey of View
	(properties
		x 230
		y 75
		view 15160
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(underDoorScr register: 1 cue:)
				((ScriptID 0 14) dispose:) ; exitButt
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cantReachScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3560 -17 -42)
					(gCurRoom drawPic: 15140)
				)
				(1
					(gEgo normalize: 3 posn: 167 95 show:)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95 show:)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance justStandUpScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 3570 86 1)
					(gCurRoom drawPic: 15140)
				)
				(1
					(gEgo normalize: 3 posn: 167 95 show:)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95 show:)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance keyOnPaperScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 167) (== (gEgo y:) 95))
							(self cue:)
						)
						((and (== (gEgo x:) 160) (== (gEgo y:) 119))
							(gEgo setHeading: 0 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(DoRobot 3610 -8 -41)
					(paperView dispose:)
					(gCurRoom drawPic: 15140)
				)
				(2
					(gEgo normalize: 3 posn: 167 95 show:)
					(gCurRoom drawPic: 15100)
					(upDoor setHotspot: 4 3 12 8) ; Do, Move, invStairKey, invLibKey
					(underDoor dispose:)
					(SetFlag 168)
					(ClearFlag 170)
					(gEgo get: 6 3) ; invStairKey
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo normalize: 3 posn: 167 95 show:)
					(= global115 0)
					(gCurRoom drawPic: 15100)
					(upDoor setHotspot: 4 3 12 8) ; Do, Move, invStairKey, invLibKey
					(underDoor dispose:)
					(SetFlag 168)
					(ClearFlag 170)
					(paperView dispose:)
					(gEgo get: 6 3) ; invStairKey
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance keyWithPokerScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 167) (== (gEgo y:) 95))
							(self cue:)
						)
						((and (== (gEgo x:) 160) (== (gEgo y:) 119))
							(gEgo setHeading: 0 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(DoRobot 3620 75 11)
					(gCurRoom drawPic: 15140)
				)
				(2
					(gEgo normalize: 3 posn: 167 95 get: 6) ; invStairKey
					(gCurRoom drawPic: 15100)
					(upDoor setHotspot: 4 3 12 8) ; Do, Move, invStairKey, invLibKey
					(underDoor dispose:)
					(SetFlag 168)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95 get: 6) ; invStairKey
					(gCurRoom drawPic: 15100)
					(upDoor setHotspot: 4 3 12 8) ; Do, Move, invStairKey, invLibKey
					(underDoor dispose:)
					(SetFlag 168)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance libKeyScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 1970 125 -6)
					(gCurRoom drawPic: 15140)
				)
				(1
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 3 posn: 167 95)
					(gCurRoom drawPic: 15100)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance thruNurseryDoorScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(if (not global115)
			(switch (= state newState)
				(0
					(cond
						((and (== (gEgo x:) 160) (== (gEgo y:) 119))
							(gEgo setHeading: 0 self)
						)
						(
							(or
								(and (== (gEgo x:) 144) (== (gEgo y:) 91))
								(and (== (gEgo x:) 145) (== (gEgo y:) 95))
							)
							(gEgo setHeading: 270 self 15)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(cond
						(
							(or
								(not (OneOf gChapter 2 3))
								(not (IsFlag 120))
								(IsFlag 119)
							)
							(gCurRoom newRoom: 14100)
						)
						((gGDacSound handle:)
							(gGDacSound fade: 0 10 10 1 self)
						)
						(else
							(gCurRoom newRoom: 14200)
						)
					)
				)
				(2
					(gCurRoom newRoom: 14200)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(if
						(and
							(OneOf gChapter 2 3)
							(IsFlag 120)
							(not (IsFlag 119))
						)
						(if (gGDacSound handle:)
							(gGDacSound stop:)
						)
						(gCurRoom newRoom: 14200)
					else
						(gCurRoom newRoom: 14100)
					)
				)
			)
		)
	)
)

(instance toUpDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (== (gEgo x:) 167) (== (gEgo y:) 95))
						(self cue:)
					)
					((and (== (gEgo x:) 160) (== (gEgo y:) 119))
						(gEgo setHeading: 0 self)
					)
					(else
						(gEgo setHeading: 90 self)
					)
				)
			)
			(1
				(switch register
					(4
						(cond
							((IsFlag 169)
								(gCurRoom setScript: openStairwellScr)
							)
							((or (IsFlag 170) (IsFlag 167))
								(gCurRoom setScript: noUseScr)
							)
							((IsFlag 166)
								(gCurRoom setScript: tryDoorAgainScr)
							)
							(else
								(SetFlag 166)
								(gCurRoom setScript: tryDoorScr)
							)
						)
					)
					(7
						(if (IsFlag 170)
							(gCurRoom setScript: useNailPaperScr)
						else
							(gCurRoom setScript: useNailScr)
						)
					)
					(9
						(cond
							((IsFlag 170)
								(= cycles 1)
							)
							((IsFlag 167)
								(gCurRoom setScript: tooLateScr)
							)
							(else
								(gCurRoom setScript: paperUnderDoorScr)
							)
						)
					)
					(12
						(gCurRoom setScript: unlockStairwellScr)
					)
					(8
						(if (IsFlag 169)
							(= cycles 1)
						else
							(gCurRoom setScript: libKeyScr)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gGame pragmaFail:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(ClearFlag 121)
		(super dispose:)
	)
)

(instance toUpDoorExitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (== (gEgo x:) 167) (== (gEgo y:) 95))
						(gEgo setHeading: 0 self 20)
					)
					((and (== (gEgo x:) 160) (== (gEgo y:) 119))
						(gEgo setHeading: 0 self)
					)
					(else
						(gEgo setHeading: 90 self)
					)
				)
			)
			(1
				(gCurRoom setScript: openStairwellScr)
			)
		)
	)

	(method (dispose)
		(ClearFlag 121)
		(super dispose:)
	)
)

(instance upDoorExit of ExitFeature
	(properties
		nsLeft 162
		nsTop 65
		nsRight 180
		nsBottom 80
		approachX 167
		approachY 92
		x 171
		y 80
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(SetFlag 121)
			(gCurRoom setScript: toUpDoorExitScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance upDoor of Feature
	(properties
		nsLeft 162
		nsTop 65
		nsRight 180
		nsBottom 80
		approachX 167
		approachY 92
		x 171
		y 80
	)

	(method (handleEvent event)
		(if (and (== global163 underDoor) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 4) (scratch respondsTo: theVerb)) ; Do
			(gGame handsOff:)
			(SetFlag 121)
			(gCurRoom setScript: toUpDoorScr 0 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance underDoor of Feature
	(properties
		nsLeft 158
		nsTop 86
		nsRight 177
		nsBottom 99
		approachX 170
		approachY 92
		x 167
		y 81
	)

	(method (handleEvent event)
		(if (and (== global163 upDoor) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(if (IsFlag 170)
					(gCurRoom setScript: keyOnPaperScr)
				else
					(gCurRoom setScript: startUnderDoorScr)
				)
			)
			(10 ; invPoker
				(gGame handsOff:)
				(gCurRoom setScript: keyWithPokerScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 136
		nsTop 38
		nsRight 151
		nsBottom 84
		sightAngle 360
		approachX 144
		approachY 82
		nextRoom 13500
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(SetFlag 121)
			(gCurRoom setScript: sDownStairs)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance nurseryDoor of ExitFeature
	(properties
		nsLeft 126
		nsTop 54
		nsRight 135
		nsBottom 93
		approachX 144
		approachY 91
		x 130
		y 93
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(if (and (== gChapter 1) (>= global172 3) (not (IsFlag 83)))
				(SetFlag 53)
			)
			(if global184
				(IsFlag 120)
			)
			(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
				(SetFlag 181)
			)
			(gCurRoom setScript: thruNurseryDoorScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 89
		nsRight 246
		approachX 160
		approachY 200
		nextRoom 15200
		interRoom 11
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(if
				(and
					(not (IsFlag 120))
					(not (IsFlag 125))
					(not (IsFlag 119))
					(OneOf gChapter 2 3)
				)
				(SetFlag 120)
			)
			(gCurRoom newRoom: nextRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

