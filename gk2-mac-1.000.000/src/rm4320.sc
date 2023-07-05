;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4320)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	rm4320 0
)

(instance rm4320 of TopicRoom ; "Hunt Club: Front Hall"
	(properties
		modNum 430
		noun 16
		picture 4323
	)

	(method (init)
		(if (== gChapter 1)
			(= dialogDoneFlag 43)
		else
			(= dialogDoneFlag 52)
		)
		(pXaver init: setScript: FidgetScript)
		(gEgo setScale: 0 view: 21102 loop: 0 cel: 0 posn: 500 127 init:)
		(switch gChapter
			(1
				(super
					init:
						tPlaceIsThis
						tDoktorKlingmann
						tTaxadermist
						tHunter
						tFamily
						tRitter
				)
				(return)
			)
			(3
				(tClub
					setSubList:
						tClubHowLong
						tWhatHappened
						tClubNumber
						tHowOftenHunt
				)
				(super init: tClub tClubMembers tBlackWolf)
				(return)
			)
		)
	)

	(method (cleanUp)
		(if (== gChapter 3)
			(PlayScene 263)
		)
	)

	(method (converse)
		(cond
			((IsFlag 32) ; "What kind of place is this?"
				(return 0)
			)
			((IsFlag 229) ; "I tell you, I am a Ritter of Rittersberg."
				(ClearFlag 229)
				(SetFlag 31)
				(return 0)
			)
			((and (IsFlag 231) (not (IsFlag 33))) ; "I am a member of a prominent German family."
				(SetFlag 33)
				(SetFlag 31)
				(return 0)
			)
		)
		(return (super converse: &rest))
	)
)

(instance pXaver of Prop
	(properties
		modNum 430
		x 80
		y 333
		priority 100
		fixPriority 1
		view 23102
	)
)

(instance tTaxadermist of Topic ; "Are you in the market for a taxidermist?"
	(properties
		sceneNum 107
		flagNum 233
		readyFlagNum 116 ; "Die K\94niglich-Bayrische Hofjagdloge" in rm4220
		noun 10
	)
)

(instance tDoktorKlingmann of Topic ; "Do you know Herr Doktor Klingmann?"
	(properties
		sceneNum 108
		flagNum 232
		noun 11
	)
)

(instance tPlaceIsThis of Topic ; "What kind of place is this?"
	(properties
		sceneNum 109
		flagNum 32
		noun 12
		nextRoomNum 430 ; clubFrontRm
	)

	(method (yo)
		(return
			(and
				(not (IsFlag flagNum))
				(or (not readyFlagNum) (IsFlag readyFlagNum))
				(not (IsFlag 116)) ; "Die K\94niglich-Bayrische Hofjagdloge" in rm4220
			)
		)
	)
)

(instance tHunter of Topic ; "I'm an avid hunter."
	(properties
		sceneNum 110
		flagNum 230
		readyFlagNum 116 ; "Die K\94niglich-Bayrische Hofjagdloge" in rm4220
		noun 13
	)
)

(instance tFamily of Topic ; "I am a member of a prominent German family."
	(properties
		sceneNum 111
		flagNum 231
		readyFlagNum 230 ; "I'm an avid hunter."
		noun 14
	)
)

(instance tRitter of Topic ; "I tell you, I am a Ritter of Rittersberg."
	(properties
		sceneNum 112
		flagNum 229
		readyFlagNum 231 ; "I am a member of a prominent German family."
		noun 15
	)
)

(instance tClub of Topic ; "The Club"
	(properties
		sceneNum 264
		flagNum 234
		noun 17
	)
)

(instance tClubMembers of Topic ; "Club Members"
	(properties
		sceneNum 269
		flagNum 235
		noun 22
	)
)

(instance tClubHowLong of Topic ; "How long has the club been around?"
	(properties
		sceneNum 265
		flagNum 236
		noun 18
	)
)

(instance tWhatHappened of Topic ; "What happened in 1970?"
	(properties
		sceneNum 266
		flagNum 237
		readyFlagNum 236 ; "How long has the club been around?"
		noun 19
	)
)

(instance tClubNumber of Topic ; "How many members are there?"
	(properties
		sceneNum 267
		flagNum 239
		noun 20
	)
)

(instance tHowOftenHunt of Topic ; "How often do the club members go hunting?"
	(properties
		sceneNum 268
		flagNum 238
		noun 21
	)
)

(instance tBlackWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 270
		flagNum 240
		noun 23
	)
)

