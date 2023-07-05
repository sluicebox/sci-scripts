;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 752)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	throwDazzle 0
	geniePoofIn 1
	geniePoofOut 2
)

(local
	[local0 8] = [9 10 11 -1 11 12 13 14]
	[local8 8] = [85 85 85 85 85 85 85 88]
	[local16 8] = [1 0 -1 0 1 0 1 0]
)

(instance throwDazzle of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 [temp3 100])
		(switch (= state newState)
			(0
				(if (not global106)
					(= global106 gEgo)
				)
				(if (== global106 gEgo)
					(gGame handsOff:)
				)
				(Load rsSOUND 708)
				(Load rsSOUND 707)
				(= cycles 4)
			)
			(1
				(= temp2
					(GetAngle
						(register x:)
						(register y:)
						(global106 x:)
						(global106 y:)
						60
					)
				)
				(register
					loop:
						(cond
							((<= 338 temp2 23) 3)
							((<= 23 temp2 75) 6)
							((<= 75 temp2 105) 0)
							((<= 105 temp2 158) 4)
							((<= 158 temp2 203) 2)
							((<= 203 temp2 255) 5)
							((<= 255 temp2 285) 1)
							(else 7)
						)
				)
				(UnLoad 128 (register view:))
				(= temp0 (- (NumCels register) 1))
				(register cel: temp0)
				(SetNowSeen register)
				(if (!= (register loop:) 3)
					(projectile
						priority: (register priority:)
						y:
							(-
								(register nsBottom:)
								(/
									(*
										[local8 (register loop:)]
										(-
											(register nsBottom:)
											(register nsTop:)
										)
									)
									100
								)
							)
						setLoop: [local0 (register loop:)]
					)
					(projectile
						x:
							(if (>= [local16 (register loop:)] 0)
								(if [local16 (register loop:)]
									(register nsRight:)
								else
									(register nsLeft:)
								)
							else
								(register x:)
							)
					)
				)
				(register cel: 0 setCycle: End self)
				(if (!= (gGlobalSound2 number:) 707)
					(gGlobalSound2 number: 0 stop:)
					(gGlobalSound2 number: 707 setLoop: 1 play:)
				)
			)
			(2
				(global106 setMotion: 0 stopUpd:)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 708 setLoop: 1 play:)
				(if (!= (register loop:) 3)
					(= temp1
						(-
							(global106 y:)
							(/ (* 75 (- (global106 y:) (global106 nsTop:))) 100)
						)
					)
					(= temp0 (global106 x:))
					(projectile
						init:
						setCycle: Fwd
						setMotion: MoveTo temp0 temp1 self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if (!= (register loop:) 3)
					(gGlobalSound2 number: 0 stop:)
					(gGlobalSound2 number: 709 setLoop: 1 play:)
					(projectile loop: 15 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(4
				(if (== global106 gEgo)
					(gGlobalSound2 number: 0 stop:)
					(gGlobalSound number: 705 setLoop: 1 play:)
				)
				(projectile dispose:)
				(cond
					((IsObject global156)
						(self setScript: global156 self)
						(= global156 0)
					)
					((== global106 gEgo)
						(gGlobalSound client: self)
						(self setScript: getEgo 0 caller)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(register setCycle: Beg self)
			)
			(6
				(= cycles 3)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance getEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 749
					normal: 0
					cel: 0
					loop: (mod (gEgo cel:) 4)
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(1
				(gEgo
					loop:
						(switch (gEgo loop:)
							(0 3)
							(1 2)
							(2 1)
							(3 0)
						)
				)
				(gEgo setCycle: End self)
			)
			(2
				(if (> (gEgo loop:) 2)
					(gEgo
						loop: (+ 4 (== (gEgo loop:) 3))
						cycleSpeed: 10
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if register
					(self dispose:)
				else
					(EgoDead 18) ; "Genie, meenie, minie, moe...Alexander can't be slow!"
				)
			)
		)
	)
)

(instance geniePoofIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 943)
				(= cycles 2)
			)
			(1
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 943 setLoop: 1 play:)
				(smoke
					scaleSignal: 1
					scaleX: (register scaleX:)
					scaleY: (register scaleY:)
					priority: (register priority:)
					posn: (register x:) (+ (register y:) 1) 1
					init:
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(2
				(register init: show:)
				(smoke cycleSpeed: 10 setCycle: End self)
			)
			(3
				(smoke dispose:)
				(= cycles 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance geniePoofOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 943 setLoop: 1 play:)
				(smoke
					scaleSignal: 1
					scaleX: (register scaleX:)
					scaleY: (register scaleY:)
					priority: (register priority:)
					posn: (register x:) (+ (register y:) 1) 1
					init:
					setCycle: CT 2 1 self
				)
			)
			(2
				(register hide:)
				(smoke setCycle: End self)
			)
			(3
				(smoke dispose:)
				(= cycles 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		view 7501
		signal 16400
		cycleSpeed 8
	)
)

(instance projectile of Actor
	(properties
		yStep 7
		loop 9
		signal 24592
		cycleSpeed 3
		xStep 7
		moveSpeed 0
	)

	(method (init)
		(if (== gCurRoomNum 740)
			(= view 7021)
		else
			(= view 702)
		)
		(super init: &rest)
	)
)

