;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7121)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)
(use System)

(public
	rm711c2d2 0
)

(instance rm711c2d2 of TopicRoom
	(properties
		modNum 7122
		picture 7122
		south 700 ; sqRm
		dialogDoneFlag 45
	)

	(method (init)
		(if (gEgo has: 29) ; invChurchFile
			(SetFlag 454) ; enable "Church File"
		else
			(ClearFlag 454) ; disable "Church File"
		)
		(if (not checking)
			(gEgo
				setScale: 0
				view: 22189
				setLoop: 2 1
				cel: 0
				posn: 188 316
				init:
				setScript: FidgetScript
			)
			(mayor init: setScript: (FidgetScript new:))
			(if (not (IsFlag 403))
				(SetFlag 403)
				(= initScene 193)
			else
				(= initScene 194)
			)
		)
		(= topicList (List new:))
		(topicList add: tHimself tRittersberg1 tRittersberg2 tThisBuilding)
		(cond
			((IsFlag 471)
				(tTrialRecords2
					setSubList: tWhy tWhat tWhere tChangeBack tWhoManWas
				)
				(topicList add: tTrialRecords2)
			)
			((IsFlag 467)
				(topicList add: tTrialRecords1)
			)
		)
		(topicList add: tChurchRecords tShowChurchFile)
		(super init:)
	)

	(method (cleanUp)
		(PlayScene 196)
	)
)

(instance mayor of Prop
	(properties
		x 464
		y 192
		view 21189
	)
)

(instance tHimself of Topic ; "Himself"
	(properties
		sceneNum 197
		flagNum 151
		noun 9
	)
)

(instance tRittersberg1 of Topic ; "Rittersberg"
	(properties
		sceneNum 198
		flagNum 152
		noun 11
	)
)

(instance tRittersberg2 of Topic ; "Rittersberg"
	(properties
		sceneNum 199
		flagNum 153
		readyFlagNum 152 ; "Rittersberg"
		noun 11
	)
)

(instance tThisBuilding of Topic ; "This Building"
	(properties
		sceneNum 200
		flagNum 154
		noun 12
	)
)

(instance tTrialRecords1 of Topic ; "Trial Records"
	(properties
		sceneNum 201
		flagNum 155
		readyFlagNum 154 ; "This Building"
		noun 13
	)
)

(instance tTrialRecords2 of Topic ; "Trial Records"
	(properties
		sceneNum 202
		flagNum 156
		noun 13
	)
)

(instance tWhy of Topic ; "Why did they bring the werewolf to Rittersberg?"
	(properties
		sceneNum 204
		flagNum 160
		noun 14
		nextRoomNum 720 ; dungeonRm
	)

	(method (nextRoomCheck)
		(return
			(and
				(IsFlag 162) ; "Where was the werewolf kept while it was here?"
				(IsFlag 161) ; "What happened to the alleged werewolf?"
				(IsFlag 163) ; "Did the werewolf ever change back?"
				(IsFlag 164) ; "Why did they want to find out who the man was?"
				(not (IsFlag 470))
			)
		)
	)
)

(instance tWhere of Topic ; "Where was the werewolf kept while it was here?"
	(properties
		sceneNum 205
		flagNum 162
		noun 16
		nextRoomNum 720 ; dungeonRm
	)

	(method (nextRoomCheck)
		(return
			(and
				(IsFlag 160) ; "Why did they bring the werewolf to Rittersberg?"
				(IsFlag 161) ; "What happened to the alleged werewolf?"
				(IsFlag 163) ; "Did the werewolf ever change back?"
				(IsFlag 164) ; "Why did they want to find out who the man was?"
				(not (IsFlag 470))
			)
		)
	)
)

(instance tWhat of Topic ; "What happened to the alleged werewolf?"
	(properties
		sceneNum 206
		flagNum 161
		noun 15
		nextRoomNum 720 ; dungeonRm
	)

	(method (nextRoomCheck)
		(return
			(and
				(IsFlag 160) ; "Why did they bring the werewolf to Rittersberg?"
				(IsFlag 162) ; "Where was the werewolf kept while it was here?"
				(IsFlag 163) ; "Did the werewolf ever change back?"
				(IsFlag 164) ; "Why did they want to find out who the man was?"
				(not (IsFlag 470))
			)
		)
	)
)

(instance tChangeBack of Topic ; "Did the werewolf ever change back?"
	(properties
		sceneNum 207
		flagNum 163
		readyFlagNum 160 ; "Why did they bring the werewolf to Rittersberg?"
		noun 17
		nextRoomNum 720 ; dungeonRm
	)

	(method (nextRoomCheck)
		(return
			(and
				(IsFlag 162) ; "Where was the werewolf kept while it was here?"
				(IsFlag 161) ; "What happened to the alleged werewolf?"
				(IsFlag 160) ; "Why did they bring the werewolf to Rittersberg?"
				(IsFlag 164) ; "Why did they want to find out who the man was?"
				(not (IsFlag 470))
			)
		)
	)
)

(instance tWhoManWas of Topic ; "Why did they want to find out who the man was?"
	(properties
		sceneNum 208
		flagNum 164
		readyFlagNum 160 ; "Why did they bring the werewolf to Rittersberg?"
		noun 18
		nextRoomNum 720 ; dungeonRm
	)

	(method (nextRoomCheck)
		(return
			(and
				(IsFlag 162) ; "Where was the werewolf kept while it was here?"
				(IsFlag 161) ; "What happened to the alleged werewolf?"
				(IsFlag 160) ; "Why did they bring the werewolf to Rittersberg?"
				(IsFlag 163) ; "Did the werewolf ever change back?"
				(not (IsFlag 470))
			)
		)
	)
)

(instance tChurchRecords of Topic ; "Church Records"
	(properties
		sceneNum 209
		flagNum 158
		readyFlagNum 472
		noun 8
		nextRoomNum 700 ; sqRm
	)
)

(instance tShowChurchFile of Topic ; "Church File"
	(properties
		sceneNum 195
		flagNum 150
		readyFlagNum 454
		noun 19
		nextRoomNum 700 ; sqRm
	)
)

(instance tLudwigII of Topic ; "Ludwig II", UNUSED
	(properties
		sceneNum 210
		flagNum 159
		readyFlagNum 466
		noun 10
	)
)

