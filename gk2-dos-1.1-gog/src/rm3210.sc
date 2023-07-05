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
		dialogDoneFlag 515
	)

	(method (init)
		(if (not checking)
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
			(tOVictims
				setSubList: tNumVictims tWhenVictims tPatVictims
				setFlag: 1
			)
			(tOVictims1 setSubList: tNumVictims tWhenVictims tPatVictims)
			(tKiller setSubList: tForensics tWereWolf tZooWolf tOneWolf)
			(tKillin setSubList: tLatest tTheories)
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
				(IsFlag 227) ; "You believe only one animal is responsible?"
				(IsFlag 225) ; "Have you considered werewolfry?"
				(IsFlag 226) ; "The killer isn't one of the Zoo wolves, is it?"
				(IsFlag 221) ; "When were the other victims killed?"
				(IsFlag 224) ; "What does forensics say about the killer?"
				(IsFlag 25) ; "Tell me about the latest victim."
				(IsFlag 514)
				(IsFlag 218) ; "The Black Wolf"
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

(instance tHimself of Topic ; "Himself"
	(properties
		sceneNum 350
		flagNum 214
		noun 10
	)
)

(instance tKillin of Topic ; "Downtown Killing"
	(properties
		sceneNum -1
		flagNum 358
		noun 24
	)
)

(instance tOVictims of Topic ; "Other Victims"
	(properties
		sceneNum 351
		flagNum 215
		noun 11
	)
)

(instance tOVictims1 of Topic ; "Other Victims"
	(properties
		sceneNum -1
		flagNum 216
		readyFlagNum 215 ; "Other Victims"
		noun 11
	)
)

(instance tKiller of Topic ; "The Killer"
	(properties
		sceneNum -1
		flagNum 217
		noun 25
	)
)

(instance tBlackWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 366
		flagNum 218
		readyFlagNum 514
		noun 22
	)
)

(instance tMissingPerson of Topic ; "Missing Persons Cases"
	(properties
		sceneNum 367
		flagNum 219
		readyFlagNum 218 ; "The Black Wolf"
		noun 23
	)
)

(instance tNumVictims of Topic ; "How many victims have there been?"
	(properties
		sceneNum 352
		flagNum 220
		noun 12
	)
)

(instance tWhenVictims of Topic ; "When were the other victims killed?"
	(properties
		sceneNum 353
		flagNum 221
		noun 13
	)
)

(instance tPatVictims of Topic ; "Is there a pattern to the locations of the killings?"
	(properties
		sceneNum 355
		flagNum 222
		noun 14
	)
)

(instance tForensics of Topic ; "What does forensics say about the killer?"
	(properties
		sceneNum 357
		flagNum 224
		noun 16
	)
)

(instance tWereWolf of Topic ; "Have you considered werewolfry?"
	(properties
		sceneNum 359
		flagNum 225
		noun 17
	)
)

(instance tZooWolf of Topic ; "The killer isn't one of the Zoo wolves, is it?"
	(properties
		sceneNum 360
		flagNum 226
		noun 18
	)
)

(instance tOneWolf of Topic ; "You believe only one animal is responsible?"
	(properties
		sceneNum 361
		flagNum 227
		noun 19
	)
)

(instance tLatest of Topic ; "Tell me about the latest victim."
	(properties
		sceneNum 364
		flagNum 25
		noun 21
	)
)

(instance tTheories of Topic ; "Have any theories about why the killer struck downtown this time?"
	(properties
		sceneNum 363
		flagNum 228
		noun 20
	)
)

(instance tCaseStatus1 of Topic ; "Case Status"
	(properties
		sceneNum 573
		flagNum 354
		noun 27
	)

	(method (yo)
		(return (and (not (IsFlag flagNum)) (== gChapter 5)))
	)
)

(instance tCaseStatus2 of Topic ; "Case Status"
	(properties
		sceneNum 574
		flagNum 355
		readyFlagNum 354 ; "Case Status"
		noun 28
	)
)

(instance tAccountBook1 of Topic ; "Grossberg's Account Book"
	(properties
		sceneNum 575
		flagNum 356
		readyFlagNum 546
		noun 29
	)

	(method (yo)
		(return (and (not (IsFlag flagNum)) (IsFlag 546) (== gChapter 5)))
	)
)

(instance tAccountBook2 of Topic ; "Grossberg's Account Book"
	(properties
		sceneNum 576
		flagNum 357
		readyFlagNum 356 ; "Grossberg's Account Book"
		noun 30
	)
)

