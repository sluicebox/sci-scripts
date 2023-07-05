;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room42 0
)

(local
	local0
)

(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room42 of Rm
	(properties
		picture 42
	)

	(method (init)
		(= east 43)
		(= south 46)
		(= west 41)
		(= north 54)
		(= horizon 94)
		(= global109 0)
		(= global591 0)
		(= global104 0)
		(super init:)
		(gEgo init:)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(lightning view: 69 loop: 6 cel: 0 posn: 123 59 setScript: flash init:)
		(switch gPrevRoomNum
			(41
				(NormalEgo)
				(= global104 0)
				(if (< (gEgo y:) (+ horizon 2))
					(gEgo posn: 1 (+ horizon 2))
				else
					(gEgo posn: 1 (gEgo y:))
				)
			)
			(46
				(NormalEgo)
				(= global104 0)
				(gEgo view: 0 posn: (gEgo x:) 188)
			)
			(43
				(NormalEgo)
				(gEgo view: 0 posn: 318 (gEgo y:))
			)
			(420
				(NormalEgo)
				(gLongSong number: 22 priority: 0 loop: -1 play:)
				(gEgo view: 0 loop: 1 posn: 266 107)
			)
			(54
				(gEgo posn: (gEgo x:) (+ horizon 2))
			)
			(421
				(gCurRoom setScript: festerOut)
			)
			(else
				(gEgo posn: 188 160 view: 0)
			)
		)
		(gEgo init:)
		(self setRegions: 501) ; regDune
		(switch global110
			(1
				(if (== (Random 1 4) 3)
					(Load rsVIEW 106)
					(= global111 (Act new:))
					(global111 posn: 1000 1000 init:)
					(= global114 (Random 2 12))
				)
			)
			(2
				(= global111 (Act new:))
				(global111 posn: 1000 1000 init:)
				(= global114 3)
			)
		)
		(cond
			((gCast contains: global111)
				(global111
					view: 106
					setCycle: Walk
					observeControl: 2
					posn: 1000 1000
					init:
				)
				(switch gPrevRoomNum
					(east
						(global111 posn: 359 167)
					)
					(west
						(global111 posn: -40 143)
					)
					(south
						(global111 posn: 160 249)
					)
					(north
						(global111 posn: 160 (+ horizon 2))
					)
				)
				(= global110 1)
				((ScriptID 501 0) notify: 1) ; regDune
			)
			((== (gCurRoom script:) 0)
				((ScriptID 501 0) notify: 4) ; regDune
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 420)
			(gLongSong fade:)
		)
		(if
			(and
				(gCast contains: global111)
				(< (gEgo distanceTo: global111) 120)
			)
			(= global110 2)
		)
		(if (not gHandsOff)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(if (& (gEgo onControl: 1) $0040)
			(gCurRoom newRoom: 420)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'read,look/sign')
					(cond
						((& (gEgo onControl: 0) $2000)
							(if
								(or
									(== (gEgo loop:) 0)
									(== (gEgo loop:) 2)
								)
								(Print 42 0 #mode 1 #at -1 100) ; "Mog: one of many large beasts that once roamed this vast desert. But they all eventually died of boredom and are now extinct."
							else
								(Print 42 1) ; "Try facing in the right direction."
							)
						)
						((& (gEgo onControl: 0) $1000)
							(if (!= (gEgo loop:) 3)
								(Print 42 1) ; "Try facing in the right direction."
							else
								(Print 42 2 #at -1 100) ; "See Phleebhut from Mog's Head Entrance Free. sorry.. temporarily closed for repair."
							)
						)
						(else
							(Print 42 3) ; "You're not close enough to read it."
						)
					)
				)
				((Said 'look>')
					(cond
						(
							(or
								(Said '/area')
								(Said '/around')
								(Said '[<around][/!*]')
							)
							(Print 42 4) ; "The desert to the north grows darker as storm clouds loom overhead. You find yourself at the base of a gigantic metal model of a great beast."
						)
						((Said '/feet,toe,leg')
							(Print 42 5) ; "Whoever built this thing did a thorough job. Right down to the polyfoam toejam."
						)
						((Said '/entrance,cavity')
							(Print 42 6) ; "You see an entrance to the inside of the foot near its north end."
						)
						((Said '/door,door')
							(Print 42 7) ; "The doorway leads to the interior of Mog."
						)
						((Said '/mog,animal')
							(Print 42 8) ; "Boy! It's a relief to know this baby is extinct."
						)
					)
				)
				((Said 'get,pull,hit/sign,mog')
					(Print 42 9) ; "Leave it alone."
				)
			)
		)
	)
)

(instance flash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 8 30))
			)
			(1
				(lightning cel: 255 setCycle: End self)
			)
			(2
				(lightning cel: 0)
				(= seconds (Random 2 5))
			)
			(3
				(thunder priority: 2 number: (Random 31 32) play: self)
			)
			(4
				(= state -1)
			)
		)
	)
)

(instance festerOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gLongSong number: 22 priority: 0 loop: -1 play:)
				(= local0 (Act new:))
				(local0
					view: 67
					setLoop: 0
					setCycle: Walk
					posn: 244 128
					setMotion: MoveTo 329 175 self
					init:
				)
				(NormalEgo)
				(gEgo view: 0 loop: 1 posn: 266 107 init:)
			)
			(1
				(local0 dispose:)
			)
		)
	)
)

