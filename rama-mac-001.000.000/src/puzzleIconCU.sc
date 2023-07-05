;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5419)
(include sci.sh)
(use Location)
(use Sound)

(public
	puzzleIconCU 0
)

(instance puzzleIconCU of CloseupLocation
	(properties
		noun 22
	)

	(method (init)
		(swoosh play:)
		(= picture ((ScriptID 201 0) subPuzCU:)) ; newYorkRegion
		(super init: picture)
		(self edgeE: 0)
		(self edgeW: 0)
	)
)

(instance swoosh of Sound
	(properties
		flags 5
		number 5401
	)
)

