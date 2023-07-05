;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 349)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use BrainWindow)
(use Talker)
(use Actor)
(use System)

(public
	art 0
	bustTalker 1
	artWin 2
)

(local
	local0
	local1
	local2
	local3
	local4 = -1
	[local5 18]
	local23
	local24
	[local25 6]
	[local31 6]
	[local37 6] = [96 133 170 206 247 284]
	[local43 6] = [180 182 174 180 159 178]
	[local49 6] = [2 7 4 6 3 5]
	[local55 6] = [8192 1024 2048 16384 4096 32]
	[local61 6] = [108 142 181 223 255 289]
	[local67 6] = [146 154 144 145 127 147]
	[local73 67] = [70 91 92 73 70 71 72 73 90 91 92 93 70 71 72 73 70 71 72 73 70 71 72 73 94 3 3 3 3 3 4 138 168 199 230 261 292 137 169 201 230 260 291 139 169 200 230 261 291 43 47 44 36 33 29 10 9 6 4 2 0 85 77 76 67 64 59]
	[local140 6] = [84 121 159 201 234 272]
	[local146 6] = [112 115 105 108 90 111]
	[local152 6] = [7 5 7 7 2 4]
	[local158 18] = [34 38 39 33 34 34 7 7 5 5 6 4 33 22 41 19 25 34]
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(if (or (param1 nsBottom:) (param1 nsRight:))
		(= temp0 (/ (+ (param1 nsLeft:) (param1 nsRight:)) 2))
		(= temp1 (/ (+ (param1 nsTop:) (param1 nsBottom:)) 2))
		(gGame setCursor: gTheCursor 1 temp0 temp1)
	else
		(gGame setCursor: gTheCursor 1 (param1 nsLeft:) (param1 nsTop:))
	)
)

