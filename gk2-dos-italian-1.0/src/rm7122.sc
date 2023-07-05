;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7122)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)
(use System)

(public
	rm7122 0
)

(instance rm7122 of ExitRoom
	(properties
		picture 7122
		east 710 ; courtRm
		south 710 ; courtRm
		west 710 ; courtRm
	)

	(method (init)
		(if (IsFlag 402)
			(officeWindowFeat init:)
		else
			(officeWindow init:)
		)
		(super init: &rest)
	)
)

(instance officeWindowFeat of Feature
	(properties
		nsLeft 370
		nsRight 522
		nsBottom 261
		sightAngle 40
		approachX 442
		approachY 271
		x 446
		y 129
	)
)

(instance officeWindow of View
	(properties
		x 372
		y 261
		priority 15
		fixPriority 1
		view 30189
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(switch gChapter
				(2
					(if
						(or
							(not (proc11_15 7121))
							(gEgo has: 28) ; invMayorNote
							(IsFlag 150)
						)
						(gMessager say: 1 62 0 1 0 710) ; "(CLICK ON MAYOR HABERMAS'S WINDOW--ALL DIALOGUE DONE)I don't have anything to say right now."
					else
						(gCurRoom newRoom: 7121) ; rm711c2d2
					)
				)
				(4
					(PlayScene 459)
				)
				(else
					(gCurRoom setScript: notHere6)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance notHere6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 62 0 0 self 710) ; "(PICKUP, CLICK ON MAYOR HABERMAS'S WINDOW--CH 6, ANXIOUS)Mayor Habermas probably has his hands full today."
			)
			(1
				(gCurRoom newRoom: 710) ; courtRm
			)
		)
	)
)

