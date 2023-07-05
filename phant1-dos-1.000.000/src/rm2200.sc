;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2200)
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
	rm2200 0
)

(instance rm2200 of ScaryRoom
	(properties
		picture 2200
		stepSound 4
	)

	(method (notify)
		(if script
			(script cue:)
		)
	)

	(method (drawPic param1)
		(switch param1
			(2200
				(fire x: 212 y: 108 view: 2200 show: setCycle: RandCycle -1)
			)
			(2201
				(fire x: 212 y: 108 view: 2201 show: setCycle: RandCycle -1)
			)
			(2320
				(fire x: 165 y: 107 view: 2320 show: setCycle: RandCycle -1)
			)
			(2321
				(fire x: 165 y: 107 view: 2321 show: setCycle: RandCycle -1)
			)
			(2300
				(fire view: 2300 posn: 22 142 show: setCycle: RandCycle -1)
			)
			(2301
				(fire view: 2301 posn: 22 142 show: setCycle: RandCycle -1)
			)
			(else
				(fire hide:)
			)
		)
		(if (gCast contains: poker)
			(if (OneOf param1 2200 2201)
				(poker show:)
			else
				(poker hide:)
			)
		)
		(super drawPic: param1 &rest)
	)

	(method (init &tmp temp0)
		(switch gChapter
			(1
				(= temp0 911)
			)
			(2
				(= temp0 911)
			)
			(3
				(= temp0 912)
			)
			(4
				(= temp0 9120)
			)
			(5
				(= temp0 913)
			)
			(6
				(= temp0 914)
			)
			(else
				(= temp0 9140)
			)
		)
		(if temp0
			(Load rsSOUND temp0)
		)
		(Load 140 2010) ; WAVE
		(proc1111_6)
		(receptionDoor approachX: 170 approachY: 81)
		(if (== gChapter 5)
			(= picture 2201)
		)
		(fire init: cycleSpeed: 8)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo
			init:
			fadedY: 0
			brightY: 0
			setScaler: Scaler 103 20 131 71
			normalize:
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(if (> (gEgo y:) 100)
					(backDoor approachX: 170)
				)
			)
			(1200
				(gEgo normalize: 2 posn: 156 75)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(4200
				(= picture 2330)
				(self setScript: throwFit)
			)
			(2300
				(backDoor approachX: 170)
				(gEgo normalize: 3 posn: 160 129)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
			(28810
				(gGame handsOff:)
				(if (== gChapter 5)
					(= picture 2321)
				else
					(= picture 2320)
				)
				(gEgo
					posn: 22 111
					view: 330
					loop: 0
					cel: 0
					scaleSignal: 0
					init:
				)
				(self setScript: sCatAftermath)
			)
			(28815
				(if global125
					(gGame handsOff:)
					(if (== gChapter 5)
						(= picture 2321)
					else
						(= picture 2320)
					)
					(gEgo
						posn: 22 111
						view: 330
						loop: 0
						cel: 0
						scaleSignal: 0
						init:
					)
					(self setScript: sCatAftermath)
				else
					(self setScript: sEnterFromGardens)
				)
				(if (and (not (IsFlag 90)) (gEgo has: 0)) ; invLibKey
					(SetFlag 90)
				)
				(if (and (not (IsFlag 102)) (gEgo has: 13)) ; invDrainCln
					(SetFlag 102)
				)
				(if (and (not (IsFlag 98)) (gEgo has: 2)) ; invNail
					(SetFlag 98)
				)
				(if (and (not (IsFlag 105)) (IsFlag 189))
					(SetFlag 105)
				)
				(if (and (not (IsFlag 115)) (IsFlag 195))
					(SetFlag 115)
				)
				(if (and (not (IsFlag 413)) (IsFlag 206))
					(SetFlag 413)
				)
				(= global125 0)
			)
			(2600
				(backDoor approachX: 170)
				(gEgo posn: (fireplace x:) (fireplace y:) normalize: 4)
				(= global163 fireplace)
			)
			(3200
				(gEgo normalize: 1 loop: 0 cel: 0 posn: 169 81)
				(if (and (OneOf gChapter 5 6) (not (IsFlag 367)))
					(SetFlag 367)
					(self setScript: seeMirrorMist)
				else
					(self setScript: (ScriptID 0 5)) ; takeLastStep
				)
			)
			(else
				(gEgo normalize: 2 posn: 147 79)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
		)
		(if (== gChapter 3)
			(SetFlag 384)
		)
		(if temp0
			(global114 play: temp0)
		)
		(gGDacSound setLoop: -1 number: 2010 play: setVol: 127)
		(if (not (gEgo has: 4)) ; invPoker
			(poker init:)
		)
		(super init: &rest)
		(painting init: approachVerbs: 1 setHotspot: 1 3) ; ???, ???, Move
		(kitchenDoor init: 1)
		(if (< gChapter 6)
			(fireplace init: approachVerbs: 4 10 setHotspot: 4 3 10) ; Do, invPoker, Do, Move, invPoker
		else
			(fireplace init: approachVerbs: 4 10 setHotspot: 4 3) ; Do, invPoker, Do, Move
		)
		(if (not (IsFlag 202))
			(backDoor init: 13)
		)
		(receptionDoor init: 2)
		(southExit init: 3)
		(if (== gPrevRoomNum 2600)
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== gChapter 4)
				(not (OneOf newRoomNumber 1200 3200))
				(IsFlag 49)
				(not (IsFlag 51))
				(not (IsFlag 190))
			)
			(SetFlag 190)
			(ClearFlag 175)
		)
		(if (and (!= newRoomNumber 2300) (!= newRoomNumber 2600) (!= newRoomNumber 900))
			(gGDacSound stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance throwFit of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(global114 endPause:)
					(= global115 0)
					(if register
						(register dispose:)
					)
					(gEgo normalize: 2 posn: 147 79)
					(gCurRoom drawPic: 2200)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 5934 -7 -13)
				)
				(1
					(proc1111_7 5930 104 27 gEgo 100)
					(= register (View new:))
					(register view: 2400 x: 199 y: 88 init:)
					(gCurRoom drawPic: 2400)
				)
				(2
					(register dispose:)
					(gEgo normalize: 2 posn: 147 79)
					(= global125 0)
					(gCurRoom drawPic: 2200)
					(gGame handsOn:)
					(global114 endPause:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoorsSlam of Script
	(properties)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(gCurRoom newRoom: 4200)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(global114 pause:)
					(SetFlag 202)
					(proc1111_7 5940 -2 -1)
					(gCurRoom drawPic: 2400)
				)
				(1
					(gCurRoom drawPic: 2330)
					(proc1111_7 5942 -9 -9 gEgo 200 1)
				)
				(2
					(gEgo hide:)
					(gCurRoom newRoom: 4200)
				)
			)
		)
	)
)

