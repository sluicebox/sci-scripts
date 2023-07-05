;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 482)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	proc482_0 0
	proc482_1 1
	proc482_2 2
)

(local
	local0
)

(procedure (proc482_0)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(gEgo setScript: grabForHole)
)

(procedure (proc482_1)
	(gEgo setScript: getHole)
)

(procedure (proc482_2)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(gEgo setScript: lookThruHole)
)

(instance getHole of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(if (> ((ScriptID 480 1) x:) 280) ; hiw
					(gGlobalSound4 number: 483 setLoop: 1 play:)
					((ScriptID 480 1) ; hiw
						setLoop: 5
						setCycle: Walk
						setMotion: MoveTo 263 47
					)
					(= local0 1)
				)
				(gEgo setMotion: PolyPath 302 92 self)
			)
			(2
				(gEgo setMotion: PolyPath 273 87 self)
			)
			(3
				(if (== local0 1)
					(self cue:)
				else
					(gGlobalSound4 number: 483 setLoop: 1 play:)
					((ScriptID 480 1) ; hiw
						setLoop: 5
						setCycle: Walk
						setMotion: MoveTo 256 64 self
					)
				)
			)
			(4
				(if (== local0 1)
					(= local0 0)
					((ScriptID 480 1) ; hiw
						setLoop: 4
						cel: 5
						posn: 254 50
						cycleSpeed: 3
						setCycle: Beg
					)
				)
				(gEgo
					normal: 0
					view: 482
					setLoop: 3
					cel: 0
					posn: 258 90
					setCycle: CT 3 1 self
				)
			)
			(5
				(gGame givePoints: 1)
				(gGlobalSound4 stop:)
				((ScriptID 480 1) dispose:) ; hiw
				(gEgo get: 18 setCycle: End self) ; holeInTheWall
			)
			(6
				(gEgo posn: 273 87 reset: 7)
				(= cycles 6)
			)
			(7
				(gMessager say: 21 5 10 1 self 480) ; "While the wallflowers dance, Alexander snatches the hole-in-the-wall!"
			)
			(8
				(gEgo setMotion: PolyPath 197 116 self)
			)
			(9
				(gEgo setHeading: 135 self)
			)
			(10
				(= cycles 2)
			)
			(11
				((ScriptID 480 5) register: 1) ; wallFlowerDance
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 482)
			)
		)
	)
)

(instance grabForHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 21 5 8 1 self 480) ; "Alexander decides to pick up the hole on the wall. A hole-in-the-wall could be a very useful thing."
			)
			(1
				(gEgo setMotion: PolyPath 300 97 self)
			)
			(2
				(gEgo setMotion: PolyPath 294 81 self)
			)
			(3
				(gMessager say: 21 5 8 2 self 480) ; "EEK!"
			)
			(4
				((ScriptID 480 1) hide:) ; hiw
				(gGlobalSound4 number: 483 setLoop: 1 play:)
				(gEgo
					view: 482
					setLoop: 0
					cel: 0
					normal: 0
					setPri: 5
					posn: 280 83
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(5
				((ScriptID 480 1) posn: 238 70 show:) ; hiw
				(gEgo posn: 294 81 reset: 7)
				(= ticks 6)
			)
			(6
				(gMessager say: 21 5 8 3 self 480) ; "Alexander's startled the poor thing! It's run off to hide behind the wallflowers!"
			)
			(7
				(gEgo setMotion: PolyPath 197 116 self)
			)
			(8
				(gEgo setHeading: 135)
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 482)
			)
		)
	)
)

(instance lookThruHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 40 0) holeLooks:) ; rWonder
					(self cue:)
				else
					(gMessager say: 21 1 5 1 self 480) ; "There appears to be a hole in the garden wall."
				)
			)
			(1
				(gEgo setMotion: PolyPath 283 94 self)
			)
			(2
				(gEgo setHeading: 0)
				(= ticks 6)
			)
			(3
				(if ((ScriptID 40 0) holeLooks:) ; rWonder
					(gMessager say: 21 1 6 1 self 480) ; "Alexander looks through the cute little hole-in-the-wall again."
				else
					(self cue:)
				)
			)
			(4
				(holeInset init:)
				(= seconds 3)
			)
			(5
				(holeInset dispose:)
				(if ((ScriptID 40 0) holeLooks:) ; rWonder
					(gMessager say: 21 1 6 2 self 480) ; "And sees the wondrous chessboard land on the other side of the wall."
				else
					(gMessager say: 21 1 5 2 self 480) ; "Through the hole in the wall, Alexander sees a land that resembles a giant chessboard!"
				)
			)
			(6
				(gEgo
					setLoop: 3
					setMotion: MoveTo (+ (gEgo x:) 5) (+ (gEgo y:) 5) self
				)
			)
			(7
				(if ((ScriptID 40 0) holeLooks:) ; rWonder
					(self cue:)
				else
					(gGlobalSound4 number: 483 setLoop: 1 play:)
					((ScriptID 480 1) ; hiw
						setMotion:
							MoveTo
							(- ((ScriptID 480 1) x:) 5) ; hiw
							((ScriptID 480 1) y:) ; hiw
							self
					)
				)
			)
			(8
				(if ((ScriptID 40 0) holeLooks:) ; rWonder
					(self cue:)
				else
					((ScriptID 480 1) ; hiw
						setMotion:
							MoveTo
							(+ ((ScriptID 480 1) x:) 5) ; hiw
							((ScriptID 480 1) y:) ; hiw
							self
					)
				)
			)
			(9
				(if ((ScriptID 40 0) holeLooks:) ; rWonder
					(self cue:)
				else
					(gMessager say: 21 1 5 3 self 480) ; "Wow! It really IS a hole-in-the-wall."
				)
			)
			(10
				(gGame handsOn:)
				(gEgo reset: 3)
				((ScriptID 40 0) holeLooks: 1) ; rWonder
				(self dispose:)
				(DisposeScript 482)
			)
		)
	)
)

(instance holeInset of View
	(properties
		x 162
		y 98
		view 487
		priority 15
		signal 16400
	)

	(method (init)
		(fields init:)
		(super init:)
	)

	(method (dispose)
		(fields dispose:)
		(super dispose:)
	)
)

(instance fields of View
	(properties
		x 164
		y 93
		view 490
		priority 14
		signal 16400
	)
)

