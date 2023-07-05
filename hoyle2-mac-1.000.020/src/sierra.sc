;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sierra 0
)

(local
	local0
)

(instance sierra of Rm
	(properties
		picture 18
	)

	(method (init &tmp temp0)
		(if (== (Graph grGET_COLOURS) 16)
			(= picture 12)
		)
		(= global303 0)
		(Load rsVIEW 900)
		(Load rsVIEW 604)
		(super init:)
		(SetCursor gTheCursor 1 319 199)
		(while ((= temp0 (Event new:)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(if (not (GameIsRestarting))
			(gTheSound number: 10 play:)
		)
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(= gNewRoomNum 2) ; selectRoom
		)
	)

	(method (dispose)
		(CT dispose:)
		(End dispose:)
		(super dispose:)
	)

	(method (doit)
		(if (not global303)
			(++ global303)
			(switch local0
				(0
					(logo0 init:)
					(shadow0 init:)
					(self cue:)
				)
				(1
					(self cue:)
				)
				(2
					(logo0 setMotion: MoveTo 155 17 self)
					(shadow0 setMotion: MoveTo 163 20)
				)
				(3
					(logo0 addToPic: 1)
					(shadow0 addToPic: 1)
					(logo1 init: setMotion: MoveTo 155 23 self)
					(shadow1 init: setMotion: MoveTo 164 26)
				)
				(4
					(logo1 addToPic: 1)
					(shadow1 addToPic: 1)
					(logo2 init: setMotion: MoveTo 155 29 self)
					(shadow2 init: setMotion: MoveTo 164 32)
				)
				(5
					(logo2 addToPic: 1)
					(shadow2 addToPic: 1)
					(logo3 init: setMotion: MoveTo 155 35 self)
					(shadow3 init: setMotion: MoveTo 163 38)
				)
				(6
					(logo3 addToPic: 1)
					(shadow3 addToPic: 1)
					(logo4 init: setMotion: MoveTo 155 41 self)
					(shadow4 init: setMotion: MoveTo 162 44)
				)
				(7
					(logo4 addToPic: 1)
					(shadow4 addToPic: 1)
					(logo5 init: setMotion: MoveTo 155 47 self)
					(shadow5 init: setMotion: MoveTo 163 50)
				)
				(8
					(logo5 addToPic: 1)
					(shadow5 addToPic: 1)
					(logo6 init: setMotion: MoveTo 155 53 self)
					(shadow6 init: setMotion: MoveTo 163 56)
				)
				(9
					(logo6 addToPic: 1)
					(shadow6 addToPic: 1)
					(logo7 init: setMotion: MoveTo 155 59 self)
					(shadow7 init: setMotion: MoveTo 164 62)
				)
				(10
					(logo7 addToPic: 1)
					(shadow7 addToPic: 1)
					(logo8 init: setMotion: MoveTo 155 65 self)
					(shadow8 init: setMotion: MoveTo 163 68)
				)
				(11
					(logo8 addToPic: 1)
					(shadow8 addToPic: 1)
					(logo9 init: setMotion: MoveTo 155 71 self)
					(shadow9 init: setMotion: MoveTo 163 74)
				)
				(12
					(logo9 addToPic: 1)
					(shadow9 addToPic: 1)
					(logo10 init: setMotion: MoveTo 155 77 self)
					(shadow10 init: setMotion: MoveTo 163 80)
				)
				(13
					(logo10 addToPic: 1)
					(shadow10 addToPic: 1)
					(logo11 init: setMotion: MoveTo 153 83 self)
					(shadow11 init: setMotion: MoveTo 163 86)
				)
				(14
					(logo11 addToPic: 1)
					(shadow11 addToPic: 1)
					(logo12 init: setMotion: MoveTo 155 89 self)
					(shadow12 init: setMotion: MoveTo 163 92)
				)
				(15
					(logo12 addToPic: 1)
					(shadow12 addToPic: 1)
					(logo13 init: setMotion: MoveTo 155 95 self)
					(shadow13 init: setMotion: MoveTo 163 98)
				)
				(16
					(logo13 addToPic: 1)
					(shadow13 addToPic: 1)
					(logo14 init: setMotion: MoveTo 155 101 self)
					(shadow14 init: setMotion: MoveTo 163 104)
				)
				(17
					(logo14 addToPic: 1)
					(shadow14 addToPic: 1)
					(logo15 init: setMotion: MoveTo 155 107 self)
					(shadow15 init: setMotion: MoveTo 163 110)
				)
				(18
					(logo15 addToPic: 1)
					(shadow15 addToPic: 1)
					(logo16 init: setMotion: MoveTo 155 113 self)
					(shadow16 init: setMotion: MoveTo 163 116)
				)
				(19
					(logo16 addToPic: 1)
					(shadow16 addToPic: 1)
					(theS init: setCycle: End self)
				)
				(20
					(theI init: setCycle: End self)
				)
				(21
					(theE init: setCycle: End self)
				)
				(22
					(theR1 init: setCycle: End self)
				)
				(23
					(theR2 init: setCycle: End self)
				)
				(24
					(theA init: setCycle: End self)
				)
				(25
					(tradeMark init:)
					(presents init:)
					(self cue:)
				)
				(26
					(Wait 90)
					(self cue:)
				)
				(27
					(Wait 90)
					(self cue:)
				)
				(28
					(theS dispose:)
					(theI dispose:)
					(theE dispose:)
					(theR1 dispose:)
					(theR2 dispose:)
					(theA dispose:)
					(presents dispose:)
					(tradeMark dispose:)
					(self cue:)
				)
				(29
					(Wait 90)
					(hoyleName init:)
					(self cue:)
				)
				(30
					(Wait 300)
					(self cue:)
				)
				(31
					(hoyleName dispose:)
					(self cue:)
				)
				(32
					(Wait 90)
					(creditTitle cel: 1 init:)
					(creditName cel: 1 init:)
					(if (== (Graph grGET_COLOURS) 16)
						(creditTitle cel: 3)
						(creditName cel: 3)
					)
					(mask init:)
				)
				(33
					(Wait 180)
					(self cue:)
				)
				(34
					(creditTitle posn: 500 500 forceUpd:)
					(creditName posn: 500 500 forceUpd:)
					(mask posn: 500 500 forceUpd:)
					(self cue:)
				)
				(35
					(Wait 90)
					(self cue:)
				)
				(36
					(creditTitle cel: 0 init:)
					(creditName cel: 0 init:)
					(if (== (Graph grGET_COLOURS) 16)
						(creditTitle cel: 2)
						(creditName cel: 2)
					)
					(mask init:)
				)
				(37
					(Wait 180)
					(creditTitle posn: 500 500 forceUpd:)
					(creditName posn: 500 500 forceUpd:)
					(mask posn: 500 500 forceUpd:)
					(self cue:)
				)
				(38
					(= gNewRoomNum 2) ; selectRoom
				)
			)
		)
	)

	(method (cue)
		(= global303 0)
		(++ local0)
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
		(self view: 900 setLoop: 4 cel: 0 posn: 77 132)
	)
)

(instance theI of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 5 cel: 0 posn: 102 132)
	)
)

(instance theE of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 6 cel: 0 posn: 127 133)
	)
)

(instance theR1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 7 cel: 0 posn: 163 133)
	)
)

(instance theR2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 7 cel: 0 posn: 201 133)
	)
)

(instance theA of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 8 cel: 0 posn: 237 133)
	)
)

(instance presents of View
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 9 cel: 0 posn: 158 175)
	)
)

(instance tradeMark of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 900 setLoop: 9 cel: 1 posn: 270 120)
	)
)

(instance hoyleName of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 604
			setLoop: 6
			cel: (if (== (Graph grGET_COLOURS) 16) 1 else 0)
			posn: 158 150
		)
	)
)

(instance creditTitle of View
	(properties)

	(method (init)
		(super init:)
		(self view: 604 setLoop: 7 posn: 158 140)
	)
)

(instance creditName of View
	(properties)

	(method (init)
		(super init:)
		(self view: 604 setLoop: 8 priority: 8 posn: 158 160)
	)
)

(instance mask of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 604
			setLoop: 9
			cel: 0
			posn: 158 160
			cycleSpeed: 2
			priority: 10
			setCycle: End sierra
		)
	)
)

