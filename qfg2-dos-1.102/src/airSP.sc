;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use ProjClient)
(use TargActor)
(use rm220)
(use ForwardCounter)
(use Motion)
(use System)

(public
	airSP 0
	levitateSP 1
	earthSP 2
	triggerWallSP 3
)

(local
	oldControl
	goofedUp
)

(instance airSP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bullseye init:)
				(wizStaff init: setCycle: End self)
				(gMiscSound number: 222 priority: 5 loop: -1 play:)
				(NormalEgo)
				(gEgo setMotion: 0)
				(stopPath)
			)
			(1
				(wizStaff setLoop: 1 setCycle: ForwardCounter 2 self)
			)
			(2
				(wizStaff setLoop: 2 setCycle: Fwd setPri: 8)
				(gCurRoom notify: 6 1)
				(HandsOn)
			)
		)
	)

	(method (doit &tmp thisControl)
		(super doit: &rest)
		(= thisControl (gEgo onControl: 1))
		(cond
			((== oldControl thisControl))
			(((ScriptID 62 0) client:)) ; levitate
			((== thisControl 16384)
				(gEgo view: 62 setLoop: 1 setCycle: Fwd)
			)
			((and (== (gEgo view:) 62) (not gCantMove))
				(NormalEgo)
			)
		)
		(= oldControl thisControl)
	)

	(method (handleEvent event &tmp aSpell)
		(cond
			((super handleEvent: event))
			((and (== (gEgo view:) 62) (Said 'cast,stop,get,get'))
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: setMotion: MoveTo 161 136)
			)
		)
	)
)

(instance earthSP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wall
					posn: 139 108
					view: 222
					setLoop: 4
					cel: 0
					init:
					setStep: 2 1
					setMotion: MoveTo 143 108 self
				)
			)
			(1
				(wall cel: 1 setMotion: MoveTo 149 109 self)
			)
			(2
				(wall cel: 2 setMotion: MoveTo 156 110 self)
			)
			(3
				(wall cel: 3 setMotion: MoveTo 165 111 self)
			)
			(4
				(wall cel: 4 setMotion: MoveTo 177 113 self)
			)
			(5
				(NormalEgo)
				(gCurRoom notify: 6 3)
				(wall setPri: 7 ignoreActors: 0 stopUpd:)
				(stopPath)
				(HandsOn)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'climb,climb')
				(cond
					((<= 4 (gCurRoom notify: 6) 5)
						(triggerWallSP changeState: 8)
					)
					((== (gCurRoom notify: 6) 6)
						(HighPrint 221 0) ; "Are you CRAZY?"
					)
					(else
						(self setScript: (ScriptID 220 2)) ; climbSP
					)
				)
			)
		)
	)
)

(instance fetchStaffSP of Script
	(properties)

	(method (doit)
		(cond
			((> (Abs (- (gEgo x:) (wizStaff x:))) 26))
			((gCurRoom notify: 2))
			((not ((ScriptID 62 0) client:)) ; levitate
				(gCurRoom notify: 2 1)
				(gEgo setScript: 0)
				(gCurRoom setScript: (ScriptID 220 1) 0 16) ; fallSP
			)
			((< (gEgo z:) 16)
				(gCurRoom notify: 2 1)
				(levitateSP cue:)
				(gCurRoom setScript: (ScriptID 220 1) 0 16) ; fallSP
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wizStaff setLoop: 3 cycleSpeed: 1 setCycle: End self)
				(bullseye hide:)
				(gCurRoom notify: 6 0)
			)
			(1
				(wizStaff
					setLoop: 4
					setStep: 2 3
					setPri: 7
					setCycle: Fwd
					cycleSpeed: 0
					moveSpeed: 1
					setMotion: MoveTo 348 180 self
				)
				(gCurRoom notify: 6 2)
			)
			(2
				(gMiscSound loop: 1 fade:)
				(= cycles 8)
			)
			(3
				(wizStaff dispose:)
				(if ((ScriptID 62 0) client:) ; levitate
					((ScriptID 62 0) cue:) ; levitate
					(= cycles 52)
				else
					(= cycles 1)
				)
			)
			(4
				(HandsOff)
				(gEgo setMotion: MoveTo 246 141 self)
			)
			(5
				(gEgo setLoop: -1 setHeading: 315 self)
			)
			(6
				(SolvePuzzle 687 7 1)
				(gCurRoom notify: 6 0)
				(HandsOn 1)
				(SetFlag 67) ; fPassedAir
				(gCurRoom setScript: (ScriptID 220 3)) ; zapInSP
				(client dispose:)
			)
		)
	)
)

