;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use dummyClient)
(use GameControls)
(use IconBar)
(use LoadMany)
(use Sound)

(class PuzzleIcon of IconI
	(properties
		client 0
	)
)

(class PuzzleBar of GameControls
	(properties
		iconHeight 22
		puzzleHeight 10
		bottomHeight 22
		eventX 0
		eventY 0
		hintFlag 0
		solvedFlag 0
		script 0
		inited 0
		shown 0
	)

	(method (init &tmp temp0)
		(if (not inited)
			(= inited 1)
			(LoadMany rsSOUND 949)
			(if (< (= temp0 (- (window right:) (window left:))) 90)
				(= temp0 90)
			)
			(self
				add:
					((puzzleCoin new:) lowlightColor: (proc0_1 19 3))
					((puzzleOK new:)
						nsLeft: (/ (- temp0 40) 2)
						lowlightColor: (proc0_1 19 3)
						yourself:
					)
					((puzzleHelp new:)
						nsLeft: (- temp0 31)
						lowlightColor: (proc0_1 19 3)
						yourself:
					)
					((BigDummy new:)
						nsTop: 0
						nsLeft: 0
						nsBottom: (- (window bottom:) (window top:))
						nsRight: (- (window right:) (window left:))
						yourself:
					)
			)
			(super init: &rest)
		)
	)

	(method (dispose)
		(= inited 0)
		(super dispose: &rest)
	)

	(method (noClickHelp)
		(super noClickHelp: &rest)
		(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
		(gGame setCursor: 8)
	)

	(method (add param1 &tmp temp0 temp1)
		(super add: param1 &rest)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			(if (temp1 respondsTo: #client)
				(temp1 client: self)
			)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(= gGameTime (+ gTickOffset (GetTime)))
		(self animateOnce:)
		(= eventX (event x:))
		(= eventY (event y:))
		(cond
			((== (event type:) evNULL)
				(= temp0 0)
				(= temp1 (self firstTrue: #onMe event))
				(event dispose:)
				(if (and temp1 (!= temp1 highlightedIcon))
					(= oldMouseY 0)
					(self highlight: temp1)
				)
			)
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_QUESTION))
				(self showHelp:)
				(event dispose:)
			)
			(else
				(= temp0 (super dispatchEvent: event &rest))
			)
		)
		(return temp0)
	)

	(method (animateOnce)
		(return 0)
	)

	(method (buyClue &tmp temp0 temp1)
		(= temp0 (/ (- (window right:) (window left:)) 2))
		(= temp1 (- (window bottom:) (window top:)))
		(gGame setCursor: gTheCursor 1 temp0 temp1)
		(return
			(cond
				((and hintFlag (IsFlag hintFlag)) 1)
				((not global115)
					(proc5_11 15 0)
					0
				)
				(else
					(puzzleMusic number: 949 play:)
					(if hintFlag
						(SetFlag hintFlag)
					)
					(if (not (-- global115))
						(gEgo put: 0)
						(proc5_11 15 1)
					else
						(proc5_21
							15
							2
							global115
							(if (== global115 1) { } else {s })
						)
					)
					1
				)
			)
		)
	)

	(method (showHelp))

	(method (goAway)
		(&= state $ffdf)
	)

	(method (isActive)
		(return (& state $0020))
	)

	(method (solvePuzzle param1)
		(proc5_0 solvedFlag (if argc param1 else global114))
	)

	(method (setScript param1)
		(if script
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (advance)
		(super advance: &rest)
		(if (== (highlightedIcon name:) {BigDummy})
			(super advance:)
		)
	)

	(method (retreat)
		(super retreat: &rest)
		(if (== (highlightedIcon name:) {BigDummy})
			(super retreat:)
		)
	)
)

(instance puzzleCoin of PuzzleIcon
	(properties
		view 947
		loop 10
		cel 0
		nsLeft 7
		nsTop 2
		signal 385
	)

	(method (select &tmp temp0)
		(= temp0 (GetPort))
		(if (super select: &rest)
			(client buyClue:)
		)
		(SetPort temp0)
	)
)

(instance puzzleOK of PuzzleIcon
	(properties
		view 947
		loop 9
		cel 0
		nsLeft 30
		nsTop 2
		signal 193
		helpStr {Click here to put this puzzle aside.}
	)

	(method (select)
		(if (super select: &rest)
			(client goAway:)
		)
	)
)

(instance puzzleHelp of PuzzleIcon
	(properties
		view 947
		loop 7
		cel 0
		nsLeft 70
		nsTop 2
		cursor 70
		message 6
		signal 385
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(super show: &rest)
		(= temp4 (GetPort))
		(SetPort 0)
		(= temp0 (client window:))
		(= temp1 (temp0 left:))
		(= temp2 (temp0 right:))
		(= temp5 (+ (temp0 top:) (client iconHeight:)))
		(= temp3 (- (temp0 bottom:) (client bottomHeight:)))
		(Graph grDRAW_LINE (- temp5 3) temp1 (- temp5 3) temp2 0 -1 -1)
		(Graph grDRAW_LINE (- temp5 2) temp1 (- temp5 2) temp2 0 -1 -1)
		(Graph grUPDATE_BOX (- temp5 3) temp1 (- temp5 1) temp2 1)
		(Graph grDRAW_LINE (- temp3 2) temp1 (- temp3 2) temp2 0 -1 -1)
		(Graph grDRAW_LINE (- temp3 1) temp1 (- temp3 1) temp2 0 -1 -1)
		(Graph grUPDATE_BOX (- temp3 2) temp1 temp3 temp2 1)
		(SetPort temp4)
	)

	(method (select &tmp temp0)
		(= temp0 (GetPort))
		(if (super select: &rest)
			(client showHelp:)
		)
		(SetPort temp0)
	)
)

(instance BigDummy of IconI
	(properties)

	(method (show))

	(method (highlight))

	(method (select))
)

(instance puzzleMusic of Sound
	(properties
		flags 1
	)
)

