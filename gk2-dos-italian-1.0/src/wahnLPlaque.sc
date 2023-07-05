;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8647)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	wahnLPlaque 0
)

(instance wahnLPlaque of ExitRoom
	(properties
		picture 8647
		south 8645 ; wahn8645
	)

	(method (init)
		(super init: &rest)
		(lPlaque init:)
		(SetFlag 611)
		(gGame changeScore: 1021)
	)
)

(instance lookAtPlaque of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 14 62 0 0 self 860) ; "(READING DISPLAYS, LETTER FROM WAGNER TO LUDWIG)July, 1882. Great and beloved King. Monsieur Beaujolais and I have finished the diagram. We checked the figures many times and M. is confident that it will work. Eight identical fixtures are to be made from the diagram and placed in the theater EXACTLY as specified. I'm sending the diagram with your courier."
			)
			(1
				(if (not (IsFlag 611))
					(IsFlag 611)
					(PlayScene 536 self)
				else
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance lPlaque of GKFeature
	(properties
		nsLeft 20
		nsTop 12
		nsRight 620
		nsBottom 324
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom setScript: lookAtPlaque)
		else
			(super doVerb: theVerb)
		)
	)
)

