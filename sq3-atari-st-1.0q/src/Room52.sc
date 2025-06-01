;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
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
	Room52 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance puss of Prop
	(properties)
)

(instance mouth of Prop
	(properties)
)

(instance tongue of Prop
	(properties)
)

(instance slurp of Sound
	(properties)
)

(instance Room52 of Rm
	(properties
		picture 52
	)

	(method (init)
		(= north 48)
		(= west 51)
		(= east 49)
		(= south 53)
		(Load rsVIEW 78)
		(Load rsVIEW 122)
		(Load rsVIEW 777)
		(Load rsSOUND 82)
		(= global109 1)
		(= global591 1)
		(super init:)
		(= global116 0)
		(if (== global117 52)
			(= global127 (View new:))
			(global127
				view: 78
				setLoop: 8
				setCel: 255
				setPri: 5
				posn: 208 125
				init:
				stopUpd:
			)
		)
		(if (IsItemAt 16 52) ; Invisibility_Belt
			(= gView (View new:))
			(gView
				view: 120
				loop: 5
				cel: 0
				ignoreActors:
				posn: 209 128
				setPri: 6
				init:
				stopUpd:
			)
		)
		(NormalEgo)
		(puss
			view: 78
			loop: 0
			cel: 1
			posn: 204 50
			setPri: 7
			setCycle: Fwd
			init:
		)
		(mouth
			view: 777
			ignoreActors:
			loop: 0
			cel: 0
			posn: 207 48
			setPri: 9
			init:
		)
		(tongue
			view: 777
			loop: 0
			cel: 0
			ignoreActors:
			posn: 207 59
			setPri: 10
			init:
		)
		(gEgo init:)
		(switch gPrevRoomNum
			(48
				(= global104 2)
				(gEgo posn: 119 70 view: 68 setPri: 1 ignoreControl: 8192)
			)
			(53
				(NormalEgo)
				(gEgo
					view: 0
					posn: (gEgo x:) 188
					observeControl: 8192 4096
				)
			)
			(51
				(switch global104
					(0
						(gEgo
							posn: 1 (gEgo y:)
							setStep: 3 2
							observeControl: 8192 4096
							setPri: -1
						)
					)
					(1
						(gEgo
							posn: 1 113
							setStep: 2 1
							view: 82
							ignoreControl: 8192
							observeControl: 4096
							looper: (ScriptID 501 1) ; DUNELOOPER
							setPri: 1
						)
					)
					(2
						(gEgo
							view: 68
							posn: 1 85
							looper: 0
							ignoreControl: 8192 4096
							setStep: 1 1
							setPri: 1
						)
					)
				)
			)
			(49
				(gEgo
					view: 0
					observeControl: 8192 4096
					setStep: 3 2
					setPri: -1
				)
				(if (< (gEgo y:) 126)
					(gEgo posn: 314 102)
				else
					(gEgo posn: 318 (gEgo y:))
				)
			)
			(else
				(gEgo view: 0 posn: 160 160)
			)
		)
		(self setRegions: 501) ; regDune
		(switch global110
			(1
				(if (== (Random 1 2) 2)
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
				observeControl: 2 8192 4096
				posn: 1000 1000
				init:
			)
			(= global112 166)
			(= global113 105)
			(switch gPrevRoomNum
				(east
					(global111 posn: 359 152)
				)
				(west
					(global111 posn: -40 158)
				)
				(south
					(global111 posn: 218 249)
				)
				(north
					(global111 posn: 166 105)
				)
			)
			(= global110 1)
			((ScriptID 501 0) notify: 1) ; regDune
		)
	)

	(method (newRoom newRoomNumber)
		(if (not gHandsOff)
			(NormalEgo)
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
		(if
			(and
				(== global104 0)
				(gEgo inRect: 200 117 237 134)
				(== (gCurRoom script:) 0)
			)
			(self setScript: grab)
		)
		(if
			(and
				(gCast contains: global111)
				(global111 inRect: 200 117 237 134)
				(== (gCurRoom script:) 0)
			)
			(self script: grab)
			(grab changeState: 7)
		)
		(if (IsObject (gEgo mover:))
			(= local6 ((gEgo mover:) x:))
			(= local7 ((gEgo mover:) y:))
			(= local8 1)
		else
			(= local8 0)
		)
		(cond
			((& (= local0 (gEgo onControl: 0)) $0008)
				(gCurRoom newRoom: 48)
			)
			((and (== global116 2) (not (& local0 $0002)))
				(= global116 0)
				(if (proc501_2 1)
					(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				)
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
				(= global116 2)
				(= global104 1)
				(= global112 (gEgo x:))
				(= global113 (gEgo y:))
				(if local8
					(if global108
						(= local1 400)
						(= local2 global107)
					else
						(= local1 (+ (- (gEgo y:) local7) (gEgo y:)))
						(= local2 local6)
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
					setPri: 4
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
				(if local8
					(if global108
						(= local1 global108)
						(= local2 global107)
					else
						(= local1 (+ (- (gEgo y:) local7) (gEgo y:)))
						(= local2 local6)
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
				(if local8
					(if global108
						(= local1 global108)
						(= local2 global107)
					else
						(= local1 (+ (- (gEgo y:) local7) (gEgo y:)))
						(= local2 local6)
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
				(gEgo
					looper: 0
					setStep: 1 1
					setPri: 4
					ignoreControl: 4096
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
				(if local8
					(if global108
						(= local1 -400)
						(= local2 global107)
					else
						(= local1 (+ (- (gEgo y:) local7) (gEgo y:)))
						(= local2 local6)
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
					xStep: 2
					yStep: 1
					setMotion: MoveTo local2 local1
					setPri: 4
					observeControl: 4096
					ignoreControl: 8192
				)
			)
			(
				(and
					(or (== global104 0) (== global104 1))
					(== global116 0)
					(or (proc501_2 global109) (< (gEgo y:) 92))
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
					((Said 'look,explore/android,debris,heap')
						(cond
							((gCast contains: global127)
								(Print
									(Format ; "The terminator is now a pile of junk lying on the sand under the pustules. %s"
										@global402
										52
										0
										(if
											(and
												(IsItemAt 16 52) ; Invisibility_Belt
												(<
													(gEgo
														distanceTo: global127
													)
													60
												)
												(== global104 0)
											)
											{Looking closely, you notice that the terminator's invisibility belt has survived relatively intact.}
										else
											{}
										)
									)
								)
							)
							((gCast contains: global111)
								(Print 52 1) ; "All you see are footsteps."
							)
							(else
								(Print 52 2) ; "You don't see one here."
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
								(Print 52 3) ; "You see several large rocks here. One rock has a large overhang, and almost appears to be a cave. Under the overhang, you see several large, pulsating pods."
							)
							((Said '/leech')
								(Print 52 4) ; "For a brief moment, you could swear they were just a bunch of dancing raisins. But, a closer look indicates otherwise. The leech-like creatures appear to have connected themselves to this overhang with a gelatinous adhesive secretion. YUCK!"
							)
							((Said '/rock')
								(Print 52 5) ; "The most interesting rock here has a large overhang."
							)
							((Said '/overhang')
								(Print 52 6) ; "Underneath the top of the overhang, you see several large, pulsating pod-like pustules."
							)
						)
					)
					((Said 'talk/leech')
						(Print 52 7) ; "You talk to the pods, but all you get in return are some soft squishy sounds."
					)
					((Said 'hit,kill/leech')
						(Print 52 8) ; "You have no way of doing that."
					)
					((Said 'get/leech')
						(Print 52 9) ; "You can't reach them from here."
					)
					((Said 'climb/')
						(Print 52 10) ; "You don't like heights much."
					)
					(
						(or
							(Said 'get/belt/orat,stick')
							(Said 'use/stick,orat')
							(Said 'get<use<(stick,orat)/belt')
						)
						(cond
							((gEgo has: 16) ; Invisibility_Belt
								(Print 52 11) ; "You already have it."
							)
							((not (IsItemAt 16 52)) ; Invisibility_Belt
								(Print 52 2) ; "You don't see one here."
							)
							((not (gEgo has: 4)) ; Orat_on_a_Stick
								(Print 52 12) ; "You don't have the proper implement."
							)
							((!= global110 3)
								(Print 52 13) ; "The robot might have something to say about that."
							)
							(
								(or
									(not (gEgo inRect: 160 107 198 147))
									(!= global104 0)
								)
								(Print 52 14) ; "Try approaching from a slightly different angle."
							)
							(else
								(gCurRoom setScript: (ScriptID 520 0)) ; getBelt
							)
						)
					)
					((or (Said 'get/belt/pole') (Said 'use/pole'))
						(cond
							((gEgo has: 16) ; Invisibility_Belt
								(Print 52 11) ; "You already have it."
							)
							((not (IsItemAt 16 52)) ; Invisibility_Belt
								(Print 52 2) ; "You don't see one here."
							)
							((not (gEgo has: 9)) ; Metal_Pole
								(Print 52 12) ; "You don't have the proper implement."
							)
							((!= global110 3)
								(Print 52 13) ; "The robot might have something to say about that."
							)
							(
								(and
									(not (gEgo inRect: 200 117 237 134))
									(!= global104 0)
								)
								(Print 52 14) ; "Try approaching from a slightly different angle."
							)
							(else
								(gCurRoom setScript: (ScriptID 521 0)) ; getBeltPole
							)
						)
					)
					((Said 'get/belt')
						(if (IsItemAt 16 52) ; Invisibility_Belt
							(Print 52 15) ; "Get closer."
						else
							(Print 52 2) ; "You don't see one here."
						)
					)
					((Said '/ladder')
						(DontHave) ; "You don't have it."
					)
				)
			)
		)
	)
)

(instance grab of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 0)
				(HandsOff)
				(if (gCast contains: global111)
					((ScriptID 501) notify: 2) ; regDune
				)
				(= global116 9999)
				(slurp number: 82 priority: 3 loop: 1 play:)
				(mouth
					view: 78
					setLoop: 1
					cel: 255
					x: (gEgo x:)
					setCycle: End self
				)
			)
			(1
				(tongue view: 78 setLoop: 2 x: (gEgo x:) show:)
				(gEgo
					view: 78
					setLoop: 3
					setCycle: Fwd
					setPri: 8
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 109 self
				)
			)
			(2
				(tongue setCel: 1)
				(gEgo setMotion: MoveTo (gEgo x:) 92 self)
			)
			(3
				(tongue view: 777 loop: 0)
				(gEgo setMotion: MoveTo (gEgo x:) 78 self)
				(= local5 (Act new:))
				(local5 view: 777 loop: 0 init:)
			)
			(4
				(gEgo view: 777 loop: 0)
				(mouth setLoop: 4 setCycle: Fwd)
				(local5
					view: 78
					setLoop: 5
					ignoreActors:
					illegalBits: 0
					posn: (gEgo x:) 67
					setPri: 8
					setStep: 1 4
					setMotion: MoveTo (gEgo x:) 129 self
				)
				(+= local3 1)
			)
			(5
				(if (<= local3 6)
					(= state 3)
					(= cycles 2)
				else
					(local5 dispose:)
					(self changeState: 6)
				)
			)
			(6
				(EgoDead 901 1 0 999) ; "Thanks for playing Space Quest ]I[. As usual, you've been a real hoot."
			)
			(7
				(HandsOff)
				(global111 ignoreActors: setMotion: 0)
				(mouth
					view: 78
					setLoop: 1
					cel: 255
					x: (global111 x:)
					setCycle: End self
				)
			)
			(8
				(tongue view: 78 setLoop: 2 cel: 0 x: (global111 x:))
				(= global127 (Act new:))
				(global127
					view: 78
					posn: (global111 x:) (global111 y:)
					setLoop: 6
					setCycle: Fwd
					setPri: 8
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo (global111 x:) 109 self
					init:
				)
				((ScriptID 501) notify: 2) ; regDune
			)
			(9
				(tongue setCel: 1)
				(global127 setMotion: MoveTo (global127 x:) 92 self)
			)
			(10
				(tongue view: 777 loop: 0)
				(global127 setMotion: MoveTo (global127 x:) 78 self)
			)
			(11
				(global127 view: 777 loop: 0)
				(mouth setLoop: 7 setCel: 0)
				(= seconds 3)
			)
			(12
				(mouth setCel: 1)
				(= cycles 2)
			)
			(13
				(cond
					((>= (global127 x:) 230)
						(= local2 230)
					)
					((<= (global127 x:) 208)
						(= local2 208)
					)
					(else
						(= local2 (global127 x:))
					)
				)
				(global127
					view: 78
					posn: (global127 x:) 72
					setLoop: 8
					setCel: 0
					setStep: 1 6
					setMotion: MoveTo local2 125 self
				)
			)
			(14
				(mouth view: 777 loop: 0)
				(gGame changeScore: 45)
				(global127 setCel: -1 setPri: 5 setCycle: End self)
			)
			(15
				(HandsOn)
				(= gView (View new:))
				(gView
					view: 78
					loop: 9
					cel: 1
					setPri: 6
					posn: (global127 x:) (+ (global127 y:) 3)
					init:
				)
				(= global110 3)
				(= global117 52)
				(PutItem 16 52) ; Invisibility_Belt
				(gCurRoom setScript: 0)
			)
		)
	)
)