(instance art of PuzzleBar
	(properties
		solvedFlag 36
		noun 9
		msgModule 349
		personalID 10
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(self release:)
		(= window 0)
		(switch global114
			(0
				(= global130 6)
			)
			(1
				(= global130 12)
			)
			(2
				(= global130 18)
			)
		)
		(= local0 0)
		(= local3 0)
		(= local1 0)
		(= local4 -1)
		(= local23 0)
		(for ((= local2 0)) (< local2 global130) ((++ local2))
			(++ [local31 (/ (((ScriptID 342 0) at: local2) value:) 100)]) ; artFrames
		)
		(for ((= local2 0)) (< local2 6) ((++ local2))
			(= [local25 local2] 1)
			(if (not [local31 local2])
				(= [local31 local2] -1)
			)
		)
		(for ((= local2 0)) (< local2 6) ((++ local2))
			(self
				add:
					((button_b new:)
						nsLeft: [local37 local2]
						nsTop: [local43 local2]
						value: local2
						yourself:
					)
			)
		)
		(for ((= local2 0)) (< local2 6) ((++ local2))
			(self
				add:
					((button_a new:)
						modifiers: [local55 local2]
						value: local2
						nsLeft: [local61 local2]
						nsTop: [local67 local2]
						yourself:
					)
			)
		)
		(for ((= local2 0)) (< local2 18) ((++ local2))
			(self add: ((ScriptID 342 0) at: local2)) ; artFrames
		)
		(self
			add:
				(((ScriptID 15 1) new:) ; puzzleCoin
					name: {button}
					view: 347
					loop: 0
					cel: 2
					nsLeft: 17
					nsTop: 143
					yourself:
				)
				button_c
				(((ScriptID 15 2) new:) ; puzzleOK
					name: {button}
					view: 347
					loop: 1
					cel: 2
					nsLeft: 27
					nsTop: 135
					yourself:
				)
		)
	)

	(method (show &tmp temp0 temp1 temp2)
		(= temp1 (Graph grSAVE_BOX 28 104 97 121 1))
		(super show: &rest)
		(Graph grRESTORE_BOX temp1)
		(Graph grUPDATE_BOX 28 104 97 121 1)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(cond
			((not (event type:)))
			((not global128))
			((or (& (event type:) $0040) (& (event type:) evKEYUP)) ; direction
				(event type: (& (event type:) $fff7)) ; evPEEK | evVERB | evHELP | evMOVE | evJOYUP | evJOYDOWN | evSAID | direction | evMENUHIT | evMENUSTART | evMOUSEKEYBOARD | evMOUSERELEASE | evNULL | $0c00
			)
			((not (= temp0 (self firstTrue: #onMe event)))
				(= global128 0)
				(gArtWin dispose:)
			)
			((== global125 temp0))
			((and (>= (global125 loop:) 7) (== (temp0 name:) {button})))
			(else
				(= global128 0)
				(gArtWin dispose:)
			)
		)
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
							(+= temp1 6)
						)
						((< temp1 12)
							(+= temp1 18)
						)
						((< temp1 18)
							(+= temp1 6)
						)
						((< temp1 24)
							(-= temp1 18)
						)
						((< temp1 30)
							(-= temp1 12)
						)
						((< temp1 32)
							(= temp1 32)
						)
						(else
							(= temp1 30)
						)
					)
				)
				(JOY_DOWN
					(cond
						((< temp1 6)
							(+= temp1 13)
						)
						((< temp1 12)
							(-= temp1 6)
						)
						((< temp1 18)
							(+= temp1 12)
						)
						((< temp1 24)
							(-= temp1 6)
						)
						((< temp1 30)
							(-= temp1 18)
						)
						((< temp1 32)
							(= temp1 32)
						)
						(else
							(= temp1 30)
						)
					)
				)
				(JOY_RIGHT
					(cond
						((< temp1 5)
							(++ temp1)
						)
						((== temp1 5)
							(= temp1 0)
						)
						((< temp1 11)
							(++ temp1)
						)
						((== temp1 11)
							(= temp1 30)
						)
						((< temp1 17)
							(++ temp1)
						)
						((== temp1 17)
							(= temp1 12)
						)
						((< temp1 23)
							(++ temp1)
						)
						((== temp1 23)
							(= temp1 18)
						)
						((< temp1 29)
							(++ temp1)
						)
						((== temp1 29)
							(= temp1 24)
						)
						((== temp1 30)
							(++ temp1)
						)
						(else
							(= temp1 6)
						)
					)
				)
				(JOY_LEFT
					(cond
						((not temp1)
							(= temp1 5)
						)
						((< temp1 6)
							(-- temp1)
						)
						((== temp1 6)
							(= temp1 31)
						)
						((< temp1 12)
							(-- temp1)
						)
						((== temp1 12)
							(= temp1 17)
						)
						((< temp1 18)
							(-- temp1)
						)
						((== temp1 18)
							(= temp1 23)
						)
						((< temp1 24)
							(-- temp1)
						)
						((== temp1 24)
							(= temp1 29)
						)
						((< temp1 30)
							(-- temp1)
						)
						((== temp1 30)
							(= temp1 11)
						)
						((== temp1 31)
							(-- temp1)
						)
						(else
							(= temp1 11)
						)
					)
				)
			)
			(= temp0 (self at: temp1))
			(localproc_0 temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (animateOnce &tmp temp0)
		(if script
			(script doit:)
		)
	)

	(method (buyClue &tmp temp0 temp1)
		(if (and (not (IsFlag 36)) (super buyClue:))
			(if (or (not global125) (not (>= (global125 loop:) 7)))
				(for
					((= temp0 12))
					(< ((= global125 (self at: temp0)) loop:) 7)
					((++ temp0))
				)
			)
			(= temp1 (/ (global125 value:) 100))
			(bustTalker x: [local140 temp1] y: [local146 temp1])
			(bustMouth
				loop: (* temp1 2)
				nsLeft: [local152 temp1]
				nsTop: [local158 temp1]
			)
			(self select: global125 0)
			(gMessager
				say:
					[local49 temp1]
					2
					16
					(+ (mod (mod (global125 value:) 100) 10) 1)
					0
					349
			)
		)
	)

	(method (dispose &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(if (not (IsObject (= temp2 (NodeValue temp0))))
				(return)
			)
			(if (not (StrCmp (temp2 name:) {frame}))
				(self delete: temp2)
			)
		)
		(super dispose: &rest)
	)

	(method (hide)
		(if global128
			(= global128 0)
			(gArtWin dispose:)
		)
		(super hide: &rest)
	)
)

