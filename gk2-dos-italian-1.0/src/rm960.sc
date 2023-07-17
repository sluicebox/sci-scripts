;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 960)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm960 0
)

(instance rm960 of ExitRoom ; "Neuschwanstein: Grotto"
	(properties
		noun 11
		picture 9601
		west 9502 ; neuLRStool
	)

	(method (init)
		(gEgo
			posn: 442 360
			heading: 315
			sel_737:
			setScaler: Scaler 79 74 352 342
			init:
		)
		(if (== gChapter 4)
			(tourTapeButton init:)
		else
			(secretArea init:)
		)
		(super init: &rest)
		(if (IsFlag 788)
			(guard3 init: setPri: 199)
		)
		(table init:)
		(studyExit init:)
		(livingExit init:)
		(if (and (== gChapter 6) (not (IsFlag 645)))
			(SetFlag 645)
			(PlayScene 774)
		)
		(self setScript: guardControl)
	)
)

(instance secretArea of GKFeature
	(properties
		sightAngle 360
		x 207
		y 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -3 184 74 217 177 335 -1 337
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 62)) ; Do
			((IsFlag 803)
				(= noun 13)
				(= BAD_SELECTOR 0)
			)
			((gCast contains: guard3)
				(= noun 12)
				(= BAD_SELECTOR 0)
			)
			(else
				(= BAD_SELECTOR 781)
				(= noun 0)
				(gEgo
					get:
						(cond
							((gEgo has: 60) ; invOperaAct1
								(gEgo put: 60) ; invOperaAct1
								59
							)
							((gEgo has: 59) ; invOperaAct2
								(gEgo put: 59) ; invOperaAct2
								58
							)
							(else 60)
						)
				)
				(SetFlag 803)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance table of Feature
	(properties
		noun 2
		sightAngle 360
		x 283
		y 233
	)

	(method (init)
		(if (== gChapter 6)
			(= noun 10)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 209 210 282 197 325 201 326 180 351 165 357 294 334 301 272 300
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance studyExit of ExitFeature
	(properties
		approachX 173
		approachY 406
		x 173
		y 204
		BAD_SELECTOR 930
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 118 231 118 212 199 166 256 167 291 138 291 116 266
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance livingExit of ExitFeature
	(properties
		approachX 400
		approachY 600
		x 289
		y 519
		BAD_SELECTOR 950
		BAD_SELECTOR 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 176 336 176 299 402 299 402 339
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance guard3 of Prop
	(properties
		modNum 910
		sightAngle 360
		x 28
		y 333
		view 31960
	)

	(method (doVerb theVerb)
		(= noun
			(if (== gChapter 4)
				(if (== theVerb 62) ; Do
					1
				else
					(= theVerb 0)
					2
				)
			else
				(switch theVerb
					(31 19) ; invDove
					(else
						(= theVerb 62) ; Do
						18
					)
				)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance tourTapeButton of Prop
	(properties
		noun 1
		modNum 960
		sightAngle 360
		x 10
		y 290
		view 141
		loop 5
	)

	(method (cue)
		(gGame changeScore: 992)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 587)
			(gMessager say: noun 62 0 0 self modNum) ; "This is a reproduction of the grotto from the Tannh\84user saga. In such places, Ludwig could pretend he was one of his beloved mythic heroes."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance guardControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= seconds (Random 40 50))
			)
			(1
				(gGame handsOff:)
				(cond
					((= register (gCast contains: guard3))
						(ClearFlag 788)
						(guard3 setScript: 0 setCycle: Beg self)
					)
					((not (DoAudio audWPLAY))
						(SetFlag 788)
						(PlayRobot 30960 0 127 self 200)
					)
					(else
						(-- state)
						(= seconds 2)
					)
				)
			)
			(2
				(= state -1)
				(if register
					(if (not (DoAudio audWPLAY))
						(guard3 dispose:)
						(PlayRobot 32960 0 127 self 200)
					else
						(= state 1)
						(= seconds 2)
					)
				else
					(= seconds (Random 2 4))
					(guard3 init: setPri: 199 setScript: FidgetScript)
				)
			)
		)
	)
)

