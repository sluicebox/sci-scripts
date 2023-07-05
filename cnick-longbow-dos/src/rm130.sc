;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Polygon)
(use Window)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm130 0
)

(procedure (localproc_0 param1)
	(if (IsObject param1)
		(param1 sel_162: 0)
		(param1 sel_303: 0)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(= temp1 gTheCursor)
	(proc0_11 720)
	(repeat
		(if
			(= temp0
				(Print ; "Select..."
					130
					9
					77
					{Restart??}
					32
					cluckWindow
					78
					{ Play again }
					444
					78
					{ Main menu }
					100
				)
			)
			(break)
		)
	)
	(proc0_3)
	(gGame sel_198: gWaitCursor)
	(gCurRoom sel_390: temp0)
)

(instance rm130 of Rm
	(properties
		sel_20 {rm130}
		sel_399 120
		sel_28 8
	)

	(method (sel_110)
		(super sel_110: &rest)
		(proc0_11)
		(willie sel_110:)
		(tucker sel_110:)
		(monk2 sel_110:)
		(robin sel_110:)
		(proc0_7 222)
		(proc0_7 223)
		(proc0_7 225)
		(gTheIconBar sel_178: sel_211: -100 sel_221: -100)
		(self sel_146: beginScript)
	)

	(method (sel_111)
		(super sel_111:)
	)

	(method (sel_292)
		(if (gCurRoom sel_142:)
			(switch (gCurRoom sel_142:)
				(dieMonkDie
					(if (< (dieMonkDie sel_29:) 8)
						(dieMonkDie sel_144: 8)
					)
				)
				(dieRobinDie
					(if (< (dieRobinDie sel_29:) 2)
						(dieRobinDie sel_144: 2)
					)
				)
			)
		else
			(return 0)
		)
	)
)

(instance beginScript of Script
	(properties
		sel_20 {beginScript}
	)

	(method (sel_110)
		(= sel_65 continueScript)
		(super sel_110: &rest)
		(gMouseDownHandler sel_129: self)
		(gKeyDownHandler sel_129: self)
	)

	(method (sel_111)
		(gMouseDownHandler sel_81: self)
		(gKeyDownHandler sel_81: self)
		(super sel_111:)
		(localproc_0 willie)
		(localproc_0 tucker)
		(localproc_0 johnny)
	)

	(method (sel_133 param1)
		(if (johnny sel_56:)
			(proc0_6 225)
			(gCurRoom sel_408: 1 3)
			(willie
				sel_2: (+ (willie sel_2:) 1)
				sel_3: 1
				sel_4: 0
				sel_153: 246 98
			)
			(tucker
				sel_2: (+ (tucker sel_2:) 1)
				sel_3: 2
				sel_4: 0
				sel_153: 167 49
			)
			(johnny sel_2: 167 sel_3: 2 sel_4: 8 sel_153: 85 89)
			(self sel_111:)
		)
		(param1 sel_73: 1)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(proc0_3)
				(proc0_11 720)
				(= sel_136 1)
			)
			(1
				(while
					(not
						(= global125
							(Print ; "Select level to play..."
								130
								0
								78
								{Easy}
								2
								78
								{Standard}
								3
								78
								{Hard}
								4
							)
						)
					)
					(= global125 2)
					(break)
					(proc0_11 gWaitCursor)
				)
				(= sel_136 1)
			)
			(2
				(monk2 sel_236: 20 sel_162: Fwd)
				(willie
					sel_236: 5
					sel_162: Walk
					sel_53: 5
					sel_303: MoveTo 246 98
				)
				(tucker
					sel_236: 5
					sel_162: Walk
					sel_53: 5
					sel_303: MoveTo 167 49
				)
				(= sel_136 1)
			)
			(3
				(johnny
					sel_110:
					sel_236: 5
					sel_162: Walk
					sel_53: 5
					sel_63: 10
					sel_303: MoveTo 85 89 self
				)
			)
			(4
				(johnny sel_2: 167 sel_3: 2 sel_4: 0)
				(= sel_136 3)
			)
			(5
				(johnny sel_236: 7 sel_4: 0 sel_162: CT 3 1 self)
			)
			(6
				(willie sel_2: (+ (willie sel_2:) 1))
				(tucker sel_2: (+ (tucker sel_2:) 1))
				(robin sel_4: 1 sel_162: End)
				(johnny sel_162: End self)
			)
			(7
				(self sel_111:)
			)
		)
	)
)

