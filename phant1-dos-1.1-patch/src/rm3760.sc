;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3760)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm3760 0
)

(instance rm3760 of ScaryRoom
	(properties
		picture 3610
		stepSound 7
	)

	(method (init)
		(KillRobot)
		(gEgo init: setScaler: Scaler 111 62 124 89 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(3430
				(gEgo posn: 157 109 normalize: 7)
				(= global125 1)
				(gGame handsOn:)
			)
			(else
				(switch global125
					(9
						(gEgo posn: 207 107 normalize: 1)
						(= global125 4)
						(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(10
						(gEgo posn: 207 107 normalize: 1)
						(= global125 4)
						(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
					(else
						(gEgo posn: 173 136 normalize: 3)
						(= global125 2)
						(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
					)
				)
			)
		)
		((ScriptID 30) init:) ; FidgetCode
		(if (not (IsFlag 376))
			(gGDacSound number: 2010 init: setVol: 50 setLoop: -1 play:)
		)
		(fire init: view: 3610 posn: 121 99 cycleSpeed: 8 setCycle: RandCycle)
		(portrait init: setHotspot: 4 3) ; Do, Move
		(if (OneOf gChapter 1 4)
			(theCat init:)
		)
		(if
			(or
				(and (== gChapter 1) (not (IsFlag 17)))
				(and (== gChapter 4) (not (IsFlag 383)))
			)
			(theCat setHotspot: 4 3) ; Do, Move
		)
		(if (and (< gChapter 4) (not (IsFlag 16)))
			(newspaper init: setHotspot: 4 3) ; Do, Move
		)
		(fireplace init: setHotspot: 1 3) ; ???, Move
		(libDoor init: 1 approachVerbs: 0)
		(eastExit init: 2 approachVerbs: 0)
		(southExit init: 3 approachVerbs: 0)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 3760 3800 3200 3700 4200 900))
			(if (not global184)
				(global114 endPause:)
			)
			(gGDacSound stop:)
			(ClearFlag 376)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sFirePlace of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(self changeState: 1)
						)
						(2
							(gEgo setHeading: 0 self)
						)
						(3
							(gEgo setHeading: 225 self 12)
						)
						(4
							(gEgo setHeading: 270 self 19)
						)
					)
				)
				(1
					(= global125 1)
					(if (gCast contains: theCat)
						(theCat posn: 117 101 view: 3760 setPri: 120)
					)
					(if (gCast contains: newspaper)
						(newspaper posn: 79 98 view: 3762)
					)
					(fire
						view: 3761
						posn: 150 89
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(gEgo
						posn: 108 102
						view: 440
						cel: 0
						loop: 0
						setScaler: 0
						setCycle: End self
					)
					(gCurRoom drawPic: 3760)
				)
				(2
					(gEgo
						setCycle: 0
						posn: 157 109
						normalize: 7
						setScaler: Scaler 111 62 124 89
					)
					(if (gCast contains: newspaper)
						(newspaper show: view: 3612 posn: 140 134)
					)
					(if (gCast contains: theCat)
						(theCat show: posn: 192 90 view: 3611 setPri: 90)
					)
					(fire
						view: 3610
						posn: 121 99
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(gCurRoom drawPic: 3610)
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
						posn: 157 109
						normalize: 7
						setScaler: Scaler 111 62 124 89
					)
					(= global125 1)
					(fire
						view: 3610
						posn: 121 99
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(if (gCast contains: newspaper)
						(newspaper show: view: 3612 posn: 140 134)
					)
					(if (gCast contains: theCat)
						(theCat show: posn: 192 90 view: 3611 setPri: 90)
					)
					(gCurRoom drawPic: 3610)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sCarnoEyes of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load rsAUDIO 3019)
					(switch global125
						(1
							(self changeState: 1)
						)
						(3
							(gEgo setHeading: 225 self 12)
						)
						(4
							(gEgo setHeading: 270 self)
						)
						(else
							(gEgo setHeading: 0 self)
						)
					)
				)
				(1
					(= global125 1)
					(if (gCast contains: theCat)
						(theCat posn: 117 101 view: 3760 setPri: 120)
					)
					(if (gCast contains: newspaper)
						(newspaper posn: 79 98 view: 3762)
					)
					(fire
						view: 3761
						posn: 150 89
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(DoRobot 450 77 49)
					(gCurRoom drawPic: 3760)
				)
				(2
					(gGDacSound
						number: 3019
						init:
						setVol: 127
						setLoop: 1
						play: self
					)
					(global114 pause:)
					(gEgo hide:)
					(fire hide:)
					(if (gCast contains: newspaper)
						(newspaper hide:)
					)
					(if (gCast contains: theCat)
						(theCat hide:)
					)
					(gCurRoom drawPic: 3770)
				)
				(3
					(global114 endPause:)
					(if (not (IsFlag 376))
						(gGDacSound
							number: 2010
							init:
							setVol: 50
							setLoop: -1
							play:
						)
					else
						(gGDacSound
							number: 3051
							init:
							setVol: 60
							setLoop: -1
							play:
						)
					)
					(if (gCast contains: newspaper)
						(newspaper show:)
					)
					(if (gCast contains: theCat)
						(theCat show:)
					)
					(fire
						show:
						view: 3761
						posn: 150 89
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(DoRobot 451 77 49)
					(gCurRoom drawPic: 3760)
				)
				(4
					(if (gCast contains: newspaper)
						(newspaper show: view: 3612 posn: 140 134)
					)
					(if (gCast contains: theCat)
						(theCat show: posn: 192 90 view: 3611 setPri: 90)
					)
					(fire
						view: 3610
						posn: 121 99
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(gEgo show: posn: 157 109 normalize: 7)
					(= global125 1)
					(gCurRoom drawPic: 3610)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(global114 endPause: 1)
					(if (not (IsFlag 376))
						(gGDacSound
							number: 2010
							init:
							setVol: 50
							setLoop: -1
							play:
						)
					else
						(gGDacSound
							number: 3051
							init:
							setVol: 60
							setLoop: -1
							play:
						)
					)
					(if (gCast contains: newspaper)
						(newspaper show: view: 3612 posn: 140 134)
					)
					(if (gCast contains: theCat)
						(theCat show: posn: 192 90 view: 3611 setPri: 90)
					)
					(fire
						show:
						view: 3610
						posn: 121 99
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(gEgo show: posn: 157 109 normalize: 7)
					(= global125 1)
					(gCurRoom drawPic: 3610)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sGetTheNews of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(2
							(self changeState: 1)
						)
						(1
							(gEgo setHeading: 180 self 18)
						)
						(3
							(gEgo setHeading: 180 self 18)
						)
						(else
							(gEgo setHeading: 225 self 15)
						)
					)
				)
				(1
					(gEgo
						view: 480
						setScale: 0
						loop: 0
						cel: 0
						posn: 61 95
						cycleSpeed: 6
						setCycle: CT 12 1 self
					)
					(gCurRoom drawPic: 3760)
					(newspaper dispose:)
					(if (gCast contains: theCat)
						(theCat view: 3760 posn: 121 101 setPri: 180)
					)
					(fire
						view: 3761
						posn: 150 89
						cycleSpeed: 8
						setCycle: RandCycle
					)
				)
				(2
					(sfx number: 3012 setLoop: 1 play:)
					(gEgo setCycle: End self)
				)
				(3
					(SetFlag 16)
					(gEgo
						get: 3 ; invNewspaper
						normalize: 3
						setScaler: Scaler 111 62 124 89
						posn: 173 136
					)
					(= global125 2)
					(if (gCast contains: theCat)
						(theCat view: 3611 posn: 192 90 setPri: -1)
					)
					(fire
						view: 3610
						posn: 121 99
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(gCurRoom drawPic: 3610)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(SetFlag 16)
					(if (gCast contains: theCat)
						(theCat view: 3611 posn: 192 90 setPri: -1)
					)
					(fire
						view: 3610
						posn: 121 99
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(gEgo
						get: 3 ; invNewspaper
						normalize: 3
						setScaler: Scaler 111 62 124 89
						posn: 173 136
					)
					(= global125 2)
					(newspaper dispose:)
					(gGame handsOn:)
					(gCurRoom drawPic: 3610)
					(self dispose:)
				)
			)
		)
	)
)

(instance sPetTheCat of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(2
							(gEgo setHeading: 0 self)
						)
						(4
							(gEgo setHeading: 315 self)
						)
						(1
							(gEgo setHeading: 45 self 15)
						)
					)
				)
				(1
					(fire hide:)
					(if (gCast contains: newspaper)
						(newspaper hide:)
					)
					(theCat hide:)
					(if (== gChapter 1)
						(DoRobot 490 96 -14)
					else
						(DoRobot 491 66 -35)
					)
					(gCurRoom drawPic: 3960)
				)
				(2
					(if (== gChapter 1)
						(SetFlag 17)
					else
						(SetFlag 383)
					)
					(if (gCast contains: newspaper)
						(newspaper show:)
					)
					(theCat show: setHotspot: 0)
					(fire
						show:
						view: 3610
						posn: 121 99
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(gEgo posn: 180 101 normalize: 5)
					(= global125 3)
					(gCurRoom drawPic: 3610)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(if (== gChapter 1)
						(SetFlag 17)
					else
						(SetFlag 383)
					)
					(if (gCast contains: newspaper)
						(newspaper show:)
					)
					(theCat show: setHotspot: 0)
					(fire
						show:
						view: 3610
						posn: 121 99
						cycleSpeed: 8
						setCycle: RandCycle
					)
					(gEgo posn: 180 101 normalize: 5)
					(= global125 3)
					(gCurRoom drawPic: 3610)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 90 self)
				)
				(1
					(+= global125 80)
					(gCurRoom newRoom: 3200)
				)
			)
		else
			(= global115 0)
			(if (< global125 40)
				(+= global125 80)
			)
			(gCurRoom newRoom: 3200)
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
						(4
							(gEgo setHeading: 225 self)
						)
						(else
							(gEgo setHeading: 180 self)
						)
					)
				)
				(1
					(+= global125 40)
					(gCurRoom newRoom: 3200)
				)
			)
		else
			(= global115 0)
			(if (< global125 40)
				(+= global125 40)
			)
			(gCurRoom newRoom: 3200)
		)
	)
)