(instance artWin of BrainWindow
	(properties
		top 6
		left 6
		back 53
		priority -1
	)

	(method (open param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp0 (GetPort))
		(= temp2 (+ 340 (/ param1 200)))
		(= temp3 (mod (/ param1 100) 2))
		(= temp4 (mod (= temp1 (mod param1 100)) 10))
		(self
			bottom: (+ 6 (CelHigh temp2 temp3 temp4) 7)
			right: (+ 6 (CelWide temp2 temp3 temp4) 7)
		)
		(super open: &rest)
		(SetPort 0)
		(= temp5 (+ top 2))
		(= temp6 (+ left 2))
		(= temp7 (- bottom 2))
		(= temp8 (- right 2))
		(= temp9 (- outerEdgeColor 3))
		(Graph grDRAW_LINE temp5 temp6 temp5 temp8 temp9 -1 -1)
		(Graph grDRAW_LINE (+ temp5 1) temp6 (+ temp5 1) temp8 temp9 -1 -1)
		(= temp9 (- outerEdgeColor 1))
		(Graph grDRAW_LINE (+ temp5 1) temp6 temp7 temp6 temp9 -1 -1)
		(Graph grDRAW_LINE (+ temp5 2) (+ temp6 1) (- temp7 1) (+ temp6 1) temp9 -1 -1)
		(= temp9 (+ outerEdgeColor 3))
		(Graph grDRAW_LINE temp7 (+ temp6 1) temp7 (- temp8 1) temp9 -1 -1)
		(Graph grDRAW_LINE (- temp7 1) (+ temp6 2) (- temp7 1) (- temp8 2) temp9 -1 -1)
		(= temp9 (+ outerEdgeColor 2))
		(Graph grDRAW_LINE (+ temp5 1) temp8 temp7 temp8 temp9 -1 -1)
		(Graph grDRAW_LINE (+ temp5 2) (- temp8 1) (- temp7 1) (- temp8 1) temp9 -1 -1)
		(Graph grUPDATE_BOX temp5 temp6 200 200 1)
		(DrawCel temp2 temp3 temp4 (+ 4 left) (+ 4 top) -1)
		(SetPort temp0)
		(if
			(and
				global125
				(== (global125 value:) param1)
				(< (global125 loop:) 7)
			)
			(= temp1 (/ (global125 value:) 100))
			(bustTalker x: [local140 temp1] y: [local146 temp1])
			(bustMouth
				loop: (* temp1 2)
				nsLeft: [local152 temp1]
				nsTop: [local158 temp1]
			)
			(gMessager
				say:
					[local49 temp1]
					2
					11
					(+ (mod (mod (global125 value:) 100) 10) 1)
					0
					349
			)
		)
	)
)

(instance button_a of CodeIcon
	(properties
		name {button}
		view 346
		loop 11
		cel 0
		signal 161
	)

	(method (show))

	(method (highlight))

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& modifiers (OnControl CONTROL temp0 temp1)))
	)

	(method (select)
		(bustTalker x: [local140 value] y: [local146 value])
		(bustMouth
			loop: (* value 2)
			nsLeft: [local152 value]
			nsTop: [local158 value]
		)
		(art setScript: pictureAway 0 value)
		(super select: &rest)
	)
)

