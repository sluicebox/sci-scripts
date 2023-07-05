;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 824)
(include sci.sh)
(use Main)

(public
	proc824_0 0
)

(procedure (proc824_0 &tmp temp0 temp1)
	(for
		((= temp0 (FirstNode (gAddToPics elements:))))
		(and temp0 (IsObject (= temp1 (NodeValue temp0))))
		((= temp0 (NextNode temp0)))
		
		(gFeatures add: temp1)
	)
	(DisposeScript 824)
)

