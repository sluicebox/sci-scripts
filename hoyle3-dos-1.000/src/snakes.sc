;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Interface)
(use ForwardCounter)
(use Rev)
(use Path)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	snakes 0
	proc600_2 2
	lineUp 3
	slSquares 4
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9 = 100
	[local10 11] = [58 111 59 130 52 134 34 136 23 180 -32768]
	[local21 5] = [62 173 54 184 -32768]
	[local26 5] = [62 167 28 184 -32768]
	[local31 9] = [6 -5 6 -2 6 2 7 5 -32768]
	[local40 9] = [-6 -5 -6 -2 -6 2 -7 5 -32768]
	[local49 10] = [0 0 1 0 1 0 1 0 1 0]
	[local59 8] = [0 278 28 278 25 278 28 278]
	[local67 8] = [0 149 130 109 86 70 45 26]
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 global189) ((++ temp0))
		(= temp1 (nonPlayerList at: 0))
		(playerList addToEnd: temp1)
		(oldList addToEnd: temp1)
		(temp1 type: 2)
		(switch temp0
			(0
				(switch global188
					(1
						(temp1 posn: 6 196 setPri: 8)
					)
					(2
						(temp1 posn: 17 187 setPri: 7)
					)
					(3
						(temp1 posn: 4 186 setPri: 6)
					)
				)
			)
			(1
				(if (== global188 2)
					(temp1 posn: 4 186 setPri: 6)
				else
					(temp1 posn: 17 187 setPri: 7)
				)
			)
			(2
				(temp1 posn: 4 186 setPri: 6)
			)
		)
		(temp1 show: setCycle: 0 loop: 9 cel: 1 setLoop: -1)
		(proc0_1)
		(nonPlayerList delete: temp1)
	)
)

(procedure (proc600_2 &tmp temp0 temp1)
	(= temp0 (gSystemWindow color:))
	(= temp1 (gSystemWindow back:))
	(gSystemWindow color: 16 back: 21)
	(Print 600 0) ; "It doesn't matter whether you win or lose, just watch out for those snakes!"
	(gSystemWindow color: temp0 back: temp1)
)

(procedure (localproc_1)
	(upLeftButton setLoop: 1 forceUpd: associatedObj: (ScriptID 602 10)) ; upLeftFront
	(upRightButton setLoop: 1 forceUpd: associatedObj: (ScriptID 602 11)) ; upRightFront
	(lowLeftButton setLoop: 1 forceUpd: associatedObj: (ScriptID 602 12)) ; lowLeftFront
	(lowRightButton setLoop: 1 forceUpd: associatedObj: (ScriptID 602 13)) ; lowRightFront
	((ScriptID 602 10) show: setLoop: 4 forceUpd:) ; upLeftFront
	((ScriptID 602 11) show: setLoop: 4 forceUpd:) ; upRightFront
	((ScriptID 602 12) show: setLoop: 4 forceUpd:) ; lowLeftFront
	((ScriptID 602 13) show: setLoop: 4 forceUpd:) ; lowRightFront
	((ScriptID 602 9) cel: 2 forceUpd:) ; theTitle
	(switch global188
		(1
			(proc0_1)
		)
		(2
			(lowRightButton setLoop: 2 forceUpd: associatedObj: 0)
			((ScriptID 602 13) dispose:) ; lowRightFront
			(proc0_1)
		)
		(3
			(lowLeftButton setLoop: 2 forceUpd: associatedObj: 0)
			(lowRightButton setLoop: 2 forceUpd: associatedObj: 0)
			((ScriptID 602 12) dispose:) ; lowLeftFront
			((ScriptID 602 13) dispose:) ; lowRightFront
			(proc0_1)
		)
	)
	(proc0_3)
)

(procedure (localproc_2)
	(= local0 0)
	(gSong fade:)
	(upLeftButton deleteKeyMouse: associatedObj: 0 dispose:)
	(upRightButton deleteKeyMouse: associatedObj: 0 dispose:)
	(lowLeftButton deleteKeyMouse: associatedObj: 0 dispose:)
	(lowRightButton deleteKeyMouse: associatedObj: 0 dispose:)
	((ScriptID 602 10) dispose:) ; upLeftFront
	((ScriptID 602 11) dispose:) ; upRightFront
	((ScriptID 602 12) dispose:) ; lowLeftFront
	((ScriptID 602 13) dispose:) ; lowRightFront
	((ScriptID 602 9) dispose:) ; theTitle
	((gCurRoom script:) cue:)
)

(procedure (localproc_3 param1)
	(proc0_4)
	(switch local1
		(global188
			(= global270 param1)
			(global270 setScript: (jumpScript new:))
		)
		((- global188 1)
			(= global271 param1)
			(global271 setScript: (jumpScript new:))
		)
		((- global188 2)
			(= global272 param1)
			(global272 setScript: (jumpScript new:))
		)
		((- global188 3)
			(= global273 param1)
			(global273 setScript: (jumpScript new:))
		)
	)
	(-- local1)
)