(instance button_b of CodeIcon
	(properties
		name {button}
		view 346
		loop 13
		signal 161
	)

	(method (select)
		(bustTalker x: [local140 value] y: [local146 value])
		(bustMouth
			loop: (* value 2)
			nsLeft: [local152 value]
			nsTop: [local158 value]
		)
		(art setScript: artistDescription 0 value)
		(super select: &rest)
	)
)

(instance button_c of PuzzleIcon
	(properties
		name {button}
		view 347
		loop 2
		nsLeft 48
		nsTop 145
		cursor 70
		signal 385
	)

	(method (select)
		(if (super select: &rest)
			(client showHelp: 1)
		)
	)
)

(instance pictureAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(art pHandsOff: 1)
				(if (or (& local4 (<< $0001 register)) (not global128))
					(gMessager say: [local49 register] 2 3 0 self 349)
				else
					(= cycles 1)
				)
			)
			(1
				(cond
					((== [local31 register] -1)
						(gMessager say: [local49 register] 2 18 1 self 349)
						(if (& local4 (<< $0001 register))
							(^= local4 (<< $0001 register))
						)
					)
					((& local4 (<< $0001 register))
						(^= local4 (<< $0001 register))
						(gMessager say: [local49 register] 2 6 1 self 349)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if global128
					(if (== (/ global124 100) register)
						(global125
							loop: (/ global124 100)
							cel: (mod (mod global124 100) 10)
							show:
						)
						(gMessager say: [local49 register] 2 1 0 self 349)
						(++ local3)
					else
						(gMessager say: [local49 register] 2 2 0 self 349)
						(++ local1)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(cond
					((and global128 (== (/ global124 100) register))
						(gMessager
							say:
								[local49 register]
								2
								11
								(+ (mod (mod global124 100) 10) 1)
								self
								349
						)
					)
					((not [local31 register])
						(gMessager say: [local49 register] 2 17 0 self 349)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(if (and global128 (== (/ global124 100) register))
					(if (-- [local31 register])
						(gMessager say: [local49 register] 2 6 2 self 349)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(5
				(if global128
					(= global128 0)
					(gArtWin dispose:)
				)
				(if (== local3 global130)
					(art solvePuzzle:)
				)
				(if (== local1 6)
					(proc15_0 art 10 1 0 1 0 349)
					(art puzzleStatus: 1)
					(art goAway:)
				)
				(art pHandsOff: 0)
				(self dispose:)
			)
		)
	)
)

(instance artistDescription of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= temp0 0)
				(= temp1 0)
				(= temp2 1)
				(art pHandsOff: 1)
				(if global128
					(= global128 0)
					(gArtWin dispose:)
				)
				(for ((= temp1 0)) temp2 ((++ temp1))
					(= temp0
						(+ [local73 (+ (* register 4) temp1)] (* register 100))
					)
					(= temp2 0)
					(for
						((= local2 12))
						(< local2 (+ 12 global130))
						((++ local2))
						
						(if (== ((art at: local2) value:) temp0)
							(= local2 100)
							(= temp2 1)
						)
					)
				)
				((= local23 (artWin new:)) open: temp0)
				(gMessager say: [local49 register] 2 4 [local25 register] 0 349)
				(if
					(==
						(++ [local25 register])
						(proc15_6 349 [local49 register] 2 4)
					)
					(= [local25 register] 1)
				)
				(= cycles 1)
			)
			(1
				(local23 dispose:)
				(art pHandsOff: 0)
				(self dispose:)
			)
		)
	)
)

(instance bustTalker of Talker
	(properties
		x 0
		y 0
		view 350
		loop 12
		talkWidth 280
		color 2
		back 44
	)

	(method (init)
		(= mouth bustMouth)
		(super init: &rest)
	)

	(method (display &tmp [temp0 3])
		(= textX (- 140 nsLeft))
		(= textY (- 0 nsTop))
		(super display: &rest)
	)
)

(instance bustMouth of Prop
	(properties
		view 350
	)
)

(instance bustEyes of Prop ; UNUSED
	(properties
		view 350
	)
)

