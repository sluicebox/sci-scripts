;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 958)
(include sci.sh)

(public
	LoadMany 0
)

(procedure (LoadMany what which &tmp i theRes)
	(-= argc 2)
	(for ((= i 0)) (<= i argc) ((++ i))
		(= theRes [which i])
		(if what
			(Load what theRes)
		else
			(DisposeScript theRes)
		)
	)
	(DisposeScript 958)
)

