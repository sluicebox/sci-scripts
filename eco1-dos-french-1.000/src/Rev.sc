;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 969)
(include sci.sh)
(use Motion)

(class Rev of Cycle
	(properties
		cycleDir -1
	)

	(method (doit &tmp newCel)
		(if (< (= newCel (self nextCel:)) 0)
			(self cycleDone:)
		else
			(client cel: newCel)
		)
	)

	(method (cycleDone)
		(client cel: (client lastCel:))
	)
)

