;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 283)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Window)
(use Actor)

(public
	hutMasks 0
)

(local
	local0
	local1
	local2
	local3
	[local4 4]
	[local8 3] = [283 284 285]
	[local11 2] = [24 40]
	[local13 30]
	[local43 3]
	[local46 6]
	[local52 5] = [12 28 36 44 52]
	[local57 4]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 6])
	(checkProp view: [local8 gDifficulty] init:)
	(= local3 (NumLoops checkProp))
	(= temp1 (Random 0 (- local3 2)))
	(checkProp loop: temp1)
	(= local4 (NumCels checkProp))
	(checkProp loop: (+ temp1 1))
	(= [local4 1] (NumCels checkProp))
	(= local2 (+ local4 [local4 1]))
	(checkProp dispose:)
	(= local57 (= [local57 1] 0))
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(= [temp5 temp0] 0)
		(= [local46 temp0] 0)
	)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(while
			(&
				[local57 (/ (= temp3 (Random 0 (- local2 1))) 16)]
				(<< $0001 (mod temp3 16))
			)
		)
		(|= [local57 (/ temp3 16)] (<< $0001 (mod temp3 16)))
		(= global117 @local46)
		(= temp2 0)
		(for ((*= temp3 3)) (< temp2 3) ((++ temp3))
			(|= [local46 (/ temp3 16)] (<< $0001 (mod temp3 16)))
			(|= [temp5 (/ temp3 16)] (<< $0001 (mod temp3 16)))
			(++ temp2)
		)
	)
	(for ((= temp0 0)) (< temp0 local2) ((++ temp0))
		(= [temp5 (/ temp3 16)]
			(|
				[temp5 (/ (= temp3 (+ (* temp0 3) (Random 0 2))) 16)]
				(<< $0001 (mod temp3 16))
			)
		)
	)
	(for ((= temp0 15)) (< temp0 30) ((++ temp0))
		(while
			(&
				[temp5 (/ (= temp3 (Random 0 (- (* local2 3) 1))) 16)]
				(<< $0001 (mod temp3 16))
			)
		)
		(|= [temp5 (/ temp3 16)] (<< $0001 (mod temp3 16)))
		(|= [local46 (/ temp3 16)] (<< $0001 (mod temp3 16)))
	)
	(return temp1)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (- (param1 nsTop:) 1))
	(= temp1 (- (param1 nsLeft:) 1))
	(= temp2 (+ (param1 nsBottom:) 1))
	(= temp3 (+ (param1 nsRight:) 1))
	(Graph grDRAW_LINE temp0 temp1 temp0 temp3 param2 -1 -1)
	(Graph grDRAW_LINE temp0 temp3 temp2 temp3 param2 -1 -1)
	(Graph grDRAW_LINE temp2 temp3 temp2 temp1 param2 -1 -1)
	(Graph grDRAW_LINE temp2 temp1 temp0 temp1 param2 -1 -1)
	(Graph grUPDATE_BOX (- temp0 1) (- temp1 1) (+ temp2 1) (+ temp3 1) 1)
)

