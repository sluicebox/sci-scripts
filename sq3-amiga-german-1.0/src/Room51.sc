;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
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
	Room51 0
)

(local
	local0
	local1
	local2
)

(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room51 of Rm
	(properties
		picture 51
	)

	(method (init)
		(= north 47)
		(= west 50)
		(= east 52)
		(= south 53)
		(= horizon 70)
		(= global109 1)
		(= global591 1)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(super init:)
		(= global116 0)
		(NormalEgo)
		(gEgo view: 0 init:)
		(lightning view: 69 loop: 4 cel: 0 posn: 114 53 setScript: flash init:)
		(switch gPrevRoomNum
			(47
				(= global104 2)
				(gEgo
					posn: 145 (+ horizon 2)
					setPri: 1
					view: 68
					looper: 0
					setStep: 1 1
					illegalBits: 0
				)
			)
			(50
				(switch global104
					(0
						(if (< (gEgo y:) 85)
							(gEgo
								posn: 1 90
								setPri: -1
								setStep: 3 2
								observeControl: 8192
							)
						else
							(gEgo
								posn: 1 (gEgo y:)
								setStep: 3 2
								setPri: -1
								observeControl: 8192
							)
						)
					)
					(1
						(gEgo
							view: 82
							looper: (ScriptID 501 1) ; DUNELOOPER
							posn: 1 108
							setPri: 1
							setStep: 1 1
							ignoreControl: 8192
						)
					)
					(2
						(gEgo
							view: 68
							posn: 1 80
							setStep: 1 1
							setPri: 1
							ignoreControl: 8192
						)
					)
				)
			)
			(52
				(switch global104
					(0
						(NormalEgo)
						(gEgo
							view: 0
							observeControl: 8192
							posn: 318 (gEgo y:)
						)
					)
					(1
						(gEgo
							view: 82
							ignoreControl: 8192
							posn: 318 119
							setStep: 1 1
							looper: (ScriptID 501 1) ; DUNELOOPER
							setPri: 1
						)
					)
					(2
						(gEgo
							view: 68
							posn: 318 80
							setStep: 1 1
							setPri: 1
							ignoreControl: 8192
						)
					)
				)
			)
			(53
				(NormalEgo)
				(gEgo view: 0 posn: (gEgo x:) 188 observeControl: 8192)
			)
		)
		(self setRegions: 501) ; regDune
		(switch global110
			(1
				(if (== (Random 1 3) 2)
					(= global111 (Actor new:))
					(global111 posn: 1000 1000 init:)
					(= global114 (Random 2 10))
				)
			)
			(2
				(= global111 (Actor new:))
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
			(= global112 127)
			(= global113 103)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 135)
				)
				(west
					(global111 posn: -40 116)
				)
				(south
					(global111 posn: 190 249)
				)
				(north
					(global111 posn: 127 103)
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1) ; regDune
		else
			((ScriptID 501 0) notify: 4) ; regDune
		)
		(gCurRoom setScript: Actions)
	)

	(method (newRoom newRoomNumber)
		(if (not gHandsOff)
			(NormalEgo)
			(DisposeScript 988)
			(if
				(and
					(gCast contains: global111)
					(< (gEgo distanceTo: global111) 120)
				)
				(= global110 2)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(super doit:)
		(if (!= gCurRoomNum gNewRoomNum)
			(return)
		)
		(= local0 (gEgo onControl: 0))
		(cond
			((and (== global116 2) (not (& local0 $0002)))
				(if (proc501_2 1)
					(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				)
				(= global116 0)
			)
			((and (== global116 4) (not (& local0 $0004)))
				(= global116 0)
				(gEgo ignoreControl: 4)
			)
			(
				(and
					(& local0 $0002)
					(== global104 0)
					(not gHandsOff)
					(not global116)
				)
				(= global104 1)
				(= global116 2)
				(= global112 (gEgo x:))
				(= global113 (gEgo y:))
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 400)
						(= local2 global107)
					else
						(= local1
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local2 ((gEgo mover:) x:))
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 82
					looper: (ScriptID 501 1) ; DUNELOOPER
					setStep: 2 1
					setMotion: MoveTo local2 local1
					setPri: 1
					ignoreControl: 8192
				)
			)
			(
				(and
					(& local0 $0002)
					(== global104 1)
					(not gHandsOff)
					(not global116)
				)
				(= global104 0)
				(= global116 2)
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 global108)
						(= local2 global107)
					else
						(= local1
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local2 ((gEgo mover:) x:))
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 0
					setStep: 3 2
					setMotion: MoveTo local2 local1
					setPri: -1
					observeControl: 8192
					looper: 0
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
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 global108)
						(= local2 global107)
					else
						(= local1
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local2 ((gEgo mover:) x:))
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo view: 68 posn: (gEgo x:) (- (gEgo y:) 2))
				(RedrawCast)
				(gEgo
					view: 68
					setStep: 1 1
					looper: 0
					illegalBits: 0
					observeControl: 4
					setMotion: MoveTo local2 local1
				)
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
				(if (IsObject (gEgo mover:))
					(if global108
						(= local1 -400)
						(= local2 global107)
					else
						(= local1
							(+
								(- (gEgo y:) ((gEgo mover:) y:))
								(gEgo y:)
							)
						)
						(= local2 ((gEgo mover:) x:))
					)
				else
					(= local1 (gEgo y:))
					(= local2 (gEgo x:))
				)
				(gEgo
					view: 82
					posn: (gEgo x:) (- (gEgo y:) 2)
					observeControl: 4
				)
				(RedrawCast)
				(gEgo
					looper: (ScriptID 501 1) ; DUNELOOPER
					setStep: 2 1
					illegalBits: -32768
					ignoreControl: 8192
					setMotion: MoveTo local2 local1
					setPri: 1
				)
			)
			(
				(and
					(!= global104 2)
					(== global116 0)
					(or
						(proc501_2 global109)
						(and
							(> (gEgo x:) 146)
							(< (gEgo x:) 179)
							(< (gEgo y:) 96)
						)
						(< (gEgo y:) 81)
					)
				)
				(= global104 1)
				(= local1 180)
				(= local2 (gEgo x:))
				(gEgo setPri: 2 posn: (gEgo x:) (+ (gEgo y:) 8))
				(RedrawCast)
				(gEgo
					posn: (gEgo x:) (+ (gEgo y:) 8)
					view: 82
					looper: (ScriptID 501 1) ; DUNELOOPER
					setStep: 2 1
					setMotion: MoveTo local2 local1
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
				(if (Said 'look,look>')
					(cond
						((Said '[<around,at,in][/area]')
							(Print 51 0) ; "You are surrounded by sand and rocks."
						)
						((Said '/cavity')
							(Print 51 1) ; "It's a hole all right."
						)
						((Said '/rock')
							(Print 51 2) ; "There are many rocks here."
						)
					)
				)
			)
		)
	)
)

(instance Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
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

