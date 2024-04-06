;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1800)
(include sci.sh)
(use Main)
(use Trigger)
(use n1111)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1800 0
)

(local
	local0
	local1
)

(instance rm1800 of ScaryRoom
	(properties
		picture 1801
	)

	(method (init)
		(gGame handsOff:)
		(gEgo view: 1802 setLoop: 0 1 x: 148 y: 117 setScale: 0 init:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(20100
				(SetFlag 6)
				(SetFlag 7)
				(SetFlag 8)
				(KillRobot)
				(= picture 1800)
				(gEgo view: 1802 setLoop: 0 1 x: 148 y: 117 hide:)
				(WalkieTalkie showFrame: 660 0 64 8)
				(self setScript: sComeUp)
			)
			(else
				(ClearFlag 8)
				(if (and (== global125 59) (== gPrevRoomNum 1700))
					(= global125 0)
					(gEgo x: 148 y: 117 hide:)
					(gGame handsOff:)
					(gCurRoom setScript: sMoveRug)
				else
					(gEgo x: 148 y: 117)
				)
			)
		)
		(pantryDoor init:)
		(switch global125
			(49
				(= picture 1600)
				(self setScript: sCantOpenTrap)
			)
			(else
				(if (not (== gPrevRoomNum 20100))
					(gGame handsOn:)
				)
			)
		)
		(super init: &rest)
		(if (IsFlag 6)
			(and (!= global125 49) (!= gPrevRoomNum 20100))
			(cond
				((not (IsFlag 7))
					(if (!= gPrevRoomNum 20100)
						(trapDoor init:)
					)
				)
				((IsFlag 8)
					(trapExit init:)
					(if (!= gPrevRoomNum 20100)
						(trapDoor init:)
					)
				)
				((!= gPrevRoomNum 20100)
					(trapDoor init:)
				)
			)
		else
			(bigRug init:)
			(aRug init:)
		)
		(= global125 0)
		(egoFeature1 init:)
		(egoFeature2 init:)
		(egoFeature3 init:)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
	)

	(method (dispose)
		(trapSnd dispose:)
		(super dispose: &rest)
	)
)

(instance sComeUp of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(KillRobot)
					(SetFlag 8)
					(if (gCast contains: movedRug)
						(movedRug dispose:)
					)
					(gEgo hide:)
					(trapDoor init: setPri: 195)
					(DoRobot 660 64 8)
				)
				(1
					(trapDoor dispose:)
					(gEgo
						view: 1802
						setLoop: 0 1
						x: 148
						y: 117
						setScaler: 0
						show:
					)
					(gCurRoom drawPic: 1801 picture: 1801)
					(trapDoor setPri: 130 init:)
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
						view: 1802
						setLoop: 0 1
						x: 148
						y: 117
						setScale: 0
						show:
					)
					(if (gCast contains: movedRug)
						(movedRug dispose:)
					)
					(gCurRoom drawPic: 1801 picture: 1801)
					(trapDoor setPri: 130 init:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sNoMatch of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(egoFeature1 setHotspot: 0 14) ; invMatch
					(egoFeature2 setHotspot: 0 14) ; invMatch
					(egoFeature3 setHotspot: 0 14) ; invMatch
					(if (gCast contains: movedRug)
						(movedRug dispose:)
					)
					(trapDoor x: 204 cel: 1 setPri: 100)
					(gCurRoom drawPic: 1800)
					(DoRobot 550 77 -15 gEgo 1 1)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(trapDoor setPri: 4)
		(if global115
			(= global115 0)
		)
		(SetFlag 382)
		(if (gCast contains: movedRug)
			(movedRug dispose:)
		)
		(gCurRoom drawPic: 1801 picture: 1801)
		(trapDoor x: 138 cel: 0 show:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sLightMatch of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(trapDoor x: 204 cel: 1 setPri: 195)
					(movedRug dispose:)
					(gCurRoom drawPic: 1800)
					(DoRobot 530 69 -14 gEgo -1 1)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(= global115 0)
		)
		(= gNewRoomNum 20230)
		(super dispose: &rest)
	)
)

(instance sCloseTrapDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(trapDoor dispose:)
					(if (!= (gCurRoom picture:) 1800)
						(gCurRoom drawPic: 1800 picture: 1800)
					)
					(movedRug init:)
					(DoRobot 260 1 1)
				)
				(1
					(gEgo show:)
					(if (gCast contains: movedRug)
						(movedRug dispose:)
					)
					(ClearFlag 8)
					(gCurRoom drawPic: 1801 picture: 1801)
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(ClearFlag 8)
		(if (gCast contains: movedRug)
			(movedRug dispose:)
		)
		(gCurRoom drawPic: 1801 picture: 1801)
		(trapDoor setPri: 130 init:)
		(egoFeature1 setHotspot: 0)
		(egoFeature2 setHotspot: 0)
		(egoFeature3 setHotspot: 0)
		(gGame handsOn:)
		(= global115 0)
		(trapExit dispose:)
		(super dispose: &rest)
	)
)

