;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use n001)
(use Sound)
(use Motion)
(use Actor)
(use System)

(local
	savedLooper
	[loops 8] = [2 3 0 2 0 1 2 3]
)

(class SpellScript of Script
	(properties
		type 0
		soundObj 0
		spellSparkles 0
	)

	(method (dispose &tmp theLoop)
		(if soundObj
			(soundObj stop: dispose:)
		)
		(if spellSparkles
			(spellSparkles stop: dispose:)
		)
		(= soundObj (= spellSparkles 0))
		(= theLoop (gEgo loop:))
		(EgoGait -1 0)
		(gEgo loop: (+ theLoop 4) setLoop: -1)
		(gEgo looper: savedLooper)
		(ClearFlag 87) ; fCastingSpell
		(HandsOn)
		(super dispose:)
	)

	(method (changeState newState &tmp theSound node nextNode obj aMethod)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 87) ; fCastingSpell
				(= savedLooper (gEgo looper:))
				(gEgo looper: 0)
				(gEgo
					view: 31
					setLoop: [loops (gEgo loop:)]
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(if
					(= theSound
						(switch type
							(20 19)
							(23
								(gEgo setCycle: CT 3 1 self)
								13
							)
							(22 22)
							(24 21)
							(29 34)
							(else 0)
						)
					)
					((= soundObj (Sound new:))
						number: theSound
						loop: 1
						priority: 6
						init:
						play: self
					)
				else
					(self cue:)
				)
			)
			(2
				(= register 0)
				(cond
					(
						(= aMethod
							(switch type
								(20 402)
								(22 401)
								(24 400)
								(else 0)
							)
						)
						(for
							((= node (FirstNode (gCast elements:))))
							node
							((= node nextNode))
							
							(= nextNode (NextNode node))
							(= obj (NodeValue node))
							(if
								(and
									(obj respondsTo: aMethod)
									(Eval obj aMethod)
								)
								(= register 1)
							)
						)
						(= cycles 3)
					)
					((== type 29)
						((= spellSparkles (Prop new:))
							view: 31
							loop: 4
							cel: 0
							ignoreActors: 1
							posn: (gEgo x:) (gEgo y:)
							setPri: (+ (gEgo priority:) 1)
							init:
							setCycle: End self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(if spellSparkles
					(spellSparkles dispose:)
					(= spellSparkles 0)
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(switch type
					(20
						(if (not register)
							(HighPrint 64 0) ; "You detect no magic here."
						)
					)
					(23
						(= gZapPower (+ 5 (/ [gEgoStats 23] 10))) ; zapSpell
						(HighPrint 64 1) ; "Your weapon is now magically charged."
					)
					(29
						(SetFlag 86) ; fReversal
						(= gReversalTimer [gEgoStats 29]) ; invisibility
						(HighPrint 64 2) ; "You are now protected by the power of Reversal."
					)
				)
				(self dispose:)
			)
		)
	)
)

