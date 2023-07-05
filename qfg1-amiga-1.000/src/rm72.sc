;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Motion)
(use Game)

(public
	rm72 0
)

(instance rm72 of Rm
	(properties
		picture 700
		style 8
		horizon 90
		north 64
		east 73
		south 79
		west 71
	)

	(method (dispose)
		(SetFlag 62)
		(super dispose:)
	)

	(method (init)
		(if gNight
			(Load rsSCRIPT 805)
		)
		(super init: &rest)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(gEgo init:)
		(if gNight
			(switch (Random 1 5)
				(1
					((ScriptID 805 5) init: setScript: (ScriptID 805 0)) ; twister, twistIt
				)
				(2
					((ScriptID 805 6) init: setScript: (ScriptID 805 1)) ; tumbler, spinAcross
				)
				(3
					((ScriptID 805 7) init: setScript: (ScriptID 805 4)) ; swimmer, swimLeft
				)
				(4
					((ScriptID 805 5) init: setScript: (ScriptID 805 0)) ; twister, twistIt
				)
				(5
					((ScriptID 805 7) init: setScript: (ScriptID 805 3)) ; swimmer, swimRight
				)
			)
		)
		(switch gPrevRoomNum
			(64
				(gEgo posn: 140 92 setMotion: MoveTo 140 190)
			)
			(71
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(79
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
			)
			(73
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
		)
		(self setRegions: 806) ; Cemetery
	)
)

