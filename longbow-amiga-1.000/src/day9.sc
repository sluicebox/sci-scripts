;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 153)
(include sci.sh)
(use Main)
(use verseScript)
(use RTEyeCycle)
(use Osc)
(use Motion)
(use Actor)

(public
	day9 0
)

(local
	[local0 5] = [1151 100 1 1 0]
	[local5 4] = [1151 102 1 0]
	[local9 8] = [1151 103 1 1 2 3 1 0]
	[local17 12] = [1151 108 2 3 2 1 1 1 2 3 2 0]
	[local29 6] = [1151 117 1 2 3 0]
	[local35 6] = [1151 120 1 2 2 0]
)

(instance food1 of View
	(properties
		x 223
		y 77
		view 150
		loop 3
		priority 12
		signal 17
	)
)

(instance food2 of View
	(properties
		x 156
		y 136
		view 150
		loop 3
		cel 1
		priority 15
		signal 17
	)
)

(instance food3 of View
	(properties
		x -10
		y 153
		view 150
		loop 3
		cel 2
		priority 15
		signal 17
	)
)

(instance food4 of View
	(properties
		x 80
		y 114
		view 150
		loop 3
		cel 2
		priority 10
		signal 17
	)
)

(instance outLaw1 of Prop
	(properties
		x 233
		y 108
		view 150
		loop 1
		priority 13
		signal 16
		detailLevel 2
	)
)

(instance outLaw2 of Prop
	(properties
		x 171
		y 155
		view 150
		loop 2
		cel 2
		priority 15
		signal 16
		detailLevel 1
	)
)

(instance outLaw3 of Prop
	(properties
		x 184
		y 138
		view 150
		loop 6
		detailLevel 3
	)
)

(instance outLaw4 of Prop
	(properties
		x 8
		y 158
		view 150
		loop 5
		priority 8
		detailLevel 2
	)
)

(instance fire of Prop
	(properties
		x 163
		y 112
		view 150
		detailLevel 1
	)
)

(instance day9 of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 122)
				(if (IsFlag 181)
					(AddRansom 5000)
				)
				(if (IsFlag 180)
					(AddRansom 700)
				)
				(Load rsVIEW 143 150)
				(outLaw1 init: setCycle: CT 0 1 self)
				(outLaw2 init: setCycle: Osc 4)
				(outLaw3 init: setCycle: Osc 3)
				(outLaw4 init: setCycle: Osc 4)
				(fire init: setCycle: Fwd)
				(food1 init:)
				(food2 init:)
				(food3 init:)
				(food4 init:)
			)
			(1
				(outLaw1 stopUpd:)
				((ScriptID 23) setCycle: Beg self) ; Tuck
			)
			(2
				((ScriptID 23) stopUpd:) ; Tuck
				(gEgo
					view: 143
					loop: 5
					cel: 0
					x: 262
					y: 119
					setCycle: CT 0 1 self
				)
			)
			(3
				(Face (ScriptID 22) gEgo self) ; Much
			)
			(4
				((ScriptID 22) stopUpd:) ; Much
				(Converse 1 @local0 12 0 self) ; "This is an outrage!"
			)
			(5
				((ScriptID 23) setCycle: End self) ; Tuck
			)
			(6
				(Converse 1 @local5 15 0 self) ; "Sit down, you!"
			)
			(7
				((ScriptID 23) setCycle: Beg self) ; Tuck
			)
			(8
				(Converse 3 @local9 3 0 13 1 14 2 self) ; "Is something amiss, Sir Sheriff? The food doesn't please you?"
			)
			(9
				((ScriptID 23) setCycle: End self) ; Tuck
			)
			(10
				((ScriptID 23) setCycle: Beg self) ; Tuck
			)
			(11
				((ScriptID 23) stopUpd:) ; Tuck
				(Converse 3 @local17 2 0 12 1 15 2 self) ; "I demand--"
			)
			(12
				(Converse 3 @local29 14 0 16 1 12 2 self) ; "What does it matter? One crime or a hundred, the penalty is the same--the rope."
			)
			(13
				(Converse @local35 1 13 self) ; "Unlike you, I honour my oaths."
			)
			(14
				(fire setCycle: 0 dispose: delete:)
				(outLaw1 dispose: delete:)
				(outLaw2 dispose: delete:)
				(outLaw3 dispose: delete:)
				(outLaw4 dispose: delete:)
				(gEgo hide:)
				(food1 dispose: delete:)
				(food2 dispose: delete:)
				(food3 dispose: delete:)
				(food4 dispose: delete:)
				((ScriptID 22) dispose:) ; Much
				((ScriptID 23) dispose:) ; Tuck
				((ScriptID 19) dispose:) ; John
				((ScriptID 20) dispose:) ; Will
				((ScriptID 21) dispose:) ; Alan
				(gCurRoom drawPic: 803 -32762 newRoom: 240) ; robbedOne
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 153)
	)
)

