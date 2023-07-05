;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm041 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(if (>= (= temp0 (- param1 96)) param2)
		(return 1)
	else
		(return 0)
	)
)

(instance rm041 of MGRoom
	(properties
		picture 41
		east 24
		edgeN -1
		edgeE 190
		edgeW -1
		edgeS 255
	)

	(method (init)
		(= local0 0)
		(super init:)
		(= global305 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 84 90 60 115 63 120 188 120 191 124 196 124 196 113 217 113 217 98 187 98 178 90 149 90 149 96 108 96 108 90
					yourself:
				)
		)
		(pendulum init:)
		(hourglass init:)
		(rotatingCups init:)
		(alarmClock init:)
		(cuckooClock init:)
		(clock init:)
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo init:)
			(if global172
				(gEgo posn: 165 104)
				(self setScript: converse)
			)
		else
			(gEgo posn: 165 104 init:)
			(self setScript: comeIn)
		)
		(= global301 converse)
		(= gPrevRoomNum east)
		(proc0_8 100 103 182 99)
		(gLongSong stop: number: 601 play:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((localproc_0 (gEgo x:) (gEgo y:))
				(self setScript: gStdWalkOut 0 2)
			)
		)
	)

	(method (dispose)
		(gLongSong stop: number: 600 play:)
		(pendulum dispose:)
		(hourglass dispose:)
		(rotatingCups dispose:)
		(alarmClock dispose:)
		(cuckooClock dispose:)
		(DisposeScript 341)
		(if ((gGoals at: 1) egoReturned:)
			(DisposeScript 608)
		)
		(super dispose: &rest)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 218 104 setMotion: MoveTo 175 104 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance clock of Actor
	(properties
		x 137
		y 59
		view 66
		loop 2
		cycleSpeed 4
		illegalBits 0
	)

	(method (init)
		(if ((gGoals at: 1) egoReturned:)
			(= loop 3)
		)
		(super init:)
		(= global109 self)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse)
			)
		)
	)

	(method (dispose)
		(= signal 0)
		(super dispose:)
	)
)

(instance pendulum of Prop
	(properties
		x 138
		y 89
		view 66
		cycleSpeed 7
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse)
			)
		)
	)
)

(instance hourglass of Prop
	(properties
		x 68
		y 47
		view 66
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance rotatingCups of Prop
	(properties
		x 144
		y 127
		priority 255
		fixPriority 1
		view 66
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance alarmClock of Prop
	(properties
		x 110
		y 48
		view 66
		loop 6
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance cuckooClock of Prop
	(properties
		x 175
		y 49
		view 66
		loop 7
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(proc0_7 gEgo clock)
			(= temp0 (gGoals at: 1))
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self)
						)
						(2
							(self setScript: converse4 self)
						)
						(else
							(self setScript: converse6 self)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self)
					(temp0 egoReturned: 1)
					(if (== global123 4)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= global123 4)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self)
					(temp0 egoTold: 1)
					(= global123 4)
					(= local0 1)
				)
			)
		else
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(= gNarrator global516)
			(gGame handsOn:)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 18 1 2 0 self 41) ; "Hey! You there! Have you seen a little mouse running around?"
			)
			(2
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 18 1 3 0 self 41) ; "Hurry, hurry! Find the mouse! I feel one o'clock coming on!"
			)
			(2
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 4)
				(self dispose:)
			)
		)
	)
)

(instance converse3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 18 1 4 0 self 41) ; "Hi, Mr. Clock."
			)
			(2
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 18 1 5 0 self 41) ; "Don't just stand there! It's almost one o'clock! Bring me the mouse!"
			)
			(2
				(= global131 (+ (clock x:) 13))
				(= global132 (- (clock y:) 36))
				(= global128 100)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 4)
				(self dispose:)
			)
		)
	)
)

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gLongSong fade:)
				(gMessager say: 18 1 6 0 self 41) ; "Oh, good! I see you found the mouse. And just in the nick of time, too; it's almost one o'clock. Stand back and watch the little fellow's antics."
			)
			(2
				(self setScript: (ScriptID 341) self) ; rhymeScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 18 1 7 0 self 41) ; "I feel MUCH better now! I was afraid you wouldn't find the mouse in time. You're a great little kid, you know!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance converse7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 18 1 8 0 self 41) ; "Time is running smoothly around here. Thanks again for your help with the mouse!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(18
				(clock setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(18
				(clock cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 88 (gEgo x:) 176))
				(= temp1 84)
			)
			(2
				(= temp0 235)
				(= temp1 (proc0_13 99 (gEgo y:) 110))
			)
			(3
				(= temp0 (proc0_13 55 (gEgo x:) 203))
				(= temp1 139)
			)
			(4
				(= temp0 55)
				(= temp1 (proc0_13 84 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0)
	)
)