(instance sLookPainting of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(backDoor approachX: 170)
					(global114 pause:)
					(gCurRoom drawPic: 2505)
					(proc1111_7 380 11 10)
				)
				(1
					(SetFlag 121)
					(gCurRoom drawPic: (+ 2200 (== gChapter 5)))
					(gEgo
						show:
						posn: (fireplace x:) (fireplace y:)
						normalize: 4
						setScaler: Scaler 103 20 131 71
					)
					(gGame handsOn:)
					(global114 endPause:)
					(self dispose:)
					(ClearFlag 121)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(global114 endPause:)
					(= global115 0)
					(gCurRoom drawPic: (+ 2200 (== gChapter 5)))
					(gEgo
						show:
						posn: (fireplace x:) (fireplace y:)
						normalize: 4
						setScaler: Scaler 103 20 131 71
					)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
					(ClearFlag 121)
				)
			)
		)
	)
)

(instance checkOutFire of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(backDoor approachX: 170)
					(= register (gEgo cycleSpeed:))
					(gEgo
						posn: 22 111
						view: 330
						loop: 0
						cel: 0
						cycleSpeed: 8
						scaleSignal: 0
						setCycle: End self
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2321)
					else
						(gCurRoom drawPic: 2320)
					)
				)
				(1
					(= ticks 45)
				)
				(2
					(gEgo view: 321 posn: 160 131 setCycle: Fwd)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2341)
					else
						(gCurRoom drawPic: 2340)
					)
					(= seconds 8)
				)
				(3
					(gEgo posn: 22 111 view: 330 loop: 0)
					(gEgo setCel: (gEgo lastCel:) setCycle: Beg self)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2321)
					else
						(gCurRoom drawPic: 2320)
					)
				)
				(4
					(gEgo
						normalize: 4
						posn: (fireplace x:) (fireplace y:)
						cycleSpeed: register
						setScaler: Scaler 103 20 131 71
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2201)
					else
						(gCurRoom drawPic: 2200)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gEgo
						setCycle: 0
						normalize: 4
						posn: (fireplace x:) (fireplace y:)
						setScaler: Scaler 103 20 131 71
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2201)
					else
						(gCurRoom drawPic: 2200)
					)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
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
		(mist2 init:)
	)

	(method (dispose)
		(RemapColors 0) ; Off
		(mist2 dispose:)
		(super dispose:)
	)
)

