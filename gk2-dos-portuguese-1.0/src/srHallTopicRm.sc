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
		BAD_SELECTOR 134
		BAD_SELECTOR 44
	)

	(method (init)
		(if (not BAD_SELECTOR)
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

	(method (BAD_SELECTOR)
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

(instance tSRGabe of Topic
	(properties
		BAD_SELECTOR 139
		BAD_SELECTOR 182
		noun 3
	)
)

(instance tSRGabe2 of Topic
	(properties
		BAD_SELECTOR 140
		BAD_SELECTOR 183
		BAD_SELECTOR 182
		noun 4
	)
)

(instance tSRHerself of Topic
	(properties
		BAD_SELECTOR 137
		BAD_SELECTOR 184
		noun 5
	)
)

(instance tSRHerself2 of Topic
	(properties
		BAD_SELECTOR 138
		BAD_SELECTOR 185
		BAD_SELECTOR 184
		noun 6
	)
)

(instance tSRCarKeys of Topic
	(properties
		BAD_SELECTOR 144
		BAD_SELECTOR 186
		BAD_SELECTOR 460
		noun 7
	)
)

(instance tSRResearch of Topic
	(properties
		BAD_SELECTOR 141
		BAD_SELECTOR 187
		noun 8
	)
)

(instance tSRResearch2 of Topic
	(properties
		BAD_SELECTOR 142
		BAD_SELECTOR 188
		BAD_SELECTOR 187
		noun 9
	)
)

(instance tSRResearch3 of Topic
	(properties
		BAD_SELECTOR 143
		BAD_SELECTOR 189
		BAD_SELECTOR 188
		noun 10
	)
)

(instance tSRLockedDoor of Topic
	(properties
		BAD_SELECTOR 145
		BAD_SELECTOR 190
		BAD_SELECTOR 462
		noun 11
	)
)

