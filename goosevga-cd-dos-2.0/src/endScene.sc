;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	endScene 0
)

(instance endScene of Rm
	(properties
		picture 32
	)

	(method (init)
		(HandsOff)
		(TheMenuBar state: 0)
		(= global104 1)
		(super init:)
		(door init:)
		(goose init:)
		(humpty init:)
		(crooked init:)
		(jackAndJill init:)
		(king init:)
		(lady init:)
		(mary init:)
		(cat init:)
		(mother init:)
		(herHead init: mother)
		(Load rsVIEW 16)
		(Load rsVIEW global117)
		(gEgo posn: 164 130 init: hide:)
		((gEgo head:) hide:)
		(self setScript: gameEndScript)
	)
)

(instance gameEndScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goose setMotion: MoveTo 191 133 self)
			)
			(1
				(goose setCycle: End setMotion: MoveTo 11 135)
				(= cycles 10)
			)
			(2
				(goose setMotion: 0)
				(= cycles 13)
			)
			(3
				(goose setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(goose view: 18 setLoop: 1 setCel: 0)
				((gEgo head:) show:)
				(gEgo show: setMotion: MoveTo 125 130 self)
				(humpty setLoop: 9 setCel: 0 setCycle: End)
				(crooked setLoop: 10 setCel: 0 setCycle: End)
				(king setLoop: 8 setCel: 0 setCycle: End)
			)
			(5
				(proc0_20)
				(= global247 gCast)
				(proc0_7 gEgo mother)
				(mother say: (= register 485) self)
			)
			(6
				(crooked say: (++ register) self)
			)
			(7
				(gEgo say: (++ register) self)
			)
			(8
				(mother say: (++ register) self)
			)
			(9
				(gEgo setMotion: MoveTo 164 130 self)
			)
			(10
				((gEgo head:) hide:)
				(gEgo hide:)
				(goose
					view: (+ global114 21)
					setLoop: 3
					setCel: 255
					setCycle: Beg self
				)
			)
			(11
				(mother say: (++ register) self)
			)
			(12
				(herHead dispose:)
				(mother setLoop: 0)
				(crooked say: (++ register) self)
			)
			(13
				(DoSound sndMASTER_VOLUME global125)
				(goose setLoop: 2 setCel: 255 setCycle: Beg self)
				(humpty setCycle: Beg humpty)
				(crooked setCycle: Beg crooked)
				(king setCycle: Beg king)
				(= cycles 11)
			)
			(14
				(goose setMotion: MoveTo 11 135)
			)
			(15
				(goose
					setLoop: 1
					setCycle: Fwd
					y: (- (goose y:) 16)
					setPri:
					setMotion: MoveTo -41 65 self
				)
				(= cycles 14)
			)
			(16
				(mother setLoop: 1)
				(= cycles 16)
			)
			(17
				(mother setLoop: 2)
			)
			(18
				(gCurRoom newRoom: 93) ; cloudRoom
			)
		)
	)
)

(instance goose of Act
	(properties
		y 133
		x 281
		loop 2
		signal 26624
		cycleSpeed 1
		illegalBits 0
	)

	(method (init)
		(self view: (+ global114 21))
		(super init:)
	)
)

(instance mother of CDActor
	(properties
		y 128
		x 94
		view 92
		loop 4
		signal 26624
		illegalBits 0
	)
)

(instance herHead of Head
	(properties
		y 90
		x 94
		view 92
		loop 5
		moveHead 0
	)
)

(instance humpty of Prop
	(properties
		y 157
		x 91
		view 140
		signal 26624
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (cue)
		(= loop 0)
		(self setCycle: Fwd)
	)
)

(instance crooked of CDActor
	(properties
		y 100
		x 16
		view 140
		loop 1
		signal 26624
		cycleSpeed 2
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (say)
		(= global246 mimic)
		((= head cmHead) init: self posn: 32 95 0)
		(catHead init:)
		(okcHead init:)
		(mqcHead init:)
		(super say: &rest)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if head
			(catHead setCel: (= temp0 (head cel:)))
			(okcHead setCel: temp0)
			(mqcHead setCel: temp0)
		)
	)

	(method (cue)
		(if head
			(= global246 0)
			(super cue: &rest)
			((crooked head:) dispose:)
			(catHead dispose:)
			(okcHead dispose:)
			(mqcHead dispose:)
			(= head 0)
		else
			(= loop 1)
			(self setCycle: Fwd)
		)
	)
)

(instance cmHead of Head
	(properties
		y 95
		x 32
		view 140
		loop 11
		priority 14
		signal 16
		moveHead 0
	)
)

(instance catHead of View
	(properties
		y 88
		x 115
		view 140
		loop 12
		priority 14
		signal 24848
	)
)

(instance okcHead of View
	(properties
		y 86
		x 219
		view 140
		loop 13
		priority 14
		signal 24848
	)
)

(instance mqcHead of View
	(properties
		y 75
		x 251
		view 140
		loop 14
		priority 14
		signal 24848
	)
)

(instance mimic of Code
	(properties)

	(method (doit &tmp temp0)
		(catHead setCel: (= temp0 (cmHead cel:)))
		(okcHead setCel: temp0)
		(mqcHead setCel: temp0)
	)
)

(instance jackAndJill of View
	(properties
		y 118
		x 165
		view 140
		loop 2
		signal 26881
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance king of Prop
	(properties
		y 120
		x 220
		view 140
		loop 3
		signal 26624
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (cue)
		(= loop 3)
		(self setCycle: Fwd)
	)
)

(instance lady of View
	(properties
		y 141
		x 51
		view 140
		loop 4
		signal 26881
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance mary of View
	(properties
		y 126
		x 254
		view 140
		loop 5
		signal 26881
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance cat of View
	(properties
		y 122
		x 115
		view 140
		loop 6
		signal 26881
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance door of View
	(properties
		y 113
		x 70
		view 131
		signal 26881
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

