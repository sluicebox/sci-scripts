;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm040 0
)

(instance rm040 of Rm
	(properties
		picture 40
		style 0
		horizon 134
		vanishingY 100
	)

	(method (init)
		(HandsOn)
		(Load rsVIEW 127)
		(Load rsVIEW 36)
		(Load rsVIEW 240)
		(super init:)
		(= global207 1)
		(gEgo loop: 1 posn: 263 150 init:)
		(proc0_10 70 158 320 150)
		(fire init:)
		(table init:)
		(gAddToPics add: flowers dogPicture eachElementDo: #init doit:)
		(if [global675 15]
			(man init:)
			(catMouse init:)
		)
	)

	(method (doit)
		(if (== (gEgo onControl: 1) 4)
			(gCurRoom newRoom: 15)
		)
		(super doit:)
	)
)

(instance fire of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 127 posn: 98 136 setLoop: 3 setCycle: Fwd cycleSpeed: 3)
	)
)

(instance man of View
	(properties)

	(method (init)
		(super init:)
		(self view: 127 posn: 173 130 setLoop: 1 setCel: 0 stopUpd:)
	)
)

(instance catMouse of View
	(properties)

	(method (init)
		(super init:)
		(self view: 127 posn: 136 119 setLoop: 1 setCel: 1 stopUpd:)
	)
)

(instance table of View
	(properties)

	(method (init)
		(super init:)
		(self view: 36 posn: 70 175 setPri: 10 ignoreActors: 1 stopUpd:)
	)
)

(instance dogPicture of PicView
	(properties
		x 143
		y 105
		view 240
	)
)

(instance flowers of PicView
	(properties
		x 115
		y 125
		view 240
		cel 1
	)
)

