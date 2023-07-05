;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5631)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use Motion)
(use Actor)
(use System)

(public
	hlVonAignerTub 0
)

(instance hlVonAignerTub of TopicRoom
	(properties
		modNum 545
		picture 5621
		BAD_SELECTOR 63
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(gEgo
				setScale: 0
				view: 22652
				setLoop: 0 1
				posn: 380 120
				cel: 0
				init:
				setScript: sFidget
			)
			(pVonAigner init: setScript: sVonAignerFidget)
		)
		(tHLVAGrossberg2
			BAD_SELECTOR: tHLVAContact tHLVAZell tHLVAZell2 tHLVAMoneyZell
		)
		(tHLVAGrossberg
			BAD_SELECTOR: tHLVAContact tHLVAZell tHLVAZell2 tHLVAMoneyZell
			BAD_SELECTOR: 1
		)
		(super
			init:
				tHLVAClub
				tHLVAGrossberg
				tHLVAGrossberg2
				tHLVABlackWolf
				tHLVABlackWolf2
		)
	)

	(method (BAD_SELECTOR)
		(if (not (gCurRoom BAD_SELECTOR:))
			(gCurRoom north: 530)
			(SetFlag 656)
			(PlayScene 655)
		)
	)
)

(instance pVonAigner of Prop
	(properties
		x 184
		y 114
		view 21652
	)
)

(instance tHLVAClub of Topic
	(properties
		BAD_SELECTOR 656
		BAD_SELECTOR 342
		noun 3
	)
)

(instance tHLVALodge of Topic ; UNUSED
	(properties
		BAD_SELECTOR 663
		BAD_SELECTOR 343
		noun 12
	)
)

(instance tHLVAGrossberg of Topic
	(properties
		BAD_SELECTOR 657
		BAD_SELECTOR 344
		noun 4
	)
)

(instance tHLVAGrossberg2 of Topic
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 351
		BAD_SELECTOR 344
		noun 4
	)
)

(instance tHLVABlackWolf of Topic
	(properties
		BAD_SELECTOR 664
		BAD_SELECTOR 345
		noun 9
	)
)

(instance tHLVAContact of Topic
	(properties
		BAD_SELECTOR 658
		BAD_SELECTOR 346
		noun 5
	)
)

(instance tHLVAZell of Topic
	(properties
		BAD_SELECTOR 659
		BAD_SELECTOR 347
		noun 6
	)
)

(instance tHLVAZell2 of Topic
	(properties
		BAD_SELECTOR 660
		BAD_SELECTOR 348
		BAD_SELECTOR 347
		noun 7
	)
)

(instance tHLVAMoneyZell of Topic
	(properties
		BAD_SELECTOR 661
		BAD_SELECTOR 349
		BAD_SELECTOR 347
		noun 8
	)
)

(instance tHLVABlackWolf2 of Topic
	(properties
		BAD_SELECTOR 665
		BAD_SELECTOR 350
		BAD_SELECTOR 345
		noun 10
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 8 16))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sVonAignerFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(pVonAigner cel: 0 setCycle: End)
				(= seconds (Random 2 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

