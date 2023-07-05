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
		dialogDoneFlag 67
	)

	(method (init)
		(if (not checking)
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

(instance tHimself1 of Topic ; "Himself"
	(properties
		sceneNum 524
		flagNum 294
		noun 7
	)
)

(instance tHimself2 of Topic ; "Himself"
	(properties
		sceneNum 525
		flagNum 295
		readyFlagNum 294 ; "Himself"
		noun 8
	)
)

(instance tWagner of Topic ; "Wagner"
	(properties
		sceneNum 526
		flagNum 296
		noun 9
	)
)

(instance tLtr2Ludwig of Topic ; "Wagner's letter to Ludwig"
	(properties
		sceneNum 528
		flagNum 297
		readyFlagNum 611
		noun 10
	)
)

(instance tLtr2Conductor of Topic ; "Ludwig's letter to Conductor"
	(properties
		sceneNum 529
		flagNum 298
		readyFlagNum 623
		noun 11
	)
)

(instance tWolfPanels of Topic ; "Wolf Panels at Neuschwanstein"
	(properties
		sceneNum 532
		flagNum 299
		readyFlagNum 625
		noun 12
	)

	(method (yo)
		(if (IsFlag 298) ; "Ludwig's letter to Conductor"
			(return (super yo: &rest))
		else
			(return 0)
		)
	)
)

(instance tLostOpera of Topic ; "Lost Opera"
	(properties
		sceneNum 533
		flagNum 300
		readyFlagNum 299 ; "Wolf Panels at Neuschwanstein"
		noun 13
	)
)

