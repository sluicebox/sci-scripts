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
		dialogDoneFlag 54
	)

	(method (init)
		(if (not checking)
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
		(if (gCurRoom checkTopics:)
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

(instance tHimself of Topic ; "Himself"
	(properties
		sceneNum 292
		flagNum 254
		noun 15
	)
)

(instance tHimself2 of Topic ; "Himself"
	(properties
		sceneNum 293
		flagNum 255
		readyFlagNum 254 ; "Himself"
		noun 16
	)
)

(instance tClub1 of Topic ; "The Club"
	(properties
		sceneNum 295
		flagNum 256
		noun 17
	)
)

(instance tClubMembers of Topic ; "Club Members"
	(properties
		sceneNum 297
		flagNum 257
		noun 18
	)
)

(instance tClubMembers2 of Topic ; "Club Members"
	(properties
		sceneNum 301
		flagNum 258
		readyFlagNum 257 ; "Club Members"
		noun 19
	)
)

(instance tVonZell1 of Topic ; "Von Zell"
	(properties
		sceneNum 298
		flagNum 259
		readyFlagNum 257 ; "Club Members"
		noun 20
	)
)

(instance tVonZell2 of Topic ; "Von Zell"
	(properties
		sceneNum 299
		flagNum 260
		readyFlagNum 259 ; "Von Zell"
		noun 21
	)
)

(instance tVonZell3 of Topic ; "Von Zell"
	(properties
		sceneNum 300
		flagNum 261
		readyFlagNum 260 ; "Von Zell"
		noun 22
	)
)

(instance tBlackWolf of Topic ; "The Black Wolf"
	(properties
		sceneNum 304
		flagNum 262
		readyFlagNum 514
		noun 23
	)
)

