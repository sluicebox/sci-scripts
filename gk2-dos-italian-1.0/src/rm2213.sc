;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2213)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)

(public
	rm2213 0
)

(local
	local0 = 2213
)

(instance rm2213 of ExitRoom ; "Huber Farm Exterior"
	(properties
		modNum 220
		noun 9
		picture 2213
		south 220 ; farmFldRm
	)

	(method (cue)
		(gCurRoom newRoom: local0)
	)

	(method (init)
		(if (gEgo has: 73) ; invPitcher
			(Palette 1 (= global249 209)) ; PalLoad
		else
			(Palette 1 (= global249 208)) ; PalLoad
		)
		(super init: &rest)
		(fpsDoor init:)
		(switch gPrevRoomNum
			(220 ; farmFldRm
				(gEgo posn: 447 336 heading: 315)
			)
			(else
				(gEgo posn: 359 328 heading: 135)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 100 90 338 303 init:)
		(if (not (gEgo has: 73)) ; invPitcher
			(vBucket init:)
		)
		(gGame handsOn: 0)
	)
)

(instance vBucket of View
	(properties
		x 269
		y 106
		view 2213
	)

	(method (doVerb theVerb)
		(fpsDoor doVerb: theVerb)
	)
)

(instance fpsDoor of Feature
	(properties)

	(method (init)
		(self createPoly: 209 21 312 36 319 273 219 300)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gEgo has: 73)) ; invPitcher
			(gGame handsOff:)
			(= global141 self)
			(= local0 2244)
			(if (== gPrevRoomNum 220) ; farmFldRm
				(gEgo view: 474 cel: 0 loop: 0 setCycle: End gCurRoom)
			else
				(super handleEvent: event &rest)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(111 ; invPitcher
				(if (gEgo has: 73) ; invPitcher
					(PlayScene 2023 0 2244) ; rm2244
				else
					(PlayScene 3023 0 2244) ; rm2244
				)
			)
			(62 ; Do
				(if (gEgo has: 73) ; invPitcher
					(PlayScene 2023 0 2244) ; rm2244
				else
					(PlayScene 3023 0 2244) ; rm2244
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature ; UNUSED
	(properties
		x 320
		y 480
		BAD_SELECTOR 4
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gEgo has: 73)) ; invPitcher
			(gGame handsOff:)
			(= global141 self)
			(= local0 220)
			(if (== gPrevRoomNum 2244)
				(gEgo view: 471 cel: 0 loop: 0 setCycle: End gCurRoom)
			else
				(super handleEvent: event &rest)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(= sightAngle 5)
		(if (gEgo has: 73) ; invPitcher
			(= sightAngle 360)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 220) ; farmFldRm
		else
			(super doVerb: &rest)
		)
	)
)

