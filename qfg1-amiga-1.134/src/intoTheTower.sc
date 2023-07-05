;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 131)
(include sci.sh)
(use Main)
(use rm31)
(use Interface)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	intoTheTower 0
	gameOver 1
)

(local
	local0
	local1 = 1
	local2
	local3
	local4
	[local5 5] = [1 2 4 8 16]
	[local10 4] = [{Open} {Fetch} {Flame Dart} {Trigger}]
)

(instance cheese of View
	(properties
		y 122
		x 161
		view 31
		cel 4
	)
)

(instance intoTheTower of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 131)
	)

	(method (init)
		(cheese init: setPri: 7 ignoreActors: stopUpd:)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and local4 (not global310) (not local2))
			(self cue:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) evSAID) local2)
				(= seconds 0)
				(cond
					((Said 'yes,please')
						(= local1 0)
						(self cue:)
					)
					((Said 'no')
						(self cue:)
					)
					(else
						(event claimed: 1)
						(proc31_5 4 131 0)
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 [temp1 40])
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					setPri: 8
					posn: 200 208
					setMotion: MoveTo 175 183 self
				)
			)
			(1
				((ScriptID 31 1) setCycle: Fwd) ; wizard
				(= cycles 4)
			)
			(2
				(Print 131 1 #at 5 40 #width 80 #mode 1 #title { Erasmus } #dispose #time 3) ; "Come in and sit down."
				(gEgo setMotion: MoveTo 155 163 self)
			)
			(3
				(NormalEgo)
				(gEgo illegalBits: 0 setMotion: MoveTo 155 158 self)
			)
			(4
				((ScriptID 31 1) setCel: 0 setCycle: 0) ; wizard
				(gEgo setMotion: MoveTo 174 152 self)
			)
			(5
				((ScriptID 31 2) setCel: 7) ; egoChair
				(gEgo
					view: 31
					setLoop: 4
					setCel: 2
					illegalBits: 0
					posn: 186 121
					stopUpd:
				)
				(= cycles 5)
			)
			(6
				((ScriptID 31 1) setCel: -1 setCycle: Fwd) ; wizard
				(Print 131 2 #at 5 40 #width 80 #mode 1 #title { Erasmus } #dispose #time 4) ; "Fenrus, our guest has arrived."
				(= seconds 4)
			)
			(7
				((ScriptID 31 1) setCel: 0 setCycle: 0 stopUpd:) ; wizard
				(gEgo setCel: 2)
				((ScriptID 31 3) setCycle: Beg self) ; poof
			)
			(8
				((ScriptID 31 3) setCycle: End self) ; poof
			)
			(9
				((ScriptID 31 4) setCycle: End) ; fenrus
				(= cycles 10)
			)
			(10
				(Print 131 3 #at 225 85 #width 90 #mode 1 #title { Fenrus } #dispose #time 3) ; "Cheese, please!"
				(gEgo setCycle: End)
				(= seconds 2)
			)
			(11
				((ScriptID 31 3) ; poof
					cycleSpeed: 0
					cel: 0
					posn: 197 102
					setPri: 14
					setCycle: End self
				)
			)
			(12
				((ScriptID 31 3) cel: 0 posn: 161 115 setCycle: End) ; poof
				(= cycles 10)
			)
			(13
				(cheese posn: (+ (cheese x:) 7) (- (cheese y:) 3))
				(++ local0)
				(= cycles 1)
			)
			(14
				(if (< local0 5)
					(self changeState: 13)
				else
					(cheese dispose:)
					((ScriptID 31 4) setLoop: 5 setCel: 0) ; fenrus
					(self cue:)
				)
			)
			(15
				((ScriptID 31 4) setCel: 1) ; fenrus
				(Print 131 4 #at 225 85 #width 90 #mode 1 #title { Fenrus } #dispose #time 3) ; "Ahhhhhh!"
				(gEgo setCycle: CT 3 -1)
				(= seconds 3)
			)
			(16
				((ScriptID 31 4) cycleSpeed: 1 setCel: 0) ; fenrus
				(= cycles 2)
			)
			(17
				(if (>= [gEgoStats 12] 20) ; magic
					(= cycles 1)
				else
					(User canInput: 1)
					(gEgo setCel: 2)
					(client setScript: 0)
				)
			)
			(18
				(HandsOff)
				(= local4 1)
				(= global312 0)
				(= local1 0)
				(if (not (IsFlag 353))
					(SetFlag 353)
					(proc31_5 8 131 5)
				else
					(= cycles 1)
				)
			)
			(19
				(while (& global281 [local5 register])
					(++ register)
				)
				(cond
					(local3
						(SetFlag 266)
						(proc31_5 9 131 6)
					)
					((& global280 [local5 register])
						(proc31_5 5 (Format @temp1 131 7 [local10 register])) ; "Have you learned the %s spell yet?"
					)
					((< register 4)
						(|= global280 [local5 register])
						(proc31_5 7 (Format @temp1 131 8 [local10 register])) ; "Do you know how to cast the %s spell?"
					)
					((IsFlag 266)
						(proc31_5 7 131 9)
					)
					(else
						(= local3 1)
						(-- state)
						(proc31_5 7 131 10)
					)
				)
			)
			(20
				(= local1 (= local2 1))
				(HandsOn)
				(User canControl: 0)
				(= seconds 14)
			)
			(21
				(HandsOff)
				(= local2 0)
				(cond
					(local1
						(switch register
							(4
								(gEgo setCel: 2)
								(User canInput: 1)
								(client setScript: 0)
								(proc31_5 8 131 11)
							)
							(3
								(proc31_5 8 131 12)
							)
							(else
								(proc31_5 8 131 13)
							)
						)
					)
					((>= register 4)
						(client setScript: (ScriptID 132 5)) ; goGame
					)
					(else
						(|= global281 [local5 register])
						(++ register)
						(self changeState: 19)
					)
				)
			)
			(22
				(gEgo setCel: 2)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance gameOver of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 131)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 31 2) setCel: 7) ; egoChair
				(gEgo
					view: 31
					setLoop: 4
					setCel: 0
					illegalBits: 0
					posn: 186 121
					stopUpd:
				)
				((ScriptID 31 4) setLoop: 5 cel: 1) ; fenrus
				(= cycles 5)
			)
			(1
				((ScriptID 31 3) ; poof
					cycleSpeed: 0
					cel: 0
					posn: 160 102
					setPri: 14
					setCycle: End self
				)
			)
			(2
				((ScriptID 31 9) ; door1
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 153 119
					startUpd:
				)
				((ScriptID 31 10) ; door2
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 168 119 self
					startUpd:
				)
			)
			(3
				((ScriptID 31 10) stopUpd:) ; door2
				((ScriptID 31 9) stopUpd:) ; door1
				(gEgo setCel: 2)
				(= cycles 5)
			)
			(4
				((ScriptID 31 1) setCel: -1 setCycle: Fwd) ; wizard
				(gEgo setCel: 1)
				(Print 131 14 #at 5 40 #width 80 #mode 1 #title { Erasmus } #dispose #time 5) ; "I so enjoy playing the Mage's Maze."
				(= seconds 5)
			)
			(5
				(gEgo setCel: 2)
				((ScriptID 31 1) setCycle: Beg) ; wizard
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

