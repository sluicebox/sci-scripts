;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2001)
(include sci.sh)
(use Main)

(public
	proc2001_0 0
	proc2001_1 1
)

(local
	[local0 12] = [20206 20207 20208 20209 20207 20208 20209 20206 20208 20209 20206 20207]
)

(procedure (proc2001_0 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ (* (Random 1 2) 2) 3))
	(= temp2 (Random 0 11))
	(for ((= temp1 0)) (< temp1 7) ((++ temp1))
		(= temp3 (Random -3 -7))
		(gSounds playChain: -1 temp3 [local0 temp2] -1)
		(= temp2 (mod (+ temp2 temp0) 12))
	)
	(gSounds adjChainVol: 127)
)

(procedure (proc2001_1)
	(gSounds fadeChain:)
)

