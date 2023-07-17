;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2202)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)
(use Motion)

(public
	rm2202 0
)

(local
	local0
)

(instance rm2202 of ExitRoom
	(properties
		modNum 220
		picture 2202
	)

	(method (cue)
		(gCurRoom newRoom: local0)
	)

	(method (init)
		(if (gEgo has: 73) ; invPitcher
			(Palette 1 (= global249 203)) ; PalLoad
		else
			(Palette 1 (= global249 202)) ; PalLoad
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(220 ; farmFldRm
				(gEgo posn: 340 325 heading: 45)
			)
			(else
				(gEgo posn: 294 289 heading: 180)
			)
		)
		(gEgo
			sel_737:
			setScaler: Scaler 81 35 332 224
			init:
			heading: (if (== gPrevRoomNum 220) 45 else 179) ; farmFldRm
		)
		(fMuddyArea init:)
		(fSouthExit init:)
		(if (not (gEgo has: 73)) ; invPitcher
			(fTreeLine init:)
		)
		(gGame handsOn:)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (handleEvent event)
		(cond
			((and (self onMe: event) (gEgo has: 73)) ; invPitcher
				(gGame handsOff:)
				(= global141 self)
				(= local0 220)
				(if (== gPrevRoomNum 2212)
					(gEgo view: 472 cel: 0 loop: 0 setCycle: End gCurRoom)
				else
					(gEgo view: 470 cel: 0 loop: 1 setCycle: End gCurRoom)
				)
			)
			((and (self onMe: event) (== (gEgo heading:) 179))
				(= local0 220)
				(gEgo view: 544 setCycle: End gCurRoom)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb)
		(gCurRoom newRoom: 220) ; farmFldRm
	)
)

(instance fMuddyArea of GKFeature
	(properties
		modNum 220
		x 480
		y 150
		BAD_SELECTOR 2212
	)

	(method (init)
		(super init:)
		(self createPoly: 446 225 612 230 612 184 444 182)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gEgo has: 73)) ; invPitcher
			(gGame handsOff:)
			(= global141 self)
			(= local0 2212)
			(if (== gPrevRoomNum 220) ; farmFldRm
				(gEgo view: 470 cel: 0 loop: 0 setCycle: End gCurRoom)
			else
				(super handleEvent: event &rest)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 62) (== theVerb 111)) ; Do, invPitcher
			(gCurRoom newRoom: 2212)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fTreeLine of ExitFeature
	(properties
		modNum 220
		x 400
		y 150
		BAD_SELECTOR 2211
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 259 104 342 225 444 225 444 182 504 182 507 104)
	)
)

