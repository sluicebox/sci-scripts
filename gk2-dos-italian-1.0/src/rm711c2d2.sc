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
		BAD_SELECTOR 45
	)

	(method (init)
		(if (gEgo has: 29) ; invChurchFile
			(SetFlag 454)
		else
			(ClearFlag 454)
		)
		(if (not BAD_SELECTOR)
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
				(= BAD_SELECTOR 193)
			else
				(= BAD_SELECTOR 194)
			)
		)
		(= BAD_SELECTOR (List new:))
		(BAD_SELECTOR add: tHimself tRittersberg1 tRittersberg2 tThisBuilding)
		(cond
			((IsFlag 471)
				(tTrialRecords2
					sel_835: tWhy tWhat tWhere tChangeBack tWhoManWas
				)
				(BAD_SELECTOR add: tTrialRecords2)
			)
			((IsFlag 467)
				(BAD_SELECTOR add: tTrialRecords1)
			)
		)
		(BAD_SELECTOR add: tChurchRecords tShowChurchFile)
		(super init:)
	)

	(method (BAD_SELECTOR)
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

(instance tHimself of Topic
	(properties
		BAD_SELECTOR 197
		BAD_SELECTOR 151
		noun 9
	)
)

(instance tRittersberg1 of Topic
	(properties
		BAD_SELECTOR 198
		BAD_SELECTOR 152
		noun 11
	)
)

(instance tRittersberg2 of Topic
	(properties
		BAD_SELECTOR 199
		BAD_SELECTOR 153
		BAD_SELECTOR 152
		noun 11
	)
)

(instance tThisBuilding of Topic
	(properties
		BAD_SELECTOR 200
		BAD_SELECTOR 154
		noun 12
	)
)

(instance tTrialRecords1 of Topic
	(properties
		BAD_SELECTOR 201
		BAD_SELECTOR 155
		BAD_SELECTOR 154
		noun 13
	)
)

(instance tTrialRecords2 of Topic
	(properties
		BAD_SELECTOR 202
		BAD_SELECTOR 156
		noun 13
	)
)

(instance tWhy of Topic
	(properties
		BAD_SELECTOR 204
		BAD_SELECTOR 160
		noun 14
		BAD_SELECTOR 720
	)

	(method (BAD_SELECTOR)
		(return
			(and
				(IsFlag 162)
				(IsFlag 161)
				(IsFlag 163)
				(IsFlag 164)
				(not (IsFlag 470))
			)
		)
	)
)

(instance tWhere of Topic
	(properties
		BAD_SELECTOR 205
		BAD_SELECTOR 162
		noun 16
		BAD_SELECTOR 720
	)

	(method (BAD_SELECTOR)
		(return
			(and
				(IsFlag 160)
				(IsFlag 161)
				(IsFlag 163)
				(IsFlag 164)
				(not (IsFlag 470))
			)
		)
	)
)

(instance tWhat of Topic
	(properties
		BAD_SELECTOR 206
		BAD_SELECTOR 161
		noun 15
		BAD_SELECTOR 720
	)

	(method (BAD_SELECTOR)
		(return
			(and
				(IsFlag 160)
				(IsFlag 162)
				(IsFlag 163)
				(IsFlag 164)
				(not (IsFlag 470))
			)
		)
	)
)

(instance tChangeBack of Topic
	(properties
		BAD_SELECTOR 207
		BAD_SELECTOR 163
		BAD_SELECTOR 160
		noun 17
		BAD_SELECTOR 720
	)

	(method (BAD_SELECTOR)
		(return
			(and
				(IsFlag 162)
				(IsFlag 161)
				(IsFlag 160)
				(IsFlag 164)
				(not (IsFlag 470))
			)
		)
	)
)

(instance tWhoManWas of Topic
	(properties
		BAD_SELECTOR 208
		BAD_SELECTOR 164
		BAD_SELECTOR 160
		noun 18
		BAD_SELECTOR 720
	)

	(method (BAD_SELECTOR)
		(return
			(and
				(IsFlag 162)
				(IsFlag 161)
				(IsFlag 160)
				(IsFlag 163)
				(not (IsFlag 470))
			)
		)
	)
)

(instance tChurchRecords of Topic
	(properties
		BAD_SELECTOR 209
		BAD_SELECTOR 158
		BAD_SELECTOR 472
		noun 8
		BAD_SELECTOR 700
	)
)

(instance tShowChurchFile of Topic
	(properties
		BAD_SELECTOR 195
		BAD_SELECTOR 150
		BAD_SELECTOR 454
		noun 19
		BAD_SELECTOR 700
	)
)

(instance tLudwigII of Topic ; UNUSED
	(properties
		BAD_SELECTOR 210
		BAD_SELECTOR 159
		BAD_SELECTOR 466
		noun 10
	)
)

