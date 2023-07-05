;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7804)
(include sci.sh)
(use Main)
(use Location)

(public
	octoTeaGateCU 0
)

(instance octoTeaGateCU of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 7811)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
	)
)

