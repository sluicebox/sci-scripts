;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8253)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	rm8253 0
)

(instance rm8253 of ExitRoom
	(properties
		picture 8253
		south 8202 ; rm8202
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 622)
			(plaque init:)
		else
			(self setScript: readReact)
		)
	)
)

(instance plaque of GKFeature
	(properties
		noun 16
		modNum 820
		nsLeft 28
		nsTop 48
		nsRight 620
		nsBottom 304
	)

	(method (doVerb)
		(gCurRoom setScript: readReact)
	)
)

(instance readReact of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 16 62 0 0 self 820) ; "(READING DISPLAYS; LUDWIG'S DIARY DISPLAY SIGN)Ludwig's diary. Ludwig kept a diary from 1869, when he was twenty-four years old, until his death. The diary provides a fascinating look into the mind of this tormented man."
			)
			(1
				(if (IsFlag 622)
					(self cue:)
				else
					(SetFlag 622)
					(PlayScene 495 0 8202) ; rm8202
				)
			)
			(2
				(gCurRoom newRoom: 8202)
			)
		)
	)
)

