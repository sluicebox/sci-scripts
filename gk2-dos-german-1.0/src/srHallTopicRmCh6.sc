;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1223)
(include sci.sh)
(use Main)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Motion)
(use Actor)
(use System)

(public
	srHallTopicRmCh6 0
)

(instance srHallTopicRmCh6 of TopicRoom
	(properties
		modNum 120
		picture 1220
		dialogDoneFlag 68
	)

	(method (init)
		(if (not checking)
			(gerda init: setScript: (FidgetScript new:))
			(gEgo view: 22131 posn: 208 117 init: setScript: FidgetScript)
		)
		(super init: tSRHeart)
	)
)

(instance gerda of Prop
	(properties
		x 412
		y 229
		view 21131
	)
)

(instance sFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setLoop: (Random 0 1) setCycle: End)
				(= seconds (Random 12 20))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance gerdaFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End)
				(= seconds (Random 8 14))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance tSRHeart of Topic ; "Silver Heart"
	(properties
		sceneNum 759
		flagNum 388
		readyFlagNum 717
		noun 22
	)
)

