;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 318)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local0 0)
				(Load rsVIEW 90)
				(Load rsVIEW 60)
				(gEgo setMotion: MoveTo 133 110 self)
			)
			(1
				(cockHorse init:)
				(-= global114 300)
				(gEgo view: global114 setMotion: MoveTo 105 145 self)
			)
			(2
				(proc0_7 gEgo cockHorse)
				(= cycles 1)
			)
			(3
				(gLongSong stop:)
				(gMessager say: 1 0 0 10 0 400) ; "BANBURY CROSS"
				(proc0_9)
				(rhymeSync init: 400 1 0 0 10)
				(= cycles 1)
			)
			(4
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				else
					(if gLanguage
						(proc0_16
							(temp0
								format:
									{Montar un caballo macho a Banbury Cross,}
							)
						)
					else
						(proc0_16
							(temp0 format: {Ride a cockhorse to Banbury Cross,})
						)
					)
					(horse
						init:
						ignoreActors: 1
						setPri: 183
						setMotion: PolyPath 129 117
					)
				)
				(= cycles 1)
			)
			(5
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0
								format:
									{Para ver una viejita encima de un caballo blanco,}
							)
						)
					)
					(else
						(proc0_16
							(temp0
								format: {To see a fine lady upon a white horse.}
							)
						)
					)
				)
				(= cycles 1)
			)
			(6
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0 format: {Anillos en sus dedos de las manos,})
						)
					)
					(else
						(proc0_16 (temp0 format: {With rings on her fingers,}))
					)
				)
				(= cycles 1)
			)
			(7
				(horse setLoop: 1 1 cel: 0 cycleSpeed: 6 setCycle: CT 5 1)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(if gLanguage
						(proc0_16
							(temp0
								format: {Y campanas en los dedos de los pies,}
							)
						)
					else
						(proc0_16 (temp0 format: {And bells on her toes,}))
					)
					(if (== (horse cel:) 5)
						(horse cel: 0)
					)
					(horse setCycle: End)
				)
				(= cycles 1)
			)
			(9
				(cond
					((< (rhymeSync prevSignal:) 50)
						(-- state)
					)
					(gLanguage
						(proc0_16
							(temp0
								format:
									{Ella tendr# m*sica dondequiera que vaya.}
							)
						)
					)
					(else
						(proc0_16
							(temp0
								format:
									{She shall have music wherever she goes.}
							)
						)
					)
				)
				(= cycles 1)
			)
			(10
				(cockHorse dispose:)
				(horse
					setLoop: 0 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 231 102 self
				)
			)
			(11
				(horse setMotion: PolyPath 290 96 self)
			)
			(12
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(horse dispose:)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(13
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(= local0 1)
			)
		)
		(temp0 dispose:)
		(if local0
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance horse of Actor
	(properties
		x -34
		y 96
		view 90
		cel 2
		illegalBits 0
		xStep 5
		moveSpeed 9
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCycle: Walk)
	)
)

(instance cockHorse of View
	(properties
		x 134
		y 107
		view 60
	)

	(method (init)
		(super init: &rest)
		(self setPri: 110)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

