;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8520)
(include sci.sh)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	topic850 0
)

(instance topic850 of TopicRoom
	(properties
		modNum 850
		picture 8520
		BAD_SELECTOR 67
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(deskDude init: setScript: FidgetScript)
			(grace init: setScript: (FidgetScript new:))
		)
		(super
			init:
				tHimself1
				tHimself2
				tWagner
				tLtr2Ludwig
				tLtr2Conductor
				tWolfPanels
				tLostOpera
		)
	)
)

(instance deskDude of Prop
	(properties
		x 90
		y 334
		view 21520
	)
)

(instance grace of Prop
	(properties
		x 455
		y 108
		view 21519
	)
)

(instance tHimself1 of Topic
	(properties
		BAD_SELECTOR 524
		BAD_SELECTOR 294
		noun 7
	)
)

(instance tHimself2 of Topic
	(properties
		BAD_SELECTOR 525
		BAD_SELECTOR 295
		BAD_SELECTOR 294
		noun 8
	)
)

(instance tWagner of Topic
	(properties
		BAD_SELECTOR 526
		BAD_SELECTOR 296
		noun 9
	)
)

(instance tLtr2Ludwig of Topic
	(properties
		BAD_SELECTOR 528
		BAD_SELECTOR 297
		BAD_SELECTOR 611
		noun 10
	)
)

(instance tLtr2Conductor of Topic
	(properties
		BAD_SELECTOR 529
		BAD_SELECTOR 298
		BAD_SELECTOR 623
		noun 11
	)
)

(instance tWolfPanels of Topic
	(properties
		BAD_SELECTOR 532
		BAD_SELECTOR 299
		BAD_SELECTOR 625
		noun 12
	)

	(method (BAD_SELECTOR)
		(if (IsFlag 298)
			(return (super BAD_SELECTOR: &rest))
		else
			(return 0)
		)
	)
)

(instance tLostOpera of Topic
	(properties
		BAD_SELECTOR 533
		BAD_SELECTOR 300
		BAD_SELECTOR 299
		noun 13
	)
)

