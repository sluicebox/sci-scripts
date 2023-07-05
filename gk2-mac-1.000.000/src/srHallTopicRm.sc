;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1220)
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
	srHallTopicRm 0
)

(instance srHallTopicRm of TopicRoom
	(properties
		modNum 120
		picture 1220
		initScene 134
		dialogDoneFlag 44
	)

	(method (init)
		(if (not checking)
			(gerda init: setScript: (FidgetScript new:))
			(gEgo view: 22131 posn: 208 117 init: setScript: FidgetScript)
		)
		(super
			init:
				tSRGabe
				tSRGabe2
				tSRHerself
				tSRHerself2
				tSRCarKeys
				tSRResearch
				tSRResearch2
				tSRResearch3
				tSRLockedDoor
		)
	)

	(method (cleanUp)
		(PlayScene 136)
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

(instance tSRGabe of Topic ; "Gabriel"
	(properties
		sceneNum 139
		flagNum 182
		noun 3
	)
)

(instance tSRGabe2 of Topic ; "Gabriel"
	(properties
		sceneNum 140
		flagNum 183
		readyFlagNum 182 ; "Gabriel"
		noun 4
	)
)

(instance tSRHerself of Topic ; "Herself"
	(properties
		sceneNum 137
		flagNum 184
		noun 5
	)
)

(instance tSRHerself2 of Topic ; "Herself"
	(properties
		sceneNum 138
		flagNum 185
		readyFlagNum 184 ; "Herself"
		noun 6
	)
)

(instance tSRCarKeys of Topic ; "Car keys"
	(properties
		sceneNum 144
		flagNum 186
		readyFlagNum 460
		noun 7
	)
)

(instance tSRResearch of Topic ; "Gabriel's research"
	(properties
		sceneNum 141
		flagNum 187
		noun 8
	)
)

(instance tSRResearch2 of Topic ; "Gabriel's research"
	(properties
		sceneNum 142
		flagNum 188
		readyFlagNum 187 ; "Gabriel's research"
		noun 9
	)
)

(instance tSRResearch3 of Topic ; "Gabriel's research"
	(properties
		sceneNum 143
		flagNum 189
		readyFlagNum 188 ; "Gabriel's research"
		noun 10
	)
)

(instance tSRLockedDoor of Topic ; "Locked door"
	(properties
		sceneNum 145
		flagNum 190
		readyFlagNum 462
		noun 11
	)
)

