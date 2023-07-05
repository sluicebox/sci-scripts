;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use Teller)
(use OccasionalCycle)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	[local0 4] = [0 5 -6 999]
	[local4 2]
	[local6 5] = [0 3 4 2 999]
	[local11 2]
)

(instance rm530 of Rm
	(properties
		picture 400
		vanishingY -200
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 117 87 135 161 145 158 152 115 153 138 174 222 186 316 185 317 168 264 148 319 147 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 122 137 123 0 101 0 0 319 0
					yourself:
				)
		)
		(= [local4 0] @local0)
		(egoTeller init: gEgo @local0 @local4)
		(gEgo
			x: 330
			y: 150
			changeGait: 1 ; running
			normalize:
			setScale: 190
			noun: 2
			init:
		)
		(= [local11 0] @local6)
		(yesufuTeller init: (ScriptID 39 1) @local6 @local11) ; Yesufu
		((ScriptID 39 1) ; Yesufu
			view: 501
			loop: 0
			cel: 4
			x: 215
			y: 166
			setScale: 190
			setCycle: OccasionalCycle self 1 70 130
			noun: 1
			init:
		)
		(super init:)
		(tree addToPic:)
		(grass addToPic:)
		(rock addToPic:)
		(tree2 addToPic:)
		(rock3 addToPic:)
		(rock4 addToPic:)
		(trap addToPic:)
		(gCurRoom setScript: enterRoom)
	)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((<= (gEgo x:) 5)
				(gCurRoom setScript: exitEgo)
			)
			((>= (gEgo x:) 315)
				(gCurRoom setScript: exitEgoR)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Rest
				(gMessager say: 3 6 7) ; "Rest now? You have to be kidding!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(DisposeScript 39)
		(super dispose:)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 200 150 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance freeYesufu of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 1 4 0 0 self) ; "You help Yesufu."
			)
			(1
				(SetFlag 30)
				(gEgo setMotion: PolyPath 215 156 self solvePuzzle: 287 8 9)
			)
			(2
				(gEgo view: 4 setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				((ScriptID 39 1) setLoop: 1 cel: 0 setCycle: End self) ; Yesufu
				(gEgo setCycle: Beg self)
			)
			(4)
			(5
				(gMessager say: 1 6 1 0 self) ; "Thank you. You could have run off, but you did not. Now let us run together again and race to the end."
			)
			(6
				(gEgo normalize: setMotion: PolyPath 200 128 self)
				((ScriptID 39 1) ; Yesufu
					view: 983
					setCycle: StopWalk -1
					setLoop: -1
					setLoop: yesufuStopGroop
					setStep: 6 4
					xStep: 6
					yStep: 4
					setMotion: PolyPath 200 140
				)
			)
			(7
				(gEgo setMotion: PolyPath -20 103 self)
				((ScriptID 39 1) setMotion: PolyPath -20 114) ; Yesufu
			)
			(8
				(gEgo addHonor: 50)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance exitEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (- (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance exitEgoR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance egoTeller of Teller
	(properties)

	(method (doChild)
		(if (== query -6) ; "Say Good-bye"
			(gEgo setAvoider: PAvoider setMotion: PolyPath -10 103)
		)
	)
)

(instance yesufuTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(gCurRoom setScript: freeYesufu)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tree of View
	(properties
		x 240
		y 114
		view 400
		loop 2
		cel 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance grass of View
	(properties
		x 268
		y 200
		view 400
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance rock of View
	(properties
		x 311
		y 120
		view 400
		cel 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance tree2 of View
	(properties
		x 161
		y 75
		view 400
		cel 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance rock2 of View ; UNUSED
	(properties
		x 9
		y 57
		view 400
		cel 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance rock3 of View
	(properties
		x 33
		y 76
		view 400
		cel 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance rock4 of View
	(properties
		x 36
		y 145
		view 400
		cel 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance trap of View
	(properties
		x 194
		y 153
		view 401
		loop 3
		cel 1
		signal 16384
	)

	(method (onMe)
		(return 0)
	)
)

(instance yesufuStopGroop of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(IsObject ((ScriptID 39 1) cycler:)) ; Yesufu
				(((ScriptID 39 1) cycler:) isKindOf: StopWalk) ; Yesufu
			)
			((ScriptID 39 1) view: (((ScriptID 39 1) cycler:) vWalking:)) ; Yesufu, Yesufu
		)
		(super doit: &rest)
	)
)

