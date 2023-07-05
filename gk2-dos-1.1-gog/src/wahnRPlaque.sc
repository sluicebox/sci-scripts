;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8646)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	wahnRPlaque 0
)

(instance wahnRPlaque of ExitRoom
	(properties
		picture 8646
		south 8645 ; wahn8645
	)

	(method (init)
		(super init: &rest)
		(rPlaque init:)
		(gGame changeScore: 1020)
	)
)

(instance rPlaque of GKFeature
	(properties
		modNum 860
		nsLeft 20
		nsTop 12
		nsRight 620
		nsBottom 324
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 596)
			(gCurRoom setScript: plaqueScript)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance plaqueScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 62 0 0 self 860) ; "(READING DISPLAYS, LETTER FROM LUDWIG TO WAGNER)June 10, 1881. Munich Residence. Great Friend. I am writing to you in the middle of the night. My blood is pounding too wildly for sleep. Tonight's performance!! How can I describe it? I am unsure whether to be terrified or thrilled. Perhaps I even feel ... hopeful??? If it IS hope, you have given it to me, my Friend, for the first time in years."
			)
			(1
				(gGame changeScore: 1020)
				(self dispose:)
			)
		)
	)
)

