;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use smell)
(use ADRoom)
(use Scaler)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm601 0
)

(local
	local0 = 1
)

(instance rm601 of ADRoom
	(properties
		horizon 75
		vanishingY -60
	)

	(method (init)
		(proc875_0)
		(switch gAct
			(1
				(self picture: 200)
			)
			(2
				(self picture: 200)
			)
			(3
				(self picture: 345)
			)
			(4
				(self picture: 350)
			)
			(5
				(self picture: 530)
			)
			(6
				(self picture: 380)
			)
		)
		(super init: &rest)
		(gTheIconBar disable:)
		(if (== gPrevRoomNum 600)
			(= local0 0)
		)
		(switch gAct
			(1
				(gCurRoom setScript: sPickAct1)
			)
			(2
				(gCurRoom setScript: sPickAct2)
			)
			(3
				(gCurRoom setScript: sPickAct3)
			)
			(4
				(gCurRoom setScript: sPickAct4)
			)
			(5
				(gCurRoom setScript: sPickAct5)
			)
			(6
				(frontDoors init: stopUpd:)
				(gCurRoom setScript: sPickAct6)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gNarrator keepWindow: 0)
		(ClearFlag 2)
		(ClearFlag 77)
		(gTheIconBar enable:)
		(= gNormalCursor ((gTheIconBar at: 0) cursor:))
		(super newRoom: newRoomNumber)
	)
)

(instance sWhat2Look4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 420 10)
				(gCast eachElementDo: #dispose)
				(= cycles 1)
			)
			(1
				(gNarrator keepWindow: 1)
				(gMessager say: 7 0 gAct 2 self 110)
			)
			(2
				(if local0
					(switch gAct
						(2
							(gMessager say: 7 0 gAct 3 5 self 110) ; "The Story Thus Far: Our heroine Pepper Pumpernickel and her newshound Lockjaw have been sent through time by the wicked Uncle Fred! He's mixed up colonial Philadelphia with the 1960's, and the results are not pretty."
						)
						(3
							(gMessager say: 7 0 gAct 3 6 self 110) ; "The Story Thus Far: Pepper Pumpernickel and her newshound Lockjaw have been sent through time by the wicked Uncle Fred. Fred has mixed colonial Philadelphia with the 1960's, and the results are truly weird! After freeing the mysterious Poor Richard, Pepper and Lockjaw were arrested and locked in a storage shed."
						)
						(4
							(gMessager say: 7 0 gAct 3 7 self 110) ; "The Story Thus Far: Pepper Pumpernickel and her newshound Lockjaw have been sent through time by the wicked Uncle Fred. He's mixed up colonial Philadelphia with the year 1968, and the results are truly weird! Pepper freed a mysterious character named Poor Richard from the stocks, and was arrested and thrown into a storage shed for her troubles."
						)
						(5
							(gMessager say: 7 0 gAct 3 8 self 110) ; "The Story Thus Far: Pepper Pumpernickel and her dog Lockjaw have been propelled through time by the dreaded Uncle Fred. Fred has mixed up colonial Philadelphia with the 1960's, and the results are horrifying! Pepper rescued the mysterious Poor Richard from the town stocks, and was immediately arrested and thrown into a shed by the local watchman."
						)
						(6
							(gMessager say: 7 0 gAct 3 11 self 110) ; "The Story Thus Far: Pepper Pumpernickel and her dog Lockjaw have been sent through time by the evil Uncle Fred. Fred has mixed up colonial Philadelphia with the 1960's, and the results are awful! Pepper freed a strange character named Poor Richard from the town stocks, and was promptly arrested and thrown into a storage shed for her troubles."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sPickAct1 of Script
	(properties)

	(method (changeState newState &tmp [temp0 601])
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 200)
				(fallView init:)
				(crash init: hide:)
				(Load rsVIEW 835 837)
				(gGame setCursor: 996 1 100 100)
				(= cycles 1)
			)
			(1
				(sFX number: 942 play:)
				(actLetters init: addToPic:)
				(actNum init: addToPic:)
			)
			(2
				(shortMsg init: stopUpd:)
			)
			(3
				(littleOr init: stopUpd:)
				(= seconds 3)
			)
			(4
				(sFX number: 943 play:)
				(fallView
					setLoop: 0
					setStep: 1 15
					setMotion: MoveTo 150 132 self
				)
			)
			(5
				(crash addToPic:)
				(sFX stop:)
				(= cycles 1)
			)
			(6
				(fallView setMotion: MoveTo 150 132 self)
			)
			(7
				(sFX number: 1209 play: self)
				(ShakeScreen 5 ssLEFTRIGHT)
			)
			(8
				(sFX number: 945 loop: 1 play: self)
			)
			(9
				(= seconds 4)
			)
			(10
				(self setScript: sWhat2Look4 self)
			)
			(11
				(= cycles 4)
			)
			(12
				(gCurRoom newRoom: 120)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and (>= (= temp0 (sFX prevSignal:)) 10) (== state 1))
				(self cue:)
			)
			((and (>= temp0 20) (== state 2))
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance sPickAct2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(kooky init: setLoop: 1 setStep: 69 1)
			)
			(1
				(sFX number: 942 play:)
				(actLetters posn: 77 8 init: addToPic:)
				(actNum cel: 2 posn: 205 7 init: addToPic:)
			)
			(2
				(shortMsg loop: 3 posn: 56 52 init: stopUpd:)
			)
			(3
				(littleOr posn: 128 80 init: stopUpd:)
				(= ticks 180)
			)
			(4
				(sFX number: 946 play: self)
				(kooky setMotion: MoveTo 153 124 self)
			)
			(5 0)
			(6
				(sFX number: 947 play:)
				(kooky addToPic:)
				(= seconds 4)
			)
			(7
				(self setScript: sWhat2Look4 self)
			)
			(8
				(= cycles 4)
			)
			(9
				(gCurRoom newRoom: 210)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and (>= (= temp0 (sFX prevSignal:)) 10) (== state 1))
				(self cue:)
			)
			((and (>= temp0 20) (== state 2))
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance sPickAct3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(sFX number: 942 play:)
				(actLetters posn: 63 30 setPri: 10 init: addToPic:)
				(actNum cel: 3 posn: 197 29 init: addToPic:)
			)
			(2
				(shortMsg loop: 4 posn: 29 71 init: stopUpd:)
			)
			(3
				(littleOr posn: 134 99 init: stopUpd:)
				(= seconds 3)
			)
			(4
				(zap init:)
				(lightning setScale: Scaler 100 184 189 15 init: setCycle: Fwd)
				(= ticks 3)
			)
			(5
				(sFX number: 3452 play:)
				(Palette palSET_INTENSITY 0 255 (Random 300 500))
				(= ticks 3)
			)
			(6
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 2)
			)
			(7
				(lightning dispose:)
				(= cycles 1)
			)
			(8
				(zap setCycle: CT 4 1 self)
			)
			(9
				(zap cel: 0)
				(= ticks 200)
			)
			(10
				(zap cel: 5 setCycle: End self)
				(sFX number: 948 play:)
			)
			(11
				(zap dispose:)
				(= ticks 160)
			)
			(12
				(self setScript: sWhat2Look4 self)
			)
			(13
				(= cycles 4)
			)
			(14
				(gCurRoom newRoom: 330)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and (>= (= temp0 (sFX prevSignal:)) 10) (== state 1))
				(self cue:)
			)
			((and (>= temp0 20) (== state 2))
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance sPickAct4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(banner init: hide:)
				(sFX number: 942 play:)
				(actLetters posn: 51 5 init: addToPic:)
				(actNum cel: 4 posn: 186 5 init: addToPic:)
			)
			(2
				(shortMsg loop: 5 posn: 55 45 init: stopUpd:)
			)
			(3
				(littleOr posn: 130 66 init: stopUpd:)
				(= seconds 4)
			)
			(4
				(sFX number: 415 play:)
				(banner show: setCycle: End self)
			)
			(5
				(banner addToPic:)
				(= cycles 1)
			)
			(6
				(= seconds 4)
			)
			(7
				(self setScript: sWhat2Look4 self)
			)
			(8
				(= cycles 4)
			)
			(9
				(gCurRoom newRoom: 330)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and (>= (= temp0 (sFX prevSignal:)) 10) (== state 1))
				(self cue:)
			)
			((and (>= temp0 20) (== state 2))
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance sPickAct5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(act5View init: hide:)
				(act5Txt init: hide:)
				(sFX number: 942 play:)
				(actLetters posn: 51 5 init: addToPic:)
				(actNum cel: 5 posn: 186 5 init: addToPic:)
			)
			(2
				(shortMsg loop: 6 posn: 8 44 init: stopUpd:)
			)
			(3
				(littleOr posn: 130 63 init: stopUpd:)
				(= seconds 4)
			)
			(4
				(sFX number: 234 play:)
				(act5View show: addToPic:)
				(act5Txt show: setCycle: End self)
			)
			(5
				(act5Txt addToPic:)
				(= cycles 1)
			)
			(6
				(= seconds 4)
			)
			(7
				(sFX fade:)
				(= cycles 1)
			)
			(8
				(self setScript: sWhat2Look4 self)
			)
			(9
				(= cycles 4)
			)
			(10
				(gCurRoom newRoom: 320)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and (>= (= temp0 (sFX prevSignal:)) 10) (== state 1))
				(self cue:)
			)
			((and (>= temp0 20) (== state 2))
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance sPickAct6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(act6L1 init: hide:)
				(act6L2 init: hide:)
				(sFX number: 942 play:)
				(actLetters posn: 64 5 setPri: 15 init: addToPic:)
				(actNum cel: 6 posn: 210 5 setPri: 15 init: addToPic:)
			)
			(2
				(shortMsg loop: 7 posn: 29 43 setPri: 15 init: stopUpd:)
			)
			(3
				(littleOr posn: 130 66 setPri: 15 init: stopUpd:)
				(= ticks 180)
			)
			(4
				(act6L1 show: addToPic:)
				(sFX number: 954 play:)
			)
			(5
				(act6L2 show: addToPic:)
				(= seconds 4)
			)
			(6
				(self setScript: sWhat2Look4 self)
			)
			(7
				(= cycles 4)
			)
			(8
				(gCurRoom newRoom: 320)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and (>= (= temp0 (sFX prevSignal:)) 10) (== state 1))
				(self cue:)
			)
			((and (>= temp0 20) (== state 2))
				(self cue:)
			)
			((and (>= temp0 10) (== state 4))
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance actLetters of View
	(properties
		x 72
		y 10
		view 836
		signal 16384
	)
)

