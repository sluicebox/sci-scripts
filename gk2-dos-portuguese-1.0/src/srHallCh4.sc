;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1222)
(include sci.sh)
(use Main)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	srHallCh4 0
)

(instance srHallCh4 of TopicRoom
	(properties
		modNum 120
		picture 1220
		BAD_SELECTOR 417
		BAD_SELECTOR 64
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(gerda init: setScript: (FidgetScript new:))
			(gEgo view: 22131 posn: 208 117 init: setScript: FidgetScript)
		)
		(super init: tSR4Gabe tSR4Permit)
	)
)

(instance gerda of Prop
	(properties
		x 412
		y 229
		view 21131
	)
)

(instance tSR4Gabe of Topic
	(properties
		BAD_SELECTOR 418
		BAD_SELECTOR 301
		noun 19
	)
)

(instance tSR4Permit of Topic
	(properties
		BAD_SELECTOR 419
		BAD_SELECTOR 302
		BAD_SELECTOR 577
		noun 20
	)
)

