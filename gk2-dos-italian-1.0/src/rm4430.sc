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
		BAD_SELECTOR 55
	)

	(method (init)
		(pVonAigner init: setScript: FidgetScript)
		(pHennemann init: setScript: (FidgetScript new:))
		(pGabriel init: setScript: (FidgetScript new:))
		(super init: tVonAigner tHennemann tWolfKilling tWhat)
	)

	(method (BAD_SELECTOR)
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

(instance tVonAigner of Topic
	(properties
		BAD_SELECTOR 310
		BAD_SELECTOR 263
		noun 24
	)
)

(instance tHennemann of Topic
	(properties
		BAD_SELECTOR 311
		BAD_SELECTOR 264
		noun 25
	)
)

(instance tWolfKilling of Topic
	(properties
		BAD_SELECTOR 312
		BAD_SELECTOR 265
		noun 26
	)
)

(instance tWhat of Topic
	(properties
		BAD_SELECTOR 313
		BAD_SELECTOR 266
		noun 27
	)

	(method (BAD_SELECTOR)
		(= BAD_SELECTOR gPrevRoomNum)
		(super sel_833: &rest)
	)
)