(instance stokeSound of Sound
	(properties
		number 2013
	)
)

(instance sStokeFire of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(backDoor approachX: 170)
					(gGame handsOff:)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2321)
					else
						(gCurRoom drawPic: 2320)
					)
					(gEgo
						posn: 22 111
						view: 330
						loop: 0
						cel: 0
						setScale: 0
						setCycle: End self
					)
				)
				(1
					(proc1111_7 340 0 30)
					(stokeSound play:)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2341)
					else
						(gCurRoom drawPic: 2340)
					)
				)
				(2
					(if (== gChapter 5)
						(gCurRoom drawPic: 2321)
					else
						(gCurRoom drawPic: 2320)
					)
					(gEgo setCycle: Beg self)
				)
				(3
					(if (== gChapter 5)
						(gCurRoom drawPic: 2201)
					else
						(gCurRoom drawPic: 2200)
					)
					(gEgo
						normalize: 0
						posn: (fireplace x:) (fireplace y:)
						setScaler: Scaler 103 20 131 71
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2201)
					else
						(gCurRoom drawPic: 2200)
					)
					(gEgo
						setCycle: 0
						normalize: 0
						posn: (fireplace x:) (fireplace y:)
						setScaler: Scaler 103 20 131 71
					)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance seeMirrorMist of Script
	(properties)

	(method (changeState newState)
		(if global115
			(= global115 0)
			(mist dispose:)
			(gEgo show:)
			(gEgo normalize: 2)
			(gCurRoom drawPic: (+ 2200 (== gChapter 5)))
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if register
						(= cycles 1)
					else
						(self setScript: (ScriptID 0 5) self) ; takeLastStep
					)
				)
				(1
					(gGame handsOff:)
					(gEgo setHeading: 180 self 5)
				)
				(2
					(gEgo hide:)
					(gCurRoom drawPic: (+ 2300 (== gChapter 5)))
					(mist init:)
					(= seconds 7)
				)
				(3
					(mist dispose:)
					(gEgo show:)
					(gEgo normalize: 2)
					(gCurRoom drawPic: (+ 2200 (== gChapter 5)))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sExitToGardens of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 300 120 5 gEgo -1 1)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2401)
					else
						(gCurRoom drawPic: 2400)
					)
				)
				(1
					(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
						(SetFlag 181)
					)
					(gEgo hide:)
					(gCurRoom newRoom: 28815)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(proc1111_6)
					(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
						(SetFlag 181)
					)
					(gCurRoom newRoom: 28815)
				)
			)
		)
	)
)

