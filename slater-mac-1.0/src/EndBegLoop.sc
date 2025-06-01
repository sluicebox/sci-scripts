;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 805)
(include sci.sh)
(use Main)
(use Motion)

(class EndBegLoop of CT
	(properties
		maxLoops 0
		lastView 0
		curLoop 0
		curView 1
		origView 0
	)

	(method (init param1 param2)
		(= client param1)
		(= origView (client view:))
		(= curView (client view:))
		(= maxLoops (NumLoops client))
		(-- maxLoops)
		(if (>= argc 2)
			(= lastView param2)
		else
			(= lastView (client view:))
		)
		(super init: param1 100 1 &rest)
	)

	(method (cycleDone)
		(gGame handsOn:)
		(super cycleDone:)
	)

	(method (doit &tmp temp0)
		(= temp0 (self nextCel:))
		(client cel: temp0)
		(cond
			((== cycleDir 1)
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
							(-- curLoop)
							(-- curView)
							(= cycleDir (- cycleDir))
							(client cel: (client lastCel:))
						)
					)
				)
			)
			((<= temp0 0)
				(cond
					((>= (-- curLoop) 0)
						(client setLoop: curLoop)
						(client cel: (client lastCel:))
					)
					((>= (-- curView) origView)
						(client view: curView)
						(= maxLoops (NumLoops client))
						(-- maxLoops)
						(= curLoop maxLoops)
						(client setLoop: curLoop cel: (client lastCel:))
					)
					(else
						(self cycleDone:)
					)
				)
			)
		)
	)
)

