;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Actor)

(public
	farmIntRm 0
)

(instance farmIntRm of ExitRoom ; "Huber Farm Interior"
	(properties
		noun 14
		picture 2101
		south 2103 ; farmIntRm2
	)

	(method (init)
		(switch gPrevRoomNum
			(220 ; farmFldRm
				(gEgo posn: 145 336 heading: 135)
				(Lock 140 210 1) ; WAVE
				(gGk2Music setLoop: -1 number: 210 play:)
			)
			(else
				(gEgo posn: 78 348 heading: 45)
			)
		)
		(gEgo normalize: setScaler: Scaler 97 76 348 308 init:)
		(fFrontDoor init:)
		(fNewsPaper init:)
		(fStationary init:)
		(fNote init:)
		(cond
			((not (gEgo has: 8)) ; invHuberKeys
				(vKeys init:)
			)
			((gEgo has: 13) ; invKlingmannReceipt
				(fMirror init:)
			)
		)
		(phone init:)
		(super init: &rest)
		(gGame handsOn: 0)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 220) ; farmFldRm
			(Lock 140 210 0) ; WAVE
			(gGk2Music fade: 0 20 10 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fFrontDoor of ExitFeature
	(properties
		sightAngle 360
		x 102
		y 188
		nextRoomNum 220 ; farmFldRm
		exitDir 0
	)

	(method (init)
		(super init:)
		(self createPoly: 166 282 166 86 44 79 39 298)
	)

	(method (doVerb)
		(if (gEgo has: 8) ; invHuberKeys
			(PlayScene 5 0 220) ; farmFldRm
		else
			(PlayScene 1005 0 220) ; farmFldRm
		)
	)
)

(instance fNewsPaper of GKFeature
	(properties
		sightAngle 360
		approachDist 200
		x 326
		y 218
		nextRoomNum 2143 ; rm2143
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 319 212 359 210 377 218 336 219)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(1
					(PlayScene 9 0 2143) ; rm2143
				)
				(3
					(SetFlag 533)
					(PlayScene 9 0 2143) ; rm2143
				)
				(5
					(PlayScene 548)
					(gEgo posn: 78 348 normalize: 45)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fStationary of GKFeature
	(properties
		sightAngle 360
		approachDist 200
		x 326
		y 218
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 285 222 296 215 317 216 304 224)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(1
					(cond
						((IsFlag 411)
							(gMessager say: 22 62 0 1 0 210) ; "(TRY TO WRITE TO GRACE AGAIN CH 1)I already wrote one letter to Gracie. Don't want to give the poor girl a heart attack!"
						)
						((not (IsFlag 826))
							(gMessager say: 27 62 0 1 0 210) ; "(TRY TO WRITE TO GRACE CH 3 BEFORE IT'S TIME)I don't have anythin' to write about at the moment."
						)
						(else
							(PlayScene 10)
							(SetFlag 411)
							(gEgo get: 9 posn: 78 348 heading: 45 normalize:) ; invGabeEnvelope1
						)
					)
				)
				(3
					(cond
						((IsFlag 411)
							(gMessager say: 28 62 0 1 0 210) ; "(TRY TO WRITE TO GRACE AGAIN IN CH 3 AFTER ALREADY WRITING HER ABOUT LUDWIG)I don't want to distract Gracie from her "Ludwig" research with another letter."
						)
						((IsFlag 241) ; "Ludwig II" in rm4220b
							(PlayScene 232)
							(SetFlag 411)
							(gEgo
								get: 31 ; invGabeEnvelope2
								posn: 78 348
								heading: 45
								normalize:
							)
						)
						(else
							(gMessager say: 27 62 0 1 0 210) ; "(TRY TO WRITE TO GRACE CH 3 BEFORE IT'S TIME)I don't have anythin' to write about at the moment."
						)
					)
				)
				(5
					(gMessager say: 13 62 0 1 0 210) ; "(TRY TO WRITE TO GRACE, CH 5)I don't want to write to Gracie. If she knew about the huntin' trip, she'd REALLY freak."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance phone of GKFeature
	(properties
		modNum 210
		sightAngle 360
		x 523
		y 211
	)

	(method (init)
		(self createPoly: 507 224 507 199 540 199 540 224)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (== (event message:) KEY_DIVIDE) (not (IsFlag 546)))
			(= sightAngle 5)
		else
			(= sightAngle 360)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 2 62 0 0 0 210) ; "(TRY TO USE PHONE)Who should I call?"
			)
			(7 ; invUbergrauLetter
				(gMessager say: 4 7 0 0 0 210) ; "(USE UBERGRAU LETTER ON PHONE)I could call \9abergrau, but I'd rather just go over there."
			)
			(47 ; invGrosPhoneNumber
				(cond
					((IsFlag 546)
						(gMessager say: 12 47 0 0 0 210) ; "(TRY TO CALL GROSSBERG ASSISTANT AFTER FIRST TIME)I don't think there's much more to be gained from Grossberg's assistant."
					)
					((and (== gChapter 3) (IsFlag 515))
						(PlayScene 233)
						(SetFlag 546) ; enable "Grossberg's Account Book" in rm3210
						(gEgo heading: 225 posn: 453 301 normalize:)
					)
					(else
						(gMessager say: 34 62 0 0 0 210) ; "(PICKUP, TRY TO CALL GROSSBERG'S NBR CH 3 BEFORE FINISHING DIALOGUE WITH LEBER)I need to make sure I've gleaned everythin' I can from Leber before I try that."
					)
				)
			)
			(53 ; invGabeEnvelope1
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(54 ; invGabeEnvelope2
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(55 ; ???
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(63 ; invGabeLetter1
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(64 ; invGabeLetter2
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(83 ; invGraceEnvelope3
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(49 ; invGraceLetter1
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(50 ; invGraceLetter2
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(51 ; invGraceLetter3
				(gMessager say: 3 0 0 0 0 210) ; "(USE GRACE LETTER ON PHONE)I don't need to call Gracie."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fNote of GKFeature
	(properties
		sightAngle 360
		approachDist 200
		x 5
		y 230
		nextRoomNum 2142 ; rm2142
	)

	(method (init)
		(super init:)
		(self createPoly: 10 122 27 127 27 174 14 170)
	)
)

(instance fMirror of GKFeature
	(properties
		sightAngle 360
		x 170
		y 144
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				178
				104
				230
				106
				230
				169
				244
				169
				244
				176
				238
				176
				238
				187
				227
				179
				219
				183
				202
				185
				184
				182
				174
				188
				174
				175
				170
				175
				170
				169
				178
				169
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; invKlingmannReceipt
				(if (and (IsFlag 434) (== gChapter 1))
					(PlayScene 13)
					(SetFlag 412) ; enable "Die K\94niglich-Bayrische Hofjagdloge" in rm4220
					(gEgo posn: 78 348 heading: 135 normalize:)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vKeys of View
	(properties
		sightAngle 360
		x 195
		y 187
		view 2101
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 180 173 206 173 201 193 181 193)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 8)
			(gEgo get: 8 posn: 78 348 heading: 135 normalize:) ; invHuberKeys
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

