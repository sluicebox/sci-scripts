;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 129)
(include sci.sh)
(use Main)
(use Gaza)
(use Motion)
(use Game)
(use Actor)

(public
	desertReg 0
	proc129_1 1
	proc129_2 2
	proc129_3 3
	proc129_4 4
	proc129_5 5
	proc129_6 6
	proc129_7 7
	proc129_8 8
	proc129_9 9
)

(local
	local0
	[local1 8]
	[local9 8]
	[local17 16] = [0 3 2 1 1 0 3 2 2 1 0 3 3 2 1 0]
	[local33 4] = [0 5 1 4]
	[local37 4] = [2 6 3 6]
	[local41 4] = [0 1 2 3]
	[local45 16] = [0 1 2 3 1 2 3 0 2 3 0 1 3 0 1 2]
	[local61 4] = [125 320 160 -10]
	[local65 4] = [-5 140 235 140]
	[local69 4] = [125 290 160 25]
	[local73 4] = [60 140 182 140]
	[local77 4] = [95 320 130 -10]
	[local81 4] = [-5 130 220 130]
	[local85 4] = [95 285 130 30]
	[local89 4] = [50 130 180 130]
	[local93 8] = [30 250 30 250 80 151 80 151]
	[local101 8] = [50 290 50 290 150 220 150 220]
	[local109 8] = [30 30 160 160 90 90 116 116]
	[local117 8] = [75 75 180 180 115 115 140 140]
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		([local1 temp0] dispose:)
		([local9 temp0] dispose:)
	)
)

(procedure (proc129_1 &tmp temp0)
	(= global165
		[local17
			(+
				(*
					(= temp0
						(cond
							((< (gEgo y:) 40) 0)
							((> (gEgo x:) 310) 1)
							((> (gEgo y:) 185) 2)
							((< (gEgo x:) 10) 3)
						)
					)
					4
				)
				global163
			)
		]
	)
)

(procedure (proc129_2 param1)
	(gEgo
		posn: [local61 param1] [local65 param1]
		setMotion: MoveTo [local69 param1] [local73 param1] self
	)
	(if local0
		(gMuleObj
			show:
			posn: [local77 param1] [local81 param1]
			setMotion: MoveTo [local85 param1] [local89 param1]
		)
	)
)

(procedure (proc129_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(= [local1 temp0] (aRock new:))
		(= [local9 temp0] (aShadow new:))
		([local1 temp0] setLoop: 0 cel: temp0 posn: 0 1000 init: stopUpd:)
		([local9 temp0]
			setLoop: 2
			cel: temp0
			ignoreActors:
			posn: 0 1000
			init:
			stopUpd:
		)
	)
)

(procedure (proc129_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		([local1 temp0] setLoop: [local33 global163])
		([local9 temp0] setLoop: [local37 global163])
	)
)

(procedure (proc129_5 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		([local1 temp0] posn: 0 1000 hide:)
		([local9 temp0] posn: 0 1000 hide:)
	)
)

(procedure (proc129_6 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		([local1 temp0] show:)
		(if (!= global163 3)
			([local9 temp0] show:)
		)
	)
)

(procedure (proc129_7 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (Random 0 255))
	(= temp2 (Random 0 15))
	(for ((= temp1 0)) (< temp1 8) ((++ temp1))
		(if (& temp0 $0001)
			(= temp3 (Random [local93 temp1] [local101 temp1]))
			(= temp4 (Random [local109 temp1] [local117 temp1]))
			([local1 temp1] cel: temp2 posn: temp3 temp4)
			([local9 temp1] cel: temp2 posn: temp3 temp4)
			(if (>= (+= temp2 2) 16)
				(= temp2 0)
			)
		)
		(>>= temp0 $0001)
	)
)

(procedure (proc129_8 &tmp temp0)
	(= global112 [local41 global163])
	(= temp0 [local45 (+ (* global163 4) global164)])
	(proc129_2 temp0)
)

(procedure (proc129_9)
	(cond
		((IsFlag 103)
			(ClearFlag 103)
			((ScriptID 140 0) dispose: delete:) ; lizard
			(DisposeScript 140)
			(DisposeScript 143)
		)
		((IsFlag 101)
			(ClearFlag 101)
			((ScriptID 141 0) dispose: delete:) ; lovers
			(DisposeScript 141)
		)
		((IsFlag 102)
			(ClearFlag 102)
			((ScriptID 145 0) dispose: delete:) ; water
			(DisposeScript 145)
		)
	)
)

(instance aRock of View
	(properties
		view 148
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (MouseClaimed self event)
			(proc107_2)
		)
	)
)

(instance aShadow of View
	(properties
		view 148
		loop 1
	)
)

(instance desertReg of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
		(= global163 (= global165 (= global164 (= global162 0))))
		(LOOKUP_ERROR)
	)

	(method (init)
		(super init:)
		(if (IsFlag 20)
			(= local0 1)
		)
		(= global163 0)
		(= global112 0)
	)
)

