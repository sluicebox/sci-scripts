;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30400)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm30400 0
)

(local
	local0
)

(instance rm30400 of ScaryRoom
	(properties
		picture 30210
	)

	(method (init)
		(if (== gPrevRoomNum 900)
			(gEgo init:)
			(gGame handsOn:)
		else
			(gEgo init: hide: setScaler: Scaler 152 132 129 104 normalize:)
			(WalkieTalkie showFrame: 1840 0 -7 -39)
			(self setScript: sSitDown)
		)
		(cup init:)
		(magazines init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(waterCooler init: approachVerbs: 0 setHotspot: 4 3) ; Do, Move
		(pornoMag init:)
		(southExit init: 3)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Move
				(if (proc0_6 (gUser curEvent:))
					(gCurRoom setScript: sStandUp 0 self)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(KillRobot)
		(ClearFlag 121)
		(super dispose:)
	)
)

(instance waterCooler of Feature
	(properties
		nsLeft 21
		nsTop 49
		nsRight 46
		nsBottom 97
		sightAngle 360
		approachX 45
		approachY 101
		x 33
		y 73
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: getWaterScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magazines of Feature
	(properties
		nsLeft 129
		nsTop 91
		nsRight 175
		nsBottom 105
		sightAngle 360
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sReadMag)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 123
		nsRight 293
		nsBottom 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(gCurRoom setScript: sStandUp)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frontDoor of ExitFeature ; UNUSED
	(properties
		nsLeft 270
		nsTop 7
		nsRight 281
		nsBottom 119
		x 275
		y 63
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(= global125 9)
			(gCurRoom setScript: sStandUp)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance couchFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(if (not (gCurRoom script:))
						(gGame handsOff:)
						(SetFlag 121)
						(if (Random 0 1)
							(gEgo
								view: 1841
								posn: 144 105
								setLoop: 0
								setCel: 0
								setCycle: End self
							)
						else
							(gEgo
								view: 1842
								posn: 144 105
								setLoop: 0
								setCel: 0
								setCycle: End self
							)
						)
					else
						(= state -1)
						(= seconds (Random 5 30))
					)
				else
					(gGame handsOn:)
				)
			)
			(1
				(gEgo setCel: 0 normalize: 1841)
				(ClearFlag 121)
				(gGame handsOn:)
				(= state -1)
				(= seconds (Random 5 30))
			)
		)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(KillRobot)
					(DoRobot 1840 8 -40)
				)
				(1
					(= local0 1)
					(gEgo
						view: 1841
						setLoop: 0
						setCel: 0
						setScale: 0
						posn: 144 105
						show:
						setScript: couchFidget
					)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(gEgo
						view: 1841
						setLoop: 0
						setCel: 0
						setScale: 0
						posn: 144 105
						show:
						setScript: couchFidget
					)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						setScript: 0
						setCycle: 0
						view: 1850
						x: 146
						setLoop: 0
						setCel: 0
						setCycle: End self
						cycleSpeed: 6
					)
				)
				(1
					(= local0 0)
					(gCurRoom newRoom: 30100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(gEgo setScript: 0 setCycle: 0)
					(gCurRoom newRoom: 30100)
				)
			)
		)
	)
)

(instance sReadMag of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo
						view: 1860
						setLoop: 0
						setCel: 0
						posn: 144 104
						setPri: 120
						setCycle: CT 37 1 self
						cycleSpeed: 9
					)
				)
				(1
					(sFx number: 30010 play:)
					(pornoMag dispose:)
					(gEgo setCycle: End self)
				)
				(2
					(gEgo hide:)
					(cup hide:)
					(DoRobot 1861 50 -6)
					(gCurRoom drawPic: 30220)
				)
				(3
					(cup show:)
					(gEgo
						view: 1843
						setLoop: 0
						setCel: 0
						posn: 144 105
						show:
						setCycle: CT 45 1 self
					)
					(gCurRoom drawPic: 30210)
				)
				(4
					(sFx number: 30013 play:)
					(pornoMag init:)
					(gEgo setCycle: End self)
				)
				(5
					(gEgo setPri: -1)
					(gGame handsOn:)
					(gUser canControl: 0)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (not (gCast contains: pornoMag))
						(pornoMag init:)
					)
					(= global115 0)
					(gEgo
						view: 1843
						setCel: 48
						setPri: -1
						posn: 144 105
						show:
					)
					(gCurRoom drawPic: 30210)
					(cup show:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance getWaterScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1870 14 -1)
				)
				(1
					(KillRobot)
					(= local0 0)
					(gEgo hide:)
					(WalkieTalkie showFrame: 1870 200 14 -1)
					(gCurRoom newRoom: 30100)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(gEgo hide:)
					(WalkieTalkie showFrame: 1870 200 14 -1)
					(gCurRoom newRoom: 30100)
				)
			)
		)
	)
)

(instance cup of View
	(properties
		x 28
		y 71
		view 1871
	)
)

(instance pornoMag of View
	(properties
		x 152
		y 94
		view 30400
	)

	(method (init)
		(super init:)
		(self setPri: 113)
	)

	(method (doVerb theVerb)
		(magazines doVerb: theVerb)
	)
)

(instance sFx of Sound
	(properties
		flags 1
	)
)

