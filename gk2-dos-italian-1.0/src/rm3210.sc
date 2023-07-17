;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3210)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	rm3210 0
)

(instance rm3210 of TopicRoom ; "Leber's Office"
	(properties
		modNum 320
		noun 9
		picture 3222
		BAD_SELECTOR 515
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(gEgo
				setScale: 0
				view: 26342
				setLoop: 0 1
				cel: 0
				posn: 332 333
				init:
				setScript: FidgetScript
			)
			(pLeber init: setScript: (FidgetScript new:))
		)
		(if (== gChapter 3)
			(tOVictims sel_835: tNumVictims tWhenVictims tPatVictims sel_832: 1)
			(tOVictims1 sel_835: tNumVictims tWhenVictims tPatVictims)
			(tKiller sel_835: tForensics tWereWolf tZooWolf tOneWolf)
			(tKillin sel_835: tLatest tTheories)
			(super
				init:
					tHimself
					tOVictims
					tOVictims1
					tKiller
					tKillin
					tBlackWolf
					tMissingPerson
			)
			(return)
		else
			(super init: tCaseStatus1 tCaseStatus2 tAccountBook1 tAccountBook2)
			(return)
		)
	)

	(method (dispose)
		(if
			(and
				(== gChapter 3)
				(IsFlag 227)
				(IsFlag 225)
				(IsFlag 226)
				(IsFlag 221)
				(IsFlag 224)
				(IsFlag 25)
				(IsFlag 514)
				(IsFlag 218)
				(not (IsFlag 517))
			)
			(SetFlag 515)
			(SetFlag 517)
			(PlayScene 349)
		)
		(super dispose:)
	)
)

(instance pLeber of Prop
	(properties
		modNum 320
		x 109
		y 100
		view 25342
	)
)

(instance tHimself of Topic
	(properties
		BAD_SELECTOR 350
		BAD_SELECTOR 214
		noun 10
	)
)

(instance tKillin of Topic
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 358
		noun 24
	)
)

(instance tOVictims of Topic
	(properties
		BAD_SELECTOR 351
		BAD_SELECTOR 215
		noun 11
	)
)

(instance tOVictims1 of Topic
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 216
		BAD_SELECTOR 215
		noun 11
	)
)

(instance tKiller of Topic
	(properties
		BAD_SELECTOR -1
		BAD_SELECTOR 217
		noun 25
	)
)

(instance tBlackWolf of Topic
	(properties
		BAD_SELECTOR 366
		BAD_SELECTOR 218
		BAD_SELECTOR 514
		noun 22
	)
)

(instance tMissingPerson of Topic
	(properties
		BAD_SELECTOR 367
		BAD_SELECTOR 219
		BAD_SELECTOR 218
		noun 23
	)
)

(instance tNumVictims of Topic
	(properties
		BAD_SELECTOR 352
		BAD_SELECTOR 220
		noun 12
	)
)

(instance tWhenVictims of Topic
	(properties
		BAD_SELECTOR 353
		BAD_SELECTOR 221
		noun 13
	)
)

(instance tPatVictims of Topic
	(properties
		BAD_SELECTOR 355
		BAD_SELECTOR 222
		noun 14
	)
)

(instance tForensics of Topic
	(properties
		BAD_SELECTOR 357
		BAD_SELECTOR 224
		noun 16
	)
)

(instance tWereWolf of Topic
	(properties
		BAD_SELECTOR 359
		BAD_SELECTOR 225
		noun 17
	)
)

(instance tZooWolf of Topic
	(properties
		BAD_SELECTOR 360
		BAD_SELECTOR 226
		noun 18
	)
)

(instance tOneWolf of Topic
	(properties
		BAD_SELECTOR 361
		BAD_SELECTOR 227
		noun 19
	)
)

(instance tLatest of Topic
	(properties
		BAD_SELECTOR 364
		BAD_SELECTOR 25
		noun 21
	)
)

(instance tTheories of Topic
	(properties
		BAD_SELECTOR 363
		BAD_SELECTOR 228
		noun 20
	)
)

(instance tCaseStatus1 of Topic
	(properties
		BAD_SELECTOR 573
		BAD_SELECTOR 354
		noun 27
	)

	(method (BAD_SELECTOR)
		(return (and (not (IsFlag BAD_SELECTOR)) (== gChapter 5)))
	)
)

(instance tCaseStatus2 of Topic
	(properties
		BAD_SELECTOR 574
		BAD_SELECTOR 355
		BAD_SELECTOR 354
		noun 28
	)
)

(instance tAccountBook1 of Topic
	(properties
		BAD_SELECTOR 575
		BAD_SELECTOR 356
		BAD_SELECTOR 546
		noun 29
	)

	(method (BAD_SELECTOR)
		(return
			(and (not (IsFlag BAD_SELECTOR)) (IsFlag 546) (== gChapter 5))
		)
	)
)

(instance tAccountBook2 of Topic
	(properties
		BAD_SELECTOR 576
		BAD_SELECTOR 357
		BAD_SELECTOR 356
		noun 30
	)
)

