;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7422)
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
	gastTopicRm 0
)

(instance gastTopicRm of TopicRoom
	(properties
		modNum 740
		picture 7422
		dialogDoneFlag 46
	)

	(method (init)
		(if (not checking)
			(werner init: setScript: wernerFidget)
			(gEgo view: 21171 posn: 525 155 init: setScript: FidgetScript)
			(if (IsFlag 492)
				(= initScene 175)
			else
				(SetFlag 492)
				(= initScene 174)
			)
		)
		(tGHCase1 setSubList: tGHWhereGabe tGHHowLong tGHAbout setFlag: 1)
		(tGHCaseOther setSubList: tGHWhereGabe tGHHowLong tGHAbout)
		(if (!= gChapter 4)
			(super
				init:
					tGHHimself1
					tGHHimself2
					tGHWolfgang1
					tGHWolfgang2
					tGHRittersburg
					tGHCase1
					tGHCaseOther
					tGHWerewolf1
					tGHWerewolf2
					tGHLudwig1
					tGHLudwig2
			)
			(return)
		else
			(super
				init:
					tGHHimself1
					tGHHimself2
					tGHWolfgang1
					tGHWolfgang2
					tGHRittersburg
					tGHWerewolf1
					tGHWerewolf2
					tGHLudwig1
					tGHLudwig2
					tGH4Case
					tGH4Smiths
			)
			(return)
		)
	)

	(method (cleanUp)
		(PlayScene 176)
	)
)

(instance werner of Prop
	(properties
		x 241
		y 140
		view 23171
		cycleSpeed 8
	)
)

(instance sFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(gEgo cel: 0 setLoop: (Random 0 1) setCycle: End)
				(= seconds (Random 12 20))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance wernerFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End)
				(= seconds 4)
			)
			(1
				(client setCycle: Beg)
				(= seconds (Random 8 14))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance tGHHimself1 of Topic ; "Himself"
	(properties
		sceneNum 177
		flagNum 165
		noun 18
	)
)

(instance tGHHimself2 of Topic ; "Himself"
	(properties
		sceneNum 178
		flagNum 166
		readyFlagNum 165 ; "Himself"
		noun 19
	)
)

(instance tGHWolfgang1 of Topic ; "Wolfgang"
	(properties
		sceneNum 179
		flagNum 167
		readyFlagNum 175
		noun 20
	)
)

(instance tGHWolfgang2 of Topic ; "Wolfgang"
	(properties
		sceneNum 180
		flagNum 168
		readyFlagNum 167 ; "Wolfgang"
		noun 21
	)
)

(instance tGHRittersburg of Topic ; "Rittersberg"
	(properties
		sceneNum 181
		flagNum 169
		noun 22
	)
)

(instance tGHCase1 of Topic ; "Gabriel's Case"
	(properties
		sceneNum 182
		flagNum 170
		noun 23
	)
)

(instance tGHCaseOther of Topic ; "Gabriel's Case"
	(properties
		sceneNum -1
		flagNum 171
		readyFlagNum 170 ; "Gabriel's Case"
		noun 23
	)
)

(instance tGHWhereGabe of Topic ; "Where can I find Gabriel?"
	(properties
		sceneNum 183
		flagNum 172
		noun 24
	)
)

(instance tGHHowLong of Topic ; "Do you know how long Gabriel will be gone?"
	(properties
		sceneNum 184
		flagNum 173
		noun 25
	)
)

(instance tGHAbout of Topic ; "What is the case about?"
	(properties
		sceneNum 185
		flagNum 174
		noun 26
	)
)

(instance tGHWerewolf1 of Topic ; "Werewolves"
	(properties
		sceneNum 186
		flagNum 176
		readyFlagNum 174 ; "What is the case about?"
		noun 27
	)
)

(instance tGHWerewolf2 of Topic ; "Werewolves"
	(properties
		sceneNum 187
		flagNum 177
		readyFlagNum 176 ; "Werewolves"
		noun 28
	)
)

(instance tGHLudwig1 of Topic ; "Ludwig II"
	(properties
		sceneNum 188
		flagNum 179
		readyFlagNum 178
		noun 29
	)
)

(instance tGHLudwig2 of Topic ; "Ludwig II"
	(properties
		sceneNum 189
		flagNum 180
		readyFlagNum 179 ; "Ludwig II"
		noun 30
	)
)

(instance tGH4Case of Topic ; "Gabriel's Case"
	(properties
		sceneNum 441
		flagNum 311
		noun 23
	)
)

(instance tGH4Smiths of Topic ; "The Smiths"
	(properties
		sceneNum 445
		flagNum 312
		readyFlagNum 633
		noun 32
		nextRoomNum 7424 ; smithTopicRm
	)
)