(instance sCTrapDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(trapDoor dispose:)
					(gCurRoom drawPic: 1800 picture: 1800)
					(movedRug init:)
					(DoRobot 260 1 1 gEgo -1 1)
				)
				(1
					(gEgo hide:)
					(ClearFlag 8)
					(gCurRoom newRoom: 1700)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(gEgo hide:)
		(ClearFlag 8)
		(movedRug dispose:)
		(gCurRoom newRoom: 1700)
		(= global115 0)
		(trapExit dispose:)
		(super dispose: &rest)
	)
)

(instance sMoveRug of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(trapDoor dispose:)
					(DoRobot 213 82 6 gEgo 10 1)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(= global115 0)
		(movedRug dispose:)
		(trapDoor init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sDownStairs of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(movedRug dispose:)
					(trapDoor x: 204 cel: 1 setPri: 130)
					(gEgo
						view: 560
						loop: 0
						cel: 0
						posn: 114 118
						show:
						setScale: 0
						setPri: 118
						setCycle: End self
					)
					(gCurRoom drawPic: 1800)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(= gNewRoomNum 20100)
		(super dispose: &rest)
	)
)

(instance sCantOpenTrap of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(movedRug init:)
					(DoRobot 222 90 -29)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(gEgo view: 1802 setLoop: 0 1 x: 148 y: 117 setCycle: 0 show:)
		(if (gCast contains: movedRug)
			(movedRug dispose:)
		)
		(if (!= (gCurRoom picture:) 1801)
			(gCurRoom drawPic: 1801 picture: 1801)
		)
		(trapDoor init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sFeelRug of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 210
						show:
						cel: 0
						setLoop: 0 1
						x: 123
						y: 120
						setScale: 0
						setScale: 0
						cycleSpeed: 8
						setPri: 196
					)
					(gCurRoom drawPic: 1800 picture: 1800)
					(aRug init:)
					(bigRug init: setPri: 195)
					(= cycles 2)
				)
				(1
					(Load 140 1020) ; WAVE
					(Load rsVIEW 211)
					(gEgo setCycle: End self)
				)
				(2
					(gEgo hide:)
					(gEgo
						view: 211
						setLoop: 0 1
						cel: 0
						x: 113
						y: 69
						cycleSpeed: 6
						setPri: -1
						show:
					)
					(= local0
						((View new:)
							view: 212
							setLoop: 0 1
							cel: 0
							x: 145
							y: 129
							setPri: 20
							init:
						)
					)
					(gCurRoom drawPic: 1810 picture: 1810)
					(bigRug dispose:)
					(aRug dispose:)
					(= cycles 2)
				)
				(3
					(gEgo setCycle: CT 8 1 self)
				)
				(4
					(= ticks 30)
				)
				(5
					(gEgo setCycle: CT 11 1 self)
				)
				(6
					(gEgo setCycle: CT 8 -1 self)
				)
				(7
					(gEgo setCycle: End self)
				)
				(8
					(DoRobot 212 32 7)
					(gCurRoom drawPic: 1701 picture: 1701)
					(if local0
						(local0 dispose:)
						(= local0 0)
					)
				)
				(9
					(gEgo hide:)
					(DoRobot 213 82 6 gEgo 10 1)
					(gCurRoom drawPic: 1800 picture: 1800)
					(movedRug init:)
					(trapDoor init:)
				)
				(10
					(= ticks 30)
				)
				(11
					(KillRobot)
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(gEgo view: 1802 setLoop: 0 1 x: 148 y: 117 setCycle: 0 show:)
		(KillRobot)
		(= global115 0)
		(if local0
			(local0 dispose:)
		)
		(bigRug dispose:)
		(aRug dispose:)
		(movedRug dispose:)
		(SetFlag 6)
		(if (!= (gCurRoom picture:) 1801)
			(gCurRoom drawPic: 1801 picture: 1801)
		)
		(trapDoor init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sHandTrapdoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 220 71 -40)
					(gCurRoom drawPic: 1600 picture: 1600)
					(movedRug init:)
					(trapDoor dispose:)
				)
				(1
					(movedRug dispose:)
					(gEgo
						view: 221
						setLoop: 0 1
						cel: 0
						posn: 153 120
						show:
						setScale: 0
						setCycle: End self
					)
					(gCurRoom drawPic: 1701 picture: 1701)
					(movedRug init:)
					(if local1
						(trapSnd number: 1023)
					else
						(= local1 1)
					)
					(Lock 140 1021 1) ; WAVE
					(trapSnd play:)
					(trapSnd setVol: 127)
				)
				(2
					(trapSnd stop:)
					(Lock 140 1021 0) ; WAVE
					(movedRug dispose:)
					(trapDoor dispose:)
					(gEgo hide:)
					(DoRobot 213 82 6 gEgo -1 1)
					(gCurRoom drawPic: 1800 picture: 1800)
					(movedRug init:)
					(trapDoor init:)
				)
				(3
					(= cycles 2)
				)
				(4
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(= local1 1)
		(KillRobot)
		(trapSnd stop:)
		(Lock 140 1021 0) ; WAVE
		(if global115
			(= global115 0)
		)
		(= global125 0)
		(gEgo view: 1802 setLoop: 0 1 x: 148 y: 117 setCycle: 0 show:)
		(if (gCast contains: movedRug)
			(movedRug dispose:)
		)
		(if (!= (gCurRoom picture:) 1801)
			(gCurRoom drawPic: 1801 picture: 1801)
		)
		(trapDoor init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sOpenTrapDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(movedRug dispose:)
					(trapDoor dispose:)
					(gGame handsOff:)
					(if (IsFlag 382)
						(egoFeature1 setHotspot: 0 14) ; invMatch
						(egoFeature2 setHotspot: 0 14) ; invMatch
						(egoFeature3 setHotspot: 0 14) ; invMatch
					)
					(Load rsVIEW 259)
					(DoRobot 270 3 1 gEgo -1 1)
					(gCurRoom drawPic: 1800 picture: 1800)
					(movedRug init:)
				)
				(1
					(gEgo show:)
					(movedRug dispose:)
					(SetFlag 8)
					(gCurRoom drawPic: 1801 picture: 1801)
					(KillRobot)
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(if global115
			(= global115 0)
		)
		(if (gCast contains: movedRug)
			(movedRug dispose:)
		)
		(gCurRoom drawPic: 1801 picture: 1801)
		(gEgo show:)
		(SetFlag 8)
		(trapExit init:)
		(trapDoor init:)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance sPokerTrapdoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 7)
					(SetFlag 8)
					(gEgo hide:)
					(DoRobot 230 -30 -76 gEgo -1 1)
					(gCurRoom drawPic: 1600 picture: 1600)
					(movedRug init:)
					(trapDoor dispose:)
				)
				(1
					(KillRobot)
					(movedRug dispose:)
					(gEgo
						view: 221
						setLoop: 0 1
						cel: 0
						posn: 152 120
						setCycle: CT 14 1 self
						show:
					)
					(gCurRoom drawPic: 1701 picture: 1701)
					(= register (View new:))
					(register view: 1703 x: 174 y: 141 setPri: 0 init:)
					(Load rsSOUND 1022)
					(movedRug init:)
				)
				(2
					(register dispose:)
					(= register 0)
					(movedRug dispose:)
					(global114 pause: 1022)
					(DoRobot 240 96 6)
					(gCurRoom drawPic: 1900 picture: 1900)
				)
				(3
					(SetFlag 8)
					(gEgo hide:)
					(DoRobot 271 -4 0 gEgo -1 1)
					(gCurRoom drawPic: 1800 picture: 1800)
				)
				(4
					(= ticks 30)
				)
				(5
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(KillRobot)
		(if register
			(register dispose:)
		)
		(global114 endPause:)
		(if global115
			(= global115 0)
		)
		(gEgo view: 1802 setLoop: 0 1 x: 148 y: 117 setCycle: 0 show:)
		(trapExit init:)
		(if (gCast contains: movedRug)
			(movedRug dispose:)
		)
		(if (!= (gCurRoom picture:) 1801)
			(gCurRoom drawPic: 1801 picture: 1801)
		)
		(trapDoor init:)
		(= global125 0)
		(gGame handsOn:)
		(super dispose: &rest)
	)
)

