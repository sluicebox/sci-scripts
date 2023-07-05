;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 815)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use Talker)
(use PolyPath)
(use Feature)
(use Motion)
(use Inventory)
(use User)
(use System)

(class Apartment of EcoFeature
	(properties
		BelongsTo 0
		IamHome 0
		bitValue 0
		light 0
		lightX 0
		lightY 0
		lightMsg 0
		swimX 0
		swimY 0
		egoPri 0
		newRoom 0
	)

	(method (init param1)
		(self approachVerbs: 4 1 2) ; Do, Look, Talk
		(if param1
			(= light (Clone param1))
			(light
				x: lightX
				y: lightY
				loop: (- (light loop:) IamHome)
				setCycle: Fwd
				init:
			)
			(if (not IamHome)
				(light setCycle: 0 stopUpd:)
			)
		)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(if light
			(light dispose:)
		)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(or (== (event message:) KEY_RETURN) (& (event type:) evMOUSEBUTTON))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(self onMe: event)
			)
			(CueObj state: 0 cycles: 0 client: self theVerb: 4)
			(gEgo
				setMotion: PolyPath approachX (+ (gEgo z:) approachY) CueObj
			)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if IamHome
					(EcoNarrator init: 4 0 0 9)
				else
					(EcoNarrator init: 4 0 0 10)
				)
			)
			(4 ; Do
				(cond
					((gEgo has: 25) ; scroll
						(EcoNarrator init: 4 0 0 88)
					)
					(
						(and
							(gCast contains: (ScriptID 200 7)) ; gregarious
							(!= ((Inv at: 1) owner:) 200) ; starFish
						)
						(EcoNarrator init: 4 0 0 95)
					)
					((== ((Inv at: 1) owner:) 200) ; starFish
						(gEgo setPri: egoPri)
						(= global229 BelongsTo)
						(gCurRoom setScript: (ScriptID 200 1) 0 self) ; enterApartment
					)
					(else
						(gCurRoom setScript: (ScriptID 202 0)) ; gregComeOut
					)
				)
			)
			(2 ; Talk
				(cond
					((gEgo has: 25) ; scroll
						(EcoNarrator init: 4 0 0 88)
					)
					((== ((Inv at: 1) owner:) 200) ; starFish
						(EcoNarrator init: 4 0 0 89)
					)
					((not (gCurRoom script:))
						(gCurRoom setScript: (ScriptID 200 8)) ; talkIntoApt
					)
					(else
						(EcoNarrator init: 4 0 0 97)
					)
				)
			)
			(44 ; Inventory
				(cond
					((IsFlag 7)
						(EcoNarrator init: 4 0 0 88)
					)
					((== ((Inv at: 1) owner:) 200) ; starFish
						(if (gCast contains: (ScriptID 200 7)) ; gregarious
							(EcoNarrator init: 4 0 0 95)
						else
							(EcoNarrator init: 4 0 0 94)
						)
					)
					(else
						(EcoNarrator init: 4 0 0 93)
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

