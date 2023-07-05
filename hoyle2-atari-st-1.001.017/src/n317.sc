;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 317)
(include sci.sh)
(use Main)

(public
	proc317_0 0
)

(procedure (proc317_0 &tmp temp0 temp1)
	(if (== global684 -1)
		(= global684
			(if (<= global337 400)
				(Random 0 51)
			else
				51
			)
		)
	)
	(= temp1 ((gTheStock at: global684) suit:))
	(gTheFoundations eachElementDo: #startingRank ((gTheStock at: global684) rank:))
	(gTheFoundations eachElementDo: #preRemoveRank ((gTheStock at: global684) rank:))
	((gTheFoundations at: temp1) preRemoveRank: 0)
	(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
		(if (!= temp0 temp1)
			((gTheFoundations at: temp0) preRemoveSuit: temp0)
		)
	)
)