(instance movedRug of View
	(properties
		sightAngle 360
		approachDist 10
		view 1801
	)

	(method (init)
		(switch (gCurRoom picture:)
			(1800
				(= view 1801)
				(= x 169)
				(= y 119)
				(= cel 0)
			)
			(1600
				(= view 1601)
				(= x 58)
				(= y 108)
				(= cel 0)
			)
			(1701
				(= view 199)
				(= x 71)
				(= y 102)
				(= loop 1)
			)
			(else
				(= view 1801)
				(= x 192)
				(= y 127)
				(= cel 1)
				(self hide:)
			)
		)
		(super init: &rest)
	)
)

(instance aRug of Feature
	(properties
		nsLeft 123
		nsTop 112
		nsRight 202
		nsBottom 125
		approachX 158
		approachY 120
		x 162
		y 118
	)

	(method (init)
		(self setHotspot: 4 3 approachVerbs: 0) ; Do, Move
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (not (IsFlag 6)) (== theVerb 4)) ; Do
			(gCurRoom setScript: sFeelRug)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bigRug of View
	(properties
		sightAngle 360
		approachDist 10
		fixPriority 1
		view 1820
	)

	(method (init)
		(if (== (gCurRoom picture:) 1800)
			(= x 96)
			(= y 135)
			(= cel 0)
			(= priority 170)
		else
			(= x 85)
			(= y 136)
			(= cel 1)
			(= priority 195)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (not (IsFlag 6)) (== theVerb 4)) ; Do
			(gCurRoom setScript: sFeelRug)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance trapDoor of View
	(properties
		sightAngle 40
		approachX 100
		approachY 100
		approachDist 10
		y 123
		fixPriority 1
		view 259
	)

	(method (init)
		(if (IsFlag 8)
			(= loop 1)
			(trapExit init:)
		else
			(= loop 0)
		)
		(if (== (gCurRoom picture:) 1800)
			(= x 204)
			(= cel 1)
			(= priority 4)
		else
			(if (IsFlag 8)
				(= x 138)
			else
				(= x 167)
			)
			(= cel 0)
			(= priority 4)
		)
		(if (IsFlag 7)
			(self approachVerbs: 0 setHotspot: 4 3 21) ; Do, Move, Exit
		else
			(self approachVerbs: 0 setHotspot: 4 3 10 21) ; Do, Move, invPoker, Exit
		)
		(super init: &rest)
		(self signal: (| (self signal:) $1000))
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 4 21) ; Do, Exit
				(cond
					((IsFlag 8)
						(gCurRoom setScript: sCloseTrapDoor)
					)
					((IsFlag 7)
						(gCurRoom setScript: sOpenTrapDoor)
					)
					(else
						(gCurRoom setScript: sHandTrapdoor)
					)
				)
			)
			((and (not (IsFlag 7)) (== theVerb 10)) ; invPoker
				(gCurRoom setScript: sPokerTrapdoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trapExit of Trigger
	(properties
		nsLeft 148
		nsTop 113
		nsRight 201
		nsBottom 129
		approachDist 10
		exitDir 12
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 21 4)) ; Exit, Do
				(super doVerb: theVerb)
			)
			((and (IsFlag 8) (IsFlag 27))
				(gCurRoom setScript: sDownStairs)
			)
			((not (IsFlag 8))
				(gCurRoom setScript: sOpenTrapDoor)
			)
			(else
				(gCurRoom setScript: sNoMatch)
			)
		)
	)
)

