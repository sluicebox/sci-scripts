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
			(= BAD_SELECTOR 43)
		else
			(= BAD_SELECTOR 52)
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
					sel_835:
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

	(method (BAD_SELECTOR)
		(if (== gChapter 3)
			(PlayScene 263)
		)
	)

	(method (BAD_SELECTOR)
		(cond
			((IsFlag 32)
				(return 0)
			)
			((IsFlag 229)
				(ClearFlag 229)
				(SetFlag 31)
				(return 0)
			)
			((and (IsFlag 231) (not (IsFlag 33)))
				(SetFlag 33)
				(SetFlag 31)
				(return 0)
			)
		)
		(return (super sel_846: &rest))
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

(instance tTaxadermist of Topic
	(properties
		BAD_SELECTOR 107
		BAD_SELECTOR 233
		BAD_SELECTOR 116
		noun 10
	)
)

(instance tDoktorKlingmann of Topic
	(properties
		BAD_SELECTOR 108
		BAD_SELECTOR 232
		noun 11
	)
)

(instance tPlaceIsThis of Topic
	(properties
		BAD_SELECTOR 109
		BAD_SELECTOR 32
		noun 12
		BAD_SELECTOR 430
	)

	(method (BAD_SELECTOR)
		(return
			(and
				(not (IsFlag BAD_SELECTOR))
				(or (not BAD_SELECTOR) (IsFlag BAD_SELECTOR))
				(not (IsFlag 116))
			)
		)
	)
)

(instance tHunter of Topic
	(properties
		BAD_SELECTOR 110
		BAD_SELECTOR 230
		BAD_SELECTOR 116
		noun 13
	)
)

(instance tFamily of Topic
	(properties
		BAD_SELECTOR 111
		BAD_SELECTOR 231
		BAD_SELECTOR 230
		noun 14
	)
)

(instance tRitter of Topic
	(properties
		BAD_SELECTOR 112
		BAD_SELECTOR 229
		BAD_SELECTOR 231
		noun 15
	)
)

(instance tClub of Topic
	(properties
		BAD_SELECTOR 264
		BAD_SELECTOR 234
		noun 17
	)
)

(instance tClubMembers of Topic
	(properties
		BAD_SELECTOR 269
		BAD_SELECTOR 235
		noun 22
	)
)

(instance tClubHowLong of Topic
	(properties
		BAD_SELECTOR 265
		BAD_SELECTOR 236
		noun 18
	)
)

(instance tWhatHappened of Topic
	(properties
		BAD_SELECTOR 266
		BAD_SELECTOR 237
		BAD_SELECTOR 236
		noun 19
	)
)

(instance tClubNumber of Topic
	(properties
		BAD_SELECTOR 267
		BAD_SELECTOR 239
		noun 20
	)
)

(instance tHowOftenHunt of Topic
	(properties
		BAD_SELECTOR 268
		BAD_SELECTOR 238
		noun 21
	)
)

(instance tBlackWolf of Topic
	(properties
		BAD_SELECTOR 270
		BAD_SELECTOR 240
		noun 23
	)
)

