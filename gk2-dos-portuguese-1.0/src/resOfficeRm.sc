;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1120)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)

(public
	resOfficeRm 0
)

(instance resOfficeRm of ExitRoom ; "Wittelsbacher Theater: Office"
	(properties
		noun 6
		picture 11201
	)

	(method (init)
		(if (IsFlag 735)
			(gGk2Music fade: 0 10 10 1)
			(Lock rsAUDIO 11002 0)
			((ScriptID 1101 0) keep: 0) ; resRegion
		else
			(gGk2Music fade: 0 10 10 1)
		)
		(gEgo
			posn: 100 320
			heading: 135
			sel_737:
			setScaler: Scaler 95 62 327 238
			init:
		)
		(if (IsFlag 739)
			(Palette 1 (= global249 253)) ; PalLoad
		else
			(Palette 1 (= global249 254)) ; PalLoad
		)
		(super init: &rest)
		(if (and (not (IsFlag 789)) (not (IsFlag 736)))
			(gabriel init: setScript: FidgetScript)
		else
			(blankets init:)
		)
		(if (not (IsFlag 739))
			(dress init:)
		)
		(if (not (IsFlag 758))
			(seatChart init:)
		)
		(if (not (IsFlag 742))
			(toDoList init:)
		)
		(if (not (IsFlag 761))
			(glasses init:)
		)
		(door init:)
		(bulletin init:)
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (== newRoomNumber 11302) (IsFlag 735))
				(Lock rsAUDIO 11002 1)
				(gGk2Music play: 0 0 fade: 63 10 10 0)
				(self setRegions: 1101) ; resRegion
			)
			((== newRoomNumber 11302)
				(gGk2Music play: 0 0 fade: 63 10 10 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance blankets of View
	(properties
		sightAngle 360
		y 233
		view 30976
	)

	(method (init)
		(super init: &rest)
		((gUser sel_715:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance gabriel of Prop
	(properties
		modNum 1120
		sightAngle 40
		approachX 200
		y 283
		priority 1
		fixPriority 1
		view 20873
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(= global141 self)
				(or
					(and (not (IsFlag 760)) (not (IsFlag 746)))
					(and
						(IsFlag 760)
						(IsFlag 749)
						(not (IsFlag 743))
						(not (IsFlag 796))
					)
					(IsFlag 743)
				)
			)
			(= global141 0)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (not (IsFlag 760)) (not (IsFlag 746)))
						(SetFlag 760)
						(PlayScene 842)
					)
					((and (IsFlag 760) (not (IsFlag 749)))
						(gMessager say: 7 theVerb 0 0 0 modNum) ; "(PICKUP. TRY TO TALK TO GABE IN THEATER OFFICE AFTER FIRST TIME, ANXIOUS)I should let him rest ... while he still can."
					)
					((and (IsFlag 760) (IsFlag 749) (not (IsFlag 743)))
						(if (IsFlag 796)
							(gMessager say: 7 theVerb 0 0 0 modNum) ; "(PICKUP. TRY TO TALK TO GABE IN THEATER OFFICE AFTER FIRST TIME, ANXIOUS)I should let him rest ... while he still can."
						else
							(SetFlag 796)
							(PlayScene 844)
						)
					)
					((IsFlag 743)
						(SetFlag 789)
						(ClearFlag 735)
						(SetFlag 736)
						(PlayScene 845 0 11002) ; rm11002
					)
				)
			)
			(96 ; invVonGlowerLetter
				(gMessager say: 5 96 0 0 0 1120) ; "(DOESN'T WANT TO SHOW HIM THE LETTER BUT FEELS GUILTY ABOUT IT)I'll show him von Glower's letter. Eventually."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dress of View
	(properties
		modNum 1120
		sightAngle 40
		x 245
		y 118
		view 30976
		loop 3
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 735))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 735)
					(gMessager say: 1 62 0 0 0 1120) ; "(THEATER OFFICE, TRY TO PUT ON DRESS BEFORE OVERTURE)I'm not ready to get dressed yet."
				else
					(SetFlag 739)
					(PlayScene 838)
					(Palette 1 253) ; PalLoad
					(SetFlag 759)
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance seatChart of View
	(properties
		modNum 1120
		sightAngle 40
		x 313
		y 131
		view 30976
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11241)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glasses of View
	(properties
		x 371
		y 249
		view 30976
		loop 1
	)

	(method (doVerb theVerb)
		(table doVerb: theVerb)
	)
)

(instance toDoList of View
	(properties
		x 309
		y 218
		view 30976
		loop 2
	)

	(method (doVerb theVerb)
		(table doVerb: theVerb)
	)
)

(instance door of ExitFeature
	(properties
		sightAngle 40
		x 224
		y 136
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 235 186 38 262 44 262 225
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11302)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance couch of GKFeature ; UNUSED
	(properties
		sightAngle 40
		x 87
		y 218
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 165 175 152 175 265 0 284
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11213)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of GKFeature
	(properties
		sightAngle 40
		x 379
		y 211
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 291 194 314 186 349 183 387 185 424 191 460 200 467 210 465 220 453 227 425 230 399 240 388 240 372 229 299 214
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11240)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bulletin of GKFeature
	(properties
		sightAngle 40
		x 347
		y 93
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 299 37 396 10 396 177 299 162
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11241)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

