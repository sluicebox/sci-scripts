;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use n001)
(use Interface)
(use Motion)
(use File)
(use System)

(class Dance of Script
	(properties
		stepType 0
		repCnt 0
		pauseCnt 0
		baseIndex 0
		fp 0
	)

	(method (changeState newState &tmp [str 50])
		(= state newState)
		(= baseIndex (* state 4))
		(= stepType (self at: baseIndex))
		(if (OneOf stepType 2 3 4)
			(= repCnt (self at: (+ baseIndex 2)))
			(if (> repCnt 0)
				(-- repCnt)
			)
		)
		(if (OneOf stepType 1 2 3)
			(= pauseCnt (self at: (+ baseIndex 3)))
		)
		(if (OneOf stepType 1 2 3 4)
			(client setLoop: (self at: (+ baseIndex 1)))
		)
		(self setDir: 0)
		(if 0
			(fp
				writeString:
					(Format ; "changeState: %d %s"
						@str
						75
						0
						state
						(switch stepType
							(0 {DanceView})
							(1 {DanceCel})
							(2 {DanceEndLoop})
							(3 {DanceBegLoop})
							(4 {DanceMove})
							(5 {DanceRelPosn})
							(6 {DancePosn})
							(7 {DanceSpecial})
							(8 {DanceEnd})
						)
					)
			)
		)
		(self doState:)
	)

	(method (endLoop)
		(client cel: 0 setCycle: End self)
	)

	(method (begLoop)
		(client cel: (client lastCel:) setCycle: Beg self)
	)

	(method (setDir dir)
		(client setMotion: dir)
	)

	(method (cue)
		(cond
			(repCnt
				(-- repCnt)
				(self doState:)
			)
			(pauseCnt
				(= cycles pauseCnt)
				(= pauseCnt 0)
			)
			(else
				(super cue: &rest)
			)
		)
	)

	(method (doState &tmp dir)
		(switch stepType
			(0
				(client
					view: (self at: (+ baseIndex 1))
					setLoop: (self at: (+ baseIndex 2))
					cel: (self at: (+ baseIndex 3))
				)
				(self cue:)
			)
			(1
				(client cel: (self at: (+ baseIndex 2)))
			)
			(2
				(self endLoop:)
			)
			(3
				(self begLoop:)
			)
			(4
				(if (OneOf (= dir (self at: (+ baseIndex 3))) 5 3)
					(self endLoop:)
				else
					(self begLoop:)
				)
				(self setDir: dir)
			)
			(6
				(client
					posn: (self at: (+ baseIndex 1)) (self at: (+ baseIndex 2))
				)
				(self cue:)
			)
			(5
				(client
					x: (+ (client x:) (self at: (+ baseIndex 1)))
					y: (+ (client y:) (self at: (+ baseIndex 2)))
				)
				(self cue:)
			)
			(7
				(self doSpecial: (self at: (+ baseIndex 1)))
			)
			(8
				(self dispose:)
			)
		)
	)

	(method (at)
		(Printf 75 1 name) ; "%s needs at:"
	)

	(method (doSpecial)
		(Printf 75 2 name) ; "%s needs doSpecial:"
	)

	(method (dispose)
		(if (and (= repCnt (= pauseCnt 0)) fp)
			(fp close: dispose:)
		)
		(super dispose:)
	)
)

(class DQSnd of Dance
	(properties
		cycleDir 0
		theMusic 0
		moveDir 0
		saveSpeed 0
		disposeUs 0
		prevTime 0
	)

	(method (init who music)
		(= saveSpeed gSpeed)
		(= gSpeed 0)
		(if 0
			(= prevTime (GetTime))
			((= fp (File new:)))
			(fp name: {dqsnd.dbg} open: 2)
		)
		((= client who) script: self)
		((= theMusic music) playBed: self)
		(self changeState: start)
	)

	(method (doit)
		(if disposeUs
			(HandsOn)
			(= disposeUs 0)
			(self dispose:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(= cycleDir 0)
		(super changeState: newState)
		(= pauseCnt 0)
	)

	(method (setDir dir)
		(= moveDir dir)
	)

	(method (endLoop)
		(client cel: 0)
		(= cycleDir 1)
	)

	(method (begLoop)
		(client cel: (client lastCel:))
		(= cycleDir -1)
	)

	(method (cue &tmp thisTime elapsedTime [str 50])
		(if 0
			(Display
				(Format @str 75 3 (theMusic prevSignal:)) ; "cue %d"
				dsCOORD
				0
				10
				dsCOLOR
				15
				dsBACKGROUND
				0
			)
		)
		(if cycleDir
			(cond
				((== cycleDir 1)
					(if (== (client cel:) (client lastCel:))
						(= cycleDir 0)
					else
						(client cel: (+ (client cel:) 1))
					)
				)
				((not (client cel:))
					(= cycleDir 0)
				)
				(else
					(client cel: (- (client cel:) 1))
				)
			)
			(if (not cycleDir)
				(self cue:)
			else
				(switch moveDir
					(1
						(client y: (- (client y:) 1))
					)
					(5
						(client y: (+ (client y:) 1))
					)
					(3
						(client x: (+ (client x:) 1))
					)
					(7
						(client x: (- (client x:) 1))
					)
				)
			)
		else
			(super cue: &rest)
		)
		(if 0
			(if (> (= elapsedTime (- (= thisTime (GetTime)) prevTime)) 1)
				(theMusic pause: 1)
				(fp
					writeString:
						(Format @str 75 4 (- (theMusic prevSignal:) 128) elapsedTime) ; "cue %3d :%-3d"
				)
				(fp
					writeString:
						(Format ; "loop %d cel %d x %3d y %3d"
							@str
							75
							5
							(client loop:)
							(client cel:)
							(client x:)
							(client y:)
						)
				)
				(theMusic pause: 0)
			)
			(= prevTime thisTime)
		)
	)

	(method (doState)
		(if (== stepType 8)
			(= disposeUs 1)
		else
			(super doState:)
		)
	)

	(method (dispose)
		(= gSpeed saveSpeed)
		(if theMusic
			(theMusic dispose:)
			(= theMusic 0)
		)
		(= disposeUs 0)
		(super dispose:)
	)
)

