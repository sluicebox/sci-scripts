;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 973)
(include sci.sh)
(use Motion)

(class Rev of Cycle
	(properties
		cycleDir -1
	)

	(method (doit &tmp temp0)
		(if (< (= temp0 (self nextCel:)) 0)
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(client cel: (client lastCel:))
	)
)

