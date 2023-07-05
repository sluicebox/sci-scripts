;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 231)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use PolyPath)
(use StopWalk)
(use Sound)
(use Motion)

(public
	exitNorth 0
	exitFromHouse 1
	enterFromNorth 2
	enterFromHouse 4
)

(instance exitNorth of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 231)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: 3
					setLoop: 3
					setCycle: Fwd
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20) self
				)
			)
			(1
				(gEgo ignoreActors: 0 normal: 0 setCycle: 0)
				(= ticks 1)
			)
			(2
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance exitFromHouse of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(sfx dispose:)
		(DisposeScript 231)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 230 1) startUpd:) ; door
				(= cycles 1)
			)
			(1
				(gEgo
					setPri: 3
					ignoreActors: 1
					posn: 146 84
					setCycle: StopWalk
					init:
				)
				(gCast delete: gEgo addToFront: gEgo)
				(sfx number: 104 play:)
				((ScriptID 230 1) setCycle: End self) ; door
			)
			(2
				(gEgo setMotion: MoveTo 140 88 self)
			)
			(3
				(gEgo setPri: -1 setMotion: MoveTo 104 88 self)
			)
			(4
				(gEgo ignoreActors: 0)
				(sfx number: 103 play:)
				((ScriptID 230 1) setCycle: Beg self) ; door
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance enterFromNorth of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 231)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 230 2) ignoreActors: 1) ; bookWyrm
				(gEgo
					normal: 0
					posn: 95 102
					setLoop: 2
					setPri: 3
					ignoreActors: 1
					hide:
				)
				(= cycles 1)
			)
			(1
				(gEgo setCycle: Fwd init: setMotion: MoveTo 95 86 self)
				(gCast delete: gEgo addToFront: gEgo)
				(if (= global224 (proc10_17 InvFriend))
					(= global224 (global224 regActor:))
					(global224
						ignoreActors: 1
						x: 88
						y: 105
						setPri: 2
						setLoop: 2
						init:
						setCycle: Fwd
						setMotion: MoveTo 88 88
					)
				)
			)
			(2
				((ScriptID 230 3) cel: 1) ; wyrmHead
				(gEgo setPri: -1 normal: 1 setMotion: PolyPath 102 100 self)
				(if global224
					(global224
						setLoop: -1
						ignoreActors: 0
						setPri: -1
						setCycle: StopWalk
						setMotion: NPFollow gEgo 40
					)
				)
			)
			(3
				(NormalEgo 5 global139)
				((ScriptID 230 2) ignoreActors: 0) ; bookWyrm
				(self dispose:)
			)
		)
	)
)

(instance enterFromHouse of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 231)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 5 global139)
				(gEgo setCycle: StopWalk posn: 132 89 init:)
				(gCast delete: gEgo addToFront: gEgo)
				(= ticks 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 1
		number 104
	)
)

