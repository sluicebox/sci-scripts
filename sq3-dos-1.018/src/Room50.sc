;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use regDune)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room50 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room50 of Rm
	(properties
		picture 50
	)

	(method (init)
		(= east 51)
		(= west 49)
		(= south 53)
		(= north 47)
		(= global109 1)
		(= global591 1)
		(= global116 0)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(gEgo view: 0 init:)
		(lightning view: 69 loop: 4 cel: 0 posn: 185 58 setScript: flash init:)
		(switch gPrevRoomNum
			(46
				(= global104 2)
				(gEgo
					posn: 186 67
					view: 68
					looper: 0
					setPri: 1
					setStep: 1 1
					ignoreControl: 8192
				)
			)
			(49
				(gEgo observeControl: 8192)
				(if (and (> (gEgo y:) 146) (< (gEgo y:) 155))
					(gEgo posn: 1 144)
				else
					(gEgo posn: 1 (gEgo y:))
				)
			)
			(51
				(switch global104
					(1
						(gEgo
							view: 82
							posn: 317 (gEgo y:)
							ignoreControl: 8192
							setStep: 1 1
							setPri: 1
						)
					)
					(2
						(gEgo
							view: 68
							posn: 317 (gEgo y:)
							setStep: 1 1
							setPri: 1
						)
					)
					(0
						(gEgo
							view: 0
							posn: 317 (gEgo y:)
							setStep: 3 2
							observeControl: 8192
							setPri: -1
						)
					)
				)
			)
			(53
				(NormalEgo)
				(gEgo view: 0 posn: (gEgo x:) 188 observeControl: 8192)
			)
			(else
				(gEgo posn: 180 98 observeControl: 8192)
			)
		)
		(self setRegions: 501) ; regDune
		(switch global110
			(1
				(if (== (Random 1 3) 2)
					(= global111 (Act new:))
					(global111 posn: 1000 1000 init:)
					(= global114 (Random 2 10))
				)
			)
			(2
				(= global111 (Act new:))
				(global111 posn: 1000 1000 init:)
				(= global114 3)
			)
		)
		(if (gCast contains: global111)
			(global111
				view: 106
				setCycle: Walk
				observeControl: 2 8192
				posn: 1000 1000
				init:
			)
			(= global112 176)
			(= global113 85)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 117)
				)
				(west
					(global111 posn: -40 117)
				)
				(south
					(global111 posn: 160 249)
				)
				(north
					(global111 posn: 176 85)
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1) ; regDune
		else
			((ScriptID 501 0) notify: 4) ; regDune
		)
		(gEgo observeControl: 1024)
	)

	(method (newRoom newRoomNumber)
		(NormalEgo)
		(DisposeScript 988)
		(if
			(and
				(gCast contains: global111)
				(< (gEgo distanceTo: global111) 85)
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
		(= local0 (gEgo onControl: 0))
		(if (IsObject (gEgo mover:))
			(= local3 ((gEgo mover:) x:))
			(= local4 ((gEgo mover:) y:))
			(= local5 1)
		else
			(= local5 0)
		)
		(cond
			((and (== global116 2) (not (& local0 $0002)))
				(= global116 0)
				(if (proc501_2 1)
					(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				)
			)
			((and (== global116 4) (not (& local0 $0004)))
				(gEgo ignoreControl: 4)
				(= global116 0)
			)
			(
				(and
					(& local0 $0002)
					(== global104 0)
					(not gHandsOff)
					(not global116)
				)
				(= global116 2)
				(= global104 1)
				(= global112 (gEgo x:))
				(= global113 (gEgo y:))
				(if local5
					(if global108
						(= local1 400)
						(= local2 global107)
					else
						(= local1 (+ (- (gEgo y:) local4) (gEgo y:)))
						(= local2 local3)
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 82
					looper: (ScriptID 501 1) ; DUNELOOPER
					xStep: 2
					yStep: 1
					setMotion: MoveTo local2 local1
					setPri: 1
					ignoreControl: 8192
				)
			)
			((and (& local0 $0010) (== global104 2))
				(gCurRoom newRoom: 46)
			)
			(
				(and
					(& local0 $0002)
					(== global104 1)
					(not gHandsOff)
					(not global116)
				)
				(= global116 2)
				(= global104 0)
				(if local5
					(if global108
						(= local1 global108)
						(= local2 global107)
					else
						(= local1 (+ (- (gEgo y:) local4) (gEgo y:)))
						(= local2 local3)
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 0
					xStep: 3
					yStep: 2
					looper: 0
					setMotion: MoveTo local2 local1
					setPri: -1
					observeControl: 8192
					moveSpeed: 0
				)
			)
			(
				(and
					(== global104 1)
					(& local0 $0004)
					(not gHandsOff)
					(not global116)
				)
				(= global116 4)
				(= global104 2)
				(if local5
					(if global108
						(= local1 global108)
						(= local2 global107)
					else
						(= local1 (+ (- (gEgo y:) local4) (gEgo y:)))
						(= local2 local3)
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 68
					posn: (gEgo x:) (- (gEgo y:) 3)
					observeControl: 4
				)
				(RedrawCast)
				(gEgo looper: 0 setStep: 1 1 setMotion: MoveTo local2 local1)
			)
			(
				(and
					(== global104 2)
					(& local0 $0004)
					(not gHandsOff)
					(not global116)
				)
				(= global116 4)
				(= global104 1)
				(if local5
					(if global108
						(= local1 -400)
						(= local2 global107)
					else
						(= local1 -400)
						(= local2 local3)
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 82
					posn: (gEgo x:) (- (gEgo y:) 3)
					observeControl: 4
				)
				(RedrawCast)
				(gEgo
					looper: (ScriptID 501 1) ; DUNELOOPER
					setStep: 2 1
					setMotion: MoveTo local2 local1
					setPri: 1
					ignoreControl: 8192
				)
			)
			(
				(and
					(!= global104 2)
					(== global116 0)
					(or
						(proc501_2 global109)
						(and (> (gEgo x:) 217) (< (gEgo y:) 80))
						(and
							(> (gEgo x:) 87)
							(< (gEgo x:) 108)
							(< (gEgo y:) 60)
						)
						(< (gEgo y:) 54)
					)
				)
				(= global104 1)
				(= local1 180)
				(= local2 (gEgo x:))
				(gEgo setPri: 1 posn: (gEgo x:) (+ (gEgo y:) 8))
				(RedrawCast)
				(gEgo
					view: 82
					looper: (ScriptID 501 1) ; DUNELOOPER
					xStep: 2
					yStep: 1
					setMotion: MoveTo local2 local1
					ignoreControl: 8192
				)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 5])
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							(
								(or
									(Said '/area')
									(Said '/around')
									(Said '[<around][/!*]')
								)
								(Print 50 0) ; "Strange rock formations rise up from the sand dunes. "What a desolate place this is," you think to yourself."
							)
							((Said '/rock')
								(Print 50 1) ; "This has got to be the strangest array of rock formations you've ever seen."
							)
							((Said '/dune')
								(Print 50 2) ; "The dunes rise and fall across the horizon with all the curves of a beautiful moon maiden."
							)
							((Said '/cavity')
								(Print 50 3) ; "You see a hole through one of the rocks."
							)
						)
					)
					((Said '/cavity')
						(Print 50 4) ; "In this day and age it would be wise to leave alien holes alone."
					)
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