(instance actNum of View
	(properties
		x 204
		y 9
		view 836
		cel 1
		signal 16384
	)
)

(instance shortMsg of Prop
	(properties
		x 59
		y 50
		view 836
		loop 2
		priority 10
		signal 16401
	)
)

(instance littleOr of View
	(properties
		x 128
		y 78
		view 836
		loop 1
		priority 10
		signal 16401
	)
)

(instance fallView of Actor
	(properties
		x 150
		y -35
		view 835
		priority 15
		signal 24592
		illegalBits 0
	)
)

(instance crash of View
	(properties
		x 150
		y 130
		view 837
		signal 1
	)
)

(instance kooky of Actor
	(properties
		x -84
		y 124
		view 835
		loop 1
		priority 15
		signal 16
	)
)

(instance zap of Prop
	(properties
		x 92
		y 135
		view 850
	)
)

(instance lightning of Prop
	(properties
		x 190
		y 15
		view 346
		scaleSignal 1
	)
)

(instance banner of Prop
	(properties
		x 52
		y 108
		view 851
		priority 15
		signal 16
	)
)

(instance act5View of View
	(properties
		x 142
		y 113
		view 852
		priority 15
		signal 16
	)
)

(instance act5Txt of Prop
	(properties
		x 142
		y 113
		view 852
		loop 1
		priority 15
		signal 16
		cycleSpeed 1
	)
)

(instance frontDoors of View
	(properties
		x 17
		y 147
		view 396
		signal 1
	)
)

(instance act6L1 of View
	(properties
		x 147
		y 125
		view 835
		loop 2
		priority 15
		signal 16
	)
)

(instance act6L2 of View
	(properties
		x 147
		y 125
		view 835
		loop 3
		priority 15
		signal 16
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

