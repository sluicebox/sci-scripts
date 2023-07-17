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
		BAD_SELECTOR 41
	)

	(method (init)
		(if (not BAD_SELECTOR)
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
			sel_835: stHowLong stResponsible stWhyHumans stHowChoose
			sel_832: 1
		)
		(tMissingWolves2
			sel_835: stHowLong stResponsible stWhyHumans stHowChoose
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

(instance tKlingmann1 of Topic
	(properties
		BAD_SELECTOR 50
		BAD_SELECTOR 117
		noun 3
	)
)

(instance tKlingmann2 of Topic
	(properties
		BAD_SELECTOR 51
		BAD_SELECTOR 118
		BAD_SELECTOR 117
		noun 4
	)
)

(instance tResearch of Topic
	(properties
		BAD_SELECTOR 52
		BAD_SELECTOR 119
		BAD_SELECTOR 118
		noun 5
	)
)

(instance tWolves of Topic
	(properties
		BAD_SELECTOR 53
		BAD_SELECTOR 120
		noun 6
	)
)

(instance tMissingWolves1 of Topic
	(properties
		BAD_SELECTOR 54
		BAD_SELECTOR 121
		noun 7
	)
)

(instance tMissingWolves2 of Topic
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 122
		BAD_SELECTOR 121
		noun 7
	)
)

(instance stHowLong of Topic
	(properties
		BAD_SELECTOR 55
		BAD_SELECTOR 123
		noun 8
	)
)

(instance stResponsible of Topic
	(properties
		BAD_SELECTOR 56
		BAD_SELECTOR 124
		noun 9
	)
)

(instance stWhyHumans of Topic
	(properties
		BAD_SELECTOR 57
		BAD_SELECTOR 125
		noun 10
	)
)

(instance stHowChoose of Topic
	(properties
		BAD_SELECTOR 58
		BAD_SELECTOR 126
		BAD_SELECTOR 125
		noun 11
	)
)

