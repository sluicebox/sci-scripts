;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Sound)

(public
	proc112_0 0
)

(procedure (proc112_0 param1 param2 &tmp temp0 temp1)
	(if (not argc)
		(return)
	)
	(= temp1 (if (> argc 1) param2 else 127))
	(genSquawkSnd number: (+ 6300 param1) play: temp1 0)
)

(instance genSquawkSnd of Sound
	(properties
		flags 5
	)
)

