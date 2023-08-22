;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use n013)
(use StopWalk)
(use Grooper)
(use Ego)
(use System)

(public
	GKEgo 0
	gStopGroop 1
)

(local
	local0 = -1
)

(class GKEgo of Ego
	(properties
		noun 1
		modNum 18
		talking 0
		oldView 0
		oldLoop 0
		oldCel 0
		oldSig 0
	)

	(method (handleEvent event)
		(if (& (event type:) $0010) ; direction
			(return 0)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (setScale)
		(= scaleX (= scaleY (= maxScale 128)))
		(super setScale: &rest)
	)

	(method (put param1 &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 0)
		(if
			(and
				(== param1 (gInventory indexOf: (gTheIconBar curInvIcon:)))
				(gGame barUp:)
			)
			(= temp0 1)
		)
		(if (== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
			(= temp1 1)
		)
		(super put: param1 &rest)
		(if (and (not (gTheIconBar curInvIcon:)) temp1)
			(gTheIconBar curIcon: (gTheIconBar walkIconItem:))
			(if (gGame isHandsOn:)
				(gGame setCursor: (gTheIconBar getCursor:))
			)
		)
		(if temp0
			((ScriptID 12 1) hide:) ; curInvView
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Talk
				(switch (Random 0 5)
					(0
						(gMessager say: 1 11 1 1 0 18) ; "(THESE ARE TO PLAYER)Man, I'm beat. This sleep thing is getting to be a real problem."
					)
					(1
						(gMessager say: 1 11 2 1 0 18) ; "Can somebody tell me what's going on?"
					)
					(2
						(gMessager say: 1 11 3 1 0 18) ; "Don't ask me. I'm even less informed than you."
					)
					(3
						(gMessager say: 1 11 4 1 0 18) ; "Ever have one of those days?"
					)
					(4
						(gMessager say: 1 11 5 1 0 18) ; "Could you just shoot me?"
					)
					(5
						(gMessager say: 1 11 6 1 0 18) ; "Knight. Gabriel Knight. In case someone wants to know."
					)
				)
				(return 1)
			)
			(129 ; lit_flash
				(gMessager say: 1 129 7 1 0 18) ; "There's enough light without the flashlight at the moment."
				(return 1)
			)
			(else
				(if (Message msgGET modNum noun theVerb 0 1)
					(gMessager say: noun theVerb 0 0 0 18)
				else
					(gMessager say: noun 0 0 0 0 18) ; "(THESE NEXT LINES ARE TRIGGERED WHEN PLAYER CLICKS ITEMS ON GABRIEL)I've already got it."
				)
				(return 1)
			)
		)
	)

	(method (getPoints param1 param2 param3)
		(if (and (!= param1 -999) (IsFlag param1))
			(return 0)
		)
		(if (!= param1 -999)
			(SetFlag param1)
		)
		(+= gScore param2)
		(if (and (gGame barUp:) (not (OneOf gCurRoomNum 50))) ; interrogation
			(gTheIconBar updateScore:)
		)
		(return (and (or (<= argc 2) param3) (gGkSound3 number: 10 play:)))
	)

	(method (normalize param1 param2)
		(if (> argc 0)
			(gEgo loop: param1)
		)
		(gEgo
			view: (if (> argc 1) param2 else 900)
			edgeHit: EDGE_NONE
			signal: 4129
			z: 0
			setLoop: -1
			setLooper: gGStopGroop
			setPri: -1
			setMotion: 0
			illegalBits: 0
			ignoreActors: 0
			setStep: 3 2
			setCycle: StopWalk -1
			setSpeed: (gGame currentSpeed:)
		)
	)

	(method (doit)
		(super doit:)
		(= edgeHit
			(cond
				((<= x 0) 4)
				((>= x 319) 2)
				((>= y 141) 3)
				((<= y (gCurRoom horizon:)) 1)
				(else 0)
			)
		)
	)
)

(instance gStopGroop of Grooper
	(properties)

	(method (cue &tmp temp0)
		(if
			(and
				(== client gEgo)
				(not (gEgo scaleSignal:))
				(!= (= temp0 (gEgo loop:)) local0)
			)
			(cond
				((< temp0 2)
					(= local0 temp0)
					(gEgo setStep: 4 2)
				)
				((< temp0 4)
					(= local0 temp0)
					(gEgo setStep: 3 1)
				)
				((< temp0 6)
					(= local0 temp0)
					(gEgo setStep: 3 3)
				)
				(else
					(= local0 temp0)
					(gEgo setStep: 3 2)
				)
			)
		)
		(super cue:)
	)
)