(instance levitateSP of HandsOffScript
	(properties)

	(method (doit)
		(if (< (Abs (- (gEgo x:) (wizStaff x:))) 22)
			(gEgo z: (- (gEgo z:) (Random 0 2)))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom notify: 1 (gEgo y:))
				(if (== (gCurRoom notify: 6) 2)
					(HandsOff)
					(gCurRoom notify: 4 1)
				)
				(caller cue:)
			)
			(1
				(if (gCurRoom notify: 2)
					(gEgo z: 100 y: (+ (gEgo y:) 100))
					(self setScript: (ScriptID 62 1) 0 200) ; fallDown
				)
				(gEgo ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance triggerWallSP of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((!= (gEgo onControl: 1) 16384))
			((gCurRoom notify: 5)
				(gCurRoom notify: 5 0)
				(self changeState: 4)
			)
			((== (gCurRoom notify: 6) 5)
				(self changeState: 8)
			)
		)
	)

	(method (changeState newState &tmp [unused 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(wall setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gCurRoom notify: 6 4)
				(gCurRoom notify: 5 1)
				(HandsOn)
			)
			(2
				(HandsOff)
				(wall setLoop: 0 cel: (wall lastCel:) setCycle: Beg self)
			)
			(3
				(gCurRoom notify: 6 3)
				(gCurRoom notify: 5 0)
				(HandsOn)
			)
			(4
				(HandsOff)
				(wall setLoop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(5
				(wall setCycle: End self)
				(gEgo posn: 185 123)
				(gCurRoom setScript: (ScriptID 220 1) 0 16) ; fallSP
				(HandsOn)
				(client setScript: 0)
			)
			(6
				(wall setLoop: 1 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(7
				(gCurRoom notify: 6 5)
				(gCurRoom notify: 5 0)
			)
			(8
				(HandsOff)
				(gCurRoom notify: 6 6)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 190 117 self
				)
			)
			(9
				(gEgo
					view: 7
					setLoop: 1
					posn: 182 91
					setPri: 11
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(10
				(= cycles 8)
			)
			(11
				(gEgo
					setPri: 7
					cel: (- (gEgo lastCel:) 1)
					setCycle: CT 1 -1 self
				)
			)
			(12
				(startPath)
				(gEgo
					view: 0
					posn: 177 114
					setLoop: 7
					cycleSpeed: 0
					setCycle: Fwd
				)
				(wall setPri: 8 setMotion: MoveTo 232 134 self)
			)
			(13
				(wall
					setMotion: MoveTo 262 144 self
					cycleSpeed: 4
					setCycle: Beg
				)
			)
			(14
				(stopPath)
				(gEgo setCycle: 0)
				(Face gEgo wall)
				(= cycles 8)
			)
			(15
				(wall setLoop: 3 cycleSpeed: 1 cel: 0 setCycle: End self)
			)
			(16
				(DontTalk 0)
				(gMiscSound number: 223 priority: 5 loop: 1 play:)
				(ShakeScreen 2)
				(wall cycleSpeed: 2 setCycle: Beg)
				(gEgo
					view: 225
					setLoop: 8
					setCycle: ForwardCounter 5
					setMotion: MoveTo 201 125
				)
				(= cycles 24)
			)
			(17
				(wall cycleSpeed: 1 cel: 0 setCycle: End self)
			)
			(18
				(gMiscSound number: 223 priority: 5 loop: 1 play:)
				(ShakeScreen 2)
				(wall cycleSpeed: 2 setCycle: Beg)
				(gEgo setCycle: ForwardCounter 4 setMotion: MoveTo 212 132)
				(= cycles 24)
			)
			(19
				(wall cycleSpeed: 0 setCycle: ForwardCounter 2 self)
			)
			(20
				(gMiscSound number: 223 priority: 5 loop: 1 play:)
				(ShakeScreen 2)
				(wall cycleSpeed: 2 setCycle: Beg)
				(gEgo setCycle: ForwardCounter 3 setMotion: MoveTo 214 142)
			)
			(21
				(HandsOff)
				(wall setCycle: 0)
				(gEgo setMotion: 0 setLoop: 0 cel: 0 setCycle: End self)
				(gMiscSound loop: 1 play:)
			)
			(22
				(if (== (gEgo view:) 31)
					(wall setLoop: 1 cel: 0 setCycle: End)
				else
					(wall setLoop: 0 cel: (wall lastCel:) setCycle: Beg)
				)
				(= cycles 24)
			)
			(23
				(wall
					setLoop: 4
					cel: (wall lastCel:)
					ignoreActors:
					setCycle: Beg self
				)
			)
			(24
				(wall setMotion: MoveTo 319 260)
				(gEgo view: 0 setCycle: Walk setMotion: MoveTo 246 141 self)
			)
			(25
				(gEgo setLoop: -1 setHeading: 315 self)
			)
			(26
				(SolvePuzzle 688 7 1)
				(gCurRoom notify: 6 0)
				(HandsOn)
				(SetFlag 68) ; fPassedEarth
				(gCurRoom setScript: (ScriptID 220 3)) ; zapInSP
				(client dispose:)
			)
		)
	)
)

(instance wizStaff of TargActor
	(properties
		x 170
		y 86
		noun '/staff'
		description {the wizard's spinning staff}
		lookStr {The wizard's staff spins faster and faster.}
		view 221
		priority 9
		signal 16400
		illegalBits 0
	)

	(method (calmMe)
		(LowPrint 221 1) ; "It seems to have no effect."
		(return 1)
	)

	(method (dazzleMe)
		(LowPrint 221 1) ; "It seems to have no effect."
	)

	(method (detectMe)
		(LowPrint 221 2) ; "Yep, it's magic, alright!"
		(return 1)
	)

	(method (fetchMe)
		(LowPrint 221 3) ; "The ends of the staff are spinning much too rapidly."
		(return 0)
	)

	(method (openMe)
		(LowPrint 221 1) ; "It seems to have no effect."
		(return 0)
	)

	(method (triggerMe)
		(LowPrint 221 1) ; "It seems to have no effect."
		(return 0)
	)

	(method (hurtMe amount whatHurt &tmp hurtType moveScript)
		(if
			(and
				(== (= hurtType (whatHurt type:)) 27)
				(== (gCurRoom notify: 6) 1)
				(< hitY 87)
			)
			(bullseye setScript: fetchStaffSP)
		else
			((= moveScript (Projectile new:))
				type: hurtType
				damage: amount
				xStart: x
				yStart: (- y 11)
				x: (+ (gEgo x:) (Random 3 40))
				y: (- (gEgo y:) (Random 3 30))
			)
			(self init: setScript: moveScript self 0)
			(return 0)
		)
	)
)

(instance bullseye of TargActor
	(properties
		x 170
		y 91
		lookStr {The staff might be easier to hit with a spell near its center.}
		view 221
		loop 5
		priority 9
		signal 16400
		illegalBits 0
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		((= moveScript (Projectile new:))
			type: (whatHurt type:)
			damage: amount
			xStart: x
			yStart: (- y 11)
			x: (+ (gEgo x:) (Random 3 40))
			y: (- (gEgo y:) (Random 3 30))
		)
		(self setScript: moveScript self 0)
		(return 0)
	)

	(method (fetchMe)
		(if (== (gCurRoom notify: 6) 1)
			(self setScript: fetchStaffSP)
		else
			(LowPrint 221 1) ; "It seems to have no effect."
		)
		(return 0)
	)
)

(instance wall of TargActor
	(properties
		x 170
		y 86
		noun '/wall,creature,elemental'
		description {the earthen wall}
		lookStr {The wall is made of earth and stone.}
		view 222
		priority 9
		signal 16400
		illegalBits 0
	)

	(method (handleEvent event)
		(if (Said 'climb,climb')
			(event claimed: 0)
		else
			(super handleEvent: event)
		)
	)

	(method (calmMe)
		(if (== (gCurRoom notify: 6) 4)
			((ScriptID 221 3) changeState: 6) ; triggerWallSP
			(return 1)
		else
			(LowPrint 221 4) ; "It seems to have no effect on the wall."
		)
		(return 0)
	)

	(method (dazzleMe)
		(if (== (gCurRoom notify: 6) 4)
			((ScriptID 221 3) changeState: 6) ; triggerWallSP
		else
			(LowPrint 221 1) ; "It seems to have no effect."
		)
		(return 0)
	)

	(method (detectMe)
		(HighPrint 221 5) ; "The wall appears to have a spell placed upon it."
		(return 1)
	)

	(method (fetchMe)
		(LowPrint 221 6) ; "You don't have the ability to fetch such a huge object."
		(return 0)
	)

	(method (openMe)
		(LowPrint 221 1) ; "It seems to have no effect."
		(return 0)
	)

	(method (triggerMe)
		(cond
			((== (gCurRoom notify: 6) 3)
				(self setScript: triggerWallSP)
				(return 1)
			)
			((>= 5 (gCurRoom notify: 6) 4)
				((ScriptID 221 3) changeState: 2) ; triggerWallSP
				(return 1)
			)
			(else
				(LowPrint 221 1) ; "It seems to have no effect."
				(return 0)
			)
		)
	)

	(method (hurtMe &tmp temp0)
		(switch (gCurRoom notify: 6)
			(3
				((gCurRoom script:)
					setScript:
						delayPrintS
						0
						{That was about as useful as bouncing a flame dart off of a brick wall.}
				)
			)
			(4
				((gCurRoom script:)
					setScript:
						delayPrintS
						0
						{You really shouldn't get him angry.__You wouldn't like him when he's angry.}
				)
			)
			(else
				((gCurRoom script:)
					setScript:
						delayPrintS
						0
						{It seems to have absorbed your spell's energy.}
				)
			)
		)
		(return 1)
	)
)

(instance delayPrintS of Script
	(properties)

	(method (doit)
		(if (and (not (IsFlag 87)) register) ; fCastingSpell
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(LowPrint register)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

