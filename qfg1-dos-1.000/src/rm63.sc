;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Motion)
(use Game)

(public
	rm63 0
)

(instance rm63 of Rm
	(properties
		picture 701
		style 8
		horizon 90
		north 51
		east 64
		south 71
		west 62
	)

	(method (dispose)
		(SetFlag 53)
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
			(51
				(gEgo posn: 180 92 setMotion: MoveTo 180 190)
			)
			(62
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(64
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(71
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
			)
		)
		(self setRegions: 806) ; Cemetery
	)
)

