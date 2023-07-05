;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7426)
(include sci.sh)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	smithTopicCh6 0
)

(instance smithTopicCh6 of TopicRoom
	(properties
		modNum 740
		picture 7413
		BAD_SELECTOR 765
		BAD_SELECTOR 66
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(rolls init:)
			(mrsSmith init: setScript: FidgetScript)
			(grace init: setScript: (FidgetScript new:))
		)
		(super init: tGabe tPlan tAltotting tVGLetter)
	)

	(method (BAD_SELECTOR)
		(PlayScene 766)
	)
)

(instance rolls of View
	(properties
		x 265
		y 268
		view 31764
	)
)

(instance mrsSmith of Prop
	(properties
		x 176
		y 176
		view 21763
		cycleSpeed 8
	)
)

(instance grace of Prop
	(properties
		x 464
		y 173
		view 22763
		cycleSpeed 8
	)
)

(instance tGabe of Topic
	(properties
		BAD_SELECTOR 767
		BAD_SELECTOR 384
		noun 41
	)
)

(instance tPlan of Topic
	(properties
		BAD_SELECTOR 769
		BAD_SELECTOR 385
		noun 42
	)
)

(instance tAltotting of Topic
	(properties
		BAD_SELECTOR 770
		BAD_SELECTOR 386
		noun 43
	)
)

(instance tVGLetter of Topic
	(properties
		BAD_SELECTOR 771
		BAD_SELECTOR 387
		BAD_SELECTOR 705
		noun 44
	)
)

