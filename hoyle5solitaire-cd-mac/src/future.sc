;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use System)

(public
	future 0
)

(local
	local0
	local1
	[local2 2]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(futureWindow init:)
	(localproc_1 300)
	(futureWindow dispose:)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= temp0 (+ (GetTime) param1))
	(while (> temp0 (GetTime))
	)
)

(instance future of Code
	(properties)

	(method (init)
		(= local1 916)
		(localproc_0)
	)
)

(instance futureWindow of InvisibleWindow
	(properties)

	(method (init)
		(= top (/ (- gScreenHeight 134) 2))
		(= left (/ (- gScreenWidth 189) 2))
		(= bottom (+ (/ (- gScreenHeight 134) 2) 134))
		(= right (+ (/ (- gScreenWidth 189) 2) 189))
		(= priority 16)
		(= inTop top)
		(= inLeft left)
		(= inBottom bottom)
		(= inRight right)
		(super init:)
		(proc0_10 local1 0 0 0 0 0 self)
	)
)

