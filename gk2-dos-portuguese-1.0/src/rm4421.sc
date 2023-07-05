;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4421)
(include sci.sh)
(use Main)
(use n011)
(use TopicRoom)
(use TopicPrint)
(use FidgetScript)
(use Actor)

(public
	rm4421 0
)

(instance rm4421 of TopicRoom ; "Hunt Club: Main Hall"
	(properties
		modNum 440
		noun 6
		picture 4420
		BAD_SELECTOR 54
	)

	(method (init)
		(if (not BAD_SELECTOR)
			(gEgo
				setScale: 0
				view: 23289
				setLoop: 0 1
				cel: 0
				posn: 136 108
				init:
				setScript: FidgetScript
			)
			(pPreiss init: setScript: (FidgetScript new:))
			(vTable init:)
		)
		(super
			init:
				tHimself
				tHimself2
				tClub1
				tClubMembers
				tClubMembers2
				tVonZell1
				tVonZell2
				tVonZell3
				tBlackWolf
		)
	)

	(method (dispose)
		(if (gCurRoom BAD_SELECTOR:)
			(PlayScene 291 0 -1)
		)
		(super dispose: &rest)
	)
)

(instance pPreiss of Prop
	(properties
		modNum 440
		x 446
		y 124
		view 24289
	)
)

(instance vTable of View
	(properties
		x 259
		y 278
		view 25289
	)
)

(instance tHimself of Topic
	(properties
		BAD_SELECTOR 292
		BAD_SELECTOR 254
		noun 15
	)
)

(instance tHimself2 of Topic
	(properties
		BAD_SELECTOR 293
		BAD_SELECTOR 255
		BAD_SELECTOR 254
		noun 16
	)
)

(instance tClub1 of Topic
	(properties
		BAD_SELECTOR 295
		BAD_SELECTOR 256
		noun 17
	)
)

(instance tClubMembers of Topic
	(properties
		BAD_SELECTOR 297
		BAD_SELECTOR 257
		noun 18
	)
)

(instance tClubMembers2 of Topic
	(properties
		BAD_SELECTOR 301
		BAD_SELECTOR 258
		BAD_SELECTOR 257
		noun 19
	)
)

(instance tVonZell1 of Topic
	(properties
		BAD_SELECTOR 298
		BAD_SELECTOR 259
		BAD_SELECTOR 257
		noun 20
	)
)

(instance tVonZell2 of Topic
	(properties
		BAD_SELECTOR 299
		BAD_SELECTOR 260
		BAD_SELECTOR 259
		noun 21
	)
)

(instance tVonZell3 of Topic
	(properties
		BAD_SELECTOR 300
		BAD_SELECTOR 261
		BAD_SELECTOR 260
		noun 22
	)
)

(instance tBlackWolf of Topic
	(properties
		BAD_SELECTOR 304
		BAD_SELECTOR 262
		BAD_SELECTOR 514
		noun 23
	)
)

