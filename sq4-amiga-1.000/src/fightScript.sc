;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 151)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use PolyPath)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	fightScript 0
	endFightScript 1
)

(local
	local0
	local1
	local2
	local3 = 50
	local4
	local5
	local6
	[local7 8] = [161 189 186 154 120 91 89 118]
	[local15 8] = [119 107 80 67 61 79 107 126]
	[local23 10] = [361 353 307 267 246 173 126 85 64 0]
	[local33 9] = [5 4 3 2 1 0 7 6 5]
	[local42 9] = [1 0 7 6 5 4 3 2 1]
	[local51 8] = [2 2 1 1 3 3 0 0]
	[local59 8] = [6 6 5 5 7 7 4 4]
	[local67 8] = [5 -5 0 0 -5 5 5 0]
	[local75 8] = [5 5 0 -5 -5 -5 0 0]
)

(procedure (localproc_0 param1 param2)
	(if (not ((ScriptID 150 1) mover:)) ; RogerJr
		(gEgo view: 526 setCycle: Walk)
		((ScriptID 150 1) view: 527 setCycle: Walk) ; RogerJr
		(cond
			((== param1 0)
				(if (> (++ local5) 7)
					(= local5 0)
				)
			)
			((< (-- local5) 0)
				(= local5 7)
			)
		)
		(param2 cue:)
	)
)

