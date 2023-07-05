;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use CursorCoords)
(use n902)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	aRoom 0
)

(local
	local0
)

(class CT of Cycle
	(properties
		endCel 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(super init: param1)
		(= cycleDir param3)
		(if (== argc 4)
			(= caller param4)
		)
		(= temp0 (client lastCel:))
		(= endCel (if (> param2 temp0) temp0 else param2))
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (client lastCel:))
		(if (> endCel temp1)
			(= endCel temp1)
		)
		(= temp0 (self nextCel:))
		(client
			cel:
				(cond
					((> temp0 temp1) 0)
					((< temp0 0) temp1)
					(else temp0)
				)
		)
		(if (and (== cycleCnt 0) (== endCel (client cel:)))
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(if caller
			(= global58 1)
		else
			(self motionCue:)
		)
	)
)

(class End of CT
	(properties)

	(method (init param1 param2)
		(super init: param1 (param1 lastCel:) 1 (if (== argc 2) param2 else 0))
	)
)

(instance aRoom of Rm
	(properties
		picture 900
	)

	(method (init &tmp temp0 temp1)
		(= temp1 (Graph grGET_COLOURS))
		(if (== 2 temp1)
			(Load rsVIEW 801)
		else
			(Load rsVIEW 800)
		)
		(if (and (not global506) (not (HaveMouse)))
			(SetCursor gTheCursor 1 300 170)
		)
		(if (!= gPrevRoomNum 100) ; introRm
			(proc902_0)
			(DisposeScript 902)
		)
		(Load rsVIEW 900)
		(proc0_7 128 1 2 3 4 5 6 8 9 10 11 12 13 14 15 16 17 18 19)
		(proc0_7 135 0 3 4 999)
		(Load rsVIEW 161)
		((= global517 inList) add:)
		(if (not global506)
			(gIntroSong play:)
			(= global506 1)
		)
		(= local0 2)
		(= global186 0)
		(super init:)
		(while ((= temp0 (Event new:)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (and global506 (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD)))
			(= gNormalCursor 999)
			(gGame setCursor: 999 (HaveMouse))
			(proc0_7 128 1 2 3 4 5 6 8 9 10 11 12 13 14 15 16 17 18 19)
			(proc0_7 135 0 3 4 999)
			(Load rsVIEW 161)
			(event claimed: 1)
			(gCurRoom newRoom: 101) ; selectRoom
		)
	)

	(method (doit)
		(if (not global186)
			(++ global186)
			(sierra doit:)
		)
	)

	(method (dispose)
		(global517 empty: dispose:)
		(DisposeScript 891)
		(super dispose:)
	)
)

(instance sierra of CardRoom
	(properties)

	(method (doit)
		(switch state
			(0
				(logo0 init:)
				(shadow0 init:)
				(self cue:)
			)
			(1
				(self cue:)
			)
			(2
				(if local0
					(logo0 setMotion: MoveTo 158 17 self)
					(shadow0 setMotion: MoveTo 166 20)
				else
					(logo0 posn: 158 17)
					(shadow0 posn: 166 20)
					(self cue:)
				)
			)
			(3
				(logo0 addToPic: 1)
				(shadow0 addToPic: 1)
				(if (>= local0 1)
					(logo1 init: setMotion: MoveTo 158 23 self)
					(shadow1 init: setMotion: MoveTo 167 26)
				else
					(logo1 init: posn: 158 23)
					(shadow1 init: posn: 167 26)
					(self cue:)
				)
			)
			(4
				(logo1 addToPic: 1)
				(shadow1 addToPic: 1)
				(if local0
					(logo2 init: setMotion: MoveTo 158 29 self)
					(shadow2 init: setMotion: MoveTo 167 32)
				else
					(logo2 init: posn: 158 29)
					(shadow2 init: posn: 167 32)
					(self cue:)
				)
			)
			(5
				(logo2 addToPic: 1)
				(shadow2 addToPic: 1)
				(if local0
					(logo3 init: setMotion: MoveTo 158 35 self)
					(shadow3 init: setMotion: MoveTo 166 38)
				else
					(logo3 init: posn: 158 35)
					(shadow3 init: posn: 166 38)
					(self cue:)
				)
			)
			(6
				(logo3 addToPic: 1)
				(shadow3 addToPic: 1)
				(if local0
					(logo4 init: setMotion: MoveTo 158 41 self)
					(shadow4 init: setMotion: MoveTo 165 44)
				else
					(logo4 init: posn: 158 41)
					(shadow4 init: posn: 165 44)
					(self cue:)
				)
			)
			(7
				(logo4 addToPic: 1)
				(shadow4 addToPic: 1)
				(if local0
					(logo5 init: setMotion: MoveTo 158 47 self)
					(shadow5 init: setMotion: MoveTo 166 50)
				else
					(logo5 init: posn: 158 47)
					(shadow5 init: posn: 166 50)
					(self cue:)
				)
			)
			(8
				(logo5 addToPic: 1)
				(shadow5 addToPic: 1)
				(if local0
					(logo6 init: setMotion: MoveTo 158 53 self)
					(shadow6 init: setMotion: MoveTo 166 56)
				else
					(logo6 init: posn: 158 53)
					(shadow6 init: posn: 166 56)
					(self cue:)
				)
			)
			(9
				(logo6 addToPic: 1)
				(shadow6 addToPic: 1)
				(if local0
					(logo7 init: setMotion: MoveTo 158 59 self)
					(shadow7 init: setMotion: MoveTo 167 62)
				else
					(logo7 init: posn: 158 59 self)
					(shadow7 init: posn: 167 62)
					(self cue:)
				)
			)
			(10
				(logo7 addToPic: 1)
				(shadow7 addToPic: 1)
				(if local0
					(logo8 init: setMotion: MoveTo 158 65 self)
					(shadow8 init: setMotion: MoveTo 166 68)
				else
					(logo8 init: posn: 158 65 self)
					(shadow8 init: posn: 166 68)
					(self cue:)
				)
			)
			(11
				(logo8 addToPic: 1)
				(shadow8 addToPic: 1)
				(if local0
					(logo9 init: setMotion: MoveTo 158 71 self)
					(shadow9 init: setMotion: MoveTo 166 74)
				else
					(logo9 init: posn: 158 71)
					(shadow9 init: posn: MoveTo 166 74)
					(self cue:)
				)
			)
			(12
				(logo9 addToPic: 1)
				(shadow9 addToPic: 1)
				(if local0
					(logo10 init: setMotion: MoveTo 158 77 self)
					(shadow10 init: setMotion: MoveTo 166 80)
				else
					(logo10 init: posn: 158 77)
					(shadow10 init: posn: 166 80)
					(self cue:)
				)
			)
			(13
				(logo10 addToPic: 1)
				(shadow10 addToPic: 1)
				(if local0
					(logo11 init: setMotion: MoveTo 158 83 self)
					(shadow11 init: setMotion: MoveTo 166 86)
				else
					(logo11 init: posn: 158 83)
					(shadow11 init: posn: 166 86)
					(self cue:)
				)
			)
			(14
				(logo11 addToPic: 1)
				(shadow11 addToPic: 1)
				(if local0
					(logo12 init: setMotion: MoveTo 158 89 self)
					(shadow12 init: setMotion: MoveTo 166 92)
				else
					(logo12 init: posn: 158 89)
					(shadow12 init: posn: 166 92)
					(self cue:)
				)
			)
			(15
				(logo12 addToPic: 1)
				(shadow12 addToPic: 1)
				(if local0
					(logo13 init: setMotion: MoveTo 158 95 self)
					(shadow13 init: setMotion: MoveTo 166 98)
				else
					(logo13 init: posn: 158 95)
					(shadow13 init: posn: 166 98)
					(self cue:)
				)
			)
			(16
				(logo13 addToPic: 1)
				(shadow13 addToPic: 1)
				(if local0
					(logo14 init: setMotion: MoveTo 158 101 self)
					(shadow14 init: setMotion: MoveTo 166 104)
				else
					(logo14 init: posn: 158 101)
					(shadow14 init: posn: 166 104)
					(self cue:)
				)
			)
			(17
				(logo14 addToPic: 1)
				(shadow14 addToPic: 1)
				(if local0
					(logo15 init: setMotion: MoveTo 158 107 self)
					(shadow15 init: setMotion: MoveTo 166 110)
				else
					(logo15 init: posn: 158 107)
					(shadow15 init: posn: 166 110)
					(self cue:)
				)
			)
			(18
				(logo15 addToPic: 1)
				(shadow15 addToPic: 1)
				(if local0
					(logo16 init: setMotion: MoveTo 158 113 self)
					(shadow16 init: setMotion: MoveTo 166 116)
				else
					(logo16 init: posn: 158 113)
					(shadow16 init: posn: 166 116)
					(self cue:)
				)
			)
			(19
				(logo16 addToPic: 1)
				(shadow16 addToPic: 1)
				(theS init: setCycle: End self)
			)
			(20
				(theS addToPic: 1)
				(theI init: setCycle: End self)
			)
			(21
				(theI addToPic: 1)
				(theE init: setCycle: End self)
			)
			(22
				(theE addToPic: 1)
				(theR1 init: setCycle: End self)
			)
			(23
				(theR1 addToPic: 1)
				(theR2 init: setCycle: End self)
			)
			(24
				(theR2 addToPic: 1)
				(theA init: setCycle: End self)
			)
			(25
				(theA addToPic: 1)
				(tradeMark init: addToPic: 1)
				(self cue:)
			)
			(26
				(Wait 30)
				(self cue:)
			)
			(27
				(presents init:)
				(Wait 30)
				(self cue:)
			)
			(28
				(gCurRoom newRoom: 100) ; introRm
			)
		)
	)

	(method (cue)
		(= global186 0)
		(++ state)
	)
)

(instance logo0 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 0
			ignoreActors: 1
			illegalBits: 0
			posn: -32 17
			setPri: 13
			setStep: 50 1
			setCycle: 0
		)
	)
)

