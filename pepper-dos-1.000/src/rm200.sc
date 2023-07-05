;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use ADRoom)
(use Scaler)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm200 0
	offScreenTalker 1
)

(instance rm200 of ADRoom
	(properties
		picture 200
		north 240
		east 230
		west 350
		vanishingY -100
	)

	(method (init)
		(super init: &rest)
		(Load rsSOUND 1500)
		(if (and (not (== gPrevRoomNum 212)) (not (== gPrevRoomNum 381)))
			(gEgo
				x: -30
				y: -30
				init:
				normalize:
				ignoreActors: 1
				setScale: Scaler 22 150 189 0
			)
			((ScriptID 895 1) x: -30 y: -30 init: setScale: Scaler 22 150 189 0) ; lockjaw
		)
		(switch gPrevRoomNum
			(381
				(gEgo
					init:
					normalize:
					view: 309
					setLoop: 0
					cel: 0
					x: 209
					y: 177
					setStep: 10 35
					ignoreActors: 1
					setScale: Scaler 22 200 180 36
				)
				((ScriptID 895 1) ; lockjaw
					init:
					normalize:
					view: 309
					setLoop: 1
					cel: 0
					x: 223
					y: 177
					setStep: 10 35
					ignoreActors: 1
					setScale: Scaler 22 200 180 36
				)
				(gCurRoom setScript: sTheyZoomOut)
			)
			(410
				(pigeon init:)
				(self setScript: sMansionToBen)
			)
			(321
				(pigeon init:)
				(self setScript: sBenToMansion)
			)
			(212
				(if (== (Random 1 10) 5)
					(flag y: 28)
					(flag2 y: 39)
				)
				(flag setCycle: Fwd init:)
				(flag2 setCycle: Fwd init:)
				(coach loop: 0 cel: 0 init:)
				(self setScript: overTheHills)
			)
			(else
				(self setScript: sFallFromSky)
			)
		)
	)
)

(instance sTheyZoomOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: Fwd)
				((ScriptID 895 1) setCycle: Fwd) ; lockjaw
				(= ticks 60)
			)
			(1
				(gLongSong2 number: 1500 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 0 14 self)
				((ScriptID 895 1) setMotion: MoveTo 0 48 self) ; lockjaw
			)
			(2 0)
			(3
				0
				(if (not ((ScriptID 895 1) mover:)) ; lockjaw
					((ScriptID 895 1) dispose:) ; lockjaw
				)
				(if (not ((ScriptID 895 0) mover:)) ; pepper
					((ScriptID 895 0) dispose:) ; pepper
				)
			)
			(4
				(gCurRoom newRoom: 140)
			)
		)
	)

	(method (doit)
		(if (and (== (gLongSong2 prevSignal:) -1) (== state 3))
			(self cue:)
		)
		(super doit:)
	)
)

(instance overTheHills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 215 setLoop: -1 play:)
				(= seconds 2)
			)
			(1
				(coach setCycle: End self)
			)
			(2
				(coach x: 36 y: 143 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 1 0 1 1 5 self) ; "ARF! ARF! ARF!"
			)
			(4
				(gLongSong2 number: 902 setLoop: 1 play: self)
				(gMessager say: 1 0 1 6 self) ; "<CHOMP!!!>"
			)
			(5)
			(6
				(gLongSong2 number: 2105 setLoop: 1 play: self)
				(gMessager say: 1 0 1 7 self) ; "YEEEEOWCH!"
			)
			(7)
			(8
				(coach x: 84 y: 126 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9
				(gLongSong fade:)
				(gCurRoom newRoom: 212)
			)
		)
	)
)

(instance sFallFromSky of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
				(gLongSong number: 200 setLoop: 1 play:)
				(gLongSong2 number: 1500 setLoop: 1 play: self)
			)
			(1
				(gEgo
					view: 155
					setLoop: 3
					setCycle: Fwd
					setMotion: JumpTo 140 170 self
				)
				(= ticks 5)
			)
			(2
				((ScriptID 895 1) ; lockjaw
					view: 155
					setCycle: Fwd
					setLoop: 4
					setMotion: JumpTo 140 170 gCurRoom
				)
			)
			(3)
			(4
				(gCurRoom newRoom: 214)
			)
		)
	)
)

(instance sBenToMansion of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(pigeon
					setLoop: 4
					posn: 214 39
					setCycle: Fwd
					setScale: Scaler 40 25 43 24
					setMotion: MoveTo 66 23 self
				)
			)
			(2
				(gLongSong fade:)
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 410)
			)
		)
	)
)

(instance sMansionToBen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 321 setLoop: -1 play:)
				(= cycles 1)
			)
			(1
				(pigeon
					setLoop: 3
					posn: 74 28
					setCycle: Fwd
					setScale: Scaler 40 25 43 24
					setMotion: MoveTo 214 47 self
				)
			)
			(2
				(gLongSong fade:)
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 321)
			)
		)
	)
)

(instance pigeon of Actor
	(properties
		view 200
		loop 4
	)
)

(instance coach of Prop
	(properties
		x 71
		y 154
		view 200
	)
)

(instance flag of Prop
	(properties
		x 82
		y 20
		view 200
		loop 3
	)
)

(instance flag2 of Prop
	(properties
		x 283
		y 29
		view 200
		loop 4
	)
)

(instance offScreenTalker of BalloonTalker
	(properties
		x 49
		y 120
		talkWidth 150
	)
)

