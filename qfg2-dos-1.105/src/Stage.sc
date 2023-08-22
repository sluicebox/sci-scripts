;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use n001)
(use Motion)
(use Game)

(class Stage of Rm
	(properties
		inOut 0
		edgeHit 0
		entranceScript 0
		topFromX 32767
		topFromY 32767
		topExit 1
		topToX 32767
		topToY 32767
		bottomFromX 32767
		bottomFromY 240
		bottomExit 3
		bottomToX 32767
		bottomToY 180
		rightFromX 335
		rightFromY 32767
		rightExit 2
		rightToX 305
		rightToY 32767
		leftFromX -15
		leftFromY 32767
		leftExit 4
		leftToX 15
		leftToY 32767
		saveIllegal 0
		saveSig 0
		whereTo 0
	)

	(method (init &tmp fromX fromY toX toY theLoop staged whichEntrance)
		(super init: &rest)
		(if (== inOut 0)
			(HandsOff)
			(= saveSig (gEgo signal:))
			(= saveIllegal (gEgo illegalBits:))
			(= staged 1)
			(= whichEntrance (+ (mod (+ gRoomExitDir 1) 4) 1))
			(if (IsFlag 28)
				(cond
					(north
						(= whichEntrance topExit)
						(= gPrevRoomNum north)
					)
					(south
						(= whichEntrance bottomExit)
						(= gPrevRoomNum south)
					)
					(west
						(= whichEntrance leftExit)
						(= gPrevRoomNum west)
					)
					(east
						(= whichEntrance rightExit)
						(= gPrevRoomNum east)
					)
					(else
						(= staged 0)
					)
				)
			)
			(cond
				((and north (== whichEntrance topExit))
					(= fromX topFromX)
					(= fromY topFromY)
					(= toX topToX)
					(= toY topToY)
					(= theLoop 2)
					(cond
						((and (== fromY 32767) (== toY 32767))
							(= fromY (- horizon 2))
							(= toY (+ horizon 20))
						)
						((== fromY 32767)
							(= fromY (- toY 22))
						)
						((== toY 32767)
							(= toY (+ fromY 22))
						)
					)
				)
				((and south (== whichEntrance bottomExit))
					(= fromX bottomFromX)
					(= fromY bottomFromY)
					(= toX bottomToX)
					(= toY bottomToY)
					(= theLoop 3)
				)
				((and west (== whichEntrance leftExit))
					(= fromX leftFromX)
					(= fromY leftFromY)
					(= toX leftToX)
					(= toY leftToY)
					(= theLoop 0)
				)
				((and east (== whichEntrance rightExit))
					(= fromX rightFromX)
					(= fromY rightFromY)
					(= toX rightToX)
					(= toY rightToY)
					(= theLoop 1)
				)
				(else
					(= staged 0)
				)
			)
			(if staged
				(if (== fromX 32767)
					(= fromX (gEgo x:))
				)
				(if (== fromY 32767)
					(= fromY (gEgo y:))
				)
				(if (== toX 32767)
					(= toX (gEgo x:))
				)
				(if (== toY 32767)
					(= toY (gEgo y:))
				)
				(= inOut 1)
				(gEgo
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: fromX fromY
					loop: theLoop
					setMotion: MoveTo toX toY self
				)
			else
				(= inOut 3)
			)
		)
	)

	(method (doit &tmp toX toY theHeight)
		(cond
			((gEgo script:))
			(script
				(script doit:)
			)
			((and (== inOut 3) (or edgeHit (= edgeHit (gEgo edgeHit:))))
				(= theHeight (- (gEgo nsBottom:) (- (gEgo nsTop:) 1)))
				(switch edgeHit
					(1
						(= whereTo north)
						(= gRoomExitDir topExit)
						(= toX (gEgo x:))
						(= toY
							(if (== topFromY 32767)
								(- (gEgo y:) 10)
							else
								topFromY
							)
						)
					)
					(3
						(= whereTo south)
						(= gRoomExitDir bottomExit)
						(= toX (gEgo x:))
						(= toY
							(if (== bottomFromY 32767)
								(+ (gEgo y:) theHeight)
							else
								bottomFromY
							)
						)
					)
					(2
						(= whereTo east)
						(= gRoomExitDir rightExit)
						(= toX
							(if (== rightFromX 32767)
								(+ (gEgo x:) 30)
							else
								rightFromX
							)
						)
						(= toY (gEgo y:))
					)
					(4
						(= whereTo west)
						(= gRoomExitDir leftExit)
						(= toX
							(if (== leftFromX 32767)
								(- (gEgo x:) 30)
							else
								leftFromX
							)
						)
						(= toY (gEgo y:))
					)
				)
				(if whereTo
					(HandsOff)
					(= inOut 2)
					(= saveSig (gEgo signal:))
					(= saveIllegal (gEgo illegalBits:))
					(gEgo
						illegalBits: 0
						ignoreActors:
						ignoreHorizon:
						setMotion: MoveTo toX toY self
					)
				)
				(= edgeHit 0)
				(gEgo edgeHit: EDGE_NONE)
			)
		)
	)

	(method (cue)
		(HandsOn 1)
		(switch inOut
			(1
				(gEgo illegalBits: saveIllegal signal: saveSig)
				(= inOut 3)
				(super cue:)
				(if entranceScript
					(self setScript: entranceScript)
				)
			)
			(2
				(gCurRoom setScript: 0 newRoom: whereTo)
				(super cue:)
			)
		)
	)
)