(instance sExitLibDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(switch global125
						(1
							(gEgo setHeading: 90 self)
						)
						(2
							(gEgo setHeading: 0 self)
						)
						(3
							(gEgo setHeading: 135 self)
						)
						(4
							(gEgo setHeading: 0 self)
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
			(gCurRoom newRoom: 3200)
		)
	)
)

(instance fire of Prop
	(properties
		view 0
	)
)

(instance sfx of Sound
	(properties)
)

(instance newspaper of View
	(properties
		x 140
		y 134
		view 3612
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sGetTheNews)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theCat of View
	(properties
		x 192
		y 90
		view 3611
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sPetTheCat)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance portrait of Feature
	(properties
		nsLeft 107
		nsRight 125
		nsBottom 23
		x 116
		y 11
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: sCarnoEyes)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fireplace of Feature
	(properties
		nsLeft 103
		nsTop 63
		nsRight 131
		nsBottom 97
		x 117
		y 80
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; ???
			(gGame handsOff:)
			(gCurRoom setScript: sFirePlace)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance libDoor of ExitFeature
	(properties
		nsLeft 209
		nsTop 49
		nsRight 235
		nsBottom 87
		x 222
		y 71
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(gCurRoom setScript: sExitLibDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 157
		nsTop 121
		nsRight 197
		nsBottom 129
		x 177
		y 125
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

(instance eastExit of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 292 89 292 129 244 129 244 93
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

