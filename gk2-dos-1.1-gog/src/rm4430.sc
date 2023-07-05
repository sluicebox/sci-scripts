;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4430)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	rm4430 0
)

(instance rm4430 of TopicRoom ; "Hunt Club: Main Hall"
	(properties
		modNum 440
		noun 6
		picture 4454
		dialogDoneFlag 55
	)

	(method (init)
		(pVonAigner init: setScript: FidgetScript)
		(pHennemann init: setScript: (FidgetScript new:))
		(pGabriel init: setScript: (FidgetScript new:))
		(super init: tVonAigner tHennemann tWolfKilling tWhat)
	)

	(method (cleanUp)
		(PlayScene 309)
	)
)

(instance pVonAigner of Prop
	(properties
		x 239
		y 120
		view 22307
	)
)

(instance pHennemann of Prop
	(properties
		x 462
		y 111
		view 23307
	)
)

(instance pGabriel of Prop
	(properties
		x 138
		y 97
		priority 150
		fixPriority 1
		view 21307
	)
)

(instance tVonAigner of Topic ; "I haven't had a chance to speak with you yet, Herr von Aigner."
	(properties
		sceneNum 310
		flagNum 263
		noun 24
	)
)

(instance tHennemann of Topic ; "I haven't had a chance to speak with you yet, Herr Hennemann."
	(properties
		sceneNum 311
		flagNum 264
		noun 25
	)
)

(instance tWolfKilling of Topic ; "Have you guys heard about the wolf killing last night?"
	(properties
		sceneNum 312
		flagNum 265
		noun 26
	)
)

(instance tWhat of Topic ; "What were y'all talking about a minute ago?"
	(properties
		sceneNum 313
		flagNum 266
		noun 27
	)

	(method (addMe)
		(= nextRoomNum gPrevRoomNum)
		(super addMe: &rest)
	)
)

