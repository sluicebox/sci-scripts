;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2300)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use Scaler)
(use RandCycle)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm2300 0
)

(local
	[local0 2]
)

(instance rm2300 of ScaryRoom
	(properties
		picture 2300
		north 2200
		stepSound 4
	)

	(method (drawPic param1)
		(switch param1
			(2300
				(fire view: 2300 posn: 22 142 show: setCycle: RandCycle -1)
				(UpdateScreenItem fire)
			)
			(2301
				(fire view: 2301 posn: 22 142 show: setCycle: RandCycle -1)
				(UpdateScreenItem fire)
			)
			(2310
				(fire view: 2310 posn: 39 125 show: setCycle: RandCycle -1)
				(UpdateScreenItem fire)
			)
			(2311
				(fire view: 2311 posn: 39 125 show: setCycle: RandCycle -1)
				(UpdateScreenItem fire)
			)
			(else
				(fire hide:)
			)
		)
		(super drawPic: param1)
	)

	(method (init)
		(if (== gChapter 5)
			(= picture 2301)
		)
		(fire init: cycleSpeed: 8)
		(gEgo init: setScaler: Scaler 176 70 153 90)
		(altEgo setPri: 1 scaleSignal: 1 init: hide:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(if (== (gEgo y:) 95)
					(= global163 mirror)
				)
			)
			(else
				(gEgo normalize: 3 posn: 120 127)
				(gCurRoom setScript: (ScriptID 0 5) 0 15) ; takeLastStep
			)
		)
		(super init:)
		(if (not (IsFlag 291))
			(mirror init: approachVerbs: 1 setHotspot: 1 3) ; ???, ???, Move
		)
		(if (and (== gChapter 5) (not (IsFlag 291)))
			(mist init:)
			(mist2 init:)
		)
		(southExit init: 3)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 2200) (!= newRoomNumber 900))
			(gGDacSound stop:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sLookMirror of Script
	(properties)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(global114 endPause: 1)
			(gEgo
				show:
				posn: 149 95
				normalize: 3
				setScaler: Scaler 176 70 153 90
			)
			(altEgo show: doit:)
			(= global115 0)
			(mirrorPic dispose:)
			(fire2 dispose:)
			(if (== gChapter 5)
				(gCurRoom drawPic: 2301)
			else
				(gCurRoom drawPic: 2300)
			)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(fire2 init: doit: setPri: 0)
					(gGame handsOff:)
					(altEgo hide:)
					(if (not (IsFlag 291))
						(mirrorPic init:)
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2311)
					else
						(gCurRoom drawPic: 2310)
					)
					(DoRobot 401 122 27)
				)
				(1
					(global114 pause:)
				)
				(2
					(global114 endPause:)
					(gEgo
						show:
						posn: 149 95
						normalize: 3
						setScaler: Scaler 176 70 153 90
					)
					(altEgo show: doit:)
					(mirrorPic dispose:)
					(fire2 dispose:)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2301)
					else
						(gCurRoom drawPic: 2300)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBottleTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(mist dispose:)
				(mist2 dispose:)
				(gCurRoom drawPic: -1)
				(SetFlag 291)
				(SetFlag 367)
				(PlayVMD 0 {4950.vmd} 0) ; Open
				(proc26_0 4950 self)
			)
			(1
				(gCurRoom newRoom: 1160)
			)
		)
	)
)

(instance altEgo of Actor
	(properties
		x 120
		y 100
		priority 1
		signal 20481
	)

	(method (handleEvent)
		(return 0)
	)

	(method (onMe)
		(return 0)
	)

	(method (doit &tmp temp0)
		(if
			(and
				(< 85 (gEgo x:) 196)
				(self isNotHidden:)
				(or (!= cel (gEgo cel:)) (!= view (gEgo view:)))
			)
			(switch (gEgo view:)
				(3
					(self view: 2 loop: 1)
				)
				(7302
					(self view: 7203 loop: 1)
				)
				(else 0)
			)
			(self
				cel: (gEgo cel:)
				x: (- (gEgo x:) 8)
				y: (gEgo y:)
				scaleX: (gEgo scaleX:)
				scaleY: (gEgo scaleY:)
			)
			(UpdateScreenItem self)
		)
	)
)

(instance mirrorPic of View
	(properties
		x 187
		y 55
		fixPriority 1
		view 2312
	)
)

(instance mist2 of Prop
	(properties
		x 144
		y 74
		priority 2
		fixPriority 1
		view 2302
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 12)
		(self setCycle: Fwd)
	)
)

(instance fire2 of Prop
	(properties
		x 203
		y 101
		scaleX 24
		scaleY 24
		view 2310
		loop 1
		scaleSignal 1
	)

	(method (init)
		(if (== gChapter 5)
			(= view 2311)
		)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(if (!= cel (= temp0 (fire cel:)))
			(= cel temp0)
			(UpdateScreenItem self)
		)
	)
)

(instance fire of Prop
	(properties
		x 22
		y 142
		fixPriority 1
		view 2300
	)

	(method (init)
		(if (== gChapter 5)
			(= view 2301)
		)
		(super init: &rest)
	)
)

(instance mist of Prop
	(properties
		x 144
		y 74
		priority 2
		fixPriority 1
		view 2302
	)

	(method (init)
		(RemapColors 2 244 125) ; ByPercent
		(RemapColors 2 243 130) ; ByPercent
		(RemapColors 2 242 135) ; ByPercent
		(RemapColors 2 241 140) ; ByPercent
		(RemapColors 2 240 145) ; ByPercent
		(RemapColors 2 239 150) ; ByPercent
		(RemapColors 2 238 155) ; ByPercent
		(RemapColors 2 237 160) ; ByPercent
		(RemapColors 2 236 165) ; ByPercent
		(super init: &rest)
		(= cycleSpeed 12)
		(self setCycle: Fwd)
	)

	(method (dispose)
		(RemapColors 0) ; Off
		(super dispose:)
	)
)

(instance mirror of Feature
	(properties
		nsLeft 123
		nsTop 19
		nsRight 168
		nsBottom 77
		approachX 129
		approachY 90
		x 145
		y 48
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; ???
				(if (and (== gChapter 5) (not (IsFlag 291)))
					(gCurRoom setScript: sBottleTime)
				else
					(gCurRoom setScript: sLookMirror)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fireplace of Feature ; UNUSED
	(properties
		nsTop 74
		nsRight 69
		nsBottom 130
		sightAngle 40
		approachX 95
		approachY 118
		x 34
		y 102
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 95
		nsRight 200
		approachX 120
		approachY 140
		nextRoom 2200
	)

	(method (handleEvent)
		(= approachX (gEgo x:))
		(super handleEvent: &rest)
	)
)

