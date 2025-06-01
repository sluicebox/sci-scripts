;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 806)
(include sci.sh)
(use Main)
(use Motion)

(class IncrementalEnd of End
	(properties
		maxLoops 0
		lastView 0
		curLoop 0
		curView 0
		origView 0
		origLoop 0
		origCel 0
	)

	(method (init param1 param2)
		(= client param1)
		(= origCel (client cel:))
		(= origView (client view:))
		(= origLoop (client loop:))
		(= curView (client view:))
		(= maxLoops (NumLoops client))
		(-- maxLoops)
		(if (>= argc 2)
			(= lastView param2)
		else
			(= lastView (client view:))
		)
		(super init: param1 param1 &rest)
	)

	(method (doit &tmp temp0)
		(= temp0 (self nextCel:))
		(client cel: temp0)
		(if (== (+ (client lastCel:) 1) temp0)
			(cond
				((<= (++ curLoop) maxLoops)
					(client setLoop: curLoop cel: 0)
				)
				((<= (++ curView) lastView)
					(= curLoop 0)
					(client view: curView setLoop: 0 cel: 0)
					(= maxLoops (NumLoops client))
					(-- maxLoops)
				)
				(else
					(client cel: (client lastCel:))
					(self cycleDone:)
				)
			)
		)
	)

	(method (cycleDone)
		(gGame handsOn:)
		(client view: origView loop: origLoop cel: origCel)
		(super cycleDone:)
	)
)

