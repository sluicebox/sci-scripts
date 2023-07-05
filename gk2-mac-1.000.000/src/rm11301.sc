;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11301)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11301 0
)

(instance rm11301 of ExitRoom ; "Wittelsbacher Theater: Side Hallway"
	(properties
		modNum 1130
		noun 1
		picture 11301
		south 11002 ; rm11002
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(switch gPrevRoomNum
			(11002
				(gEgo
					posn: 264 313
					heading: 45
					normalize:
					setScaler: Scaler 83 23 318 189
					init:
				)
			)
			(11122
				(gEgo
					posn: 292 280
					normalize: 135
					setScaler: Scaler 83 23 318 189
					init:
				)
			)
			(else
				(gEgo
					posn: 292 207
					heading: 135
					normalize:
					setScaler: Scaler 83 23 318 189
					init:
				)
			)
		)
		(ClearFlag 814)
		(if (IsFlag 739)
			(Palette 1 (= global249 255)) ; PalLoad
		else
			(Palette 1 (= global249 256)) ; PalLoad
		)
		(super init: &rest)
		(east3Exit init:)
		(east2Exit init:)
		(east1Exit init:)
		(backstageExit init:)
	)
)

(instance east3Exit of ExitFeature
	(properties
		modNum 1100
		x 368
		y 151
		exitDir 2
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
		exitDir 2
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
		exitDir 2
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

(instance backstageExit of ExitFeature
	(properties
		x 280
		y 150
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 314 188 314 113 353 113 353 188
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
						(gMessager say: 9 62 0 0 0 1100) ; "I don't need to go that way at the moment."
					)
					((IsFlag 736)
						(gMessager say: 2 62 0 0 0 1100) ; "(EMBARRASSED)I can't go wandering all over the theater dressed like this! People are being seated!"
					)
					(else
						(gCurRoom newRoom: 1150) ; backStageRm
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

