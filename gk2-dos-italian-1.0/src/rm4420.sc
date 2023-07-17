;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4420)
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
	rm4420 0
)

(instance rm4420 of TopicRoom ; "Hunt Club: Main Hall"
	(properties
		modNum 440
		noun 6
		picture 4420
		north 440 ; clubMainRm
		south 440 ; clubMainRm
		BAD_SELECTOR 53
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(gEgo
				setScale: 0
				view: 23277
				setLoop: 0 1
				cel: 0
				posn: 122 187
				init:
				setScript: (FidgetScript new:)
			)
			(pVonZell init: setScript: FidgetScript)
		)
		(super
			init:
				tHimself
				tHunting1
				tHunting2
				tClubMembers
				tClub1
				tClub2
				tBlackWolf
				tTrophies
		)
	)

	(method (BAD_SELECTOR)
		(PlayScene 279)
	)

	(method (dispose)
		(if (IsFlag 252)
			(SetFlag 53)
		)
		(super dispose:)
	)
)

(instance pVonZell of Prop
	(properties
		modNum 440
		x 468
		y 181
		view 24277
	)
)

(instance tHimself of Topic
	(properties
		BAD_SELECTOR 280
		BAD_SELECTOR 246
		noun 7
	)
)

(instance tHunting1 of Topic
	(properties
		BAD_SELECTOR 281
		BAD_SELECTOR 247
		noun 8
	)
)

(instance tHunting2 of Topic
	(properties
		BAD_SELECTOR 282
		BAD_SELECTOR 248
		BAD_SELECTOR 247
		noun 9
	)
)

(instance tClubMembers of Topic
	(properties
		BAD_SELECTOR 283
		BAD_SELECTOR 249
		noun 10
	)
)

(instance tClub1 of Topic
	(properties
		BAD_SELECTOR 285
		BAD_SELECTOR 250
		noun 11
	)
)

(instance tClub2 of Topic
	(properties
		BAD_SELECTOR 286
		BAD_SELECTOR 251
		BAD_SELECTOR 250
		noun 12
	)
)

(instance tTrophies of Topic
	(properties
		BAD_SELECTOR 287
		BAD_SELECTOR 252
		noun 13
		BAD_SELECTOR 440
	)

	(method (BAD_SELECTOR)
		(if
			(and
				(not (IsFlag BAD_SELECTOR))
				(or (not BAD_SELECTOR) (BAD_SELECTOR firstTrue: #sel_834))
				(IsFlag 250)
				(IsFlag 249)
			)
			(IsFlag 247)
		)
	)
)

(instance tBlackWolf of Topic
	(properties
		BAD_SELECTOR 288
		BAD_SELECTOR 253
		BAD_SELECTOR 514
		noun 14
	)
)

(instance sFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 8 16))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance sVonZellFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(pVonZell cel: 0 setCycle: End)
				(= seconds (Random 2 10))
			)
			(2
				(self init:)
			)
		)
	)
)

