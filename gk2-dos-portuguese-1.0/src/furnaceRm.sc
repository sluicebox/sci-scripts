;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1190)
(include sci.sh)
(use Main)
(use GabeEgo)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	furnaceRm 0
)

(instance furnaceRm of ExitRoom ; "Wittelsbacher Theater: Furnace Room"
	(properties
		noun 17
		picture 11902
	)

	(method (init &tmp temp0)
		(gEgo
			posn: 420 360
			heading: 315
			sel_737:
			setScaler: Scaler 82 68 324 296
			init:
		)
		(cond
			((== gEgo GabeEgo)
				(= temp0 246)
			)
			((IsFlag 739)
				(= temp0 248)
			)
			(else
				(= temp0 247)
			)
		)
		(Palette 1 (= global249 temp0)) ; PalLoad
		(super init: &rest)
		(basementExit init:)
		(furnaceControls init:)
		(furnaceDoor init:)
		(proper init:)
		(coal init:)
	)
)

(instance furnaceDoorOpen of View
	(properties
		modNum 1190
		approachX 420
		approachY 238
		x 277
		y 238
		view 30935
	)

	(method (init)
		(if (IsFlag 746)
			(gGk2Music setVol: 63)
		)
		(super init: &rest)
	)

	(method (onMe)
		(return (and (not (furnaceControls onMe: &rest)) (super onMe: &rest)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(ClearFlag 797)
				(PlayScene 926)
				(gEgo sel_737: 315)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (IsFlag 746)
			(gGk2Music setVol: 32)
		)
		(super dispose:)
	)
)

(instance fire of Prop
	(properties
		x 301
		y 217
		view 21902
	)

	(method (init)
		(Lock 140 1190 1) ; WAVE
		(super init: &rest)
		((gUser sel_715:) delete: self)
		(self setCycle: Fwd)
		(gGk2Music
			number: 1190
			setLoop: -1
			play: (if (IsFlag 797) 63 else 32) 0
		)
	)

	(method (dispose)
		(gGk2Music fade: 0 10 10 1)
		(Lock 140 1190 0) ; WAVE
		(super dispose: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance coal of GKFeature
	(properties
		modNum 1190
		nsLeft 411
		nsTop 171
		nsRight 541
		nsBottom 290
		sightAngle 0
		approachX 420
		approachY 291
		x 523
		y 291
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (or (IsFlag 795) (not (IsFlag 1120))))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (not (IsFlag 1120)) (== gEgo GraceEgo))
						(gMessager say: 20 62 0 0 0 1140) ; "(TRY TO USE ROPE ON DOORS BEFORE DECIDING TO SEAT VON GLOWER HERE)I'm not sure why I'd want to do that."
					)
					((and (IsFlag 795) (== gEgo GraceEgo))
						(gMessager say: 15 theVerb 0 0 0 modNum) ; "(TRY TO PUT COAL IN FURNACE AFTER FIRE IS LIT)The furnace doesn't need any more coal."
					)
					((and (IsFlag 795) (== gEgo GabeEgo))
						(gMessager say: 19 theVerb 0 0 0 modNum) ; "(PICKUP, CH 6 TRY TO GET COAL IN FURNACE ROOM, CRANKY)The fire doesn't need any more coal!"
					)
					((IsFlag 797)
						(SetFlag 795)
						(PlayScene 929)
						(PlayScene 926)
						(gEgo sel_737: 315)
						(furnaceDoorOpen dispose:)
						(ClearFlag 797)
					)
					(else
						(PlayScene 928)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance basementExit of ExitFeature
	(properties
		x 46
		y 193
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 59 333 26 333 26 0 56 0 138 53 138 306
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11812)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance furnaceDoor of GKFeature
	(properties
		modNum 1190
		approachX 400
		x 331
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 290 149 386 149 386 223 290 223
					yourself:
				)
		)
		(if (IsFlag 797)
			(furnaceDoorOpen init:)
		)
		(if (IsFlag 746)
			(fire init:)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(and
						(== gEgo GraceEgo)
						(or (IsFlag 795) (not (IsFlag 1120)))
					)
					(== gEgo GabeEgo)
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((== gEgo GraceEgo)
						(cond
							((IsFlag 795)
								(if (IsFlag 746)
									(gMessager say: 2 theVerb 0 0 0 modNum) ; "(DOUBTFUL)I don't think I should open the door while the furnace is burning."
								else
									(gMessager say: 1 theVerb 0 0 0 modNum) ; "(THEATER FURNACE ROOM, DOUBTFUL)I've already put plenty of coal in there. I don't need to open the door."
								)
							)
							((not (IsFlag 1120))
								(gMessager say: 20 62 0 0 0 1140) ; "(TRY TO USE ROPE ON DOORS BEFORE DECIDING TO SEAT VON GLOWER HERE)I'm not sure why I'd want to do that."
							)
							((IsFlag 797)
								(ClearFlag 797)
								(furnaceDoorOpen dispose:)
								(PlayScene 926)
								(gEgo sel_737: 315)
							)
							(else
								(SetFlag 797)
								(furnaceDoorOpen init:)
								(PlayScene 925)
								(gEgo sel_737: 315)
							)
						)
					)
					((IsFlag 794)
						(super doVerb: theVerb)
					)
					(else
						(gMessager say: 3 theVerb 0 0 0 modNum) ; "(TRY TO OPEN DOOR AS GABRIEL/HUMAN)If I open that door, the fire might go out, and I'm freezin'!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance furnaceControls of GKFeature
	(properties
		modNum 1190
		approachX 400
		x 325
		y 254
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 286 226 396 226 396 256 286 256
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(== gEgo GabeEgo)
					(and (== gEgo GraceEgo) (IsFlag 746))
					(not (IsFlag 1120))
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(cond
						((not (IsFlag 1120))
							(gMessager say: 20 62 0 0 0 1140) ; "(TRY TO USE ROPE ON DOORS BEFORE DECIDING TO SEAT VON GLOWER HERE)I'm not sure why I'd want to do that."
						)
						((IsFlag 746)
							(gMessager say: 7 theVerb 0 0 0 modNum) ; "(TRY TO LIGHT FURNACE-- SECOND TIME)The furnace is already lit."
						)
						(else
							(gCurRoom newRoom: 11940)
						)
					)
				else
					(gMessager say: 8 theVerb 0 0 0 modNum) ; "(TRY TO ADJUST CONTROLS)It seems to be running okay. I don't want to mess with the controls."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance proper of GKFeature
	(properties
		modNum 1190
		sightAngle 360
		x 278
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 237 301 238 279 262 233 237 233 235 59 381 72 402 119 455 119 455 169 406 169 406 246 446 276 446 301
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(if (IsFlag 746)
						(gMessager say: 5 theVerb 0 0 0 modNum) ; "(LOOK AT FURNACE AFTER LIGHTING IT, SAD)That should make Gabriel feel better."
					else
						(gMessager say: 4 theVerb 0 0 0 modNum) ; "(LOOK AT FURNACE BEFORE LIGHTING IT)The furnace doesn't appear to be running at the moment."
					)
				else
					(gMessager say: 6 theVerb 0 0 0 modNum) ; "(LOOK AT FIRE, SICK, WISTFUL)That fire feels great. I wish I could just curl up next to it and sleep."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

