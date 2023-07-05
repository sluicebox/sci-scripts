;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22001)
(include sci.sh)
(use Main)

(public
	proc22001_0 0
	proc22001_1 1
)

(local
	[local0 12] = [22202 22203 22204 22205 22206 22207 22207 22206 22205 22204 22203 22202]
)

(procedure (proc22001_0 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ (* (Random 1 2) 2) 3))
	(= temp2 (Random 0 11))
	(for ((= temp1 0)) (< temp1 7) ((++ temp1))
		(= temp3 (Random -3 -7))
		(gSounds playChain: -1 temp3 [local0 temp2] -1)
		(= temp2 (mod (+ temp2 temp0) 12))
	)
	(gSounds adjChainVol: 90)
)

(procedure (proc22001_1)
	(gSounds fadeChain:)
)

