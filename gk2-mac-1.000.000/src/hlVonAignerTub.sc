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
		dialogDoneFlag 63
	)

	(method (init)
		(if (not checking)
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
			setSubList: tHLVAContact tHLVAZell tHLVAZell2 tHLVAMoneyZell
		)
		(tHLVAGrossberg
			setSubList: tHLVAContact tHLVAZell tHLVAZell2 tHLVAMoneyZell
			setFlag: 1
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

	(method (cleanUp)
		(if (not (gCurRoom checkTopics:))
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

(instance tHLVAClub of Topic ; "The Club"
	(properties
		sceneNum 656
		flagNum 342
		noun 3
	)
)

(instance tHLVALodge of Topic ; "The Lodge", UNUSED
	(properties
		sceneNum 663
		flagNum 343
		noun 12
	)
)

(instance tHLVAGrossberg of Topic ; "Grossberg"
	(properties
		sceneNum 657
		flagNum 344
		noun 4
	)
)

(instance tHLVAGrossberg2 of Topic ; "Grossberg"
	(properties
		sceneNum -1
		flagNum 351
		readyFlagNum 344 ; "Grossberg"
		noun 4
	)
)

(instance tHLVABlackWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 664
		flagNum 345
		noun 9
	)
)

(instance tHLVAContact of Topic ; "Were you the Club's main contact with Grossberg?"
	(properties
		sceneNum 658
		flagNum 346
		noun 5
	)
)

(instance tHLVAZell of Topic ; "What does von Zell have to do with Grossberg?"
	(properties
		sceneNum 659
		flagNum 347
		noun 6
	)
)

(instance tHLVAZell2 of Topic ; "Why did von Zell want Grossberg's name?"
	(properties
		sceneNum 660
		flagNum 348
		readyFlagNum 347 ; "What does von Zell have to do with Grossberg?"
		noun 7
	)
)

(instance tHLVAMoneyZell of Topic ; "Would your cooperation have anything to do with the money you owe von Zell?"
	(properties
		sceneNum 661
		flagNum 349
		readyFlagNum 347 ; "What does von Zell have to do with Grossberg?"
		noun 8
	)
)

(instance tHLVABlackWolf2 of Topic ; "The Black Wolf"
	(properties
		sceneNum 665
		flagNum 350
		readyFlagNum 345 ; "The Black Wolf"
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

