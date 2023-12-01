;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3200)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm3200 0
)

(instance rm3200 of ScaryRoom
	(properties
		stepSound 7
	)

	(method (init)
		(KillRobot)
		(= picture (+ 3600 (== gChapter 5)))
		(if (> gChapter 5)
			(SetFlag 126)
			(SetFlag 9)
		)
		(gEgo init: setScaler: Scaler 66 31 130 94 normalize:)
		(fire init: cycleSpeed: 8 setCycle: RandCycle)
		(theCat init:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(3400
				(gEgo posn: 233 97 normalize: 5)
				(= global125 10)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(3700
				(switch global125
					(333
						(gEgo posn: 233 97 normalize: 7)
						(= global125 10)
					)
					(334
						(gEgo posn: 200 99 normalize: 7)
						(= global125 9)
					)
					(335
						(gEgo posn: 200 99 normalize: 7)
						(= global125 9)
					)
					(336
						(gEgo posn: 142 101 normalize: 3)
						(= global125 8)
					)
					(337
						(gEgo posn: 142 101 normalize: 3)
						(= global125 8)
					)
					(338
						(gEgo posn: 142 101 normalize: 3)
						(= global125 8)
					)
					(298
						(gEgo posn: 105 107 normalize: 3)
						(= global125 7)
					)
					(293
						(gEgo posn: 142 101 normalize: 1)
						(= global125 8)
					)
					(294
						(gEgo posn: 142 101 normalize: 1)
						(= global125 8)
					)
					(295
						(gEgo posn: 105 107 normalize: 7)
						(= global125 7)
					)
					(else
						(gEgo posn: 142 101 normalize: 3)
						(= global125 8)
					)
				)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(3760
				(if (< global125 80)
					(gEgo posn: 142 101 normalize: 5)
					(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					(= global125 8)
				else
					(gEgo posn: 200 99 normalize: 4)
					(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					(= global125 9)
				)
			)
			(4200
				(gEgo posn: 64 117 normalize: 6)
				(= global125 5)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo posn: 73 101 normalize: 4)
				(= global125 6)
				(cond
					((and (not (IsFlag 9)) (!= gChapter 4))
						(gCurRoom setScript: sDiningRoomPan)
					)
					((and (IsFlag 195) (== gChapter 5) (not (IsFlag 44)))
						(= picture 3840)
						(gCurRoom setScript: sHearParty)
					)
					(else
						(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
		)
		((ScriptID 30) init:) ; FidgetCode
		(diningDoor init: 13 approachVerbs: 0)
		(libraryDoor init: 10 approachVerbs: 0)
		(firePlaceArea init: 1 approachVerbs: 0)
		(southwestExit init: 12 approachVerbs: 0)
		(southExit init: 3 approachVerbs: 0)
		(southeastExit init: 11 approachVerbs: 0)
		(eastExit init: 2 approachVerbs: 0)
		(super init:)
		(if (not (IsFlag 376))
			(gGDacSound number: 2010 init: setVol: 37 setLoop: -1 play:)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo setScript: 0)
		(gGame handsOff:)
		(if (not (OneOf newRoomNumber 3760 3800 3200 3700 4200 900))
			(if (not global184)
				(switch gChapter
					(1
						(global114 play: 911)
					)
					(2
						(global114 play: 911)
					)
					(3
						(global114 play: 912)
					)
					(4
						(global114 play: 9120)
					)
					(5
						(global114 play: 913)
					)
					(6
						(global114 play: 914)
					)
					(7
						(global114 play: 9140)
					)
				)
			)
			(gGDacSound stop:)
			(ClearFlag 376)
		)
		(if
			(and
				(== gChapter 4)
				(not (OneOf newRoomNumber 2200 4200))
				(IsFlag 49)
				(not (IsFlag 51))
				(not (IsFlag 190))
			)
			(SetFlag 190)
			(ClearFlag 175)
		)
		(if
			(and
				(== gChapter 4)
				(not (OneOf newRoomNumber 3400 4200))
				(IsFlag 51)
				(not (IsFlag 265))
				(not (IsFlag 52))
			)
			(SetFlag 52)
			(ClearFlag 190)
		)
		(if
			(and
				(== gChapter 4)
				(OneOf newRoomNumber 2200 3760 3700)
				(IsFlag 265)
				(not (IsFlag 3))
				(not (IsFlag 247))
			)
			(SetFlag 247)
			(ClearFlag 52)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sHearParty of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo hide:)
					(fire hide:)
					(if (gCast contains: theCat)
						(theCat hide:)
					)
					(SetFlag 376)
					(global114 pause: 3049 0 -1)
					(global114 setVol: 120 1)
					(gGDacSound number: 3050 init: setVol: 120 setLoop: -1 play:)
					(DoRobot 5020 -6 -38)
				)
				(1
					(gEgo show:)
					(fire show:)
					(if (gCast contains: theCat)
						(theCat show:)
					)
					(SetFlag 44)
					(gCurRoom drawPic: (+ 3600 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(SetFlag 376)
			(if (not (global114 script:))
				(global114 pause: 3049)
				(global114 setVol: 120 1)
				(gGDacSound number: 3050 init: setVol: 120 setLoop: -1 play:)
			)
			(gEgo show:)
			(fire show:)
			(if (gCast contains: theCat)
				(theCat hide:)
			)
			(SetFlag 44)
			(gCurRoom drawPic: (+ 3600 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sDiningRoomPan of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo cel: 0 setCycle: End self)
				)
				(1
					(SetFlag 9)
					(if (< gVideoSpeed 425)
						(PlayVMD 0 {2950.vmd} 0) ; Open
						(proc26_0 2950 self)
					else
						(PlayVMD 0 {295.vmd} 0) ; Open
						(proc26_0 295 self)
					)
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(SetFlag 9)
					(gEgo normalize: 4)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExitFireplace of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(6
							(gEgo setHeading: 90 self)
						)
						(9
							(gEgo setHeading: 315 self)
						)
						(10
							(gEgo setHeading: 270 self)
						)
						(else
							(gEgo setHeading: 45 self)
						)
					)
				)
				(1
					(gCurRoom newRoom: 3760)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 3760)
		)
	)
)

(instance sExitDiningDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(6
							(gEgo setHeading: 315 self)
						)
						(5
							(gEgo setHeading: 0 self)
						)
						(7
							(gEgo setHeading: 315 self)
						)
						(else
							(gEgo setHeading: 270 self)
						)
					)
				)
				(1
					(= global125 0)
					(gCurRoom newRoom: 2200)
				)
			)
		else
			(= global115 0)
			(= global125 0)
			(gCurRoom newRoom: 2200)
		)
	)
)

(instance sExitLibraryDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(10
							(gEgo setHeading: 45 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(= global125 0)
					(gCurRoom newRoom: 3400)
				)
			)
		else
			(= global115 0)
			(= global125 0)
			(gCurRoom newRoom: 3400)
		)
	)
)

