;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm033 0
)

(instance rm033 of PQRoom
	(properties
		east -1
		south -1
		west -1
	)

	(method (init)
		(switch gPrevRoomNum
			(37
				(gEgo setLoop: 10 x: 150 y: 147 setStep: 3 2 setCycle: Walk)
			)
			(else
				(gEgo
					setLoop: 7
					x: 118
					y: 144
					cycleSpeed: 7
					moveSpeed: 7
					setStep: 3 1
				)
				(switch gDay
					(2
						(SetFlag 79)
						(ClearFlag 60)
						(proc0_17 10)
					)
					(4
						(SetFlag 84)
						(ClearFlag 60)
						(proc0_17 10)
					)
					(5
						(ClearFlag 60)
						(proc0_17 10)
					)
					(6
						(SetFlag 199)
						(ClearFlag 60)
						(proc0_17 10)
					)
				)
			)
		)
		(gEgo view: 395 cel: 0 init:)
		(if (or (>= global105 18) (<= global105 6))
			(self picture: 34)
		else
			(self picture: 33)
		)
		(gEgo normal: 0)
		(HandsOff)
		(switch gPrevRoomNum
			(37
				(gCurRoom setScript: outHospital)
			)
			(57
				(gLongSong number: 706 loop: -1 play:)
				(gCurRoom setScript: inHospital)
			)
			(else
				(gCurRoom setScript: inHospital)
			)
		)
		(super init:)
		(if (== global134 1)
			(partner init: hide:)
		)
		(gAddToPics add: egosCar eachElementDo: #init doit:)
		(if (not (or (>= global105 18) (<= global105 6)))
			(amerFlag cycleSpeed: 10 setCycle: RandCycle init:)
			(frontFlag cycleSpeed: 10 setCycle: RandCycle init:)
			(backFlag cycleSpeed: 10 setCycle: RandCycle init:)
		)
		(soundFX number: 913 loop: -1 play:)
	)
)

(instance inHospital of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(HandsOff)
				(= seconds 3)
				(ShowClock 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(carOpenSnd play:)
				(= cycles 1)
			)
			(4
				(gEgo ignoreActors: 1 setPri: 11 setCycle: End self)
			)
			(5
				(carCloseSnd play:)
				(if (== global134 1)
					(partner show:)
				)
				(gEgo
					setLoop: 9
					x: 133
					y: 146
					cycleSpeed: (gGame egoMoveSpeed:)
					moveSpeed: (gGame egoMoveSpeed:)
					ignoreActors: 0
					setPri: -1
					setCycle: Walk
					setMotion: PolyPath 165 147 self
				)
			)
			(6
				(if (== global134 1)
					(partner
						setLoop: 12
						setStep: 3 1
						cycleSpeed: (gGame egoMoveSpeed:)
						moveSpeed: (gGame egoMoveSpeed:)
						setMotion: MoveTo 141 (- (partner y:) 15)
						setCycle: End
					)
				)
				(gEgo
					setLoop: 11
					cel: 0
					x: (+ (gEgo x:) 2)
					y: (- (gEgo y:) 20)
					setStep: 3 1
					setMotion: MoveTo 167 119
					setCycle: End self
				)
			)
			(7
				(ShowClock 0)
				(if (== gPrevRoomNum 57)
					(gCurRoom newRoom: 300)
				else
					(gCurRoom newRoom: 37)
				)
			)
		)
	)
)

(instance outHospital of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(HandsOff)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 133 146 self)
				(if (== global134 1)
					(partner loop: 13 cel: 0 show:)
				)
			)
			(3
				(gEgo
					setLoop: 8
					cel: 0
					x: 119
					y: 144
					cycleSpeed: 7
					moveSpeed: 7
					setPri: 11
					setCycle: CT 2 1 self
				)
			)
			(4
				(carOpenSnd play:)
				(= cycles 1)
			)
			(5
				(gEgo setCycle: End self)
				(if (== global134 1)
					(partner hide:)
				)
			)
			(6
				(gEgo normal: 1)
				(carCloseSnd play:)
				(if (OneOf gDay 2 4 5)
					(amerFlag hide:)
					(frontFlag hide:)
					(backFlag hide:)
					(gCurRoom drawPic: 98 6)
					(= global105 22)
					(= global106 0)
					(= cycles 1)
				else
					(if (and (== gDay 6) (not (IsFlag 57)))
						(SetFlag 66)
					)
					(gCurRoom newRoom: 25)
				)
			)
			(7
				(= cycles 1)
			)
			(8
				(if (== global134 1)
					(Print 33 0) ; "You drop your partner off at the station then drive yourself home for some needed rest."
				else
					(Print 33 1) ; "Feeling physically and emotionally drained, you drive home."
				)
				(= cycles 1)
			)
			(9
				(= global105 22)
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance partner of Actor
	(properties
		x 141
		y 142
		view 395
		loop 12
		priority 6
		signal 16
	)
)

(instance amerFlag of Prop
	(properties
		x 255
		y 62
		description {the flag}
		view 395
		loop 5
		detailLevel 2
	)
)

(instance frontFlag of Prop
	(properties
		x 269
		y 58
		description {the flag}
		view 395
		loop 4
		detailLevel 2
	)
)

(instance backFlag of Prop
	(properties
		x 245
		y 70
		description {the flag}
		view 395
		loop 6
		detailLevel 2
	)
)

(instance egosCar of PicView
	(properties
		x 119
		y 144
		description {the car}
		view 395
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 33 2) ; "That's your vehicle."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance carOpenSnd of Sound
	(properties
		number 900
	)
)

(instance carCloseSnd of Sound
	(properties
		number 901
	)
)

