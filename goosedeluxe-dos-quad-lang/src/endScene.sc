;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use MGNarrator)
(use Head)
(use ROsc)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	endScene 0
)

(local
	local0
)

(instance endScene of Room
	(properties
		picture 32
	)

	(method (init)
		(proc0_2)
		(= global300 0)
		(= global104 1)
		(super init:)
		(= global516 gNarrator)
		(= gNarrator mgNarrator)
		(door init:)
		(goose init:)
		(humpty init:)
		(crooked init:)
		(jackAndJill init:)
		(king init:)
		(lady init:)
		(mary init:)
		(fiddleCat init:)
		(mother init:)
		(herHead init: mother view: 93 z: 32)
		(Load rsVIEW 16)
		(Load rsVIEW global117)
		(gEgo posn: 164 130 init: hide:)
		(self setScript: gameEndScript)
	)

	(method (dispose)
		(= gNarrator global516)
		(super dispose: &rest)
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
				(goose view: 18 setLoop: 1 setCel: 0 ignoreActors: 1)
				(gEgo
					posn: (- (goose x:) 1) (- (goose y:) 2)
					show:
					setMotion: MoveTo 125 130 self
				)
				(humpty setLoop: 9 setCel: 0 setCycle: End)
				(crooked setLoop: 10 setCel: 0 setCycle: End)
				(king setLoop: 8 setCel: 0 setCycle: End)
			)
			(5
				(proc0_20)
				(= global247 gCast)
				(proc0_7 gEgo mother)
				(gMessager say: 1 1 27 1 self 0) ; "You did great! What a wonderful child you are! Now my nursery rhymes are all fixed and working fine. We will never forget what you did for us. Right, gang?"
			)
			(6
				(= global303 1)
				(= local0 1)
				(gMessager say: 1 1 27 2 self 0) ; "Right, Mother Goose!"
				(= global303 0)
			)
			(7
				(= local0 0)
				(gMessager say: 1 1 27 3 self 0) ; "Ah. It was nothing."
			)
			(8
				(gMessager say: 1 1 27 4 self 0) ; "Oh, dear! It's almost morning! You'd better go home now."
			)
			(9
				(gEgo
					setMotion: MoveTo (- (goose x:) 1) (- (goose y:) 1) self
				)
			)
			(10
				(gEgo hide:)
				(goose
					view: (+ global114 21)
					setLoop: 3
					setCel: 255
					setCycle: Beg self
				)
			)
			(11
				(gMessager say: 1 1 27 5 self 0) ; "Good-bye! We'll miss you!"
			)
			(12
				(herHead dispose:)
				(mother view: 93 setLoop: 8 cel: 0)
				(= global303 1)
				(= local0 1)
				(gMessager say: 1 1 27 6 self 0) ; "Yes! Good-bye! Good-bye!"
				(= global303 0)
			)
			(13
				(= local0 0)
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
				(mother cel: 1)
				(= cycles 16)
			)
			(17
				(mother cel: 2)
			)
			(18
				((gCurRoom plane:) setRect: 0 0 319 199)
				(gCurRoom newRoom: 93) ; cloudRoom
			)
		)
	)
)

(instance goose of Actor
	(properties
		x 281
		y 133
		loop 2
		cycleSpeed 4
		illegalBits 0
	)

	(method (init)
		(self view: (+ global114 21))
		(super init:)
	)
)

(instance mother of Actor
	(properties
		x 94
		y 128
		view 92
		loop 4
		illegalBits 0
	)
)

(instance herHead of Head
	(properties
		view 93
		loop 7
	)
)

(instance humpty of Prop
	(properties
		x 91
		y 153
		view 140
		cycleSpeed 4
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

(instance crooked of Actor
	(properties
		x 16
		y 100
		view 140
		loop 1
		cycleSpeed 4
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance cmHead of Head
	(properties
		x 32
		y 95
		priority 14
		view 140
		loop 11
	)
)

(instance catHead of Prop
	(properties
		x 115
		y 88
		priority 14
		view 140
		loop 12
	)
)

(instance okcHead of Prop
	(properties
		x 219
		y 86
		priority 14
		view 140
		loop 13
	)
)

(instance mqcHead of Prop
	(properties
		x 251
		y 75
		priority 14
		view 140
		loop 14
	)
)

(instance mimic of Code ; UNUSED
	(properties)

	(method (doit &tmp temp0)
		(catHead setCel: (= temp0 (cmHead cel:)))
		(okcHead setCel: temp0)
		(mqcHead setCel: temp0)
	)
)

(instance jackAndJill of View
	(properties
		x 165
		y 118
		view 140
		loop 2
	)

	(method (init)
		(super init:)
	)
)

(instance king of Prop
	(properties
		x 220
		y 120
		view 140
		loop 3
		cycleSpeed 4
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
		x 51
		y 141
		view 140
		loop 4
	)

	(method (init)
		(super init:)
	)
)

(instance mary of View
	(properties
		x 254
		y 126
		view 140
		loop 5
	)

	(method (init)
		(super init:)
	)
)

(instance fiddleCat of View
	(properties
		x 115
		y 122
		view 140
		loop 6
	)

	(method (init)
		(super init:)
	)
)

(instance door of View
	(properties
		x 70
		y 113
		view 131
	)

	(method (init)
		(super init:)
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(26
				(herHead setCycle: ROsc 10000 0)
			)
			(9
				(if local0
					(doGroupTalk doit: 1)
				else
					(self doEgoTalk:)
				)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(26
				(herHead cel: 0 setCycle: 0)
			)
			(9
				(if local0
					(doGroupTalk doit: 0)
				else
					(self doEgoQuiet:)
				)
			)
		)
		(super dispose:)
	)
)

(instance doGroupTalk of Code
	(properties)

	(method (doit param1)
		(if (and argc param1)
			(catHead init: setPri: 200 setCycle: ROsc 10000 0)
			(okcHead init: setPri: 200 setCycle: ROsc 10000 0 z: 20)
			(mqcHead init: setPri: 200 setCycle: ROsc 10000 0)
		else
			(catHead dispose:)
			(okcHead dispose:)
			(mqcHead dispose:)
		)
	)
)