(instance logo1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 1
			ignoreActors: 1
			illegalBits: 0
			posn: 368 23
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 2
			ignoreActors: 1
			illegalBits: 0
			posn: -52 29
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo3 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 3
			ignoreActors: 1
			illegalBits: 0
			posn: 378 35
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo4 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 4
			ignoreActors: 1
			illegalBits: 0
			posn: -62 41
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo5 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 5
			ignoreActors: 1
			illegalBits: 0
			posn: 388 47
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo6 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 6
			ignoreActors: 1
			illegalBits: 0
			posn: -72 53
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo7 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 7
			ignoreActors: 1
			illegalBits: 0
			posn: 388 59
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo8 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 0
			setCel: 8
			ignoreActors: 1
			illegalBits: 0
			posn: -72 65
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo9 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 0
			ignoreActors: 1
			illegalBits: 0
			posn: 378 71
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo10 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 1
			ignoreActors: 1
			illegalBits: 0
			posn: -62 77
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo11 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 2
			ignoreActors: 1
			illegalBits: 0
			posn: 388 83
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo12 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 3
			ignoreActors: 1
			illegalBits: 0
			posn: -62 89
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo13 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 4
			ignoreActors: 1
			illegalBits: 0
			posn: 368 95
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo14 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 5
			ignoreActors: 1
			illegalBits: 0
			posn: -32 101
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo15 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 6
			ignoreActors: 1
			illegalBits: 0
			posn: 348 107
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance logo16 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 2
			setCel: 7
			ignoreActors: 1
			illegalBits: 0
			posn: -12 113
			setPri: 13
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow0 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 0
			ignoreActors: 1
			illegalBits: 0
			posn: -24 20
			setStep: 50 1
			setCycle: 0
		)
	)
)

