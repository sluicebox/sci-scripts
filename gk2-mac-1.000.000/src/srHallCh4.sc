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
		initScene 417
		dialogDoneFlag 64
	)

	(method (init)
		(if (not checking)
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

(instance tSR4Gabe of Topic ; "Gabriel"
	(properties
		sceneNum 418
		flagNum 301
		noun 19
	)
)

(instance tSR4Permit of Topic ; "Special Permit"
	(properties
		sceneNum 419
		flagNum 302
		readyFlagNum 577
		noun 20
	)
)