(procedure (localproc_4 &tmp temp0)
	(= global178 global270)
	(= local8 0)
	(= local9 100)
	(= global452 0)
	(= global453 0)
	(= global285 100)
	(= global457 1)
	(= global454 64)
	(= global455 53)
	(= global456 0)
	(slSquares eachElementDo: #reset)
	(playerList release:)
	(= local6 1)
	(= global179 (+ global188 global189))
	(for ((= temp0 0)) (< temp0 global179) ((++ temp0))
		(playerList addToEnd: (oldList at: temp0))
		(switch temp0
			(0
				((playerList at: temp0) posn: 19 197)
			)
			(1
				((playerList at: temp0) posn: 6 196)
			)
			(2
				((playerList at: temp0) posn: 17 187)
			)
			(3
				((playerList at: temp0) posn: 4 186)
			)
		)
	)
	(playerList eachElementDo: #reset)
	((ScriptID 602 3) posn: (- global454 27) (- global455 22) show:) ; spinner
	((ScriptID 602 1) posn: global454 global455 show:) ; spinnerButton
	(snakesScript state: 0)
	(snakesScript cue:)
)

(instance snakes of Rm
	(properties
		picture 600
		style 10
	)

	(method (init)
		(gSong play: 807 setLoop: -1)
		(super init:)
		(User canControl: 1)
		(star init: cycleSpeed: 4 setPri: 15 stopUpd:)
		((= gSnakes_opt (ScriptID 602 5)) doit:) ; snakes_opt
		(= global452 0)
		(= global453 0)
		(= global285 100)
		(= global457 1)
		(= local2 0)
		(= global454 64)
		(= global455 53)
		(= global456 0)
		(playerList add:)
		(oldList add:)
		(nonPlayerList add:)
		(slSquares add:)
		((ScriptID 602 2) add:) ; spinnerList
		((ScriptID 602 4) add:) ; associateList
		((ScriptID 602 3) init: stopUpd: hide:) ; spinner
		((ScriptID 602 4) add: (ScriptID 602 3)) ; associateList, spinner
		((ScriptID 602 4) add: star) ; associateList
		(Load rsVIEW 600)
		(Load rsVIEW 650)
		(Load rsVIEW 611)
		(Load rsVIEW 612)
		(Load rsVIEW 601)
		(Load rsVIEW 602)
		(Load rsVIEW 603)
		(Load rsVIEW 604)
		(Load rsVIEW 605)
		(Load rsVIEW 653)
		(Load rsSOUND 907)
		(Load rsSOUND 902)
		(Load rsSOUND 901)
		(Load rsSOUND 909)
		(Load rsSOUND 906)
		(Load rsSOUND 910)
		(Load rsSOUND 601)
		(Load rsSOUND 602)
		(Load rsSOUND 202)
		(Load rsSOUND 606)
		(Load rsSOUND 605)
		(Load rsSOUND 604)
		(Load rsSOUND 900)
		(Load rsSOUND 200)
		(Load rsSOUND 908)
		(Load rsSOUND 911)
		(Load rsSOUND 912)
		(ScriptID 653) ; theSNCode
		Path
		ForwardCounter
		Rev
		(ScriptID 602) ; spinnerScript
		(ScriptID 601) ; slSqr1
		((ScriptID 601 1) init:) ; slSqr1
		((ScriptID 601 2) ; slSqr2
			init:
			thePath: (ScriptID 601 89) ; ladder1
			leadsTo: (ScriptID 601 25) ; slSqr25
		)
		((ScriptID 601 3) init:) ; slSqr3
		((ScriptID 601 4) init:) ; slSqr4
		((ScriptID 601 5) init:) ; slSqr5
		((ScriptID 601 6) ; slSqr6
			init:
			thePath: (ScriptID 601 90) ; ladder2
			leadsTo: (ScriptID 601 17) ; slSqr17
		)
		((ScriptID 601 7) init:) ; slSqr7
		((ScriptID 601 8) init:) ; slSqr8
		((ScriptID 601 9) init:) ; slSqr9
		((ScriptID 601 10) init:) ; slSqr10
		((ScriptID 601 11) init:) ; slSqr11
		((ScriptID 601 12) init:) ; slSqr12
		((ScriptID 601 13) init:) ; slSqr13
		((ScriptID 601 14) ; slSqr14
			init:
			thePath: (ScriptID 601 91) ; ladder3
			leadsTo: (ScriptID 601 71) ; slSqr71
		)
		((ScriptID 601 15) init:) ; slSqr15
		((ScriptID 601 16) init:) ; slSqr16
		((ScriptID 601 17) init:) ; slSqr17
		((ScriptID 601 18) init:) ; slSqr18
		((ScriptID 601 19) ; slSqr19
			init:
			thePath: (ScriptID 601 92) ; ladder4
			leadsTo: (ScriptID 601 42) ; slSqr42
		)
		((ScriptID 601 20) init:) ; slSqr20
		((ScriptID 601 21) init:) ; slSqr21
		((ScriptID 601 22) init:) ; slSqr22
		((ScriptID 601 23) init:) ; slSqr23
		((ScriptID 601 24) init:) ; slSqr24
		((ScriptID 601 25) init:) ; slSqr25
		((ScriptID 601 26) init:) ; slSqr26
		((ScriptID 601 27) init:) ; slSqr27
		((ScriptID 601 28) init:) ; slSqr28
		((ScriptID 601 29) ; slSqr29
			init:
			thePath: (ScriptID 601 96) ; snake1
			leadsTo: (ScriptID 601 8) ; slSqr8
		)
		((ScriptID 601 30) init:) ; slSqr30
		((ScriptID 601 31) init:) ; slSqr31
		((ScriptID 601 32) init:) ; slSqr32
		((ScriptID 601 33) init:) ; slSqr33
		((ScriptID 601 34) init:) ; slSqr34
		((ScriptID 601 35) init:) ; slSqr35
		((ScriptID 601 36) ; slSqr36
			init:
			thePath: (ScriptID 601 97) ; snake2
			leadsTo: (ScriptID 601 11) ; slSqr11
		)
		((ScriptID 601 37) init:) ; slSqr37
		((ScriptID 601 38) init:) ; slSqr38
		((ScriptID 601 39) init:) ; slSqr39
		((ScriptID 601 40) init:) ; slSqr40
		((ScriptID 601 41) init:) ; slSqr41
		((ScriptID 601 42) init:) ; slSqr42
		((ScriptID 601 43) init:) ; slSqr43
		((ScriptID 601 44) ; slSqr44
			init:
			thePath: (ScriptID 601 93) ; ladder5
			leadsTo: (ScriptID 601 66) ; slSqr66
		)
		((ScriptID 601 45) init:) ; slSqr45
		((ScriptID 601 46) ; slSqr46
			init:
			thePath: (ScriptID 601 98) ; snake3
			leadsTo: (ScriptID 601 22) ; slSqr22
		)
		((ScriptID 601 47) init:) ; slSqr47
		((ScriptID 601 48) init:) ; slSqr48
		((ScriptID 601 49) init:) ; slSqr49
		((ScriptID 601 50) init:) ; slSqr50
		((ScriptID 601 51) init:) ; slSqr51
		((ScriptID 601 52) init:) ; slSqr52
		((ScriptID 601 53) init:) ; slSqr53
		((ScriptID 601 54) init:) ; slSqr54
		((ScriptID 601 55) init:) ; slSqr55
		((ScriptID 601 56) init:) ; slSqr56
		((ScriptID 601 57) init:) ; slSqr57
		((ScriptID 601 58) ; slSqr58
			init:
			thePath: (ScriptID 601 94) ; ladder6
			leadsTo: (ScriptID 601 79) ; slSqr79
		)
		((ScriptID 601 59) init:) ; slSqr59
		((ScriptID 601 60) init:) ; slSqr60
		((ScriptID 601 61) init:) ; slSqr61
		((ScriptID 601 62) init:) ; slSqr62
		((ScriptID 601 63) init:) ; slSqr63
		((ScriptID 601 64) init:) ; slSqr64
		((ScriptID 601 65) init:) ; slSqr65
		((ScriptID 601 66) init:) ; slSqr66
		((ScriptID 601 67) init:) ; slSqr67
		((ScriptID 601 68) init:) ; slSqr68
		((ScriptID 601 69) ; slSqr69
			init:
			thePath: (ScriptID 601 95) ; ladder7
			leadsTo: (ScriptID 601 85) ; slSqr85
		)
		((ScriptID 601 70) init:) ; slSqr70
		((ScriptID 601 71) init:) ; slSqr71
		((ScriptID 601 72) init:) ; slSqr72
		((ScriptID 601 73) ; slSqr73
			init:
			thePath: (ScriptID 601 99) ; snake4
			leadsTo: (ScriptID 601 18) ; slSqr18
		)
		((ScriptID 601 74) init:) ; slSqr74
		((ScriptID 601 75) init:) ; slSqr75
		((ScriptID 601 76) ; slSqr76
			init:
			thePath: (ScriptID 601 100) ; snake5
			leadsTo: (ScriptID 601 55) ; slSqr55
		)
		((ScriptID 601 77) init:) ; slSqr77
		((ScriptID 601 78) init:) ; slSqr78
		((ScriptID 601 79) init:) ; slSqr79
		((ScriptID 601 80) init:) ; slSqr80
		((ScriptID 601 81) ; slSqr81
			init:
			thePath: (ScriptID 601 101) ; snake6
			leadsTo: (ScriptID 601 52) ; slSqr52
		)
		((ScriptID 601 82) init:) ; slSqr82
		((ScriptID 601 83) init:) ; slSqr83
		((ScriptID 601 84) init:) ; slSqr84
		((ScriptID 601 85) init:) ; slSqr85
		((ScriptID 601 86) ; slSqr86
			init:
			thePath: (ScriptID 601 102) ; snake7
			leadsTo: (ScriptID 601 64) ; slSqr64
		)
		((ScriptID 601 87) init:) ; slSqr87
		((ScriptID 601 88) init:) ; slSqr88
		(= global178 0)
		(= gSnakesScript snakesScript)
		(= gMoveScript moveScript)
		(= gPropList propList)
		(= gStar star)
		(= gBoy1 boy1)
		(= gBoy2 boy2)
		(= gGirl1 girl1)
		(= gGirl2 girl2)
		(= gSlSquares slSquares)
		(= gSound3 (ScriptID 602 6)) ; sound3
		(= gSound4 (ScriptID 602 7)) ; sound4
		(= local7 (ScriptID 602 8)) ; sound5
		(gSong setPri: -1)
		(gSound setPri: -1)
		(gSound2 setPri: -1)
		(gSound3 setPri: -1)
		(gSound4 setPri: -1)
		(local7 setPri: -1)
		(propList add:)
		(propList add: (ScriptID 601 103)) ; snakeHead1
		(propList add: (ScriptID 601 104)) ; snakeHead2
		(propList add: (ScriptID 601 105)) ; snakeHead3
		(propList add: (ScriptID 601 106)) ; snakeHead4
		(propList add: (ScriptID 601 107)) ; snakeHead5
		(propList add: (ScriptID 601 108)) ; snakeHead6
		(propList add: (ScriptID 601 109)) ; snakeHead7
		(propList add: (ScriptID 601 110)) ; snakeTail2
		(propList add: (ScriptID 601 111)) ; snakeTail4
		(propList add: (ScriptID 601 112)) ; snakeTail6
		(self setScript: snakesScript)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 [temp4 2])
		(if
			(and
				local6
				(== (mod (GetTime) 180) 0)
				(not global281)
				(!= (global178 sqrNum:) 88)
			)
			(= temp1 0)
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(if ((propList at: temp0) cycler:)
					(++ temp1)
				)
			)
			(if (< temp1 2)
				(= temp2 (Random 0 9))
				(= temp3 (Random 0 9))
				(if (and (< temp1 1) (not ((propList at: temp2) cycler:)))
					((propList at: temp2) init:)
				)
				(if (not ((propList at: temp3) cycler:))
					((propList at: temp3) init:)
				)
			)
		)
		(if
			(and
				((ScriptID 602 3) cycler:) ; spinner
				(== (mod ((ScriptID 602 3) cel:) 2) 1) ; spinner
				(!= local9 ((ScriptID 602 3) cel:)) ; spinner
			)
			(= local9 ((ScriptID 602 3) cel:)) ; spinner
			(gSound2 play: 200 setLoop: 1)
		)
		(if (and global178 (< (global178 loop:) 4) (!= local9 (global178 cel:)))
			(cond
				((< (global178 loop:) 2)
					(cond
						((== (global178 cel:) 0)
							(gSound2 play: 911 setLoop: 1)
							(= local9 0)
						)
						((== (global178 cel:) 3)
							(gSound2 play: 912 setLoop: 1)
							(= local9 3)
						)
					)
				)
				((== (global178 cel:) 1)
					(= local9 1)
					(gSound2 play: 911 setLoop: 1)
				)
				((== (global178 cel:) 3)
					(= local9 3)
					(gSound2 play: 912 setLoop: 1)
				)
			)
		)
		(if (== global452 0)
			(gSound3 fade:)
		)
		(if (== global453 0)
			(gSound4 fade:)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (& (event type:) evKEYBOARD)
			(= global282 1)
		else
			(= global282 0)
		)
		(cond
			(local0
				(if (== local0 1)
					(upLeftButton handleEvent: event)
					(upRightButton handleEvent: event)
					(lowLeftButton handleEvent: event)
					(lowRightButton handleEvent: event)
				else
					(if (!= (upLeftButton loop:) 2)
						(upLeftButton handleEvent: event)
					)
					(if (!= (upRightButton loop:) 2)
						(upRightButton handleEvent: event)
					)
					(if (!= (lowLeftButton loop:) 2)
						(lowLeftButton handleEvent: event)
					)
					(if (!= (lowRightButton loop:) 2)
						(lowRightButton handleEvent: event)
					)
				)
			)
			(global281
				((ScriptID 602 1) handleEvent: event) ; spinnerButton
			)
			(else
				(slSquares firstTrue: #handleEvent event)
			)
		)
	)

	(method (dispose)
		(nonPlayerList release: dispose:)
		(playerList release: dispose:)
		(oldList release: dispose:)
		(propList release: dispose:)
		(KeyMouse release: dispose:)
		((ScriptID 602 2) release: dispose:) ; spinnerList
		(slSquares release: dispose:)
		((ScriptID 602 4) release: dispose:) ; associateList
		(jumpScript dispose:)
		(gSong setPri: 1 setLoop: 1)
		(gSound setPri: 2 setLoop: 1)
		(gSound2 setPri: 3 setLoop: 1)
		(gSound3 setLoop: 1)
		(gSound4 setLoop: 1)
		(gSound3 stop: dispose:)
		(gSound4 stop: dispose:)
		(local7 stop: dispose:)
		(DisposeScript 653)
		(DisposeScript 983)
		(DisposeScript 969)
		(DisposeScript 956)
		(DisposeScript 601)
		(DisposeScript 602)
		(super dispose:)
	)
)

(instance snakesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= global189 0)
				(= local6 0)
				((ScriptID 602 9) init: stopUpd:) ; theTitle
				(upLeftButton
					init:
					stopUpd:
					addKeyMouse:
					associatedObj: (ScriptID 602 10) ; upLeftFront
				)
				(upRightButton
					init:
					stopUpd:
					addKeyMouse:
					associatedObj: (ScriptID 602 11) ; upRightFront
				)
				(lowLeftButton
					init:
					stopUpd:
					addKeyMouse:
					associatedObj: (ScriptID 602 12) ; lowLeftFront
				)
				(lowRightButton
					init:
					stopUpd:
					addKeyMouse:
					associatedObj: (ScriptID 602 13) ; lowRightFront
				)
				((ScriptID 602 10) init: stopUpd:) ; upLeftFront
				((ScriptID 602 11) cel: 1 init: stopUpd:) ; upRightFront
				((ScriptID 602 12) cel: 2 init: stopUpd:) ; lowLeftFront
				((ScriptID 602 13) cel: 3 init: stopUpd:) ; lowRightFront
				((ScriptID 602 2) add: (ScriptID 602 1)) ; spinnerList, spinnerButton
			)
			(1
				(if (not local6)
					(= global179 (+ global188 global189))
					((ScriptID 602 9) dispose:) ; theTitle
					(= global178 global270)
					(upLeftButton dispose: associatedObj: 0)
					(upRightButton dispose: associatedObj: 0)
					(lowLeftButton dispose: associatedObj: 0)
					(lowRightButton dispose: associatedObj: 0)
					((ScriptID 602 4) add: boy1) ; associateList
					((ScriptID 602 4) add: boy2) ; associateList
					((ScriptID 602 4) add: girl1) ; associateList
					((ScriptID 602 4) add: girl2) ; associateList
					((ScriptID 602 10) dispose:) ; upLeftFront
					((ScriptID 602 11) dispose:) ; upRightFront
					((ScriptID 602 12) dispose:) ; lowLeftFront
					((ScriptID 602 13) dispose:) ; lowRightFront
					((ScriptID 602 3) init: show:) ; spinner
					((ScriptID 602 1) init: show:) ; spinnerButton
				)
				(if (== (playerList indexOf: global178) (- global179 1))
					(= global186 (playerList at: 0))
				else
					(= global186
						(playerList at: (+ (playerList indexOf: global178) 1))
					)
				)
				(if (!= (global178 type:) 2)
					(cond
						((< 0 (global178 sqrNum:) 78)
							(directionArrow
								init:
									((slSquares at: (- (global178 sqrNum:) 1))
										row:
									)
							)
						)
						((not (global178 sqrNum:))
							(directionArrow init: 1)
						)
					)
				)
				(++ local6)
				(self setScript: (ScriptID 602 0)) ; spinnerScript
			)
			(2
				(global178
					moveSpeed: 6
					cycleSpeed: 6
					yStep: 2
					setCycle: Walk
					looper: 0
					setLoop: -1
					cel: 1
					loop: 9
					setPri: -1
					forceUpd:
					stopUpd:
				)
				(= global178 global186)
				(-= state 2)
				(= ticks 60)
			)
		)
	)
)

