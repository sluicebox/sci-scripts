;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
)

(instance rm400 of LBRoom
	(properties
		noun 28
		picture 400
		west 370
		vanishingY 50
	)

	(method (init &tmp [temp0 30])
		(self setRegions: 93) ; RotundaRgn
		((ScriptID 2400 0) doit: (= obstacles (List new:))) ; poly2400Code
		(gEgo y: 180 init: normalize: 831 setScale: Scaler 125 30 190 50)
		(super init:)
		(cond
			((or (> gAct 2) (not (& $7204 gMustDos)))
				(realDagger init: approachVerbs: 4 1 8) ; Do, Look, magnifier
			)
			((not (IsFlag 71))
				((ScriptID 93 3) ; Heimlich
					init:
					posn: 70 185
					setLoop: 8
					setCel: 1
					setScale: 160
				)
				(script next: sHeimlichShoos2)
			)
			(else
				(daggerGone init:)
			)
		)
		(westExitFeature init:)
		(cashRegister init: approachVerbs: 4) ; Do
		(middleShelves init:)
		(secondShelf init: approachVerbs: 4 1) ; Do, Look
		(glassCounter init:)
		(fakeDaggers init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(footedPot init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(largePicture init: approachVerbs: 1) ; Look
		(littleThings init: approachVerbs: 1) ; Look
		(leftShelves init:)
		(nefertiti init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(fakeNefertiti init: approachVerbs: 4 1 8) ; Do, Look, magnifier
		(purplePots init: approachVerbs: 1) ; Look
		(rug init:)
		(rightShelves init: approachVerbs: 4 1) ; Do, Look
		(smallPicture init: approachVerbs: 1) ; Look
	)

	(method (newRoom)
		(gGameMusic2 stop:)
		(gGameMusic1 pause: 0 fade: 127 5 5 0)
		(super newRoom: &rest)
	)

	(method (dispose)
		(DisposeScript 2400)
		(super dispose:)
	)
)

(instance sHeimlichShoos of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(= ticks 30)
			)
			(2
				((ScriptID 22 0) doit: $7204 self) ; triggerAndClock, 7:30 pm
			)
			(3
				(gGameMusic1 pause: 1)
				(gGameMusic2 number: 19 flags: 1 setLoop: 1 play:)
				((ScriptID 93 3) ; Heimlich
					init:
					setCycle: StopWalk -1
					setScale: 160
					posn: -20 185
					setMotion: MoveTo 80 185 self
				)
			)
			(4
				((ScriptID 93 3) setLoop: 8 setCel: 6) ; Heimlich
				(= ticks 30)
			)
			(5
				(gMessager say: 33 8 0 0 self) ; "Fraulein! Zis Gift Shop is closed! You should not be here!"
			)
			(6
				(gEgo setMotion: PolyPath 80 165 self)
			)
			(7
				((ScriptID 93 3) setCel: 3) ; Heimlich
				(gEgo setMotion: PolyPath 40 180 self)
			)
			(8
				((ScriptID 93 3) setCel: 7) ; Heimlich
				(gEgo setMotion: PolyPath -50 180 self)
			)
			(9
				(gEgo edgeHit: EDGE_LEFT)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance sHeimlichShoos2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic1 pause: 1)
				(gGameMusic2 number: 19 flags: 1 setLoop: 1 play:)
				(= cycles 2)
			)
			(1
				(gMessager say: 3 0 82 0 self 1889) ; "Ze gift shop ist CLOSED! You must leave at VONCE!"
			)
			(2
				(gEgo setMotion: PolyPath -50 (gEgo y:) self)
			)
			(3
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance daggerGone of View
	(properties
		x 242
		y 110
		view 403
	)
)

(instance inPittsburgh of Inset
	(properties
		picture 401
		x 250
		y 50
		hideTheCast 1
	)

	(method (init)
		(super init: &rest)
		(if register
			(stamp init:)
		)
		(daggerFeature init: register)
		(proc0_8 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(proc0_8 0)
		(daggerFeature dispose:)
		(if (not register)
			(gCurRoom setScript: sHeimlichShoos)
		)
		(super dispose:)
	)
)

(instance stamp of View
	(properties
		x 88
		y 85
		view 401
	)

	(method (doVerb theVerb)
		(daggerFeature doVerb: theVerb)
	)
)

(instance daggerFeature of Feature
	(properties
		x 1
		y 100
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(inPittsburgh doVerb: 13)
			)
			(8 ; magnifier
				(gMessager say: noun 8)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init param1)
		(= noun (if param1 7 else 8))
		(super init: &rest)
	)
)

(instance westExitFeature of ExitFeature
	(properties
		nsTop 150
		nsBottom 189
		nsRight 5
		cursor 12
		exitDir 4
		noun 32
	)
)

(instance cashRegister of Feature
	(properties
		x 225
		y 140
		noun 9
		sightAngle 40
		onMeCheck 16384
		approachX 241
		approachY 138
		approachDist 44
	)
)

(instance middleShelves of Feature
	(properties
		x 159
		y 84
		noun 16
		nsTop 61
		nsLeft 88
		nsBottom 107
		nsRight 230
		sightAngle 40
		approachX 153
		approachY 110
		approachDist 55
	)
)

(instance secondShelf of Feature
	(properties
		x 136
		y 85
		noun 2
		nsTop 79
		nsLeft 101
		nsBottom 91
		nsRight 171
		sightAngle 40
		approachX 136
		approachY 110
		approachDist 34
	)
)

(instance glassCounter of Feature
	(properties
		x 225
		y 122
		noun 6
		sightAngle 40
		onMeCheck 8192
		approachX 222
		approachY 140
	)
)

(instance fakeDaggers of Feature
	(properties
		x 270
		y 114
		noun 7
		sightAngle 40
		onMeCheck 4096
		approachX 254
		approachY 141
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; magnifier
			(gCurRoom setInset: inPittsburgh 0 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance realDagger of Feature
	(properties
		x 249
		y 115
		noun 8
		nsTop 108
		nsLeft 243
		nsBottom 111
		nsRight 256
		sightAngle 40
		approachX 249
		approachY 109
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 8) (== gAct 2) (not (& gMustDos $7204))) ; magnifier
			(gCurRoom setInset: inPittsburgh)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance footedPot of Feature
	(properties
		x 231
		y 153
		noun 14
		nsTop 151
		nsLeft 224
		nsBottom 156
		nsRight 239
		sightAngle 40
		approachX 235
		approachY 166
	)
)

(instance largePicture of Feature
	(properties
		x 285
		y 74
		noun 5
		sightAngle 40
		onMeCheck 2048
		approachX 261
		approachY 149
	)
)

(instance littleThings of Feature
	(properties
		x 225
		y 133
		noun 15
		sightAngle 40
		onMeCheck 1024
		approachX 235
		approachY 166
	)
)

(instance leftShelves of Feature
	(properties
		x 43
		y 70
		noun 1
		sightAngle 40
		onMeCheck 512
		approachX 69
		approachY 130
	)
)

(instance nefertiti of Feature
	(properties
		x 10
		y 107
		noun 12
		nsTop 97
		nsLeft 2
		nsBottom 117
		nsRight 19
		sightAngle 40
		approachX 40
		approachY 153
	)
)

(instance fakeNefertiti of Feature
	(properties
		x 48
		y 75
		noun 13
		nsTop 69
		nsLeft 43
		nsBottom 81
		nsRight 53
		sightAngle 40
		approachX 73
		approachY 127
	)
)

(instance purplePots of Feature
	(properties
		x 253
		y 124
		noun 10
		sightAngle 40
		onMeCheck 256
		approachX 247
		approachY 135
	)
)

(instance rug of Feature
	(properties
		x 132
		y 141
		noun 11
		sightAngle 40
		onMeCheck 128
		approachX 132
		approachY 141
	)
)

(instance rightShelves of Feature
	(properties
		x 270
		y 113
		noun 3
		sightAngle 40
		onMeCheck 64
		approachX 254
		approachY 141
	)
)

(instance smallPicture of Feature
	(properties
		x 248
		y 64
		noun 4
		sightAngle 40
		onMeCheck 32
		approachX 234
		approachY 117
	)
)

