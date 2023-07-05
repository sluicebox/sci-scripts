;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 59)
(include sci.sh)
(use Main)
(use eRS)
(use MCyc)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm059 0
)

(local
	[local0 65] = [0 0 125 94 0 0 125 93 0 0 125 94 0 0 124 94 0 0 125 94 0 0 125 93 0 0 126 94 0 0 125 94 0 0 125 95 0 0 125 94 0 0 126 94 0 0 125 94 0 0 125 93 0 0 125 94 0 0 124 94 0 0 125 94 -32768]
)

(instance rm059 of SQRoom
	(properties
		picture 59
		style 10
	)

	(method (init)
		(HandsOff)
		(Load rsVIEW 22)
		(Load rsSOUND 110)
		(Load rsSCRIPT 942)
		(super init:)
		(self setScript: rmScript)
		(shipBlast init:)
		(switch gPrevRoomNum
			(72
				(ship posn: 126 256 init:)
			)
			(else
				(ship x: 29 y: -5 init:)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(proc0_14 12)
				(if (!= gPrevRoomNum 72)
					(gLongSong number: 801 loop: -1 vol: 127 flags: 1 playBed:)
					(shipBlast number: 109 loop: -1 vol: 127 play:)
				)
				(= cycles 1)
			)
			(2
				(ship setMotion: MoveTo 126 94 self)
			)
			(3
				(ship setCycle: MCyc @local0 self)
			)
			(4
				(if (== gPrevRoomNum 72)
					(ship setCycle: MCyc @local0 self)
				else
					(self cue:)
				)
			)
			(5
				(if (== gPrevRoomNum 72)
					(gEgo view: 0)
				)
				(shipBlast number: 110 loop: 1 flags: 1 play:)
				(ship
					cycleSpeed: 0
					setCycle: End
					setMotion: MoveTo 150 193 self
				)
			)
			(6
				(shipBlast stop:)
				(if (== gPrevRoomNum 72)
					(gCurRoom newRoom: 119)
				else
					(gCurRoom newRoom: 60)
				)
			)
		)
	)
)

(instance ship of Actor
	(properties
		yStep 3
		view 22
		signal 8192
		cycleSpeed 1
	)
)

(instance shipBlast of Sound
	(properties)
)

