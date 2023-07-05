;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Osc)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm190 0
)

(instance rm190 of LLRoom
	(properties
		picture 190
	)

	(method (init)
		(LoadMany rsVIEW 190 191 192)
		(LoadMany rsSOUND 195 198 197 196 191 192 199 193 194)
		(gGame setCursor: gTheCursor 0 333 199)
		(typist1 init: cycleSpeed: (+ 2 gHowFast) setCycle: Fwd)
		(typist2 init: cycleSpeed: (+ 3 gHowFast) setCycle: Fwd)
		(smallScreen init: cycleSpeed: (+ 4 gHowFast) setCycle: Fwd)
		(nudeLady init: cycleSpeed: (+ 3 gHowFast) setCycle: Osc)
		(gGame setSpeed: 3)
		(blenderLid cycleSpeed: gHowFast init: stopUpd:)
		(shaft1 cycleSpeed: gHowFast init:)
		(platform1 cycleSpeed: gHowFast init:)
		(shaft2 cycleSpeed: gHowFast init: stopUpd:)
		(platform2 cycleSpeed: gHowFast init: stopUpd:)
		(deadLarry cycleSpeed: gHowFast init:)
		(gCurRoom setScript: sRecycle)
		(sfxFactory play:)
		(super init:)
	)
)

(instance sRecycle of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (platform2 cel:) 3)
			(deadLarry setPri: 1)
		)
		(if (and (== state 18) (== (sfxNewLarry prevSignal:) -1))
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(shaft1
					illegalBits: 0
					yStep: 1
					setLoop: 5
					setCel: 0
					setMotion: MoveTo 95 18
				)
				(platform1
					illegalBits: 0
					yStep: 1
					setLoop: 7
					setMotion: MoveTo 95 18
				)
				(deadLarry
					illegalBits: 0
					yStep: 1
					setLoop: 4
					setMotion: MoveTo 99 38 self
				)
			)
			(1
				(gTheMusic2 stop:)
				(shaft1 stopUpd:)
				(platform1 stopUpd:)
				(deadLarry stopUpd:)
				(blenderLid cycleSpeed: 4 setCycle: End self)
			)
			(2
				(sfxDumpEgo play:)
				(platform1 setCel: 1)
				(deadLarry setCel: 1 posn: 80 28)
				(= cycles 6)
			)
			(3
				(platform1 setCel: 2)
				(deadLarry setCel: 2 posn: 71 41)
				(= cycles 6)
			)
			(4
				(deadLarry setCel: 3 posn: 63 54)
				(= cycles 6)
			)
			(5
				(deadLarry setCel: 4 posn: 60 64 setCycle: End self)
			)
			(6
				(platform1 cycleSpeed: 3 setCycle: Beg self)
			)
			(7
				(platform1 stopUpd:)
				(blenderLid cycleSpeed: 3 setCycle: Beg self)
				(sfxLidCloses play:)
			)
			(8
				(blenderLid stopUpd:)
				(= cycles 30)
			)
			(9
				(sfxBlender play: hold: 10)
				(deadLarry setLoop: 1 posn: 63 66 cycleSpeed: 4 setCycle: Fwd)
				(= cycles 30)
			)
			(10
				(deadLarry cycleSpeed: 3)
				(= cycles 30)
			)
			(11
				(deadLarry cycleSpeed: 2)
				(= cycles 30)
			)
			(12
				(deadLarry cycleSpeed: 1)
				(= cycles 30)
			)
			(13
				(deadLarry cycleSpeed: 0)
				(= cycles 30)
			)
			(14
				(deadLarry setLoop: 2)
				(= seconds 6)
			)
			(15
				(sfxBlender release:)
				(deadLarry
					cycleSpeed: 4
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(16
				(sfxGurgle play:)
				(deadLarry
					view: 191
					setPri: 6
					posn: 48 92
					cycleSpeed: 6
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(17
				(= cycles 5)
			)
			(18
				(sfxGurgle stop:)
				(sfxNewLarry play:)
				(deadLarry hide:)
			)
			(19
				(sfxNewLarry stop:)
				(sfxSquirt play:)
				(deadLarry
					show:
					posn: 232 126
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(20
				(sfxSquirt stop:)
				(sfxConveyor play:)
				(deadLarry setStep: 1 1 setMotion: MoveTo 187 137 self)
			)
			(21
				(sfxConveyor stop:)
				(sfxGroundOpens play:)
				(= seconds 3)
			)
			(22
				(sfxGroundOpens stop:)
				(sfxElevator play:)
				(deadLarry setPri: 12 yStep: 1 setMotion: MoveTo 187 0)
				(platform2
					setLoop: 6
					setPri: 8
					setCycle: Walk
					setStep: 1 1
					cycleSpeed: 20
					setMotion: MoveTo 189 0
				)
				(shaft2
					setLoop: 5
					setStep: 1 1
					setPri: 4
					setMotion: MoveTo 189 0 self
				)
			)
			(23
				(sfxElevator fade:)
				(= seconds 2)
			)
			(24
				(Print 190 0 #at -1 140) ; "(Now you know what we have to go through every time you press "Restart!")"
				(gGame restart:)
			)
		)
	)
)

(instance sfxLidCloses of Sound
	(properties
		number 802
	)
)

(instance sfxGroundOpens of Sound
	(properties
		number 191
	)
)

(instance sfxElevator of Sound
	(properties
		flags 1
		number 192
	)
)

(instance sfxDumpEgo of Sound
	(properties
		number 194
	)
)

(instance sfxBlender of Sound
	(properties
		number 195
	)
)

(instance sfxFactory of Sound
	(properties
		number 193
		loop -1
	)
)

(instance sfxGurgle of Sound
	(properties
		number 196
		loop -1
	)
)

(instance sfxNewLarry of Sound
	(properties
		number 197
	)
)

(instance sfxSquirt of Sound
	(properties
		number 198
		loop -1
	)
)

(instance sfxConveyor of Sound
	(properties
		number 199
	)
)

(instance deadLarry of Actor
	(properties
		x 99
		y 28
		view 190
		loop 4
		signal 16384
	)
)

(instance shaft1 of Actor
	(properties
		x 95
		y 8
		yStep 1
		view 190
		loop 5
		priority 1
		signal 16400
	)
)

(instance platform1 of Actor
	(properties
		x 95
		y 8
		yStep 1
		view 190
		loop 7
		priority 5
		signal 16400
	)
)

(instance shaft2 of Actor
	(properties
		x 189
		y 141
		yStep 1
		view 190
		loop 5
		priority 1
		signal 16400
	)
)

(instance platform2 of Actor
	(properties
		x 189
		y 141
		yStep 1
		view 190
		loop 6
		priority 1
		signal 16400
	)
)

(instance nudeLady of Actor
	(properties
		x 45
		y 166
		yStep 8
		view 192
		loop 3
		detailLevel 1
	)
)

(instance blenderLid of Prop
	(properties
		x 43
		y 34
		view 190
	)
)

(instance typist1 of Prop
	(properties
		x 7
		y 143
		view 192
		detailLevel 1
	)
)

(instance smallScreen of Prop
	(properties
		x 77
		y 148
		view 192
		loop 1
		detailLevel 1
	)
)

(instance typist2 of Prop
	(properties
		x 72
		y 158
		view 192
		loop 2
		detailLevel 1
	)
)

