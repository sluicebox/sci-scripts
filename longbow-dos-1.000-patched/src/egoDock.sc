;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 704)
(include sci.sh)
(use Main)
(use n013)
(use PolyPath)
(use Motion)
(use System)

(public
	egoDock 0
	cantGoThere 1
	climbGoThere 2
	getOffVines 3
)

(local
	[local0 6] = [0 7 7 7 7 2]
	[local6 6] = [2 4 3 2 4 0]
	[local12 6] = [146 143 143 143 138 142]
	[local18 6] = [154 144 145 153 148 150]
	local24
)

(instance egoDock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (>= (gEgo x:) 160)
					(gEgo setMotion: MoveTo 110 165 self)
				else
					(self cue:)
				)
			)
			(1
				(if (<= 45 (gEgo heading:) 135)
					(self cue:)
				else
					(gEgo setHeading: 90)
					(= ticks 36)
				)
			)
			(2
				(gEgo
					setLoop: 0
					looper: 0
					setCel: 0
					setCycle: End
					setMotion: MoveTo 148 146 self
				)
			)
			(3
				(= ticks 12)
			)
			(4
				((ScriptID 700 3) ; theBoat
					view: 21
					loop: 2
					cel: 2
					posn: 110 124
					setPri: 11
					ignoreActors: 1
					stopUpd:
					init:
				)
				(gEgo view: 15 loop: 0 cel: 1 posn: 146 154 cycleSpeed: 12)
				((ScriptID 700 2) ; theBow
					cel: 3
					posn: 142 148
					cycleSpeed: (gEgo cycleSpeed:)
					init:
				)
				(= ticks (+ (gEgo cycleSpeed:) 1))
			)
			(5
				(gEgo
					loop: [local0 local24]
					cel: [local6 local24]
					posn: [local12 local24] [local18 local24]
				)
				(++ local24)
				(= ticks (+ (gEgo cycleSpeed:) 1))
			)
			(6
				(if (<= local24 5)
					(-= state 2)
				)
				(if (== local24 3)
					(gEgo setPri: 10)
				)
				(self cue:)
			)
			(7
				(gEgo
					cel: 0
					loop: 2
					setCel: 0
					posn: 142 150
					setCycle: End self
				)
				((ScriptID 700 1) ; longPole
					cel: 0
					posn: 142 150
					init:
					cycleSpeed: (gEgo cycleSpeed:)
					setCycle: End
				)
			)
			(8
				((ScriptID 700 1) y: (- ((ScriptID 700 1) y:) 2) stopUpd:) ; longPole, longPole
				(= ticks 24)
			)
			(9
				((ScriptID 700 2) y: (+ ((ScriptID 700 2) y:) 2) setCycle: Beg) ; theBow, theBow
				(gEgo setCycle: Beg self)
			)
			(10
				((ScriptID 700 2) dispose:) ; theBow
				(gEgo view: 0 loop: 4 cel: 2 posn: 132 142)
				(= ticks 12)
			)
			(11
				(NormalEgo 4)
				(gEgo setHeading: 0 self)
			)
			(12
				(gGame setSpeed: global141)
				(gEgo setMotion: MoveTo 135 122 self)
			)
			(13
				(gEgo setPri: -1)
				(HandsOn)
				(gCurRoom notify: 2)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 704)
	)
)

(instance cantGoThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1700 13 self) ; "The ledge becomes too narrow to go that way."
			)
			(1
				(gEgo setMotion: PolyPath 15 115 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 704)
	)
)

(instance climbGoThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1700 23 self) ; "I cannot cling to bare stone."
			)
			(1
				(cond
					((<= (gEgo x:) 130)
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 10)
								(gEgo y:)
								self
						)
					)
					((>= (gEgo x:) 170)
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 10)
								(gEgo y:)
								self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gCurRoom notify: 1)
				(HandsOn)
				(gTheIconBar disable: 0 4)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 704)
	)
)

(instance getOffVines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreControl: 4
					setCycle: Walk
					setMotion: MoveTo 150 75 self
				)
			)
			(1
				(gEgo
					view: 708
					posn: 140 124
					setLoop: 2
					setCel: 4
					ignoreControl: 4
					setCycle: End self
				)
			)
			(2
				(gEgo setHeading: 90)
				(= ticks 66)
			)
			(3
				((ScriptID 700 4) dispose:) ; quiver
				(gEgo
					view: 15
					posn: 149 121
					setLoop: 3
					setCel: 5
					setCycle: Beg self
				)
			)
			(4
				(gEgo view: 15 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				((ScriptID 700 2) ; theBow
					setCel: 3
					setPri: 12
					cycleSpeed: 6
					setCycle: Beg
				)
				((gTheIconBar at: 2) message: 3)
				(gEgo setCycle: Beg self)
			)
			(6
				(SetFlag 34)
				((ScriptID 700 2) dispose: delete:) ; theBow
				(NormalEgo)
				(self dispose:)
				(HandsOn)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 704)
	)
)

