;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8146)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm8146 0
)

(instance rm8146 of ExitRoom
	(properties
		picture 8146
		east 8143 ; rm8143
		south 8151 ; rm8151
		west 8145 ; rm8145
	)

	(method (init)
		(gGame changeScore: 995)
		(SetFlag 601)
		(super init: &rest)
		(lizLetter1 init:)
	)
)

(instance lizLetter1 of Feature
	(properties
		noun 18
		modNum 810
		nsLeft 208
		nsTop 46
		nsRight 513
		nsBottom 234
	)
)