(instance continueScript of Script
	(properties
		sel_20 {continueScript}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(proc0_3)
				(= sel_137 1)
			)
			(1
				(if (proc0_5 225)
					(gCurRoom sel_408: 120 3)
					(proc0_7 225)
				)
				(monk2 sel_111:)
				(robin sel_111:)
				(self sel_146: (ScriptID 11) self) ; monkFight
			)
			(2
				(proc0_3)
				(if (proc0_5 222)
					(robin
						sel_110:
						sel_2: 122
						sel_3: 10
						sel_4: 6
						sel_153: 145 100
					)
					(monk2
						sel_110:
						sel_2: 124
						sel_3: 0
						sel_4: 0
						sel_153: 162 97
					)
					(gCurRoom
						sel_388:
							((Polygon sel_109:)
								sel_31: 2
								sel_110:
									153
									80
									166
									100
									149
									98
									140
									98
									133
									100
									131
									103
									126
									97
									129
									87
									133
									84
									141
									83
									152
									80
								sel_117:
							)
					)
					(sel_42 sel_146: dieRobinDie)
				else
					(robin
						sel_110:
						sel_2: 167
						sel_3: 3
						sel_4: 7
						sel_153: 131 99
					)
					(monk2
						sel_110:
						sel_2: 124
						sel_3: 10
						sel_4: 6
						sel_153: 162 97
					)
					(gCurRoom
						sel_388:
							((Polygon sel_109:)
								sel_31: 2
								sel_110:
									147
									94
									170
									89
									187
									95
									187
									103
									174
									109
									164
									104
									147
									104
									148
									97
								sel_117:
							)
					)
					(sel_42 sel_146: dieMonkDie)
				)
				(proc0_11 gWaitCursor)
				(self sel_111:)
			)
		)
	)
)

(instance dieRobinDie of Script
	(properties
		sel_20 {dieRobinDie}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_137 3)
			)
			(1
				(Print 130 1 77 {Fens Monk} 32 cluckWindow) ; "Robin Hood is dead! Death to all outlaws."
				(Print 130 2 77 {Little John} 32 cluckWindow) ; "By all that is holy, I'll avenge my master this day! You'll fight until not a one of us is left standing or your blood covers the ground!"
				(= sel_136 1)
			)
			(2
				(gCurRoom sel_390: 100)
				(self sel_111:)
			)
		)
	)
)

(instance dieMonkDie of Script
	(properties
		sel_20 {dieMonkDie}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_137 1)
			)
			(1
				(robin sel_236: 7 sel_4: 7 sel_162: CT 1 -1 self)
			)
			(2
				(johnny
					sel_306:
					sel_236: 7
					sel_2: 167
					sel_3: 2
					sel_4: 8
					sel_162: CT 3 -1 self
				)
			)
			(3
				(robin sel_4: 0)
				(johnny sel_162: CT 0 -1 self)
			)
			(4
				(robin sel_2: 702 sel_3: 1 sel_4: 7)
				(= sel_137 2)
			)
			(5
				(if (not (proc0_5 224))
					(proc0_6 224)
					(Print 130 3 77 {Robin Hood} 32 cluckWindow) ; "He fought well."
					(Print 130 4 77 {Little John} 32 cluckWindow) ; "But not well enough."
					(Print 130 5 77 {Will Scarlet} 32 cluckWindow) ; "Your final blow was so strong, it broke his staff!"
					(Print 130 6 77 {Robin Hood} 32 cluckWindow) ; "Aye, that was bad luck. Off toward the cave, men."
				else
					(Print 130 7 77 {Little John} 32 cluckWindow) ; "You are becoming a man of the staff, Robin. You've beaten him again!"
					(Print 130 8 77 {Robin Hood} 32 cluckWindow) ; "Aye, John. The Fens Monk is a respectable fighter. Nay is he a match for Robin Hood."
					(+= sel_29 1)
				)
				(= sel_136 1)
			)
			(6
				(= sel_137 1)
			)
			(7
				(willie
					sel_2: (- (willie sel_2:) 1)
					sel_162: Walk
					sel_307:
					sel_303: MoveTo 350 86
				)
				(robin sel_162: Walk sel_307: sel_303: PolyPath 350 86)
				(tucker
					sel_2: 154
					sel_162: Walk
					sel_307:
					sel_303: MoveTo 350 86
				)
				(johnny
					sel_2: 151
					sel_3: 2
					sel_162: Walk
					sel_303: MoveTo 350 86 self
					sel_53: 6
					sel_307:
				)
			)
			(8
				(localproc_1)
				(self sel_111:)
			)
		)
	)
)

(instance johnny of Actor
	(properties
		sel_20 {johnny}
		sel_0 83
		sel_2 151
	)

	(method (sel_110)
		(super sel_110: &rest)
	)

	(method (sel_292)
		(return 0)
	)
)

(instance willie of Actor
	(properties
		sel_20 {willie}
		sel_1 319
		sel_0 116
		sel_2 160
	)

	(method (sel_110)
		(super sel_110: &rest)
	)

	(method (sel_292)
		(return 0)
	)
)

(instance tucker of Actor
	(properties
		sel_20 {tucker}
		sel_1 166
		sel_2 154
	)

	(method (sel_110)
		(super sel_110: &rest)
	)

	(method (sel_292)
		(return 0)
	)
)

(instance monk2 of Actor
	(properties
		sel_20 {monk2}
		sel_1 159
		sel_0 99
		sel_2 124
	)

	(method (sel_110)
		(super sel_110: &rest)
	)

	(method (sel_292)
		(return 0)
	)
)

(instance robin of Actor
	(properties
		sel_20 {robin}
		sel_1 130
		sel_0 97
		sel_2 167
		sel_3 3
	)

	(method (sel_292)
		(return 0)
	)
)

(instance cluckWindow of SysWindow
	(properties
		sel_20 {cluckWindow}
		sel_26 43
	)
)

