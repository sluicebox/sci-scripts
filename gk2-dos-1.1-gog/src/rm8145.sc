;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8145)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8145 0
)

(instance rm8145 of ExitRoom
	(properties
		picture 8145
		east 8146 ; rm8146
		south 8151 ; rm8151
	)

	(method (init)
		(super init: &rest)
		(ludToLizLetter init:)
	)
)

(instance ludToLizLetter of GKFeature
	(properties
		noun 22
		modNum 810
		nsLeft 147
		nsTop 123
		nsRight 472
		nsBottom 320
	)
)

