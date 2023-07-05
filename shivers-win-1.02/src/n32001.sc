;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32001)
(include sci.sh)
(use Main)

(public
	proc32001_0 0
	proc32001_1 1
)

(local
	[local0 12] = [23202 23204 23205 23206 23206 23205 23204 23202 23202 23204 23205 23206]
)

(procedure (proc32001_0 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ (* (Random 1 2) 2) 3))
	(= temp2 (Random 0 11))
	(gSounds adjChainVol: 74)
	(for ((= temp1 0)) (< temp1 7) ((++ temp1))
		(= temp3 (Random -3 -7))
		(gSounds playChain: -1 temp3 [local0 temp2] -1)
		(= temp2 (mod (+ temp2 temp0) 12))
	)
)

(procedure (proc32001_1)
	(gSounds fadeChain:)
)