(instance hutMasks of PuzzleBar
	(properties
		solvedFlag 30
		noun 14
		personalID 21
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= local0 (= local1 0))
		(= temp4 0)
		(= temp3 (localproc_0))
		(= temp4 (- (* local2 3) 1))
		(for ((= temp0 0)) (< temp0 30) ((++ temp0))
			(while
				(not
					(&
						[local46 (/ (= temp1 (Random 0 temp4)) 16)]
						(<< $0001 (mod temp1 16))
					)
				)
			)
			(&= [local46 (/ temp1 16)] (~ (<< $0001 (mod temp1 16))))
			(if (< (/= temp1 3) local4)
				(= temp2 temp1)
				(= temp5 temp3)
			else
				(= temp2 (- temp1 local4))
				(= temp5 (+ temp3 1))
			)
			(self
				add:
					((= [local13 temp0] (maskIcon new:))
						view: [local8 gDifficulty]
						loop: temp5
						cel: temp2
						value: temp1
						nsTop: (+ 36 (* (/ temp0 6) 28))
						nsLeft:
							(+
								[local11 (mod (/ temp0 6) 2)]
								(* 34 (mod temp0 6))
							)
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [local43 temp0] 0)
		)
		(= window puz2Window)
		(super init: &rest)
	)

	(method (buyClue &tmp temp0 temp1 temp2)
		(if (and (!= puzzleStatus 1) (super buyClue: &rest))
			(while
				(not
					(&
						[local57 (/ (= temp0 (Random 0 (- local2 1))) 16)]
						(<< $0001 (mod temp0 16))
					)
				)
			)
			(for ((= temp1 0)) (< temp1 local0) ((++ temp1))
				([local43 temp1] signal: (& ([local43 temp1] signal:) $dfff))
				(localproc_1 [local43 temp1] 19)
				(= [local43 temp1] 0)
			)
			(= local0 0)
			(for ((= temp1 0)) (< temp1 size) ((++ temp1))
				(if (== ((= temp2 (self at: temp1)) value:) temp0)
					(self select: temp2 0)
					(Wait 10)
				)
			)
		)
		(ScriptID 15 7)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(if (& (event type:) $0040) ; direction
			(= temp1
				(if highlightedIcon
					(self indexOf: highlightedIcon)
				else
					0
				)
			)
			(switch (event message:)
				(JOY_UP
					(cond
						((< temp1 6)
							(= temp1 (- size 2))
						)
						((< temp1 (- size 3))
							(-= temp1 6)
						)
						(else
							(= temp1 (- size 6))
						)
					)
				)
				(JOY_DOWN
					(cond
						((< temp1 (- size 9))
							(+= temp1 6)
						)
						((< temp1 (- size 3))
							(= temp1 (- size 2))
						)
						(else
							(= temp1 (+ (* (- temp1 (- size 3)) 2) 1))
						)
					)
				)
				(JOY_RIGHT
					(cond
						((< temp1 (- size 3))
							(if (not (mod (++ temp1) 6))
								(-= temp1 6)
							)
						)
						((>= (++ temp1) size)
							(= temp1 (- size 3))
						)
					)
				)
				(JOY_LEFT
					(cond
						((< temp1 (- size 3))
							(if (not (mod temp1 6))
								(+= temp1 5)
							else
								(-- temp1)
							)
						)
						((< (-- temp1) (- size 3))
							(= temp1 (- size 1))
						)
					)
				)
			)
			(= temp0 (self at: temp1))
			(proc5_9 temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)
)

(instance puz2Window of SysWindow
	(properties
		top 5
		left 32
		bottom 189
		right 288
		back 19
		priority -1
	)

	(method (open &tmp [temp0 5])
		(super open: &rest)
		(DrawCel 289 0 0 0 21 -1)
		(DrawCel 289 0 1 0 104 -1)
		(DrawCel 289 1 0 128 21 -1)
		(DrawCel 289 1 1 128 104 -1)
	)
)

(instance maskIcon of CodeIcon
	(properties)

	(method (select &tmp [temp0 30] temp30)
		(cond
			((& signal $4000) 0)
			((== [local43 0] self)
				(= [local43 0] 0)
				(for ((= temp30 0)) (< temp30 (- local0 1)) ((++ temp30))
					(= [local43 temp30] [local43 (+ temp30 1)])
				)
				(&= signal $dfff)
				(-- local0)
				(gCSoundFX number: 239 setLoop: 1 play:)
				(localproc_1 self 19)
			)
			((== [local43 1] self)
				(= [local43 1] 0)
				(for ((= temp30 1)) (< temp30 (- local0 1)) ((++ temp30))
					(= [local43 temp30] [local43 (+ temp30 1)])
				)
				(&= signal $dfff)
				(-- local0)
				(gCSoundFX number: 239 setLoop: 1 play:)
				(localproc_1 self 19)
			)
			((<= local0 1)
				(gCSoundFX number: 240 setLoop: 1 play:)
				(localproc_1 self 60)
				(= [local43 local0] self)
				(|= signal $2000)
				(++ local0)
			)
			(else
				(gCSoundFX number: 240 setLoop: 1 play:)
				(localproc_1 self 60)
				(Wait 0)
				(Wait 20)
				(= [local43 local0] self)
				(if (== ([local43 0] value:) ([local43 1] value:) value)
					(Wait 0)
					(for ((= temp30 0)) (< temp30 3) ((++ temp30))
						([local43 temp30]
							signal: (| ([local43 temp30] signal:) $4000)
							cursor: [local52 local1]
							show:
						)
						(gCSoundFX number: 241 setLoop: 1 play:)
						(= [local43 temp30] 0)
						(Wait 10)
					)
					(&= [local57 (/ value 16)] (~ (<< $0001 (mod value 16))))
					(if (>= (++ local1) 5)
						(hutMasks solvePuzzle:)
					else
						(Message msgGET 280 4 27 5 1 @temp0) ; "Good job. You have only %d more set(s) to find!"
						(gMessager sayFormat: 99 @temp0 (- 5 local1))
					)
				else
					(Wait 0)
					(for ((= temp30 0)) (< temp30 3) ((++ temp30))
						([local43 temp30]
							signal: (& ([local43 temp30] signal:) $dfff)
						)
						(gCSoundFX number: 239 setLoop: 1 play:)
						(localproc_1 [local43 temp30] 19)
						(= [local43 temp30] 0)
					)
				)
				(= local0 0)
			)
		)
	)

	(method (show)
		(super show: &rest)
		(cond
			((& signal $4000)
				(localproc_1 self cursor)
			)
			((& signal $2000)
				(localproc_1 self 60)
			)
		)
	)

	(method (highlight param1)
		(cond
			((& signal $4000) 0)
			(param1
				(localproc_1 self 7)
			)
			((& signal $2000)
				(localproc_1 self 60)
			)
			(else
				(localproc_1 self 19)
			)
		)
	)
)

(instance checkProp of Prop
	(properties
		view 289
	)
)

