;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31001)
(include sci.sh)
(use Main)

(public
	proc31001_0 0
	proc31001_1 1
)

(local
	[local0 10] = [23102 23103 23107 23105 23106 23106 23105 23107 23103 23102]
)

(procedure (proc31001_0 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ (* (Random 0 1) 4) 3))
	(= temp2 (Random 0 9))
	(gSounds adjChainVol: 90)
	(for ((= temp1 0)) (< temp1 7) ((++ temp1))
		(= temp3 (Random -2 -7))
		(gSounds playChain: -1 temp3 [local0 temp2] -1)
		(= temp2 (mod (+ temp2 temp0) 10))
	)
)

(procedure (proc31001_1)
	(gSounds fadeChain:)
)