(instance upLeftButton of TrackingView
	(properties
		view 650
		loop 1
		priority 1
	)

	(method (init)
		(self
			setLoop: loop
			posn: ((ScriptID 602 9) x:) (+ ((ScriptID 602 9) y:) 16) ; theTitle, theTitle
			setPri: priority
			ignoreActors:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(switch local0
				(1
					(= local1 (= global179 (= global188 1)))
					(++ local0)
					(upLeftButton
						loop: 1
						forceUpd:
						associatedObj: boy1
						trackingCode: boy1Track
					)
					(upRightButton
						loop: 1
						forceUpd:
						associatedObj: girl1
						trackingCode: girl1Track
					)
					(lowLeftButton
						loop: 1
						forceUpd:
						associatedObj: boy2
						trackingCode: boy2Track
					)
					(lowRightButton
						loop: 1
						forceUpd:
						associatedObj: girl2
						trackingCode: girl2Track
					)
					(gSound play: 901 setLoop: 1)
					((ScriptID 602 10) hide: forceUpd:) ; upLeftFront
					((ScriptID 602 11) hide: forceUpd:) ; upRightFront
					((ScriptID 602 12) hide: forceUpd:) ; lowLeftFront
					((ScriptID 602 13) hide: forceUpd:) ; lowRightFront
					((ScriptID 602 9) cel: 1 forceUpd:) ; theTitle
					(boy1 init: ignoreActors: setPri: 2)
					(girl1 init: ignoreActors: setPri: 2)
					(boy2 init: ignoreActors: setPri: 3)
					(girl2 init: ignoreActors: setPri: 4)
					(proc0_1)
				)
				(2
					(if (and local1 (!= loop 2))
						(self setLoop: 2)
						(proc0_1)
						(self associatedObj: 0 trackingCode: 0)
						(gSound play: 901 setLoop: 1)
						(localproc_3 boy1)
					)
				)
				(3
					(if (!= loop 2)
						(gSound play: 901 setLoop: 1)
						(Wait 1)
						(Wait 30)
						(= global189 0)
						(localproc_2)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance upRightButton of TrackingView
	(properties
		view 650
		loop 1
		priority 1
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ ((ScriptID 602 9) x:) 98) (+ ((ScriptID 602 9) y:) 16) ; theTitle, theTitle
			setPri: priority
			ignoreActors:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(switch local0
				(1
					(= local1 (= global179 (= global188 2)))
					(++ local0)
					(upLeftButton
						loop: 1
						forceUpd:
						associatedObj: boy1
						trackingCode: boy1Track
					)
					(upRightButton
						loop: 1
						forceUpd:
						associatedObj: girl1
						trackingCode: girl1Track
					)
					(lowLeftButton
						loop: 1
						forceUpd:
						associatedObj: boy2
						trackingCode: boy2Track
					)
					(lowRightButton
						loop: 1
						forceUpd:
						associatedObj: girl2
						trackingCode: girl2Track
					)
					(gSound play: 901 setLoop: 1)
					((ScriptID 602 10) hide: forceUpd:) ; upLeftFront
					((ScriptID 602 11) hide: forceUpd:) ; upRightFront
					((ScriptID 602 12) hide: forceUpd:) ; lowLeftFront
					((ScriptID 602 13) hide: forceUpd:) ; lowRightFront
					((ScriptID 602 9) cel: 1 forceUpd:) ; theTitle
					(boy1 init: ignoreActors: setPri: 2)
					(girl1 init: ignoreActors: setPri: 2)
					(boy2 init: ignoreActors: setPri: 3)
					(girl2 init: ignoreActors: setPri: 4)
					(proc0_1)
				)
				(2
					(if (and local1 (!= loop 2))
						(self setLoop: 2)
						(proc0_1)
						(self associatedObj: 0 trackingCode: 0)
						(gSound play: 901 setLoop: 1)
						(localproc_3 girl1)
					)
				)
				(3
					(if (!= loop 2)
						(= global189 1)
						(localproc_0)
						(gSound play: 901 setLoop: 1)
						(Wait 1)
						(Wait 30)
						(localproc_2)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance lowLeftButton of TrackingView
	(properties
		view 650
		loop 1
		priority 1
	)

	(method (init)
		(self
			setLoop: loop
			posn: ((ScriptID 602 9) x:) (+ ((ScriptID 602 9) y:) 74) ; theTitle, theTitle
			setPri: priority
			ignoreActors:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(switch local0
				(1
					(= local1 (= global179 (= global188 3)))
					(++ local0)
					(upLeftButton
						loop: 1
						forceUpd:
						associatedObj: boy1
						trackingCode: boy1Track
					)
					(upRightButton
						loop: 1
						forceUpd:
						associatedObj: girl1
						trackingCode: girl1Track
					)
					(lowLeftButton
						loop: 1
						forceUpd:
						associatedObj: boy2
						trackingCode: boy2Track
					)
					(lowRightButton
						loop: 1
						forceUpd:
						associatedObj: girl2
						trackingCode: girl2Track
					)
					(gSound play: 901 setLoop: 1)
					((ScriptID 602 10) hide: forceUpd:) ; upLeftFront
					((ScriptID 602 11) hide: forceUpd:) ; upRightFront
					((ScriptID 602 12) hide: forceUpd:) ; lowLeftFront
					((ScriptID 602 13) hide: forceUpd:) ; lowRightFront
					((ScriptID 602 9) cel: 1 forceUpd:) ; theTitle
					(boy1 init: ignoreActors: setPri: 2)
					(girl1 init: ignoreActors: setPri: 2)
					(boy2 init: ignoreActors: setPri: 3)
					(girl2 init: ignoreActors: setPri: 4)
					(proc0_1)
				)
				(2
					(if (and local1 (!= loop 2))
						(self setLoop: 2)
						(proc0_1)
						(self associatedObj: 0 trackingCode: 0)
						(gSound play: 901 setLoop: 1)
						(localproc_3 boy2)
					)
				)
				(3
					(if (!= loop 2)
						(= global189 2)
						(localproc_0)
						(gSound play: 901 setLoop: 1)
						(Wait 1)
						(Wait 30)
						(localproc_2)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance lowRightButton of TrackingView
	(properties
		view 650
		loop 1
		priority 1
	)

	(method (init)
		(self
			setLoop: loop
			posn: (+ ((ScriptID 602 9) x:) 98) (+ ((ScriptID 602 9) y:) 74) ; theTitle, theTitle
			setPri: priority
			ignoreActors:
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(switch local0
				(1
					(= local1 (= global179 (= global188 4)))
					(++ local0)
					(upLeftButton
						loop: 1
						forceUpd:
						associatedObj: boy1
						trackingCode: boy1Track
					)
					(upRightButton
						loop: 1
						forceUpd:
						associatedObj: girl1
						trackingCode: girl1Track
					)
					(lowLeftButton
						loop: 1
						forceUpd:
						associatedObj: boy2
						trackingCode: boy2Track
					)
					(lowRightButton
						loop: 1
						forceUpd:
						associatedObj: girl2
						trackingCode: girl2Track
					)
					(gSound play: 901 setLoop: 1)
					(Wait 1)
					(Wait 30)
					((ScriptID 602 10) hide: forceUpd:) ; upLeftFront
					((ScriptID 602 11) hide: forceUpd:) ; upRightFront
					((ScriptID 602 12) hide: forceUpd:) ; lowLeftFront
					((ScriptID 602 13) hide: forceUpd:) ; lowRightFront
					((ScriptID 602 9) cel: 1 forceUpd:) ; theTitle
					(boy1 init: ignoreActors: setPri: 2)
					(girl1 init: ignoreActors: setPri: 2)
					(boy2 init: ignoreActors: setPri: 3)
					(girl2 init: ignoreActors: setPri: 4)
					(proc0_1)
				)
				(2
					(if (and local1 (!= loop 2))
						(self setLoop: 2)
						(proc0_1)
						(self associatedObj: 0 trackingCode: 0)
						(gSound play: 901 setLoop: 1)
						(localproc_3 girl2)
					)
				)
				(3
					(if (!= loop 2)
						(= global189 3)
						(localproc_0)
						(gSound play: 901 setLoop: 1)
						(Wait 1)
						(Wait 30)
						(localproc_2)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance jumpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global178 client)
				(client setLoop: 9 setCycle: 0 moveSpeed: 2 cycleSpeed: 2)
				(cond
					((== client girl1)
						(client
							setCycle: Rev
							setMotion: MoveTo (client x:) 40 self
						)
					)
					((== client girl2)
						(client
							setCycle: Walk
							setLoop: -1
							setMotion: MoveTo 258 (client y:) self
						)
					)
					(else
						(client
							setMotion: MoveTo (client x:) (- (client y:) 3) self
						)
					)
				)
			)
			(1
				(if (== client girl2)
					(client posn: 350 100)
					(gSound play: 911 setLoop: -1)
					(= ticks 50)
				else
					(= ticks 1)
				)
			)
			(2
				(cond
					((== client boy1)
						(client
							setLoop: -1
							setCycle: Walk
							cycleSpeed: 2
							setMotion: MoveTo 65 (client y:) self
						)
					)
					((== client boy2)
						(client
							setLoop: -1
							setCycle: Walk
							cycleSpeed: 2
							setMotion: MoveTo (client x:) 167 self
						)
					)
					((== client girl1)
						(client
							setLoop: -1
							setCycle: Walk
							cycleSpeed: 2
							setMotion: MoveTo 67 40 self
						)
					)
					(else
						(gSound stop:)
						(client
							posn: 64 167
							setLoop: 4
							setMotion: MoveTo 50 183 self
						)
					)
				)
			)
			(3
				(client setLoop: -1 setCycle: Walk cycleSpeed: 2)
				(switch client
					(boy1
						(gSound play: 908 setLoop: -1)
						(client
							setCycle: End
							moveSpeed: 1
							looper: looper2
							setMotion: boy1Way self
						)
					)
					(boy2
						(client
							setLoop: 9
							setCycle: Fwd
							setMotion: boy2Way self
						)
					)
					(girl1
						(client
							setLoop: 4
							setCycle: Rev
							cycleSpeed: 3
							setMotion: girl1Way self
						)
					)
					(girl2
						(client setMotion: MoveTo 32 183 self)
					)
				)
			)
			(4
				(client
					setLoop: -1
					cel: 1
					looper: 0
					moveSpeed: 6
					cycleSpeed: 6
					setCycle: Walk
				)
				(gSound stop:)
				(switch client
					(global270
						(client setPri: 8 setMotion: MoveTo 19 197 self)
					)
					(global271
						(client setPri: 7 setMotion: MoveTo 6 196 self)
					)
					(global272
						(client setPri: 6 setMotion: MoveTo 17 187 self)
					)
					(global273
						(client setPri: 5 setMotion: MoveTo 4 186 self)
					)
				)
				(playerList addToEnd: client)
				(oldList addToEnd: client)
				(nonPlayerList delete: client)
			)
			(5
				(client setCycle: 0 loop: 9 cel: 1 stopUpd:)
				(if (not (-- global179))
					(++ local0)
					(if (!= global188 4)
						(nonPlayerList eachElementDo: #hide)
						(localproc_1)
					else
						(localproc_2)
					)
				else
					(proc0_3)
				)
				(self dispose:)
			)
		)
	)
)

(class SLChar of Actor
	(properties
		loop 9
		cel 1
		type 1
		sqrNum 0
		inPath 0
		lastX 0
		dir 0
	)

	(method (reset)
		(self
			loop: 9
			setLoop: -1
			cel: 1
			sqrNum: 0
			dir: 0
			lastX: 0
			inPath: 0
			looper: 0
			moveSpeed: 6
			cycleSpeed: 6
			setCycle: Walk
			setPri: -1
			stopUpd:
		)
	)

	(method (movQuik)
		(if (== (self inPath:) (global283 thePath:))
			(self lastX: (self x:))
			(switch (self dir:)
				(0
					(if
						(<
							(self x:)
							(+
								((slSquares at: (- (self sqrNum:) 1)) nsLeft:)
								10
							)
						)
						(self posn: (- (self x:) 10) (self y:))
					else
						(self posn: (+ (self x:) 10) (self y:))
					)
				)
				(1
					(self posn: (- (self x:) 15) (self y:))
				)
				(2
					(self posn: (+ (self x:) 15) (self y:))
				)
			)
		)
		(if
			(and
				(== (self dir:) 3)
				(or
					(== (global283 thePath:) (ScriptID 601 91)) ; ladder3
					(== (global283 thePath:) (ScriptID 601 99)) ; snake4
				)
			)
			(self lastX: (self x:) posn: (+ (self x:) 20) (self y:))
		)
	)

	(method (movBack)
		(if (self lastX:)
			(self posn: (self lastX:) (self y:))
			(self lastX: 0)
		)
	)

	(method (init)
		(self setLoop: 8 setCycle: Fwd)
		(nonPlayerList add: self)
		(super init:)
	)

	(method (shift)
		(if (== (self sqrNum:) (local4 number:))
			(if (== (self x:) (+ (local4 nsLeft:) 14))
				(self posn: (- (self x:) 8) (+ (self y:) 4))
			else
				(self posn: (+ (self x:) 10) (+ (self y:) 1))
			)
		)
	)
)

(instance boy1 of SLChar
	(properties
		x 112
		y 96
		view 601
	)
)

(instance girl1 of SLChar
	(properties
		x 208
		y 96
		view 603
	)
)

(instance boy2 of SLChar
	(properties
		x 112
		y 154
		view 602
	)
)

(instance girl2 of SLChar
	(properties
		x 208
		y 154
		view 604
	)
)

(class SLList of List
	(properties
		noShow 0
	)

	(method (cue)
		(self eachElementDo: #movQuik)
	)
)

(instance playerList of SLList
	(properties)
)

(instance oldList of SLList
	(properties)
)

(instance nonPlayerList of List
	(properties)
)

(class slSqr of KMRect
	(properties
		number 0
		thePath 0
		populatn 0
		leadsTo 0
		direct 0
		row 0
	)

	(method (init)
		(++ local2)
		(self number: local2 populatn: 0)
		(slSquares add: self)
	)

	(method (reset)
		(self populatn: 0)
	)

	(method (cue)
		(gSound2 stop:)
		(cond
			((== local8 1)
				(gSound play: 902 setLoop: 1)
				(= local8 0)
			)
			((== local8 2)
				(= local8 0)
			)
			(else
				(gSound play: 901 setLoop: 1)
			)
		)
		(star stopUpd: posn: 350 100 loop: 2)
		(if (not (self thePath:))
			(playerList eachElementDo: #movBack)
			(cond
				((== (self number:) 21)
					(global178 inPath: (ScriptID 601 89) dir: 1) ; ladder1
				)
				(
					(or
						(== (self number:) 30)
						(== (self number:) 37)
						(== (self number:) 38)
						(== (self number:) 51)
						(== (self number:) 61)
					)
					(global178 inPath: (ScriptID 601 91)) ; ladder3
					(cond
						((or (== (self number:) 37) (== (self number:) 51))
							(global178 dir: 2)
						)
						((or (== (self number:) 38) (== (self number:) 30))
							(global178 dir: 1)
						)
						(else
							(global178 dir: 3)
						)
					)
				)
				((== (self number:) 26)
					(global178 inPath: (ScriptID 601 92) dir: 0) ; ladder4
				)
				((== (self number:) 45)
					(global178 inPath: (ScriptID 601 93) dir: 0) ; ladder5
				)
				((or (== (self number:) 16) (== (self number:) 17))
					(global178 inPath: (ScriptID 601 96) dir: 2) ; snake1
				)
				(
					(or
						(== (self number:) 13)
						(== (self number:) 31)
						(== (self number:) 32)
					)
					(global178 inPath: (ScriptID 601 97)) ; snake2
					(cond
						((== (self number:) 31)
							(global178 dir: 1)
						)
						((== (self number:) 32)
							(global178 dir: 2)
						)
						(else
							(global178 dir: 0)
						)
					)
				)
				(
					(or
						(== (self number:) 23)
						(== (self number:) 24)
						(== (self number:) 43)
					)
					(global178 inPath: (ScriptID 601 98)) ; snake3
					(cond
						((== (self number:) 23)
							(global178 dir: 1)
						)
						((== (self number:) 24)
							(global178 dir: 2)
						)
						(else
							(global178 dir: 0)
						)
					)
				)
				(
					(or
						(== (self number:) 62)
						(== (self number:) 48)
						(== (self number:) 40)
						(== (self number:) 27)
					)
					(global178 inPath: (ScriptID 601 99)) ; snake4
					(cond
						((== (self number:) 40)
							(global178 dir: 2)
						)
						(
							(or
								(== (self number:) 62)
								(== (self number:) 48)
								(== (self number:) 27)
							)
							(global178 dir: 1)
						)
					)
				)
				(
					(or
						(== (self number:) 54)
						(== (self number:) 57)
						(== (self number:) 77)
					)
					(global178 inPath: (ScriptID 601 100)) ; snake5
					(if (== (self number:) 54)
						(global178 dir: 1)
					else
						(global178 dir: 2)
					)
				)
				(
					(or
						(== (self number:) 60)
						(== (self number:) 51)
						(== (self number:) 74)
					)
					(global178 inPath: (ScriptID 601 101)) ; snake6
					(if (== (self number:) 74)
						(global178 dir: 2)
					else
						(global178 dir: 1)
					)
				)
				((or (== (self number:) 68) (== (self number:) 87))
					(global178 inPath: (ScriptID 601 102) dir: 1) ; snake7
				)
				(else
					(global178 inPath: 0 dir: 0)
				)
			)
			(self populatn: (+ (self populatn:) 1))
			(switch populatn
				(1
					(global178
						posn: (+ (self nsLeft:) 16) (- (self nsBottom:) 2)
					)
				)
				(2
					(global178
						posn: (+ (self nsLeft:) 6) (- (self nsBottom:) 3)
					)
				)
				(3
					(global178
						posn: (+ (self nsLeft:) 14) (- (self nsBottom:) 7)
					)
				)
				(4
					(global178
						posn: (+ (self nsLeft:) 4) (- (self nsBottom:) 8)
					)
				)
			)
			(proc0_1)
			(if (== (self number:) 88)
				(if global457
					(= global457 0)
					(gPropList eachElementDo: #dispose)
					(= global452 0)
					(= global453 0)
					(global178 setScript: winScript)
				else
					(global178 setScript: winScript2)
				)
			else
				(snakesScript cue:)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(<= nsLeft (event x:) nsRight)
				(<= nsTop (event y:) nsBottom)
			)
			(event claimed: 1)
			(= local3 (self number:))
			(if (== global279 local3)
				(proc0_4)
				(= global283 self)
				(directionArrow hide:)
				(global178 setScript: moveScript)
			else
				(gSound play: 907 setLoop: 1)
				(if (== (star x:) 350)
					(star
						x: (+ (global284 nsLeft:) 11)
						y: (+ (global284 nsTop:) 11)
						setCycle: Fwd
					)
				else
					(star cel: 0 loop: 4)
				)
			)
			(return number)
		)
		(return 0)
	)
)

(instance moveScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= local4 0)
				(global178 setCycle: Walk setPri: -1)
				(= local5 (- (global178 sqrNum:) 1))
				(if (!= (global178 sqrNum:) 0)
					(= local4 (slSquares at: (- (global178 sqrNum:) 1)))
					(global178 sqrNum: global279)
					(if (!= (local4 direct:) 2)
						(global178
							setMotion:
								MoveTo
								(global178 x:)
								(local4 nsBottom:)
								self
						)
					else
						(global178
							setMotion:
								MoveTo
								(local4 nsRight:)
								(global178 y:)
								self
						)
					)
				else
					(global178 sqrNum: global279)
					(= ticks 1)
				)
			)
			(1
				(++ local5)
				(= temp2 (slSquares at: local5))
				(= temp1 (temp2 nsBottom:))
				(if (== (temp2 direct:) 1)
					(= temp0 (+ (temp2 nsLeft:) 4))
				else
					(= temp0 (- (temp2 nsRight:) 2))
				)
				(cond
					((== (temp2 number:) 47)
						(gSound2 play: 902 setLoop: 1)
						(global178 setLoop: 9 setMotion: skipPath self)
					)
					((== (temp2 number:) 83)
						(gSound2 play: 902 setLoop: 1)
						(global178 setLoop: 9 setMotion: skipPath82 self)
					)
					(else
						(global178 setMotion: MoveTo temp0 temp1 self)
					)
				)
			)
			(2
				(global178 setLoop: -1)
				(if (!= global279 ((slSquares at: local5) number:))
					(-= state 2)
					(= ticks 1)
				else
					(if (and local4 (> (local4 populatn:) 1))
						(playerList eachElementDo: #shift)
					)
					(if local4
						(local4 populatn: (- (local4 populatn:) 1))
					)
					(if (global283 thePath:)
						(cond
							(
								(or
									(== (= temp3 (global283 number:)) 29)
									(== temp3 36)
									(== temp3 46)
									(== temp3 73)
									(== temp3 81)
									(== temp3 87)
									(== temp3 76)
								)
								(= local8 1)
							)
							(
								(or
									(== temp3 2)
									(== temp3 6)
									(== temp3 14)
									(== temp3 19)
									(== temp3 44)
									(== temp3 58)
									(== temp3 69)
								)
								(= local8 2)
							)
						)
						(global283 cue:)
						(global178 sqrNum: ((global283 leadsTo:) number:))
						(global178 yStep: 2 moveSpeed: 7 setCycle: Fwd)
						(cond
							(
								(or
									(== (global283 thePath:) (ScriptID 601 91)) ; ladder3
									(== (global283 thePath:) (ScriptID 601 92)) ; ladder4
									(== (global283 thePath:) (ScriptID 601 93)) ; ladder5
								)
								(global178
									setLoop: 5
									cycleSpeed: 9
									moveSpeed: 8
								)
								(gSound2 stop:)
								(gSound2 play: 910 setLoop: -1)
							)
							(
								(or
									(== (global283 thePath:) (ScriptID 601 96)) ; snake1
									(== (global283 thePath:) (ScriptID 601 97)) ; snake2
									(== (global283 thePath:) (ScriptID 601 98)) ; snake3
									(== (global283 thePath:) (ScriptID 601 99)) ; snake4
									(== (global283 thePath:) (ScriptID 601 100)) ; snake5
									(== (global283 thePath:) (ScriptID 601 101)) ; snake6
									(== (global283 thePath:) (ScriptID 601 102)) ; snake7
								)
								(global178 yStep: 3)
								(global178 setCycle: Walk)
								(global178 moveSpeed: 2)
								(global178 looper: looper2)
								(if (== (global283 thePath:) (ScriptID 601 101)) ; snake6
									(global178 posn: 200 39)
								)
								(if (== (global283 thePath:) (ScriptID 601 102)) ; snake7
									(global178 posn: 79 29)
								)
								(gSound2 stop:)
								(= local8 1)
								(gSound2 play: 908 setLoop: -1)
							)
							(else
								(gSound2 stop:)
								(gSound2 play: 910 setLoop: -1)
								(global178 cycleSpeed: 8)
								(global178 moveSpeed: 8 cycleSpeed: 9)
								(global178 setLoop: 4)
								(if (== (global283 thePath:) (ScriptID 601 89)) ; ladder1
									(global178 posn: 52 178)
								)
							)
						)
						(playerList eachElementDo: #movQuik)
						(global178
							setMotion: (global283 thePath:) (global283 leadsTo:)
						)
					else
						(global283 cue:)
					)
				)
			)
		)
	)
)

(instance propList of List
	(properties)
)

(instance slSquares of List
	(properties)
)

(instance skipPath of RelPath
	(properties)

	(method (at param1)
		(return [local31 param1])
	)
)

(instance skipPath82 of RelPath
	(properties)

	(method (at param1)
		(return [local40 param1])
	)
)

(instance boy1Way of Path
	(properties)

	(method (at param1)
		(return [local10 param1])
	)
)

(instance girl1Way of Path
	(properties)

	(method (at param1)
		(return [local21 param1])
	)
)

(instance boy2Way of Path
	(properties)

	(method (at param1)
		(return [local26 param1])
	)
)

(instance looper2 of Code
	(properties)

	(method (doit param1 param2)
		(param1 setLoop: (if (< param2 180) 6 else 7))
	)
)

(instance star of Prop
	(properties
		x 350
		y 100
		view 600
		loop 2
	)
)

(instance boy1Track of Code
	(properties)

	(method (doit)
		(boy1 doit:)
	)
)

(instance girl1Track of Code
	(properties)

	(method (doit)
		(girl1 doit:)
	)
)

(instance boy2Track of Code
	(properties)

	(method (doit)
		(boy2 doit:)
	)
)

(instance girl2Track of Code
	(properties)

	(method (doit)
		(girl2 doit:)
	)
)

(instance winScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSong play: 810 setLoop: -1)
				(global178
					setLoop: 9
					cycleSpeed: 1
					setCycle: ForwardCounter 4 self
				)
			)
			(1
				((ScriptID 602 3) stopUpd: hide:) ; spinner
				((ScriptID 602 1) stopUpd: hide:) ; spinnerButton
				(global178
					posn: 41 39
					setLoop: -1
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Walk
					setMotion: MoveTo 178 41 self
				)
			)
			(2
				(= global283 (ScriptID 601 73)) ; slSqr73
				(playerList eachElementDo: #movQuik)
				(gSound play: 908 setLoop: -1)
				(global178
					setCycle: End
					looper: looper2
					setMotion: (ScriptID 601 99) self ; snake4
				)
			)
			(3
				(gSound stop:)
				(playerList eachElementDo: #movBack)
				(global178 setMotion: MoveTo 111 161 self)
			)
			(4
				(global178
					looper: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 230 161 self
				)
			)
			(5
				(gSound play: 910 setLoop: -1)
				(= global283 (ScriptID 601 14)) ; slSqr14
				(playerList eachElementDo: #movQuik)
				(global178
					setLoop: 5
					setPri: 1
					setMotion: (ScriptID 601 91) self ; ladder3
				)
			)
			(6
				(gSound stop:)
				(playerList eachElementDo: #movBack)
				(global178 setMotion: MoveTo 137 50 self)
			)
			(7
				(global178 setPri: -1 setMotion: MoveTo 130 41 self)
			)
			(8
				(global178 setLoop: -1 setMotion: MoveTo 42 41 self)
			)
			(9
				(global178 setLoop: 9 cel: 1 setCycle: ForwardCounter 5 self)
			)
			(10
				(gSong fade:)
				(global178 posn: 41 37 cel: 1 stopUpd:)
				(if global275
					(playerList delete: global178)
					(-- global179)
					(if (playerList isEmpty:)
						(localproc_4)
					else
						(snakesScript cue:)
					)
				else
					(localproc_4)
				)
			)
		)
	)
)

(instance winScript2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSong play: 202 setLoop: 1)
				(global178
					setLoop: 9
					cycleSpeed: 3
					setCycle: ForwardCounter 4 self
				)
			)
			(1
				(global178
					setLoop: 9
					setCycle: Fwd
					moveSpeed: 2
					cycleSpeed: 1
					setMotion: MoveTo (global178 x:) (- (global178 y:) 10) self
				)
			)
			(2
				(global178
					setMotion: MoveTo (global178 x:) (+ (global178 y:) 10) self
				)
			)
			(3
				(global178
					setLoop: 9
					setMotion: MoveTo (global178 x:) (- (global178 y:) 10) self
				)
			)
			(4
				(global178
					setMotion: MoveTo (global178 x:) (+ (global178 y:) 10) self
				)
			)
			(5
				(global178
					setLoop: 9
					setMotion: MoveTo (global178 x:) (- (global178 y:) 10) self
				)
			)
			(6
				(global178
					setMotion: MoveTo (global178 x:) (+ (global178 y:) 10) self
				)
			)
			(7
				(gSong fade:)
				(playerList delete: global178)
				(-- global179)
				(if (or (playerList isEmpty:) (not global275))
					(global178 setCycle: 0 setLoop: 9 cel: 1 stopUpd:)
					(proc0_1)
					(localproc_4)
				else
					(snakesScript cue:)
				)
			)
		)
	)
)

(instance lineUp of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (slSquares at: (- (global178 sqrNum:) 1)))
		(switch (temp0 populatn:)
			(2
				(global178 posn: (+ (temp0 nsLeft:) 6) (- (temp0 nsBottom:) 3))
			)
			(3
				(global178 posn: (+ (temp0 nsLeft:) 14) (- (temp0 nsBottom:) 7))
			)
			(4
				(global178 posn: (+ (temp0 nsLeft:) 4) (- (temp0 nsBottom:) 8))
			)
		)
		(if (> (temp0 populatn:) 1)
			(for ((= temp2 0)) (< temp2 (playerList size:)) ((++ temp2))
				(= temp1 (playerList at: temp2))
				(if
					(and
						(== (temp1 sqrNum:) (temp0 number:))
						(!= temp1 global178)
					)
					(cond
						((== (temp1 x:) (+ (temp0 nsLeft:) 14))
							(temp1 posn: (- (temp1 x:) 8) (+ (temp1 y:) 4))
						)
						(
							(or
								(== (temp1 x:) (+ (temp0 nsLeft:) 6))
								(== (temp1 x:) (+ (temp0 nsLeft:) 4))
							)
							(temp1 posn: (+ (temp1 x:) 10) (+ (temp1 y:) 1))
						)
					)
				)
			)
		)
	)
)

(instance directionArrow of Prop
	(properties)

	(method (init param1)
		(if (and (not global274) param1)
			(self
				view: 600
				setPri: 15
				setLoop: (+ [local49 param1] 6)
				cycleSpeed: 6
				setCycle: Fwd
				posn: [local59 param1] [local67 param1]
				ignoreActors:
				show:
			)
			(super init:)
		)
	)
)