(instance sEnterFromGardens of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 301 130 15 gEgo -1 1)
					(if (== gChapter 5)
						(gCurRoom picture: 2401)
					else
						(gCurRoom picture: 2400)
					)
				)
				(1
					(gEgo view: 4 loop: 0 cel: 0 posn: 153 79)
					(proc1111_6)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2201)
					else
						(gCurRoom drawPic: 2200)
					)
					(if (and (OneOf gChapter 5 6) (not (IsFlag 367)))
						(SetFlag 367)
						(gCurRoom setScript: seeMirrorMist)
					else
						(gCurRoom setScript: (ScriptID 0 5)) ; takeLastStep
					)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(= global115 0)
					(gEgo view: 4 loop: 0 cel: 0 posn: 153 79)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2201)
					else
						(gCurRoom drawPic: 2200)
					)
					(if (and (OneOf gChapter 5 6) (not (IsFlag 367)))
						(SetFlag 367)
						(gCurRoom setScript: seeMirrorMist)
					else
						(gCurRoom setScript: (ScriptID 0 5)) ; takeLastStep
					)
				)
			)
		)
	)
)

(instance sCatAftermath of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= global163 painting)
					(gCurRoom picture: 2341)
					(gGame setIntensity: 0 0)
					(backDoor approachX: 170)
					(proc1111_7 4990 110 24 gEgo -1 1)
					(= cycles 2)
				)
				(1
					(gGame fade: 0 100 2)
				)
				(2
					(gEgo hide:)
					(gGame fade: 100 0 2 self)
				)
				(3
					(= ticks 240)
				)
				(4
					(proc1111_6)
					(gEgo
						normalize: 0
						posn: (fireplace x:) (fireplace y:)
						setScaler: Scaler 103 20 131 71
					)
					(gEgo show:)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2201)
					else
						(gCurRoom drawPic: 2200)
					)
					(gGame fade: 0 100 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(proc1111_6)
					(gEgo
						show:
						setCycle: 0
						normalize: 0
						posn: (fireplace x:) (fireplace y:)
						setScaler: Scaler 103 20 131 71
					)
					(if (== gChapter 5)
						(gCurRoom drawPic: 2201)
					else
						(gCurRoom drawPic: 2200)
					)
					(= global115 0)
					(gGame setIntensity: 100 1)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 212
		y 108
		fixPriority 1
		view 2200
	)

	(method (init)
		(if (== gChapter 5)
			(= view 2201)
		)
		(super init: &rest)
	)
)

(instance painting of Feature
	(properties
		nsLeft 199
		nsRight 227
		nsBottom 54
		sightAngle 40
		approachX 160
		approachY 105
		x 213
		y 27
	)

	(method (handleEvent event)
		(if (and (== global163 fireplace) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				init: 213 0 203 20 202 43 208 57 222 54 232 26 227 0
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; ???
				(gGame handsOff:)
				(gCurRoom setScript: sLookPainting)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance kitchenDoor of ExitFeature
	(properties
		nsLeft 150
		nsTop 58
		nsRight 162
		nsBottom 74
		approachX 156
		approachY 70
		x 156
		y 66
		nextRoom 1200
	)
)

(instance poker of View
	(properties
		x 191
		y 103
		scaleX 50
		scaleY 50
		view 332
		scaleSignal 1
	)
)

(instance fireplace of Feature
	(properties
		approachX 170
		approachY 119
		x 170
		y 105
		z 30
	)

	(method (handleEvent event)
		(if (and (== global163 painting) (self onMe: event))
			(= global163 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 188 76 229 93 229 132 188 96
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gEgo has: 4) ; invPoker
					(gGame handsOff:)
					(gCurRoom setScript: checkOutFire)
				else
					(gGame handsOff:)
					(gCurRoom newRoom: 2600)
				)
			)
			(10 ; invPoker
				(gCurRoom setScript: sStokeFire)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance receptionDoor of ExitFeature
	(properties
		nsLeft 171
		nsTop 52
		nsRight 181
		nsBottom 82
		approachX 174
		approachY 81
		x 176
		y 81
		nextRoom 3200
	)
)

(instance backDoor of ExitFeature
	(properties
		nsLeft 121
		nsTop 58
		nsRight 132
		nsBottom 71
		approachX 145
		approachY 77
		x 126
		y 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(if (== gChapter 7)
					(gCurRoom setScript: sDoorsSlam)
				else
					(gCurRoom setScript: sExitToGardens)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		approachX 160
		approachY 140
		nextRoom 2300
	)
)

(instance stepSnd of Sound ; UNUSED
	(properties)
)

