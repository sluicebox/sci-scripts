;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40260)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Motion)
(use Actor)
(use System)

(public
	rm40v260 0
)

(local
	local0
	local1
	local2
)

(instance rm40v260 of ShiversRoom
	(properties
		picture 40300
	)

	(method (init)
		(spHourDown init:)
		(spHourUp init:)
		(spMinDown init:)
		(spMinUp init:)
		(vBottom init:)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance spHourDown of ShiversProp
	(properties
		priority 150
		fixPriority 1
		view 40300
	)

	(method (doVerb)
		(self setScript: sPullChain)
	)
)

(instance spHourUp of ShiversProp
	(properties
		priority 150
		fixPriority 1
		view 40300
		loop 1
	)

	(method (doVerb)
		(self setScript: sPullChain)
	)
)

(instance spMinDown of ShiversProp
	(properties
		priority 150
		fixPriority 1
		view 40300
		loop 2
	)

	(method (doVerb)
		(self setScript: sPullChain)
	)
)

(instance spMinUp of ShiversProp
	(properties
		priority 150
		fixPriority 1
		view 40300
		loop 3
	)

	(method (doVerb)
		(self setScript: sPullChain)
	)
)

(instance vBottom of View
	(properties
		priority 250
		fixPriority 1
		view 40300
		loop 4
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40250
	)

	(method (init)
		(self createPoly: 197 142 216 0 263 0 263 143 197 143)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40270
	)

	(method (init)
		(self createPoly: 0 0 49 0 68 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance sPullChain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds interruptChain:)
				(gSounds stop: 14001)
				(gSounds stop: 14007)
				(switch (client loop:)
					(0
						(spHourDown cel: 0)
						(spHourUp cel: (spHourUp lastCel:))
					)
					(1
						(spHourUp cel: 0)
						(spHourDown cel: (spHourDown lastCel:))
					)
					(2
						(spMinDown cel: 0)
						(spMinUp cel: (spMinUp lastCel:))
					)
					(3
						(spMinUp cel: 0)
						(spMinDown cel: (spMinDown lastCel:))
					)
				)
				(FrameOut)
				(= cycles 1)
			)
			(1
				(switch (client loop:)
					(0
						(gSounds stop: 14002)
						(proc951_9 14002)
						(gSounds play: 14002 0 82 0)
						(spHourDown setCycle: End)
						(spHourUp setCycle: Beg self)
					)
					(1
						(gSounds stop: 14011)
						(proc951_9 14011)
						(gSounds play: 14011 0 82 0)
						(spHourUp setCycle: End)
						(spHourDown setCycle: Beg self)
					)
					(2
						(gSounds stop: 14006)
						(proc951_9 14006)
						(gSounds play: 14006 0 82 0)
						(spMinDown setCycle: End)
						(spMinUp setCycle: Beg self)
					)
					(3
						(gSounds stop: 14012)
						(proc951_9 14012)
						(gSounds play: 14012 0 82 0)
						(spMinUp setCycle: End)
						(spMinDown setCycle: Beg self)
					)
				)
			)
			(2
				(whatTimeIsIt doit: (client loop:))
				(= local1 (mod global546 100))
				(= local2 (/ (- global546 local1) 100))
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(cond
					(
						(or
							(== global546 530)
							(== global546 1015)
							(== global546 315)
						)
						(gSounds stop: 14001)
						(proc951_9 14001)
						(gSounds play: 14001 0 82 0)
						(if (IsFlag 39)
							(= local0 (Str format: {(Alarm clock sound)}))
							(gCurRoom drawText: local0 0 18)
							(local0 data: 0 dispose:)
						)
					)
					((== local1 30)
						(gSounds stop: 14007)
						(proc951_9 14007)
						(gSounds play: 14007 0 42 0)
						(if (IsFlag 39)
							(= local0 (Str format: {(Clock chimes once)}))
							(gCurRoom drawText: local0 0 18)
							(local0 data: 0 dispose:)
						)
					)
					((== local1 0)
						(gSounds adjChainVol: 42)
						(switch local2
							(0)
							(1
								(gSounds playChain: 14007 0)
							)
							(2
								(gSounds playChain: 14007 0 14007 0)
							)
							(3
								(gSounds playChain: 14007 0 14007 0 14007 0)
							)
							(4
								(gSounds
									playChain: 14007 0 14007 0 14007 0 14007 0
								)
							)
							(5
								(gSounds
									playChain:
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
								)
							)
							(6
								(gSounds
									playChain:
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
								)
							)
							(7
								(gSounds
									playChain:
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
								)
							)
							(8
								(gSounds
									playChain:
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
								)
							)
							(9
								(gSounds
									playChain:
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
								)
							)
							(10
								(gSounds
									playChain:
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
								)
							)
							(11
								(gSounds
									playChain:
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
								)
							)
							(12
								(gSounds
									playChain:
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
										14007
										0
								)
							)
						)
						(if (IsFlag 39)
							(= local0
								(Str format: {(Clock chimes %d times)} local2)
							)
							(gCurRoom drawText: local0 0 18)
							(local0 data: 0 dispose:)
						)
					)
					((IsFlag 39)
						(gCurRoom eraseText:)
					)
				)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance whatTimeIsIt of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(switch param1
			(0
				(= temp0 500)
			)
			(1
				(= temp0 -500)
			)
			(2
				(= temp0 35)
			)
			(3
				(= temp0 -35)
			)
		)
		(if (< param1 3)
			(= temp3 (mod (= temp1 (+ global546 temp0)) 100))
			(= temp2 (/ (- temp1 temp3) 100))
			(if (>= temp3 60)
				(++ temp2)
				(= temp3 (mod temp3 60))
			)
		else
			(= temp3 (mod global546 100))
			(= temp2 (/ (- global546 temp3) 100))
			(if (or (< (= temp3 (+ (mod global546 100) temp0)) 0) (== temp3 60))
				(if (== (-- temp2) 0)
					(= temp2 12)
				)
				(= temp3 (- 60 (Abs temp3)))
			)
		)
		(if (== (= temp2 (mod temp2 12)) 0)
			(= temp2 12)
		)
		(if
			(and
				(== (= global546 (+ (* temp2 100) temp3)) 530)
				(not (IsFlag 90))
			)
			(SetFlag 90)
			(proc951_15 6750)
		)
	)
)