(instance pantryDoor of Trigger
	(properties
		approachDist 10
		y 1
		exitDir 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 1 210 1 208 123 144 112
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			(
				(and
					(or
						(egoFeature1 onMe: gMouseX gMouseY)
						(egoFeature2 onMe: gMouseX gMouseY)
						(egoFeature3 onMe: gMouseX gMouseY)
					)
					(IsFlag 8)
					(== theVerb 14) ; invMatch
				)
				(gCurRoom setScript: sLightMatch)
			)
			((not (OneOf theVerb 21 4 3)) ; Exit, Do, Move
				(super doVerb: theVerb)
			)
			((IsFlag 8)
				(gCurRoom setScript: sCTrapDoor)
			)
			(else
				(gCurRoom newRoom: 1700)
			)
		)
	)
)

(instance egoFeature1 of Feature
	(properties
		y 100
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 160 25 165 23 165 20 163 20 161 13 163 10 163 5 169 3 177 5 182 21 186 31 185 39 156 40
				yourself:
			)
		)
		(self approachVerbs: 0)
		(if (IsFlag 8)
			(self setHotspot: 0 14) ; invMatch
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(pantryDoor doVerb: theVerb)
	)
)

(instance egoFeature2 of Feature
	(properties
		y 100
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 160 69 182 69 179 88 162 88 yourself:)
		)
		(self approachVerbs: 0)
		(if (IsFlag 8)
			(self setHotspot: 0 14) ; invMatch
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(pantryDoor doVerb: theVerb)
	)
)

(instance egoFeature3 of Feature
	(properties
		y 100
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 167 100 181 100 179 112 163 114 167 106
				yourself:
			)
		)
		(self approachVerbs: 0)
		(if (IsFlag 8)
			(self setHotspot: 0 14) ; invMatch
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(pantryDoor doVerb: theVerb)
	)
)

(instance trapSnd of Sound
	(properties
		number 1021
		loop -1
	)
)

