;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4450)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Motion)
(use Actor)
(use System)

(public
	rm4450 0
)

(instance rm4450 of TopicRoom ; "Hunt Club: Main Hall"
	(properties
		modNum 440
		noun 6
		picture 4420
		dialogDoneFlag 56
	)

	(method (init)
		(SetFlag 548)
		(pVonZell init: setScript: FidgetScript)
		(pKlingman init: setScript: (FidgetScript new:))
		(pGabe init: setScript: sFidgetScript)
		(super init: tHowsGoing tKids tNew tMag tMagReturned)
	)

	(method (cleanUp)
		(PlayScene 316)
	)
)

(instance sFidgetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 60))
			)
			(1
				(client cel: 0 setLoop: 0 setCycle: End self)
			)
			(2
				(client cel: 0 show:)
				(self changeState: 0)
			)
		)
	)
)

(instance pVonZell of Prop
	(properties
		x 125
		y 195
		view 22315
	)
)

(instance pKlingman of Prop
	(properties
		x 459
		y 182
		view 23315
	)
)

(instance pGabe of Prop
	(properties
		x 293
		y 70
		priority 200
		fixPriority 1
		view 21315
	)
)

(instance tHowsGoing of Topic ; "Hey, how's it going?"
	(properties
		sceneNum 317
		flagNum 267
		noun 28
	)

	(method (addMe)
		(= nextRoomNum gPrevRoomNum)
		(super addMe: &rest)
	)
)

(instance tKids of Topic ; "What're you two kids talking about?"
	(properties
		sceneNum 318
		flagNum 269
		noun 29
	)

	(method (addMe)
		(= nextRoomNum gPrevRoomNum)
		(super addMe: &rest)
	)
)

(instance tNew of Topic ; "What's new?"
	(properties
		sceneNum 319
		flagNum 268
		readyFlagNum 267 ; "Hey, how's it going?"
		noun 30
	)

	(method (addMe)
		(= nextRoomNum gPrevRoomNum)
		(super addMe: &rest)
	)

	(method (yo)
		(return
			(and
				(not (IsFlag flagNum))
				(IsFlag readyFlagNum)
				(not (IsFlag 271)) ; "Just wanted to put back this magazine."
			)
		)
	)
)

(instance tMag of Topic ; "Just wanted to grab a magazine."
	(properties
		sceneNum 320
		flagNum 270
		noun 31
	)

	(method (addMe)
		(= nextRoomNum gPrevRoomNum)
		(super addMe: &rest)
	)
)

(instance tMagReturned of Topic ; "Just wanted to put back this magazine."
	(properties
		sceneNum 321
		flagNum 271
		readyFlagNum 270 ; "Just wanted to grab a magazine."
		noun 32
	)

	(method (addMe)
		(= nextRoomNum gPrevRoomNum)
		(super addMe: &rest)
	)

	(method (yo)
		(if (not (IsFlag flagNum))
			(gEgo has: 76) ; invMagWithRecorder
		)
	)
)

