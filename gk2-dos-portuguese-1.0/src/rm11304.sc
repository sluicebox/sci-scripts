;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11304)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm11304 0
)

(instance rm11304 of ExitRoom ; "Wittelsbacher Theater: Side Hallway"
	(properties
		modNum 1130
		noun 1
		picture 11304
		south 1140 ; centerHallRm
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(switch gPrevRoomNum
			(1140 ; centerHallRm
				(gEgo
					posn: 344 330
					heading: 315
					sel_737:
					setScaler: Scaler 83 23 318 189
					init:
				)
			)
			(11120
				(gEgo
					posn: 335 280
					sel_737: 225
					setScaler: Scaler 83 23 318 189
					init:
				)
			)
			(else
				(gEgo
					posn: 324 206
					heading: 225
					sel_737:
					setScaler: Scaler 83 23 318 189
					init:
				)
			)
		)
		(ClearFlag 814)
		(if (IsFlag 739)
			(Palette 1 (= global249 261)) ; PalLoad
		else
			(Palette 1 (= global249 262)) ; PalLoad
		)
		(super init: &rest)
		(west3Exit init:)
		(west2Exit init:)
		(west1Exit init:)
		(spotlightExit init:)
	)
)

(instance west3Exit of ExitFeature
	(properties
		modNum 1100
		x 247
		y 155
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 239 206 239 105 255 117 255 188
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
						(gCurRoom newRoom: 1110) ; audRm
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance west2Exit of ExitFeature
	(properties
		modNum 1100
		approachX 327
		approachY 280
		x 209
		y 164
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 196 255 196 74 223 93 223 223
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
						(gCurRoom newRoom: 11120)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance west1Exit of ExitFeature
	(properties
		modNum 1100
		approachX 327
		approachY 280
		x 128
		y 166
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 99 0 157 38 157 293 118 333 99 333
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
						(gCurRoom newRoom: 11120)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spotlightExit of ExitFeature
	(properties
		sightAngle 40
		approachX 286
		approachY 188
		x 333
		y 150
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 188 260 113 301 113 301 188
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 1170) ; spotRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

