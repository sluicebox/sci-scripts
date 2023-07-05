;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8144)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use System)

(public
	rm8144 0
)

(instance rm8144 of ExitRoom
	(properties
		picture 8144
		south 8151 ; rm8151
		west 8143 ; rm8143
	)

	(method (init)
		(super init: &rest)
		(letter2Bishop init:)
	)
)

(instance letter2Bishop of GKFeature
	(properties
		nsLeft 208
		nsTop 46
		nsRight 513
		nsBottom 234
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom setScript: readLetter)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance readLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 24 62 0 0 self 810) ; "(READING DISPLAYS; ELIZABETH'S LETTER TO BISHOP, CURIOUS AT END)In this letter, dated Nov., 1886, Elizabeth of Austria thanks Bishop Frank for his assistance in helping her fulfill Ludwig's last wishes. She writes that she knows it was an unusual request, but she believes Ludwig had reasons of his own for wishing it to be done. She hopes that his spirit finds peace at last."
			)
			(1
				(if (not (IsFlag 638))
					(SetFlag 638)
					(SetFlag 578)
					(PlayScene 497 0 8151) ; rm8151
				else
					(self dispose:)
				)
			)
		)
	)
)