(instance fightScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self addToFront: (ScriptID 150 1)) ; RogerJr
		(= local1 1)
		(= local5 0)
		(= local6 4)
		(LoadMany rsVIEW 523 524 525 526 527 528)
		(gLongSong number: 868 vol: 127 loop: -1 play:)
		(gTheIconBar curIcon: (gTheIconBar at: 0))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self delete: (ScriptID 150 1)) ; RogerJr
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if local0
			(cond
				((== (event type:) evMOUSEBUTTON)
					(= temp0 (OnControl CONTROL (event x:) (event y:)))
					(= temp1 (OnControl CONTROL (gEgo x:) (gEgo y:)))
					(cond
						(
							(or
								(== temp0 (* temp1 2))
								(and (== temp0 8) (== temp1 1024))
							)
							(localproc_0 0 self)
						)
						(
							(or
								(== temp0 (/ temp1 2))
								(and (== temp0 1024) (== temp1 8))
							)
							(localproc_0 1 self)
						)
					)
				)
				(
					(and
						(& (event type:) $0040) ; direction
						(== (gEgo view:) 526)
						(not (gEgo mover:))
					)
					(switch (event message:)
						(JOY_UP
							(= register 1)
							(self changeState: 3)
							(= local1 0)
						)
						(JOY_RIGHT
							(localproc_0 0 self)
						)
						(JOY_LEFT
							(localproc_0 1 self)
						)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(cond
			(script)
			((and (< (gEgo distanceTo: (ScriptID 150 1)) 15) (< state 4)) ; RogerJr
				(self setScript: struggleScript self)
			)
			((== (gEgo view:) 526)
				(if (gEgo mover:)
					(= temp0 (GetAngle (gEgo x:) (gEgo y:) 137 89))
					(for ((= temp1 0)) (< temp0 [local23 temp1]) ((++ temp1))
					)
					(-- temp1)
					(gEgo setLoop: [local33 temp1])
					((ScriptID 150 1) setLoop: [local42 temp1]) ; RogerJr
				)
				(if (< (-- local3) 1)
					(= register 0)
					(self changeState: 3)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 526 setLoop: 3)
				(= cycles 1)
			)
			(1
				(= local0 1)
				(gCurRoom notify: 1)
			)
			(2
				(if (> (= local6 (+ local5 4)) 7)
					(-= local6 8)
				)
				(gEgo setMotion: MoveTo [local7 local5] [local15 local5])
				((ScriptID 150 1) ; RogerJr
					setMotion: MoveTo [local7 local6] [local15 local6]
				)
				(self changeState: 1)
			)
			(3
				(if register
					(gEgo
						view: 524
						setMotion:
							MoveTo
							((ScriptID 150 1) x:) ; RogerJr
							((ScriptID 150 1) y:) ; RogerJr
					)
				)
				((ScriptID 150 1) ; RogerJr
					view: 525
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
			)
			(4
				(if (== local4 5)
					(= cycles 1)
				else
					(= local3 (Random 50 100))
					(self changeState: 1)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance struggleScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local0 0)
				(gCurRoom notify: 0)
				(= temp0 (+ (gEgo x:) [local67 (gEgo loop:)]))
				(= temp1 (+ (gEgo y:) [local75 (gEgo loop:)]))
				(gEgo
					view: 523
					posn: temp0 temp1
					setCel: 0
					setCycle: CT (Random 3 7) 1 self
					setMotion: 0
				)
				((ScriptID 150 1) setMotion: 0 hide:) ; RogerJr
			)
			(1
				(= cycles (Random 1 5))
			)
			(2
				(gEgo setCycle: CT (Random 0 2) -1 self)
			)
			(3
				(if (== (++ local4) 5)
					(gEgo setLoop: 4)
					((ScriptID 150 1) setLoop: 0) ; RogerJr
					(= local5 0)
					(= local6 4)
				)
				(= cycles (Random 1 5))
			)
			(4
				(gEgo setCycle: CT (Random 3 7) 1 self)
			)
			(5
				(= register
					(if (== local4 5)
						0
					else
						(Random 0 1)
					)
				)
				(= temp0 (- (gEgo x:) [local67 (gEgo loop:)]))
				(= temp1 (- (gEgo y:) [local75 (gEgo loop:)]))
				(if register
					((ScriptID 150 1) ; RogerJr
						view: 525
						setLoop: [local42 (+ local5 1)]
						show:
						setCycle: Rev
						setMotion: MoveTo [local7 local6] [local15 local6] self
					)
					(gEgo
						view: 528
						posn: temp0 temp1
						setLoop: [local51 (gEgo loop:)]
						setCel: 0
						cycleSpeed: 1
						setCycle: CT 2 1 self
					)
				else
					(= temp2 (if (== local4 5) 0 else local5))
					(gEgo
						view: 524
						setLoop:
							(if (== local4 5) 4 else [local33 (+ local5 1)])
						setCycle: Rev
						setMotion: MoveTo [local7 temp2] [local15 temp2] self
					)
					((ScriptID 150 1) ; RogerJr
						view: 528
						setLoop: [local59 ((ScriptID 150 1) loop:)] ; RogerJr
						setCel: 0
						show:
						cycleSpeed: 1
						setCycle: CT 2 1 self
					)
				)
			)
			(6
				(= cycles 4)
			)
			(7
				(if (and local1 register)
					(if local2
						(gDirectionHandler delete: client)
						(gMouseDownHandler delete: client delete: (ScriptID 150 1)) ; RogerJr
						(client setScript: fallScript)
					else
						(Print 151 0) ; "Whew! You were nearly thrown off the edge of the platform! Be more careful!"
						(= local2 1)
					)
				)
				(if register
					(gEgo setCycle: End)
				else
					((ScriptID 150 1) setCycle: End) ; RogerJr
				)
			)
			(8
				(if register
					((ScriptID 150 1) view: 527 setCycle: Walk) ; RogerJr
					(gEgo
						view: 524
						setLoop: [local33 (+ local5 1)]
						cycleSpeed: 0
						setCycle: Rev
						setMotion: MoveTo [local7 local5] [local15 local5] self
					)
				else
					(gEgo view: 526 setCycle: Walk)
					((ScriptID 150 1) ; RogerJr
						view: 525
						setLoop: [local42 (+ local5 1)]
						cycleSpeed: 0
						setMotion: 0
					)
					(if (not (== local4 5))
						((ScriptID 150 1) ; RogerJr
							setCycle: Rev
							setMotion:
								MoveTo
								[local7 local6]
								[local15 local6]
								self
						)
					else
						((ScriptID 150 1) ; RogerJr
							setCycle: Walk
							setMotion: MoveTo 145 105 self
						)
					)
				)
			)
			(9
				(if (not (== local4 5))
					(if register
						(gEgo view: 526 setCycle: Walk)
					else
						((ScriptID 150 1) view: 527 setCycle: Walk) ; RogerJr
					)
					(= local1 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance endFightScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 150 2) setMotion: MoveTo 120 98 (ScriptID 150 2)) ; diskDrive, diskDrive
				(= local3 1000)
			)
			(1
				(gLongSong2 number: 848 vol: 127 loop: -1 play:)
				(beam init: setCycle: Fwd)
				(brain
					makePolygon:
						127
						101
						121
						103
						112
						96
						111
						91
						111
						87
						113
						80
						115
						2
						169
						2
						162
						81
						160
						88
						158
						95
						149
						100
						142
						102
				)
				(= cycles 6)
			)
			(2
				((ScriptID 150 1) setCycle: Walk setMotion: MoveTo 145 105 self) ; RogerJr
			)
			(3
				(Print 151 1) ; "Is that the best effort you can muster? All this space hero nonsense must be getting to you. You're getting OLD, Roger! I, on the other hand, am enjoying the physical joys of youth."
				(= cycles 1)
			)
			(4
				(gEgo
					setCycle: Walk
					setMotion:
						PolyPath
						((ScriptID 150 1) x:) ; RogerJr
						(+ ((ScriptID 150 1) y:) 7) ; RogerJr
						self
				)
			)
			(5
				((ScriptID 150 1) hide:) ; RogerJr
				(gEgo view: 523 setCycle: Fwd)
				(= cycles 5)
			)
			(6
				(gEgo view: 524 setCycle: Walk)
				((ScriptID 150 1) ; RogerJr
					view: 528
					posn: 139 91
					setLoop: 6
					setCel: 0
					show:
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
			)
			(7
				((ScriptID 150 1) ; RogerJr
					view: 522
					setLoop: 1
					setCel: 5
					setCycle: Beg self
				)
			)
			(8
				((ScriptID 150 1) ; RogerJr
					setLoop: 0
					setPri: 4
					posn: 127 39
					cycleSpeed: 0
					setCycle: Fwd
				)
				(beam dispose:)
				(gLongSong2 stop:)
				(gEgo
					view: 3
					setCycle: StopWalk 510
					headView: 510
					setLoop: -1
					setPri: -1
					normal: 1
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond
					((< (gEgo y:) 95)
						(= temp0 1)
					)
					((< (gEgo x:) 95)
						(= temp0 12)
					)
					(else
						(= temp0 3)
					)
				)
				(gEgo
					setStep: (gEgo xStep:) 19
					setPri: temp0
					setMotion: MoveTo (gEgo x:) 300 self
				)
			)
			(1
				(EgoDead)
			)
		)
	)
)

(instance beam of Prop
	(properties
		x 127
		y 39
		view 522
		loop 5
		priority 4
		signal 16400
	)
)