(instance sExitSouthWest of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 225 self)
					(+= global125 120)
				)
				(1
					(gCurRoom newRoom: 4200)
				)
			)
		else
			(= global115 0)
			(if (< global125 120)
				(+= global125 120)
			)
			(gCurRoom newRoom: 4200)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(5
							(gEgo setHeading: 135 self)
						)
						(6
							(gEgo setHeading: 135 self)
						)
						(7
							(gEgo setHeading: 180 self)
						)
						(else
							(gEgo setHeading: 225 self)
						)
					)
				)
				(1
					(+= global125 160)
					(gCurRoom newRoom: 4200)
				)
			)
		else
			(= global115 0)
			(if (< global125 160)
				(+= global125 160)
			)
			(gCurRoom newRoom: 4200)
		)
	)
)

(instance sExitSouthEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(9
							(gEgo setHeading: 180 self)
						)
						(10
							(gEgo setHeading: 180 self)
						)
						(5
							(gEgo setHeading: 90 self)
						)
						(else
							(gEgo setHeading: 135 self)
						)
					)
				)
				(1
					(gCurRoom newRoom: 3700)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 3700)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(9
							(gEgo setHeading: 135 self)
						)
						(10
							(gEgo setHeading: 135 self)
						)
						(else
							(gEgo setHeading: 90 self)
						)
					)
				)
				(1
					(gCurRoom newRoom: 3800)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 3800)
		)
	)
)

(instance fire of Prop
	(properties
		x 161
		y 92
	)

	(method (init)
		(self view: (+ 3600 (== gChapter 5)))
		(super init: &rest)
	)
)

(instance theCat of Prop
	(properties
		x 182
		y 92
		loop 1
	)

	(method (init)
		(self view: (+ 3600 (== gChapter 5)))
		(if (OneOf gChapter 1 4)
			(super init: &rest)
		)
	)
)

(instance diningDoor of ExitFeature
	(properties
		nsLeft 52
		nsTop 62
		nsRight 85
		nsBottom 100
		x 62
		y 101
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitDiningDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance libraryDoor of ExitFeature
	(properties
		nsLeft 209
		nsTop 59
		nsRight 245
		nsBottom 97
		x 266
		y 102
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
				(SetFlag 181)
			)
			(gGame handsOff:)
			(gCurRoom setScript: sExitLibraryDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance firePlaceArea of ExitFeature
	(properties
		x 145
		y 93
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 96 139 104 184 104 202 95 178 92 177 81 148 81 147 93
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitFireplace)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southwestExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 107 40 103 60 129 0 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthWest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 52 119 146 119 146 129 60 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouth)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southeastExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 147 119 271 119 292 129 147 129
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitSouthEast)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance eastExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 99 249 110 292 128 292 101
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitEast)
		else
			(super doVerb: theVerb)
		)
	)
)

