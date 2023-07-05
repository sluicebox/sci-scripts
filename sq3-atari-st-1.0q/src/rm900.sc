;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm900 0
)

(instance rm900 of Rm
	(properties
		picture 900
	)

	(method (init &tmp temp0 [temp1 50])
		(= gShowStyle 16)
		(User canInput: 1 canControl: 1)
		(Load rsVIEW 900)
		(super init:)
		(while ((= temp0 (Event new:)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(self setScript: rmScript)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (event type:)
			(= gNormalCursor 999)
			(gGame setCursor: 999 (HaveMouse))
			(gCurRoom newRoom: 2)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(logo0 init:)
				(shadow0 init:)
				(= cycles 10)
			)
			(1
				(= global159 1)
				(gLongSong play:)
				(= cycles 10)
			)
			(2
				(if global124
					(logo0 setMotion: MoveTo 158 17 self)
					(shadow0 setMotion: MoveTo 166 20)
				else
					(logo0 posn: 158 17)
					(shadow0 posn: 166 20)
					(= cycles 1)
				)
			)
			(3
				(logo0 stopUpd:)
				(shadow0 stopUpd:)
				(if (>= global124 1)
					(logo1 init: setMotion: MoveTo 158 23 self)
					(shadow1 init: setMotion: MoveTo 167 26)
				else
					(logo1 init: posn: 158 23)
					(shadow1 init: posn: 167 26)
					(= cycles 1)
				)
			)
			(4
				(logo1 stopUpd:)
				(shadow1 stopUpd:)
				(if global124
					(logo2 init: setMotion: MoveTo 158 29 self)
					(shadow2 init: setMotion: MoveTo 167 32)
				else
					(logo2 init: posn: 158 29)
					(shadow2 init: posn: 167 32)
					(= cycles 1)
				)
			)
			(5
				(logo2 stopUpd:)
				(shadow2 stopUpd:)
				(if global124
					(logo3 init: setMotion: MoveTo 158 35 self)
					(shadow3 init: setMotion: MoveTo 166 38)
				else
					(logo3 init: posn: 158 35)
					(shadow3 init: posn: 166 38)
					(= cycles 1)
				)
			)
			(6
				(logo3 stopUpd:)
				(shadow3 stopUpd:)
				(if global124
					(logo4 init: setMotion: MoveTo 158 41 self)
					(shadow4 init: setMotion: MoveTo 165 44)
				else
					(logo4 init: posn: 158 41)
					(shadow4 init: posn: 165 44)
					(= cycles 1)
				)
			)
			(7
				(logo4 stopUpd:)
				(shadow4 stopUpd:)
				(if global124
					(logo5 init: setMotion: MoveTo 158 47 self)
					(shadow5 init: setMotion: MoveTo 166 50)
				else
					(logo5 init: posn: 158 47)
					(shadow5 init: posn: 166 50)
					(= cycles 1)
				)
			)
			(8
				(logo5 stopUpd:)
				(shadow5 stopUpd:)
				(if global124
					(logo6 init: setMotion: MoveTo 158 53 self)
					(shadow6 init: setMotion: MoveTo 166 56)
				else
					(logo6 init: posn: 158 53)
					(shadow6 init: posn: 166 56)
					(= cycles 1)
				)
			)
			(9
				(logo6 stopUpd:)
				(shadow6 stopUpd:)
				(if global124
					(logo7 init: setMotion: MoveTo 158 59 self)
					(shadow7 init: setMotion: MoveTo 167 62)
				else
					(logo7 init: posn: 158 59 self)
					(shadow7 init: posn: 167 62)
					(= cycles 1)
				)
			)
			(10
				(logo7 stopUpd:)
				(shadow7 stopUpd:)
				(if global124
					(logo8 init: setMotion: MoveTo 158 65 self)
					(shadow8 init: setMotion: MoveTo 166 68)
				else
					(logo8 init: posn: 158 65 self)
					(shadow8 init: posn: 166 68)
					(= cycles 1)
				)
			)
			(11
				(logo8 stopUpd:)
				(shadow8 stopUpd:)
				(if global124
					(logo9 init: setMotion: MoveTo 158 71 self)
					(shadow9 init: setMotion: MoveTo 166 74)
				else
					(logo9 init: posn: 158 71)
					(shadow9 init: posn: MoveTo 166 74)
					(= cycles 1)
				)
			)
			(12
				(logo9 stopUpd:)
				(shadow9 stopUpd:)
				(if global124
					(logo10 init: setMotion: MoveTo 158 77 self)
					(shadow10 init: setMotion: MoveTo 166 80)
				else
					(logo10 init: posn: 158 77)
					(shadow10 init: posn: 166 80)
					(= cycles 1)
				)
			)
			(13
				(logo10 stopUpd:)
				(shadow10 stopUpd:)
				(if global124
					(logo11 init: setMotion: MoveTo 158 83 self)
					(shadow11 init: setMotion: MoveTo 166 86)
				else
					(logo11 init: posn: 158 83)
					(shadow11 init: posn: 166 86)
					(= cycles 1)
				)
			)
			(14
				(logo11 stopUpd:)
				(shadow11 stopUpd:)
				(if global124
					(logo12 init: setMotion: MoveTo 158 89 self)
					(shadow12 init: setMotion: MoveTo 166 92)
				else
					(logo12 init: posn: 158 89)
					(shadow12 init: posn: 166 92)
					(= cycles 1)
				)
			)
			(15
				(logo12 stopUpd:)
				(shadow12 stopUpd:)
				(if global124
					(logo13 init: setMotion: MoveTo 158 95 self)
					(shadow13 init: setMotion: MoveTo 166 98)
				else
					(logo13 init: posn: 158 95)
					(shadow13 init: posn: 166 98)
					(= cycles 1)
				)
			)
			(16
				(logo13 stopUpd:)
				(shadow13 stopUpd:)
				(if global124
					(logo14 init: setMotion: MoveTo 158 101 self)
					(shadow14 init: setMotion: MoveTo 166 104)
				else
					(logo14 init: posn: 158 101)
					(shadow14 init: posn: 166 104)
					(= cycles 1)
				)
			)
			(17
				(logo14 stopUpd:)
				(shadow14 stopUpd:)
				(if global124
					(logo15 init: setMotion: MoveTo 158 107 self)
					(shadow15 init: setMotion: MoveTo 166 110)
				else
					(logo15 init: posn: 158 107)
					(shadow15 init: posn: 166 110)
					(= cycles 1)
				)
			)
			(18
				(logo15 stopUpd:)
				(shadow15 stopUpd:)
				(if global124
					(logo16 init: setMotion: MoveTo 158 113 self)
					(shadow16 init: setMotion: MoveTo 166 116)
				else
					(logo16 init: posn: 158 113)
					(shadow16 init: posn: 166 116)
					(= cycles 1)
				)
			)
			(19
				(logo16 stopUpd:)
				(shadow16 stopUpd:)
				(theS init: setCycle: End self)
			)
			(20
				(theS stopUpd:)
				(theI init: setCycle: End self)
			)
			(21
				(theI stopUpd:)
				(theE init: setCycle: End self)
			)
			(22
				(theE stopUpd:)
				(theR1 init: setCycle: End self)
			)
			(23
				(theR1 stopUpd:)
				(theR2 init: setCycle: End self)
			)
			(24
				(theR2 stopUpd:)
				(theA init: setCycle: End self)
			)
			(25
				(theA stopUpd:)
				(= seconds 2)
			)
			(26
				(presents init:)
				(= seconds 2)
			)
			(27
				(gCurRoom newRoom: 1)
			)
		)
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			setPri: 15
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
			cel: (if (>= global124 1) 0 else 4)
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
			cel: (if (>= global124 1) 0 else 4)
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
			cel: (if (>= global124 1) 0 else 4)
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
			cel: (if (>= global124 1) 0 else 4)
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
			cel: (if (>= global124 1) 0 else 4)
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
			cel: (if (>= global124 1) 0 else 4)
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

