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
		BAD_SELECTOR 46
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(werner init: setScript: wernerFidget)
			(gEgo view: 21171 posn: 525 155 init: setScript: FidgetScript)
			(if (IsFlag 492)
				(= BAD_SELECTOR 175)
			else
				(SetFlag 492)
				(= BAD_SELECTOR 174)
			)
		)
		(tGHCase1 sel_835: tGHWhereGabe tGHHowLong tGHAbout sel_832: 1)
		(tGHCaseOther sel_835: tGHWhereGabe tGHHowLong tGHAbout)
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

	(method (BAD_SELECTOR)
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

(instance tGHHimself1 of Topic
	(properties
		BAD_SELECTOR 177
		BAD_SELECTOR 165
		noun 18
	)
)

(instance tGHHimself2 of Topic
	(properties
		BAD_SELECTOR 178
		BAD_SELECTOR 166
		BAD_SELECTOR 165
		noun 19
	)
)

(instance tGHWolfgang1 of Topic
	(properties
		BAD_SELECTOR 179
		BAD_SELECTOR 167
		BAD_SELECTOR 175
		noun 20
	)
)

(instance tGHWolfgang2 of Topic
	(properties
		BAD_SELECTOR 180
		BAD_SELECTOR 168
		BAD_SELECTOR 167
		noun 21
	)
)

(instance tGHRittersburg of Topic
	(properties
		BAD_SELECTOR 181
		BAD_SELECTOR 169
		noun 22
	)
)

(instance tGHCase1 of Topic
	(properties
		BAD_SELECTOR 182
		BAD_SELECTOR 170
		noun 23
	)
)

(instance tGHCaseOther of Topic
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 171
		BAD_SELECTOR 170
		noun 23
	)
)

(instance tGHWhereGabe of Topic
	(properties
		BAD_SELECTOR 183
		BAD_SELECTOR 172
		noun 24
	)
)

(instance tGHHowLong of Topic
	(properties
		BAD_SELECTOR 184
		BAD_SELECTOR 173
		noun 25
	)
)

(instance tGHAbout of Topic
	(properties
		BAD_SELECTOR 185
		BAD_SELECTOR 174
		noun 26
	)
)

(instance tGHWerewolf1 of Topic
	(properties
		BAD_SELECTOR 186
		BAD_SELECTOR 176
		BAD_SELECTOR 174
		noun 27
	)
)

(instance tGHWerewolf2 of Topic
	(properties
		BAD_SELECTOR 187
		BAD_SELECTOR 177
		BAD_SELECTOR 176
		noun 28
	)
)

(instance tGHLudwig1 of Topic
	(properties
		BAD_SELECTOR 188
		BAD_SELECTOR 179
		BAD_SELECTOR 178
		noun 29
	)
)

(instance tGHLudwig2 of Topic
	(properties
		BAD_SELECTOR 189
		BAD_SELECTOR 180
		BAD_SELECTOR 179
		noun 30
	)
)

(instance tGH4Case of Topic
	(properties
		BAD_SELECTOR 441
		BAD_SELECTOR 311
		noun 23
	)
)

(instance tGH4Smiths of Topic
	(properties
		BAD_SELECTOR 445
		BAD_SELECTOR 312
		BAD_SELECTOR 633
		noun 32
		BAD_SELECTOR 7424
	)
)

