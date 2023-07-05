;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8143)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm8143 0
)

(instance rm8143 of ExitRoom
	(properties
		picture 8143
		east 8144 ; rm8144
		south 8151 ; rm8151
		west 8146 ; rm8146
	)

	(method (init)
		(gGame changeScore: 996)
		(super init: &rest)
		(SetFlag 602)
		(lizLetter2 init:)
	)
)

(instance lizLetter2 of Feature
	(properties
		noun 19
		modNum 810
		nsLeft 208
		nsTop 46
		nsRight 513
		nsBottom 234
	)
)

