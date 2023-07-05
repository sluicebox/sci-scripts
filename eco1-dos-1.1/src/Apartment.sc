;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 815)
(include sci.sh)
(use Main)
(use n819)
(use Talker)
(use PolyPath)
(use Feature)
(use Motion)
(use Inventory)
(use User)

(class Apartment of Feature
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
		(self approachVerbs: 3 2 5) ; Do, Look, Talk
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
			(CueObj state: 0 cycles: 0 client: self theVerb: 3 theInvItem: 0)
			(gEgo
				setMotion: PolyPath approachX (+ (gEgo z:) approachY) CueObj
			)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if IamHome
					(Narrator init: 4 0 0 9)
				else
					(Narrator init: 4 0 0 10)
				)
			)
			(3 ; Do
				(cond
					((gEgo has: 33) ; scroll
						(Narrator init: 4 0 0 88)
					)
					(
						(and
							(gCast contains: (ScriptID 200 7)) ; gregarious
							(!= ((Inv at: 20) owner:) 200) ; starFish
						)
						(Narrator init: 4 0 0 95)
					)
					((== ((Inv at: 20) owner:) 200) ; starFish
						(gEgo setPri: egoPri)
						(= global229 BelongsTo)
						(gCurRoom setScript: (ScriptID 200 1) 0 self) ; enterApartment
					)
					(else
						(gCurRoom setScript: (ScriptID 202 0)) ; gregComeOut
					)
				)
			)
			(5 ; Talk
				(cond
					((gEgo has: 33) ; scroll
						(Narrator init: 4 0 0 88)
					)
					((== ((Inv at: 20) owner:) 200) ; starFish
						(Narrator init: 4 0 0 89)
					)
					((not (gCurRoom script:))
						(gCurRoom setScript: (ScriptID 200 8)) ; talkIntoApt
					)
					(else
						(Narrator init: 4 0 0 97)
					)
				)
			)
			(4 ; Inventory
				(cond
					((IsFlag 7)
						(Narrator init: 4 0 0 88)
					)
					((== ((Inv at: 20) owner:) 200) ; starFish
						(if (gCast contains: (ScriptID 200 7)) ; gregarious
							(Narrator init: 4 0 0 95)
						else
							(Narrator init: 4 0 0 94)
						)
					)
					(else
						(Narrator init: 4 0 0 93)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

