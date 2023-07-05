;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42201)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use Motion)
(use Actor)
(use System)

(public
	rm4220b 0
)

(instance rm4220b of TopicRoom
	(properties
		modNum 420
		picture 4222
		dialogDoneFlag 51
	)

	(method (init)
		(if (and (IsFlag 688) (IsFlag 341))
			(SetFlag 689)
		)
		(if (not checking)
			(gEgo
				setScale: 0
				view: 20073
				setLoop: 0 1
				cel: 0
				posn: 391 333
				init:
				setScript: sFidget
			)
			(pUbergrau init: setScript: sUbergrauFidget)
		)
		(super
			init:
				tLudwig1
				tLudwig2
				tBlackWolf
				tMissingPersons1
				tMissingPersons2
				tGettingCash
		)
	)
)

(instance tLudwig1 of Topic ; "Ludwig II"
	(properties
		sceneNum 246
		flagNum 241
		readyFlagNum 514
		noun 16
	)
)

(instance tLudwig2 of Topic ; "Ludwig II"
	(properties
		sceneNum 247
		flagNum 242
		readyFlagNum 241 ; "Ludwig II"
		noun 17
	)
)

(instance tBlackWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 248
		flagNum 243
		readyFlagNum 514
		noun 18
	)
)

(instance tMissingPersons1 of Topic ; "Missing Persons"
	(properties
		sceneNum 249
		flagNum 245
		readyFlagNum 218 ; "The Black Wolf" in rm3210
		noun 19
	)
)

(instance tMissingPersons2 of Topic ; "Missing Persons"
	(properties
		sceneNum 558
		flagNum 321
		noun 20
		nextRoomNum 420 ; uberRm
	)

	(method (yo param1)
		(return
			(and
				(== gChapter 5)
				(not (IsFlag flagNum))
				(or
					(and argc param1)
					(not readyFlagNum)
					(IsFlag readyFlagNum)
				)
				(or (not subList) (subList firstTrue: #yo))
			)
		)
	)
)

(instance tGettingCash of Topic ; "Getting Cash"
	(properties
		sceneNum 559
		flagNum 322
		readyFlagNum 341
		noun 21
	)
)

(instance pUbergrau of Prop
	(properties
		x 202
		y 215
		view 21073
	)
)

(instance sUbergrauFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(pUbergrau cel: 0 setCycle: End)
				(= seconds (Random 3 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 12 25))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

