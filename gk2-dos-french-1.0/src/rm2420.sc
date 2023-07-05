;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2420)
(include sci.sh)
(use Main)
(use TopicRoom)
(use TopicPrint)
(use Cursor)
(use Motion)
(use Actor)
(use System)

(public
	rm2420 0
)

(instance rm2420 of TopicRoom
	(properties
		modNum 240
		picture 2422
		south 240 ; zooOfficeRm
		dialogDoneFlag 41
	)

	(method (init)
		(if (not checking)
			(gEgo
				setScale: 0
				view: 23043
				setLoop: 0 1
				cel: 0
				posn: 383 333
				init:
				setScript: sFidget
			)
			(vLeftBorder init:)
			(vRightBorder init:)
			(klingmann init: setScript: sKlingmannFidget)
		)
		(tMissingWolves1
			setSubList: stHowLong stResponsible stWhyHumans stHowChoose
			setFlag: 1
		)
		(tMissingWolves2
			setSubList: stHowLong stResponsible stWhyHumans stHowChoose
		)
		(super
			init:
				tKlingmann1
				tKlingmann2
				tResearch
				tWolves
				tMissingWolves1
				tMissingWolves2
		)
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

(instance sKlingmannFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(klingmann cel: 0 setCycle: End)
				(= seconds (Random 2 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance klingmann of Prop
	(properties
		x 3
		y 332
		view 24043
	)
)

(instance vLeftBorder of View
	(properties
		x -2
		y 343
		view 14
	)

	(method (init)
		(super init: &rest)
		(GKHotCursor delete: self)
	)
)

(instance vRightBorder of View
	(properties
		x 619
		y 343
		view 14
	)

	(method (init)
		(super init: &rest)
		(GKHotCursor delete: self)
	)
)

(instance tKlingmann1 of Topic ; "Himself"
	(properties
		sceneNum 50
		flagNum 117
		noun 3
	)
)

(instance tKlingmann2 of Topic ; "Himself"
	(properties
		sceneNum 51
		flagNum 118
		readyFlagNum 117 ; "Himself"
		noun 4
	)
)

(instance tResearch of Topic ; "Research"
	(properties
		sceneNum 52
		flagNum 119
		readyFlagNum 118 ; "Himself"
		noun 5
	)
)

(instance tWolves of Topic ; "Wolves"
	(properties
		sceneNum 53
		flagNum 120
		noun 6
	)
)

(instance tMissingWolves1 of Topic ; "Missing Wolves"
	(properties
		sceneNum 54
		flagNum 121
		noun 7
	)
)

(instance tMissingWolves2 of Topic ; "Missing Wolves"
	(properties
		sceneNum -1
		flagNum 122
		readyFlagNum 121 ; "Missing Wolves"
		noun 7
	)
)

(instance stHowLong of Topic ; "How long have the wolves been missing?"
	(properties
		sceneNum 55
		flagNum 123
		noun 8
	)
)

(instance stResponsible of Topic ; "Do you think the Zoo wolves are responsible for the mutilation killings?"
	(properties
		sceneNum 56
		flagNum 124
		noun 9
	)
)

(instance stWhyHumans of Topic ; "Why would the wolves kill humans?"
	(properties
		sceneNum 57
		flagNum 125
		noun 10
	)
)

(instance stHowChoose of Topic ; "How does a wolf choose its victims?"
	(properties
		sceneNum 58
		flagNum 126
		readyFlagNum 125 ; "Why would the wolves kill humans?"
		noun 11
	)
)

