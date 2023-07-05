;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use Motion)
(use Game)

(public
	rm66 0
)

(instance rm66 of Rm
	(properties
		picture 66
		style 8
		horizon 90
		north 56
		east 67
		south 75
		west 65
	)

	(method (dispose)
		(SetFlag 56)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(gEgo init:)
		(switch gPrevRoomNum
			(56
				(gEgo posn: 190 92 setMotion: MoveTo 190 190)
			)
			(67
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(65
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(75
				(gEgo posn: 200 188 setMotion: MoveTo 200 0)
			)
		)
	)
)

