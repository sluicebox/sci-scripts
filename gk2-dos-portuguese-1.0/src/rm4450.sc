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
		BAD_SELECTOR 56
	)

	(method (init)
		(SetFlag 548)
		(pVonZell init: setScript: FidgetScript)
		(pKlingman init: setScript: (FidgetScript new:))
		(pGabe init: setScript: sFidgetScript)
		(super init: tHowsGoing tKids tNew tMag tMagReturned)
	)

	(method (BAD_SELECTOR)
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

(instance tHowsGoing of Topic
	(properties
		BAD_SELECTOR 317
		BAD_SELECTOR 267
		noun 28
	)

	(method (BAD_SELECTOR)
		(= BAD_SELECTOR gPrevRoomNum)
		(super BAD_SELECTOR: &rest)
	)
)

(instance tKids of Topic
	(properties
		BAD_SELECTOR 318
		BAD_SELECTOR 269
		noun 29
	)

	(method (BAD_SELECTOR)
		(= BAD_SELECTOR gPrevRoomNum)
		(super BAD_SELECTOR: &rest)
	)
)

(instance tNew of Topic
	(properties
		BAD_SELECTOR 319
		BAD_SELECTOR 268
		BAD_SELECTOR 267
		noun 30
	)

	(method (BAD_SELECTOR)
		(= BAD_SELECTOR gPrevRoomNum)
		(super BAD_SELECTOR: &rest)
	)

	(method (BAD_SELECTOR)
		(return
			(and
				(not (IsFlag BAD_SELECTOR))
				(IsFlag BAD_SELECTOR)
				(not (IsFlag 271))
			)
		)
	)
)

(instance tMag of Topic
	(properties
		BAD_SELECTOR 320
		BAD_SELECTOR 270
		noun 31
	)

	(method (BAD_SELECTOR)
		(= BAD_SELECTOR gPrevRoomNum)
		(super BAD_SELECTOR: &rest)
	)
)

(instance tMagReturned of Topic
	(properties
		BAD_SELECTOR 321
		BAD_SELECTOR 271
		BAD_SELECTOR 270
		noun 32
	)

	(method (BAD_SELECTOR)
		(= BAD_SELECTOR gPrevRoomNum)
		(super BAD_SELECTOR: &rest)
	)

	(method (BAD_SELECTOR)
		(if (not (IsFlag BAD_SELECTOR))
			(gEgo has: 76) ; invMagWithRecorder
		)
	)
)

