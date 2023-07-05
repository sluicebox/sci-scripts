;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8152)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8152 0
)

(instance rm8152 of ExitRoom
	(properties
		picture 8152
		east 8141 ; rm8141
		south 8141 ; rm8141
		west 8141 ; rm8141
	)

	(method (init)
		(super init: &rest)
		(pics init:)
	)
)

(instance pics of GKFeature
	(properties
		noun 34
		modNum 810
		nsLeft 14
		nsTop 40
		nsRight 606
		nsBottom 216
	)
)

