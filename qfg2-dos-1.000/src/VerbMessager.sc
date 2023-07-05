;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 839)
(include sci.sh)
(use System)

(class VerbMessager of Code
	(properties
		ssLook 0
		ssOpen 0
		ssClose 0
		ssSmell 0
		ssMove 0
		ssEat 0
		ssGet 0
		ssClimb 0
		ssTalk 0
	)

	(method (doit)
		(return
			(cond
				((Said ssLook) 1)
				((Said ssOpen) 2)
				((Said ssClose) 3)
				((Said ssSmell) 4)
				((Said ssMove) 5)
				((Said ssEat) 6)
				((Said ssGet) 7)
				((Said ssClimb) 8)
				((Said ssTalk) 9)
			)
		)
	)
)

