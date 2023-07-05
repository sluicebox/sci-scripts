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
		dialogDoneFlag 53
	)

	(method (init)
		(if (not checking)
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

	(method (cleanUp)
		(PlayScene 279)
	)

	(method (dispose)
		(if (IsFlag 252) ; "Trophies in basement"
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

(instance tHimself of Topic ; "Himself"
	(properties
		sceneNum 280
		flagNum 246
		noun 7
	)
)

(instance tHunting1 of Topic ; "Hunting"
	(properties
		sceneNum 281
		flagNum 247
		noun 8
	)
)

(instance tHunting2 of Topic ; "Hunting"
	(properties
		sceneNum 282
		flagNum 248
		readyFlagNum 247 ; "Hunting"
		noun 9
	)
)

(instance tClubMembers of Topic ; "Club Members"
	(properties
		sceneNum 283
		flagNum 249
		noun 10
	)
)

(instance tClub1 of Topic ; "The Club"
	(properties
		sceneNum 285
		flagNum 250
		noun 11
	)
)

(instance tClub2 of Topic ; "The Club"
	(properties
		sceneNum 286
		flagNum 251
		readyFlagNum 250 ; "The Club"
		noun 12
	)
)

(instance tTrophies of Topic ; "Trophies in basement"
	(properties
		sceneNum 287
		flagNum 252
		noun 13
		nextRoomNum 440 ; clubMainRm
	)

	(method (yo)
		(if
			(and
				(not (IsFlag flagNum))
				(or (not subList) (subList firstTrue: #yo))
				(IsFlag 250) ; "The Club"
				(IsFlag 249) ; "Club Members"
			)
			(IsFlag 247) ; "Hunting"
		)
	)
)

(instance tBlackWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 288
		flagNum 253
		readyFlagNum 514
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