(instance shadow1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 1
			ignoreActors: 1
			illegalBits: 0
			posn: 376 26
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 2
			ignoreActors: 1
			illegalBits: 0
			posn: -44 32
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow3 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 3
			ignoreActors: 1
			illegalBits: 0
			posn: 386 38
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow4 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 4
			ignoreActors: 1
			illegalBits: 0
			posn: -55 44
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow5 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 5
			ignoreActors: 1
			illegalBits: 0
			posn: 396 50
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow6 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 6
			ignoreActors: 1
			illegalBits: 0
			posn: -64 56
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow7 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 7
			ignoreActors: 1
			illegalBits: 0
			posn: 397 62
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow8 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 1
			setCel: 8
			ignoreActors: 1
			illegalBits: 0
			posn: -64 68
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow9 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 0
			ignoreActors: 1
			illegalBits: 0
			posn: 386 74
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow10 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 1
			ignoreActors: 1
			illegalBits: 0
			posn: -54 80
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow11 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 2
			ignoreActors: 1
			illegalBits: 0
			posn: 396 85
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow12 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 3
			ignoreActors: 1
			illegalBits: 0
			posn: -54 92
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow13 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 4
			ignoreActors: 1
			illegalBits: 0
			posn: 376 98
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow14 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 5
			ignoreActors: 1
			illegalBits: 0
			posn: -24 104
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow15 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 6
			ignoreActors: 1
			illegalBits: 0
			posn: 356 110
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance shadow16 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 3
			setCel: 7
			ignoreActors: 1
			illegalBits: 0
			posn: -4 116
			setCycle: 0
			setStep: 50 1
		)
	)
)

(instance theS of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 4
			cel: (if (>= local0 1) 0 else 4)
			posn: 77 132
			ignoreActors: 1
		)
	)
)

(instance theI of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 5
			cel: (if (>= local0 1) 0 else 4)
			posn: 102 132
			ignoreActors: 1
		)
	)
)

(instance theE of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 6
			cel: (if (>= local0 1) 0 else 4)
			posn: 127 133
			ignoreActors: 1
		)
	)
)

(instance theR1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 7
			cel: (if (>= local0 1) 0 else 4)
			posn: 163 133
			ignoreActors: 1
		)
	)
)

(instance theR2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 7
			cel: (if (>= local0 1) 0 else 4)
			posn: 201 133
			ignoreActors: 1
		)
	)
)

(instance theA of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 900
			setLoop: 8
			cel: (if (>= local0 1) 0 else 4)
			posn: 237 133
			ignoreActors: 1
		)
	)
)

(instance presents of View
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 9 cel: 0 ignoreActors: 1 posn: 158 175)
	)
)

(instance tradeMark of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 9 cel: 1 ignoreActors: 1 posn: 270 120)
	)
)

(instance inList of InputList
	(properties)
)

