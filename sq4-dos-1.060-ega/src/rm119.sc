;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 119)
(include sci.sh)
(use Main)
(use eRS)
(use Motion)
(use Actor)
(use System)

(public
	rm119 0
)

(instance rm119 of SQRoom
	(properties
		picture 119
	)

	(method (init)
		(Load rsVIEW 120)
		(gLongSong2 hold: 2)
		(if (== gPrevRoomNum 59)
			(ship x: 72 y: -1)
			(self setScript: flyInScript)
		else
			(ship x: 171 y: 52)
			(self setScript: flyOutScript)
		)
		(ship init: setCycle: Fwd)
		(super init:)
	)
)

(instance flyInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(ship loop: 0 setMotion: MoveTo 168 46 self)
			)
			(2
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance flyOutScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(++ register)
		(ship x: (- (ship x:) (/ register 4)))
		(ship y: (- (ship y:) (/ register 4)))
		(if (and (== state 1) (== (gLongSong prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(gLongSong2 stop:)
				(gLongSong prevSignal: 0)
				(-- register)
			)
			(1
				(gLongSong number: 74 loop: 1 vol: 127 playBed:)
				(ship loop: 1 setMotion: MoveTo 70 -3)
			)
			(2
				(gCurRoom newRoom: 72)
			)
		)
	)
)

(instance ship of Actor
	(properties
		yStep 4
		view 120
		signal 8192
		xStep 2
	)
)

