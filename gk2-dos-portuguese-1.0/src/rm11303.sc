;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11303)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11303 0
)

(instance rm11303 of ExitRoom ; "Wittelsbacher Theater: Side Hallway"
	(properties
		modNum 1130
		noun 1
		picture 11303
		south 1140 ; centerHallRm
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(switch gPrevRoomNum
			(1140 ; centerHallRm
				(gEgo
					posn: 211 311
					heading: 45
					sel_737:
					setScaler: Scaler 94 24 331 188
					init:
				)
			)
			(11122
				(gEgo
					posn: 292 280
					sel_737: 135
					setScaler: Scaler 83 23 318 189
					init:
				)
			)
			(else
				(gEgo
					posn: 292 207
					heading: 135
					sel_737:
					setScaler: Scaler 83 23 318 189
					init:
				)
			)
		)
		(ClearFlag 814)
		(if (IsFlag 739)
			(Palette 1 (= global249 259)) ; PalLoad
		else
			(Palette 1 (= global249 260)) ; PalLoad
		)
		(super init: &rest)
		(east3Exit init:)
		(east2Exit init:)
		(east1Exit init:)
	)
)

(instance east3Exit of ExitFeature
	(properties
		modNum 1100
		x 368
		y 151
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 359 184 359 116 377 100 377 202
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (or (IsFlag 739) (IsFlag 736)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 739)
						(gMessager say: 1 62 0 0 0 1100) ; "(THEATER FOYER, TRY TO ENTER AUDITORIUM AFTER OPERA STARTS)I don't need to go through the auditorium. I'd disrupt the performance."
					)
					((IsFlag 736)
						(gMessager say: 2 62 0 0 0 1100) ; "(EMBARRASSED)I can't go wandering all over the theater dressed like this! People are being seated!"
					)
					(else
						(gCurRoom newRoom: 11101)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance east2Exit of ExitFeature
	(properties
		modNum 1100
		approachX 300
		approachY 280
		x 405
		y 161
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 392 91 418 73 418 250 392 222
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (or (IsFlag 739) (IsFlag 736)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 739)
						(gMessager say: 1 62 0 0 0 1100) ; "(THEATER FOYER, TRY TO ENTER AUDITORIUM AFTER OPERA STARTS)I don't need to go through the auditorium. I'd disrupt the performance."
					)
					((IsFlag 736)
						(gMessager say: 2 62 0 0 0 1100) ; "(EMBARRASSED)I can't go wandering all over the theater dressed like this! People are being seated!"
					)
					(else
						(gCurRoom newRoom: 11122)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance east1Exit of ExitFeature
	(properties
		modNum 1100
		approachX 300
		approachY 280
		x 487
		y 165
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 460 294 460 33 515 -1 515 332 498 332
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (or (IsFlag 739) (IsFlag 736)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 739)
						(gMessager say: 1 62 0 0 0 1100) ; "(THEATER FOYER, TRY TO ENTER AUDITORIUM AFTER OPERA STARTS)I don't need to go through the auditorium. I'd disrupt the performance."
					)
					((IsFlag 736)
						(gMessager say: 2 62 0 0 0 1100) ; "(EMBARRASSED)I can't go wandering all over the theater dressed like this! People are being seated!"
					)
					(else
						(SetFlag 814)
						(gCurRoom newRoom: 11122)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

