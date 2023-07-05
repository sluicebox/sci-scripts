;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm12 0
)

(instance rm12 of Rm
	(properties
		picture 700
		style 8
		horizon 90
		north 10
		east 13
		west 11
	)

	(method (dispose)
		(SetFlag 2)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 700)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(gEgo illegalBits: -28672 init:)
		(switch gPrevRoomNum
			(10
				(gEgo posn: 140 91 setMotion: MoveTo 140 190)
			)
			(11
				(gEgo posn: 0 140 setMotion: MoveTo 320 140)
			)
			(13
				(gEgo posn: 319 140 setMotion: MoveTo 0 140)
			)
		)
		(gAddToPics add: southBush eachElementDo: #init doit:)
	)
)

(instance southBush of PV
	(properties
		y 207
		x 162
		view 700
		loop 2
		cel 1
		priority 15
	)
)

