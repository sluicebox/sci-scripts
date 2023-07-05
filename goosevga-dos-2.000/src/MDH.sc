;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 979)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(instance COn of Code
	(properties)

	(method (doit who)
		(proc255_5 who &rest)
	)
)

(instance MTM of Motion
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (client isStopped:)
			(self moveDone:)
		)
	)
)

(class MDH of EventHandler
	(properties
		x 0
		y 0
		modifiers 0
		targetObj 0
		shiftParser 0
	)

	(method (cue &tmp event)
		((= event (Event new:)) type: evMOUSEBUTTON x: x y: y modifiers: modifiers)
		(targetObj handleEvent: event)
		(= targetObj 0)
		(event dispose:)
	)

	(method (handleEvent event &tmp thisEgo thisMover node)
		(= thisEgo (gUser alterEgo:))
		(= thisMover (thisEgo mover:))
		(= x (event x:))
		(= y (event y:))
		(= modifiers (event modifiers:))
		(if (& modifiers $000c) ; emALT | emCTRL
			(super handleEvent: event)
		else
			(for
				((= node (FirstNode elements)))
				(and node (= targetObj (NodeValue node)))
				((= node (NextNode node)))
				
				(if
					(= targetObj
						(cond
							((targetObj isKindOf: Collect)
								(targetObj firstTrue: #perform COn event)
							)
							((proc255_5 targetObj event) targetObj)
						)
					)
					(if (& modifiers emSHIFT)
						(event type: evSAID)
						(shiftParser doit: targetObj event)
						(targetObj handleEvent: event)
						(event type: evMOUSEBUTTON)
						(event claimed:)
						(return)
					)
					(if
						(and
							(gUser controls:)
							(IsObject thisEgo)
							(gCast contains: thisEgo)
						)
						(thisEgo
							setMotion: MTM (targetObj x:) (targetObj y:) self
						)
						(gUser prevDir: 0)
						(event claimed: 1)
						(break)
					)
					(super handleEvent: event)
					(break)
				)
			)
			(if (== targetObj 0)
				(super handleEvent: event)
			)
		)
	)
)

